
package com.model;
import com.controller.DataBases;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;




public final class Dosen{
    private static final DataBases db = new DataBases();

    private Connection connection;
    private Statement st;

    final static ArrayList<Dosen> arrayDosen = new ArrayList<>();
           
    public String NIP;
    public String Nama;
    public String Alamat;
    public String No_Hp;
    public String Email;
    public String Prodi_Kode_Prodi;
    public String Dosen_NIP;

    public Dosen(String NIP, String Nama, String Alamat, String No_Hp, String Email, String kodepro, String Dosen_NIP) {
        this.NIP = NIP;
        this.Nama = Nama;
        this.Alamat = Alamat;
        this.No_Hp = No_Hp;
        this.Email = Email;
        this.Prodi_Kode_Prodi =kodepro;
        this.Dosen_NIP =Dosen_NIP;
    }

    public final String getDosen_NIP() {
        return Dosen_NIP;
    }

    public final void setDosen_NIP(String Dosen_NIP) {
        this.Dosen_NIP = Dosen_NIP;
    }

    public final String getProdi_Kode_Prodi() {
        return Prodi_Kode_Prodi;
    }

    public final void setProdi_Kode_Prodi(String Prodi_Kode_Prodi) {
        this.Prodi_Kode_Prodi = Prodi_Kode_Prodi;
    }

    public final String getNIP() {
        return NIP;
    }

    public final void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public final String getNama() {
        return Nama;
    }

    public final void setNama(String Nama) {
        this.Nama = Nama;
    }

    public final String getAlamat() {
        return Alamat;
    }

    public final void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public final String getNo_Hp() {
        return No_Hp;
    }

    public final void setNo_Hp(String No_Hp) {
        this.No_Hp = No_Hp;
    }

    public final String getEmail() {
        return Email;
    }

    public final void setEmail(String Email) {
        this.Email = Email;
    }
    
    public final static ArrayList<Dosen> readdosen() throws SQLException{
        arrayDosen.clear();
        String query ="SELECT *FROM dosen";
        ResultSet rs = db.executeSelectQuery(query);
        while (rs.next()) {
            String nip = rs.getString("NIP");
            String nama = rs.getString("Nama");
            String alamat = rs.getString("Alamat");
            String nohp = rs.getString("No_Hp");
            String email = rs.getString("Email");
            String kodepro = rs.getString("Prodi_Kode_Prodi");
            String DsnNIP = rs.getString("Dosen_NIP");
            Dosen dosenbaru= new Dosen(nip,nama,alamat,nohp,email,kodepro,DsnNIP);
            arrayDosen.add(dosenbaru);
        }
        return arrayDosen;
    }
    
    public final static void createDosen(String nip, String nama, String alamat, String nohp, String email, String kodeprodi, String DsnNIP) throws SQLException{
        Dosen dosenBaru = new Dosen(nip, nama, alamat, nohp, email, kodeprodi,DsnNIP);
        arrayDosen.add(dosenBaru);
        String query = String.format("INSERT INTO dosen VALUES ('%s','%s','%s','%s','%s','%s','%s')",
                dosenBaru.getNIP(),dosenBaru.getNama(),dosenBaru.getAlamat(),dosenBaru.getNo_Hp(),dosenBaru.getEmail(), dosenBaru.getProdi_Kode_Prodi(),dosenBaru.getDosen_NIP());
        db.executeUpdateQuery(query);
    }
     
    public final static void deleteDosen(String nip) throws SQLException{
        for (Dosen dosen : arrayDosen) {
            if (dosen.getNIP().equals(nip)) {
                arrayDosen.remove(dosen);
                String query = String.format("DELETE FROM dosen WHERE NIP = '%s'", dosen.getNIP());
                db.executeUpdateQuery(query);
                break;
            }
        }
    }
    public final static void updateDosen(String nip, String nama, String alamat, String nohp, String email, String kodepro, String dosennip) throws SQLException{
        for (Dosen dosen : arrayDosen) {
            if (dosen.getNIP().equals(nip)) {
                dosen.setNama(nama);
                dosen.setAlamat(alamat);
                dosen.setNo_Hp(nohp);
                dosen.setEmail(email);
                dosen.setProdi_Kode_Prodi(kodepro);
                dosen.setDosen_NIP(dosennip);
  
                
                String query = String.format("UPDATE dosen SET Nama = '%s', Alamat = '%s', No_Hp ='%s', Email ='%s', Dosen_NIP = '%s' WHERE NIP = '%s' ",
                        dosen.getNIP(),dosen.getNama(),dosen.Alamat,dosen.getNo_Hp(),dosen.getEmail(), dosen.Prodi_Kode_Prodi, dosen.getDosen_NIP());
                db.executeUpdateQuery(query);
            }
        }
    }   
}
