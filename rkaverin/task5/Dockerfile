FROM ruby:2.5
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
ADD . /usr/src/app
RUN gem install sinatra
EXPOSE 4567
CMD ["ruby", "/usr/src/app/myapp.rb"]