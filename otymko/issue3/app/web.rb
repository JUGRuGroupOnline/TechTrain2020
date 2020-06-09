# app.rb
require 'sinatra'
require 'net/http'

url = ENV['SERVICE_ENTRYPOINT']
standart_answer = 'Мы сломали'

get '/' do
  if url == nil then
    error 'Переменная среды не задана: SERVICE_ENTRYPOINT'
  end
  result = Net::HTTP.get(URI(url))
  text = result.force_encoding("UTF-8")
  if text != standart_answer then
    error 'Ответ не соответствует ожидаемому значению: ' + standart_answer
  else
    text += ' твой'
  end
  return text
end