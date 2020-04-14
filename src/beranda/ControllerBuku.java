/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beranda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Kurnia Indah N
 */
public class ControllerBuku {
    ModelBuku modelbuku;
    ViewBuku viewbuku;
    
    public ControllerBuku(ModelBuku modelbuku, ViewBuku viewbuku){
        this.modelbuku = modelbuku;
        this.viewbuku = viewbuku;
        
        if(modelbuku.getBanyakData() !=0){
           String dataMovie[][]= modelbuku.read();
           viewbuku.tabel.setModel((new JTable(dataMovie, viewbuku.namaKolom)).getModel());
        }
        else{
            JOptionPane.showMessageDialog(null,"Data Tidak ada");          
        }
        
    viewbuku.btnSimpan.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if ( viewbuku.getkb().equals("")
                    || viewbuku.getnpeng().equals("")
                    || viewbuku.getnpen().equals("")
                    || viewbuku.gettt ().equals("")){
                JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
            }else{
                String kb = viewbuku.getkb();
                String nb = viewbuku.getnb();
                String npeng = viewbuku.getnpeng();
                String npen = viewbuku.getnpen();
                String tt = viewbuku.gettt();
                    
                String data[][] = modelbuku.read();
                viewbuku.tabel.setModel(new JTable (data, viewbuku.namaKolom).getModel());
            }   
        }
    }); 
        
   viewbuku.btnRefresh.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            String data[][] = modelbuku.read();
            viewbuku.tabel.setModel(new JTable (data, viewbuku.namaKolom).getModel());   
            viewbuku.tfkb.setText(null);
            viewbuku.tfnb.setText(null);
            viewbuku.tfnpeng.setText(null);
            viewbuku.tfnpen.setText(null);
            viewbuku.tftt.setText(null);
        }
    }); 

   
    viewbuku.tabel.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
            int baris = viewbuku.tabel.getSelectedRow();
            int kolom = viewbuku.tabel.getSelectedColumn();
            String dataterpilih = viewbuku.tabel.getValueAt(baris, 0).toString();
            System.out.println(dataterpilih);
        
            String kb = viewbuku.tabel.getValueAt(baris, 1).toString();
            viewbuku.tfkb.setText(kb);
            String nb = viewbuku.tabel.getValueAt(baris, 2).toString();
            viewbuku.tfnb.setText(nb);
            String npeng = viewbuku.tabel.getValueAt(baris, 3).toString();
            viewbuku.tfnpeng.setText(npeng);
            String npen = viewbuku.tabel.getValueAt(baris, 4).toString();
            viewbuku.tfnpen.setText(npen);
            String tt = viewbuku.tabel.getValueAt(baris, 5).toString();
            viewbuku.tftt.setText(tt);
        
    viewbuku.btnHapus.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){    
            modelbuku.hapus(dataterpilih);
            String data[][]= modelbuku.read();
            viewbuku.tabel.setModel(new JTable(data, viewbuku.namaKolom).getModel());
        }
    });    
  }});
}}

