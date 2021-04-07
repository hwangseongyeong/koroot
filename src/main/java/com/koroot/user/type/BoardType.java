package com.koroot.user.type;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum BoardType {
    NOTICE("공지 사항"),
    ACCOUNTING("투명한 재정, 회계 보고"),
    IMAGE("이미지"),
    BOOK_STORY("책 이야기"),
    SUPPORT_STATUS("후원 현황"),
    PUBLICATION("발간 자료"),
    VIDEO("영상 자료"),
    PRESS("언론 보도"),
    VOICE("해외입양인 목소리"),
    STORY("김도현 목사의 해외입양 이야기"),
    ;

    private String desc;
}
