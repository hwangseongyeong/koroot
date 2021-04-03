package com.koroot.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroController {

    @GetMapping("/intro/directions")
    public String main(){
        return "content/intro/directions";
    }

    @GetMapping("/intro/history")
    public String history(){
        return "content/intro/history";
    }

    @GetMapping("/intro/greetings")
    public String greetings(){
        return "content/intro/greetings";
    }

    @GetMapping("/intro/establishment")
    public String establishment(){
        return "content/intro/establishment";
    }

    @GetMapping("/intro/people")
    public String people(){
        return "content/intro/people";
    }

    @GetMapping("/intro/annual")
    public String annual(){
        return "content/intro/annual";
    }

    @GetMapping("/intro/accounting")
    public String accounting(){
        return "content/intro/accounting";
    }
}
