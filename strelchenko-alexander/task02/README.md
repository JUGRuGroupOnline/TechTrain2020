## Сборка
В корне проекта запускаем:
```shell script
docker build . -t strelchenko:task02
```

## Запуск
```shell script
docker run -d --rm -p 8081:8081 -e "TASK01_HOST=$TASK01_HOST" -e "TASK01_PORT=$TASK01_PORT" --name task02 strelchenko:task02
```

### Пример
```shell script
docker run -d --rm -p 8081:8081 -e "TASK01_HOST=localhost" -e "TASK01_PORT=8080" --name task02 strelchenko:task02
```