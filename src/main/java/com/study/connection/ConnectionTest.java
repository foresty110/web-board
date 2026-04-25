package com.study.connection;

import java.sql.*;

public class ConnectionTest {

    static final String DB_URL = "jdbc:mysql://localhost:3308/ebrainsoft_study";
    static final String USER = "ebsoft";
    static final String PASS = "ebsoft";
    Statement stmt = null;

    public Connection getConnection() throws Exception{

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return conn;
    }

    void insertData() {
        try {
            String insertStr = "INSERT INTO user VALUES('도구', 'asd123', 'qwer1234')";
            stmt.executeUpdate(insertStr);
            System.out.println("데이터 추가 성공!");
        } catch(Exception e) {
            System.out.println("데이터 추가 실패 이유 : " + e.toString());
        }
    }

    //삭제
    void removeData() {
        try {
            String removeStr = "DELETE FROM students where name='이지수'";
            stmt.executeUpdate(removeStr);
            System.out.println("데이터 삭제 성공!");
        } catch(Exception e) {
            System.out.println("데이터 삭제 실패 이유 : " + e.toString());
        }
    }

    //수정
    void changeData() {
        try {
            String changeStr = "UPDATE user SET name='가나다'";
            stmt.executeUpdate(changeStr);
            System.out.println("데이터 변경 성공!");
        } catch(Exception e) {
            System.out.println("데이터 변경 실패 이유 : " + e.toString());
        }
    }

    //조회
    void viewData() {
        try {
            System.out.println("== user 테이블 조회 ==");
            String viewStr1 = "SELECT * FROM user";
            ResultSet result1 = stmt.executeQuery(viewStr1);
            int cnt1 = 0;
            while(result1.next()) {
                System.out.print(result1.getString("name") + "\t" + result1.getString("id")
                        + "\t" + result1.getString("password") + "\n");
                cnt1++;
            }

            System.out.println("");
            System.out.println("== students 테이블 조회 ==");
            String viewStr2 = "SELECT * FROM students";
            ResultSet result2 = stmt.executeQuery(viewStr2);
            int cnt2 = 0;
            while(result2.next()) {
                System.out.print(result2.getInt("number") + "\t" + result2.getString("name") + "\t"
                        + result2.getString("gender") + "\t" + result2.getString("department") + "\n");
                cnt2++;
            }

            System.out.println("");
            System.out.println("데이터 조회 성공!");
        } catch(Exception e) {
            System.out.println("데이터 조회 실패 이유 : " + e.toString());
        }
    }

}
