package com.koroot.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroController {

    @GetMapping("/directions")
    public String main(){
        return "content/intro/directions";
    }
}
