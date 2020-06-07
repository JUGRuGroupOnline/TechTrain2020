from flask import Flask, request, make_response
from flask_restful import Resource, Api
import os
import requests

app = Flask(__name__)
api = Api(app)

class Greeting (Resource):
    
    def get(self):
        response = requests.get(url=("http://" + os.environ['SOURCE_URL']))
        if response.status_code != 200 or response.text != "Мы сломали":
            raise Exception("Unexpected response: {}".format(response.text))
        result = make_response(response.text + " твой")
        return result


api.add_resource(Greeting, '/')

if __name__ == '__main__':
    app.run('0.0.0.0',os.environ['PORT'])
