package com.koroot.web;

import com.koroot.domain.entity.BoardPost;
import com.koroot.model.BoardSearch;
import com.koroot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final BoardService boardService;

    @GetMapping("/")
    public String index(){
        return "redirect:/main";
    }

    @GetMapping("/eng")
    public String engIndex(){
        return "redirect:/eng/main";
    }

    @GetMapping("/main")
    public String main(Model model){
        BoardSearch search = new BoardSearch(1, 0, 7, "");
        List<BoardPost> boardList = boardService.getBoardPostList(search).getContent();
        model.addAttribute("boardList", boardList);
        return "content/main/main";
    }

    @GetMapping("/eng/main")
    public String engMain(Model model){
        BoardSearch search = new BoardSearch(15, 0, 7, "");
        List<BoardPost> boardList = boardService.getBoardPostList(search).getContent();
        model.addAttribute("boardList", boardList);
        return "content/main/engMain";
    }
}
