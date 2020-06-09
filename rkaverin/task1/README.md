#Task3

Сервис выводит фразу "Мы"
Ожидаемый вывод:

    Мы
## make
    mvn clean package
    docker build . -t rkaverin:task1

## run
    docker run -d --rm -p 8080:8080 --name task1 rkaverin:task1