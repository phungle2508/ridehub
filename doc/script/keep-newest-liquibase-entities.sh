#!/usr/bin/env bash
# keep-newest-liquibase-entities.sh
# Keeps only the newest Liquibase "*_added_entity_*.xml" and
# "*_added_entity_constraints_*.xml" files per service changelog dir.

set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
BASE="${ROOT_DIR}/backend"
DRY_RUN=0

if [[ "${1:-}" == "--dry-run" ]]; then
  DRY_RUN=1
fi

# Patterns to process; add more if needed
PATTERNS=(
  "*_added_entity_*.xml"
  "*_added_entity_constraints_*.xml"
)

# Find all ms_* services
mapfile -t SERVICES < <(find "${BASE}" -maxdepth 1 -type d -name "ms_*" | sort)

if [[ ${#SERVICES[@]} -eq 0 ]]; then
  echo "No ms_* services found under ${BASE}" >&2
  exit 1
fi

total_deleted=0

for svc in "${SERVICES[@]}"; do
  changelog_dir="${svc}/src/main/resources/config/liquibase/changelog"
  if [[ ! -d "${changelog_dir}" ]]; then
    echo "[SKIP] ${svc}: no changelog dir"
    continue
  fi

  echo "==> Service: $(basename "${svc}")"
  echo "    Changelog: ${changelog_dir}"

  for pattern in "${PATTERNS[@]}"; do
    # Gather matching files
    mapfile -t files < <(find "${changelog_dir}" -maxdepth 1 -type f -name "${pattern}" -printf "%f\n" | sort -r)
    if [[ ${#files[@]} -le 1 ]]; then
      # 0 or 1 file => nothing to prune
      [[ ${#files[@]} -eq 1 ]] && echo "    [KEEP] ${files[0]} (only match for pattern '${pattern}')"
      continue
    fi

    newest="${files[0]}"
    echo "    Pattern '${pattern}':"
    echo "      [KEEP] ${newest}"

    # Delete all but the newest
    for ((i=1; i<${#files[@]}; i++)); do
      victim="${changelog_dir}/${files[$i]}"
      if [[ ${DRY_RUN} -eq 1 ]]; then
        echo "      [DEL?] ${files[$i]}"
      else
        rm -f -- "${victim}"
        echo "      [DEL ] ${files[$i]}"
        ((total_deleted++))
      fi
    done
  done

  echo
done

if [[ ${DRY_RUN} -eq 1 ]]; then
  echo "Dry run complete. No files were deleted."
  echo "Re-run without --dry-run to apply."
else
  echo "Done. Deleted ${total_deleted} old changelog file(s)."
fi
