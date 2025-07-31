package com.grupo5.resenalibro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeepAliveController {

    @GetMapping("/")
    public String root() {
        return "Servidor vivo";
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}