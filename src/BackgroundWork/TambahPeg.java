/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackgroundWork;

/**
 *
 * @author Dimas Adiyaksa
 */
public class TambahPeg {
    koneksi kon = new koneksi();
    
    public void tambah(String sql){
        kon.insert(sql);
    }
}
