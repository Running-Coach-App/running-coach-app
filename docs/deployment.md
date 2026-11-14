# Deployment

How a teammate on the university network deploys the Running Coach App once the team VM exists. Build and run steps stay in [`docs/setup.md`](setup.md). This page does not repeat them.

The university VM was not obtained in time for the Week 5 meeting, so staging and production were not deployed. The runbook below is what the deploy uses when the VM is available. Real host addresses, ports, and passwords stay out of the repository; they go in the Moodle submission and in a `.env` on the campus machine.

## Environments

| Environment | Where it runs | What it is for |
| --- | --- | --- |
| Development | A teammate's machine, with a phone or an emulator | Changing the product and running it from [`docs/setup.md`](setup.md) |
| Integration | GitHub Actions on pull requests and on `main` | Checks and scans on every pull request. A push to `main` also runs `.github/workflows/deploy-campus.yml` when campus secrets are set |
| Staging | The university VM, a separate port from production | The release candidate APK, served for install and for a `deployed` quality-requirement test |
| Production | The university VM, a second port | The same commit as staging, served for the `Customer` to install from the university network. There is no domain name |

Staging and production are two deployments of the same Android APK, not two running copies of a server process. Each has its own directory, its own port, and its own `.env` values.

## Campus access

The VM is reached over SSH from a machine on the university network. At least one member of the team is on campus for a deploy.

Connect with the host and user from `.env`. Do not commit those values.

```text
ssh "$VM_USER@$VM_HOST"
```

Recreate the VM from the university portal, set its password there, and keep that password out of the repository.

## Configuration

The shape of the configuration is [`.env.example`](https://github.com/Running-Coach-App/running-coach-app/blob/main/.env.example). Copy it to `.env` on the campus machine and fill the placeholders. `.env` is ignored.

Use `$STAGING_URL` and `$PRODUCTION_URL` wherever a command would need an address. Do not paste a real IPv4 address into this page, into a workflow, or into a quality-requirement test.

The Android SDK path stays in `local.properties` on the machine that builds, as [`docs/setup.md`](setup.md) already says.

## Automatic deploy on `main`

When repository secrets `CAMPUS_VM_HOST`, `CAMPUS_VM_USER`, and `CAMPUS_VM_SSH_KEY` are set, each push to `main` runs `.github/workflows/deploy-campus.yml`. That workflow builds and tests the debug APK, copies it to `/opt/coaching/apk/` on the VM, pulls `main` under `/opt/coaching/repo/running-coach-app`, reinstalls systemd units from `deploy/vm/install-services.sh`, and restarts the services.

| Secret | Purpose |
| --- | --- |
| `CAMPUS_VM_HOST` | Campus IPv4, for SSH and for URLs baked into the APK at build time |
| `CAMPUS_VM_USER` | SSH user, usually `root` |
| `CAMPUS_VM_SSH_KEY` | Private key GitHub Actions uses to `scp` and `ssh` |

First-time VM setup: clone the repository, run `bash deploy/vm/install-services.sh`, and put the deploy public key in `authorized_keys`. Do not commit hostnames or keys.

**Download page (campus network):** `$SCHEME://$HOST:9000/` serves `app-debug.apk`.

**Ingest (port 8080):** posts from the app land as `events-*.jsonl` and `diagnostics-*.jsonl` under `/opt/coaching/data/`. No database: append-only files.

GitHub-hosted runners may not reach a campus-only address. If deploy steps time out, run the same `scp` and `git pull` from a machine on the university network, or ask the TA about runner reachability.

## Manual deploy

Use when campus secrets are not set, or CI cannot reach the VM.

1. On a machine that can build, check out the release-candidate commit and assemble the debug APK as [`docs/setup.md`](setup.md) describes.
2. Copy `app/build/outputs/apk/debug/app-debug.apk` to the staging directory on the VM.
3. Serve that directory on the staging port from `.env`. Keep the previous APK beside it as `app-debug.apk.previous`.
4. Verify staging, below.
5. Copy the same APK, from the same commit, to the production directory, and serve it on the production port.
6. Verify production, below.

The `Customer` installs from `$PRODUCTION_URL` on the university network. He does not receive an APK over Telegram, per [`DEC-021`](decisions.md#dec-021).

## Verification

After each production deploy, and after staging before promoting, install the APK from that environment's URL onto a phone or emulator on the university network, then run the core task:

1. Start an interval session.
2. Hear "Session started."
3. Confirm time is visible on the run screen.
4. Stop the session and hear "Session stopped."

If any of those fail, roll back. Do not leave production on a commit that failed this check.

## Rollback

Replace the current APK with `app-debug.apk.previous` in that environment's directory, serve it again, and repeat the verification. If the previous file is missing, check out the last known good tag, assemble it from [`docs/setup.md`](setup.md), and copy that APK up instead.

Record the commit that production finally runs with the release. A run on an earlier commit is not the released state's run.

## Telemetry

The VM runs `deploy/collector/serve.py` on port 8080. With usage data on ([`DEC-030`](decisions.md#dec-030)), the debug APK POSTs new lines from `events.jsonl` and `diagnostics.jsonl` when `collector.url` is set at build time ([`DEC-031`](decisions.md#dec-031)). Inspect uploads with `ls /opt/coaching/data/` on the VM.

[`docs/analytics.md`](analytics.md) and [`docs/observability.md`](observability.md) describe the on-device shapes.
