#!/bin/bash
# Pull main and the campus debug APK. The VM runs this on a timer because
# GitHub-hosted runners cannot reach the campus address.
set -euo pipefail
REPO="${1:-/opt/coaching/repo/running-coach-app}"
APK_DIR=/opt/coaching/apk
APK="$APK_DIR/app-debug.apk"
RELEASE_APK="https://github.com/Running-Coach-App/running-coach-app/releases/download/main-debug/app-debug.apk"
FALLBACK_APK="https://github.com/Running-Coach-App/running-coach-app/releases/download/v0.5.0/running-coach-app-v0.5.0-debug.apk"

install -d -m 755 /opt/coaching/{apk,data,repo}
if [ ! -d "$REPO/.git" ]; then
  git clone https://github.com/Running-Coach-App/running-coach-app.git "$REPO"
fi
cd "$REPO"
git fetch origin
git checkout main
git pull --ff-only origin main
bash deploy/vm/install-services.sh "$REPO"

tmp="$(mktemp)"
if curl -fsSL -o "$tmp" "$RELEASE_APK"; then
  mv "$tmp" "$APK"
elif [ ! -s "$APK" ] && curl -fsSL -o "$tmp" "$FALLBACK_APK"; then
  mv "$tmp" "$APK"
else
  rm -f "$tmp"
fi
chmod 644 "$APK" 2>/dev/null || true
systemctl restart coaching-collector coaching-apk