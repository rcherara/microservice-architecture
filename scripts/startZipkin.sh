#!/bin/bash
echo "Starting Zipkin Trace Server."

docker container stop zipkinServer && docker container rm zipkinServer
docker run -d -p 9411:9411 --name zipkinServer openzipkin/zipkin
docker container ls

echo "Zipkin should be available under: http://localhost:9411. Opening browser..."
sleep 3
open http://localhost:9411