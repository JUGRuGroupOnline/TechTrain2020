package ru.gavrilov.service2kt

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URL

/**
 * @author gavrilov-sv
 * created on 07.06.2020
 */

@RestController
class Controller {

    var host: String = System.getenv("HOST_TASK_1")
    var port: String = System.getenv("PORT_TASK_1")
    val url = URL("http://$host:$port/")

    @GetMapping("/")
    fun getString(): String {
        var result = " сломали";
        val readText = url.readText()
            if (readText == "Мы") {
                result = readText + result;
            }
        return result;
    }

}