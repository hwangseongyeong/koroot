package com.koroot.api;

import com.koroot.domain.entity.BoardPost;
import com.koroot.model.BoardPostDto;
import com.koroot.model.BoardSearchDto;
import com.koroot.model.BoardSearch;
import com.koroot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/board")
public class BoardApiController {

    private final BoardService boardService;

    @GetMapping("/list")
    public BoardSearchDto getBoardList(BoardSearch boardSearch) {
        Page<BoardPost> page = boardService.getBoardPostList(boardSearch);
        return BoardSearchDto.of(page);
    }

    @GetMapping("/journalList")
    public List<BoardPostDto> getJournalList(BoardSearch boardSearch) {

        return boardService.getBoardPostJournalList(boardSearch);
    }
}
