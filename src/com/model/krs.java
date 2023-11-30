
package com.model;


public class krs {
    String kode_KRS;
    String Jumlah_SKS;

    public krs(String kode_KRS, String Jumlah_SKS) {
        this.kode_KRS = kode_KRS;
        this.Jumlah_SKS = Jumlah_SKS;
    }

    public String getKode_KRS() {
        return kode_KRS;
    }

    public void setKode_KRS(String kode_KRS) {
        this.kode_KRS = kode_KRS;
    }

    public String getJumlah_SKS() {
        return Jumlah_SKS;
    }

    public void setJumlah_SKS(String Jumlah_SKS) {
        this.Jumlah_SKS = Jumlah_SKS;
    }
    
    
}
