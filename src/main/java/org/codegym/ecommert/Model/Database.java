package org.codegym.ecommert.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ecommert?useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456@Abc";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connect database successfully");
        } catch (ClassNotFoundException sqlException) {
            System.out.println(sqlException.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return connection;
    }
}
