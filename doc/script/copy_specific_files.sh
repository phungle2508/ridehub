#!/bin/bash
set -euo pipefail

# =========================================
# Central port / DB mappings (edit here)
# =========================================
declare -A SERVER_PORTS=(
  [ms_user]=8083
  [ms_booking]=8084
  [ms_payment]=8085
  [ms_notification]=8086
)
declare -A SQL_PORTS=(
  [ms_user]=3308
  [ms_booking]=3309
  [ms_payment]=3310
  [ms_notification]=3311
)

# =========================================
# Dynamic Source Directory Selection
# =========================================
readonly RED='\033[0;31m' GREEN='\033[0;32m' YELLOW='\033[1;33m' NC='\033[0m'

# Function to determine source directory
get_source_directory() {
    local src_dir=""
    
    # Method 1: Command line argument
    if [[ $# -gt 0 ]]; then
        src_dir="$1"
        echo -e "${GREEN}Using source directory from argument: $src_dir${NC}" >&2
    
    # Method 2: Environment variable
    elif [[ -n "${SOURCE_SERVICE:-}" ]]; then
        src_dir="backend/$SOURCE_SERVICE"
        echo -e "${GREEN}Using source directory from environment: $src_dir${NC}" >&2
    
    # Method 3: Interactive selection
    elif [[ -t 0 ]]; then  # Check if running interactively
        echo -e "${YELLOW}Available microservices:${NC}" >&2
        local services=()
        while IFS= read -r -d '' dir; do
            services+=("${dir##*/}")
        done < <(find backend -maxdepth 1 -type d -name 'ms_*' -print0 2>/dev/null | sort -z)
        
        if [[ ${#services[@]} -eq 0 ]]; then
            echo -e "${RED}No microservices found in backend/ directory${NC}" >&2
            exit 1
        fi
        
        for i in "${!services[@]}"; do
            echo "  $((i+1)). ${services[$i]}" >&2
        done
        
        while true; do
            read -p "Select source service (1-${#services[@]}): " choice
            if [[ "$choice" =~ ^[0-9]+$ ]] && [[ $choice -ge 1 ]] && [[ $choice -le ${#services[@]} ]]; then
                src_dir="backend/${services[$((choice-1))]}"
                echo -e "${GREEN}Selected: $src_dir${NC}" >&2
                break
            else
                echo -e "${RED}Invalid choice. Please enter a number between 1 and ${#services[@]}${NC}" >&2
            fi
        done
    
    # Method 4: Auto-detect (find service with most recent changes)
    else
        echo -e "${YELLOW}Auto-detecting most recently modified service...${NC}" >&2
        src_dir=$(find backend -maxdepth 1 -type d -name 'ms_*' -printf "%T@ %p\n" 2>/dev/null | sort -n | tail -1 | cut -d' ' -f2-)
        if [[ -n "$src_dir" ]]; then
            echo -e "${GREEN}Auto-selected most recent: $src_dir${NC}" >&2
        else
            echo -e "${RED}No microservices found for auto-detection${NC}" >&2
            exit 1
        fi
    fi
    
    # Validate source directory exists
    if [[ ! -d "$src_dir" ]]; then
        echo -e "${RED}Error: Source directory '$src_dir' not found!${NC}" >&2
        exit 1
    fi
    
    echo "$src_dir"
}

# =========================================
# Copy from source -> every backend/ms_* (except source)
# Replace: <source>/<Source>/<SOURCE> -> <svc>/<Svc>/<SVC>
# Only copy: application-dev.yml, bootstrap.yml from resources/config
# =========================================

# Extract service name from source directory
get_source_service_name() {
    local src_dir="$1"
    basename "$src_dir" | sed 's/^ms_//'
}

# ---------- Helpers ----------
transform_token() {
    local token="$1" case="$2"
    case "$case" in
        lower) echo "${token,,}" ;;
        upper) echo "${token^^}" ;;
        title) echo "${token^}" ;;
        *) echo "$token" ;;
    esac
}

copy_and_replace_file() {
    local -r src_file="$1" dest_file="$2" from="$3" to="$4"
    [[ -f "$src_file" ]] || { echo -e "${RED}  Warning: Source file not found: $src_file${NC}" >&2; return 1; }
    echo "  Copying: $src_file -> $dest_file"
    mkdir -p "$(dirname "$dest_file")"
    sed -e "s/${from}/${to}/g" \
        -e "s/${from^}/${to^}/g" \
        -e "s/${from^^}/${to^^}/g" \
        "$src_file" > "$dest_file"
}

# Optional copy: skip (no error) if source file missing
optional_copy_and_replace_file() {
    local -r src_file="$1" dest_file="$2" from="$3" to="$4"
    if [[ -f "$src_file" ]]; then
        copy_and_replace_file "$src_file" "$dest_file" "$from" "$to"
    else
        echo -e "${YELLOW}  Skip (not found): $src_file${NC}"
        return 0
    fi
}

copy_and_replace_dir() {
    local -r src_dir="$1" dest_dir="$2" from="$3" to="$4"
    [[ -d "$src_dir" ]] || { echo -e "${RED}  Warning: Source directory not found: $src_dir${NC}" >&2; return 1; }
    echo "  Copying directory: $src_dir -> $dest_dir"

    if [[ "$src_dir" == */src/main/resources/config* ]]; then
        find "$src_dir" -type d -name liquibase -prune -o -type f -print0 \
        | while IFS= read -r -d '' file; do
            local rel_path="${file#$src_dir/}"
            local new_rel_path="$rel_path"
            new_rel_path="${new_rel_path//$from/$to}"
            new_rel_path="${new_rel_path//${from^}/${to^}}"
            new_rel_path="${new_rel_path//${from^^}/${to^^}}"
            local dest_file="$dest_dir/$new_rel_path"
            mkdir -p "$(dirname "$dest_file")"
            sed -e "s/$from/$to/g" \
                -e "s/${from^}/${to^}/g" \
                -e "s/${from^^}/${to^^}/g" \
                "$file" > "$dest_file"
        done
    else
        find "$src_dir" -type f -print0 \
        | while IFS= read -r -d '' file; do
            local rel_path="${file#$src_dir/}"
            local new_rel_path="$rel_path"
            new_rel_path="${new_rel_path//$from/$to}"
            new_rel_path="${new_rel_path//${from^}/${to^}}"
            new_rel_path="${new_rel_path//${from^^}/${to^^}}"
            local dest_file="$dest_dir/$new_rel_path"
            mkdir -p "$(dirname "$dest_file")"
            sed -e "s/$from/$to/g" \
                -e "s/${from^}/${to^}/g" \
                -e "s/${from^^}/${to^^}/g" \
                "$file" > "$dest_file"
        done
    fi
}

copy_kafka_resource() {
    local -r src_dir="$1" dest_dir="$2" source_token="$3" target_token="$4"
    local -r target_title="${target_token^}"
    local -r source_title="${source_token^}"
    echo "  Copying Ms*KafkaResource.java..."
    shopt -s nullglob
    local kafka_files=("${src_dir}"/src/main/java/com/ticketsystem/${source_token}/web/rest/Ms*KafkaResource.java)
    shopt -u nullglob
    if [[ ${#kafka_files[@]} -eq 0 ]]; then
        echo -e "${RED}  Warning: No Ms*KafkaResource.java found${NC}" >&2
        return 1
    fi
    for src_file in "${kafka_files[@]}"; do
        local base_name="${src_file##*/}"
        local dest_name="${base_name//${source_title}/${target_title}}"
        local dest_file="${dest_dir}/src/main/java/com/ticketsystem/${target_token}/web/rest/${dest_name}"
        copy_and_replace_file "$src_file" "$dest_file" "$source_token" "$target_token"
    done
}

# Only change the package line for FeignClientConfiguration.java
copy_feign_config_package_only() {
    local -r src_file="$1" dest_file="$2" _from="$3" to="$4"
    [[ -f "$src_file" ]] || { echo -e "${RED}  Warning: Source file not found: $src_file${NC}" >&2; return 1; }
    echo "  Copying (package-only): $src_file -> $dest_file"
    mkdir -p "$(dirname "$dest_file")"
    sed -E 's|^([[:space:]]*package[[:space:]]+com\.ticketsystem\.)[^.]+(\.[^;]*;)|\1'"$to"'\2|' \
        "$src_file" > "$dest_file"
}

default_server_port() {
  local svc="$1"
  echo "${SERVER_PORTS[$svc]:-8080}"
}
default_sql_port() {
  local svc="$1"
  echo "${SQL_PORTS[$svc]:-3306}"
}
default_db_name() {
  local svc="$1"
  echo "${svc#ms_}"
}

# In-place patch (replace/insert) — keeps other content
patch_application_dev_yml() {
    local -r dest_dir="$1"
    local -r target_svc="${dest_dir##*/}"
    local -r appyml="${dest_dir}/src/main/resources/config/application-dev.yml"

    local port dbport dbname
    port="$(default_server_port "$target_svc")"
    dbport="$(default_sql_port "$target_svc")"
    dbname="$(default_db_name "$target_svc")"

    mkdir -p "$(dirname "$appyml")"
    [[ -f "$appyml" ]] || touch "$appyml"

    # Ensure top-level "server:" exists
    if ! grep -qE '^[[:space:]]*server:[[:space:]]*$' "$appyml"; then
        printf "\nserver:\n" >> "$appyml"
    fi

    replace_or_insert() {
        local key="$1" val="$2"
        if grep -qE "^[[:space:]]*$key[[:space:]]*:" "$appyml"; then
            sed -i -E "0,/^[[:space:]]*$key[[:space:]]*:.*$/s//  $key: $val/" "$appyml"
        else
            awk -v k="$key" -v v="$val" '
                BEGIN{ins=0}
                {print}
                ins==0 && $0 ~ /^[[:space:]]*server:[[:space:]]*$/ {
                    print "  " k ": " v
                    ins=1
                }
            ' "$appyml" > "${appyml}.tmp" && mv "${appyml}.tmp" "$appyml"
        fi
    }

    replace_or_insert "name" "\${SERVER_NAME:${target_svc}}DEV"
    replace_or_insert "port" "\${SERVER_PORT:${port}}"
    replace_or_insert "forward-headers-strategy" "native"
    replace_or_insert "sql-port" "\${SQL_PORT:${dbport}}"
    replace_or_insert "sql-name" "\${SQL_NAME:${dbname}}"
}

process_target_service() {
    local -r src_dir="$1"
    local -r dest_dir="$2"
    local -r source_token="$3"
    local -r target_svc="${dest_dir##*/}"
    local -r target_token="${target_svc#ms_}"
    local -r target_title="${target_token^}"

    [[ "$target_svc" == "$(basename "$src_dir")" ]] && return 0
    echo -e "${YELLOW}==> Processing ${target_svc} (${source_token} -> ${target_token})${NC}"

    local -a operations=(
        # Java sources
        "copy_and_replace_dir;${src_dir}/src/main/java/com/ticketsystem/${source_token}/broker;${dest_dir}/src/main/java/com/ticketsystem/${target_token}/broker"
        "copy_and_replace_file;${src_dir}/src/main/resources/logback-spring.xml;${dest_dir}/src/main/resources/logback-spring.xml"
        "copy_and_replace_file;${src_dir}/pom.xml;${dest_dir}/pom.xml"
        "copy_and_replace_file;${src_dir}/src/main/java/com/ticketsystem/${source_token}/Ms${source_token^}App.java;${dest_dir}/src/main/java/com/ticketsystem/${target_token}/Ms${target_title}App.java"

        # ONLY these files from resources/config (optional)
        "optional_copy_and_replace_file;${src_dir}/src/main/resources/config/application-dev.yml;${dest_dir}/src/main/resources/config/application-dev.yml"
        "optional_copy_and_replace_file;${src_dir}/src/main/resources/config/bootstrap.yml;${dest_dir}/src/main/resources/config/bootstrap.yml"
        "optional_copy_and_replace_file;${src_dir}/src/main/resources/config/tls/kafka.broker.keystore.jks;${dest_dir}/src/main/resources/config/tls/kafka.broker.keystore.jks"
        "optional_copy_and_replace_file;${src_dir}/src/main/resources/config/tls/kafka.client.truststore.jks;${dest_dir}/src/main/resources/config/tls/kafka.client.truststore.jks"

        # Java config under /config
        "copy_and_replace_file;${src_dir}/src/main/java/com/ticketsystem/${source_token}/config/ConsulSSHTunnel.java;${dest_dir}/src/main/java/com/ticketsystem/${target_token}/config/ConsulSSHTunnel.java"
        "copy_feign_config_package_only;${src_dir}/src/main/java/com/ticketsystem/${source_token}/config/FeignClientConfiguration.java;${dest_dir}/src/main/java/com/ticketsystem/${target_token}/config/FeignClientConfiguration.java"
    )

    local IFS=';'
    for op in "${operations[@]}"; do
        read -ra parts <<< "$op"
        "${parts[0]}" "${parts[1]}" "${parts[2]}" "$source_token" "$target_token"
    done

    # Handle TLS config directory if it exists
    if [[ -d "${src_dir}/src/main/java/com/ticketsystem/${source_token}/config/tls" ]]; then
        copy_and_replace_dir "${src_dir}/src/main/java/com/ticketsystem/${source_token}/config/tls" "${dest_dir}/src/main/java/com/ticketsystem/${target_token}/config/tls" "$source_token" "$target_token"
    fi

    # Patch application-dev.yml in place (keeps other content)
    patch_application_dev_yml "$dest_dir"

    # Copy Kafka resource after all
    copy_kafka_resource "$src_dir" "$dest_dir" "$source_token" "$target_token"

    echo "  ✓ Done ${target_svc}"
}

# ---------- Main ----------
main() {
    # Get dynamic source directory
    local SRC_DIR
    SRC_DIR=$(get_source_directory "$@")
    local SOURCE_TOKEN
    SOURCE_TOKEN=$(get_source_service_name "$SRC_DIR")
    
    echo -e "${GREEN}Using source: $SRC_DIR (service: $SOURCE_TOKEN)${NC}"
    echo -e "${GREEN}Starting batch copy from ${SRC_DIR} to all other backend/ms_* services...${NC}"

    local services=()
    while IFS= read -r -d '' dir; do
        [[ "$(basename "$dir")" != "$(basename "$SRC_DIR")" ]] && services+=("$dir")
    done < <(find backend -maxdepth 1 -type d -name 'ms_*' -print0 2>/dev/null)

    if [[ ${#services[@]} -eq 0 ]]; then
        echo -e "${YELLOW}No target services found to process (excluding source: $(basename "$SRC_DIR"))${NC}"
        exit 0
    fi

    echo "Found ${#services[@]} target service(s) to process"
    for service in "${services[@]}"; do
        process_target_service "$SRC_DIR" "$service" "$SOURCE_TOKEN"
    done
    echo -e "${GREEN}All ${#services[@]} target services processed successfully!${NC}"
}

# Show usage if help requested
if [[ $# -gt 0 ]] && [[ "$1" == "-h" || "$1" == "--help" ]]; then
    echo "Usage: $0 [SOURCE_SERVICE_DIR]"
    echo ""
    echo "Copy configuration and code from source service to all other microservices."
    echo ""
    echo "Methods to specify source (in order of priority):"
    echo "  1. Command line argument:    $0 backend/ms_route"
    echo "  2. Environment variable:     SOURCE_SERVICE=ms_route $0"
    echo "  3. Interactive selection:    $0 (when run in terminal)"
    echo "  4. Auto-detection:           Uses most recently modified service"
    echo ""
    echo "Examples:"
    echo "  $0 backend/ms_route                    # Use ms_route as source"
    echo "  SOURCE_SERVICE=ms_user $0              # Use ms_user as source"
    echo "  $0                                     # Interactive/auto mode"
    exit 0
fi

main "$@"