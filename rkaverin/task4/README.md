#Task4

Сервис считывает строку сервиса task3 и дополняет ее фразой " код,"
Ожидаемый вывод:

    Мы сломали твой код,

## make
    docker build . -t rkaverin:task4

## run
    docker run -d --rm -p 8083:8080 --env PREV_SERVICE=<http://task3.host:port> --name task4 rkaverin:task4
где **http://task3.host:port** - url запущенного сервиса task3 задачи