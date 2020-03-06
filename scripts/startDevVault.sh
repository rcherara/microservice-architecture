#!/bin/bash
echo "Starting Hashicorp Vault for Development purposes. DON'T use for production purposes!"

docker container stop dev-vault && docker container rm dev-vault
docker run --cap-add=IPC_LOCK -d --name=dev-vault -e VAULT_DEV_ROOT_TOKEN_ID=root -p 8200:8200 vault 
docker container ls

echo "Vault should be available under: http://localhost:8200. Opening browser..."
sleep 2
open http://localhost:8200