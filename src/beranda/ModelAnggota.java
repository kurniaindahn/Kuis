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
public class ModelAnggota {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dataperpus";
    static final String USER = "root";
    static final String PASS = "";
    Connection koneksi;
    Statement statement;

   
public  ModelAnggota(){
    try{
        Class.forName(JDBC_DRIVER);
        koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("Koneksi berhasil");
    } catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex.getMessage());
        System.out.println("Koneksi gagal");
    }
}

public void simpan(String nis, String ns, String ttl, String jk, String ag, String tdaf, String bs, String kel){
    try{
        String query = "INSERT INTO `anggota` (`NIS`, `Nama_Siswa`, `TTL`, `Jenis_Kelamin`, `Agama`, `Tgl_Daftar`, `Berlaku`, `Kelas`) VALUES ('"+nis+"', '"+ns+"', '"+ttl+"', '"+jk+"','"+ag+"', '"+tdaf+"', '"+bs+"', '"+kel+"')";
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
        String query = "Select * from `anggota`";
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            data[jmlData][0] = resultSet.getString("NIS");
            data[jmlData][1] = resultSet.getString("Nama_Siswa");
            data[jmlData][2] = resultSet.getString("TTL");
            data[jmlData][3] = resultSet.getString("Jenis_Kelamin");
            data[jmlData][4] = resultSet.getString("Agama");
            data[jmlData][5] = resultSet.getString("Tgl_Daftar");
            data[jmlData][6] = resultSet.getString("Berlaku");
            data[jmlData][7] = resultSet.getString("Kelas");
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
        String query = "Select * from `anggota`";
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

public void hapus(String nis){
    try{
        String query = "DELETE FROM `anggota` WHERE `NIS` = '"+nis+"'";
        statement = koneksi.createStatement();
        statement.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Berhasil Dihapus!");
    } catch(SQLException sql){
        System.out.println(sql.getMessage());
    }
}


}
 
