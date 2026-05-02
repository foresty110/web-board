package com.study.connection.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
// 게시글 조회 조건
public class BoardSearchCondition {

    private String startDate;

    private String endDate;

    private String category;

    private String keyword;

    private int offset;

    private int size;

    //TODO 맵핑 유틸리티 - 맵스트럭
    public static BoardSearchCondition from(BoardListRequestDto dto) {
        return BoardSearchCondition.builder()
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .category(dto.getCategory())
                .keyword(dto.getKeyword())
                .offset(1) // TODO
                .size(dto.getSize())
                .build();
    }
}