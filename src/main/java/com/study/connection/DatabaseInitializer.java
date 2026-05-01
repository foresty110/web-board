package com.study.connection;


import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.sql.Connection;
import java.sql.Statement;

@WebListener
public class DatabaseInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[DB 초기화] 테이블 생성을 시작합니다...");

        ConnectionTest dbTest = new ConnectionTest();

        // 실행할 쿼리문들을 배열로 정리
        String[] queries = {
                "CREATE TABLE IF NOT EXISTS t_category (" +
                        "    id INT AUTO_INCREMENT PRIMARY KEY," +
                        "    name VARCHAR(50) NOT NULL" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4",

                "CREATE TABLE IF NOT EXISTS t_post (" +
                        "    id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                        "    category_id INT NOT NULL," +
                        "    title VARCHAR(200) NOT NULL," +
                        "    author VARCHAR(50) NOT NULL," +
                        "    password VARCHAR(255) NOT NULL," +
                        "    content TEXT NOT NULL," +
                        "    view_count INT DEFAULT 0," +
                        "    created_at DATETIME DEFAULT CURRENT_TIMESTAMP," +
                        "    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP," +
                        "    CONSTRAINT fk_post_category FOREIGN KEY (category_id) REFERENCES t_category(id)" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4",

                "CREATE TABLE IF NOT EXISTS t_attachment (" +
                        "    id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                        "    post_id BIGINT NOT NULL," +
                        "    origin_name VARCHAR(255) NOT NULL," +
                        "    save_name VARCHAR(255) NOT NULL," +
                        "    file_path VARCHAR(500) NOT NULL," +
                        "    file_size BIGINT," +
                        "    CONSTRAINT fk_attach_post FOREIGN KEY (post_id) REFERENCES t_post(id) ON DELETE CASCADE" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4",

                "CREATE TABLE IF NOT EXISTS t_comment (" +
                        "    id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                        "    post_id BIGINT NOT NULL," +
                        "    author VARCHAR(50) NOT NULL," +
                        "    content VARCHAR(1000) NOT NULL," +
                        "    created_at DATETIME DEFAULT CURRENT_TIMESTAMP," +
                        "    CONSTRAINT fk_comment_post FOREIGN KEY (post_id) REFERENCES t_post(id) ON DELETE CASCADE" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4"
        };

        try (Connection conn = dbTest.getConnection();
             Statement stmt = conn.createStatement()) {

            for (String sql : queries) {
                stmt.execute(sql);
            }

            System.out.println("[DB 초기화] 모든 테이블이 성공적으로 준비되었습니다.");

        } catch (Exception e) {
            System.err.println("[DB 초기화] 실패: " + e.getMessage());
            e.printStackTrace();
        }
    }
}