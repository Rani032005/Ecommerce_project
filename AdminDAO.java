package com.ecommerce.dao;

import com.ecommerce.model.Admin;
import com.ecommerce.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    // Admin login method
    public Admin login(String username, String passwordHash) {
        String sql = "SELECT * FROM admins WHERE username = ? AND password_hash = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            stmt.setString(2, passwordHash);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPasswordHash(rs.getString("password_hash"));
                return admin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // login failed
    }
}
