
package com.model;

import com.controller.DataBases;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public final class prodi {
    private final DataBases db = new DataBases();
    private Connection connection;
    private Statement st;
    
    
    ArrayList<prodi>Arrarprodi = new ArrayList<>();
    
    String Kode_Prodi;
    String Nama_Prodi;

    public prodi(String KodeProdi, String NamaProdi) {
        this.Kode_Prodi = KodeProdi;
        this.Nama_Prodi = NamaProdi;
    }

    public String getKode_Prodi() {
        return Kode_Prodi;
    }

    public void setKode_Prodi(String Kode_Prodi) {
        this.Kode_Prodi = Kode_Prodi;
    }

    public String getNama_Prodi() {
        return Nama_Prodi;
    }

    public void setNama_Prodi(String Nama_Prodi) {
        this.Nama_Prodi = Nama_Prodi;
    }
    
    public void createprodi(String kode_prodi, String nama_prodi) throws SQLException{
        prodi ProdiBaru = new prodi(kode_prodi, nama_prodi);
        String query = String.format("INSERT INTO prodi VALUES ('%s','%s')",
                ProdiBaru.getKode_Prodi(),ProdiBaru.getNama_Prodi());
        db.executeUpdateQuery(query);
    }
    
     public ArrayList<prodi> readprodi() throws SQLException{
        String query ="SELECT *FROM prodi";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String kode_prodi = rs.getString("Kode_Prodi");
            String nama_prodi = rs.getString("Nama_Prodi");
            
            prodi ProdiBaru= new prodi(kode_prodi,nama_prodi);
            Arrarprodi.add(ProdiBaru);
        }
        return Arrarprodi;
    }
    
    public void deleteprodi(String kode_prodi) throws SQLException{
        for (prodi Prodi : Arrarprodi) {
            if (Prodi.getKode_Prodi().equals(kode_prodi)) {
                Arrarprodi.remove(Prodi);
                String query = String.format("DELETE FROM prodi WHERE Kode_Prodi = '%s'", Prodi.getKode_Prodi());
                db.executeUpdateQuery(query);
                break;
            }
        }
    }
    
    public void updateprodi(String kode_prodi, String nama_prodi) throws SQLException{
        for (prodi Prodi : Arrarprodi) {
            if (Prodi.getKode_Prodi().equals(kode_prodi)) {
                Prodi.setNama_Prodi(nama_prodi);

                String query = String.format("UPDATE fakultas SET Nama_prodi = '%s' WHERE Kode_Prodi = '%s' ",
                        Prodi.getKode_Prodi(),Prodi.getNama_Prodi());
                db.executeUpdateQuery(query);
            }
        }
    }
}
