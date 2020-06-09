package com.github.otymko.techtrain.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FirstApplication {

  @GetMapping("/")
  public String home() {
    return "Мы";
  }

  public static void main(String[] args) {
    SpringApplication.run(FirstApplication.class, args);
  }

}
