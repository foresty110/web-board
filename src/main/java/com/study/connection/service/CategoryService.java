package com.study.connection.service;

import com.study.connection.dto.CategoryDto;
import com.study.connection.entity.Category;
import com.study.connection.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryMapper categoryMapper;

    // 전체 카테고리 조회
    public List<CategoryDto> findAll() {
        List<Category> categoryList = categoryMapper.findAll();

        return categoryList.stream()
                .map(CategoryDto::from)
                .collect(Collectors.toList());
    }
}
