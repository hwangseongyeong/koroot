package com.koroot.web;

import com.koroot.domain.entity.BoardPost;
import com.koroot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 후원참여
 */
@RequiredArgsConstructor
@Controller
public class SupportController {

    private final BoardService boardService;

    /**
     * 후원 안내
     */
    @GetMapping("/support/guide")
    public String guide(Model model){
        long boardPostId = 3507;
        BoardPost boardPost = boardService.getBoardPost(boardPostId);
        model.addAttribute("boardPost", boardPost);
        return "content/board/contents";
    }
    @GetMapping("/eng/support/guide")
    public String engGuide(Model model){
        long boardPostId = 3542;
        BoardPost boardPost = boardService.getBoardPost(boardPostId);
        model.addAttribute("boardPost", boardPost);
        return "content/board/engContents";
    }

    /**
     * 자원활동하기
     */
    @GetMapping("/support/volunteer")
    public String volunteer(){
        return "content/support/volunteer";
    }

    @GetMapping("/eng/support/volunteer")
    public String engVolunteer(){
        return "content/support/engVolunteer";
    }
}
