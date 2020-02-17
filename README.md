
![Java CI](https://github.com/Reddah-Cherara/building-a-microservice-architecture/workflows/Java%20CI/badge.svg?branch=master)

# Best Practices of a Microservice Architecture with Spring Cloud, CI, CD and IaC


This example is an eco-system  for a car dealer based on a microservices architecture.

The architecture supports the following technologies: 

  * Frameworks - Spring Boot, Spring Cloud and Resilience4j.
  * Databases - H2, MySQL, Postgres, and MongoDB
  * Message brokers - Apache Kafka, RabbitMQ, and Redis Streams
  * Services communicate asynchronously using domain events, and command/reply messages.
  * Pivotal Cloud Foundry (PCF) AWS, Azure, Google Compute Platform (GCP), OpenStack, VMware vSphere, SoftLayer
  * IaC on AWS, GCP or .

# The Key Requirements

  * Maximize team autonomy.
  * Optimize for development speed.
  * Focus on automation (Automate everything).
  * Provide flexibility without compromising consistency.
  * Built for resilience.
  * Simplified maintenance.
  * Application portability.
  * Application auto-scaling.
  * Centralized platform administration.
  * Centralized logging.
  * Dynamic routing.
  * Application health management.
  * Integration with external logging components like Elasticsearch and Logstash.
  * Role-based access for deployed applications.
  * Provision for vertical and horizontal scaling.
  * Infrastructure security.
  * Support for various IaaS providers.

# Twelve-factor application guide
• Codebase. One codebase tracked in VCS, many deploys. One app has a single code base and its tracked by a version control system like Git, Subversion, Mercurial, etc. You can do many deployments (from the same code base) to development, testing, staging and production environments.
• Dependencies. Explicity declare and isolate dependencies. Some times your environments don’t have internect connection (if is a private system), so you need to think about packaging your dependencies (jars, gems, shared-libraries, etc) or if you have an internal repository of libraries, you can declared manifest like poms, gemfile, bundles, etc. Never rely that you will have everything in your final environment.
• Configuration. Store config in the environment. You should’t hardcode anything that varies. Use the environment variables or a configuration server.
• Backing Services. Treat backing services as attached resources. Connect to services via URL or configuration.
• Build, Release, Run. Strictly separate build and run stages. Related to a CI/CD (Continuous Integration, Continuous Delivery)
• Processes. Execute the app as one or more stateless processes. Processess should not store internal state. Share nothing. Any necessary state should be considered as a Backing Service.
• Port binding. Export services via port port binding. Your application is self-container, and these apps are exposed via port binding. An application can become another App’ service.
• Concurrency. Scale out via the process model. Scale by adding more application instances. Individual processes are free to multithread.
• Disposability. Maximize robustness with fast startup and graceful shutdown. Processes should be disposable (remember they are stateless). Fault tolerant.
• Environment parity. Keep development, staging and production environments as similar as possible. This is a result of High Quality, ensures continuous delivery.
• Logs. Treat logs as event streams. Your apps should write to stdout. Logs are streams of aggregated, time-ordered events.
• Admin processes. Run admin and managemenr tasks as one-off processes. Run admin processes on the platform: DB migrations, one time scripts, etc.

# Architecture
The following diagram shows the targert platform architecture.


NOTE : 
  TODO :  Adding diagram here. ༼ つ ◕_◕ ༽つ

Since an auto dealership application uses the Microservice architecture pattern for vehicle details data is spread over multiple services. For example,

- Vehicle Service - basic information about the vehicle, 
- Transaction service - purchase history for vehicle, vehicle price
- Dealership service - vehicle availability,Order processing, stock

Consequently, the code that displays the vehicle details needs to fetch information from all of these services.

Each service is:

:small_orange_diamond: Highly maintainable and testable - enables rapid and frequent development and deployment.
:small_orange_diamond: Loosely coupled with other services - enables a team to work independently the majority of time on their service(s) without being impacted by changes to other services and without affecting other services.
:small_orange_diamond: Independently deployable - enables a team to deploy their service without having to coordinate with other teams :small_orange_diamond: Capable of being developed by a small team - essential for high productivity by avoiding the high communication head of large teams. :small_orange_diamond: Services communicate using either synchronous protocols such as HTTP/REST or asynchronous protocols such as AMQP. :small_orange_diamond: Services can be developed and deployed independently of one another. :small_orange_diamond: Each service has its own database in order to be decoupled from other services. :small_orange_diamond: Data consistency between services is maintained using the Saga pattern. :small_orange_diamond: Client-side Discovery pattern or Server-side Discovery pattern to route requests to available service instances. :small_orange_diamond: The API Gateway authenticate the user and pass an Access Token containing information about the user to the services :small_orange_diamond: API Gateway  use a Circuit Breaker to invoke services :small_orange_diamond: API gateway often implements the API Composition pattern. :small_orange_diamond: Asynchronous Java API + Reactive Programming Model. :small_orange_diamond: Hystrix Fault Tolerance.

###### Tutorial http://rcherara.ca/microservices-with-spring-cloud/


# Using patterns

- Service Discovery & Service Registry : Eureka
- Load balancing : Spring Cloud Loadbalancer
- Reliability (Circuit Breaker) :  Resilience4j
- Fault-tolerance : 
- API Gateway 	: Spring Cloud Gateway
- Externalized configuration  : Spring Cloud Config
- Security : Access Token
- Observability : 
  - Log aggregation : AWS Cloud Watch
  - Application metrics - instrument a service’s code to gather statistics about operations
  - Audit logging - record user activity in a database
  - Distributed tracing - Zipkin, Sleuth and ELK Stack
  - Exception tracking - Sentry, TrackJS, Raygun and Airbrake.
  - Health check API : EurekaClient, Spring Boot Admin and Spring Boot Actuator
  - Log deployments and changes : GitHub, AWS CloudTrail and LogDNA.
- Deployment patterns : 
  - Service instance per Container - Dockerfile and DockerComposite
  - Serverless deployment - deploy a service using serverless deployment platform
  - Service deployment platform - deploy services using a highly automated deployment platform that provides a service abstraction
- Transactional messaging:
- Data management : 
  - Database per Service - each service has its own private database
  - Domain event - publish an event whenever data changes
  - Event sourcing - persist aggregates as a sequence of events

NOTE : 
  Resilience4J is a standalone library inspired by Hystrix but build on the principles of Functional Programming. 
NOTE :
 Continuous integration and continuous deployment (CI/CD) has enabled teams to build and deploy software at a much faster pace. DevOps teams can build, test, and deploy changes to production in a matter of minutes, allowing for extremely rapid release cycles. However, a CI/CD pipeline has a lot of moving parts and steps where problems to occur. In order to ensure a successful deployment, it’s important to monitor each step in this process.

## Building and running the application

This is a Maven project. However, you  need to have Java 11, Docker,and Maven installed.

The details of how to build and run the services depend slightly on whether you are using  
  - SaaS (Software as a Service)
  - IaaS (Infrastructure as a service)
  - PaaS (Platform as a Service)
  - Local.

## Building and running using SaaS

First, must sign up to get your credentials in order to get free access to the SaaS version.

Next, build the application

```
git clone https://github.com/Reddah-Cherara/rcherara-spring-cloud-microservice.git
cd rcherara-spring-cloud-microservice
mvn install
```

Next, you can launch the services using Docker Compose:

```
 $ docker-compose up -d
```
# Modules:

- [x] config-service
- [x] discovery-service
- [x] gateway-service
- [x] config-repo
- [x] vehicle-service
- [x] dealership-service
- [x] transaction-service
- [X] monitor-dashboard
- [ ] DockerFiles
- [ ] JenkinsFiles
- [ ] CI/CD
- [ ] Auth-server
- [ ] IaC

## Spring Cloud Config Server

Spring Cloud Config Server offers the following benefits:

HTTP resource-based API for external configuration (name-value pairs or equivalent YAML content)

Encrypt and decrypt property values (symmetric or asymmetric)

Embeddable easily in a Spring Boot application using @EnableConfigServer

## Spring Cloud Config Client
Spring Cloud Config Client lets you:

- Bind to the Config Server and initialize Spring Environment with remote property sources.

- Encrypt and decrypt property values (symmetric or asymmetric).

- @RefreshScope for Spring @Beans that want to be re-initialized when configuration changes.

Use management endpoints:

  - /env for updating Environment and rebinding @ConfigurationProperties and log levels.
  - /refresh for refreshing the @RefreshScope beans.
  - /restart for restarting the Spring context (disabled by default).
  - /pause and /resume for calling the Lifecycle methods (stop() and start() on the ApplicationContext).

Bootstrap application context: It binds to the Config Server and decrypts property values.

## Using the Swagger UI
The services are Swagger "enabled".
Open the url http://${DOCKER_HOST_IP}:<SERVICE-PORT>/swagger-ui.html
All Swagger Resources(groups) : http://localhost:<SERVICE-PORT>/swagger-resources
Swagger UI endpoint: http://localhost:<SERVICE-PORT>/swagger-ui.html
Swagger docs endpoint: http://localhost:<SERVICE-PORT>/v2/api-docs

## Monitor services configuration 
- Dealership-service   : curl -s http://localhost:<SERVICE-PORT>/monitor/dealership-service | jq '.'
- Discovery-service.   : curl -s http://localhost:<SERVICE-PORT>/monitor/discovery-service | jq '.'
- Gateway-service.     : curl -s http://localhost:<SERVICE-PORT>/monitor/gateway-service | jq '.'
- Transaction-service. : curl -s http://localhost:<SERVICE-PORT>/monitor/transaction-service | jq '.'
- Vehicle-service.yml. : curl -s http://localhost:<SERVICE-PORT>/monitor/vehicle-service | jq '.'

## Vehicle service
To run locally:
```
mvn install
java -jar target/vehicle-service-0.0.1.BUILD-SNAPSHOT.jar
```
## Dealership service
To run locally:
```
mvn install
java -jar target/dealership-service-0.0.1.BUILD-SNAPSHOT.jar
```

## Gateway service
To run locally:
```
mvn install
java -jar target/gateway-service-0.0.1.BUILD-SNAPSHOT.jar
```

## Discovery
To run locally:
```
mvn install
java -jar target/discovery-service-0.0.1.BUILD-SNAPSHOT.jar
```

### DiscoveryClient 

"The Gateway can be configured to create routes based on services registered with a DiscoveryClient compatible service registry. To enable this, set spring.cloud.gateway.discovery.locator.enabled=true and make sure a DiscoveryClient implementation is on the classpath and enabled (such as Netflix Eureka, Consul or Zookeeper)."

This properties doesn't work with Kubernate configuration Service Discovery. Changed it to False and it worked!! 


# Guides
The following guides illustrate how to use some features concretely:
* [Pattern: API Gateway / Backends for Frontends](https://microservices.io/patterns/apigateway.html)
* [Pattern: Microservice Architecture](https://microservices.io/patterns/microservices.html/)
* [Centralized Configuration](https://spring.io/guides/gs/centralized-configuration/)
* [Event-Driven Data Management for Microservices](https://www.nginx.com/blog/event-driven-data-management-microservices/)
* [Asynchronous microservices](http://eventuate.io/whyeventdriven.html)

## Reference
1.  [Microservice Architecture](https://microservices.io/patterns/microservices.html)
2.  [Spring Cloud Gateway](https://cloud.spring.io/spring-cloud-gateway/reference/html/)
3.  [Minishift– Cherara Reddag blog](rcherara.ca/installing-minishift-on-macos/)
4.  [About Spring cloud security OAuth2](http://blog.spring-cloud.io/blog/oauth-authorize.html)
5.  [Dive into Eureka – nobodyiam's blog](http://nobodyiam.com/2016/06/25/dive-into-eureka/)
6.  [About Spring cloud security OAuth2](http://blog.spring-cloud.io/blog/oauth-authorize.html)
7.  [Synthesis-Based Software Architecture Design](https://slideplayer.com/slide/1672922/)
8.  [OAuth 2.0 Login](https://docs.spring.io/spring-security/site/docs/5.2.x/reference/htmlsingle/#oauth2login)
9.  [OAuth 2.0 Resource Server](https://docs.spring.io/spring-security/site/docs/5.2.x/reference/htmlsingle/#oauth2resourceserver)
10. [Spring Cloud Security](https://cloud.spring.io/spring-cloud-static/spring-cloud-security/2.2.0.M3/reference/html/)
11. [Spring Cloud Config Server](https://cloud.spring.io/spring-cloud-config/multi/multi__spring_cloud_config_server.html)
12. [Spring Cloud](https://spring.io/projects/spring-cloud)
13. [The Twelve Factors](https://12factor.net)
14. [Maximize Observability of your CI/CD Pipeline with LogDNA](https://logdna.com/maximize-observability-of-your-ci-cd-pipeline-with-logdna/)


## Got questions?

### Author
CHERARA REDDAH.

* [Cherara Reddah linkedin](https://www.linkedin.com/in/cherarareddah/)
* [Cherara Reddah blog](https://rcherara.ca)