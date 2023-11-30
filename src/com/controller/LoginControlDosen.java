
package com.controller;

import com.model.Dosen;
import com.view.tampilan_login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginControlDosen {
    private DataBases db = new DataBases();

    
    
    public Dosen login(String username, String password){
        if (username.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(null, "Username dan Password tidak boleh kosong");
        }else try {
           ResultSet Data = db.executeSelectQuery("Select * from dosen;");
            while (Data.next()) {                
                String NIP = Data.getString("NIP");
                String Nama = Data.getString("Nama");
                String Alamat = Data.getString("Alamat");
                String No_Hp = Data.getString("No_Hp");
                String Email = Data.getString("Email");
                if (username.equals(Nama)&& password.equals(NIP))  {
                    JOptionPane.showMessageDialog(null, "LOGIN BERHASIL");
                    return new Dosen(NIP, Nama, Alamat, No_Hp, Email, No_Hp, No_Hp);
                }   
            }

        } catch (SQLException ex) {
            Logger.getLogger(tampilan_login.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return null;
    }
}
