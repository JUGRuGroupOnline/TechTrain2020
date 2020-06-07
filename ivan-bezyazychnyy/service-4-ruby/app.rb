require 'sinatra'
require 'net/http'

set :port, ENV['PORT']
set :bind, '0.0.0.0'

get '/' do
    response = Net::HTTP.get_response(URI.parse('http://' + ENV['SOURCE_URL']))
    text = response.body.force_encoding("UTF-8")
    #if text != "Мы сломали твой" then
    #    raise "Expected " + "Мы сломали твой" + " but got " + text
    #end
    return text + " код,"
end
