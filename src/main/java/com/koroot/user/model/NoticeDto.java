package com.koroot.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NoticeDto {

    private long noticeId;
    private String category;
    private String title;
    private String writer;

    @Builder
    public NoticeDto(long noticeId, String category, String title, String writer) {
        this.noticeId = noticeId;
        this.category = category;
        this.title = title;
        this.writer = writer;
    }

    public static NoticeDto of(long noticeId, String category, String title, String writer) {
        return NoticeDto.builder()
                .noticeId(noticeId)
                .category(category)
                .title(title)
                .writer(writer)
                .build();
    }
}
