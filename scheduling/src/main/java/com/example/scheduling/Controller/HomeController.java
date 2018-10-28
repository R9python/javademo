package com.example.scheduling.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController{
    @RequestMapping("/test")
    public String Index(){
        return "hello, java.";
    }
}