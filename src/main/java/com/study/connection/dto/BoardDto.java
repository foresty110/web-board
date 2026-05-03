package com.study.connection.dto;

import com.study.connection.entity.Board;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
// 게시글 요약 정보 dto
public class BoardDto {

    private Long id;

    private String title;

    private String author;

    private String categoryName;

    private int viewCount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    public static BoardDto from(Board entity) {
        return BoardDto.builder()
                .id(entity.getId())
                .categoryName(entity.getCategoryName())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .viewCount(entity.getViewCount())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}