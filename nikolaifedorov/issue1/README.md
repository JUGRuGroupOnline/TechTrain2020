# Getting Started

## Clean
$ ./gradlew clean

## Build jar
$ ./gradlew build

## Run app
$ java -jar build/libs/rest-0.0.1-SNAPSHOT.jar

## Build Docker image and tag it
$ docker build --build-arg JAR_FILE=build/libs/*.jar -t techtrain2020/issue1-spring-boot-docker .

## Run Docker image
$ docker run -p 8080:8080 techtrain2020/issue1-spring-boot-docker

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/gradle-plugin/reference/html/#build-image)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
