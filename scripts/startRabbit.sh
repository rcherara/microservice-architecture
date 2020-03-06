#!/bin/bash
echo "Starting Rabbit MQ message broker."
docker container stop rabbitBroker && docker container rm rabbitBroker
docker run -d --hostname my-rabbit --name rabbitBroker -p 15672:15672 -p 5672:5672 rabbitmq:3-management
docker container ls

echo "Rabbit should be available under: http://localhost:15672. Opening browser..."
sleep 3
open http://localhost:15672