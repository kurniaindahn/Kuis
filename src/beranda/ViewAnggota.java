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
public class ViewAnggota extends JFrame{
    
   String jkk;
   JTable tabel;
   DefaultTableModel tableModel;
   JScrollPane scrollPane;
   Object namaKolom[] = {"NIS", "Nama Siswa", "TTL", "Jenis Kelamin", "Agama", "Tgl Daftar", "Berlaku S/D", "Kelas"};
   
   JLabel lJudul = new JLabel ("DATA ANGGOTA");
   JLabel lnis = new JLabel("NIS");
   JTextField tfnis = new JTextField();
   JLabel lns= new JLabel("Nama Siswa");
   JTextField tfns = new JTextField();
   JLabel lttl = new JLabel("TTL");
   JTextField tfttl = new JTextField();
   JLabel ljk = new JLabel("Jenis Kelamin");
   JTextField tfjk = new JTextField();
   JRadioButton rblk = new JRadioButton ("Laki-Laki");
   JRadioButton rbpr = new JRadioButton ("Perempuan");
   JLabel lag = new JLabel("Agama");
   String[] namaag =
        {" Islam", " Katholik", " Kristen", " Hindhu", " Budha"};
   JComboBox cmbag = new JComboBox(namaag);
   JLabel lkel = new JLabel("Kelas");
   JTextField tfkel = new JTextField();
   JLabel ltd = new JLabel("Tanggal Daftar");
   JTextField tftd = new JTextField();
   JLabel lbh = new JLabel("Berlaku Hingga");
   JTextField tfbh = new JTextField();
   JButton btnSimpan = new JButton("Simpan");
   JButton btnHapus = new JButton("Hapus");
   JButton btnKeluar = new JButton("Keluar");
   JButton btnRefresh = new JButton("Refresh");
   
public ViewAnggota(){
      
    setTitle("Data Anggota");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setLayout(null);
    setSize(800, 700);
    setLocation(70, 30);
     
    add(lJudul);     
    lJudul.setBounds(300, 5, 300, 40);
    add(lnis);
    lnis.setBounds(30, 50, 150, 20);
    add(tfnis);
    tfnis.setBounds(140, 50, 160, 20);
    add(lns);
    lns.setBounds(30, 100, 150, 20);
    add(tfns);
    tfns.setBounds(140, 100, 160, 20);
    add(lttl);
    lttl.setBounds(30, 150, 150, 20);
    add(tfttl);
    tfttl.setBounds(140, 150, 160, 20);
    add(ljk);
    ljk.setBounds(30, 200, 150, 20);
    add(rblk);
    rblk.setBounds(140, 200, 100, 20);
    add(rbpr);
    rbpr.setBounds(240, 200, 100, 20);
    add(lag);
    lag.setBounds(420, 50, 150, 20);
    add(cmbag);
    cmbag.setBounds(530, 50, 150, 20);
    add(lkel);
    lkel.setBounds(420, 100, 150, 20);
    add(tfkel);
    tfkel.setBounds(530, 100, 160, 20);
    add(ltd);
    ltd.setBounds(420, 150, 150, 20);
    add(tftd);
    tftd.setBounds(530, 150, 160, 20);
    add(lbh);
    lbh.setBounds(420, 200, 150, 20);
    add(tfbh);
    tfbh.setBounds(530, 200, 160, 20);
    add(btnSimpan);
    btnSimpan.setBounds(60, 530, 150, 35);
    add(btnHapus);
    btnHapus.setBounds(225, 530, 150, 35);
    add(btnKeluar);
    btnKeluar.setBounds(390, 530, 150, 35);
    add(btnRefresh);
    btnRefresh.setBounds(555, 530, 150, 35);
    
    tableModel = new DefaultTableModel (namaKolom,0);
    tabel = new JTable(tableModel);
    scrollPane = new JScrollPane(tabel);
    
    add(scrollPane);
    scrollPane.setBounds(50, 270, 700, 220);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    setVisible(true);
    
    btnKeluar.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        Beranda b = new Beranda ();
        dispose();
    }
   });

}
   
    public String getnis(){
       return tfnis.getText();
    }
    public String getns(){
       return tfns.getText();
    }
    public String getttl(){
       return tfttl.getText();
    }
    public String getkel(){
       return tfkel.getText();
    }
    public String getjk(){
        if(rblk.isSelected()){
            jkk=rblk.getText();
        }
        else{
            jkk=rbpr.getText();
        }
        return jkk;
    }
    public String getag(){
       return (String) cmbag.getSelectedItem();
    }
    public String gettd(){
       return tftd.getText();
    }
    public String getbh(){
       return tfbh.getText();
    }
    
}
