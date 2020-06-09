#!/bin/bash
mvn clean package
docker build -t techtrain2020/service-1-java .
