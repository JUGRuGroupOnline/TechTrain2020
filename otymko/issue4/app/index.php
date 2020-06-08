<?php

$method = $_SERVER['REQUEST_METHOD'];
$url = getenv('SERVICE_ENTRYPOINT');
$standart_answer = "Мы сломали твой";

if ($method == 'GET') {
    if ($url == null) {
        exit("Переменная среды не задана: SERVICE_ENTRYPOINT");
    }
    $content = getTextFromUrl($url);
    if (strcasecmp($content, $standart_answer) != 0) {
        exit("Ответ не соответствует ожидаемому значению: ".$standart_answer);
    }
    exit($content.' код,'); 
} else {
    exit('Метод не поддерживается');
}

function getTextFromUrl($url) {
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $url);
    curl_setopt($ch, CURLOPT_HEADER, 0);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER , 1);
    $content = curl_exec($ch);
    curl_close($ch);
    return $content;   
}

?>