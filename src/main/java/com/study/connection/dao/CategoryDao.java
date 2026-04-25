package com.study.connection.dao;

import com.study.connection.dto.CategoryDto;

import java.util.List;

public interface CategoryDao {
    // 모든 카테고리 목록 조회
    List<CategoryDto> selectAllCategories();
}
