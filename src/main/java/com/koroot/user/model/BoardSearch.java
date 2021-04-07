package com.koroot.user.model;

import com.koroot.user.type.BoardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardSearch {
    private int offset;
    private int limit;
    private String search;
    private BoardType type;
}
