## Сборка
В корне проекта запускаем:
```shell script
mvn clean package 
docker build . -t strelchenko:task01
```

## Запуск
```shell script
docker run -d --rm -p 8080:8080 --name task01 strelchenko:task01
```