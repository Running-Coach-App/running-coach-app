#!/bin/bash
# Run once on the campus VM as root after cloning the repository.
set -euo pipefail
REPO="${1:-/opt/coaching/repo/running-coach-app}"

install -d -m 755 /opt/coaching/{apk,data,repo}

cat > /etc/systemd/system/coaching-collector.service <<EOF
[Unit]
Description=Running Coach telemetry ingest
After=network.target
[Service]
Type=simple
Environment=COACHING_DATA_DIR=/opt/coaching/data
ExecStart=/usr/bin/python3 ${REPO}/deploy/collector/serve.py --host 0.0.0.0 --port 8080
Restart=on-failure
[Install]
WantedBy=multi-user.target
EOF

cat > /etc/systemd/system/coaching-apk.service <<EOF
[Unit]
Description=Running Coach APK download
After=network.target
[Service]
Type=simple
ExecStart=/usr/bin/python3 ${REPO}/deploy/apk-serve/serve.py --directory /opt/coaching/apk --host 0.0.0.0 --port 9000
Restart=on-failure
[Install]
WantedBy=multi-user.target
EOF

install -m 755 "${REPO}/deploy/vm/update-from-github.sh" /opt/coaching/update-from-github.sh

cat > /etc/systemd/system/coaching-update.service <<EOF
[Unit]
Description=Pull Running Coach main and campus APK
After=network-online.target
Wants=network-online.target
[Service]
Type=oneshot
ExecStart=/bin/bash /opt/coaching/update-from-github.sh ${REPO}
EOF

cat > /etc/systemd/system/coaching-update.timer <<EOF
[Unit]
Description=Pull Running Coach main every ten minutes
[Timer]
OnBootSec=2min
OnUnitActiveSec=10min
Persistent=true
[Install]
WantedBy=timers.target
EOF

systemctl daemon-reload
systemctl enable --now coaching-collector coaching-apk coaching-update.timer