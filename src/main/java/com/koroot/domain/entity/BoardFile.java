package com.koroot.domain.entity;

import com.koroot.service.ConfigService;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @Column(columnDefinition = "TINYINT")
    private boolean deleted;

    @Builder
    public BoardFile(Long boardPostId, String fileType, String filePath, String fileOriginalName, String fileName) {
        this.boardPostId = boardPostId;
        this.fileType = fileType;
        this.filePath = filePath;
        this.fileOriginalName = fileOriginalName;
        this.fileName = fileName;
    }

    public String getImageUrl(){
        return ConfigService.IMAGE_DOWNLOAD_PATH + "/" + filePath + "/" + fileName;
    }

    public String getFileUrl(){
        return ConfigService.FILE_DOWNLOAD_PATH + "/" + filePath + "/" + fileName;
    }

    public void updateDisable() {
        this.deleted = true;
    }
}
