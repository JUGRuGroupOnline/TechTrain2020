FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/task06.jar
COPY ${JAR_FILE} task06.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/task06.jar"]