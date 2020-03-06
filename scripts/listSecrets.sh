#!/bin/bash
echo "Listing Secrets in vault..."
docker exec -it -e VAULT_ADDR='http://0.0.0.0:8200' -e VAULT_TOKEN=root dev-vault vault secrets list