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
public class Beranda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            GUI g = new GUI (); 
    }
    
}

class GUI extends JFrame{
    
        JLabel lJudul = new JLabel ("MENU UTAMA");
        JButton btnAng = new JButton("Input Anggota");
        JButton btnKar = new JButton("Input Karyawan");
        JButton btnBuk = new JButton("Input Data Buku");
        JButton btnPem = new JButton("Peminjaman");
    
    public GUI(){
        setTitle("Beranda");
        setVisible(true);
        setLayout(null);
        setSize (440,300);
        setLocation(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        add(lJudul);
        lJudul.setBounds(170, 10, 100, 30);
        add(btnAng);
        btnAng.setBounds(50, 50, 150, 50);
        add(btnKar);
        btnKar.setBounds(50, 130, 150, 50);
        add(btnBuk);
        btnBuk.setBounds(230, 50, 150, 50);
        add(btnPem);
        btnPem.setBounds(230, 130, 150, 50);
        
        btnAng.addActionListener(new ActionListener(){     
        @Override
        public void actionPerformed(ActionEvent e){
            MVC_Ang mvc_ang = new MVC_Ang();
            }
         });
        
        btnKar.addActionListener(new ActionListener(){     
        @Override
        public void actionPerformed(ActionEvent e){
            MVC_Kar mvc_kar = new MVC_Kar();
            }
         });
        
        btnBuk.addActionListener(new ActionListener(){     
        @Override
        public void actionPerformed(ActionEvent e){
            MVC_Buk mvc_buk = new MVC_Buk();
            }
         });
        
        btnPem.addActionListener(new ActionListener(){     
        @Override
        public void actionPerformed(ActionEvent e){
            MVC_Pem mvc_pem = new MVC_Pem();
            }
         });
        
    }
}
