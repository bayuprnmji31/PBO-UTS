
package com.model;

import com.controller.DataBases;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Mata_Kuliah {
    private static final DataBases db = new DataBases();


    private Connection connection;
    static private Statement st;
    
    
    final static ArrayList<Mata_Kuliah> arraymk = new ArrayList<>();
            
    protected String Kode_MK;
    protected String Nama_MK;
    protected String SKS;
    protected String Semester;
    protected String Praktikum;
    protected String Dosen_NIP;

    public Mata_Kuliah(String Kode_MK, String Nama_MK, String SKS, String Semester, String Praktikum, String DosenNIP) {
        this.Kode_MK = Kode_MK;
        this.Nama_MK = Nama_MK;
        this.SKS = SKS;
        this.Semester = Semester;
        this.Praktikum = Praktikum;
        this.Dosen_NIP =DosenNIP;
        
    }

    public String getKode_MK() {
        return Kode_MK;
    }

    public void setKode_MK(String Kode_MK) {
        this.Kode_MK = Kode_MK;
    }

    public String getNama_MK() {
        return Nama_MK;
    }

    public void setNama_MK(String Nama_MK) {
        this.Nama_MK = Nama_MK;
    }

    public String getSKS() {
        return SKS;
    }

    public void setSKS(String SKS) {
        this.SKS = SKS;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public String getPraktikum() {
        return Praktikum;
    }

    public void setPraktikum(String Praktikum) {
        this.Praktikum = Praktikum;
    }

    public String getDosen_NIP() {
        return Dosen_NIP;
    }

    public void setDosen_NIP(String Dosen_NIP) {
        this.Dosen_NIP = Dosen_NIP;
    }
    
    public static ArrayList<Mata_Kuliah> readMata_Kuliah() throws SQLException{
        arraymk.clear();
        String query ="SELECT *FROM mata_kuliah";
        ResultSet rs = db.executeSelectQuery(query);
        while (rs.next()) {
            String kode_matakuliah = rs.getString("Kode_MK");
            String nama_matakuliah = rs.getString("Nama_MK");
            String sks = rs.getString("SKS");
            String semester = rs.getString("Semester");
            String praktikum= rs.getString("Praktikum");
            String Dosennp= rs.getString("Dosen_NIP");
            Mata_Kuliah matakuliahbaru= new Mata_Kuliah(kode_matakuliah,nama_matakuliah,sks,semester,praktikum, Dosennp) {};
            arraymk.add(matakuliahbaru);
        }
        return arraymk;
    }
    
    public static void createMata_Kuliah(String kode_matakuliah, String nama_matakuliah, String sks, String semester, String praktikum, String Dosennp) throws SQLException{
        Mata_Kuliah matakuliahBaru = new Mata_Kuliah(kode_matakuliah, nama_matakuliah, sks, semester, praktikum,Dosennp);
        String query = String.format("INSERT INTO mata_kuliah VALUES ('%s','%s','%s','%s','%s','%s')",
                matakuliahBaru.getKode_MK(),matakuliahBaru.getNama_MK(),matakuliahBaru.getSKS(),matakuliahBaru.getSemester(),matakuliahBaru.getPraktikum(),matakuliahBaru.getDosen_NIP());
        db.executeUpdateQuery(query);
    }
    
    public static void deleteMata_Kuliah(String kode_matakuliah) throws SQLException{
        for (Mata_Kuliah matakuliah : arraymk) {
            if (matakuliah.getKode_MK().equals(kode_matakuliah)) {
                arraymk.remove(matakuliah);
                String query = String.format("DELETE FROM mata_kuliah WHERE Kode_MK = '%s'", matakuliah.getKode_MK());
                db.executeUpdateQuery(query);
                break;
            }
        }
    }
    
    public static void updateMata_Kuliah(String kode_matakuliah, String nama_matakuliah, String sks, String semester, String praktikum) throws SQLException{
        for (Mata_Kuliah matakuliah : arraymk) {
            if (matakuliah.getKode_MK().equals(kode_matakuliah)) {
                matakuliah.setNama_MK(nama_matakuliah);
                matakuliah.setSKS(sks);
                matakuliah.setSemester(semester);
                matakuliah.setPraktikum(praktikum);
  
                
                String query = String.format("UPDATE mata_kuliah SET Nama_MK = '%s', SKS = '%s',Semester ='%s', Praktikum ='%s' WHERE Kode_MK = '%s' ",
                        matakuliah.getKode_MK(),matakuliah.getNama_MK(),matakuliah.getSKS(),matakuliah.getSemester(),matakuliah.getPraktikum());
                st.execute(query);
            }
        }
    }
}
