package com.koroot.user.web;

import com.koroot.domain.entity.Board;
import com.koroot.user.model.BoardSearch;
import com.koroot.user.service.BoardService;
import com.koroot.user.type.BoardType;
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

    @GetMapping("/main")
    public String main(Model model){
        BoardSearch search = new BoardSearch(0, 7, "", BoardType.NOTICE);
        List<Board> boardList = boardService.getBoardSearch(search).getContent();
        model.addAttribute("boardList", boardList);
        return "content/main/main";
    }
}
