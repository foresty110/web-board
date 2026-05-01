package com.study.connection.dao;

import com.study.connection.ConnectionTest;
import com.study.connection.dto.PostDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImpl implements PostDao {

    private ConnectionTest dbTest = new ConnectionTest();
    private static PostDao postDao = new PostDaoImpl();

    private PostDaoImpl() {}

    public static PostDao getPostDao() {
        return postDao;
    }

    @Override
    public List<PostDto> selectAllPosts() {
        List<PostDto> list = new ArrayList<>();
        // t_post와 t_category를 JOIN하여 카테고리 이름까지 가져옵니다.
        String sql = "SELECT p.*, c.name as category_name " +
                "FROM t_post p " +
                "JOIN t_category c ON p.category_id = c.id ";

        try (Connection conn = dbTest.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                PostDto post = new PostDto();
                post.setId(rs.getLong("id"));
                post.setCategoryId(rs.getInt("category_id"));
                post.setCategoryName(rs.getString("category_name"));
                post.setTitle(rs.getString("title"));
                post.setAuthor(rs.getString("author"));
                post.setViewCount(rs.getInt("view_count"));
                post.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                post.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());

                list.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
