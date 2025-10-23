#!/bin/bash

# Script to set up repositories under maian3333 account
# This script should be run after creating the repositories manually

echo "Setting up RideHub repositories under maian3333 account..."

# Services to push
services=(
    "gateway:ridehub-gateway"
    "ms_booking:ridehub-ms-booking" 
    "ms_promotion:ridehub-ms-promotion"
    "ms_route:ridehub-ms-route"
    "ms_user:ridehub-ms-user"
)

# Base directory
base_dir="/home/phungvip/Desktop/work-space/ridehub-phungle/backend"

for service_info in "${services[@]}"; do
    IFS=':' read -r service_dir repo_name <<< "$service_info"
    service_path="$base_dir/$service_dir"
    
    echo "Processing $service_dir -> $repo_name..."
    
    if [ -d "$service_path" ]; then
        cd "$service_path"
        
        # Check if it's already a git repo
        if [ -d ".git" ]; then
            echo "Updating remote URL for $service_dir..."
            git remote set-url origin "https://github.com/maian3333/$repo_name.git"
            
            echo "Pushing $service_dir to maian3333/$repo_name..."
            git push -u origin main
        else
            echo "Initializing git repo for $service_dir..."
            git init
            git add .
            git commit -m "Initial commit - $service_dir service"
            git branch -M main
            git remote add origin "https://github.com/maian3333/$repo_name.git"
            git push -u origin main
        fi
        
        echo "✅ $service_dir setup complete"
    else
        echo "❌ Directory $service_path not found"
    fi
    
    echo ""
done

echo "🎉 All services have been pushed to maian3333 account!"
echo ""
echo "Next steps:"
echo "1. Run this script after creating the repositories on GitHub"
echo "2. Update submodules in main repo:"
echo "   cd /home/phungvip/Desktop/work-space/ridehub-phungle"
echo "   git submodule sync"
echo "   git submodule update --init --recursive"
echo "   git add .gitmodules"
echo "   git commit -m 'Update submodule URLs to maian3333 account'"
echo "   git push origin main"