
#!/bin/bash

# A script to refresh a service using its /actuator/refresh endpoint.

if [ "$1" = "--help" ];
then
  echo "Usage: $0 <service-base-url>"
  echo "Example: $0 http://localhost:1111"
else
  echo "Service Base URL: '$1'"
  echo "POSTing to: '$1/actuator/refresh'"
  curl -X POST $1/actuator/refresh
fi