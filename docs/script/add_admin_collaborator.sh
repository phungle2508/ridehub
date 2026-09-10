#!/usr/bin/env bash
set -euo pipefail

# ==============================================================================
# SCRIPT TỰ ĐỘNG THÊM COLLABORATOR VÀO TẤT CẢ REPOSITORIES (ROOT + SUBMODULES)
# Tự động trích xuất danh sách GitHub repos từ .gitmodules và root remote origin.
# Yêu cầu: GitHub CLI (gh) đã đăng nhập (gh auth login).
# ==============================================================================

GREEN='\033[0;32m'
RED='\033[0;31m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
CYAN='\033[0;36m'
BOLD='\033[1m'
NC='\033[0m'

print_info()    { echo -e "${BLUE}[INFO]${NC} $1"; }
print_success() { echo -e "${GREEN}[SUCCESS]${NC} $1"; }
print_warn()    { echo -e "${YELLOW}[WARN]${NC} $1"; }
print_error()   { echo -e "${RED}[ERROR]${NC} $1"; }

# Tìm thư mục root của git repository
REPO_ROOT="$(git rev-parse --show-toplevel 2>/dev/null || pwd)"
cd "$REPO_ROOT"

# Kiểm tra GitHub CLI
if ! command -v gh >/dev/null 2>&1; then
  print_error "Không tìm thấy GitHub CLI ('gh'). Vui lòng cài đặt: https://cli.github.com"
  exit 1
fi

if ! gh auth status >/dev/null 2>&1; then
  print_error "GitHub CLI chưa được đăng nhập! Hãy chạy lệnh: ${BOLD}gh auth login${NC}"
  exit 1
fi

if [ "${1:-}" = "-h" ] || [ "${1:-}" = "--help" ]; then
  echo -e "${BOLD}CÁCH SỬ DỤNG:${NC} $0 <github_username> [permission]"
  echo -e "  - ${CYAN}github_username${NC}: Tên tài khoản GitHub của collaborator cần thêm."
  echo -e "  - ${CYAN}permission${NC}     : Quyền hạn (admin, push, pull, maintain, triage). Mặc định: ${GREEN}admin${NC}"
  exit 0
fi

# Xử lý tham số đầu vào
COLLAB="${1:-}"
PERMISSION="${2:-admin}"

if [ -z "$COLLAB" ]; then
  echo -e "${BOLD}CÁCH SỬ DỤNG:${NC} $0 <github_username> [permission]"
  echo -e "  - ${CYAN}github_username${NC}: Tên tài khoản GitHub của collaborator cần thêm."
  echo -e "  - ${CYAN}permission${NC}     : Quyền hạn (admin, push, pull, maintain, triage). Mặc định: ${GREEN}admin${NC}"
  echo ""
  read -rp "👉 Nhập GitHub Username cần thêm: " COLLAB
  if [ -z "$COLLAB" ]; then
    print_error "Tên username không được để trống!"
    exit 1
  fi
fi

echo -e "${CYAN}====================================================================${NC}"
echo -e "${BOLD}🚀 THÊM COLLABORATOR: ${GREEN}${COLLAB}${NC} (Quyền: ${YELLOW}${PERMISSION}${NC})"
echo -e "${CYAN}====================================================================${NC}"

# 1. Trích xuất repo slug từ remote URL
extract_slug() {
  local url="$1"
  # Xử lý cả dạng HTTPS (https://github.com/owner/repo.git) và SSH (git@github.com:owner/repo.git)
  echo "$url" | sed -E 's#(https://github.com/|git@github.com:)##' | sed -E 's/\.git$//'
}

REPOS=()

# 2. Lấy root repository slug
ROOT_URL="$(git remote get-url origin 2>/dev/null || true)"
if [ -n "$ROOT_URL" ]; then
  ROOT_SLUG="$(extract_slug "$ROOT_URL")"
  [ -n "$ROOT_SLUG" ] && REPOS+=("$ROOT_SLUG")
fi

# 3. Quét tất cả submodules trong .gitmodules
if [ -f ".gitmodules" ]; then
  while read -r url; do
    [ -z "$url" ] && continue
    SLUG="$(extract_slug "$url")"
    if [ -n "$SLUG" ]; then
      # Tránh trùng lặp
      if [[ ! " ${REPOS[*]} " =~ " ${SLUG} " ]]; then
        REPOS+=("$SLUG")
      fi
    fi
  done < <(git config --file .gitmodules --get-regexp url | awk '{ print $2 }')
fi

if [ ${#REPOS[@]} -eq 0 ]; then
  print_error "Không tìm thấy repository nào để thêm collaborator!"
  exit 1
fi

print_info "Đã phát hiện ${#REPOS[@]} repositories cần phân quyền:"
for r in "${REPOS[@]}"; do
  echo -e "  - ${CYAN}$r${NC}"
done
echo ""

SUCCESS_COUNT=0
FAILED_COUNT=0

# 4. Thực thi thêm collaborator qua GitHub API
for repo in "${REPOS[@]}"; do
  echo -e "${BLUE}▶ Đang thêm vào:${NC} ${BOLD}$repo${NC}..."
  if gh api --method PUT \
    --field permission="$PERMISSION" \
    "repos/$repo/collaborators/$COLLAB" >/dev/null 2>&1; then
    print_success "Đã gửi lời mời thành công vào: $repo"
    ((SUCCESS_COUNT++))
  else
    print_error "Thất bại khi thêm vào: $repo (Kiểm tra quyền quản trị của bạn hoặc tài khoản $COLLAB)"
    ((FAILED_COUNT++))
  fi
done

echo ""
echo -e "${CYAN}====================================================================${NC}"
echo -e "${BOLD}KẾT QUẢ HOÀN TẤT:${NC} ${GREEN}${SUCCESS_COUNT} thành công${NC} | ${RED}${FAILED_COUNT} thất bại${NC}"
echo -e "${CYAN}====================================================================${NC}"
