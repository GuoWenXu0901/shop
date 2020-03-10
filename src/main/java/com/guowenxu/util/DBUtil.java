package com.guowenxu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

    public static Connection getConn() {

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql:///user";
        String name = "root";
        String password = "123456";

        Connection conn = null;

        try {
            // 加载驱动程序；
            Class.forName(driver);
            // 获得数据库连接；
            conn = DriverManager.getConnection(url, name, password);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {

        try {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(DBUtil.getConn());
    }
}