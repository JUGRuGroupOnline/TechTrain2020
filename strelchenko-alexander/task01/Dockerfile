FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} task01.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/task01.jar"]