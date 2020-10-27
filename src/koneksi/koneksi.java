package koneksi;

import java.sql.*;

public class koneksi {

 
    private static Connection koneksi;
    public static Connection GetConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Berhasil Terkoneksi");
        }catch(ClassNotFoundException e){
            System.out.println("Gagal Koneksi");
        }
        String url="jdbc:mysql://localhost/jne";
        try{
            koneksi=DriverManager.getConnection(url,"root","");
            System.out.println("berhasil tersambung kedatabase");
        }catch(SQLException e){
            System.out.println("Gagal tersambung ke database");
           
        }
        return koneksi;
    }
}
