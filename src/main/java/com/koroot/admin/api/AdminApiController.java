package com.koroot.admin.api;

import com.koroot.domain.entity.Board;
import com.koroot.user.service.BoardService;
import com.koroot.user.type.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AdminApiController {

    private final BoardService boardService;

    @GetMapping("/admin/api/boardList")
    public List<Board> getBoardList() {
        return boardService.getBoardList(BoardType.NOTICE);
    }

    @GetMapping("/admin/api/board/listAll")
    public List<Board> getBoardListAll() {
        return boardService.getBoardListAll();
    }

    @GetMapping("/admin/api/boardCreate")
    public Board createBoard() {
        return boardService.createBoard();
    }
}
