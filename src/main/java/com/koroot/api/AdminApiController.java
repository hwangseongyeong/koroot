package com.koroot.api;

import com.koroot.model.BoardPostRequestDto;
import com.koroot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin/board")
public class AdminApiController {

    private final BoardService boardService;

    @PostMapping(consumes = {"multipart/form-data"})
    public boolean createBoard(@RequestPart(value = "mainImage", required = false) MultipartFile mainImage,
                               @RequestPart(value = "boardFile", required = false) MultipartFile boardFile,
                               @RequestPart(value = "reqData") BoardPostRequestDto reqData) throws Exception{
        return boardService.createBoard(reqData, mainImage, boardFile);
    }

    @PutMapping(consumes = {"multipart/form-data"})
    public boolean updateBoard(@RequestPart(value = "mainImage", required = false) MultipartFile mainImage,
                               @RequestPart(value = "boardFile", required = false) MultipartFile boardFile,
                               @RequestPart(value = "reqData") BoardPostRequestDto reqData) throws Exception{
        return boardService.updateBoard(reqData, mainImage, boardFile);
    }

    @DeleteMapping
    public boolean deleteBoard(Long boardPostId) {
        return boardService.deleteBoard(boardPostId);
    }

    @DeleteMapping("/{boardFileId}")
    public boolean deleteBoardFile(@PathVariable(value = "boardFileId") Long boardFileId) {
        return boardService.deleteBoardFile(boardFileId);
    }
}
