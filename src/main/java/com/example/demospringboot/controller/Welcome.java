package com.example.demospringboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Welcome {

    @GetMapping("/hi")
    public String sayHi(){
        return "welcome Developer Rosheni";
    }

    @GetMapping("/")
    public String home(){

        return " Aegon Harris Project";
    }
}
