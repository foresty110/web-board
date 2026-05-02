package com.study.connection.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// 게시글 테이블
public class Board {

    private Long id;

    private Integer categoryId;

    private String title;

    private String author;

    private String password;

    private String content;

    private Integer viewCount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String categoryName;

}
