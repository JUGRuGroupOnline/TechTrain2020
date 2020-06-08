# TechTrain Issue#1

## description

Сделать Rest-сервис, который выдает строку(String) "Мы".
Сервис должен быть написан на Java.
Сервис должен запускаться в докер-контейнере.

## build

docker build -t issue1 .

## run

docker run --rm -p 5001:8080 issue1

## check

wget -qO- http://localhost:5001
