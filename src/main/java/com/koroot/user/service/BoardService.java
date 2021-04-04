package com.koroot.user.service;

import com.koroot.domain.entity.Board;
import com.koroot.domain.repository.BoardRepository;
import com.koroot.user.type.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getBoardList(BoardType type){
        return boardRepository.findAllByTypeOrderByBoardIdDesc(type)
                .orElse(Collections.emptyList());
    }

    public Board getBoard(long boardId){
        return boardRepository.findById(boardId)
                .orElse(null);
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
