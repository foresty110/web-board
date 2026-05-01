package com.study.connection.service;


import com.study.connection.Entity.Board;
import com.study.connection.Mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public List<Board> getAllBoards() {
        return boardMapper.findAll();
    }
}

