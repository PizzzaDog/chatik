package com.overone.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    static final private String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final private String URL = "jdbc:mysql://localhost/chat";
    static final private String USER = "root";
    static final private String PASSWORD = "mySqlPass3721";

    public static Connection getDBConn() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Не удалось зарегестрировать драйвер");
            e.printStackTrace();
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Не удалось получить connection");
            e.printStackTrace();
        }
        return connection;
    }
}
