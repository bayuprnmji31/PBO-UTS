
package com.model;

import com.controller.DataBases;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


abstract class mata_kuliah_peminatan extends Mata_Kuliah{
    
    private final DataBases db = new DataBases();
    private Connection connection;
    private Statement st;
    
    ArrayList<mata_kuliah_peminatan> arraymkp = new ArrayList<>();
    String MK_Prasyarat;

    
    public mata_kuliah_peminatan(String MK_Prasyarat, String Kode_MK, String Nama_MK, String SKS, String Semester, String Praktikum, String DosenNIP) {
        super(Kode_MK, Nama_MK, SKS, Semester, Praktikum, DosenNIP);
        this.MK_Prasyarat = MK_Prasyarat;
    }

    @Override
    public void setDosen_NIP(String Dosen_NIP) {
        super.setDosen_NIP(Dosen_NIP); 
    }

    @Override
    public String getDosen_NIP() {
        return super.getDosen_NIP(); 
    }

    public String getMK_Prasyarat() {
        return MK_Prasyarat;
    }

    public void setMK_Prasyarat(String MK_Prasyarat) {
        this.MK_Prasyarat = MK_Prasyarat;
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
    
    public ArrayList<mata_kuliah_peminatan> readmata_kuliah_peminatan() throws SQLException{
        String query ="SELECT *FROM mata_kuliah_peminatan";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String kode_matakuliah = rs.getString("Kode_MK");
            String nama_matakuliah = rs.getString("Nama_MK");
            String sks = rs.getString("SKS");
            String semester = rs.getString("Semester");
            String praktikum= rs.getString("Praktikum");
            String DosenNIP = rs.getString("Dosen_NIP");
            String prasyarat= rs.getString("MK_Prasyarat");
            mata_kuliah_peminatan matakuliahpeminatanbaru= new mata_kuliah_peminatan(kode_matakuliah,nama_matakuliah,sks,semester,praktikum,DosenNIP, prasyarat) {};
            arraymkp.add(matakuliahpeminatanbaru);
        }
        return arraymkp;
    }
    
    public void createmata_kuliah_peminatan(String kode_matakuliah, String nama_matakuliah, String sks, String semester, String praktikum, String prasyarat) throws SQLException{
        mata_kuliah_peminatan matakuliahpeminatanBaru = new mata_kuliah_peminatan(kode_matakuliah, nama_matakuliah, sks, semester, praktikum,Dosen_NIP, prasyarat) {};
        String query = String.format("INSERT INTO mata_kuliah_peminatan VALUES ('%s','%s','%s','$s','$s')",
                matakuliahpeminatanBaru.getKode_MK(),matakuliahpeminatanBaru.getNama_MK(),matakuliahpeminatanBaru.getSKS(),matakuliahpeminatanBaru.getSemester(),matakuliahpeminatanBaru.getPraktikum(), matakuliahpeminatanBaru.getMK_Prasyarat());
        st.execute(query);
    }
    
    public void deletemata_kuliah_peminatan(String kode_matakuliah) throws SQLException{
        for (mata_kuliah_peminatan matakuliahpeminatan : arraymkp) {
            if (matakuliahpeminatan.getKode_MK().equals(kode_matakuliah)) {
                arraymkp.remove(matakuliahpeminatan);
                String query = String.format("DELETE FROM mata_kuliah_peminatan WHERE Kode_MK = '%s'", matakuliahpeminatan.getKode_MK());
                st.execute(query);
                break;
            }
        }
    }
    
    public void updatemata_kuliah_wajib(String kode_matakuliah, String nama_matakuliah, String sks, String semester, String praktikum, String prasyarat) throws SQLException{
        for (mata_kuliah_peminatan matakuliahpeminatan : arraymkp) {
            if (matakuliahpeminatan.getKode_MK().equals(kode_matakuliah)) {
                matakuliahpeminatan.setNama_MK(nama_matakuliah);
                matakuliahpeminatan.setSKS(sks);
                matakuliahpeminatan.setSemester(semester);
                matakuliahpeminatan.setPraktikum(praktikum);
                matakuliahpeminatan.setMK_Prasyarat(prasyarat);
  
                
                String query = String.format("UPDATE mata_kuliah_peminatan SET Nama_MK = '%s', SKS = '%s',Semester ='%s', Praktikum ='%s',MK_Prasyarat='$s' WHERE Kode_MK = '%s' ",
                        matakuliahpeminatan.getKode_MK(),matakuliahpeminatan.getNama_MK(),matakuliahpeminatan.getSKS(),matakuliahpeminatan.getSemester(),matakuliahpeminatan.getPraktikum(), matakuliahpeminatan.getMK_Prasyarat());
                st.execute(query);
            }
        }
    }

}
