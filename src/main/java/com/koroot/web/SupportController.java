package com.koroot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 후원참여
 */
@Controller
public class SupportController {

    /**
     * 후원 안내
     */
    @GetMapping("/support/guide")
    public String guide(){
        return "content/support/guide";
    }

    /**
     * 자원활동하기
     */
    @GetMapping("/support/volunteer")
    public String volunteer(){
        return "content/support/volunteer";
    }
}
