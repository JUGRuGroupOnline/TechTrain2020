from flask import Flask
import requests
import os

api = Flask(__name__)
standard_asnwer = 'Мы сломали твой код, уронили сервак.'

@api.route('/', methods=['GET'])
def get_index():
    url = getUrl()
    if (url == None):
        return "Переменная среды не задана: SERVICE_ENTRYPOINT"
    answer = getTextFromUrl(url)
    if (answer != standard_asnwer):
        return 'Ответ не соответствует ожидаемому значению: ' + standard_asnwer 
    return answer + ' Вставай, Наташа!'

def getTextFromUrl(url):
    req = requests.get(url)
    return req.text

def getUrl():
    return os.environ['SERVICE_ENTRYPOINT']

if __name__ == '__main__':
    api.run(debug=False, host='0.0.0.0')
