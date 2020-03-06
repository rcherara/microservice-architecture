#!/bin/bash
echo "Usage: $0 <secret> <key>=<value>"
echo "Adding secret '$2' to secret/$1."
docker exec -it -e VAULT_ADDR='http://0.0.0.0:8200' -e VAULT_TOKEN=root dev-vault vault kv put secret/$1 $2