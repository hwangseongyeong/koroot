package com.koroot.domain.repository;

import com.koroot.domain.entity.BoardFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardFileRepository extends JpaRepository<BoardFile, Long> {
    Optional<List<BoardFile>> findAllByBoardPostIdAndDeletedIsFalse(long boardPostId);
}
