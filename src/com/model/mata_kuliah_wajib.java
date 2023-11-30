
package com.model;

import com.controller.DataBases;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


abstract class mata_kuliah_wajib extends Mata_Kuliah{
    private DataBases db = new DataBases();
    private Connection connection;
    private Statement st;
    
    ArrayList<mata_kuliah_wajib> arraymkw = new ArrayList<>();

    public mata_kuliah_wajib(String Kode_MK, String Nama_MK, String SKS, String Semester, String Praktikum, String DosenNIP) {
        super(Kode_MK, Nama_MK, SKS, Semester, Praktikum, DosenNIP);
    }


    @Override
    public void setPraktikum(String Praktikum) {
        super.setPraktikum(Praktikum);
    }

    @Override
    public String getPraktikum() {
        return super.getPraktikum(); 
    }

    @Override
    public void setSemester(String Semester) {
        super.setSemester(Semester); 
    }

    @Override
    public String getSemester() {
        return super.getSemester(); 
    }

    @Override
    public void setSKS(String SKS) {
        super.setSKS(SKS); 
    }

    @Override
    public String getSKS() {
        return super.getSKS();
    }

    @Override
    public void setNama_MK(String Nama_MK) {
        super.setNama_MK(Nama_MK); 
    }

    @Override
    public String getNama_MK() {
        return super.getNama_MK(); 
    }

    @Override
    public void setKode_MK(String Kode_MK) {
        super.setKode_MK(Kode_MK); 
    }

    @Override
    public String getKode_MK() {
        return super.getKode_MK(); 
    }
    
    public final ArrayList<mata_kuliah_wajib> readmata_kuliah_wajib() throws SQLException{
        String query ="SELECT *FROM mata_kuliah_wajib";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String kode_matakuliah = rs.getString("Kode_MK");
            String nama_matakuliah = rs.getString("Nama_MK");
            String sks = rs.getString("SKS");
            String semester = rs.getString("Semester");
            String praktikum= rs.getString("Praktikum");
            String Dsnnp    = rs.getString("Dosen_NIP");
            mata_kuliah_wajib matakuliahwajibbaru= new mata_kuliah_wajib(kode_matakuliah,nama_matakuliah,sks,semester,praktikum, Dsnnp) {};
            arraymk.add(matakuliahwajibbaru);
        }
        return arraymkw;
    }
    
    public final void createmata_kuliah_wajib(String kode_matakuliah, String nama_matakuliah, String sks, String semester, String praktikum, String DosenNIP) throws SQLException{
        mata_kuliah_wajib matakuliahwajibBaru = new mata_kuliah_wajib(kode_matakuliah, nama_matakuliah, sks, semester, praktikum, DosenNIP) {};
        String query = String.format("INSERT INTO mata_kuliah_wajib VALUES ('%s','%s','%s','$s','$s', '%s')",
                matakuliahwajibBaru.getKode_MK(),matakuliahwajibBaru.getNama_MK(),matakuliahwajibBaru.getSKS(),matakuliahwajibBaru.getSemester(),matakuliahwajibBaru.getPraktikum());
        st.execute(query);
    }
    
    public final void deletemata_kuliah_wajib(String kode_matakuliah) throws SQLException{
        for (mata_kuliah_wajib matakuliahwajib : arraymkw) {
            if (matakuliahwajib.getKode_MK().equals(kode_matakuliah)) {
                arraymkw.remove(matakuliahwajib);
                String query = String.format("DELETE FROM mata_kuliah_wajib WHERE Kode_MK = '%s'", matakuliahwajib.getKode_MK());
                db.executeUpdateQuery(SKS);
                break;
            }
        }
    }
    
    public final void updatemata_kuliah_wajib(String kode_matakuliah, String nama_matakuliah, String sks, String semester, String praktikum) throws SQLException{
        for (mata_kuliah_wajib matakuliahwajib : arraymkw) {
            if (matakuliahwajib.getKode_MK().equals(kode_matakuliah)) {
                matakuliahwajib.setNama_MK(nama_matakuliah);
                matakuliahwajib.setSKS(sks);
                matakuliahwajib.setSemester(semester);
                matakuliahwajib.setPraktikum(praktikum);
  
                
                String query = String.format("UPDATE mata_kuliah_wajib SET Nama_MK = '%s', SKS = '%s',Semester ='%s', Praktikum ='%s' WHERE Kode_MK = '%s' ",
                        matakuliahwajib.getKode_MK(),matakuliahwajib.getNama_MK(),matakuliahwajib.getSKS(),matakuliahwajib.getSemester(),matakuliahwajib.getPraktikum());
                st.execute(query);
            }
        }
    }
    
    
}
