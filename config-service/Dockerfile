FROM openjdk:11-jdk-alpine
ENV APP_FILE config-service-1.0-SNAPSHOT.jar
ENV APP_HOME /usr/apps
EXPOSE 8080
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["nohup","java","-jar","config-service-1.0-SNAPSHOT.jar","&"]