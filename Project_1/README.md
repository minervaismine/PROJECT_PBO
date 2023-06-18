# App
Di dalam "App.java" terdapat object Menu, dimana object ini akan memanggil method
''' java
menu.showMenu();
'''
ini bertujuan untuk menampilkan menu dari program yang terdapat di class "Menu.java"

# Com
Terdapat beberapa package di dalamnya, yaitu :
1. Config
2. Controllers
3. Layout
4. Models

## 1. Config
Terdapat file "MyConfig.java" yang memiliki beberapa variabel static dan sebuah method, yaitu :
1. DB_URL          : Alamat untuk memberikan koneksi ke database   --> "jdbc:mysql://localhost:3306/db_sisfo"
2. DB_USER         : Nama pengguna untuk mengakses database        --> "root"
3. DB_PASS         : Password untuk mengakses database             --> "" (tidak ada)
4. connect         : Untuk menyimpan koneksi ke database dan bertipe data Connection
5. getConnection() : Method yang digunakan untuk mendapatkan koneksi ke database

## 2. Controllers
Terdapat file "DataControllers.java" yang memnili variabel static dan beberapa method, yaitu :
1. connect       : Untuk menyimpan koneksi ke database. Memanggil method getConnection() dari file "MyConfig.java"
2. statement     : Variabel untuk menyimpan statement pada method. Memanggil method createStatement() dari variabel connect
3. resultset     : Variabel untuk menyimpan nilai hasil dari method
4. getDatabase() : Method yang digunakan untuk membaca data dari database
5. insertData()  : Method yang digunakan untuk memasukkan data baru ke database
6. editData()    : Method yang digunakan untuk mengedit data dari database
7. deleteData()  : Method yang digunakan untuk menghapus data dari database

## 3. Layout
Terdapat beberapa file di dalamnya, yaitu :
1. ReadData.java
   Terdapat object DataControllers, dimana object ini akan memanggil method
   ''' java
   dataControllers.getDatabase();
   '''
2. InsertData.java 
   Terdapat object DataControllers, dimana object ini akan memanggil method
   ''' java
   dataControllers.insertData();
   '''   
3. EditData.java
   Terdapat object DataControllers, dimana object ini akan memanggil method
   ''' java
   dataControllers.editData();
   '''
4. DeleteData.java
   Terdapat object DataControllers, dimana object ini akan memanggil method
   ''' java
   dataControllers.deleteData();
   '''

## 4. Models
Terdapat method showMenu() yang menampilkan menu program dan di dalamnya terdapat beberapa method lain seperti readData(), insertData(), editData(), dan deleteData() yang memanggil informasi dari file "DataControllers.java". Selain itu terdapat juga variabel input yang menerima inputan, dan perulangan while, serta penggunaan switch case