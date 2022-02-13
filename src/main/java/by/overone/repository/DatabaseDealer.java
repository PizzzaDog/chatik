package by.overone.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDealer {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/chatik?serverTimezone=UTC&encoding=UTF-8";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

//    private static String TABLE_NAME = "message";
    private static final String TABLE_NAME = "message";
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private static PreparedStatement preparedStatement;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    public static ResultSet executeCustomQuery(String tableName, String query) {
    public static ResultSet executeCustomQuery(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = con.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // збс, в жопу JDBC
        return null;
    }

    public static PreparedStatement getPrepareStatement(String prepStat) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            preparedStatement = con.prepareStatement(prepStat, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return preparedStatement;
    }
}
