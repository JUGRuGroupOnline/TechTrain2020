## Сборка
В корне проекта запускаем:
```shell script
docker build . -t strelchenko:task04
```

## Запуск
```shell script
docker run -d --rm -p 8083:8083 -e "TASK03_HOST=$TASK03_HOST" -e "TASK03_PORT=$TASK03_PORT" --name task04 strelchenko:task04
```

### Пример
```shell script
docker run -d --rm -p 8083:8083 -e "TASK03_HOST=localhost" -e "TASK03_PORT=8082" --name task04 strelchenko:task04
```