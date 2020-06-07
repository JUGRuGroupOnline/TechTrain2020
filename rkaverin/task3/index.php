<?php

$url = getenv("PREV_SERVICE");
$res = file_get_contents(getenv("PREV_SERVICE"));

if (strcasecmp($res, "Мы сломали") == 0) {
    echo $res . " твой";
} else {
    echo "task3 error: got \"". $res . "\" from \"" . $url;
}
