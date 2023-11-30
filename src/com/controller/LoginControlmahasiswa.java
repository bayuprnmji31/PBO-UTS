package com.controller;

import com.model.Mahasiswa;
import com.view.tampilan_login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginControlmahasiswa {
    private DataBases db = new DataBases();
    private Connection connection;
    

    public Mahasiswa login(String username, String password){
        if (username.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(null, "Username dan Password tidak boleh kosong");
        }else try {
           ResultSet Data = db.executeSelectQuery("Select * from mahasiswa;");
            while (Data.next()) {                
                String NIM = Data.getString("NIM");
                String Nama = Data.getString("Nama");
                String Alamat = Data.getString("Alamat");
                String No_Hp = Data.getString("No_Hp");
                String Email = Data.getString("Email");
                String Pro   = Data.getString("Prodi_Kode_Prodi");
                if (username.equals(Nama)&& password.equals(NIM))  {
                    JOptionPane.showMessageDialog(null, "LOGIN BERHASIL");
                    return new Mahasiswa(NIM, Nama, Alamat, No_Hp, Email, Pro);
                }   
            }
        } catch (SQLException ex) {
            Logger.getLogger(tampilan_login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }       
}
