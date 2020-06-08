package ru.jugru.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Task {

    @RequestMapping("/")
    public String home() {
        return "Мы";
    }

    public static void main(String[] args) {
        SpringApplication.run(Task.class, args);
    }

}