package com.koroot.api;

import com.koroot.model.BoardFileDto;
import com.koroot.model.ImageResponseDto;
import com.koroot.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequiredArgsConstructor
@RestController
public class ImageController {

    private final ImageService imageService;

    @Value("${file.image.upload-path}")
    public String IMAGE_DIR_PATH;

    public static final String BOARD_IMAGE_PATH = "/board";

    @PostMapping(value = "/image/upload/board", consumes = {"multipart/form-data"})
    public ImageResponseDto imageUpload(@RequestPart(value = "upload") MultipartFile file) throws Exception{

        BoardFileDto dto = imageService.imageUpload(file, BOARD_IMAGE_PATH);
        String url = "/image/download/" + dto.getFilePath() + File.separator + dto.getFileName();
        return new ImageResponseDto(url, true);
    }

    @GetMapping(value = "/image/download/{path}/{imgName:.+}")
    public void getImage(@PathVariable(value = "imgName") String imgName,
                         @PathVariable(value = "path") String path,
                         HttpServletResponse response) throws Exception {

        Path pullPath = Paths.get(IMAGE_DIR_PATH, path, imgName);
        InputStream in = new FileInputStream(pullPath.toFile());
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }
}
