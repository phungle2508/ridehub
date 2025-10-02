#!/usr/bin/env bash
set -euo pipefail
shopt -s globstar nullglob

# Xác định repo root (để restore khi không còn submodule)
repo_root="$(git rev-parse --show-toplevel)"

# Đảm bảo submodule (nếu còn) đã init nhưng không lỗi nếu không có
git submodule update --init --recursive || true

# Hàm chạy git restore an toàn
restore_paths() {
  local workdir="$1"; shift
  if [[ -d "$workdir/.git" || -f "$workdir/.git" ]]; then
    git -C "$workdir" restore --source=HEAD --staged --worktree -- "$@" || true
  else
    git -C "$repo_root" restore --source=HEAD --staged --worktree -- "$@" || true
  fi
}

for sm in backend/ms_* backend/gateway; do
  [[ -d "$sm" ]] || continue
  echo "==> Restoring in $sm"

  if [[ "$sm" == backend/ms_* ]]; then
    patterns=(
      "src/main/java/com/ridehub/*/broker/*"
      "src/main/resources/logback-spring.xml"
      "pom.xml"
      "src/main/java/com/ridehub/*/Ms*App.java"
      "src/main/resources/config/bootstrap.yml"
      "src/main/resources/config/application-dev.yml"
      "src/main/java/com/ridehub/*/web/rest/Ms*KafkaResource.java"
      "src/main/java/com/ridehub/*/config/ConsulSSHTunnel.java"
      # "src/main/java/com/ridehub/*/config/FeignClientConfiguration.java"
    )
  else
    patterns=(
      "src/main/java/com/ridehub/gateway/config/ConsulSSHTunnel.java"
      "src/main/resources/logback-spring.xml"
      "pom.xml"
      "src/main/resources/config/*"
    )
  fi

  pathspecs=()
  if [[ -d "$sm/.git" || -f "$sm/.git" ]]; then
    # Submodule: chạy từ trong submodule → KHÔNG prefix $sm
    for pat in "${patterns[@]}"; do
      pathspecs+=( ":(glob)$pat" )
    done
  else
    # Thư mục thường: chạy từ repo root → prefix $sm
    for pat in "${patterns[@]}"; do
      pathspecs+=( ":(glob)$sm/$pat" )
    done
  fi

  # Gọi restore 1 phát với pathspec (không để bash expand)
  restore_paths "$sm" "${pathspecs[@]}"
done