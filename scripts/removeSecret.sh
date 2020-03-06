echo "Usage: $0 <key>"
echo "Removing secret 'secret/$1'."
docker exec -it -e VAULT_ADDR='http://0.0.0.0:8200' -e VAULT_TOKEN=root dev-vault vault kv metadata delete secret/$1