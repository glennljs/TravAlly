package com.alliance.travally.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControlller {
    
    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello World!";
    }

}
