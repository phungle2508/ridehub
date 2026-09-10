#!/usr/bin/env bash
set -euo pipefail

# ==============================================================================
# SCRIPT TỰ ĐỘNG COMMIT & PUSH TOÀN BỘ SUBMODULES + ROOT REPO
# - Tự động phát hiện thư mục root git bất kể chạy từ đâu.
# - Xử lý an toàn detached HEAD, pull rebase và push.
# - Tự động cập nhật và commit con trỏ (submodule pointers) ở Root Repo.
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

# 1. Xác định Root Repository
REPO_ROOT="$(git rev-parse --show-toplevel 2>/dev/null || true)"
if [ -z "$REPO_ROOT" ]; then
  print_error "Không tìm thấy thư mục gốc Git repository!"
  exit 1
fi

cd "$REPO_ROOT"

# 2. Xử lý tham số
COMMIT_MSG=""
TARGET_BRANCH="main"
STATUS_ONLY=false
PUSH_ROOT=true

show_help() {
  echo -e "${BOLD}CÁCH DÙNG:${NC} $0 [OPTIONS] [COMMIT_MESSAGE]"
  echo ""
  echo "Tùy chọn:"
  echo "  -m, --message <msg>   Thông điệp commit (mặc định: 'chore: update submodule <name>')"
  echo "  -b, --branch <name>   Tên nhánh mục tiêu để push (mặc định: 'main')"
  echo "  -s, --status          Chỉ quét và hiển thị trạng thái thay đổi, không commit/push"
  echo "  --no-root             Chỉ push các submodule, không tự động commit/push root repo"
  echo "  -h, --help            Hiển thị trợ giúp này"
  exit 0
}

while [ $# -gt 0 ]; do
  case "$1" in
    -m|--message)
      shift
      [ $# -gt 0 ] && COMMIT_MSG="$1"
      ;;
    -b|--branch)
      shift
      [ $# -gt 0 ] && TARGET_BRANCH="$1"
      ;;
    -s|--status)
      STATUS_ONLY=true
      ;;
    --no-root)
      PUSH_ROOT=false
      ;;
    -h|--help)
      show_help
      ;;
    *)
      if [ -z "$COMMIT_MSG" ]; then
        COMMIT_MSG="$1"
      else
        print_warn "Tham số không xác định: $1"
      fi
      ;;
  esac
  shift
done

# 3. Quét danh sách Submodules từ .gitmodules
if [ ! -f ".gitmodules" ]; then
  print_error "Không tìm thấy tệp .gitmodules tại: $REPO_ROOT"
  exit 1
fi

SUBMODULES=()
while read -r path; do
  [ -n "$path" ] && [ -d "$REPO_ROOT/$path" ] && SUBMODULES+=("$path")
done < <(git config --file .gitmodules --get-regexp path | awk '{ print $2 }')

if [ ${#SUBMODULES[@]} -eq 0 ]; then
  print_error "Không tìm thấy submodule hợp lệ nào trong .gitmodules!"
  exit 1
fi

echo -e "${CYAN}====================================================================${NC}"
echo -e "${BOLD}📦 QUẢN LÝ TỰ ĐỘNG ${#SUBMODULES[@]} GIT SUBMODULES${NC} (Nhánh: ${YELLOW}${TARGET_BRANCH}${NC})"
echo -e "${CYAN}====================================================================${NC}"

# Chế độ chỉ xem trạng thái
if [ "$STATUS_ONLY" = true ]; then
  echo -e "${BLUE}▶ Đang kiểm tra trạng thái toàn bộ submodules:${NC}\n"
  for sm in "${SUBMODULES[@]}"; do
    cd "$REPO_ROOT/$sm"
    changes="$(git status --porcelain)"
    branch="$(git rev-parse --abbrev-ref HEAD)"
    if [ -n "$changes" ]; then
      echo -e "  [${YELLOW}DIRTY${NC}]  ${BOLD}$sm${NC} (Nhánh: $branch) có thay đổi chưa commit:"
      echo "$changes" | sed 's/^/         /'
    else
      echo -e "  [${GREEN}CLEAN${NC}]  ${BOLD}$sm${NC} (Nhánh: $branch) sạch sẽ."
    fi
  done
  cd "$REPO_ROOT"
  echo ""
  echo -e "${BLUE}Trạng thái Root Repo:${NC}"
  git status -s
  exit 0
fi

# Bảng theo dõi kết quả
declare -A RESULTS

# 4. Thực thi commit & push cho từng submodule
for sm in "${SUBMODULES[@]}"; do
  echo -e "\n${BLUE}--------------------------------------------------------------------${NC}"
  print_info "Đang xử lý submodule: ${BOLD}$sm${NC}"
  cd "$REPO_ROOT/$sm"

  # Đảm bảo submodule đang ở đúng branch mục tiêu
  CURRENT_BRANCH="$(git rev-parse --abbrev-ref HEAD)"
  if [ "$CURRENT_BRANCH" = "HEAD" ]; then
    print_warn "Submodule đang ở trạng thái Detached HEAD! Đang chuyển về nhánh: $TARGET_BRANCH..."
    git checkout "$TARGET_BRANCH" || git checkout -b "$TARGET_BRANCH"
  elif [ "$CURRENT_BRANCH" != "$TARGET_BRANCH" ]; then
    print_warn "Submodule đang ở nhánh '$CURRENT_BRANCH'. Đang chuyển về '$TARGET_BRANCH'..."
    git checkout "$TARGET_BRANCH" || git checkout -b "$TARGET_BRANCH"
  fi

  # Kiểm tra thay đổi nội bộ
  HAS_CHANGES=false
  if [ -n "$(git status --porcelain)" ]; then
    HAS_CHANGES=true
  fi

  if [ "$HAS_CHANGES" = true ]; then
    sm_msg="${COMMIT_MSG:-chore: update submodule $(basename "$sm")}"
    print_info "Phát hiện thay đổi. Đang commit với thông điệp: '$sm_msg'..."
    git add -A
    git commit -m "$sm_msg"
  fi

  # Kiểm tra xem local có commit chưa push lên remote không
  git fetch origin "$TARGET_BRANCH" >/dev/null 2>&1 || true
  LOCAL_AHEAD="$(git rev-list --count "origin/$TARGET_BRANCH..HEAD" 2>/dev/null || echo "0")"

  if [ "$LOCAL_AHEAD" -gt 0 ] || [ "$HAS_CHANGES" = true ]; then
    print_info "Đang rebase & push lên origin/$TARGET_BRANCH ($LOCAL_AHEAD commits ahead)..."
    if git pull origin "$TARGET_BRANCH" --rebase; then
      if git push origin "$TARGET_BRANCH"; then
        print_success "✓ Đã push thành công: $sm"
        RESULTS["$sm"]="PUSHED"
      else
        print_error "✗ Lỗi khi push $sm!"
        RESULTS["$sm"]="PUSH_FAILED"
      fi
    else
      print_error "✗ Rebase xung đột tại $sm! Hãy giải quyết conflict bằng tay."
      RESULTS["$sm"]="REBASE_CONFLICT"
    fi
  else
    print_success "✓ Submodule $sm sạch sẽ, không có commit mới cần push."
    RESULTS["$sm"]="CLEAN"
  fi
done

# 5. Xử lý cập nhật Root Repository
cd "$REPO_ROOT"

echo -e "\n${CYAN}====================================================================${NC}"
echo -e "${BOLD}📋 BẢNG TỔNG HỢP KẾT QUẢ SUBMODULES:${NC}"
echo -e "${CYAN}====================================================================${NC}"
for sm in "${SUBMODULES[@]}"; do
  status="${RESULTS[$sm]}"
  case "$status" in
    "PUSHED")
      echo -e "  [${GREEN}PUSHED${NC}]         $sm"
      ;;
    "CLEAN")
      echo -e "  [${BLUE}UP-TO-DATE${NC}]     $sm"
      ;;
    "PUSH_FAILED"|"REBASE_CONFLICT")
      echo -e "  [${RED}${status}${NC}]  $sm"
      ;;
  esac
done

# 6. Tự động commit và push Root Pointer nếu có
if [ "$PUSH_ROOT" = true ]; then
  echo -e "\n${BLUE}--------------------------------------------------------------------${NC}"
  print_info "Kiểm tra thay đổi con trỏ Submodules tại Root Repository..."
  ROOT_CHANGES="$(git status --porcelain)"
  if [ -n "$ROOT_CHANGES" ]; then
    print_info "Phát hiện thay đổi tại Root Repo. Đang cập nhật submodule pointers..."
    git add -u
    root_msg="${COMMIT_MSG:-chore: bump submodule commit pointers}"
    print_info "Phát hiện thay đổi tại Root Repo. Đang cập nhật và commit thay đổi..."
    git add -A
    root_msg="${COMMIT_MSG:-chore: sync submodules and update documentation}"
    git commit -m "$root_msg"
    print_info "Đang push Root Repository lên origin..."
    if git push origin "$(git rev-parse --abbrev-ref HEAD)"; then
      print_success "✓ Đã cập nhật và push Root Repository thành công!"
    else
      print_warn "Chưa thể push Root Repository. Hãy kiểm tra kết nối Git."
    fi
  else
    print_success "✓ Root Repository đã đồng bộ hoàn toàn với các submodules."
  fi
fi

echo -e "\n${GREEN}🎉 HOÀN TẤT QUY TRÌNH TOÀN BỘ SUBMODULES!${NC}\n"
