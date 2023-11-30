/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.view;

import com.model.Mahasiswa;
import com.model.Mata_Kuliah;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Bayu Purnama Aji
 */
public final class ubahmk extends javax.swing.JFrame {

    /**
     * Creates new form ubahmk
     * @throws java.sql.SQLException
     */
    public ubahmk() throws SQLException {
        initComponents();
        tampil();
    }
    
    private void tampil() throws SQLException{
         ArrayList<Mata_Kuliah> mk =Mata_Kuliah.readMata_Kuliah();
         System.out.println(mk);
         DefaultTableModel modelmhs = (DefaultTableModel) tampil1.getModel();
         for (Mata_Kuliah mkk : mk) {
          String kd = mkk.getKode_MK();
          String NMK = mkk.getNama_MK();
          String SKS = mkk.getSKS();
          String SMS  = mkk.getSemester();
          String PRAK  = mkk.getPraktikum();
          String DPN = mkk.getDosen_NIP();
          modelmhs.addRow(new Object[]{kd, NMK, SKS, SMS, PRAK, DPN});
          
        }
        
    }
    
    public void selectRow(){
        int i = tampil1.getSelectedRow();
        TableModel model = tampil1.getModel();
        kodemk.setText(model.getValueAt(i, 0).toString());
        dp.setText(model.getValueAt( i, 5).toString());   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tampil1 = new javax.swing.JTable();
        ubah = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kodemk = new javax.swing.JTextField();
        nmk = new javax.swing.JTextField();
        sks = new javax.swing.JTextField();
        sms = new javax.swing.JTextField();
        prak = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dp = new javax.swing.JTextField();
        pilih = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 30, 30));
        jLabel2.setText("DATA MATA KULIAH");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        tampil1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode MK", "Nama MK", "SKS", "Semester", "Praktikum", "Dosen Pengajar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tampil1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 520, 260));

        ubah.setText("UBAH");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        getContentPane().add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 100, 40));

        kembali.setText("KEMBALI");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 420, 100, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 30, 30));
        jLabel3.setText("Kode MK");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 30, 30));
        jLabel4.setText("Nama MK");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 30, 30));
        jLabel5.setText("SKS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 30, 30));
        jLabel6.setText("Semester");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 30, 30));
        jLabel7.setText("Praktikum");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, -1, -1));

        kodemk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodemkActionPerformed(evt);
            }
        });
        getContentPane().add(kodemk, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 230, -1));
        getContentPane().add(nmk, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 230, -1));
        getContentPane().add(sks, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 230, -1));
        getContentPane().add(sms, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 230, -1));
        getContentPane().add(prak, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 230, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 30, 30));
        jLabel8.setText("Dosen Pengajar");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, -1, -1));
        getContentPane().add(dp, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 230, -1));

        pilih.setText("PILIH");
        pilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihActionPerformed(evt);
            }
        });
        getContentPane().add(pilih, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 130, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/component_ui/Login (18).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kodemkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodemkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodemkActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        new crudmatakuliah().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_kembaliActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        int row = tampil1.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel) tampil1.getModel();
            String kodemkk = model.getValueAt(row, 0).toString();
            String namamk = nmk.getText();
            String sk = sks.getText();
            String semester = sms.getText();
            String praktikum = prak.getText();
            String dpn = model.getValueAt(row, 5).toString();

            if (kodemkk.isEmpty() || namamk.isEmpty() || sk.isEmpty() || semester.isEmpty() || praktikum.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Harap isi semua data kecuali Kode Mata Kuliah dan Dosen sebelum mengubah data.");
            } else {
                try {
                    Mahasiswa.updateMahasiswa(kodemkk, namamk, sk, semester, praktikum, dpn);
                    model.setValueAt(namamk, row, 1);
                    model.setValueAt(sk, row, 2);
                    model.setValueAt(semester, row, 3);
                    model.setValueAt(praktikum, row, 4);
                    JOptionPane.showMessageDialog(null, "Data Mata Kuliah dengan Kode " + kodemkk + " telah diubah.");
                    selectRow();
                } catch (SQLException ex) {
                    Logger.getLogger(crudMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Gagal mengubah data Mata Kuliah dengan kode " + kodemkk);
                }
            } 
        }
 
    }//GEN-LAST:event_ubahActionPerformed

    private void pilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihActionPerformed
        if(adaItemDipilih()) {
            selectRow();
        }else {
            // Tampilkan peringatan bahwa pengguna belum memilih item
            JOptionPane.showMessageDialog(this, "Anda belum memilih item. Silakan pilih item terlebih dahulu.");
            }
    }//GEN-LAST:event_pilihActionPerformed
    private boolean adaItemDipilih() {
        // Mengambil indeks baris yang dipilih dari JTable
        int selectedRow = tampil1.getSelectedRow();

        // Memeriksa apakah ada baris yang dipilih
        return selectedRow != -1; // Jika tidak ada baris yang dipilih, kembalikan false  
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
            java.util.logging.Logger.getLogger(ubahmk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ubahmk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ubahmk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ubahmk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ubahmk().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ubahmk.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JTextField kodemk;
    private javax.swing.JTextField nmk;
    private javax.swing.JButton pilih;
    private javax.swing.JTextField prak;
    private javax.swing.JTextField sks;
    private javax.swing.JTextField sms;
    private javax.swing.JTable tampil1;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}