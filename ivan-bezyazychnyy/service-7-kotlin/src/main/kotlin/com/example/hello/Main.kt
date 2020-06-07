package com.example.hello

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import java.net.URL

fun main(args: Array<String>) {
   val port = System.getenv("PORT") ?: "8080"
   embeddedServer(Netty, port.toInt()) {
       install(CORS) {
           anyHost()
       }
       routing {
           get("/") {
               var response = URL("http://" + System.getenv("SOURCE_URL")).readText()
               if (response != "Мы сломали твой код, уронили сервак.") {
                   throw Exception("Expected " + "Мы сломали твой код, уронили сервак." + " but got " + response)
               }
               call.respondText(response + " Вставай, Наташа!", ContentType.Text.Html)
           }
       }
   }.start(wait = true)
}
