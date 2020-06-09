const express = require('express');
const app = express();
const request = require('request');

app.get('/', (req, res) => {
    console.log('Hello world received a request.');
    request('http://' + process.env.SOURCE_URL, function (error, response, body) {
        if (!error && response.statusCode == 200) {
            console.log(body) // Print the google web page.
        }
        if (body != 'Мы сломали твой код,') {
            res.send(new Error('Expected ' + 'Мы сломали твой код,' + ' but got ' + body));
        } else {
            res.send(body + ' уронили')
        }
    });
}); 

const port = process.env.PORT;
app.listen(port, () => {
  console.log('Hello world listening on port', port);
});
