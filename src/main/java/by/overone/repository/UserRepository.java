package by.overone.repository;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepository {
    private static final String TABLE_NAME = "user";

    public boolean userExistByUsername(String username) {
        // Можно вынести в DatabaseDealer
        ResultSet rs = DatabaseDealer.executeCustomQuery("Select COUNT(*) FROM " + TABLE_NAME);
        try {
            assert rs != null;
            if (rs.next()) return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
