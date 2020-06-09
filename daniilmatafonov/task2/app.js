const express = require("express");
const request = require('request');

var app = express();
app.listen(5000, () => {
    console.log("API starts on 5000 port");
});

app.get("/crash", (req, res) => {
    request('http://localhost:8080/', function (error, response, body) {
        if (!error && response.statusCode === 200 && body === 'Мы') {
            const respMessage = body + ' сломали';
            res.send(respMessage);
        }
    });
});