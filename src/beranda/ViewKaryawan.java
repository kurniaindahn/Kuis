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
public class ViewKaryawan extends JFrame{
    
   JTable tabel;
   DefaultTableModel tableModel;
   JScrollPane scrollPane;
   Object namaKolom[] = {"NIK", "Nama Karyawan", "Jenis Kelamin", "Golongan", "Jabatan", "Tunjangan", "Total Gaji"};
   
   JLabel lJudul = new JLabel ("DATA KARYAWAN");
   JLabel lnik = new JLabel("NIK");
   JTextField tfnik = new JTextField();
   JLabel lnk= new JLabel("Nama Karyawan");
   JTextField tfnk = new JTextField();
   JLabel ljk = new JLabel("Jenis Kelamin");
   JRadioButton rbpr = new JRadioButton ("Pria");
   JRadioButton rbwa = new JRadioButton ("Wanita");
   JLabel lgol = new JLabel("Golongan");
   JTextField tfgol = new JTextField();
   JLabel ljab = new JLabel("Jabatan");
   JTextField tfjab = new JTextField();
   JLabel ltun = new JLabel("Tunjangan");
   JTextField tftun = new JTextField();
   JLabel ljg = new JLabel("Jumlah Gaji");
   JTextField tfjg = new JTextField();
   JButton btnSimpan = new JButton("Simpan");
   JButton btnCari = new JButton("Cari");
   JButton btnRefresh = new JButton("Refresh");
   JButton btnHapus = new JButton("Hapus");
   JButton btnKeluar = new JButton("Keluar");
   
public ViewKaryawan(){
      
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setLayout(null);
    setSize(1135, 365);
    setLocation(400, 350);
     
    add(lJudul);     
    lJudul.setBounds(480, 15, 900, 40);
    add(lnik);
    lnik.setBounds(10, 50, 90, 20);
    add(tfnik);
    tfnik.setBounds(10, 70, 260, 20);
    add(lnk);
    lnk.setBounds(10, 100, 90, 20);
    add(tfnk);
    tfnk.setBounds(10, 120, 260, 20);
    add(ljk);
    ljk.setBounds(10, 150, 90, 20);
    add(lgol);
    lgol.setBounds(150, 150, 120, 20);
    add(ljab);
    ljab.setBounds(10, 200, 90, 20);
    add(ltun);
    ltun.setBounds(150, 200, 120, 20);
    add(ljg);
    ljg.setBounds(10, 250, 90, 20);
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
   
    public String getnik(){
       return tfnik.getText();
    }
    public String getnk(){
       return tfnk.getText();
    }
    public String getjk(){
        if (rbpr.isSelected()){
            return rbpr.getText();
        }
        else if(rbwa.isSelected()){
            return rbwa.getText();
        }
       return null;
    }
    public String getgol(){
       return tfgol.getText();
    }
    public String getjab(){
       return tfjab.getText();
    }
    public String gettun(){
       return tftun.getText();
    }
    public String getjg(){
       return tfjg.getText();
    }
}

