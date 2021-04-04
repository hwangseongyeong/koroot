package com.koroot.admin.api;

import com.koroot.admin.model.BoardDto;
import com.koroot.admin.service.AdminBoardService;
import com.koroot.domain.entity.Board;
import com.koroot.user.service.BoardService;
import com.koroot.user.type.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AdminApiController {

    private final BoardService boardService;
    private final AdminBoardService adminBoardService;

    @GetMapping("/admin/api/boardList")
    public List<Board> getBoardList() {
        return boardService.getBoardList(BoardType.NOTICE);
    }

    @GetMapping("/admin/api/board/listAll")
    public List<Board> getBoardListAll() {
        return boardService.getBoardListAll();
    }

    @PostMapping("/admin/api/boardCreate")
    public Board createBoard( @RequestBody BoardDto reqDto) {
        return adminBoardService.createBoard(reqDto);
    }

}
