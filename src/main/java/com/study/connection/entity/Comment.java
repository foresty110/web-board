package com.study.connection.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    private Long id;            // 댓글 id

    private Long postId;        // 게시글 id

    private String author;      // 댓글 작성자

    private String content;     // 댓글 내용

    private LocalDateTime createdAt; // 등록 일시
}
