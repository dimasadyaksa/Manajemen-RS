package Objek;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo_7
 */
public class Pegawai extends Orang{
    private String profesi;
    private String keterangan;

    public Pegawai(String id,String nama,String jenisKelamin,String alamat,String profesi,String keterangan){
        super.setId(id);
        super.setNama(nama);
        super.setJenis_kelamin(jenisKelamin);
        super.setAlamat(alamat);
        this.profesi = profesi;
        this.keterangan = keterangan;
    }   
    
    public Pegawai(String id,String nama,String jenisKelamin,String alamat,String profesi){
        super.setId(id);
        super.setNama(nama);
        super.setJenis_kelamin(jenisKelamin);
        super.setAlamat(alamat);
        this.profesi = profesi;
    } 

    public Pegawai() {
    }
    
    public String getProfesi() {
        return profesi;
    }

    public void setProfesi(String profesi) {
        this.profesi = profesi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
}
