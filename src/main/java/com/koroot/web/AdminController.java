package com.koroot.web;

import com.koroot.domain.entity.BoardFile;
import com.koroot.domain.entity.BoardPost;
import com.koroot.service.BoardService;
import com.koroot.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final BoardService boardService;
    private final LoginService loginService;

    @GetMapping("/login")
    public String login(HttpServletRequest request){

        if (loginService.isLogin(request)) {
            return "redirect:/admin/board";
        }

        return "content/login/login";
    }

    @GetMapping("/admin")
    public String admin(Model model){

        return "redirect:/admin/board";
    }

    @GetMapping("/admin/board")
    public String adminBoardList(@RequestParam(value = "boardInfoId", required = false) Long boardInfoId, Model model){
        if(Objects.isNull(boardInfoId)){
            boardInfoId = 1L;
        }
        model.addAttribute("boardInfoId", boardInfoId);
        model.addAttribute("boardInfoList", boardService.getBoardInfoList());
        return "content/admin/adminBoardList";
    }

    @GetMapping("/admin/board/{boardPostId}/detail")
    public String adminBoardDetail(@PathVariable(value = "boardPostId") Long boardPostId, Model model){

        BoardPost boardPost = boardService.getBoardPost(boardPostId);
        model.addAttribute("boardInfo", boardService.getBoardInfo(boardPost.getBoardInfoId()));
        model.addAttribute("boardPost", boardPost);
        model.addAttribute("boardInfoList", boardService.getBoardInfoList());
        if(Objects.nonNull(boardPost.getMainImageId())){
            BoardFile boardFile = boardService.getBoardFile(boardPost.getMainImageId());
            model.addAttribute("mainImage", boardFile);
        }
        return "content/admin/adminBoardDetail";
    }

    @GetMapping("/admin/board/create")
    public String adminBoardCreate(Model model){

        model.addAttribute("boardInfoList", boardService.getBoardInfoList());
        return "content/admin/adminBoardCreate";
    }
}
