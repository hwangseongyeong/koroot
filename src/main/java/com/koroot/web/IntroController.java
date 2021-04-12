package com.koroot.web;

import com.koroot.domain.entity.BoardPost;
import com.koroot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 단체소개
 */
@RequiredArgsConstructor
@Controller
public class IntroController {

    private final BoardService boardService;

    /**
     * 인사말
     */
    @GetMapping("/intro/greetings")
    public String greetings(Model model){
        long boardPostId = 3420;
        BoardPost boardPost = boardService.getBoardPost(boardPostId);
        model.addAttribute("boardPost", boardPost);
        return "content/board/contents";
    }

    @GetMapping("/intro/test")
    public @ResponseBody BoardPost get(Model model){
        long boardPostId = 3420;
        BoardPost boardPost = boardService.getBoardPost(boardPostId);
        model.addAttribute("boardPost", boardPost);
        return boardPost;
    }

    /**
     * 설립 목적
     */
    @GetMapping("/intro/establishment")
    public String establishment(Model model){
        long boardPostId = 3421;
        BoardPost boardPost = boardService.getBoardPost(boardPostId);
        model.addAttribute("boardPost", boardPost);
        return "content/board/contents";
    }
    /**
     * 연혁
     */
    @GetMapping("/intro/history")
    public String history(){
        return "content/intro/history";
    }
    /**
     * 함께하는 사람들
     */
    @GetMapping("/intro/people")
    public String people(Model model){
        long boardPostId = 3422;
        BoardPost boardPost = boardService.getBoardPost(boardPostId);
        model.addAttribute("boardPost", boardPost);
        return "content/board/contents";
    }
    /**
     * 찾아오시는 길
     */
    @GetMapping("/intro/directions")
    public String main(){
        return "content/intro/directions";
    }
}
