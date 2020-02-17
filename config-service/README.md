# Config-service

##  Technology:
Spring Cloud Config provides server and client modules for supporting externalized Configuration in a distributed system. With Config server, spring bootmicroservices configuration centralized across all environments.

The concept is similar to Environment, PropertySource in client applications. If the application moves from one profile to another profile, spring boot applications need not restarted, without downtime microservices will switch from one profile to another.

The default storage for these externalizes properties are git version system, as it supports branching, different properties for each configuration environment.


spring.cloud.config.server.git.uri is the property used to configure the git repository.


# Serving Configuration from A Branch or Label:

By default, spring config server will load properties from a master, but we can configure this using spring.cloud.config.server.git.default-label property.


# Serving application and profile specific properties:

We can also load profile specific properties using {application}-{profile}.properties(yml) file format. Suppose if a file named bookservice-default.properties file is present, then it will be loaded only if none of the profiles are configured, bookservice-dev.properties will load bookservice service only if he is running in dev as an active profile in bookservice application.

Spring config server also supports Vault storage, which is used to storage the secured properties, like passwords, and SSL certificates, etc.

# Native profile

```yml
spring:
   profiles:
      active: native
   cloud:
        config:
            server:
                native:
                    searchLocations: file:///path/to/local/git/repository
```


# How spring cloud config use local property override remote property

```yml
spring:
  cloud:
    config:
      allowOverride: true
      overrideNone: true
      overrideSystemProperties: false
```

# Reference
1.  [Use local property override remote property](https://stackoverflow.com/questions/43800256/how-spring-cloud-config-use-local-property-override-remote-property)

# Got questions?

### Author
CHERARA REDDAH.

* [Cherara Reddah linkedin](https://www.linkedin.com/in/cherarareddah/)
* [Cherara Reddah blog](https://rcherara.ca)