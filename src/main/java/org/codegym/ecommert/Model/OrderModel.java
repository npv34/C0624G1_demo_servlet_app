package org.codegym.ecommert.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderModel {

    private Connection connection;

    public OrderModel() {
        connection = Database.getConnection();
    }

    public ResultSet getAllOrder() throws SQLException {
        String sql = "SELECT * FROM Orders JOIN Customers ON Orders.customer_id = Customers.customer_id";
        PreparedStatement ps = connection.prepareStatement(sql);
        return ps.executeQuery();
    }
}
