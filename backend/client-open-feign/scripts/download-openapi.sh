#!/usr/bin/env bash
set -euo pipefail

TOKEN="$1"
OUT="$2"
URL="$3"

echo "Fetching OpenAPI from: $URL"
HTTP=$(curl -sS -o "$OUT" -w "%{http_code}" \
  -H "Authorization: Bearer $TOKEN" \
  -H "Accept: application/json" \
  -H "X-Requested-With: XMLHttpRequest" \
  "$URL")

echo "HTTP $HTTP"
if [ "$HTTP" != "200" ]; then
  echo "Download failed (HTTP $HTTP)."
  exit 1
fi

if head -c 64 "$OUT" | grep -qi '<!doctype html\|<html'; then
  echo "Got HTML (likely login page)."
  exit 1
fi
