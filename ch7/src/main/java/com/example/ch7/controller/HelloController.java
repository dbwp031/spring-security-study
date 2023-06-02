package com.example.ch7.controller;

import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/ciao")
    public String ciao() {
        return "Ciao!";
    }

    @PostMapping("/a")
    public String postEndPointA() {
        return "PostEndPointA Works!";
    }


    @GetMapping("/a")
    public String getEndPointA() {
        return "GetEndPointA Works!";
    }

    @GetMapping("/a/b")
    public String getEndPointA_B() {
        return "GetEndPointA_B Works!";
    }

    @GetMapping("/a/b/c")
    public String getEndPointA_B_C() {
        return "GetEndPointA_B_C Works!";
    }

    @GetMapping("/product/{code}")
    public String productCode(@PathVariable String code) {
        return code;
    }

    @GetMapping("/video/{country}/{language}")
    public String video(@PathVariable String country, @PathVariable String language) {
        return "video -> " + country + language;
    }
}
