require 'socket'
require 'net/http'
require 'sinatra'

set :port, 8084

helpers do
  def get_env_or_default(key, default_value)
    env_value = ENV[key]
    env_value = default_value if env_value.nil? || env_value.empty?
    return env_value
  end
end

get "/" do
  task04host = get_env_or_default("TASK04_HOST", "localhost")
  task04port = get_env_or_default("TASK04_PORT", 8083)
  response = Net::HTTP.get_response(task04host, '/', task04port)
  return response.body.force_encoding(Encoding::UTF_8) + " уронили"
end