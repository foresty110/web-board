package com.study.connection.dto;

import com.study.connection.entity.Board;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
// 게시글 목록 조회 응답 객체
public class BoardListResponseDto {

    private List<BoardDto> boards;

    private long totalViewCount;

    private int totalPages;

    private int currentPage;

    public static BoardListResponseDto from(List<Board> boardDtoList, long totalCount) {
        return BoardListResponseDto.builder()
                .boards(boardDtoList.stream()
                        .map(BoardDto::from)
                        .collect(Collectors.toList()))
                .totalViewCount(totalCount)
                .build();
    }
}