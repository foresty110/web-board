package com.study.connection.controller;

import com.study.connection.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("board/free")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String getBoards(
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String keyword,
            Model model) {
        model.addAttribute("title", "게시판 목록");
        return "list";
    }
}
