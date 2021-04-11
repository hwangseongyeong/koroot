package com.koroot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardFileDto {
    private String filePath;
    private String originalName;
    private String fileName;
}
