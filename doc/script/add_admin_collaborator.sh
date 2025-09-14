#!/bin/bash

COLLAB="phungle2508"
OWNER="maian3333"
PERMISSION="admin"

REPOS=(
    "gateway"
    "ms_user"
    "ms_payment" 
    "ms_notification"
    "ms_route"
    "ms_booking"
    "vps-infra"
    "vps-microservices"
)

for repo in "${REPOS[@]}"; do
    echo "Adding $COLLAB to $OWNER/$repo..."
    gh api --method PUT --field permission="$PERMISSION" repos/"$OWNER"/"$repo"/collaborators/"$COLLAB"
    echo "✅ Done: $repo"
done