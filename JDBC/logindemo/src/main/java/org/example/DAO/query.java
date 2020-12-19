package org.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class query {
    public boolean queryUser(User user) {
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "select username,password from user where username = ? and password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            rs.close();
            ps.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
