### RUN

>gradle clean build

>docker build -t service2 .

>docker run -p 8082:8080 -e "HOST_TASK_1=$NETWORK_HOST" -e "PORT_TASK_1=8081" -t service2
- $NETWORK_HOST - host from task 1

example:
>docker run -p 8082:8080 -e "HOST_TASK_1=172.17.0.1" -e "PORT_TASK_1=8081" -t service2