/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.config;

/**
 *
 * @author Fikri
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public abstract class MyConfig {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_sisfo";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    
    private static Connection connect;
    private static Statement statement;
    private static ResultSet resultset;

    public static void connection(){
        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection: Gagal");
        }
    }

    // READ
    public static void getDatabase(){
        MyConfig.connection();
        try {
            statement = connect.createStatement();
            resultset = statement.executeQuery("SELECT * FROM db_barang ORDER BY ID DESC");

            while(resultset.next()){
                System.out.println(
                    resultset.getString("Nama") + ": Rp."+
                    resultset.getString("Harga") + " (" +
                    resultset.getString("Jumlah") + ")"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void insertData(String namaBaru, int hargaBaru, int jumlahBaru){
        MyConfig.connection();

        try {
            statement = connect.createStatement();
            statement.executeUpdate("INSERT INTO `db_barang` (`ID`, `Nama`, `Harga`, `Jumlah`) VALUES (NULL, '"+namaBaru+"', '"+hargaBaru+"', '"+jumlahBaru+"')");

            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteAllData() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            statement = connection.createStatement();

            String query = "DELETE FROM `db_barang`";
            statement.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}