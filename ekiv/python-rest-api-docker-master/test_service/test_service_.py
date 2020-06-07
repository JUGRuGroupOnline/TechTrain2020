# coding: utf-8

from flask import Flask
import urllib.request
from flask_restful import Resource, Api

app = Flask(__name__)
api = Api(app)

class HelloWorld(Resource):
    def get(self):
        contents = urllib.request.urlopen("http://localhost:8585/fifth").read()
        if contents == 'Мы сломали твой код, уронили':
            return contents + ' сервак.'
        else:
            return 'Wrong input' + contents

api.add_resource(HelloWorld, '/')

if __name__ == '__main__':
    app.run(debug=True)
