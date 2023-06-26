package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConfig {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/tugas_database";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    private static Connection connect;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void connection() {

        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS); 
            System.out.println("database connected success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getDatabase(){
        connection();

        try {
            String query = "SELECT NAMA, HARGA, JUMLAH  FROM `tb_produk` ORDER BY ID DESC";
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("NAMA"));
                System.out.println("Rp " + resultSet.getInt("HARGA"));
                System.out.println(resultSet.getInt("JUMLAH"));
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
