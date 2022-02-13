package com.overone.repository;

import com.overone.model.Message;
import org.springframework.stereotype.Repository;
import com.overone.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {
    public List<Message> findAll() {

        List<Message> messages = new ArrayList<>();

        try (Connection dbConn = DBUtils.getDBConn();
             Statement allEmployee = dbConn.createStatement();
             ResultSet resultSet = allEmployee.executeQuery("Select * from message")) {
            while (resultSet.next()) {
                messages.add(new Message(
                                resultSet.getLong("id"),
                                resultSet.getString("time"),
                                resultSet.getString("sender"),
                                resultSet.getString("text")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messages;
    }

    public boolean save(Message message) {
        try {
            PreparedStatement preparedStatement = DBUtils.getDBConn().prepareStatement("Insert into message (time, sender, text) values (?, ?, ?)");
            preparedStatement.setString(1, message.getTime());
            preparedStatement.setString(2, message.getSender());
            preparedStatement.setString(3, message.getText());
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
