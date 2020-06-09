from flask import Flask

import os
import requests

app = Flask(__name__)


@app.route('/')
def hello():
    url = os.getenv('PREV_SERVICE', "http://127.0.0.1:8080/")
    response = requests.get(url)
    if response.text.lower() == "Мы".lower():
        return response.text + ' сломали'
    else:
        return "task2 error: got \"" + response.text + "\" from " + url


if __name__ == '__main__':
    app.run(host='0.0.0.0')
