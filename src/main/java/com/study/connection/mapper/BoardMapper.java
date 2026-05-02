package com.study.connection.mapper;

import com.study.connection.entity.Board;
import com.study.connection.dto.BoardSearchCondition;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {
    List<Board> findAll(BoardSearchCondition boardSearchCondition);
    Board findById(Long id);
    int countAll(BoardSearchCondition boardSearchCondition);
}
