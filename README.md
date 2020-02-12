# Microservices with SpringCloud

## Architecture

The following diagram shows the application architecture:

TODO :

###### tutorial http://rcherara.ca/posts/microservice-with-springcloud

include module:
* discovery-service
* gateway-service
* config-service
* config
* vehicle-service
* reservation-client
* hystrix-dashboard
* monitor
* zipkin
* auth-server

## Building and running the application

This is a Maven project. However, you do not need to install Gradle since it will be downloaded automatically. You just need to have Java 11 installed.

The details of how to build and run the services depend slightly on whether you are using  SaaS or Local.

## Building and running using SaaS

First, must sign up to get your credentials in order to get free access to the SaaS version.

Next, build the application

cd java-server
./gradlew assemble

Next, you can launch the services using Docker Compose:

cd java-server/docker-microservices
docker-compose up -d

# Using the Swagger UI

The services are Swagger "enabled".

Open the url http://${DOCKER_HOST_IP}:<SERVICE-PORT>/swagger-ui.html
  
All Swagger Resources(groups) : http://localhost:<SERVICE-PORT>/swagger-resources
Swagger UI endpoint: http://localhost:<SERVICE-PORT>swagger-ui.html
Swagger docs endpoint: http://localhost:<SERVICE-PORT>/v2/api-docs

# Monitor the services configuration 
  
- dealership-service

curl -s http://localhost:8888/monitor/dealership-service | jq '.'

- discovery-service

curl -s http://localhost:8888/monitor/discovery-service | jq '.'

- gateway-service

curl -s http://localhost:8888/monitor/gateway-service | jq '.'

- proxy-service

curl -s http://localhost:8888/monitor/proxy-service | jq '.'

- transaction-service

curl -s http://localhost:8888/monitor/transaction-service | jq '.'

- vehicle-service.yml

curl -s http://localhost:8888/monitor/vehicle-service | jq '.'
  
# Hystrix Dashboard
To run locally:

mvn install
java -jar target/hystrix-dashboard-0.0.1.BUILD-SNAPSHOT.jar

### Guides
The following guides illustrate how to use some features concretely:

* [Centralized Configuration](https://spring.io/guides/gs/centralized-configuration/)
* 
* 
* 

### Reference

1. [Pattern: Microservice Architecture](https://microservices.io/patterns/microservices.html/)
2. [Spring Cloud Tutorial - Spring Cloud Gateway Hello World Example](https://www.javainuse.com/spring/cloud-gateway)
3. [Installing minishift on macos – Cherara Reddag blog](rcherara.ca/installing-minishift-on-macos/)
4. [About Spring cloud security OAuth2](http://blog.spring-cloud.io/blog/oauth-authorize.html)
5. [Dive into Eureka – nobodyiam's blog](http://nobodyiam.com/2016/06/25/dive-into-eureka/)
6. [About Spring cloud security OAuth2](http://blog.spring-cloud.io/blog/oauth-authorize.html)

# Got questions?

Don't hesitate to create an issue or contact me.

# Author

Cherara Reddah 
