import http.client
import os

from flask import Flask

app = Flask(__name__)


@app.route("/")
def hello():
    task01_host = os.getenv('TASK01_HOST', "localhost")
    task01_port = os.getenv('TASK01_PORT', "8080")
    connection = http.client.HTTPConnection('http://' + task01_host + ':' + task01_port)
    connection.request("GET", "/")
    connection_response = connection.getresponse()
    response_data = connection_response.read()
    connection.close()
    response_string = str(response_data, 'utf-8')
    if response_string == "Мы":
        return response_string + " сломали"



app.run(port=8081)

