package com.Jupiter.hrm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DbConfig {

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    public Connection getConnection() throws SQLException {
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection success");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return con;
    }
}
