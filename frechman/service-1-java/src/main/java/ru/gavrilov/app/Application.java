package ru.gavrilov.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gavrilov-sv
 * created on 07.06.2020
 */
@SpringBootApplication
@RestController
public class Application {

    @GetMapping("/")
    public String getWeString() {
        return "Мы";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}