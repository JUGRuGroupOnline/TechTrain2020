#Task6

Сервис считывает строку сервиса task5 и дополняет ее фразой " сервак."
Ожидаемый вывод:

    Мы сломали твой код, уронили сервак.

## make
    docker build . -t rkaverin:task6

## run
    docker run -d --rm -p 8085:7000 --env PREV_SERVICE=<http://task5.host:port> --name task6 rkaverin:task6
где **http://task5.host:port** - url запущенного сервиса task5 задачи