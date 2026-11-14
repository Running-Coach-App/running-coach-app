#!/usr/bin/env python3
"""Append-only ingest for sanitized JSON Lines (events and diagnostics)."""

from __future__ import annotations

import argparse
import os
from http.server import BaseHTTPRequestHandler, HTTPServer
from pathlib import Path
import time


class Handler(BaseHTTPRequestHandler):
    data_dir = Path("/opt/coaching/data")

    def do_POST(self) -> None:
        if not self.path.startswith("/ingest"):
            self.send_error(404)
            return
        length = int(self.headers.get("Content-Length", "0"))
        body = self.rfile.read(length).decode("utf-8", errors="replace")
        kind = "misc"
        if "kind=events" in self.path:
            kind = "events"
        elif "kind=diagnostics" in self.path:
            kind = "diagnostics"
        Handler.data_dir.mkdir(parents=True, exist_ok=True)
        stamp = int(time.time() * 1000)
        path = Handler.data_dir / f"{kind}-{stamp}.jsonl"
        path.write_text(body, encoding="utf-8")
        self.send_response(204)
        self.end_headers()

    def log_message(self, format: str, *args) -> None:
        return


def main() -> None:
    parser = argparse.ArgumentParser()
    parser.add_argument("--host", default="0.0.0.0")
    parser.add_argument("--port", type=int, default=8080)
    parser.add_argument("--data-dir", default=os.environ.get("COACHING_DATA_DIR", "/opt/coaching/data"))
    args = parser.parse_args()
    Handler.data_dir = Path(args.data_dir)
    server = HTTPServer((args.host, args.port), Handler)
    print(f"ingest listening on {args.host}:{args.port} -> {Handler.data_dir}")
    server.serve_forever()


if __name__ == "__main__":
    main()