package com.study.connection.dto;

import com.study.connection.entity.Category;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryDto {
    private Long id;
    private String name;

    public static CategoryDto from(Category entity) {
        return CategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
