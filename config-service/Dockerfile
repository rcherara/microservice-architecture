FROM openjdk:11-jdk-alpine
ENV APP_FILE config-service-1.0-SNAPSHOT.jar
ENV APP_HOME /usr/apps
EXPOSE 8080
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["nohup","java","-jar","config-service-1.0-SNAPSHOT.jar","&"]


FROM openjdk:14-alpine

ENV JAVA_OPTS=""

MAINTAINER Cherara Reddah <cherara.reddah@icloud.com>


ENV APP_DIR /opt/config-service/app

RUN apk -q update && apk -q add bash && apk -q add --update curl \
    # Add user configuration-server
    && adduser -D config-service \
    # Create folders
    && mkdir -p $APP_DIR  && chown -R config-service:config-service$APP_DIR

WORKDIR $APP_DIR

COPY target/config-service-*.jar config-service.jar

WORKDIR $APP_DIR

USER configuration-server

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar config-service.jar;" ]