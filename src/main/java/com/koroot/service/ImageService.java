package com.koroot.service;

import com.koroot.model.BoardFileDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class ImageService {

    @Value("${file.image.upload-path}")
    public String IMAGE_DIR_PATH;

    @Value("${file.upload-path}")
    public String FILE_DIR_PATH;

    public BoardFileDto imageUpload(MultipartFile file, String path) throws Exception{

        String filename = String.valueOf(System.currentTimeMillis());

        String fileUrl = IMAGE_DIR_PATH + "/" + path + "/" +  filename;

        File uploadFile = new File(fileUrl);
        file.transferTo(uploadFile);

        return new BoardFileDto(path, file.getOriginalFilename(), filename);
    }

    public BoardFileDto fileUpload(MultipartFile file, String path) throws Exception{

        String filename = String.valueOf(System.currentTimeMillis());

        String fileUrl = FILE_DIR_PATH + "/" + path + "/" +  filename;

        File uploadFile = new File(fileUrl);
        file.transferTo(uploadFile);

        return new BoardFileDto(path, file.getOriginalFilename(), filename);
    }
}
