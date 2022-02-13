package com.overone.repository;

import com.overone.model.Message;
import org.springframework.stereotype.Repository;
import com.overone.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
