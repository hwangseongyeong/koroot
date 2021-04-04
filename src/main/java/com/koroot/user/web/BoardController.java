package com.koroot.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    /**
     * 게시판 상세
     */
    @GetMapping("/board/detail")
    public String boardDetail(){
        return "content/board/boardDetail";
    }
}
