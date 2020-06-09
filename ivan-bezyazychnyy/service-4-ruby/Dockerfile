FROM ruby:2.6-slim
WORKDIR /usr/src/app
COPY Gemfile Gemfile.lock ./
ENV BUNDLE_FROZEN=true
RUN gem install bundler && bundle install
COPY . ./
CMD ["ruby", "./app.rb"]