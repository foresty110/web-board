package com.study.connection.service;

import com.study.connection.dto.CommentDto;
import com.study.connection.entity.Comment;
import com.study.connection.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    // 게시글에 달린 댓글 전체 조회
    public List<CommentDto> getCommentsByBoardId(Long boardId) {

        // 해당 게시글의 댓글 리스트 조회
        List<Comment> commentList = commentMapper.findAllByBoardId(boardId);

        return commentList.stream()
                .map(CommentDto::from)
                .collect(Collectors.toList());

    }
}
