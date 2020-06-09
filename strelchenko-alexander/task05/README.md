## Сборка
В корне проекта запускаем:
```shell script
docker build . -t strelchenko:task05
```

## Запуск
```shell script
docker run -d --rm -p 8084:8084 -e "TASK04_HOST=$TASK04_HOST" -e "TASK04_PORT=$TASK04_PORT" --name task05 strelchenko:task05
```

### пример
```shell script
docker run -d --rm -p 8084:8084 -e "TASK04_HOST=localhost" -e "TASK04_PORT=8083" --network host --name task05 strelchenko:task05
````
