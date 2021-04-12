package com.koroot.web;

import com.koroot.domain.entity.BoardPost;
import com.koroot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 자료실
 */
@RequiredArgsConstructor
@Controller
public class ResourcesController {

    private final BoardService boardService;

    /**
     * 발간 자료
     */
    @GetMapping("/resources/publication")
    public String publication(){
        return "content/resources/publication";
    }
    /**
     * 영상 자료
     */
    @GetMapping("/resources/video")
    public String video(){
        return "content/resources/video";
    }
    /**
     * 해외입양인 커뮤니티
     */
    @GetMapping("/resources/community")
    public String community(Model model){
        long boardPostId = 3489;
        BoardPost boardPost = boardService.getBoardPost(boardPostId);
        model.addAttribute("boardPost", boardPost);
        return "content/board/contents";
    }
}
