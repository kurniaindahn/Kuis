/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beranda;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kurnia Indah N
 */
public class ViewBuku extends JFrame{
    
   JTable tabel;
   DefaultTableModel tableModel;
   JScrollPane scrollPane;
   Object namaKolom[] = {"Kode Buku", "Nama Buku", "Nama Pengarang", "Nama Penerbit", "Tahun Terbit"};
   
   JLabel lJudul = new JLabel ("Data Buku"); 
   JLabel lkb = new JLabel("Kode Buku");
   JTextField tfkb = new JTextField();
   JLabel lnb= new JLabel("Nama Buku");
   JTextField tfnb = new JTextField();
   JLabel lnpeng = new JLabel("Nama Pengarang");
   JTextField tfnpeng = new JTextField();
   JLabel lnpen = new JLabel("Nama Penerbit");
   JTextField tfnpen = new JTextField();
   JLabel ltt = new JLabel("Tahun Terbit");
   JTextField tftt = new JTextField();
   JButton btnSimpan = new JButton("Simpan");
   JButton btnCari = new JButton("Cari");
   JButton btnRefresh = new JButton("Refresh");
   JButton btnHapus = new JButton("Hapus");
   JButton btnKeluar = new JButton("Keluar");
   
public ViewBuku(){
      
    setTitle("Data  Buku");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setLayout(null);
    setSize(800, 700);
    setLocation(70, 30);
     
    add(lJudul);     
    lJudul.setBounds (300, 5, 300, 50);
    add(lkb);
    lkb.setBounds (30, 50, 150, 20);
    add(tfkb);
    tfkb.setBounds(140, 50, 160, 20);
    add(lnb);
    lnb.setBounds(30, 100, 150, 20);
    add(tfnb);
    tfnb.setBounds(140, 100, 160, 20);
    add(lnpeng);
    lnpeng.setBounds(30, 150, 150, 20);
    add(tfnpeng);
    tfnpeng.setBounds(140, 150, 160, 20);
    add(lnpen);
    lnpen.setBounds(30, 200, 150, 20);
    add(tfnpen);
    tfnpen.setBounds(140, 200, 160, 20);
    add(ltt);
    ltt.setBounds(30, 250, 150, 20);
    add(tftt);
    tftt.setBounds(140, 250, 160, 20);
    add(btnSimpan);
    btnSimpan.setBounds(400, 70, 150, 35);
    add(btnCari);
    btnCari.setBounds(570, 70, 150, 35);
    add(btnRefresh);
    btnRefresh.setBounds(400, 125, 150, 35);
    add(btnHapus);
    btnHapus.setBounds(570, 125, 150, 35);
    add(btnKeluar);
    btnKeluar.setBounds(480, 175, 150, 35);
    
    tableModel = new DefaultTableModel (namaKolom,0);
    tabel = new JTable(tableModel);
    scrollPane = new JScrollPane(tabel);
    
    add(scrollPane);
    scrollPane.setBounds(50, 320, 700, 220);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
       
    btnKeluar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            Beranda beranda = new Beranda();
            dispose();
        }
   }); setVisible(true);
}
   
    public String getkb(){
       return tfkb.getText();
    }
    public String getnb(){
       return tfnb.getText();
    }
    public String getnpeng(){
       return tfnpeng.getText();
    }
    public String getnpen(){
       return tfnpen.getText();
    }
    public String gettt(){
       return tftt.getText();
    }
 }


