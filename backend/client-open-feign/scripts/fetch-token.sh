#!/usr/bin/env bash
set -euo pipefail

TOKEN_URL="${1:?Token URL missing}"
CLIENT_ID="${2:?Client ID missing}"
USERNAME="${3:?Username missing}"
PASSWORD="${4:?Password missing}"
OUT_FILE="${5:?Output file missing}"

# Optional: show where we're posting (uncomment for debugging)
# echo "Posting to: $TOKEN_URL" >&2

# Request an access token (Resource Owner Password Credentials)
JSON="$(curl -sS --fail-with-body -X POST "$TOKEN_URL" \
  -H "Content-Type: application/x-www-form-urlencoded" \
  --data-urlencode "grant_type=password" \
  --data-urlencode "client_id=${CLIENT_ID}" \
  --data-urlencode "username=${USERNAME}" \
  --data-urlencode "password=${PASSWORD}")"

# Extract access_token (jq required)
ACCESS_TOKEN="$(printf '%s' "$JSON" | jq -r '.access_token')"

if [[ -z "${ACCESS_TOKEN:-}" || "${ACCESS_TOKEN}" == "null" ]]; then
  echo "Failed to obtain access_token. Response:" >&2
  echo "$JSON" >&2
  exit 1
fi

mkdir -p "$(dirname "$OUT_FILE")"
printf 'access.token=%s\n' "$ACCESS_TOKEN" > "$OUT_FILE"
echo "Wrote token to $OUT_FILE"
