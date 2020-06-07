#Task2

Сервис считывает строку сервиса task1 и дополняет ее фразой " твой"
Ожидаемый вывод:

    Мы сломали

## make
    docker build . -t rkaverin:task2

## run
    docker run -d --rm -p 8081:5000 --env PREV_SERVICE=<http://task1.host:port> --name task2 rkaverin:task2
где **http://task1.host:port** - url запущенного сервиса task1 задачи