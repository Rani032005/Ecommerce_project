package com.ecommerce.dao;

import com.ecommerce.util.DBConnection;

import java.sql.*;

public class CartDAO {

    public boolean addToCart(int userId, int productId, int quantity) {
        String sql = "INSERT INTO cart_items (cart_id, product_id, quantity) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection()) {
            int cartId = getCartIdByUser(userId, conn);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cartId);
            stmt.setInt(2, productId);
            stmt.setInt(3, quantity);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private int getCartIdByUser(int userId, Connection conn) throws SQLException {
        String sql = "SELECT id FROM carts WHERE user_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("id");
        } else {
            String insert = "INSERT INTO carts (user_id) VALUES (?)";
            PreparedStatement insertStmt = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            insertStmt.setInt(1, userId);
            insertStmt.executeUpdate();
            ResultSet generatedKeys = insertStmt.getGeneratedKeys();
            if (generatedKeys.next()) return generatedKeys.getInt(1);
        }
        return -1;
    }
}
