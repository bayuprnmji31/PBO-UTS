package com.model;
import com.controller.DataBases;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public final class Mahasiswa{

    private static final DataBases db = new DataBases();
    private Connection connection;
    static private Statement st;

    public  String NIM;
    public  String Nama;
    public  String Alamat;
    public  String No_Hp;
    public  String Email; 
    public String Prodi_Kode_Prodi;
    
    static ArrayList<Mahasiswa>arraymhs=new ArrayList<>();

    public Mahasiswa(String NIM, String Nama, String Alamat, String No_Hp, String Email, String Prodi_Kode_Prodi) {
        this.NIM = NIM;
        this.Nama = Nama;
        this.Alamat = Alamat;
        this.No_Hp = No_Hp;
        this.Email = Email;
        this.Prodi_Kode_Prodi = Prodi_Kode_Prodi;
    }

    public final String getProdi_Kode_Prodi() {
        return Prodi_Kode_Prodi;
    }

    public final void setProdi_Kode_Prodi(String Prodi_Kode_Prodi) {
        this.Prodi_Kode_Prodi = Prodi_Kode_Prodi;
    }

    public final String getNIM() {
        return NIM;
    }

    public final void setNIM(String NIM) {
        this.NIM = NIM;
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
    
    public final static ArrayList<Mahasiswa> readmahasiswa() throws SQLException{
        arraymhs.clear();
        String query ="SELECT * FROM mahasiswa";
        ResultSet rs = db.executeSelectQuery(query);
        while (rs.next()) {
            String nim = rs.getString("NIM");
            String nama = rs.getString("Nama");
            String alamat = rs.getString("Alamat");
            String nohp = rs.getString("No_Hp");
            String email = rs.getString("Email");
            String kodepro = rs.getString("Prodi_Kode_Prodi");
            Mahasiswa mahasiswabaru= new Mahasiswa(nim,nama,alamat,nohp,email,kodepro);
            arraymhs.add(mahasiswabaru);
        }
        return arraymhs;
    }
    
    public final static void createMahasiswa(String nim, String nama, String alamat, String nohp, String email, String kodepro) throws SQLException{
        Mahasiswa mahasiswaBaru = new Mahasiswa(nim, nama, alamat, nohp, email,kodepro);
        arraymhs.add(mahasiswaBaru);
        String query = String.format("INSERT INTO mahasiswa VALUES ('%s','%s','%s','%s','%s','%s')",
                mahasiswaBaru.getNIM(),mahasiswaBaru.getNama(),mahasiswaBaru.getAlamat(),mahasiswaBaru.getNo_Hp(),mahasiswaBaru.getEmail(), mahasiswaBaru.getProdi_Kode_Prodi());
        db.executeUpdateQuery(query);
    }
    
    public final static void deleteMahasiswa(String nim) throws SQLException{
        for (Mahasiswa mahasiswa : arraymhs) {
            if (mahasiswa.getNIM().equals(nim)) {
                arraymhs.remove(mahasiswa);
                String query = String.format("DELETE FROM mahasiswa WHERE NIM = '%s'", mahasiswa.getNIM());
                db.executeUpdateQuery(query);
                break;
            }
        }
    }
    
    public final static void updateMahasiswa(String nim, String nama, String alamat, String nohp, String email, String kodepro ) throws SQLException{
        for (Mahasiswa mahasiswa : arraymhs) {
            if (mahasiswa.getNIM().equals(nim)) {
                mahasiswa.setNama(nama);
                mahasiswa.setAlamat(alamat);
                mahasiswa.setNo_Hp(nohp);
                mahasiswa.setEmail(email);
                mahasiswa.setProdi_Kode_Prodi(kodepro);
               
                
                String query = String.format("UPDATE mahasiswa SET Nama = '%s', Alamat = '%s', No_Hp ='%s', Email ='%s',Prodi_Kode_Prodi = '%s' WHERE NIM = '%s' ",
                        mahasiswa.getNIM(),mahasiswa.getNama(),mahasiswa.getAlamat(),mahasiswa.getNo_Hp(),mahasiswa.getEmail(), mahasiswa.getProdi_Kode_Prodi());
                db.executeUpdateQuery(query);
            }
        }
    }
 }
