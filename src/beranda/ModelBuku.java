/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beranda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Kurnia Indah N
 */
public class ModelBuku {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dataperpus";
    static final String USER = "root";
    static final String PASS = "";
    Connection koneksi;
    Statement statement;

   
public  ModelBuku(){
    try{
        Class.forName(JDBC_DRIVER);
        koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("Koneksi berhasil");
    } catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
        System.out.println("Koneksi gagal");
    }
}

public void simpan(String kb, String nb, String npeng, String npen, String tt){
    try{
        String query = "INSERT INTO `buku` (`Kode_Buku`, `Nama_Buku`, `Nama_Pengarang`, `Nama_Penerbit`, `Tahun_Terbit`) VALUES ('"+kb+"', '"+nb+"', '"+npeng+"', '"+npen+"','"+tt+"')";
        statement = (Statement) koneksi.createStatement();
        statement.executeUpdate(query);
        System.out.println("Berhasil ditambahkan!");
        JOptionPane.showMessageDialog(null, "Data berhasil Ditambahkan!");
    } catch (Exception sql){
        System.out.println(sql.getMessage());
        JOptionPane.showMessageDialog(null, sql.getMessage());
    }
}

public String[][] read(){
    try{
        int jmlData = 0;
        String data[][] = new String[getBanyakData()][8];
        String query = "Select * from `buku`";
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            data[jmlData][0] = resultSet.getString("Kode_Buku");
            data[jmlData][1] = resultSet.getString("Nama_Buku");
            data[jmlData][2] = resultSet.getString("Nama_Pengarang");
            data[jmlData][3] = resultSet.getString("Nama_Penerbit");
            data[jmlData][4] = resultSet.getString("Tahun_Terbit");
            jmlData++;
        }
        return data;
    } catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return null;
    }
}

public int getBanyakData(){
    int jmlData = 0;
    try{
        statement = koneksi.createStatement();
        String query = "Select * from `buku`";
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
        } return jmlData;
    } catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return 0;
    }
}

public int getBanyakDataSearch(String getSearch){
    int jmlData=0;
    try{
        statement = koneksi.createStatement();
        String query = "Select * from `buku` where `judul` like '%"+getSearch+"%'";
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
        }
        return jmlData;
    }catch(SQLException e){
       System.out.println(e.getMessage());
       System.out.println("SQL ERROR");
       return 0;
    }
}

public String[][] cari(String getSearch){
    try{
        int no = 0;
        int jmlData = 0;
        String data[][] = new String[getBanyakDataSearch(getSearch)][8];
        String query = "Select * from `buku` where `judul` like '%"+getSearch+"%'";
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            data[jmlData][0] = resultSet.getString("Kode_Buku");
            data[jmlData][1] = resultSet.getString("Nama_Buku");
            data[jmlData][2] = resultSet.getString("Nama_Pengarang");
            data[jmlData][3] = resultSet.getString("Nama_Penerbit");
            data[jmlData][4] = resultSet.getString("Tahun_Terbit");
            jmlData++;
        } return data;
    } catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL ERROR");
            return null;
    }
}

public void hapus(String kb){
    try{
        String query = "DELETE FROM `buku` WHERE `Kode_Buku` = '"+kb+"'";
        statement = koneksi.createStatement();
        statement.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Berhasil Dihapus!");
    } catch(SQLException sql){
        System.out.println(sql.getMessage());
    }
}
}
 

