

package com.example.demo.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class DockerController {

    @RequestMapping("/")
    fun home(): String {
        val result = java.net.URL("http://localhost:8686/").readText()
        if(result == "Мы сломали твой код, уронили сервак."){
         return result + " Вставай, Наташа!"
        }
        else{
         return "wrong input: " + result
       }
      }

    @RequestMapping("/hello")
    fun helloWorld(): String {
        return "Welcome to Docker apis, This is hello world in docker"
    }
}


