/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackgroundWork;

import Objek.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dimas Adiyaksa
 */
public class crud {
    koneksi kon = new koneksi();
    ResultSet rs = null;
    int count;
    public void deletePas(String id,List pasien,int idx){
        kon.insert("DELETE FROM pasien WHERE `kode pasien` = '"+id+"' ");
        ArrayList <Pasien> p = new ArrayList<>();
        p = pasien.getList();
        p.remove(idx);
    }
    
    public void deletePeg(String id,List peg,int idx){
        try {
            rs = kon.koneksikan("SELECT COUNT(*) FROM perawatan WHERE `perawatan`.`Kode Dokter` = "+id+" "
                    + "OR `perawatan`.`kode perawat` = "+id+"");
            rs.next();
            count = Integer.parseInt(rs.getString("COUNT(*)"));
        } catch (SQLException ex) {
            Logger.getLogger(crud.class.getName()).log(Level.SEVERE, null, ex);
        }
       if(count==0){
        kon.insert("DELETE FROM kepegawaian WHERE `nip` = '"+id+"' ");
        ArrayList <Pegawai> p = new ArrayList<>();
        p = peg.getListPeg();
        p.remove(idx);
       }else{
           JOptionPane.showMessageDialog(null, "Tidak dapat dihapus!\nSedang merawat pasien");
       }
    }
    
    public void deleteRuang(String id,List R,int idx){
        kon.insert("DELETE FROM ruangan WHERE `kode ruang` = '"+id+"' ");
        ArrayList <ruangan> p = new ArrayList<>();
        p = R.getListRuang();
        p.remove(idx);
    }
    
    public void deletePeny(String id){
        kon.insert("DELETE FROM `info penyakit` WHERE `kode penyakit` = '"+id+"' ");
    }
}
