#!/usr/bin/env bash
set -euo pipefail

# Colors
GREEN='\033[0;32m'
RED='\033[0;31m'
BLUE='\033[0;34m'
NC='\033[0m'

print_info()    { echo -e "${BLUE}[INFO]${NC} $1"; }
print_success() { echo -e "${GREEN}[SUCCESS]${NC} $1"; }
print_error()   { echo -e "${RED}[ERROR]${NC} $1"; }

ROOT_DIR="$(pwd)"

# Detect submodules dynamically from .gitmodules
SUBMODULES=$(git config --file .gitmodules --get-regexp path | awk '{ print $2 }')

if [ -z "$SUBMODULES" ]; then
  print_error "No submodules found in this repository."
  exit 1
fi

for submodule in $SUBMODULES; do
  print_info "🔄 Processing submodule: $submodule"
  cd "$ROOT_DIR/$submodule"

  # Ensure branch is main
  BRANCH=$(git rev-parse --abbrev-ref HEAD)
  if [ "$BRANCH" != "main" ]; then
    print_info "Switching $submodule to main branch"
    git checkout main || git checkout -b main
  fi

  # Commit if there are changes
  if [ -n "$(git status --porcelain)" ]; then
    git add .
    git commit -m "chore: update submodule $submodule"
    print_success "Committed changes in $submodule"
  else
    print_info "No local changes in $submodule"
  fi

  # Rebase & push
  git pull origin main --rebase || true
  git push origin main
  print_success "✅ Pushed $submodule → main"

  cd "$ROOT_DIR"
done

print_success "🎉 All submodules pushed to main successfully!"
