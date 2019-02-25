package Objek;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dimas Adiyaksa
 */
public class Pasien extends Orang{
    private int umur;
    private String kodePerawatan;
    private String kodeRuang;
    private String kodePenyakit;
    private Penyakit sakit;
    private Pegawai dokter;
    private Pegawai perawat;
    private String in;
    private String out;
    private String crDateIn;
    private String crDateOut;
    private String DokterName;
    private String PerawatName;
    
public Pasien(String id,String nama,String jenisKelamin,
        String alamat,int umur, String kodePerawatan, String kodeRuang, String kodePenyakit) {
         super.setNama(nama);
        super.setId(id);
        super.setJenis_kelamin(jenisKelamin);
        super.setAlamat(alamat);
        this.umur = umur;
        this.kodePerawatan = kodePerawatan;
        this.kodeRuang = kodeRuang;
        this.kodePenyakit = kodePenyakit;
        
        //To change body of generated methods, choose Tools | Templates.
    }
    public Pasien(String id,String nama,String jenisKelamin,
        String alamat,int umur, String kodePerawatan, String kodeRuang, 
        String kodePenyakit, Penyakit sakit, Pegawai dokter, Pegawai perawat) {
        
        super.setNama(nama);
        super.setId(id);
        super.setJenis_kelamin(jenisKelamin);
        super.setAlamat(alamat);
        this.umur = umur;
        this.kodePerawatan = kodePerawatan;
        this.kodeRuang = kodeRuang;
        this.kodePenyakit = kodePenyakit;
        this.sakit = sakit;
        this.dokter = dokter;
        this.perawat = perawat;
    }
    
    public Pasien(String id,String nama,String jenisKelamin,
        String alamat,int umur, String kodePerawatan, String kodeRuang, String kodePenyakit, String in,String out) {
        super.setNama(nama);
        super.setId(id);
        super.setJenis_kelamin(jenisKelamin);
        super.setAlamat(alamat);
        this.umur = umur;
        this.kodePerawatan = kodePerawatan;
        this.kodeRuang = kodeRuang;
        this.kodePenyakit = kodePenyakit;
        this.out = out;
        this.in = in;
    }

    public Pasien(){
        
    };

    public String getDokterName() {
        return DokterName;
    }

    public void setDokterName(String DokterName) {
        this.DokterName = DokterName;
    }

    public String getPerawatName() {
        return PerawatName;
    }

    public void setPerawatName(String PerawatName) {
        this.PerawatName = PerawatName;
    }

    
    
    public String getCrDateIn() {
        return crDateIn;
    }

    public void setCrDateIn(String crDateIn) {
        this.crDateIn = crDateIn;
    }

    public String getCrDateOut() {
        return crDateOut;
    }

    public void setCrDateOut(String crDateOut) {
        this.crDateOut = crDateOut;
    }

    

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getKodePerawatan() {
        return kodePerawatan;
    }

    public void setKodePerawatan(String kodePerawatan) {
        this.kodePerawatan = kodePerawatan;
    }

    public String getKodeRuang() {
        return kodeRuang;
    }

    public void setKodeRuang(String kodeRuang) {
        this.kodeRuang = kodeRuang;
    }

    public String getKodePenyakit() {
        return kodePenyakit;
    }

    public void setKodePenyakit(String kodePenyakit) {
        this.kodePenyakit = kodePenyakit;
    }

    public Penyakit getSakit() {
        return sakit;
    }

    public void setSakit(Penyakit sakit) {
        this.sakit = sakit;
    }

    public Pegawai getDokter() {
        return dokter;
    }

    public void setDokter(Pegawai dokter) {
        this.dokter = dokter;
    }

    public Pegawai getPerawat() {
        return perawat;
    }

    public void setPerawat(Pegawai perawat) {
        this.perawat = perawat;
    }

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }
    
    public void print(){
        System.out.println(getId()+" "+super.getNama()+" "+getOut());
    }
    
}
