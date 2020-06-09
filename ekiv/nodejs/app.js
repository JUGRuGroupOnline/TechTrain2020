'use strict';

const express = require('express');
const app = new express();
const request = require('request');

app.get('/forth', (req, res) => {
    request('http://localhost:8383/third', function (error, response, body) {
  if (!error && response.statusCode == 200) {
      if(body === 'Мы сломали твой'){
        res.send(body + ' код,');
      }else{
          res.send('-');
      }
  }
});
    
});

app.listen(8484, () => {
    console.log('Server up!');
});
