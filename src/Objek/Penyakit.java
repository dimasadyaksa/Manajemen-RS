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
public class Penyakit {
    private String kodePenyakit;
    private String namaPenyakit;
    private String Kategori;

    public Penyakit(String kodePenyakit, String namaPenyakit, String Kategori) {
        this.kodePenyakit = kodePenyakit;
        this.namaPenyakit = namaPenyakit;
        this.Kategori = Kategori;
    }

    public String getKodePenyakit() {
        return kodePenyakit;
    }

    public void setKodePenyakit(String kodePenyakit) {
        this.kodePenyakit = kodePenyakit;
    }

    public String getNamaPenyakit() {
        return namaPenyakit;
    }

    public void setNamaPenyakit(String namaPenyakit) {
        this.namaPenyakit = namaPenyakit;
    }

    public String getKategori() {
        return Kategori;
    }

    public void setKategori(String Kategori) {
        this.Kategori = Kategori;
    }
    
    
}
