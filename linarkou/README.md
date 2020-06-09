### How to run
```
mvn clean package
docker build -t task1 .
docker run -p 8080:8080 task1
```