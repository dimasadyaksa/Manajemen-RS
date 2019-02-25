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
public class ruangan {
    private String namaRuang;
    private String kodeRuang;
    private String jenisRuang;
    private int jmlPas;

    public ruangan(String kodeRuang, String namaRuang, String jenisRuang) {
        this.namaRuang = namaRuang;
        this.kodeRuang = kodeRuang;
        this.jenisRuang = jenisRuang;
    }

    public ruangan() {
       
    }

    public String getNamaRuang() {
        return namaRuang;
    }

    public void setNamaRuang(String namaRuang) {
        this.namaRuang = namaRuang;
    }

    public String getKodeRuang() {
        return kodeRuang;
    }

    public void setKodeRuang(String kodeRuang) {
        this.kodeRuang = kodeRuang;
    }

    public String getJenisRuang() {
        return jenisRuang;
    }

    public void setJenisRuang(String jenisRuang) {
        this.jenisRuang = jenisRuang;
    }
    
    
    
}
