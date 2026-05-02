package com.study.connection.mapper;

import com.study.connection.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {
    List<Comment> findAllByBoardId(Long id);
}
