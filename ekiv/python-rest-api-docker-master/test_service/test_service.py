# coding: utf-8

from flask import Flask
from flask import Response
import urllib.request
from flask_restful import Resource, Api

app = Flask(__name__)
api = Api(app)

class HelloWorld(Resource):
    def get(self):

        with urllib.request.urlopen('http://localhost:8585/fifth') as response:
            contents = response.read().decode('utf-8')

        if contents == 'Мы сломали твой код, уронили':
            return Response(contents + ' сервак.', mimetype='text/plain')
        else:
            return Response('Wrong input' + contents, mimetype='text/plain')

api.add_resource(HelloWorld, '/')

if __name__ == '__main__':
    app.run(host="localhost", port=8686, debug=False)
