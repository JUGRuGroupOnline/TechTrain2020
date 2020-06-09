FROM gradle:4.10 as builder
COPY build.gradle .
COPY src ./src
RUN gradle clean build --no-daemon
FROM adoptopenjdk/openjdk8:jdk8u202-b08-alpine-slim
COPY --from=builder /home/gradle/build/libs/gradle.jar /app.jar
CMD [ "java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "/app.jar" ]