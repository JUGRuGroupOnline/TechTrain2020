## Сборка
В корне проекта запускаем:
```shell script
./gradlew build
docker build . -t strelchenko:task06
```

## Запуск
```shell script
docker run -d --rm -p 8085:8085 -e "TASK05_HOST=$TASK05_HOST" -e "TASK05_PORT=$TASK05_PORT" --name task06 strelchenko:task06
```

### пример
```shell script
docker run -d --rm -p 8085:8085 -e "TASK05_HOST=localhost" -e "TASK05_PORT=8084" --name task06 strelchenko:task06
````