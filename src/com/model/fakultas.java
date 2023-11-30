
package com.model;

import com.controller.DataBases;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class fakultas {
    private final DataBases db = new DataBases();
    private Connection connection;
    private Statement st;
    
    String Kode_fakultas;
    String Nama_Fakultas;
    
    ArrayList<fakultas> arrayfkt = new ArrayList<>();

    public fakultas(String Kode_fakultas, String NamaFakultas) {
        this.Kode_fakultas = Kode_fakultas;
        this.Nama_Fakultas = NamaFakultas;
    }

    public final String getKode_fakultas() {
        return Kode_fakultas;
    }

    public final void setKode_fakultas(String Kode_fakultas) {
        this.Kode_fakultas = Kode_fakultas;
    }

    public final String getNama_Fakultas() {
        return Nama_Fakultas;
    }

    public final void setNama_Fakultas(String Nama_Fakultas) {
        this.Nama_Fakultas = Nama_Fakultas;
    }
    
    public final ArrayList<fakultas> readfakultas() throws SQLException{
        String query ="SELECT *FROM fakultas";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String kode_fakultas = rs.getString("Kode_fakultas");
            String nama_fakultas = rs.getString("Nama_Fakultas");
            
            fakultas FakultasBaru= new fakultas(kode_fakultas,nama_fakultas);
            arrayfkt.add(FakultasBaru);
        }
        return arrayfkt;
    }
    
    public final void createfakultas(String kode_fakultas, String nama_fakultas) throws SQLException{
        fakultas fakultasBaru = new fakultas(kode_fakultas, nama_fakultas);
        String query = String.format("INSERT INTO fakultas VALUES ('%s','%s')",
                fakultasBaru.getKode_fakultas(),fakultasBaru.getNama_Fakultas());
        db.executeUpdateQuery(query);
    }
    
    public final void deletefakultas(String kode_fakultas) throws SQLException{
        for (fakultas Fakultas : arrayfkt) {
            if (Fakultas.getKode_fakultas().equals(kode_fakultas)) {
                arrayfkt.remove(Fakultas);
                String query = String.format("DELETE FROM fakultas WHERE Kode_fakultas = '%s'", Fakultas.getKode_fakultas());
                db.executeUpdateQuery(query);
                break;
            }
        }
    }
    
    public final void updatefakultas(String kode_fakultas, String nama_fakultas) throws SQLException{
        for (fakultas Fakultas : arrayfkt) {
            if (Fakultas.getKode_fakultas().equals(kode_fakultas)) {
                Fakultas.setNama_Fakultas(nama_fakultas);

                String query = String.format("UPDATE fakultas SET Nama_fakultas = '%s' WHERE Kode_fakultas = '%s' ",
                        Fakultas.getKode_fakultas(),Fakultas.getNama_Fakultas());
                db.executeUpdateQuery(query);
            }
        }
    }
}
