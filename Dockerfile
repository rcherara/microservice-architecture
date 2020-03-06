FROM openjdk:13-jdk-alpine
MAINTAINER cherara.reddah@icloud.com
ENV APP_FILE vehicle-service-1.0-SNAPSHOT.jar
ENV APP_HOME /usr/apps
EXPOSE 8080
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]