#!/bin/bash
# push_microservices_and_vps.sh
#
# Pushes:
#  - ./ms_*
#  - ./backend/ms_*
#  - ./vps-*
# to https://github.com/<OWNER>/<repo>.git (OWNER from GH_OWNER or gh auth)
#
# Usage:
#   chmod +x ./push_microservices_and_vps.sh
#   ./push_microservices_and_vps.sh
#   GH_OWNER=my-org ./push_microservices_and_vps.sh   # push to org instead of user

set -euo pipefail

# =========================
# Pretty colors
# =========================
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m'

print_status()  { echo -e "${BLUE}[INFO]${NC} $1"; }
print_success() { echo -e "${GREEN}[SUCCESS]${NC} $1"; }
print_warning() { echo -e "${YELLOW}[WARNING]${NC} $1"; }
print_error()   { echo -e "${RED}[ERROR]${NC} $1"; }

# =========================
# Prechecks
# =========================
command -v gh >/dev/null || { print_error "GitHub CLI (gh) is not installed."; exit 1; }
if ! gh auth status &>/dev/null; then
  print_error "GitHub CLI is not authenticated. Run: gh auth login"
  exit 1
fi

OWNER="${GH_OWNER:-$(gh api user --jq .login)}"
print_success "Authenticated as owner: ${OWNER}"

CURRENT_DIR="$(pwd)"
print_status "Working in: ${CURRENT_DIR}"

# =========================
# Collect target directories
# =========================
mapfile -t MS_DIRS_ROOT    < <(find .       -maxdepth 1 -mindepth 1 -type d -name "ms_*"   -printf "%P\n" | sort)
mapfile -t MS_DIRS_BACKEND < <(find backend -maxdepth 1 -mindepth 1 -type d -name "ms_*"   -printf "%P\n" 2>/dev/null | sed 's|^|backend/|' | sort || true)
mapfile -t VPS_DIRS        < <(find .       -maxdepth 1 -mindepth 1 -type d -name "vps-*"  -printf "%P\n" | sort)

TARGET_DIRS=()
TARGET_DIRS+=("${MS_DIRS_ROOT[@]}")
TARGET_DIRS+=("${MS_DIRS_BACKEND[@]}")
TARGET_DIRS+=("${VPS_DIRS[@]}")

if [ "${#TARGET_DIRS[@]}" -eq 0 ]; then
  print_error "No matching directories found: ms_* (root), backend/ms_*, or vps-*."
  exit 1
fi

print_status "Found ${#TARGET_DIRS[@]} repositories to process:"
for d in "${TARGET_DIRS[@]}"; do echo "  - $d"; done
echo

# =========================
# Helpers
# =========================
ensure_gitignore() {
  local dir="$1"
  if [ ! -f "${dir}/.gitignore" ]; then
    cat > "${dir}/.gitignore" <<'EOF'
# Java / Maven
target/
*.class
*.log
*.jar
*.war
*.nar
*.ear
pom.xml.tag
pom.xml.releaseBackup
pom.xml.versionsBackup
pom.xml.next
release.properties
dependency-reduced-pom.xml

# Node / frontend (just in case)
node_modules/
.next/
dist/
build/
*.map

# IDE / OS
.idea/
*.iml
.vscode/
.project
.classpath
.settings/
.DS_Store
Thumbs.db

# Env
.env
.env.local
.env.*.local

# Misc archives
*.zip
*.tar.gz
*.rar
EOF
    print_status "Created .gitignore in ${dir}"
  fi
}

# =========================
# Main loop (hardened to keep going)
# =========================
SUCCESS_COUNT=0
FAILED_REPOS=()

i=0
for dir in "${TARGET_DIRS[@]}"; do
  i=$((i+1))
  echo
  print_status "[$i/${#TARGET_DIRS[@]}] Processing: ${dir}"
  echo "-------------------------------------------"

  if [ ! -d "${dir}" ]; then
    print_error "Directory missing, skipping: ${dir}"
    FAILED_REPOS+=("${dir} (directory not found)")
    continue
  fi

  REPO_NAME="$(basename "${dir}")"     # backend/ms_payment -> ms_payment; vps-infra -> vps-infra
  REPO_URL="https://github.com/${OWNER}/${REPO_NAME}.git"

  # prevent a single failure from killing the whole script
  set +e

  pushd "${dir}" >/dev/null 2>&1
  if [ $? -ne 0 ]; then
    print_error "pushd failed: ${dir}"
    FAILED_REPOS+=("${REPO_NAME} (pushd failed)")
    set -e
    continue
  fi

  # Init repo if needed
  if [ ! -d ".git" ]; then
    print_status "Initializing git repository..."
    git init
    if [ $? -ne 0 ]; then
      print_error "git init failed"
      popd >/dev/null 2>&1
      FAILED_REPOS+=("${REPO_NAME} (git init failed)")
      set -e
      continue
    fi
  fi

  # Ensure we have a branch and prefer 'main'
  git symbolic-ref -q HEAD >/dev/null || git checkout -b main
  CURRENT_BRANCH="$(git branch --show-current 2>/dev/null || echo main)"
  [ "${CURRENT_BRANCH}" = "main" ] || git branch -M main

  # .gitignore
  ensure_gitignore "."

  # Commit if needed
  git add -A
  if ! git diff --cached --quiet; then
    if git rev-parse --verify HEAD >/dev/null 2>&1; then
      print_status "Committing updates..."
      git commit -m "Update: $(date '+%Y-%m-%d %H:%M:%S')" || print_warning "Commit failed or nothing to commit"
    else
      print_status "Creating initial commit..."
      git commit -m "Initial commit for ${REPO_NAME}" || print_warning "Initial commit failed (maybe empty repo)"
    fi
  else
    print_status "No changes to commit."
  fi

  # Remote handling
  git remote remove origin >/dev/null 2>&1
  print_status "Adding remote: ${REPO_URL}"
  git remote add origin "${REPO_URL}" 2>/dev/null || git remote set-url origin "${REPO_URL}"

  # Push (try normal, then force if needed)
  print_status "Pushing to GitHub..."
  if git push -u origin main; then
    print_success "✅ Successfully pushed ${REPO_NAME}"
    SUCCESS_COUNT=$((SUCCESS_COUNT+1))
  else
    print_warning "Normal push failed, trying --force…"
    if git push -u origin main --force; then
      print_warning "⚠️  Force-pushed ${REPO_NAME} (diverged history)"
      SUCCESS_COUNT=$((SUCCESS_COUNT+1))
    else
      print_error "❌ Push failed for ${REPO_NAME}"
      print_error "Ensure repo exists: https://github.com/${OWNER}/${REPO_NAME}"
      FAILED_REPOS+=("${REPO_NAME} (push failed - repo may not exist)")
    fi
  fi

  popd >/dev/null 2>&1 || true

  # restore strict mode for the next iteration
  set -e
done

# =========================
# Summary
# =========================
echo
echo "==========================================="
print_status "SUMMARY"
echo "==========================================="
print_success "Successfully processed: ${SUCCESS_COUNT}/${#TARGET_DIRS[@]}"

if [ "${#FAILED_REPOS[@]}" -gt 0 ]; then
  echo
  print_warning "Failed repositories:"
  for r in "${FAILED_REPOS[@]}"; do echo "  ❌ ${r}"; done

  echo
  print_status "To create missing repositories (public) under ${OWNER}, run:"
  for r in "${FAILED_REPOS[@]}"; do
    n="$(echo "${r}" | awk '{print $1}')"
    # Suggest creation only for 'push failed' cases
    if [[ "${r}" == *"push failed"* ]]; then
      echo "  gh repo create ${OWNER}/${n} --public"
    fi
  done
fi

echo
if [ "${SUCCESS_COUNT}" -eq "${#TARGET_DIRS[@]}" ]; then
  print_success "🎉 All repositories pushed!"
else
  print_warning "⚠️  Some repositories failed."
fi

print_status "View repos: https://github.com/${OWNER}?tab=repositories"
