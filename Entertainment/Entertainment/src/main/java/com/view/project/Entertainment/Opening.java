package com.view.project.Entertainment;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/openingparent")
public class Opening {
    @GetMapping("/open")
    public String Open(){
        return "Welcome to the open page";
    }
    @GetMapping("/")
    public String Opendefault(){
        return "Welcome to the open default page";
    }
}
