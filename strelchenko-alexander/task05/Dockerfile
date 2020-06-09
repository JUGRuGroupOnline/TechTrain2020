FROM ruby:2.7.1-alpine3.11
WORKDIR /usr/src/app
RUN gem install sinatra
EXPOSE 8084
COPY ./main.rb .
ENTRYPOINT ["ruby", "./main.rb"]