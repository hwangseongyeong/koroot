package com.koroot.domain.repository;

import com.koroot.domain.entity.Board;
import com.koroot.user.type.BoardType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<List<Board>> findAllByTypeOrderByBoardIdDesc(BoardType type);
    Optional<List<Board>> findAllByOrderByBoardIdDesc();
    @Query(value =
              "select "
            + "   board "
            + "from Board board "
            + "where board.type = :type "
            + "and (:#{#search} is null or board.title like concat('%',:#{#search},'%'))"
            + "order by board.boardId desc ")
    Page<Board> findAllSearch(Pageable pageable, BoardType type, String search);
}
