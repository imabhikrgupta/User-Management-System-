package com.user.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {
            // Load driver (optional for newer versions, but safe to include)
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "minu",
                "minu123"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}