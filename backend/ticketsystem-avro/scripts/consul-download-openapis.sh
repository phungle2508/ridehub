#!/usr/bin/env bash
set -euo pipefail

# Args
KEYCLOAK_TOKEN_FILE="${1:?openapi-auth.properties path (to read access.token)}"
CONSUL_URL="${2:?https://consul...}"
GATEWAY_URL="${3:?https://gateway...}"
OPENAPI_DIR="${4:?target/openapi}"
SERVICE_NAME_PATTERN="${5:-.*}"  # regex; default all
FETCH_MODE="${6:-gateway}"       # "gateway" or "direct"

mkdir -p "$OPENAPI_DIR"

# Read token saved by properties-maven-plugin
ACCESS_TOKEN="$(grep '^access.token=' "$KEYCLOAK_TOKEN_FILE" | cut -d'=' -f2-)"

# Requires jq
if ! command -v jq >/dev/null 2>&1; then
  echo "ERROR: jq is required." >&2
  exit 1
fi

echo "==> Fetching service list from Consul..."
SERVICES_JSON="$(curl -fsSL \
  -H "Authorization: Bearer $ACCESS_TOKEN" \
  "$CONSUL_URL/v1/catalog/services")"

# SERVICES is a set of names (keys)
echo "$SERVICES_JSON" | jq -r 'keys[]' | while read -r SVC; do
  if [[ "$SVC" =~ $SERVICE_NAME_PATTERN ]]; then
    echo " -> Found service: $SVC"

    OPENAPI_URL=""
    if [[ "$FETCH_MODE" == "gateway" ]]; then
      # Through gateway service proxy
      # Adjust path if your gateway exposes different prefix
      OPENAPI_URL="$GATEWAY_URL/services/$SVC/v3/api-docs/springdocDefault"
    else
      # Directly from instance(s): pick the first passing node
      SVC_NODES_JSON="$(curl -fsSL \
        -H "Authorization: Bearer $ACCESS_TOKEN" \
        "$CONSUL_URL/v1/catalog/service/$SVC")"

      # pick address+port (ServiceAddress may be empty -> fallback to Address)
      ADDR="$(echo "$SVC_NODES_JSON" | jq -r '.[0].ServiceAddress // .[0].Address // empty')"
      PORT="$(echo "$SVC_NODES_JSON" | jq -r '.[0].ServicePort // empty')"

      if [[ -z "$ADDR" || -z "$PORT" ]]; then
        echo "    WARN: no address/port for $SVC; skipping"
        continue
      fi

      # If your services are TLS terminated, switch to https
      OPENAPI_URL="http://$ADDR:$PORT/v3/api-docs"
      # or: OPENAPI_URL="http://$ADDR:$PORT/v3/api-docs/springdocDefault"
    fi

    OUT="$OPENAPI_DIR/$SVC.json"
    echo "    Downloading OpenAPI: $OPENAPI_URL -> $OUT"
    if ! curl -fsSL -H "Authorization: Bearer $ACCESS_TOKEN" "$OPENAPI_URL" -o "$OUT"; then
      echo "    WARN: failed to download spec for $SVC"
      rm -f "$OUT" || true
      continue
    fi

    # quick sanity: ensure JSON has openapi field
    if ! jq -e '.openapi // .swagger' "$OUT" >/dev/null 2>&1; then
      echo "    WARN: $OUT is not a valid OpenAPI file; removing"
      rm -f "$OUT" || true
      continue
    fi
  fi
done

echo "==> Done."
