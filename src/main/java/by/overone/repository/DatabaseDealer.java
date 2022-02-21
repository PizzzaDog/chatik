package by.overone.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDealer {
    public static final String DB_URL = "jdbc:mysql://localhost:3306";
    public static final String SCHEMA_URL = "/chatik?serverTimezone=UTC&encoding=UTF-8";
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
            Connection connection = DriverManager.getConnection("");
            Statement statement = connection.createStatement();
            statement.executeQuery("CREATE SCHEMA IF NOT EXISTS chatik");
            statement.executeQuery("CREATE TABLE message (" +
                    "id int NOT NULL AUTO_INCREMENT, " +
                    "time varchar(45) DEFAULT NULL, " +
                    "sender varchar(45) DEFAULT NULL, " +
                    "text varchar(45) DEFAULT NULL, " +
                    "PRIMARY KEY (id)" +
                    ")");
            statement.executeQuery("CREATE TABLE user (" +
                    "username varchar(45) DEFAULT NULL, " +
                    "password varchar(45) DEFAULT NULL)");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }

    //    public static ResultSet executeCustomQuery(String tableName, String query) {
    public static ResultSet executeCustomQuery(String query) {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = con.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // збс, в жопу JDBC
        return null;
    }

    public static PreparedStatement getPrepareStatement(String prepStat) {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            preparedStatement = con.prepareStatement(prepStat, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return preparedStatement;
    }
}
