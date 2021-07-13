package com.koroot.service;

import com.koroot.domain.entity.BoardFile;
import com.koroot.domain.entity.BoardInfo;
import com.koroot.domain.entity.BoardPost;
import com.koroot.domain.repository.BoardFileRepository;
import com.koroot.domain.repository.BoardInfoRepository;
import com.koroot.domain.repository.BoardPostRepository;
import com.koroot.model.BoardFileDto;
import com.koroot.model.BoardPostDto;
import com.koroot.model.BoardPostRequestDto;
import com.koroot.model.BoardSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardInfoRepository boardInfoRepository;
    private final BoardPostRepository boardPostRepository;
    private final BoardFileRepository boardFileRepository;
    private final ImageService imageService;

    private static final String BOARD_MAIN_IMAGE_PATH = "main";
    private static final String BOARD_FILE_PATH = "board";

    public BoardInfo getBoardInfo(long boardInfoId){
        return boardInfoRepository.findById(boardInfoId)
                .orElseGet(null);
    }

    public List<BoardInfo> getBoardInfoList(){
        return boardInfoRepository.findAll();
    }

    @Transactional
    public BoardPost getBoardPost(long boardPostId){
        Optional<BoardPost> boardPost =  boardPostRepository.findById(boardPostId);
        boardPost.ifPresent(BoardPost::updateHit);
        return boardPost.orElseGet(null);
    }

    public BoardPost getAdminBoardPost(long boardPostId){
        return boardPostRepository.findById(boardPostId)
                .orElseGet(null);
    }

    public Page<BoardPost> getBoardPostList(BoardSearch search){
        Pageable pageable = PageRequest.of(search.getOffset()/search.getLimit(), search.getLimit());
        return boardPostRepository.findAllSearch(pageable, search);
    }

    public List<BoardPostDto> getBoardPostJournalList(BoardSearch search){
        Pageable pageable = PageRequest.of(0, 100);
        return boardPostRepository.findAllSearch(pageable, search).getContent().stream()
                .map(it -> {
                    BoardPostDto dto = BoardPostDto.of(it);
                    if(Objects.nonNull(it.getMainImageId())){
                        BoardFile file = boardFileRepository.findById(it.getMainImageId()).orElse(null);
                        if(Objects.nonNull(file)) {
                            String url = ConfigService.IMAGE_DOWNLOAD_PATH + "/main/" + file.getFileName();
                            dto.setMainImageUrl(url);
                        }
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean createBoard(BoardPostRequestDto reqDto, MultipartFile mainImage, MultipartFile boardFile) throws Exception{
        BoardPost boardPost = BoardPost.of(reqDto);

        boardPostRepository.save(boardPost);

        if (Objects.nonNull(mainImage)) {
            boardPost.updateMainImageId(this.boardImageFileSave(mainImage, boardPost.getBoardPostId()));
        }

        if (Objects.nonNull(boardFile)) {
            this.boardFileSave(boardFile, boardPost.getBoardPostId());
        }

        return true;
    }

    public BoardFile getBoardFile(long boardFileId){
        return boardFileRepository.findById(boardFileId).orElseGet(null);
    }

    public List<BoardFile> getBoardFiles(long boardPostId){
        return boardFileRepository.findAllByBoardPostIdAndDeletedIsFalse(boardPostId).orElse(Collections.emptyList());
    }

    public boolean deleteBoardFile(long boardFileId) {
        boardFileRepository.findById(boardFileId)
                .ifPresent(it -> {
                    it.updateDisable();
                    boardFileRepository.save(it);
                });
        return true;
    }

    @Transactional
    public boolean updateBoard(BoardPostRequestDto reqDto, MultipartFile mainImage, MultipartFile boardFile) throws Exception{
        BoardPost boardPost = boardPostRepository.findById(reqDto.getBoardPostId()).orElseGet(null);

        if(Objects.nonNull(boardPost)){
            boardPost.updateBoardPost(reqDto);
        }

        if (Objects.nonNull(mainImage)) {
            boardPost.updateMainImageId(this.boardImageFileSave(mainImage, boardPost.getBoardPostId()));
        }

        if (Objects.nonNull(boardFile)) {
            this.boardFileSave(boardFile, boardPost.getBoardPostId());
        }

        return true;
    }

    @Transactional
    public boolean deleteBoard(Long boardPostId) {
        boardPostRepository.findById(boardPostId)
                .ifPresent(it -> it.updateDeleted(BoardPost.BOARD_WRITER));
        return true;
    }

    private long boardImageFileSave(MultipartFile mainImage, long boardPostId) throws Exception{
        BoardFileDto boardFileDto = imageService.imageUpload(mainImage, BOARD_MAIN_IMAGE_PATH);
        BoardFile boardFile = BoardFile.builder()
                .boardPostId(boardPostId)
                .fileName(boardFileDto.getFileName())
                .fileOriginalName(boardFileDto.getOriginalName())
                .filePath(BOARD_MAIN_IMAGE_PATH)
                .fileType("IMAGE")
                .build();
        boardFileRepository.save(boardFile);
        return boardFile.getBoardFileId();
    }

    private long boardFileSave(MultipartFile mainImage, long boardPostId) throws Exception{
        BoardFileDto boardFileDto = imageService.fileUpload(mainImage, BOARD_FILE_PATH);
        BoardFile boardFile = BoardFile.builder()
                .boardPostId(boardPostId)
                .fileName(boardFileDto.getFileName())
                .fileOriginalName(boardFileDto.getOriginalName())
                .filePath(BOARD_FILE_PATH)
                .fileType("FILE")
                .build();
        boardFileRepository.save(boardFile);
        return boardFile.getBoardFileId();
    }
}
