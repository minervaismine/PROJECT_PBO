package Com.Config;

import java.sql.DriverManager;
import java.sql.Connection;

public class MyConfig {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_sisfo";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    private static Connection connect;
    
    public static Connection getConnection(){
        if (connect == null){
            try {
                connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Connection: Gagal");
            }
        }
        return connect;
    }
}