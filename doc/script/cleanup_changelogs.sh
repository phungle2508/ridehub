#!/bin/bash

# Script to clean up changelog files from all microservices
# Keeps initial schema and newest version of each unique entity (ignoring timestamps)

echo "Cleaning up changelog files from all microservices..."
echo "Removing duplicate entities, keeping only newest version of each..."
echo "=================================================="

# Loop through all ms_* directories in backend folder
for ms_dir in backend/ms_*; do
    if [ -d "$ms_dir" ]; then
        changelog_path="$ms_dir/src/main/resources/config/liquibase/changelog"
        
        if [ -d "$changelog_path" ]; then
            echo "Processing: $(basename "$ms_dir")"
            
            # Change to the changelog directory
            cd "$changelog_path"
            
            # Find all XML files
            all_files=$(ls *.xml 2>/dev/null)
            
            if [ -n "$all_files" ]; then
                # Always keep the initial schema file
                initial_schema="00000000000000_initial_schema.xml"
                
                # Find other files (excluding the initial schema)
                other_files=$(ls *.xml 2>/dev/null | grep -v "00000000000000_initial_schema.xml")
                
                if [ -n "$other_files" ]; then
                    echo "  Analyzing duplicates..."
                    
                    # Create associative array to track newest version of each entity
                    declare -A newest_entity_files
                    
                    # Process each file to extract entity name and find newest
                    for file in $other_files; do
                        # Extract entity name (everything after timestamp and before .xml)
                        entity_name=$(echo "$file" | sed 's/^[0-9_]*//g' | sed 's/\.xml$//')
                        
                        # If this entity hasn't been seen or this file is newer, update
                        if [[ -z "${newest_entity_files[$entity_name]}" ]] || [[ "$file" > "${newest_entity_files[$entity_name]}" ]]; then
                            newest_entity_files["$entity_name"]="$file"
                        fi
                    done
                    
                    # Show what we're keeping
                    echo "  Keeping files:"
                    echo "    - $initial_schema"
                    for entity in "${!newest_entity_files[@]}"; do
                        echo "    - ${newest_entity_files[$entity]} (newest version of: $entity)"
                    done
                    
                    echo "  Removing duplicate files:"
                    
                    # Remove files that are not the newest version of their entity
                    removed_count=0
                    for file in $other_files; do
                        entity_name=$(echo "$file" | sed 's/^[0-9_]*//g' | sed 's/\.xml$//')
                        
                        # If this file is not the newest version of this entity, remove it
                        if [[ "$file" != "${newest_entity_files[$entity_name]}" ]]; then
                            echo "    - $file (older version of: $entity_name)"
                            rm "$file"
                            ((removed_count++))
                        fi
                    done
                    
                    if [ $removed_count -eq 0 ]; then
                        echo "    (no duplicates found)"
                    fi
                    
                    echo "  Removed $removed_count duplicate files"
                else
                    echo "  Only initial schema file found, nothing to clean up."
                fi
            else
                echo "  No XML files found"
            fi
            
            # Go back to original directory
            cd - > /dev/null
            echo ""
        else
            echo "Changelog directory not found in: $(basename "$ms_dir")"
            echo ""
        fi
    fi
done

echo "Cleanup completed!"

# One-liner version (complex):
# for ms in backend/ms_*; do echo "=== $(basename $ms) ==="; cd "$ms/src/main/resources/config/liquibase/changelog" 2>/dev/null && { others=$(ls *.xml | grep -v "00000000000000_initial_schema.xml"); declare -A newest; for f in $others; do entity=$(echo "$f" | sed 's/^[0-9_]*//g' | sed 's/\.xml$//'); if [[ -z "${newest[$entity]}" ]] || [[ "$f" > "${newest[$entity]}" ]]; then newest["$entity"]="$f"; fi; done; for f in $others; do entity=$(echo "$f" | sed 's/^[0-9_]*//g' | sed 's/\.xml$//'); if [[ "$f" != "${newest[$entity]}" ]]; then echo "REMOVE: $f"; rm "$f"; fi; done; ls *.xml; cd - > /dev/null; } || echo "No changelog dir"; done