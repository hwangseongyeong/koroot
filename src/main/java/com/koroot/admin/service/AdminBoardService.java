package com.koroot.admin.service;

import com.koroot.admin.model.BoardDto;
import com.koroot.domain.entity.Board;
import com.koroot.domain.repository.BoardRepository;
import com.koroot.user.type.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminBoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Board createBoard(BoardDto reqDto) {

        Board board = Board.builder()
                .type(reqDto.getType())
                .category(reqDto.getCategory())
                .title(reqDto.getTitle())
                .contents(reqDto.getContents())
                .createdBy("관리자")
                .build();

        return boardRepository.save(board);
    }
}
