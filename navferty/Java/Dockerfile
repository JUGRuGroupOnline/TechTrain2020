# ### BUILD image
# FROM maven:3-jdk-11 as builder
# # create app folder for sources
# RUN mkdir -p /build
# WORKDIR /build
# COPY pom.xml /build
# #Download all required dependencies into one layer
# RUN mvn -B dependency:resolve dependency:resolve-plugins
# #Copy source code
# COPY src /build/src
# # Build application
# RUN mvn package

FROM maven:3-alpine AS build-project
ADD . ./docker-spring-boot
WORKDIR /docker-spring-boot
RUN mvn clean install

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/gs-spring-boot-docker-0.1.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]