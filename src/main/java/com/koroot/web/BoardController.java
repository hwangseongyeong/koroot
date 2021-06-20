package com.koroot.web;

import com.koroot.domain.entity.BoardInfo;
import com.koroot.domain.entity.BoardPost;
import com.koroot.service.BoardService;
import com.koroot.type.BoardType;
import com.koroot.type.CategoryType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    /**
     * 게시판 목록
     */
    @GetMapping("/board/{boardInfoId}/list")
    public String boardList(@PathVariable(value = "boardInfoId") Long boardInfoId,
                            @RequestParam(value = "category", required = false) String category,
                            Model model){

        BoardInfo boardInfo = boardService.getBoardInfo(boardInfoId);
        model.addAttribute("boardInfo", boardInfo);
        if (Objects.isNull(category)) {
            category = "ALL";
        }
        model.addAttribute("category", category);
        return "content/board/" + boardInfo.getBoardType().getListViewPage();
    }
    @GetMapping("/eng/board/{boardInfoId}/list")
    public String engBoardList(@PathVariable(value = "boardInfoId") Long boardInfoId,
                            @RequestParam(value = "category", required = false) String category,
                            Model model){

        BoardInfo boardInfo = boardService.getBoardInfo(boardInfoId);
        model.addAttribute("boardInfo", boardInfo);
        if (Objects.isNull(category)) {
            category = "ALL";
        }
        model.addAttribute("category", category);
        return "content/board/eng/" + boardInfo.getBoardType().getListViewPage();
    }
    /**
     * 게시판 상세
     */
    @GetMapping("/board/{boardPostId}/detail")
    public String boardDetail(@PathVariable(value = "boardPostId") Long boardPostId,Model model){
        BoardPost boardPost = boardService.getBoardPost(boardPostId);
        model.addAttribute("boardInfo", boardService.getBoardInfo(boardPost.getBoardInfoId()));
        model.addAttribute("boardPost", boardPost);
        return "content/board/boardDetail";
    }
}
