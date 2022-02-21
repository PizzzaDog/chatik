package by.overone.service;

import by.overone.repository.DatabaseDealer;
import by.overone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean userExistByUsername(String username) {
        return userRepository.userExistByUsername(username);
    }

    public boolean checkCreds(String username, String password) {
        ResultSet rs = DatabaseDealer.executeCustomQuery("SELECT * FROM " +
                "USER U WHERE " +
                "USERNAME = " + username + "" +
                "AND PASSWORD = " + password);
        try {
            if (rs.next()) return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
