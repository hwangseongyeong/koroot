package com.koroot.type;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CategoryType {
    NONE(""),
    A("게스트하우스"),
    B("모국생활지원"),
    C("권리옹호사업"),
    D("연구사업"),
    E("국제협력"),
    ;

    private String categoryName;
}
