package com.study.connection.dto;

import com.study.connection.entity.Comment;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
// 댓글 요약 정보 dto
public class CommentDto {
    private Long id;
    private String content;
    private LocalDateTime createdAt;

    public static CommentDto from(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}
