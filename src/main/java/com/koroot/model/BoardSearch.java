package com.koroot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardSearch {
    private long boardInfoId;
    private int offset;
    private int limit;
    private String search;
}
