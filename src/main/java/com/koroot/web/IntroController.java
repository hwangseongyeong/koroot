package com.koroot.web;

import com.koroot.domain.entity.BoardPost;
import com.koroot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/eng/intro/greetings")
    public String engGreetings(Model model){
        long boardPostId = 3539;
        BoardPost boardPost = boardService.getBoardPost(boardPostId);
        model.addAttribute("boardPost", boardPost);
        return "content/board/engContents";
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
    @GetMapping("/eng/intro/introduction")
    public String introduction(Model model){
        long boardPostId = 3541;
        BoardPost boardPost = boardService.getBoardPost(boardPostId);
        model.addAttribute("boardPost", boardPost);
        return "content/board/engContents";
    }
    @GetMapping("/eng/intro/reservations")
    public String reservations(Model model){
        long boardPostId = 4055;
        BoardPost boardPost = boardService.getBoardPost(boardPostId);
        model.addAttribute("boardPost", boardPost);
        return "content/board/engContents";
    }
    /**
     * 연혁
     */
    @GetMapping("/intro/history")
    public String history(){
        return "content/intro/history";
    }

    /**
     * 연혁
     */
    @GetMapping("/eng/intro/history")
    public String engHistory(){
        return "content/intro/engHistory";
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
    public String directions(){
        return "content/intro/directions";
    }

    @GetMapping("/eng/intro/directions")
    public String engDirections(){
        return "content/intro/engDirections";
    }
}
