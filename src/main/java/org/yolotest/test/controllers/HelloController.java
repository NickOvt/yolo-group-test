package org.yolotest.test.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("rest_api/hello")
    public String hello() {
        return "Hello from the server";
    }
}
