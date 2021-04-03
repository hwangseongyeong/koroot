package com.koroot.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    /**
     * 게사판 - 등록 화면
     */
    @GetMapping("/admin/board/post")
    public String post(){
        return "content/admin/board/post";
    }


}
