## Сборка
В корне проекта запускаем:
```shell script
docker build . -t strelchenko:task03
```

## Запуск
```shell script
docker run -d --rm -p 8082:8082 -e "TASK02_HOST=$TASK02_HOST" -e "TASK02_PORT=$TASK02_PORT" --name task03 strelchenko:task03
```

### Пример
```shell script
docker run -d --rm -p 8082:8082 -e "TASK02_HOST=localhost" -e "TASK02_PORT=8081" --name task03 strelchenko:task03
```