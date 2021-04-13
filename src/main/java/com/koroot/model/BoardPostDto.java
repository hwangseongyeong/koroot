package com.koroot.model;

import com.koroot.domain.entity.BoardPost;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
public class BoardPostDto {
    private long boardPostId;
    private long boardInfoId;
    private String title;
    private String category;
    private String contents;
    @Setter
    private String mainImageUrl;
    private String createDate;
    private String createYear;

    @Builder
    public BoardPostDto(long boardPostId, long boardInfoId, String title, String category,
                        String contents, String mainImageUrl, LocalDateTime createDate) {
        this.boardPostId = boardPostId;
        this.boardInfoId = boardInfoId;
        this.title = title;
        this.category = category;
        this.contents = contents;
        this.mainImageUrl = mainImageUrl;
        this.createDate = createDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.createYear = createDate.format(DateTimeFormatter.ofPattern("yyyy"));
    }

    public static BoardPostDto of(BoardPost boardPost) {
        return BoardPostDto.builder()
                .boardInfoId(boardPost.getBoardInfoId())
                .boardPostId(boardPost.getBoardPostId())
                .title(boardPost.getTitle())
                .contents(boardPost.getContents())
                .createDate(boardPost.getCreatedAt())
                .category(boardPost.getCategory().name())
                .build();
    }
}
