package Com.Controllers;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
import Com.Config.MyConfig;

public class DataControllers {
    private static Connection connect = MyConfig.getConnection();
    private static Statement statement;
    private static ResultSet resultset;

    //READ DATA
    public static void getDatabase(){
        MyConfig.getConnection();
        try {
            statement = connect.createStatement();
            resultset = statement.executeQuery("SELECT * FROM tb_barang ORDER BY ID DESC");

            while(resultset.next()){
                System.out.println(
                    resultset.getString("Nama") + ": Rp." +
                    resultset.getString("Harga") + " (" +
                    resultset.getString("Jumlah") + ")"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //INSERT DATA
    public static void insertData(){
        String namaBaru;
        long hargaBaru;
        int jumlahBaru;

        Scanner input = new Scanner(System.in);

        System.out.print("Nama  : ");
        namaBaru = input.nextLine();

        System.out.print("Harga : ");
        hargaBaru = input.nextLong();

        System.out.print("Jumlah : ");
        jumlahBaru = input.nextInt();

        MyConfig.getConnection();

        try {
            statement = connect.createStatement();
            statement.executeUpdate("INSERT INTO `tb_barang` (`ID`, `Nama`, `Harga`, `Jumlah`) VALUES (NULL, '" + namaBaru + "', '" + hargaBaru + "', '" + jumlahBaru + "')");

            System.out.println("Data berhasil di simpan");

            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        input.close();
    }

    //EDIT DATA
    public static void editData(){
        int jumlah = 45;
        try {
            statement = connect.createStatement();
            statement.executeUpdate("UPDATE `tb_barang` SET `Jumlah` = '" + jumlah + "', WHERE `tb_barang`.`ID` = 7;");

            System.out.println("Data berhasil di Update");

            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //DELETE DATA
    public static void deleteData(){
        int id;
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan id yang ingin di hapus: ");
        id = input.nextInt();
        try {
            MyConfig.getConnection();
            statement = connect.createStatement();
            statement.executeUpdate("DELETE FROM `tb_produk` WHERE `ID` = " + id);

            System.out.println("Data berhasil dihapus");

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        input.close();
    }
}
