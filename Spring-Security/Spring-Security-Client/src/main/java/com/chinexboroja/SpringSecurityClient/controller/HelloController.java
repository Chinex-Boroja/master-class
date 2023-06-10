package com.chinexboroja.SpringSecurityClient.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @PostMapping("/hello")
    public String registerUser() {
        return "Hello Chinedu";
    }
}
