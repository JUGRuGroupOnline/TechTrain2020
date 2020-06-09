const express = require("express");
const http = require('http');

var app = express();

function getEnvOrDefault(key, defaultValue) {
    if (key in process.env){
        return process.env[key]
    }
    return defaultValue
}

app.get("/", function(req, res){
    task03host = getEnvOrDefault('TASK03_HOST', 'localhost');
    task03port = getEnvOrDefault('TASK03_PORT', '8082');
    http.get('http://' + task03host + ':' + task03port, (response => {
        let data = '';
        response.on('data', (chunk) => {
            data += chunk;
        });
        response.on('end', ()  => {
            res.send(data + " код,");
        });
    }))
});


app.listen(8083);