package com.koroot.domain.repository;

import com.koroot.domain.entity.BoardInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardInfoRepository extends JpaRepository<BoardInfo, Long> {
}
