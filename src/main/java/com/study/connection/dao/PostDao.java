package com.study.connection.dao;

import com.study.connection.dto.PostDto;

import java.util.List;

public interface PostDao {
    // 게시글 전체 목록 가져오기
    List<PostDto> selectAllPosts();
}
