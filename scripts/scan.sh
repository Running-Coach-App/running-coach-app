#!/usr/bin/env bash
#
# Running Coach App security scan.
#
# Anyone can run this from a clean checkout, without installing the Android
# toolchain, and see for themselves whether:
#
#   1. any dependency the app ships has a known vulnerability,
#   2. the app can reach the network at all,
#   3. anything that looks like a credential has been committed.
#
# It is the test for QR-08. The customer asked for a scanner "that I can run
# for myself, and that anyone who wants to install can run", whose point is
# "proof, for open source, that you are not sending data somewhere".
#
#   Usage:  ./scripts/scan.sh
#   Needs:  bash, curl, and python3 (or jq). An Android SDK is NOT needed.
#   Exits:  0 everything passed, 1 a check failed, 2 the scan could not run.
#
# Check 1 prefers osv-scanner when it is on PATH and otherwise queries the same
# database, OSV.dev, over HTTPS, so that a reader needs no install step.

set -uo pipefail

readonly ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
readonly LOCKFILE="$ROOT/app/gradle.lockfile"
readonly MANIFEST="$ROOT/app/src/main/AndroidManifest.xml"
readonly SHIPPING_CONFIGURATION="releaseRuntimeClasspath"

# Permissions that would let the product move a runner's data off the phone.
readonly NETWORK_PERMISSIONS='INTERNET|ACCESS_NETWORK_STATE|ACCESS_WIFI_STATE|CHANGE_NETWORK_STATE|CHANGE_WIFI_STATE|NEARBY_WIFI_DEVICES'

# Types that open a connection. A match is not proof of a leak, but every one
# has to be explained, so the scan stops and asks.
readonly NETWORK_APIS='java\.net\.|javax\.net\.|HttpURLConnection|URLConnection|\.openConnection|okhttp3|retrofit2|com\.squareup\.okhttp|io\.ktor|org\.apache\.http|android\.webkit|WebView|DatagramSocket|ServerSocket|SSLSocket|java\.nio\.channels\.SocketChannel'

failures=0
warnings=0

say() { printf '%s\n' "$*"; }
head2() { printf '\n%s\n%s\n' "$1" "$(printf '%.0s-' $(seq 1 ${#1}))"; }
pass() { printf '  PASS  %s\n' "$*"; }
warn() { printf '  WARN  %s\n' "$*"; warnings=$((warnings + 1)); }
fail() { printf '  FAIL  %s\n' "$*"; failures=$((failures + 1)); }
cannot() { printf '  STOP  %s\n' "$*"; exit 2; }

json() {
	# Reads stdin, runs the python snippet in $1, and forwards any further
	# arguments to the snippet as sys.argv[1:].
	snippet="$1"
	shift
	"$PYTHON" -c "$snippet" "$@" || cannot "the OSV.dev response could not be read. The dependency check did not run."
}

PYTHON=""
for candidate in python3 python; do
	if command -v "$candidate" >/dev/null 2>&1; then
		if "$candidate" -c 'import json,sys' >/dev/null 2>&1; then
			PYTHON="$candidate"
			break
		fi
	fi
done

say "Running Coach App security scan"
say "Repository: $ROOT"
say "Commit:     $(git -C "$ROOT" rev-parse --short HEAD 2>/dev/null || echo 'not a git checkout')"

# ---------------------------------------------------------------------------
# 1. Dependencies with known vulnerabilities.
# ---------------------------------------------------------------------------
head2 "1. Dependencies with known vulnerabilities"

if [ ! -f "$LOCKFILE" ]; then
	cannot "no $LOCKFILE. Run 'gradle :app:dependencies --write-locks' to regenerate it."
fi

if command -v osv-scanner >/dev/null 2>&1; then
	say "  Using osv-scanner $(osv-scanner --version 2>/dev/null | head -1)"
	osv_output="$(osv-scanner scan source --lockfile="$LOCKFILE" 2>&1)"
	osv_status=$?
	case "$osv_status" in
		0) pass "osv-scanner found no known vulnerability in any locked dependency." ;;
		1)
			say "$osv_output"
			fail "osv-scanner reported known vulnerabilities. See the table above."
			;;
		128) cannot "osv-scanner scanned no packages. Is $LOCKFILE empty?" ;;
		*)
			say "$osv_output"
			cannot "osv-scanner exited $osv_status."
			;;
	esac
else
	say "  osv-scanner is not installed; querying OSV.dev directly over HTTPS."
	say "  (Install it from https://google.github.io/osv-scanner/installation/ for the same answer offline.)"

	if [ -z "$PYTHON" ]; then
		cannot "need python3 (or install osv-scanner) to read the OSV.dev response."
	fi
	command -v curl >/dev/null 2>&1 || cannot "need curl."

	request="$(mktemp)"
	response="$(mktemp)"
	trap 'rm -f "$request" "$response"' EXIT

	# shellcheck disable=SC2016
	grep -E '^[A-Za-z][^=]*:[^=]*:[^=]*=' "$LOCKFILE" |
		json '
import json, sys
queries = []
for line in sys.stdin:
    coordinate = line.strip().split("=", 1)[0]
    group_artifact, _, version = coordinate.rpartition(":")
    queries.append({"package": {"name": group_artifact, "ecosystem": "Maven"}, "version": version})
json.dump({"queries": queries}, sys.stdout)
' >"$request"

	http="$(curl -sS -X POST -H 'Content-Type: application/json' \
		--data @"$request" https://api.osv.dev/v1/querybatch \
		-o "$response" -w '%{http_code}' 2>/dev/null)" ||
		cannot "could not reach https://api.osv.dev. Are you offline?"

	[ "$http" = "200" ] || cannot "OSV.dev answered HTTP $http."

	# Pair each advisory with the Gradle configurations the package sits in, so
	# a dependency that ships in the APK is told apart from one that only the
	# build uses. Only the first kind can reach a runner.
	report="$(
		grep -E '^[A-Za-z][^=]*:[^=]*:[^=]*=' "$LOCKFILE" |
			json '
import json, sys

lock = [line.strip() for line in sys.stdin if line.strip()]
results = json.load(open(sys.argv[1], encoding="utf-8")).get("results", [])
shipping, build_only = [], []

for line, result in zip(lock, results):
    coordinate, _, configurations = line.partition("=")
    advisories = sorted({v["id"] for v in (result.get("vulns") or [])})
    if not advisories:
        continue
    row = (coordinate, advisories, configurations.split(","))
    if sys.argv[2] in row[2]:
        shipping.append(row)
    else:
        build_only.append(row)

for coordinate, advisories, _ in shipping:
    print("SHIPPING\t%s\t%s" % (coordinate, ", ".join(advisories)))
for coordinate, advisories, configurations in build_only:
    print("BUILD\t%s\t%s\t%s" % (coordinate, ", ".join(advisories), configurations[0]))
print("COUNTS\t%d\t%d\t%d" % (len(lock), len(shipping), len(build_only)))
' "$response" "$SHIPPING_CONFIGURATION"
	)"

	locked="$(printf '%s\n' "$report" | awk -F'\t' '$1=="COUNTS" {print $2}')"
	n_shipping="$(printf '%s\n' "$report" | awk -F'\t' '$1=="COUNTS" {print $3}')"
	n_build="$(printf '%s\n' "$report" | awk -F'\t' '$1=="COUNTS" {print $4}')"

	# A scan that silently checked nothing must never read as a pass.
	case "${locked:-}" in
		'' | 0) cannot "the dependency check parsed no packages. It did not run; do not read this as a pass." ;;
	esac
	case "${n_shipping:-}${n_build:-}" in
		'') cannot "the dependency check produced no counts. It did not run; do not read this as a pass." ;;
	esac

	say "  Checked $locked locked dependencies against OSV.dev."

	if [ "${n_shipping:-0}" -gt 0 ]; then
		printf '%s\n' "$report" | awk -F'\t' '$1=="SHIPPING" {printf "        %s\n          %s\n", $2, $3}'
		fail "$n_shipping dependency(ies) on $SHIPPING_CONFIGURATION have known advisories. These ship inside the APK."
	else
		pass "no dependency that ships in the APK has a known vulnerability."
	fi

	if [ "${n_build:-0}" -gt 0 ]; then
		printf '%s\n' "$report" | awk -F'\t' '$1=="BUILD" {printf "        %s\n          %s\n          first seen in: %s\n", $2, $3, $4}'
		warn "$n_build build-time dependency(ies) have known advisories. They are not in the APK and cannot reach a runner; they are reported, not failed. See docs/research/play-store-quality.md."
	fi
fi

# ---------------------------------------------------------------------------
# 2. The product cannot reach the network.
# ---------------------------------------------------------------------------
head2 "2. The product cannot send a runner's data anywhere"

if [ ! -f "$MANIFEST" ]; then
	cannot "no $MANIFEST."
fi

declared="$(grep -oE -e "android\.permission\.($NETWORK_PERMISSIONS)" "$MANIFEST" || true)"
if [ -n "$declared" ]; then
	printf '        %s\n' $declared
	fail "the manifest declares a network permission. The product could send data off the phone."
else
	pass "the manifest declares no network permission (checked: $(printf '%s' "$NETWORK_PERMISSIONS" | tr '|' ' '))."
fi

api_hits="$(grep -rnE -e "$NETWORK_APIS" "$ROOT/app/src" 2>/dev/null || true)"
if [ -n "$api_hits" ]; then
	printf '%s\n' "$api_hits" | sed 's|^|        |'
	fail "source code references a networking type. Each hit above must be explained or removed."
else
	pass "no source file references a networking type."
fi

# The APK is the artifact a runner installs, so check it too when one is built.
apk="$(find "$ROOT/app/build/outputs/apk" -name '*.apk' -print 2>/dev/null | head -1)"
if [ -z "$apk" ]; then
	say "  (No built APK found, so the shipped manifest was not checked. Build one with"
	say "   'gradle :app:assembleDebug' and run this again to include it.)"
else
	aapt2="$(command -v aapt2 || true)"
	if [ -z "$aapt2" ]; then
		for sdk in "${ANDROID_HOME:-}" "${ANDROID_SDK_ROOT:-}" "$HOME/Android/Sdk" "$HOME/Library/Android/sdk" "$LOCALAPPDATA/Android/Sdk" "$HOME/AppData/Local/Android/Sdk"; do
			[ -n "$sdk" ] && [ -d "$sdk/build-tools" ] || continue
			aapt2="$(find "$sdk/build-tools" -name 'aapt2' -o -name 'aapt2.exe' 2>/dev/null | sort -r | head -1)"
			[ -n "$aapt2" ] && break
		done
	fi
	if [ -z "$aapt2" ]; then
		say "  (aapt2 not found, so the built APK's manifest was not checked.)"
	else
		apk_permissions="$("$aapt2" dump badging "$apk" 2>/dev/null | grep -oE -e "android\.permission\.($NETWORK_PERMISSIONS)" || true)"
		if [ -n "$apk_permissions" ]; then
			printf '        %s\n' $apk_permissions
			fail "the built APK declares a network permission: $(basename "$apk")."
		else
			pass "the built APK declares no network permission ($(basename "$apk"))."
		fi
	fi
fi

# ---------------------------------------------------------------------------
# 3. Nothing that looks like a credential is committed.
# ---------------------------------------------------------------------------
head2 "3. No committed credentials"

secret_patterns='-----BEGIN [A-Z ]*PRIVATE KEY-----|ghp_[A-Za-z0-9]{36}|github_pat_[A-Za-z0-9_]{22,}|AKIA[0-9A-Z]{16}|AIza[0-9A-Za-z_-]{35}|xox[baprs]-[0-9A-Za-z-]{10,}|-----BEGIN OPENSSH PRIVATE KEY-----'

tracked_secrets=""
while IFS= read -r file; do
	[ -f "$ROOT/$file" ] || continue
	case "$file" in
		scripts/scan.sh) continue ;;  # this file names the patterns it looks for
	esac
	if hit="$(grep -nEI -e "$secret_patterns" "$ROOT/$file" 2>/dev/null)"; then
		tracked_secrets="$tracked_secrets$file: $hit"$'\n'
	fi
done <<EOF
$(git -C "$ROOT" ls-files 2>/dev/null)
EOF

if [ -n "$tracked_secrets" ]; then
	printf '%s' "$tracked_secrets" | sed 's|^|        |'
	fail "a committed file matches a credential pattern."
else
	pass "no tracked file matches a private key, token, or API key pattern."
fi

# local.properties holds the SDK path of whoever built the app and must stay out.
if git -C "$ROOT" ls-files --error-unmatch local.properties >/dev/null 2>&1; then
	fail "local.properties is tracked. It carries a local SDK path and must stay untracked."
else
	pass "local.properties is not tracked."
fi

if [ -f "$ROOT/app/build.gradle.kts" ] && grep -qE 'storePassword|keyPassword|keyAlias' "$ROOT/app/build.gradle.kts"; then
	warn "app/build.gradle.kts mentions signing credentials. Check they are read from the environment, not written in the file."
else
	pass "no signing credential is written into the build file."
fi

# ---------------------------------------------------------------------------
head2 "Result"

say "  $warnings warning(s), $failures failure(s)."
if [ "$failures" -gt 0 ]; then
	say "  FAILED"
	exit 1
fi
say "  PASSED"
exit 0
