<?php
$url = parse_url(getenv("SOURCE_URL"));
$curl = curl_init(sprintf("http://%s", $url["host"]));
curl_setopt($curl, CURLOPT_PORT, $url["port"]);
curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($curl);
if (strcmp($response, 'Мы сломали твой код, уронили') !== 0) {
    throw new Exception('Expected ' + 'Мы сломали твой код, уронили' + ' but got ' + $response);
}
echo sprintf("%s сервак.", $response);
