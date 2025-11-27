#!/usr/bin/env bash
set -euo pipefail

# Args
KEYCLOAK_TOKEN_FILE="${1:?openapi-auth.properties path (to read access.token)}"
CONSUL_URL_RAW="${2:?https://consul...}"
GATEWAY_URL_RAW="${3:?https://apigateway...}"
OPENAPI_DIR="${4:?target/openapi}"
SERVICE_NAME_PATTERN="${5:-.*}"  # regex; default all
FETCH_MODE="${6:-gateway}"       # "gateway" or "direct"

# --- normalize CRLF from args (important on Windows/Git Bash) ---
CONSUL_URL="$(printf %s "$CONSUL_URL_RAW" | tr -d '\r')"
GATEWAY_URL="$(printf %s "$GATEWAY_URL_RAW" | tr -d '\r')"

mkdir -p "$OPENAPI_DIR"

# Read token saved by properties-maven-plugin (strip CR)
ACCESS_TOKEN="$(grep '^access.token=' "$KEYCLOAK_TOKEN_FILE" | cut -d'=' -f2- | tr -d '\r')"

# Requires jq
if ! command -v jq >/dev/null 2>&1; then
  echo "ERROR: jq is required." >&2
  exit 1
fi

echo "==> Fetching service list from Consul..."
SERVICES_JSON="$(curl -fsSL -H "Authorization: Bearer $ACCESS_TOKEN" "$CONSUL_URL/v1/catalog/services")"

# List services, CRLF-safe read
jq -r 'keys[]' <<<"$SERVICES_JSON" | while IFS= read -r SVC; do
  # strip any stray CR from service name
  SVC="${SVC//$'\r'/}"

  [[ "$SVC" =~ $SERVICE_NAME_PATTERN ]] || continue
  echo " -> Found service: $SVC"

  OPENAPI_URL=""
  if [[ "$FETCH_MODE" == "gateway" ]]; then
    # Through gateway service proxy
    # If your springdoc exposes group path, keep this.
    # Otherwise uncomment the query param form:
    # OPENAPI_URL="$GATEWAY_URL/services/$SVC/v3/api-docs?group=springdocDefault"
    OPENAPI_URL="$GATEWAY_URL/services/$SVC/v3/api-docs/springdocDefault"
  else
    # Directly from instance(s)
    SVC_NODES_JSON="$(curl -fsSL -H "Authorization: Bearer $ACCESS_TOKEN" "$CONSUL_URL/v1/catalog/service/$SVC")"
    ADDR="$(jq -r '.[0].ServiceAddress // .[0].Address // empty' <<<"$SVC_NODES_JSON" | tr -d '\r')"
    PORT="$(jq -r '.[0].ServicePort // empty' <<<"$SVC_NODES_JSON" | tr -d '\r')"

    if [[ -z "$ADDR" || -z "$PORT" ]]; then
      echo "    WARN: no address/port for $SVC; skipping"
      continue
    fi

    OPENAPI_URL="http://$ADDR:$PORT/v3/api-docs"
    # or: OPENAPI_URL="http://$ADDR:$PORT/v3/api-docs/springdocDefault"
  fi

  OUT="$OPENAPI_DIR/$SVC.json"
  echo "    Downloading OpenAPI: $OPENAPI_URL -> $OUT"

  # Quote URL and follow redirects; show error on HTTP failures
  if ! curl -fSL -H "Authorization: Bearer $ACCESS_TOKEN" "$OPENAPI_URL" -o "$OUT"; then
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
done

echo "==> Done."
