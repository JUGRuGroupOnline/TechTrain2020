FROM adoptopenjdk:11-jdk-hotspot

COPY . /src

WORKDIR /src

RUN ./gradlew bootJar

FROM adoptopenjdk:11-jre-hotspot

COPY --from=0 /src/build/libs/first-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
