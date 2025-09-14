#!/usr/bin/env bash
set -euo pipefail
shopt -s globstar nullglob

# Ensure submodules are initialized
git submodule update --init --recursive

# Iterate over microservices and the gateway submodule
for sm in backend/ms_* backend/gateway; do
  [[ -d "$sm/.git" || -f "$sm/.git" ]] || continue
  echo "==> Restoring in $sm"

  # Pick patterns per submodule type
  if [[ "$sm" == backend/ms_* ]]; then
    patterns=(
      "src/main/java/com/ticketsystem/*/broker/*"
      "src/main/resources/logback-spring.xml"
      "pom.xml"
      "src/main/java/com/ticketsystem/*/Ms*App.java"
      "src/main/resources/config/bootstrap.yml"
      "src/main/resources/config/application-dev.yml"
      "src/main/java/com/ticketsystem/*/web/rest/Ms*KafkaResource.java"
    )
  else # gateway
    patterns=(
      "src/main/resources/logback-spring.xml"
      "pom.xml"
      "src/main/resources/config/*"
    )
  fi

  files=()
  for pat in "${patterns[@]}"; do
    matches=( "$sm"/$pat )
    for f in "${matches[@]}"; do
      # build path relative to submodule root for git -C
      rel="${f#$sm/}"
      files+=( "$rel" )
    done
  done

  if (( ${#files[@]} )); then
    # Restore both index and working tree, ignore missing
    git -C "$sm" restore --staged --worktree -- "${files[@]}" || true
  else
    echo "   (no matching files to restore)"
  fi
done
