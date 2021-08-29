package com.koroot.domain.repository;

import com.koroot.domain.entity.BoardPost;
import com.koroot.model.BoardSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardPostRepository extends JpaRepository<BoardPost, Long> {
    @Query(value =
              "select "
            + "   board "
            + "from BoardPost board "
            + "where board.boardInfoId = :#{#search.boardInfoId} "
            + "and (:#{#search.search} is null or board.title like concat('%',:#{#search.search},'%'))"
            + "and board.deleted = false "
            + "order by board.createdAt desc ")
    Page<BoardPost> findAllSearch(@Param("pageable") Pageable pageable,
                                  @Param("search") BoardSearch search);
}
