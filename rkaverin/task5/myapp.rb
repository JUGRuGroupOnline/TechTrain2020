# myapp.rb
require 'net/http'
require 'sinatra'

set :bind, '0.0.0.0'

get '/' do
  url = ENV['PREV_SERVICE']
  resp = Net::HTTP.get_response(URI.parse(url)).body.force_encoding("UTF-8")

  if 'Мы сломали твой код,' == resp
    return resp + ' уронили'
  else
    return 'task5 error: got "' + resp + '" from "' + url
  end
end
