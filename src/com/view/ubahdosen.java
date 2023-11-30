
package com.view;

import com.model.Dosen;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public final class ubahdosen extends javax.swing.JFrame {


    public ubahdosen() throws SQLException {
        initComponents();
        tampil();
    }
 
    private void tampil() throws SQLException{
         ArrayList<Dosen> dsn =Dosen.readdosen();
         System.out.println(dsn);
         DefaultTableModel modeldsn = (DefaultTableModel) tampil1.getModel();
         for (Dosen ds : dsn) {
          String NIP = ds.getNIP();
          String Nama = ds.getNama();
          String Alamat = ds.getAlamat();
          String No_Hp  = ds.getNo_Hp();
          String Email  = ds.getEmail();
          String Prodi_Kode_Prodi = ds.getProdi_Kode_Prodi();
          String dosenNIP = ds.getDosen_NIP();
          modeldsn.addRow(new Object[]{NIP, Nama, Alamat, No_Hp, Email, Prodi_Kode_Prodi, dosenNIP});
          
        }    
    }

    public void selectRow(){
        int i = tampil1.getSelectedRow();
        TableModel model = tampil1.getModel();
        nip.setText(model.getValueAt(i, 0).toString());
        pempro.setText(model.getValueAt( i, 5).toString());
        dosennp.setText(model.getValueAt(i, 6).toString());   
    }

    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tampil1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nip = new javax.swing.JTextField();
        nmk = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        nohp = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        ubah = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        pempro = new javax.swing.JTextField();
        dosennp = new javax.swing.JTextField();
        tampil = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 30, 30));
        jLabel2.setText("DATA DOSEN");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        tampil1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIP", "Nama", "Alamat", "No. HP", "Email", "Program Studi", "NIP_DOSEN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tampil1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 520, 270));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 30, 30));
        jLabel3.setText("NIP");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 30, 30));
        jLabel4.setText("Nama");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 30, 30));
        jLabel5.setText("Alamat");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 30, 30));
        jLabel6.setText("No HP");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 30, 30));
        jLabel7.setText("Email");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 30, 30));
        jLabel9.setText("DOSEN_NIP");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, -1, -1));

        nip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nipActionPerformed(evt);
            }
        });
        getContentPane().add(nip, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 220, -1));
        getContentPane().add(nmk, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 220, -1));
        getContentPane().add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 220, -1));
        getContentPane().add(nohp, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 220, -1));
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 220, -1));

        ubah.setText("UBAH");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        getContentPane().add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, -1, 40));

        kembali.setText("KEMBALI");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 460, -1, 40));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 30, 30));
        jLabel10.setText("Program Studi");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, -1, -1));
        getContentPane().add(pempro, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 220, -1));
        getContentPane().add(dosennp, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 220, -1));

        tampil.setText("PILIH");
        tampil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tampilMouseClicked(evt);
            }
        });
        getContentPane().add(tampil, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 140, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/component_ui/Login (17).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nipActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        new cruddosen().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_kembaliActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
    int row = tampil1.getSelectedRow();
    if (row >= 0) {
        DefaultTableModel model = (DefaultTableModel) tampil1.getModel();
        String nipDosen = model.getValueAt(row, 0).toString();
        String namaDosen = nmk.getText();
        String alamatDosen = alamat.getText();
        String nohpDosen = nohp.getText();
        String emailDosen = email.getText();
        String prodiDosen = model.getValueAt(row, 5).toString();
        String nipDosenLain = model.getValueAt(row, 6).toString();
    
        if (nipDosen.isEmpty() || namaDosen.isEmpty() || alamatDosen.isEmpty() || nohpDosen.isEmpty() || emailDosen.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap isi semua data kecuali NIP Dosen, Prodi Dosen, dan NIP Dosen Lain sebelum mengubah data.");
        } else {

            if (namaDosen.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(null, "Nama Dosen tidak boleh mengandung angka.");
            }
        
        if (nohpDosen.matches(".*[a-zA-Z]+.*")) {
            JOptionPane.showMessageDialog(null, "Nomor HP Dosen tidak boleh mengandung huruf.");
        }
        
        try {
            Dosen.updateDosen(nipDosen, namaDosen, alamatDosen, nohpDosen, emailDosen, prodiDosen, nipDosenLain);
            model.setValueAt(namaDosen, row, 1);
            model.setValueAt(alamatDosen, row, 2);
            model.setValueAt(nohpDosen, row, 3);
            model.setValueAt(emailDosen, row, 4);
            JOptionPane.showMessageDialog(null, "Data dosen dengan NIP " + nipDosen + " telah diubah.");
            selectRow();
        } catch (SQLException ex) {
            Logger.getLogger(cruddosen.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Gagal mengubah data dosen dengan NIP " + nipDosen);
        }
    } 
}



    }//GEN-LAST:event_ubahActionPerformed

    private void tampilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tampilMouseClicked
        if(adaItemDipilih()) {
            selectRow();
        }else {
            // Tampilkan peringatan bahwa pengguna belum memilih item
            JOptionPane.showMessageDialog(this, "Anda belum memilih item. Silakan pilih item terlebih dahulu.");
            }
    }//GEN-LAST:event_tampilMouseClicked

    private boolean adaItemDipilih() {
        // Mengambil indeks baris yang dipilih dari JTable
        int selectedRow = tampil1.getSelectedRow();

        // Memeriksa apakah ada baris yang dipilih
        return selectedRow != -1; // Jika tidak ada baris yang dipilih, kembalikan false
        // Jika ada baris yang dipilih, kembalikan true
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ubahdosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ubahdosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ubahdosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ubahdosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ubahdosen().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ubahdosen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JTextField dosennp;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JTextField nip;
    private javax.swing.JTextField nmk;
    private javax.swing.JTextField nohp;
    private javax.swing.JTextField pempro;
    private javax.swing.JButton tampil;
    private javax.swing.JTable tampil1;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
