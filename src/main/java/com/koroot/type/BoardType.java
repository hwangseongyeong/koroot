package com.koroot.type;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum BoardType {
    GENERAL("generalList", "generalDetail",  "일반게시판"),
    IMAGE("imageList", "generalDetail", "이미지게시판"),
    TEXT("textList", "generalDetail", "텍스트게시판"),
    JOURNAL("journalList", "generalDetail", "저널게시판"),
    NOTICE("noticeList", "generalDetail", "공지게시판"),
    ;

    private String listViewPage;
    private String detailViewPage;
    private String desc;
}
