package com.study.connection.dao;

import com.study.connection.ConnectionTest;
import com.study.connection.dto.CategoryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private ConnectionTest dbTest = new ConnectionTest();

    private static CategoryDao categoryDao = new CategoryDaoImpl();

    private CategoryDaoImpl() {}

    public static CategoryDao getCategoryDao () {
        return categoryDao;
    }

    @Override
    public List<CategoryDto> selectAllCategories() {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        try {
            conn = dbTest.getConnection();
            String sql = "SELECT * FROM t_category";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setId(rs.getInt("id"));
                categoryDto.setName(rs.getString("name"));
                categoryDtoList.add(categoryDto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryDtoList;
    }
}