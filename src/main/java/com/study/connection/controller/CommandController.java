package com.study.connection.controller;

import com.study.connection.command.BoardListCommandImpl;
import com.study.connection.command.BoardCommand;
import com.study.connection.command.BoardWriteCommandImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/board/free/*")
public class CommandController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doHandle(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doHandle(request,response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 주소 가져오기
        String uri = request.getRequestURI();
        // 경로 가져오기
        String contextPath = "/board/free/";
        // 실제 경로만 추출
        String path = uri.substring(contextPath.length());

        BoardCommand command = null;
        String viewPage = null;

        // 페이지 연결
        if (path.equals("list")) {
            command = new BoardListCommandImpl(); //게시글 생성 페이지
        } else if (path.equals("write")) { //게시글 목록 페이지
             command = new BoardWriteCommandImpl();
        }

        // 비즈니스 로직 실행
        if (command != null) {
            viewPage = (String)command.processCommand(request, response);
        }

        // 결과 페이지로 이동
        if (viewPage != null) {
            request.getRequestDispatcher(viewPage).forward(request, response);
        }

    }

}