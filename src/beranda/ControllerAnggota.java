/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beranda;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Kurnia Indah N
 */
public class ControllerAnggota {
    ModelAnggota modelanggota;
    ViewAnggota viewanggota;
    
    public ControllerAnggota(ModelAnggota modelanggota, ViewAnggota viewanggota){
        this.modelanggota = modelanggota;
        this.viewanggota = viewanggota;
        
        if(modelanggota.getBanyakData() !=0){
           String dataMovie[][]= modelanggota.read();
           viewanggota.tabel.setModel((new JTable(dataMovie, viewanggota.namaKolom)).getModel());
        }
        else{
            JOptionPane.showMessageDialog(null,"Data Tidak ada");          
        }
        
    viewanggota.btnSimpan.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if ( viewanggota.getnis().equals("")
                    || viewanggota.getns().equals("")
                    || viewanggota.getttl().equals("")
                    || viewanggota.getjk().equals("")
                    || viewanggota.getag().equals("")
                    || viewanggota.gettd().equals("")
                    || viewanggota.getbh().equals("")
                    || viewanggota.getkel().equals("")){
                JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
            }else{
                String nis = viewanggota.getnis();
                String ns = viewanggota.getns();
                String ttl = viewanggota.getttl();
                String jk = viewanggota.getjk();
                String ag = viewanggota.getag();
                String td = viewanggota.gettd();
                String bh = viewanggota.getbh();
                String kel = viewanggota.getkel();
                modelanggota.simpan(nis, ns, ttl, jk, ag, td, bh, kel);
                    
                String data[][] = modelanggota.read();
                viewanggota.tabel.setModel(new JTable (data, viewanggota.namaKolom).getModel());
            }   
        }
    }); 
        
   viewanggota.btnRefresh.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            String data[][] = modelanggota.read();
            viewanggota.tabel.setModel(new JTable (data, viewanggota.namaKolom).getModel());   
            viewanggota.tfnis.setText(null);
            viewanggota.tfns.setText(null);
            viewanggota.tfttl.setText(null);
            viewanggota.rblk.setText("Laki-Laki");
            viewanggota.rbpr.setText("Perempuan");
            viewanggota.cmbag.setSelectedItem(this);
            viewanggota.tftd.setText(null);
            viewanggota.tfbh.setText(null);
            viewanggota.tfkel.setText(null);
        }
    }); 

   
    viewanggota.tabel.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
            int baris = viewanggota.tabel.getSelectedRow();
            int kolom = viewanggota.tabel.getSelectedColumn();
            String dataterpilih = viewanggota.tabel.getValueAt(baris, 0).toString();
            System.out.println(dataterpilih);
        
            String nis = viewanggota.tabel.getValueAt(baris, 1).toString();
            viewanggota.tfnis.setText(nis);
            String ns = viewanggota.tabel.getValueAt(baris, 2).toString();
            viewanggota.tfns.setText(ns);
            String ttl = viewanggota.tabel.getValueAt(baris, 3).toString();
            viewanggota.tfttl.setText(ttl);
            String jk = viewanggota.tabel.getValueAt(baris, 4).toString();
            viewanggota.rblk.setText(jk);
            String kel = viewanggota.tabel.getValueAt(baris, 5).toString();
            viewanggota.tfkel.setText(kel);
            String ag = viewanggota.tabel.getValueAt(baris, 6).toString();
            viewanggota.cmbag.setSelectedItem(ag);
            String td = viewanggota.tabel.getValueAt(baris, 7).toString();
            viewanggota.tftd.setText(td);
        
    viewanggota.btnHapus.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){    
            modelanggota.hapus(dataterpilih);
            String data[][]= modelanggota.read();
            viewanggota.tabel.setModel(new JTable(data, viewanggota.namaKolom).getModel());
        }
    });    
  }});
}}
