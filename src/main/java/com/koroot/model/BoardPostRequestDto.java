package com.koroot.model;

import com.koroot.type.CategoryType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardPostRequestDto {
    private long boardPostId;
    private long boardInfoId;
    private CategoryType category;
    private String title;
    private String contents;
    private String writer = "관리자";

    @Builder
    public BoardPostRequestDto(long boardInfoId, CategoryType category, String title, String contents, String writer) {
        this.boardInfoId = boardInfoId;
        this.category = category;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }
}
