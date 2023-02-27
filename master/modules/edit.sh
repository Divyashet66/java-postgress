#!/bin/bash 
json=$(cat master/modules/input.json)

VM_IP=$(echo $json | jq -r '.VM_IP')
github_url=$(echo $json | jq -r '.Github_url')
branch=$(echo $json | jq -r '.Branch')
job_name=$(echo $json | jq -r '.Job_Name')

sed -i "s/IP_Address/$VM_IP/g" master/modules/inventories/hosts

sed -i "s#Github_url#$github_url#g" master/modules/create-job/config.xml

sed -i "s/Branch_Name/$branch/g" master/modules/create-job/config.xml

sed -i "s/Job_Name/$job_name/g" master/modules/create-job/job.yaml


