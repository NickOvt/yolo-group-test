package org.yolotest.test.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/api/public/hello")
    public String hello() {
        return "Hello from the server";
    }

    @GetMapping("/api/public")
    public String helloRoot() {
        return "Hello from the server";
    }
}
