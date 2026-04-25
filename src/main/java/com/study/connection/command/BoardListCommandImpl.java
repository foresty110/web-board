package com.study.connection.command;

import com.study.connection.dao.CategoryDaoImpl;
import com.study.connection.dao.PostDaoImpl;
import com.study.connection.dto.CategoryDto;
import com.study.connection.dto.PostDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class BoardListCommandImpl implements BoardCommand {
    @Override
    public Object processCommand(HttpServletRequest request,
                                 HttpServletResponse response) throws ServletException, IOException {

        // 요청 데이터 한글 인코딩
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // DAO를 통해 데이터 가져오기
        List<PostDto> postList = PostDaoImpl.getPostDao().selectAllPosts();
        List<CategoryDto> categoryDtoList = CategoryDaoImpl.getCategoryDao().selectAllCategories();

        // JSP에 데이터 전달
        request.setAttribute("boardList", postList);
        request.setAttribute("categoryList", categoryDtoList);

        return "/list.jsp"; // 게시판 목록 페이지
    }
}
