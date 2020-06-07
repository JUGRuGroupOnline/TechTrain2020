#Task3

Сервис считывает строку сервиса task2 и дополняет ее фразой " твой"
Ожидаемый вывод:

    Мы сломали твой

## make
    docker build . -t rkaverin:task3

## run
    docker run -d --rm -p 8082:8080 --env PREV_SERVICE=<http://task2.host:port> --name task3 rkaverin:task3
где **http://task2.host:port** - url запущенного сервиса task2 задачи