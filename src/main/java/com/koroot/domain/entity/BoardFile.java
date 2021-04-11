package com.koroot.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardFileId;
    private Long boardPostId;
    private String fileType;
    private String filePath;
    private String fileOriginalName;
    private String fileName;

    @Builder
    public BoardFile(Long boardPostId, String fileType, String filePath, String fileOriginalName, String fileName) {
        this.boardPostId = boardPostId;
        this.fileType = fileType;
        this.filePath = filePath;
        this.fileOriginalName = fileOriginalName;
        this.fileName = fileName;
    }

    public String getImageUrl(){
        return "/image/download/" + filePath + "/" + fileName;
    }
}
