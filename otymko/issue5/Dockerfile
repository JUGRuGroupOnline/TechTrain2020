FROM node:14

WORKDIR /app
COPY . .

RUN npm install

EXPOSE 3000

ENTRYPOINT ["node", "/app/index.mjs"]
