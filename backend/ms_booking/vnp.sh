#!/usr/bin/env bash
set -euo pipefail

# ====== Merchant config (sandbox) ======
TMN="FCFK1679"                               # vnp_TmnCode
SECRET="69ML0ON3RUOD1F4L1YWZ4DO3L9NY54Q2"    # Secret khớp TMN
VERSION="2.1.0"
PAY_URL="https://sandbox.vnpayment.vn/paymentv2/vpcpay.html"

# ====== Your test order ======
RETURN_URL="https://apigateway.microservices.appf4s.io.vn/services/msbookingdev/api/payment/vnpay/callback"
TXN_REF="TXN-WYZ4LHPJK7YIRJQ1311"              # Mã bạn đã dùng khi khởi tạo thanh toán
ORDER_INFO="Thanh toan don hang : RH-5AWL-ZSEY"
AMOUNT_VND="275000"                           # VND
LOCALE="vn"
CURR_CODE="VND"
IP_ADDR="127.0.0.1"

# ====== Helpers ======
now_ymdhms() { LC_ALL=C date +%Y%m%d%H%M%S; }
rand_suffix() { LC_ALL=C tr -dc 'A-Z0-9' </dev/urandom | head -c6; }

# Encode cho phần tạo Payment URL (xưa giờ bạn đã OK)
urlenc_form() {
  if command -v python3 >/dev/null 2>&1; then
    python3 - "$1" << 'PY'
import sys, urllib.parse
print(urllib.parse.quote_plus(sys.argv[1], safe='~-._'))
PY
  else
    local s="$1" out="" i ch
    for (( i=0; i<${#s}; i++ )); do
      ch="${s:i:1}"
      case "$ch" in
        [a-zA-Z0-9.~_-]) out+="$ch" ;;
        ' ') out+='+' ;;
        *) printf -v out '%s%%%02X' "$out" "'$ch" ;;
      esac
    done
    printf '%s' "$out"
  fi
}

# ========== 1) CREATE PAYMENT URL (giữ nguyên logic cũ) ==========
create_pay_url() {
  local CREATE_DATE="$(now_ymdhms)"
  local AMOUNT_MULT=$(( AMOUNT_VND * 100 ))

  declare -A P
  P[vnp_Amount]="$(urlenc_form "$AMOUNT_MULT")"
  P[vnp_Command]="$(urlenc_form "pay")"
  P[vnp_CreateDate]="$(urlenc_form "$CREATE_DATE")"
  P[vnp_CurrCode]="$(urlenc_form "$CURR_CODE")"
  P[vnp_IpAddr]="$(urlenc_form "$IP_ADDR")"
  P[vnp_Locale]="$(urlenc_form "$LOCALE")"
  P[vnp_OrderInfo]="$(urlenc_form "$ORDER_INFO")"
  P[vnp_OrderType]="$(urlenc_form "other")"
  P[vnp_ReturnUrl]="$(urlenc_form "$RETURN_URL")"
  P[vnp_TmnCode]="$(urlenc_form "$TMN")"
  P[vnp_TxnRef]="$(urlenc_form "$TXN_REF")"
  P[vnp_Version]="$(urlenc_form "$VERSION")"

  readarray -t KEYS < <(printf "%s\n" "${!P[@]}" | sort)
  local CANON=""
  for k in "${KEYS[@]}"; do
    local v="${P[$k]}"
    [[ -n "$CANON" ]] && CANON+="&"
    CANON+="${k}=${v}"
  done

  local SIGNATURE
  SIGNATURE="$(printf '%s' "$CANON" | openssl dgst -sha512 -hmac "$SECRET" | sed 's/^.* //')"
  local PAYMENT_URL="${PAY_URL}?${CANON}&vnp_SecureHash=${SIGNATURE}"

  # 👉 Thêm in ra và lưu lại CreateDate
  echo
  echo "======================================================"
  echo "Payment URL:"
  echo "$PAYMENT_URL"
  echo
  echo "PAY_CREATE_DATE=$CREATE_DATE"
  echo "→ Dùng giá trị này cho querydr/refund:"
  echo "   PAY_CREATE_DATE=$CREATE_DATE ./vnp.sh querydr"
  echo "======================================================"

  # Lưu lại để dùng tự động lần sau
  echo "$CREATE_DATE" > .last_create_date
}

# ========== 2) QUERY TRANSACTION RESULT (querydr) ==========
# Tài liệu & quy tắc checksum: data = vnp_RequestId|vnp_Version|vnp_Command|vnp_TmnCode|vnp_TxnRef|vnp_TransactionDate|vnp_CreateDate|vnp_IpAddr|vnp_OrderInfo  (SHA512 HMAC) :contentReference[oaicite:1]{index=1}
querydr() {
  local REQUEST_ID="QDR-$(now_ymdhms)-$(rand_suffix)"
  local CREATE_DATE_REQ="$(now_ymdhms)"                 # thời điểm tạo request querydr
  # LƯU Ý: vnp_TransactionDate phải là thời điểm bạn tạo giao dịch PAY ban đầu (vnp_CreateDate khi pay)
  # Để test nhanh, bạn có thể tạm dùng cùng thời điểm hoặc truyền vào qua biến môi trường
  local TRANSACTION_DATE="${PAY_CREATE_DATE:-$CREATE_DATE_REQ}"

  local DATA_STR="${REQUEST_ID}|${VERSION}|querydr|${TMN}|${TXN_REF}|${TRANSACTION_DATE}|${CREATE_DATE_REQ}|${IP_ADDR}|${ORDER_INFO}"
  local SECURE_HASH
  SECURE_HASH="$(printf '%s' "$DATA_STR" | openssl dgst -sha512 -hmac "$SECRET" | sed 's/^.* //')"

  # Body JSON đúng chuẩn
  local JSON_BODY
  JSON_BODY=$(cat <<EOF
{
  "vnp_RequestId": "${REQUEST_ID}",
  "vnp_Version": "${VERSION}",
  "vnp_Command": "querydr",
  "vnp_TmnCode": "${TMN}",
  "vnp_TxnRef": "${TXN_REF}",
  "vnp_TransactionDate": "${TRANSACTION_DATE}",
  "vnp_CreateDate": "${CREATE_DATE_REQ}",
  "vnp_IpAddr": "${IP_ADDR}",
  "vnp_OrderInfo": "${ORDER_INFO}",
  "vnp_SecureHash": "${SECURE_HASH}"
}
EOF
)

  echo "[QUERYDR] Request JSON:"
  echo "${JSON_BODY}"

  echo
  echo "[QUERYDR] Response:"
  curl -sS -X POST "https://sandbox.vnpayment.vn/merchant_webapi/api/transaction" \
    -H "Content-Type: application/json" \
    -d "${JSON_BODY}" | jq -r .
}

# ========== 3) REFUND (refund) ==========
# Quy tắc checksum refund: data = vnp_RequestId|vnp_Version|vnp_Command|vnp_TmnCode|vnp_TransactionType|vnp_TxnRef|vnp_Amount|vnp_TransactionNo|vnp_TransactionDate|vnp_CreateBy|vnp_CreateDate|vnp_IpAddr|vnp_OrderInfo  (SHA512 HMAC) :contentReference[oaicite:2]{index=2}
# Lưu ý: Sandbox có thể hạn chế refund, cần liên hệ VNPAY để bật quyền nếu bị từ chối (tài liệu cộng đồng cũng lưu ý điều này). :contentReference[oaicite:3]{index=3}
refund() {
  local REQUEST_ID="RFD-$(now_ymdhms)-$(rand_suffix)"
  local CREATE_DATE_REQ="$(now_ymdhms)"
  local TRANSACTION_DATE="${PAY_CREATE_DATE:-$CREATE_DATE_REQ}"   # thời điểm bạn tạo PAY
  local CREATE_BY="${REFUND_BY:-tester}"                          # người khởi tạo hoàn tiền (username)
  local REFUND_TYPE="${REFUND_TYPE:-02}"                          # 02: toàn phần, 03: một phần
  local REFUND_AMOUNT_MULT=$(( ${REFUND_AMOUNT_VND:-$AMOUNT_VND} * 100 ))
  local VNP_TRANSACTION_NO="${VNP_TRANSACTION_NO:-}"              # nếu có mã giao dịch tại VNPAY

  local DATA_STR="${REQUEST_ID}|${VERSION}|refund|${TMN}|${REFUND_TYPE}|${TXN_REF}|${REFUND_AMOUNT_MULT}|${VNP_TRANSACTION_NO}|${TRANSACTION_DATE}|${CREATE_BY}|${CREATE_DATE_REQ}|${IP_ADDR}|${ORDER_INFO}"
  local SECURE_HASH
  SECURE_HASH="$(printf '%s' "$DATA_STR" | openssl dgst -sha512 -hmac "$SECRET" | sed 's/^.* //')"

  local JSON_BODY
  JSON_BODY=$(cat <<EOF
{
  "vnp_RequestId": "${REQUEST_ID}",
  "vnp_Version": "${VERSION}",
  "vnp_Command": "refund",
  "vnp_TmnCode": "${TMN}",
  "vnp_TransactionType": "${REFUND_TYPE}",
  "vnp_TxnRef": "${TXN_REF}",
  "vnp_Amount": ${REFUND_AMOUNT_MULT},
  "vnp_TransactionNo": "${VNP_TRANSACTION_NO}",
  "vnp_TransactionDate": "${TRANSACTION_DATE}",
  "vnp_CreateBy": "${CREATE_BY}",
  "vnp_CreateDate": "${CREATE_DATE_REQ}",
  "vnp_IpAddr": "${IP_ADDR}",
  "vnp_OrderInfo": "Refund: ${ORDER_INFO}",
  "vnp_SecureHash": "${SECURE_HASH}"
}
EOF
)

  echo "[REFUND] Request JSON:"
  echo "${JSON_BODY}"

  echo
  echo "[REFUND] Response:"
  curl -sS -X POST "https://sandbox.vnpayment.vn/merchant_webapi/api/transaction" \
    -H "Content-Type: application/json" \
    -d "${JSON_BODY}" | jq -r .
}

# ========== CLI ==========
usage() {
  cat <<'U'
Usage:
  ./vnp.sh pay-url                      # tạo payment URL
  PAY_CREATE_DATE=YYYYMMDDhhmmss ./vnp.sh querydr
  PAY_CREATE_DATE=YYYYMMDDhhmmss \
    REFUND_BY=admin REFUND_TYPE=02 REFUND_AMOUNT_VND=275000 VNP_TRANSACTION_NO=12345678 \
    ./vnp.sh refund

Ghi chú:
- PAY_CREATE_DATE phải khớp vnp_CreateDate của lệnh pay ban đầu (định dạng yyyyMMddHHmmss).
- REFUND_TYPE: 02 = hoàn toàn phần, 03 = hoàn một phần.
- REFUND_AMOUNT_VND mặc định = AMOUNT_VND ở trên.
- Một số tài khoản sandbox có thể bị hạn chế refund, cần được VNPAY cấp quyền để test. 
U
}

cmd="${1:-}"
case "$cmd" in
  pay-url) create_pay_url ;;
  querydr) querydr ;;
  refund)  refund ;;
  *) usage; exit 1 ;;
esac
