package com.koroot.domain.entity;

import com.koroot.user.type.BoardType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;
    @Enumerated(EnumType.STRING)
    private BoardType type;
    private String category;
    private String title;
    private String contents;

    private Integer hits = 0;
    private String createdBy;
    @Column(updatable = false)
    private LocalDateTime createdAt;
    private String modifiedBy;
    private LocalDateTime modifiedAt;

    @Builder
    public Board(BoardType type, String category, String title,
                 String contents, String createdBy) {
        this.type = type;
        this.category = category;
        this.title = title;
        this.contents = contents;
        this.createdBy = createdBy;
        this.modifiedBy = createdBy;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    public void updateHits(int hits) {
        this.hits = hits;
    }
}
