package com.koroot.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 후원참여
 */
@Controller
public class SupportController {

    /**
     * 후원 현황
     */
    @GetMapping("/support/status")
    public String status(){
        return "content/support/status";
    }
    /**
     * 자원활동하기
     */
    @GetMapping("/support/volunteer")
    public String volunteer(){
        return "content/support/volunteer";
    }
}
