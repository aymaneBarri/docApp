package com.example.docapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "shopee";
        String databaseUser = "root";
        String databasePassword = "";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return databaseLink;
    }
}
