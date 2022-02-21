package by.overone.repository;

import by.overone.entity.Message;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {
    private static String TABLE_NAME = "message";
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public List<Message> getAll() {
        List<Message> result = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DatabaseDealer.DB_URL, DatabaseDealer.USERNAME, DatabaseDealer.PASSWORD);
            stmt = con.createStatement();
            result = processResultSet(rs);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void save(Message message) {
        PreparedStatement prStat = DatabaseDealer.getPrepareStatement("INSERT INTO " + TABLE_NAME + " (time, sender, text) VALUES " +
                "(?, ?, ?)");
        try {
            prStat.setString(1, message.getTime());
            prStat.setString(2, message.getSender());
            prStat.setString(3, message.getText());
            prStat.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private List<Message> processResultSet(ResultSet rs) {
        List<Message> result = new ArrayList<>();
        try {
            rs = stmt.executeQuery("SELECT * FROM " +
                    "(SELECT * FROM chatik.message " +
                    "ORDER BY id desc " +
                    "LIMIT 12) o " +
                    "ORDER BY id asc ");
            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getInt("id"));
                message.setTime(rs.getString("time"));
                message.setSender(rs.getString("sender"));
                message.setText(rs.getString("text"));
                result.add(message);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
