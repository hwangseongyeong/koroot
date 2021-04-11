package com.koroot.domain.entity;

import com.koroot.model.BoardPostRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class BoardPost {

    public static final String BOARD_WRITER = "관리자";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardPostId;
    private Long boardInfoId;
    private String category;
    private String title;
    private String contents;
    private Integer hit;
    @Column(columnDefinition = "TINYINT")
    private boolean deleted;
    private Long mainImageId;
    private String createdBy;
    @Column(updatable = false)
    private LocalDateTime createdAt;
    private String modifiedBy;
    private LocalDateTime modifiedAt;

    public void updateHit() {
        this.hit++;
    }

    public void updateBoardPost(BoardPostRequestDto reqDto){
        this.title = reqDto.getTitle();
        this.contents = reqDto.getContents();
        this.category = reqDto.getCategory();
        this.modifiedBy = reqDto.getWriter();
        this.modifiedAt = LocalDateTime.now();
    }

    public void updateDeleted(String writer){
        this.deleted = true;
        this.modifiedBy = writer;
        this.modifiedAt = LocalDateTime.now();
    }

    public void updateCreate(String writer){
        this.deleted = false;
        this.createdBy = writer;
        this.createdAt = LocalDateTime.now();
        this.modifiedBy = writer;
        this.modifiedAt = LocalDateTime.now();
    }

    public void updateMainImageId(long mainImageId) {
        this.mainImageId = mainImageId;
    }

    @Builder
    public BoardPost(Long boardInfoId, String category, String title, String contents,
                     String createdBy, String modifiedBy, LocalDateTime createdAt){
        this.boardInfoId = boardInfoId;
        this.category = category;
        this.title = title;
        this.contents = contents;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdAt = createdAt;
        this.modifiedAt = createdAt;
        this.hit = 0;
        this.deleted = false;
    }

    public static BoardPost of(BoardPostRequestDto reqDto) {
        return BoardPost.builder()
                .boardInfoId(reqDto.getBoardInfoId())
                .category(reqDto.getCategory())
                .title(reqDto.getTitle())
                .contents(reqDto.getContents())
                .createdBy(reqDto.getWriter())
                .modifiedBy(reqDto.getWriter())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public String getFormatDate() {
        return this.createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
