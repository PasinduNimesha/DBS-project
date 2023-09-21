package com.Jupiter.hrm.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    public static Connection getConnection() throws SQLException {
        Connection con = null;

        try {
            // change the password
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jupiter", "root", "password");
            System.out.println("Connection success");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return con;
    }
}


