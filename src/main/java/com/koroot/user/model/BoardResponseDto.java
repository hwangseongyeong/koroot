package com.koroot.user.model;

import com.koroot.domain.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@NoArgsConstructor
public class BoardResponseDto {
    private long total;
    private long totalNotFiltered;
    private Object rows;

    @Builder
    public BoardResponseDto(long total, long totalNotFiltered, Object rows) {
        this.total = total;
        this.totalNotFiltered = totalNotFiltered;
        this.rows = rows;
    }

    public static BoardResponseDto of(Page<Board> page) {
        return BoardResponseDto.builder()
                .total(page.getTotalElements())
                .totalNotFiltered(page.getTotalElements())
                .rows(page.getContent())
                .build();
    }
}
