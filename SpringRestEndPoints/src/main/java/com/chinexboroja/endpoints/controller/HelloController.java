package com.chinexboroja.endpoints.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v2")
public class HelloController {

    @GetMapping(value = "/")
    public String getHello() {
        return "Welcome to my code Chinex!!";
    }
}
