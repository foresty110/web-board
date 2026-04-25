package com.study.connection.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BoardListCommand implements CommandHandler{
    @Override
    public Object processCommand(HttpServletRequest request,
                                 HttpServletResponse response) throws ServletException, IOException {

        // 요청 데이터 한글 인코딩
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // JSP로 보낼 데이터 담기
        String[] test = {"사과", "포도", "오렌지"};
        request.setAttribute("categoryList", test);

        return "/list.jsp"; // 게시판 목록 페이지
    }
}
