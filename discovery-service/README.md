
# Discovery Service

# Description

This project contains the sample code used in XXXXXX. It's a Spring Boot application .

The main goal of the project is to show how to  XXXX in Spring Boot and include documentation with Swagger.


# How does it work?

You can use the endpoints behind http://localhost:8080/. If you append /random to a GET request you'll receive a random Spanish greeting (which are actually hard-coded). You can also GET them by id (only from 1 to 3). To create a new one, you need to perform a POST operation.

Actually, much better if you just start the application and navigate to http://localhost:8080/swagger-ui.html. There you'll find a nice API documentation thanks to Swagger. Moreover, you can play with it.


# Spring Boot Service Discovery with Eureka Peer Awareness
## Simplified Logical View

https://github.com/mechero/spring-boot-eureka/blob/master/img/eureka_springboot.png

# Eureka Registry Cluster via enabling Peer Awareness
## Preparing your system to test it

Before you execute this application you need an extra step though. As pointed out before, the Peer Awareness feature won’t work if you use the same hostname. We set them to eureka-peer1 and eureka-peer2 in our configuration, but we need to redirect those aliases to our real local host for that to work on our machine.

In windows, you need to modify your hosts file and add a couple of lines like these (note that you usually need administrator privileges and save the file without adding an extension, you can find more info here):

  127.0.0.1 eureka-peer1
  127.0.0.1 eureka-peer2


eureka-server-example$ mvn spring-boot:run -Dspring-boot.run.profiles=peer1
eureka-server-example$ mvn spring-boot:run -Dspring-boot.run.profiles=peer2
And now, the client instances, which are also two different commands to run the same application:

eureka-client$ mvn spring-boot:run -Dspring-boot.run.profiles=spanish
eureka-client$ mvn spring-boot:run -Dspring-boot.run.profiles=english



https://github.com/mechero/spring-boot-eureka
https://thepracticaldeveloper.com/2018/03/18/spring-boot-service-discovery-eureka/

https://support.rackspace.com/how-to/modify-your-hosts-file/