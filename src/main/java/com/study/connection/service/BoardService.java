package com.study.connection.service;


import com.study.connection.dto.*;
import com.study.connection.entity.Board;
import com.study.connection.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;
    private final CommentService commentService;

    /**
     *
     * @param requestDto
     * @return
     */
    // 게시글 목록 조회 - 검색 조건 적용
    public BoardListResponseDto searchBoards(BoardListRequestDto requestDto) {

        BoardSearchCondition condition = BoardSearchCondition.from(requestDto);

        List<Board> boardList = boardMapper.findAll(condition);

        long totalCount = boardMapper.countAll(condition);

        return BoardListResponseDto.from(boardList,totalCount);
    }

    // 게시글 상세 조회
    public BoardViewResponseDto getBoardById(Long id) {

        // TODO id가 없는 경우 예외처리, 예외처리하는곳 통일
        // findById 반환 타입 Optional설정
        // DB에서 게시글 상세 정보 조회
        Board board = boardMapper.findById(id);

        // 해당 게시글의 댓글 데이터 조회
        List<CommentDto> comments = commentService.getCommentsByBoardId(id);

        return BoardViewResponseDto.from(board,comments);
    }
}

