package com.koroot.user.api;

import com.koroot.domain.entity.Board;
import com.koroot.user.service.BoardService;
import com.koroot.user.type.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    @GetMapping("/api/board/list")
    public List<Board> getBoardList(BoardType type) {
        return boardService.getBoardList(type);
    }

    @GetMapping("/api/board/listAll")
    public List<Board> getBoardListAll() {
        return boardService.getBoardListAll();
    }

    @GetMapping("/api/board")
    public Board getBoard(Long boardId) {
        return boardService.getBoard(boardId);
    }
}
