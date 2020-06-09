FROM golang:alpine3.12
WORKDIR /usr/src/app
COPY ./main.go .
RUN go build -o main
EXPOSE 8082
ENTRYPOINT ["./main"]