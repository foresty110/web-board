package com.study.connection.controller;

import com.study.connection.dto.BoardListRequestDto;
import com.study.connection.dto.BoardListResponseDto;
import com.study.connection.dto.BoardViewResponseDto;
import com.study.connection.dto.CategoryDto;
import com.study.connection.service.BoardService;
import com.study.connection.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("board/free")
public class BoardController {

    private final BoardService boardService;
    private final CategoryService categoryService;

    @GetMapping("/list")
    // 게시글 목록 조회
    public String getBoardList(BoardListRequestDto requestDto, Model model){

        // 게시글 검색 결과 가져오기
        //TODO dto- 컨트롤러 , entity - 서비스
        BoardListResponseDto response = boardService.searchBoards(requestDto);

        List<CategoryDto> categoryDto = categoryService.findAll();

        // TODO 세션,세션의 한계, 스코프, 페이지
        // 모델에 데이터 전달
        model.addAttribute("boardList", response.getBoards());
        model.addAttribute("totalCount", response.getTotalViewCount());
        model.addAttribute("categoryList", categoryDto);

        return "list";
    }

    // 게시글 상세 정보 조회
    @GetMapping("/view/{seq}")
    public String getBoardDetail(@PathVariable("seq") Long id, Model model) {

        // 게시글 상세 조회 결과 가져오기
        BoardViewResponseDto response = boardService.getBoardById(id);

        // 모델에 데이터 전달
        model.addAttribute("board", response.getBoardDetail());
        model.addAttribute("comments", response.getComments());

        return "view";
    }

    //
}
