package Com.Models;

import java.util.Scanner;
import Com.Controllers.DataControllers;

public class Menu{
    public static void showMenu(){
        Scanner input = new Scanner(System.in);
        int choice;

        System.out.println("------------------------");
        System.out.println("WELCOME TO  DATA BASE CHECKER");
        System.out.println("-------------------------");
        System.out.println("1. Read Data");
        System.out.println("2. Insert Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Delete Data");
        System.out.println("5. Exit");
        System.out.println("-------------------------");

        while (true) {
            System.out.print("Pilih: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    readData();
                    break;
                case 2:
                    insertData();
                    break;
                case 3:
                    editData();
                    break;
                case 4:
                    deleteData();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
                    break;
            }
        }
    }

    public static void readData() {
        DataControllers dataControllers = new DataControllers();
        dataControllers.getDatabase();
    }

    public static void insertData() {
        DataControllers dataControllers = new DataControllers();
        dataControllers.insertData();
    }

    public static void editData() {
        DataControllers dataControllers = new DataControllers();
        dataControllers.editData();
    }

    public static void deleteData() {
        DataControllers dataControllers = new DataControllers();
        dataControllers.deleteData();
    }
}