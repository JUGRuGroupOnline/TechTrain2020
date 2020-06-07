#Task5

Сервис считывает строку сервиса task4 и дополняет ее фразой " уронили"
Ожидаемый вывод:

    Мы сломали твой код, уронили

## make
    docker build . -t rkaverin:task5

## run
    docker run -d --rm -p 8084:4567 --env PREV_SERVICE=<http://task4.host:port> --name task5 rkaverin:task5
где **http://task4.host:port** - url запущенного сервиса task4 задачи