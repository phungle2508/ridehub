#!/usr/bin/env bash
set -e
cd backend

# Map microservices -> DB/HTTP ports
declare -A DB_PORTS=(
  [ms_route]=3307
  [ms_user]=3308
  [ms_booking]=3309
  [ms_promotion]=3310
  # [ms_payment]=3310
  # [ms_notification]=3311
)

declare -A APP_PORTS=(
  [ms_route]=8082
  [ms_user]=8083
  [ms_booking]=8084
  [ms_promotion]=8085
  # [ms_payment]=8085
  # [ms_notification]=8086
)

# Loop over services and update application-dev.yml
for ms in "${!DB_PORTS[@]}"; do
  yml="$ms/src/main/resources/config/application-dev.yml"
  if [[ -f "$yml" ]]; then
    echo "Updating $yml ..."
    
    # Update server and sql ports
    sed -i \
      -e "s/port: .*/port: \${SERVER_PORT:${APP_PORTS[$ms]}}/" \
      -e "s/sql-port: .*/sql-port: \${SQL_PORT:${DB_PORTS[$ms]}}/" \
      "$yml"
  else
    echo "⚠️  Skipping $ms (no $yml found)"
  fi
done

echo "✅ All application-dev.yml updated!"
