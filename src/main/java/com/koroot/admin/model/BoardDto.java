package com.koroot.admin.model;

import com.koroot.user.type.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardDto {

    private long boardId;
    private BoardType type;
    private String category;
    private String title;
    private String contents;
    private int hits = 0;
    private String writer;

    @Builder
    public BoardDto(long boardId, BoardType type, String category, String title, String contents, String writer) {
        this.boardId = boardId;
        this.type = type;
        this.category = category;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
    }

    public static BoardDto of(long boardId, BoardType type, String category, String title, String contents, String writer) {
        return BoardDto.builder()
                .boardId(boardId)
                .type(type)
                .category(category)
                .title(title)
                .contents(contents)
                .writer("관리자")
                .build();
    }
}
