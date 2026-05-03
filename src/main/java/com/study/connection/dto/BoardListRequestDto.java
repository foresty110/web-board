package com.study.connection.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
// 게시글 목록 조회 요청 파라미터
public class BoardListRequestDto {

    private String startDate = LocalDate.now().toString();

    private String endDate = LocalDate.now().toString();

    private String category = "";

    private String keyword = "";

    private int page = 1;

    private int size = 5;
}