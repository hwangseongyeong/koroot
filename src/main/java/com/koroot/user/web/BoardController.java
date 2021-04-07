package com.koroot.user.web;

import com.koroot.domain.entity.Board;
import com.koroot.user.service.BoardService;
import com.koroot.user.type.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    /**
     * 게시판 목록
     */
    @GetMapping("/board/list")
    public String boardList(Model model, BoardType type){
        model.addAttribute("type", type);
        return "content/board/boardList";
    }
    /**
     * 게시판 상세
     */
    @GetMapping("/board/detail")
    public String boardDetail(Model model, Long boardId, BoardType type){
        Board board = boardService.getBoard(boardId);
        board.updateHits();
        model.addAttribute("type", type);
        model.addAttribute("board", board);
        return "content/board/boardDetail";
    }
}
