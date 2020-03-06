
# Requirements

For building and running the application you need:

JDK 11
Maven 3


# Running the application locally

You can use the Spring Boot Maven plugin like so:

mvn spring-boot:run

I am using env variable SPRING_PROFILES_ACTIVE exported via ~/.bash_profile. export SPRING_PROFILES_ACTIVE=e2e


java -jar -Dspring.profiles.active=prod application.jar

or
java -jar application.jar --spring.profiles.active=prod --spring.config.location=c:\config

mvn spring-boot:run -Dspring-boot.run.profiles=local

mvn spring-boot:run -Dspring-boot.run.profiles=$SPRING_PROFILES_ACTIVE


mvn spring-boot:run -Dspring-boot.run.profiles=secure
mvn -Dmaven.test.skip=true -DskipTests=true clean


# git
https://rubygarage.org/blog/most-basic-git-commands-with-examples

# config 

https://stackoverflow.com/questions/27131143/spring-cloud-configuration-server-not-working-with-local-properties-file

Spring Cloud Netflix
https://cloud.spring.io/spring-cloud-netflix/reference/html/


https://cloud.spring.io/spring-cloud-netflix/reference/html/
https://spring.io/projects/spring-restdocs
https://docs.cloudfoundry.org/credhub/
https://github.com/jdavid-araujo/sample-spring-microservices/tree/master/department-service/src/main/java/com/david/departmentservice/client

https://github.com/salaboy/s1p_gateway/tree/master/src/main/resources
https://github.com/doocs/advanced-java/tree/master/docs/micro-services

https://docs.spring.io/spring-security/site/docs/5.2.x/reference/htmlsingle/#oauth2resourceserver

https://github.com/zlongyue/sxp.egs/tree/master/src


https://www.rajeshbhojwani.co.in/2018/11/spring-cloud-config-server-without.html

https://github.com/RajeshBhojwani/springcloudconfigscript/blob/master/spring_cloud_config_refresh_script.sh


https://www.rajeshbhojwani.co.in/2020/01/resilience4j-future-of-spring-cloud.html

https://www.rajeshbhojwani.co.in/2018/11/spring-cloud-config-server-without.html

https://github.com/eugenp/tutorials/tree/master/persistence-modules/spring-boot-persistence

