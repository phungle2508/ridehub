#!/usr/bin/env bash
set -euo pipefail

OPENAPI_DIR="${1:-target/openapi}"
OUT_ROOT="${2:-src/main/java}"
GEN_VER="${3:-7.14.0}"
VALIDATE="${4:-false}"

mkdir -p "$OUT_ROOT"

TOOLS_DIR="$(dirname "$OUT_ROOT")/tools"
CLI_JAR="$TOOLS_DIR/openapi-generator-cli-${GEN_VER}.jar"
LOG_DIR="$(dirname "$OUT_ROOT")/openapi-gen-logs"
SRC_FOLDER=""

mkdir -p "$TOOLS_DIR" "$LOG_DIR"

# Require java & curl
for bin in java curl; do
  command -v "$bin" >/dev/null 2>&1 || { echo "ERROR: $bin is required."; exit 1; }
done

# Download CLI if missing
if [ ! -f "$CLI_JAR" ]; then
  echo "==> Downloading openapi-generator-cli ${GEN_VER}"
  curl -fsSL -o "$CLI_JAR" \
    "https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/${GEN_VER}/openapi-generator-cli-${GEN_VER}.jar"
fi

# Create a temporary directory with Unix-style paths
TEMP_SPECS_DIR="$(mktemp -d)"
trap "rm -rf '$TEMP_SPECS_DIR'" EXIT

shopt -s nullglob
ORIGINAL_SPECS=("$OPENAPI_DIR"/*.json "$OPENAPI_DIR"/*.yaml "$OPENAPI_DIR"/*.yml)

if [ ${#ORIGINAL_SPECS[@]} -eq 0 ]; then
  echo "No OpenAPI specs found in ${OPENAPI_DIR}"
  exit 0
fi

# Copy specs to temp directory to avoid Windows path issues
echo "==> Copying specs to temporary directory to avoid path issues"
for spec in "${ORIGINAL_SPECS[@]}"; do
  cp "$spec" "$TEMP_SPECS_DIR/"
done

SPECS=("$TEMP_SPECS_DIR"/*.json "$TEMP_SPECS_DIR"/*.yaml "$TEMP_SPECS_DIR"/*.yml)

OK=0
FAIL=0
FAILED_LIST=()

for SPEC in "${SPECS[@]}"; do
  # Service name from file name
  SVC="$(basename "$SPEC")"
  SVC="${SVC%.*}"
  
  # Safe package fragments
  SVC_PKG="$(echo "$SVC" | tr '[:upper:]' '[:lower:]' | sed 's/[^a-z0-9]/_/g')"
  API_SUFFIX="$(echo "$SVC" | sed -E 's/[^A-Za-z0-9]+//g' | sed -E 's/^([a-z])/\U\1/')Api"
  
  OUT_DIR="$OUT_ROOT"
  LOG_FILE="$LOG_DIR/${SVC}.log"
  
  echo "==> Generating Feign client for ${SVC}"
  echo "    Spec: ${SPEC}"
  
  # Clean only this service's generated client package
  rm -rf "${OUT_DIR}/com/ridehub/${SVC_PKG}/client" || true
  
  # Set JVM system properties to disable validation and avoid path issues
  JAVA_OPTS="-Duser.timezone=UTC -Dfile.encoding=UTF-8"
  
  if JAVA_OPTS="$JAVA_OPTS" java -jar "$CLI_JAR" generate \
      -g java \
      --library feign \
      -i "$SPEC" \
      -o "$OUT_DIR" \
      -p sourceFolder="${SRC_FOLDER}" \
      -p apiPackage="com.ridehub.${SVC_PKG}.client.api" \
      -p modelPackage="com.ridehub.${SVC_PKG}.client.model" \
      -p invokerPackage="com.ridehub.${SVC_PKG}.client.invoker" \
      --additional-properties useJakartaEe=true,dateLibrary=java8,interfaceOnly=true,useTags=true,hideGenerationTimestamp=true,apiNameSuffix="${API_SUFFIX}",useBeanValidation=true,performBeanValidation=true,useOptional=true,generateParameterObjects=true,aggregateParameters=true,paramNamingStrategy=camelCase,groupByTags=true,useSpringBoot3=true,serializableModel=true \
      --global-property models,apis,supportingFiles,modelTests=false,apiTests=false,modelDocs=false,apiDocs=false \
      --skip-validate-spec \
      --enable-post-process-file \
      >"$LOG_FILE" 2>&1; then
    
    # Remove generator extras
    ROOT_OF_SRC="$(dirname "$OUT_DIR")"
    rm -rf "${ROOT_OF_SRC}/test" \
           "${ROOT_OF_SRC}/docs" \
           "${ROOT_OF_SRC}/pom.xml" \
           "${ROOT_OF_SRC}/build.gradle" \
           "${ROOT_OF_SRC}/README.md" \
           "${ROOT_OF_SRC}/.openapi-generator" \
           "${ROOT_OF_SRC}/.openapi-generator-ignore" 2>/dev/null || true
    
    echo "   OK: ${SVC} (logs: ${LOG_FILE})"
    OK=$((OK+1))
  else
    echo " FAIL: ${SVC} (see ${LOG_FILE})"
    FAIL=$((FAIL+1))
    FAILED_LIST+=("$SVC")
  fi
done

echo
echo "==> Generation summary: OK=${OK} / FAIL=${FAIL}"
if [ "$FAIL" -gt 0 ]; then
  printf 'Failed services: %s\n' "${FAILED_LIST[*]}"
  echo "Check logs under: ${LOG_DIR}"
fi