package com.koroot.web;

import com.koroot.domain.entity.BoardFile;
import com.koroot.domain.entity.BoardInfo;
import com.koroot.domain.entity.BoardPost;
import com.koroot.service.BoardService;
import com.koroot.type.BoardType;
import com.koroot.type.CategoryType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    private static final String KOR_LIST_VIEW_PAGE_URL = "content/board/";
    private static final String ENG_LIST_VIEW_PAGE_URL = "content/board/eng/";

    /**
     * 게시판 목록
     */
    @GetMapping("/board/{boardInfoId}/list")
    public String boardList(@PathVariable(value = "boardInfoId") Long boardInfoId,
                            @RequestParam(value = "category", required = false) String category,
                            Model model){

        return KOR_LIST_VIEW_PAGE_URL + setBoardListModelAttribute(model, category, boardInfoId);
    }
    @GetMapping("/eng/board/{boardInfoId}/list")
    public String engBoardList(@PathVariable(value = "boardInfoId") Long boardInfoId,
                            @RequestParam(value = "category", required = false) String category,
                            Model model){

        return ENG_LIST_VIEW_PAGE_URL + setBoardListModelAttribute(model, category, boardInfoId);
    }
    /**
     * 게시판 상세
     */
    @GetMapping("/board/{boardPostId}/detail")
    public String boardDetail(@PathVariable(value = "boardPostId") Long boardPostId,Model model){

        setBoardDetailModelAttribute(model, boardPostId);

        return "content/board/boardDetail";
    }
    @GetMapping("/eng/board/{boardPostId}/detail")
    public String engBoardDetail(@PathVariable(value = "boardPostId") Long boardPostId,Model model){

        setBoardDetailModelAttribute(model, boardPostId);

        return "content/board/engBoardDetail";
    }

    private String setBoardListModelAttribute(Model model, String category, Long boardInfoId) {
        BoardInfo boardInfo = boardService.getBoardInfo(boardInfoId);
        model.addAttribute("boardInfo", boardInfo);
        if (Objects.isNull(category)) {
            category = "ALL";
        }
        model.addAttribute("category", category);

        return boardInfo.getBoardType().getListViewPage();
    }

    private void setBoardDetailModelAttribute(Model model, Long boardPostId) {
        BoardPost boardPost = boardService.getBoardPost(boardPostId);
        model.addAttribute("boardInfo", boardService.getBoardInfo(boardPost.getBoardInfoId()));
        model.addAttribute("boardPost", boardPost);

        List<BoardFile> boardFileList = boardService.getBoardFiles(boardPostId);
        if(!boardFileList.isEmpty()) {
            model.addAttribute("boardFileList", boardFileList);
        }
    }
}
