package com.koroot.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardPostRequestDto {
    private long boardPostId;
    private long boardInfoId;
    private String category;
    private String title;
    private String contents;
    private String writer = "관리자";

    @Builder
    public BoardPostRequestDto(long boardInfoId, String category, String title, String contents, String writer) {
        this.boardInfoId = boardInfoId;
        this.category = category;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }
}
