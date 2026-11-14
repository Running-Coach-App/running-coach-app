#!/usr/bin/env python3
"""Static HTTP server for the campus debug APK."""

from __future__ import annotations

import argparse
from functools import partial
from http.server import SimpleHTTPRequestHandler, ThreadingHTTPServer
from pathlib import Path


class ApkIndexHandler(SimpleHTTPRequestHandler):
    def do_GET(self) -> None:
        if self.path in {"", "/"}:
            self.send_response(200)
            self.send_header("Content-type", "text/html; charset=utf-8")
            self.end_headers()
            body = """<!DOCTYPE html>
<html lang="en"><head><meta charset="utf-8"><title>Running Coach App</title></head>
<body><h1>Running Coach App</h1>
<p><a href="app-debug.apk">Download app-debug.apk</a></p>
</body></html>"""
            self.wfile.write(body.encode("utf-8"))
            return
        super().do_GET()


def main() -> None:
    parser = argparse.ArgumentParser()
    parser.add_argument("--directory", type=Path, required=True)
    parser.add_argument("--host", default="0.0.0.0")
    parser.add_argument("--port", type=int, default=9000)
    args = parser.parse_args()
    args.directory.mkdir(parents=True, exist_ok=True)
    handler = partial(ApkIndexHandler, directory=str(args.directory.resolve()))
    server = ThreadingHTTPServer((args.host, args.port), handler)
    print(f"serving {args.directory} on {args.host}:{args.port}")
    server.serve_forever()


if __name__ == "__main__":
    main()