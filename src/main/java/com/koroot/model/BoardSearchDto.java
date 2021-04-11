package com.koroot.model;

import com.koroot.domain.entity.BoardPost;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

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
        return BoardSearchDto.builder()
                .total(page.getTotalElements())
                .totalNotFiltered(page.getTotalElements())
                .rows(page.getContent())
                .build();
    }
}
