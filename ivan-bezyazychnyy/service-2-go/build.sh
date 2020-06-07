#!/bin/bash
env GOOS=linux GOARCH=amd64 go build -o app
docker build -t techtrain2020/service-2-go .
