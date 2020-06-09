FROM node:12
WORKDIR /usr/src/app
COPY package.json ./
RUN npm install
COPY app.js .
EXPOSE 7000
CMD [ "node", "app.js" ]