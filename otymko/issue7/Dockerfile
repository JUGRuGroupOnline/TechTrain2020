FROM python:3

COPY ./app/. /usr/src/app/

WORKDIR /usr/src/app

RUN pip install flask
RUN pip install requests

EXPOSE 5000
CMD [ "python", "./main.py" ]