package com.koroot.model;

import com.koroot.domain.entity.BoardPost;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@NoArgsConstructor
public class BoardSearchDto {
    private long total;
    private long totalNotFiltered;
    private Object rows;

    @Builder
    public BoardSearchDto(long total, long totalNotFiltered, Object rows) {
        this.total = total;
        this.totalNotFiltered = totalNotFiltered;
        this.rows = rows;
    }

    public static BoardSearchDto of(Page<BoardPost> page) {
        long total =  page.getTotalElements();
        long offset = page.getPageable().getOffset();
        List<BoardPost> boardPostList = page.getContent();
        for(BoardPost boardPost : boardPostList) {
            boardPost.setBoardNo(total - offset);
            offset++;
        }
        return BoardSearchDto.builder()
                .total(total)
                .totalNotFiltered(total)
                .rows(boardPostList)
                .build();
    }
}
