#!/bin/bash

COLLAB="phungle2508"
OWNER="LeTrungMiniuh"
PERMISSION="admin"

REPOS=(
    "gateway"
    "ms_user"
    "ms_promotion" 
    "ms_route"
    "ms_booking"
    "ridehub-central-config"
    "ridehub-central-common"
    # "vps-infra"
    # "vps-microservices"
)

for repo in "${REPOS[@]}"; do
    echo "Adding $COLLAB to $OWNER/$repo..."
    gh api --method PUT --field permission="$PERMISSION" repos/"$OWNER"/"$repo"/collaborators/"$COLLAB"
    echo "✅ Done: $repo"
done