package com.koroot.web;

import com.koroot.domain.entity.BoardPost;
import com.koroot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 활동
 */
@RequiredArgsConstructor
@Controller
public class ActivityController {

    private final BoardService boardService;

    /**
     * 사업 방향
     */
    @GetMapping("/activity/business-direction")
    public String businessDirection(Model model){
        long boardPostId = 3423;
        BoardPost boardPost = boardService.getBoardPost(boardPostId);
        model.addAttribute("boardPost", boardPost);
        return "content/board/contents";
    }
    @GetMapping("/eng/activity/business-direction")
    public String engBusinessDirection(Model model){
        long boardPostId = 3540;
        BoardPost boardPost = boardService.getBoardPost(boardPostId);
        model.addAttribute("boardPost", boardPost);
        return "content/board/engContents";
    }
    /**
     * 진행중인 주요사업 - 게스트 하우스
     */
    @GetMapping("/activity/guest-house")
    public String guestHouse(){
        return "content/activity/guestHouse";
    }
    /**
     * 진행중인 주요사업 - 모국생활지원
     */
    @GetMapping("/activity/life-support")
    public String lifeSupport(){
        return "content/activity/lifeSupport";
    }
    /**
     * 진행중인 주요사업 - 권리옹호사업
     */
    @GetMapping("/activity/advocacy")
    public String advocacy(){
        return "content/activity/advocacy";
    }
    /**
     * 진행중인 주요사업 - 연구사업
     */
    @GetMapping("/activity/research")
    public String research(){
        return "content/activity/research";
    }
    /**
     * 진행중인 주요사업 - 지난사업 아카이브
     */
    @GetMapping("/activity/archive")
    public String archive(){
        return "content/activity/archive";
    }
}
