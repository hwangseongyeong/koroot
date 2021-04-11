package com.koroot.domain.entity;

import com.koroot.type.BoardType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class BoardInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardInfoId;
    private String boardName;
    @Enumerated(EnumType.STRING)
    private BoardType boardType;
    @Column(columnDefinition = "TINYINT")
    private boolean deleted;
    private String createdBy;
    @Column(updatable = false)
    private LocalDateTime createdAt;
    private String modifiedBy;
    private LocalDateTime modifiedAt;
}
