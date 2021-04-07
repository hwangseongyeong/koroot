package com.koroot.user.service;

import com.koroot.domain.entity.Board;
import com.koroot.domain.repository.BoardRepository;
import com.koroot.user.model.BoardSearch;
import com.koroot.user.type.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getBoardList(BoardType type){
        return boardRepository.findAllByTypeOrderByBoardIdDesc(type)
                .orElse(Collections.emptyList());
    }

    public Page<Board> getBoardSearch(BoardSearch search){
        Pageable pageable = PageRequest.of(search.getOffset()/search.getLimit(), search.getLimit());
        Page<Board> page = boardRepository.findAllSearch(pageable, search.getType(), search.getSearch());
        return page;
    }

    public List<Board> getBoardListAll(){
        return boardRepository.findAllByOrderByBoardIdDesc().orElse(Collections.emptyList());
    }

    @Transactional
    public Board getBoard(long boardId){
        Optional<Board> board =  boardRepository.findById(boardId);
        board.ifPresent(it -> it.updateHits());
        return board.orElseGet(null);
    }

    @Transactional
    public Board createBoard() {
        Board board = Board.builder()
                .type(BoardType.NOTICE)
                .category("test")
                .title("test")
                .contents("test")
                .createdBy("관리자")
                .build();
        return boardRepository.save(board);
    }
}
