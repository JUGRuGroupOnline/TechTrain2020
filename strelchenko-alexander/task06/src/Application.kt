package ru.jugru.task

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.request.get
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val client = HttpClient(OkHttp)

    routing {
        get("/") {
            val task05host = System.getenv()["TASK05_HOST"] ?: "localhost"
            val task05port = System.getenv()["TASK05_PORT"] ?: "8084"
            val content: String = client.get("http://$task05host:$task05port")
            call.respondText("$content сервак.")
        }
    }
}

