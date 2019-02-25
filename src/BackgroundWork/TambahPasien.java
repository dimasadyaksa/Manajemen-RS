/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackgroundWork;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Dimas Adiyaksa
 */
public class TambahPasien {
    koneksi k = new koneksi();
    
    public TambahPasien(){
        
    }
    
    public void ruangBox(javax.swing.JComboBox rBox){
         ResultSet rs = null;
        ArrayList<String> s = new ArrayList();
        int i=0;
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        
        try {
            rs = k.koneksikan("SELECT * FROM ruangan");
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           // rs.next();
            while(rs.next()){
                s.add(rs.getString("Nama Ruang"));
                m.addElement(rs.getString("Nama Ruang"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        //m.addElement(s);
        rBox.setModel(m);
    }
    
    
    public void dokterBox(javax.swing.JComboBox dokBox){
        ResultSet rs = null;
        ArrayList<String> s = new ArrayList();
        int i=0;
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        
        try {
            rs = k.koneksikan("SELECT * FROM kepegawaian WHERE `profesi` = 'Dokter'");
           // rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           // rs.next();
            while(rs.next()){
                s.add(rs.getString("Nama"));
                m.addElement(rs.getString("Nama"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        dokBox.setModel(m);
    }
    
    
    public void perawatBox(javax.swing.JComboBox perBox){
        ResultSet rs = null;
        ArrayList<String> s = new ArrayList();
        int i=0;
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        
        try {
            rs = k.koneksikan("SELECT * FROM kepegawaian WHERE `profesi` = 'perawat'");
          //  rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           // rs.next();
            while(rs.next()){
                s.add(rs.getString("Nama"));
                m.addElement(rs.getString("Nama"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        //m.addElement(s);
        perBox.setModel(m);
    }
    
    public void insert(String sql){
        k.insert(sql);
    }
    
    public String getKdPas() throws SQLException{
        ResultSet rs = null;
        String kper = null;
        String kd = null;
        int no;
        int max,curr;
        max = 0;
        try {
            rs = k.koneksikan("SELECT * FROM pasien");
        } catch (SQLException ex) {
            Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(rs.next()){
            try {
                kper = rs.getString("Kode Pasien");
                kd = kper.substring(1);
                no = Integer.parseInt(kd);
                if(no>=max){
                    max = no;
                }
              //  System.out.println(kper);
            } catch (SQLException ex) {
                Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        max++;
        if(max<10){
            kper = "P00"+Integer.toString(max);
        }else if(max>9&&max<99){
            kper = "P0"+Integer.toString(max);
        }else{
            kper = "P"+Integer.toString(max);
        }
      
        rs.close();
        return kper;
    }
    
    
    public String getKdPas(int x) throws SQLException{
        ResultSet rs = null;
        String kper = null;
        String kd = null;
        int no;
        int max,curr;
        max = 0;
        try {
            rs = k.koneksikan("SELECT `kode pasien` FROM pasien");
        } catch (SQLException ex) {
            Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(rs.next()){
            try {
                kper = rs.getString("Kode Pasien");
                kd = kper.substring(1);
                no = Integer.parseInt(kd);
                if(no>=max){
                    max = no;
                }
              //  System.out.println(kper);
            } catch (SQLException ex) {
                Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
       // max++;
        if(max<10){
            kper = "P00"+Integer.toString(max);
        }else if(max>9&&max<99){
            kper = "P0"+Integer.toString(max);
        }else{
            kper = "P"+Integer.toString(max);
        }
      
        rs.close();
        return kper;
    }
    
    public String getKdPer() throws SQLException{
       
            ResultSet rs = null;
            String kper = null;
            String kd = null;
            int no;
            try {
                rs = k.koneksikan("SELECT `kode perawatan` FROM pasien");
            } catch (SQLException ex) {
                Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            while(rs.next()){
                try {
                    kper = rs.getString("Kode Perawatan");
                } catch (SQLException ex) {
                    Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            kd = kper.substring(2);
//            System.out.println(kd);
            no = Integer.parseInt(kd);
            no++;
            if(no<10){
                kper = "PR00"+Integer.toString(no);
            }else if(no>9&&no<99){
                kper = "PR0"+Integer.toString(no);
            }else{
                kper = "PR"+Integer.toString(no);
            }
            
       
            
            return kper;
    }
    
    public String getKdRuang(javax.swing.JComboBox ruangBx) throws SQLException{
        String kd = null;
        String namaRuang = (String) ruangBx.getSelectedItem();
        ResultSet rs = null;
        String kper = null;
        int no;
        try {
            rs = k.koneksikan("SELECT * FROM ruangan");
        } catch (SQLException ex) {
            Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(rs.next()){
            if(rs.getString("Nama Ruang").equals(namaRuang)){
                kd = rs.getString("Kode Ruang");
            }
        }
        
        return kd;
     
    }
    
    public void PenyakitPasien(javax.swing.JComboBox penyakitBx){
        ResultSet rs = null;
        ArrayList<String> s = new ArrayList();
        int i=0;
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        String kd;
        
        try {
            rs = k.koneksikan("SELECT * FROM `info penyakit`");
           // rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           // rs.next();
            while(rs.next()){
                s.add(rs.getString("Nama Penyakit"));
                m.addElement(rs.getString("Nama Penyakit"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        //m.addElement(s);
        penyakitBx.setModel(m);
    }
    
    public void setPenyakitLabel(javax.swing.JComboBox penyakitBx,javax.swing.JLabel kode, javax.swing.JLabel kategori) throws SQLException{
        String s = (String)penyakitBx.getSelectedItem();
        ResultSet rs = null;
        try {
            rs = k.koneksikan("SELECT * FROM `info penyakit` WHERE `Nama penyakit` = '"+s+"'");
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        kode.setText(rs.getString("kode penyakit"));
        kategori.setText(rs.getString("Kategori"));
        
      
    }
    
    
    public void setPerawatan(org.jdesktop.swingx.JXDatePicker In, org.jdesktop.swingx.JXDatePicker out,
            String dokter, String perawat, String kdPas, String kdRuang, String kdper) throws SQLException{
        String dateIn,dateOut;
        String NIPDok = null,NIPPer = null;
        Date in = In.getDate();
        Date Out = out.getDate();
        
        DateFormat dtform = new SimpleDateFormat("yyyy-MM-dd");
        dateIn = dtform.format(in);
        dateOut = dtform.format(Out);
        
        ResultSet rs = null;
        try {
            rs = k.koneksikan("SELECT * FROM `kepegawaian` WHERE `Nama` = '"+dokter+"' OR `nama` = '"+perawat+"'");
        } catch (SQLException ex) {
            Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(rs.next()){
            if(rs.getString("Profesi").equals("Dokter")){
                NIPDok = rs.getString("NIP");   
            }else{
                NIPPer = rs.getString("NIP");
            }
        }
        
        insert("INSERT INTO `perawatan` VALUES ('"+kdper+"','"+kdPas+"','"+NIPDok+"','"+NIPPer+"')");
        insert("INSERT INTO `penempatan` VALUES ('"+this.getKdPT()+"','"+kdRuang+"','"+kdPas+"','"+dateIn+"','"+dateOut+"')");
    }
    
    
    public String getKdPT() throws SQLException{
        ResultSet rs = null;
        String KdPT = null;
        String kd = null;
        int no;
        try {
            rs = k.koneksikan("SELECT `kode penempatan` FROM penempatan");
        } catch (SQLException ex) {
            Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(rs.next()){
            try {
                KdPT = rs.getString("Kode Penempatan");
                        } catch (SQLException ex) {
                Logger.getLogger(TambahPasien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        kd = KdPT.substring(2);
        no = Integer.parseInt(kd);
        no++;
        if(no<10){
            KdPT = "PT00"+Integer.toString(no);
        }else if(no>9&&no<99){
            KdPT = "PT0"+Integer.toString(no);
        }else{
            KdPT = "PT"+Integer.toString(no);
        }
             
        return KdPT;
    }
}
