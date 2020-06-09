package jug.ru

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URL

@SpringBootApplication
@RestController
open class Application {
  companion object {
    const val RESPONSE = "Мы"
    const val URL = "http://localhost:8080/"
  }

  @GetMapping("/")
  fun get(): String {
    return getResponse() + " сломали"
  }

  private fun doRequest(): String {
    return URL(URL).readText()
  }

  private fun getResponse(): String {
    val response = doRequest()
    if (RESPONSE != response) {
      throw Exception("Response is not: $RESPONSE it is: $response")
    }
    return response
  }
}

fun main(args: Array<String>) {
  SpringApplication.run(Application::class.java, *args)
}