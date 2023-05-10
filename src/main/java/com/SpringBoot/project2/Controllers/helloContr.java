package com.SpringBoot.project2.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloContr {

    @GetMapping("/hello")
    public String hello(){
        return "hello i am using git hub";
    }
}
