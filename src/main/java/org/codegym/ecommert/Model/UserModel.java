package org.codegym.ecommert.Model;

import org.codegym.ecommert.Entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private List<User> list;
    private Connection connection;

    public UserModel() {
        list = new ArrayList<>();
        connection = Database.getConnection();
    }

    public ResultSet getAllUser() throws SQLException {
        // viet sql
        String sql = "SELECT * FROM users";
        // dua cau lenh truy van
        PreparedStatement statement = connection.prepareStatement(sql);
        // thu hien truy van
        ResultSet resultSet = statement.executeQuery();
        return resultSet;
    }

    public void deleteUser(int id) throws SQLException {
        // viet sql
        String sql = "DELETE FROM users WHERE id = ?";
        // dua cau lenh truy van
        PreparedStatement statement = connection.prepareStatement(sql);
        // thay the id vao cau lenh
        statement.setInt(1, id);
        statement.execute();
    }

    public void addUser(User user) throws SQLException {
        // viet sql
        String sql = "INSERT INTO users (username, password, role) VALUES (?,?,?)";
        // dua cau lenh truy van
        PreparedStatement statement = connection.prepareStatement(sql);
        // thay the du lieu vao cau lenh
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getRole());
        statement.execute();
    }

    public void updateUser(User user) throws SQLException {
        // viet sql
        String sql = "UPDATE users SET username=?, password=?, role=? WHERE id=?";
        // dua cau lenh truy van
        PreparedStatement statement = connection.prepareStatement(sql);
        // thay the du lieu vao cau lenh
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getRole());
        statement.setInt(4, user.getId());
        statement.execute();
    }

    public ResultSet findUserById(int id) throws SQLException {
        // viet sql
        String sql = "SELECT * FROM users WHERE id = ?";
        // dua cau lenh truy van
        PreparedStatement statement = connection.prepareStatement(sql);
        // thay the id vao cau lenh
        statement.setInt(1, id);
        // thu hien truy van
        ResultSet resultSet = statement.executeQuery();
        return resultSet;
    }
}
