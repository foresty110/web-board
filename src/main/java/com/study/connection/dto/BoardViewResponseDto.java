package com.study.connection.dto;

import com.study.connection.entity.Board;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
// 게시글 상세 조회 응답 dto
public class BoardViewResponseDto {
    private BoardDto boardDetail;       // 게시글 상세 정보
    private List<CommentDto> comments;  // 댓글 목록

    public static BoardViewResponseDto from(Board board, List<CommentDto> comments) {
        return BoardViewResponseDto.builder()
                .boardDetail(BoardDto.from(board))
                .comments(comments)
                .build();
    }
}
