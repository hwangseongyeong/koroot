package com.koroot.api;

import com.koroot.domain.entity.BoardFile;
import com.koroot.model.BoardFileDto;
import com.koroot.model.ImageResponseDto;
import com.koroot.service.BoardService;
import com.koroot.service.ConfigService;
import com.koroot.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequiredArgsConstructor
@RestController
public class ImageController {

    private final ImageService imageService;
    private final ConfigService configService;
    private final BoardService boardService;

    public static final String BOARD_IMAGE_PATH = "/board";

    @PostMapping(value = "/image/upload/board", consumes = {"multipart/form-data"})
    public ImageResponseDto imageUpload(@RequestPart(value = "upload") MultipartFile file) throws Exception{

        BoardFileDto dto = imageService.imageUpload(file, BOARD_IMAGE_PATH);
        String url = ConfigService.IMAGE_DOWNLOAD_PATH + "/" + dto.getFilePath() + "/" + dto.getFileName();
        return new ImageResponseDto(url, true);
    }

    @GetMapping(value = "/image/download/{path}/{imgName:.+}")
    public void getImage(@PathVariable(value = "imgName") String imgName,
                         @PathVariable(value = "path") String path,
                         HttpServletResponse response) throws Exception {

        Path pullPath = Paths.get(configService.IMAGE_DIR_PATH, path, imgName);
        InputStream in = new FileInputStream(pullPath.toFile());
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }

    @GetMapping(value = "/file/download/{boardFileId}")
    public ResponseEntity<Resource> getFile(@PathVariable(value = "boardFileId") long boardFileId) throws Exception {

        BoardFile boardFile = boardService.getBoardFile(boardFileId);

        Path pullPath = Paths.get(configService.FILE_DIR_PATH, boardFile.getFilePath(), boardFile.getFileName());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);

        Resource resource = new InputStreamResource(Files.newInputStream(pullPath));

        String fileName = URLEncoder.encode(boardFile.getFileOriginalName()).replaceAll("\\+", "%20");

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_OCTET_STREAM_VALUE))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }
}
