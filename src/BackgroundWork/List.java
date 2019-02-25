
package BackgroundWork;


import Objek.*;
import GUI.*;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo_7
 */
public class List {
    private ArrayList<Pasien> ListPasien = new ArrayList<Pasien>();
    private ArrayList<Pegawai> ListPegawai = new ArrayList<Pegawai>();
    private ArrayList<ruangan> ListRuang = new ArrayList<ruangan>();
    private ArrayList<Penyakit> ListPenyakit = new ArrayList<Penyakit>();
    private final koneksi kon = new koneksi();
    
    public List (ArrayList<Pasien> P){
        this.ListPasien = P;
    }
    
    public List(){
        
    }
    
    public ArrayList<Pasien> getList(){
        return this.ListPasien;
    }
    
    public ArrayList<Pegawai> getListPeg(){
        return this.ListPegawai;
    }
    public ruangan getRuang(int idx){
        return ListRuang.get(idx);
    }
    public ArrayList<ruangan> getListRuang(){
        return this.ListRuang;
    }
    
    
    public void showAll(javax.swing.JTable Data, ArrayList<Pasien> P) throws SQLException{
         DefaultTableModel model;
        model = new DefaultTableModel(null,new String[]{
            "Kode", "Nama", "Kategori"
        });
        Object[] row = new Object[6];
        
        koneksi kon = new koneksi();
        ResultSet rs = null;
        
        try {
            rs = kon.koneksikan("SELECT * FROM pasien");
        } catch (SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(rs.next()){
            row[0] = rs.getString("kode pasien");
            row[1] = rs.getString("Nama");
            row[2] = "Pasien";
            model.addRow(row); 
        }
        
       try {
            rs = kon.koneksikan("SELECT * FROM kepegawaian");
        } catch (SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(rs.next()){
            row[0] = rs.getString("NIP");
            row[1] = rs.getString("Nama");
            if(rs.getString("Profesi").equals("Dokter")){
                row[2] = "Dokter";
            }else{
                row[2] = "Perawat";
            }
            model.addRow(row); 
        }
       
        try {
            rs = kon.koneksikan("SELECT * FROM ruangan");
        } catch (SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(rs.next()){
            row[0] = rs.getString("Kode Ruang");
            row[1] = rs.getString("Nama Ruang");
            row[2] = "Ruangan";
            model.addRow(row); 
        }
        
        try {
            rs = kon.koneksikan("SELECT * FROM `info penyakit`");
        } catch (SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(rs.next()){
            row[0] = rs.getString("Kode Penyakit");
            row[1] = rs.getString("Nama Penyakit");
            row[2] = "Penyakit";
            model.addRow(row); 
        }
        
        Data.setModel(model);
}
    
    public void cariSemua(javax.swing.JTable Data,String cari){
        DefaultTableModel model;
        model = new DefaultTableModel(null,new String[]{
            "Kode", "Nama", "Kategori"
        });
        Object[] row = new Object[3];
        for(int i = 0;i<ListPasien.size();i++){
                row[0] = ListPasien.get(i).getId();
                row[1] = ListPasien.get(i).getNama();
                row[2] = "Pasien";
                if(IsContain(row,cari)){
                  model.addRow(row);   
                } 
        }
        
        for(int i = 0;i<ListPegawai.size();i++){
            row[0] = ListPegawai.get(i).getId();
            row[1] = ListPegawai.get(i).getNama();
            if(ListPegawai.get(i).getProfesi().equals("Dokter")){
                row[2] = "Dokter";
            }else{
                row[2] = "Perawat";
            }
            if(IsContain(row,cari)){
                  model.addRow(row);   
                } 
        }
       
        for(int i = 0;i<ListRuang.size();i++){
            row[0] = ListRuang.get(i).getKodeRuang();
            row[1] = ListRuang.get(i).getNamaRuang();
            row[2] = "Ruangan";
            if(IsContain(row,cari)){
                  model.addRow(row);   
                } 
        }
        
        for(int i = 0;i<ListPenyakit.size();i++){
            row[0] = ListPenyakit.get(i).getKodePenyakit();
            row[1] = ListPenyakit.get(i).getNamaPenyakit();
            row[2] = "Penyakit";
            if(IsContain(row,cari)){
                  model.addRow(row);   
                } 
        }
        
        Data.setModel(model);
    }
    
    public void tambahRuang(){
        
        ResultSet temp = null;
        
        try {
            temp = kon.koneksikan("SELECT * FROM `ruangan`");
           // JOptionPane.showMessageDialog(null, "o");
        } catch (HeadlessException | SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        try {
            while(temp.next()){
                try {
                    ListRuang.add(new ruangan(temp.getString("Kode Ruang"),
                            temp.getString("Nama Ruang"),temp.getString("Jenis Ruang")));
                  //  JOptionPane.showMessageDialog(null, "e");
                } catch (SQLException ex) {
                    Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {    
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tambahRuang(ruangan ruang){
        ListRuang.add(ruang);
    }
    
    public void showRuang(javax.swing.JTable Data){
        DefaultTableModel model;
        model = new DefaultTableModel(null,new String[]{
            "Kode Ruang", "Nama Ruang", "Jenis Ruang"
        });
        ResultSet rs = null;
        
        try {
            rs = kon.koneksikan("SELECT * FROM ruangan");
        } catch (SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Object[] row = new Object[3];
        
        for(int i = 0;i<ListRuang.size();i++){
            row[0] = ListRuang.get(i).getKodeRuang();
            row[1] = ListRuang.get(i).getNamaRuang();
            row[2] = ListRuang.get(i).getJenisRuang();
            model.addRow(row);
        }
        
      
        Data.setModel(model);
    }
    
    public void cariRuang(javax.swing.JTable Data, String cari){
        DefaultTableModel model;
        model = new DefaultTableModel(null,new String[]{
            "Kode Ruang","Nama Ruang","Jenis Ruang"
        });
        Object[] row = new Object[3];
        for(int i = 0;i<ListRuang.size();i++){
            row[0] = ListRuang.get(i).getKodeRuang();
            row[1] = ListRuang.get(i).getNamaRuang();
            row[2] = ListRuang.get(i).getJenisRuang();
            
            if(IsContain(row,cari)){
               model.addRow(row);   
            }
            
        }
       
        Data.setModel(model);
        if(Data.getRowCount() == 0){
           JOptionPane.showMessageDialog(Data, "Data tidak ditemukan!");
        } 
    }
    public void tambahPenyakit(){
        ResultSet temp = null;
        
        try {
            temp = kon.koneksikan("SELECT * FROM `info penyakit`");
           // JOptionPane.showMessageDialog(null, "o");
        } catch (HeadlessException | SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        try {
            while(temp.next()){
                try {
                    ListPenyakit.add(new Penyakit(temp.getString("Kode Penyakit"),temp.getString("Nama Penyakit"),temp.getString("Kategori")));
                    //  JOptionPane.showMessageDialog(null, "e");
                } catch (SQLException ex) {
                    Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {    
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Pegawai getPegawai(String profesi,String nama){
        Pegawai P = null;
        for(int i = 0;i<ListPegawai.size();i++){
            if(ListPegawai.get(i).getNama().equals(nama)&&
                    ListPegawai.get(i).getProfesi().equals(profesi)){
                P = ListPegawai.get(i);
            }
        }
        return P;
    }
    
    public void showPenyakit(javax.swing.JTable Data){
        DefaultTableModel model;
        model = new DefaultTableModel(null,new String[]{
            "Kode Penyakit", "Nama Penyakit", "Kategori"
        });
        Object[] row = new Object[6];
      
        for(int i = 0;i<ListPenyakit.size();i++){
            row[0] = ListPenyakit.get(i).getKodePenyakit();
            row[1] = ListPenyakit.get(i).getNamaPenyakit();
            row[2] = ListPenyakit.get(i).getKategori();
            model.addRow(row); 
        }
       
        Data.setModel(model);
    }
    
    public void cariPenyakit(javax.swing.JTable Data, String cari){
        DefaultTableModel model;
        model = new DefaultTableModel(null,new String[]{
            "Kode Penyakit","Nama Penyakit","Kategori Penyakit"
        });
        Object[] row = new Object[7];
        for(int i = 0;i<ListPenyakit.size();i++){
            row[0] = ListPenyakit.get(i).getKodePenyakit();
            row[1] = ListPenyakit.get(i).getNamaPenyakit();
            row[2] = ListPenyakit.get(i).getKategori();
            
            if(IsContain(row,cari)){
               model.addRow(row);   
            }
            
        }
       
        Data.setModel(model);
        if(Data.getRowCount() == 0){
           JOptionPane.showMessageDialog(Data, "Data tidak ditemukan!");
        } 
    }
    
    
    public void tambahPasien() {
        Pasien p = new Pasien();
        ResultSet temp = null;
        ResultSet Penyakit = null;
        ResultSet Dokter = null;
        ResultSet Perawat = null;
        ResultSet Ruang = null;
        String dok = null;
        String per = null;
        ResultSet tgl = null;
        String pnyakit,ruang;
        try {
            temp = kon.koneksikan("SELECT * FROM `pasien` INNER JOIN `penempatan` "
                    + "ON pasien.`kode pasien`=penempatan.`kode pasien`");
           
           // JOptionPane.showMessageDialog(null, "o");
        } catch (HeadlessException | SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        int umur = 0;
        String kd = null;
        try {
            while(temp.next()){
                try {
                  //  tgl = kon.koneksikan("SELECT * FROM penempatan");
                    Penyakit = kon.koneksikan("SELECT `Nama Penyakit` FROM `info penyakit` where `Kode Penyakit` = '"+temp.getString("Kode Penyakit")+"';");
                    Ruang = kon.koneksikan("SELECT `Nama Ruang` FROM `Ruangan` where `Kode Ruang` = '"+temp.getString("Kode Ruang")+"';");
                    Dokter = kon.koneksikan("SELECT * FROM `kepegawaian` WHERE `kepegawaian`.`NIP` = "
                            + "(SELECT `perawatan`.`Kode Dokter` FROM perawatan WHERE `perawatan`.`Kode Pasien` = '"+temp.getString("Kode Pasien")+"')");
                    Perawat = kon.koneksikan("SELECT * FROM kepegawaian WHERE kepegawaian.NIP = "
                            + "(SELECT `kode perawat` FROM perawatan WHERE `kode pasien` = '"+temp.getString("Kode Pasien")+"')");
                    Dokter.next();
                    Perawat.next();
                    Penyakit.next();
                    Ruang.next();
                    //System.out.println(temp.getString("Kode Pasien"));
                    dok = Dokter.getString("Nama");
                    per = Perawat.getString("Nama");
                    pnyakit = Penyakit.getString("Nama Penyakit");
                    ruang = Ruang.getString("Nama Ruang");
                    Pasien pas = new Pasien(temp.getString("Kode Pasien"),temp.getString("Nama"),
                            temp.getString("Jenis Kelamin"),temp.getString("Alamat"),Integer.parseInt(temp.getString("Umur")),temp.getString("Kode Perawatan"),ruang
                            ,pnyakit,temp.getString("Tanggal Masuk"),temp.getString("Tanggal Keluar"));
                    pas.setDokterName(dok);
                    //System.out.println(dok);
                    //System.out.println(per);
                    pas.setPerawatName(per);
                    ListPasien.add(pas);
       
                  //  JOptionPane.showMessageDialog(null, "e");
                //    System.out.println(temp.getString("Tanggal Keluar")+" "+temp.getString("Tanggal Masuk"));
                  
                } catch (SQLException ex) {
                    Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        } catch (SQLException ex) {    
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tambahPasien(Pasien p){
        ListPasien.add(p);
    }
    
    public void showListPasien(javax.swing.JTable Data){
        DefaultTableModel model;
        model = new DefaultTableModel(null,new String[]{
            "Kode Pasien","Nama","Jenis Kelamin","Alamat","Ruang"
        });
        ResultSet psn = null;
        try {
            psn = kon.koneksikan("SELECT pasien.`kode pasien`,pasien.Nama,pasien.`Jenis Kelamin`,pasien.Alamat"
                    + ",`info penyakit`.`nama penyakit`, ruangan.`nama ruang` FROM pasien"
                    + " INNER JOIN ruangan ON ruangan.`Kode ruang`"
                    + "=pasien.`kode ruang` "
                    + "INNER JOIN `info penyakit` ON "
                    + "`info penyakit`.`kode penyakit` = pasien.`kode penyakit` ORDER BY `kode pasien`");
        } catch (SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
        Object[] row = new Object[6];
        
        try {
            while(psn.next()){
                row[0] = psn.getString("Kode Pasien");
                row[1] = psn.getString("Nama");
                row[2] = psn.getString("Jenis Kelamin");
                row[3] = psn.getString("Alamat");
                row[4] = psn.getString("Nama Ruang");
                row[5] = psn.getString("Nama Penyakit"); 
                model.addRow(row);
            }
            //for(int i = 0;i<ListPasien.size();i++){
        } catch (SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           
            
      
        //}
       
        Data.setModel(model);
    }
    
    public void cariPasien(javax.swing.JTable Data, String Cari){
        DefaultTableModel model;
        model = new DefaultTableModel(null,new String[]{
            "Kode Pasien", "Nama","Jenis Kelamin","Alamat","Ruang"
        });
        int i=0;
        Object[] row = new Object[5];
        String temp;
        ResultSet rs = null;
        try {
            rs = kon.koneksikan("SELECT * FROM pasien INNER JOIN ruangan "
                    + "ON ruangan.`kode ruang` = pasien.`kode ruang` ORDER BY `kode pasien`");
           // rs.next();
            while(rs.next()){
            row[0] = rs.getString("Kode Pasien");
            row[1] = rs.getString("Nama");
            row[2] = rs.getString("Jenis Kelamin");
            row[3] = rs.getString("Alamat");
            row[4] = rs.getString("Nama Ruang");
            
            if(IsContain(row,Cari)){
               model.addRow(row);   
            }
            i++;
        }
        } catch (SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
       
        Data.setModel(model);
        if(Data.getRowCount() == 0){
           JOptionPane.showMessageDialog(Data, "Data tidak ditemukan!");
        } 
    }
    
    public boolean IsContain(Object[] obj,String Cari){
        boolean found;
        Object tmp;
        String temp;
        Cari = Cari.toLowerCase();
        for(int i=1;i<3;i++){
            tmp = obj[i];
            temp = obj[i].toString();
            
            obj[i] = temp.toLowerCase();
            if(obj[i].toString().contains(Cari)){
                obj[i] = tmp;
                return true;
            }
            obj[i] = tmp;
        }
        return false;
    }
    
    
    public void tambahPegawai(Pegawai dokter){
        ListPegawai.add(dokter);
    }
    public void tambahPegawai(){
        Pegawai p = new Pegawai();
        ResultSet temp = null;
        
        try {
            temp = kon.koneksikan("SELECT * FROM `kepegawaian`");
           // JOptionPane.showMessageDialog(null, "o");
        } catch (HeadlessException | SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        try {
            while(temp.next()){
                try {
                    ListPegawai.add(new Pegawai(temp.getString("NIP"),temp.getString("Nama"),
                           temp.getString("Jenis Kelamin"), temp.getString("Alamat"),temp.getString("Profesi"),temp.getString("Keterangan")));
                  //  JOptionPane.showMessageDialog(null, "e");
                } catch (SQLException ex) {
                    Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {    
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showListPegawai(javax.swing.JTable Data, int pro){
     
        DefaultTableModel model;
        model = new DefaultTableModel(null,new String[]{
            "NIP", "Nama", "Alamat","Jenis Kelamin","Profesi"
        });
        ResultSet rs = null;
        try {
            rs = kon.koneksikan("SELECT * FROM kepegawaian");
        } catch (SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object[] row = new Object[6];
        
   /*     for(int i = 0;i<ListPasien.size();i++){
            row[0] = rs.getString("NIP");
            row[1] = rs.getString("Nama");
            row[2] = rs.getString("Alamat");
            row[3] = rs.getString("Jenis Kelamin");
            row[4] = rs.getString("Profesi");
//                row[5] = rs.getString("Keterangan");
            if(pro==1&&row[4].equals("Dokter")){
                model.addRow(row);
            }
                
            if(pro==2&&row[4].equals("Perawat")){
                model.addRow(row);
                }
        }
      */  
        try {
            while(rs.next()) {
                row[0] = rs.getString("NIP");
                row[1] = rs.getString("Nama");
                row[2] = rs.getString("Alamat");
                row[3] = rs.getString("Jenis Kelamin");
                row[4] = rs.getString("Profesi");
//                row[5] = rs.getString("Keterangan");
                if(pro==1&&row[4].equals("Dokter")){
                    model.addRow(row);
                }
                
                if(pro==2&&row[4].equals("Perawat")){
                    model.addRow(row);
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        Data.setModel(model);
    }
    
    public void CariDokter(javax.swing.JTable Data, String cari,int pro){
        DefaultTableModel model;
        
        model = new DefaultTableModel(null,new String[]{
            "No","NIP", "Nama", "Alamat","Jenis Kelamin","Profesi","Keterangan"
        });
        Object[] row = new Object[7];
        int x=0;
        for(int i = 0;i<ListPegawai.size();i++){
            
            row[1] = ListPegawai.get(i).getId();
            row[2] = ListPegawai.get(i).getNama();
            row[3] = ListPegawai.get(i).getAlamat();
            row[4] = ListPegawai.get(i).getJenis_kelamin();
            row[5] = ListPegawai.get(i).getProfesi();
            row[6] = ListPegawai.get(i).getKeterangan();
            
            if(pro == 1){
                if(IsContain(row,cari)&&row[5].equals("Dokter")){
                     row[0] = x+1;
                   model.addRow(row);   
                   x++;
                } 
            }else{
                if(IsContain(row,cari)&&row[5].equals("Perawat")){
                    row[0] = x+1;
                    model.addRow(row);   
                    x++;
                } 
            }
        }
       
        Data.setModel(model);
      /*  if(Data.getRowCount()==0){
            JOptionPane.showMessageDialog(Data, "Data tidak ditemukan!");
        }*/
    }
    
    public Pasien getPasien(int idx){
        return ListPasien.get(idx);
    }
    
}
