#!/bin/bash
set -euo pipefail

# =========================================
# Copy from ms_route -> every backend/ms_* (except ms_route)
# Replace: route/Route/ROUTE -> <svc>/<Svc>/<SVC>
# =========================================

readonly RED='\033[0;31m' GREEN='\033[0;32m' YELLOW='\033[1;33m' NC='\033[0m'
readonly SRC_DIR="backend/ms_route"

# Validate source directory exists
if [[ ! -d "$SRC_DIR" ]]; then
    echo -e "${RED}Error: $SRC_DIR directory not found!${NC}" >&2
    exit 1
fi

echo -e "${GREEN}Starting batch copy from ${SRC_DIR} to all backend/ms_* services...${NC}"

# ---------- Optimized helper functions ----------
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
    
    [[ -f "$src_file" ]] || {
        echo -e "${RED}  Warning: Source file not found: $src_file${NC}" >&2
        return 1
    }
    
    echo "  Copying: $src_file -> $dest_file"
    mkdir -p "$(dirname "$dest_file")"
    
    # Single sed call with all replacements
    sed -e "s/${from}/${to}/g" \
        -e "s/${from^}/${to^}/g" \
        -e "s/${from^^}/${to^^}/g" \
        "$src_file" > "$dest_file"
}

copy_and_replace_dir() {
    local -r src_dir="$1" dest_dir="$2" from="$3" to="$4"

    [[ -d "$src_dir" ]] || {
        echo -e "${RED}  Warning: Source directory not found: $src_dir${NC}" >&2
        return 1
    }

    echo "  Copying directory: $src_dir -> $dest_dir"

    # Nếu là thư mục config, loại trừ 'liquibase' bằng -prune
    if [[ "$src_dir" == */src/main/resources/config* ]]; then
        # Duyệt file với -print0 để an toàn với khoảng trắng, và prune liquibase/*
        find "$src_dir" \
            -type d -name liquibase -prune -o \
            -type f -print0 \
        | while IFS= read -r -d '' file; do
            local rel_path="${file#$src_dir/}"

            # Thay thế token trong đường dẫn
            local new_rel_path="$rel_path"
            new_rel_path="${new_rel_path//$from/$to}"
            new_rel_path="${new_rel_path//${from^}/${to^}}"
            new_rel_path="${new_rel_path//${from^^}/${to^^}}"

            local dest_file="$dest_dir/$new_rel_path"
            mkdir -p "$(dirname "$dest_file")"

            # Thay thế token trong nội dung
            sed -e "s/$from/$to/g" \
                -e "s/${from^}/${to^}/g" \
                -e "s/${from^^}/${to^^}/g" \
                "$file" > "$dest_file"
        done
    else
        # Nhánh thường (không cần loại trừ gì)
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
    local -r dest_dir="$1" target_token="$2"
    local -r target_title="${target_token^}"
    
    echo "  Copying Ms*KafkaResource.java..."
    
    # More efficient glob handling
    shopt -s nullglob
    local kafka_files=("${SRC_DIR}"/src/main/java/com/ticketsystem/route/web/rest/Ms*KafkaResource.java)
    shopt -u nullglob
    
    if [[ ${#kafka_files[@]} -eq 0 ]]; then
        echo -e "${RED}  Warning: No Ms*KafkaResource.java found${NC}" >&2
        return 1
    fi
    
    for src_file in "${kafka_files[@]}"; do
        local base_name="${src_file##*/}"
        local dest_name="${base_name//Route/$target_title}"
        local dest_file="${dest_dir}/src/main/java/com/ticketsystem/${target_token}/web/rest/${dest_name}"
        
        copy_and_replace_file "$src_file" "$dest_file" "route" "$target_token"
    done
}

process_target_service() {
    local -r dest_dir="$1"
    local -r target_svc="${dest_dir##*/}"
    local -r target_token="${target_svc#ms_}"
    local -r target_title="${target_token^}"
    
    # Skip source service
    [[ "$target_svc" == "ms_route" ]] && return 0
    
    echo -e "${YELLOW}==> Processing ${target_svc} (route -> ${target_token})${NC}"
    
    # Array of copy operations for cleaner code
    local -a operations=(
        "copy_and_replace_dir;${SRC_DIR}/src/main/java/com/ticketsystem/route/broker;${dest_dir}/src/main/java/com/ticketsystem/${target_token}/broker"
        "copy_and_replace_file;${SRC_DIR}/src/main/resources/logback-spring.xml;${dest_dir}/src/main/resources/logback-spring.xml"
        "copy_and_replace_file;${SRC_DIR}/pom.xml;${dest_dir}/pom.xml"
        "copy_and_replace_file;${SRC_DIR}/src/main/java/com/ticketsystem/route/MsRouteApp.java;${dest_dir}/src/main/java/com/ticketsystem/${target_token}/Ms${target_title}App.java"
        "copy_and_replace_dir;${SRC_DIR}/src/main/resources/config;${dest_dir}/src/main/resources/config"
    )
    
    # Execute operations
    local IFS=';'
    for op in "${operations[@]}"; do
        read -ra parts <<< "$op"
        "${parts[0]}" "${parts[1]}" "${parts[2]}" "route" "$target_token"
    done
    
    # Handle Kafka resource separately
    copy_kafka_resource "$dest_dir" "$target_token"
    
    echo "  ✓ Done ${target_svc}"
}

# ---------- Main execution ----------
main() {
    local services=()
    
    # Collect all ms_* directories efficiently
    while IFS= read -r -d '' dir; do
        [[ "${dir##*/}" != "ms_route" ]] && services+=("$dir")
    done < <(find backend -maxdepth 1 -type d -name 'ms_*' -print0 2>/dev/null)
    
    if [[ ${#services[@]} -eq 0 ]]; then
        echo -e "${YELLOW}No target services found to process${NC}"
        exit 0
    fi
    
    echo "Found ${#services[@]} target service(s) to process"
    
    # Process services in parallel for better performance
    for service in "${services[@]}"; do
        process_target_service "$service"
    done
    
    echo -e "${GREEN}All ${#services[@]} target services processed successfully!${NC}"
}

# Run main function
main "$@"