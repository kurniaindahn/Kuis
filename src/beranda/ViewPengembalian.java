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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kurnia Indah N
 */
public class ViewPengembalian  extends JFrame{
    
   JTable tabel;
   DefaultTableModel tableModel;
   JScrollPane scrollPane;
   Object namaKolom[] = {"No Pinjam", "NIS", "Nama Siswa", "Kelas", "Kode Buku", "Nama Buku", "Penerbit", "Tgl Pinjam", "Tgl Kembali", "Lama Pinjam", "Denda", "Petugas", "NIK"};
   
   JLabel lJudul = new JLabel ("Data Pengembalian Buku");
   JLabel lnopin = new JLabel("No Pinjam");
   JTextField tfnopin = new JTextField();
   JLabel lnis= new JLabel("NIS");
   JTextField tfnis = new JTextField();
   JLabel lns = new JLabel("Nama Siswa");
   JTextField tfns = new JTextField();
   JLabel lkel = new JLabel("Kelas");
   JTextField tfkel = new JTextField();
   JLabel lkb = new JLabel("Kode Buku");
   JTextField tfkb = new JTextField();
   JLabel lnb = new JLabel("Nama Buku");
   JTextField tfnb = new JTextField();
   JLabel lnpen = new JLabel("Nama Penerbit");
   JTextField tfnpen = new JTextField();
   JLabel ltpin = new JLabel("Tanggal Pinjam");
   JTextField tftpin = new JTextField();
   JLabel ltkem = new JLabel("Tanggal Kembali");
   JTextField tftkem = new JTextField();
   JLabel llp = new JLabel("Lama Peminjaman");
   JTextField tflp = new JTextField();
   JLabel lden = new JLabel("Denda");
   JTextField tfden = new JTextField();
   JLabel lnik = new JLabel("NIK");
   JTextField tfnik = new JTextField();
   JLabel lnk = new JLabel("Petugas");
   JTextField tfnk = new JTextField();
   JButton btnSimpan = new JButton("Simpan");
   JButton btnCari = new JButton("Cari");
   JButton btnRefresh = new JButton("Refresh");
   JButton btnHapus = new JButton("Hapus");
   JButton btnKeluar = new JButton("Keluar");
   
public ViewPengembalian(){
      
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setLayout(null);
    setSize(1135, 365);
    setLocation(400, 350);
     
    add(lJudul);     
    lJudul.setBounds(480, 15, 900, 40);
    add(lnopin);
    lnopin.setBounds(10, 50, 90, 20);
    add(tfnopin);
    tfnopin.setBounds(10, 70, 260, 20);
    add(lnis);
    lnis.setBounds(10, 100, 90, 20);
    add(tfnis);
    tfnis.setBounds(10, 120, 260, 20);
    add(lns);
    lns.setBounds(10, 150, 90, 20);
    add(tfns);
    tfns.setBounds(10, 170, 120, 20);
    add(lkel);
    lkel.setBounds(10, 200, 90, 20);
    add(tfkel);
    tfkel.setBounds(10, 220, 120, 20);
    add(lkb);
    lkb.setBounds(150, 200, 120, 20);
    add(tfkb);
    tfkb.setBounds(150, 220, 120, 20);
    add(lnb);
    lnb.setBounds(10, 250, 90, 20);
    add(tfnb);
    tfnb.setBounds(10, 270, 260, 20);
    add(lnpen);
    lnpen.setBounds(10, 250, 90, 20);
    add(tfnpen);
    tfnpen.setBounds(10, 270, 260, 20);
    add(ltpin);
    ltpin.setBounds(10, 250, 90, 20);
    add(tftpin);
    tftpin.setBounds(10, 270, 260, 20);
    add(ltkem);
    ltkem.setBounds(10, 250, 90, 20);
    add(tftkem);
    tftkem.setBounds(10, 270, 260, 20);
    add(llp);
    llp.setBounds(10, 250, 90, 20);
    add(tflp);
    tflp.setBounds(10, 270, 260, 20);
    add(lden);
    lden.setBounds(10, 250, 90, 20);
    add(tfden);
    tfden.setBounds(10, 270, 260, 20);
    add(lnik);
    lnik.setBounds(10, 250, 90, 20);
    add(tfnik);
    tfnik.setBounds(10, 270, 260, 20);
    add(lnk);
    lnk.setBounds(10, 250, 90, 20);
    add(tfnk);
    tfnk.setBounds(10, 270, 260, 20);
    add(btnSimpan);
    btnSimpan.setBounds(1017, 40, 80, 19);
    add(btnCari);
    btnCari.setBounds(295, 70, 80, 20);
    add(btnRefresh);
    btnRefresh.setBounds(295, 120, 80, 20);
    add(btnHapus);
    btnHapus.setBounds(295, 170, 80, 20);
    add(btnKeluar);
    btnKeluar.setBounds(295, 220, 80, 20);
    
    tableModel = new DefaultTableModel (namaKolom,0);
    tabel = new JTable(tableModel);
    scrollPane = new JScrollPane(tabel);
    
    add(scrollPane);
    scrollPane.setBounds(400, 70, 700, 220);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
       
    btnKeluar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            Beranda beranda = new Beranda();
            dispose();
        }
   }); setVisible(true);
}
   
    public String getnopin(){
       return tfnopin.getText();
    }
    public String getnis(){
       return tfnis.getText();
    }
    public String getns(){
       return tfns.getText();
    }
    public String getkel(){
       return tfkel.getText();
    }
    public String getkb(){
       return tfkb.getText();
    }
    public String getnb(){
       return tfnb.getText();
    }
    public String getnpen(){
       return tfnpen.getText();
    }
    public String gettpin(){
       return tftpin.getText();
    }
    public String gettkem(){
       return tftkem.getText();
    }
    public String getlp(){
       return tflp.getText();
    }
    public String getden(){
       return tfden.getText();
    }
    public String getnik(){
       return tfnik.getText();
    }
    public String getnk(){
       return tfnk.getText();
    }
}

