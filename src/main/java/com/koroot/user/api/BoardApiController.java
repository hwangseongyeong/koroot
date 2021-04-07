package com.koroot.user.api;

import com.koroot.domain.entity.Board;
import com.koroot.user.model.BoardResponseDto;
import com.koroot.user.model.BoardSearch;
import com.koroot.user.service.BoardService;
import com.koroot.user.type.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    @GetMapping("/api/board/list")
    public BoardResponseDto getBoardList(BoardSearch boardSearch) {
        Page<Board> page = boardService.getBoardSearch(boardSearch);
        return BoardResponseDto.of(page);
    }

    @GetMapping("/api/board/detail")
    public Board getBoardDetail(long boardId) {
        return boardService.getBoard(boardId);
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
