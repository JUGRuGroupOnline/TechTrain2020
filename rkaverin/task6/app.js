process.env.NODE_ENV = 'development';

const express = require('express'),
    request = require('request'),
    app = express();

const host = '0.0.0.0';
const port = 7000;

app.route('/')
    .get((req, res) => {
        url = process.env.PREV_SERVICE;
        request(url, function (error, response, body) {
            if (body.toLowerCase() === 'Мы сломали твой код, уронили'.toLowerCase()) {
                res.status(200).send(body+' сервак.');
            } else {
                res.status(200).send('task 6 error: got "' + body + '" from ' + url);
            }
        });
    });

app.listen(port, host, () => console.log(`Server listens http://${host}:${port}`));