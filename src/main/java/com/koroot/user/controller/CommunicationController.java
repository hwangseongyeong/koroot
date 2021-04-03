package com.koroot.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunicationController {

    @GetMapping("/communication/notice")
    public String main(){
        return "content/communication/notice";
    }

}
