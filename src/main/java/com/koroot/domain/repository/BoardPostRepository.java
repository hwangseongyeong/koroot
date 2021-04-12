package com.koroot.domain.repository;

import com.koroot.domain.entity.BoardPost;
import com.koroot.model.BoardSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardPostRepository extends JpaRepository<BoardPost, Long> {
    @Query(value =
              "select "
            + "   board "
            + "from BoardPost board "
            + "where board.boardInfoId = :#{#boardSearch.boardInfoId} "
            + "and (:#{#boardSearch.search} is null or board.title like concat('%',:#{#boardSearch.search},'%'))"
            + "and board.deleted = false "
            + "order by board.createdAt desc ")
    Page<BoardPost> findAllSearch(Pageable pageable, BoardSearch boardSearch);

    List<BoardPost> findAllByBoardInfoIdAndDeletedOrderByCreatedAtDesc(long boardInfoId, boolean deleted);

    List<BoardPost> findAllByBoardInfoIdAndCategory(long boardInfoId, String category);
}
