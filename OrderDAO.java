package com.ecommerce.dao;

import com.ecommerce.model.Order;
import com.ecommerce.model.OrderItem;
import com.ecommerce.util.DBConnection;

import java.sql.*;

public class OrderDAO {

    public boolean placeOrder(Order order) {
        String orderSql = "INSERT INTO orders (user_id, total_amount, status) VALUES (?, ?, ?)";
        String itemSql = "INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
        Connection conn = null;

        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false); // Start transaction

            // Insert into orders table
            try (PreparedStatement orderStmt = conn.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS)) {
                orderStmt.setInt(1, order.getUserId());
                orderStmt.setDouble(2, order.getTotalAmount());
                orderStmt.setString(3, "Placed");
                orderStmt.executeUpdate();

                // Get generated order_id
                try (ResultSet rs = orderStmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        int orderId = rs.getInt(1);

                        // Insert into order_items
                        try (PreparedStatement itemStmt = conn.prepareStatement(itemSql)) {
                            for (OrderItem item : order.getItems()) {
                                itemStmt.setInt(1, orderId);
                                itemStmt.setInt(2, item.getProductId());
                                itemStmt.setInt(3, item.getQuantity());
                                itemStmt.setDouble(4, item.getPrice());
                                itemStmt.addBatch();
                            }
                            itemStmt.executeBatch();
                        }
                    }
                }
            }

            conn.commit(); // Commit transaction
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback(); // Rollback on error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) conn.setAutoCommit(true);
                if (conn != null) conn.close(); // ✅ Close connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
