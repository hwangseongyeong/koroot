package com.koroot.domain.repository;

import com.koroot.domain.entity.Board;
import com.koroot.user.type.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<List<Board>> findAllByTypeOrderByBoardIdDesc(BoardType type);
    Optional<List<Board>> findAllByOrderByBoardIdDesc();

}
