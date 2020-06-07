FROM openjdk:8-jdk-alpine
EXPOSE 8787
ADD /build/libs/demo-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java", "-jar", "demo.jar", "--server.port=8787"]
