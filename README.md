# Microservices with SpringCloud

## Architecture

The following diagram shows the application architecture:

TODO :

* Client-side Discovery pattern or Server-side Discovery pattern to route requests to available service instances.
* The API Gateway authenticate the user and pass an Access Token containing information about the user to the services
* API Gateway  use a Circuit Breaker to invoke services
* API gateway often implements the API Composition pattern
* Asynchronous Java API + Reactive Programming Model
* Hystrix Fault Tolerance.

The architecture supports the following technologies: 
  * Frameworks - Spring Boot and Micronaut
  * Databases - MySQL, Postgres, and Microsoft SQL server
  * Message brokers - Apache Kafka, ActiveMQ, RabbitMQ, and Redis Streams
  * Services communicate asynchronously using domain events, and command/reply messages.

###### tutorial http://rcherara.ca/microservices-with-spring-cloud/

Include module:

* discovery-service
* gateway-service
* config-service
* config
* vehicle-service
* dealership-service
* transaction-client
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
Swagger UI endpoint: http://localhost:<SERVICE-PORT>/swagger-ui.html
Swagger docs endpoint: http://localhost:<SERVICE-PORT>/v2/api-docs

# Monitor services configuration 
- Dealership-service   : curl -s http://localhost:<SERVICE-PORT>/monitor/dealership-service | jq '.'
- Discovery-service.   : curl -s http://localhost:<SERVICE-PORT>/monitor/discovery-service | jq '.'
- Gateway-service.     : curl -s http://localhost:<SERVICE-PORT>/monitor/gateway-service | jq '.'
- Transaction-service. : curl -s http://localhost:<SERVICE-PORT>/monitor/transaction-service | jq '.'
- Vehicle-service.yml. : curl -s http://localhost:<SERVICE-PORT>/monitor/vehicle-service | jq '.'

# Vehicle service
To run locally:
mvn install
java -jar target/vehicle-service-0.0.1.BUILD-SNAPSHOT.jar

# Dealership service
To run locally:
mvn install
java -jar target/dealership-service-0.0.1.BUILD-SNAPSHOT.jar

# Gateway service
To run locally:
mvn install
java -jar target/gateway-service-0.0.1.BUILD-SNAPSHOT.jar

# Discovery
To run locally:
mvn install
java -jar target/discovery-service-0.0.1.BUILD-SNAPSHOT.jar

# Hystrix Dashboard
To run locally:
mvn install
java -jar target/hystrix-dashboard-0.0.1.BUILD-SNAPSHOT.jar


### Guides
The following guides illustrate how to use some features concretely:
* [Pattern: API Gateway / Backends for Frontends](https://microservices.io/patterns/apigateway.html)
* [Pattern: Microservice Architecture](https://microservices.io/patterns/microservices.html/)
* [Centralized Configuration](https://spring.io/guides/gs/centralized-configuration/)
* [Event-Driven Data Management for Microservices] : (https://www.nginx.com/blog/event-driven-data-management-microservices/)
* [Asynchronous microservices](http://eventuate.io/whyeventdriven.html)

### Reference
1. [Pattern: Microservice Architecture](https://microservices.io/patterns/microservices.html/)
2. [Spring Cloud Tutorial - Spring Cloud Gateway Hello World Example](https://www.javainuse.com/spring/cloud-gateway)
3. [Installing minishift on macos – Cherara Reddag blog](rcherara.ca/installing-minishift-on-macos/)
4. [About Spring cloud security OAuth2](http://blog.spring-cloud.io/blog/oauth-authorize.html)
5. [Dive into Eureka – nobodyiam's blog](http://nobodyiam.com/2016/06/25/dive-into-eureka/)
6. [About Spring cloud security OAuth2](http://blog.spring-cloud.io/blog/oauth-authorize.html)

### Got questions?
Don't hesitate to create an issue or contact me.

### Author
CHERARA REDDAH.
[Cherara Reddah linkedin](https://www.linkedin.com/in/cherarareddah/)
[Cherara Reddah blog](https://rcherara.ca)

