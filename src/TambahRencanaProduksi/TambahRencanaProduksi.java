
package TambahRencanaProduksi;
import java.sql.*;
import javax.swing.JOptionPane;

public class TambahRencanaProduksi extends javax.swing.JFrame {


    public TambahRencanaProduksi() {
        initComponents();
    }
    public static String generateNewID() {
      String newID = "PD0000";

        try (Connection connection = koneksi.koneksi.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(id_produksi) FROM produksi");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                String lastID = resultSet.getString("MAX(id_produksi)");
                if (lastID != null) {
                    try {
                        int sequence = Integer.parseInt(lastID.replaceAll("\\D", "")) + 1;
                        newID = String.format("PD%04d", sequence);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error parsing ID: " + e.getMessage());
                    }
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error generating ID: " + e.getMessage());
        }

        return newID;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nama_prod = new javax.swing.JTextField();
        penanggung_jawab = new javax.swing.JTextField();
        terget_produksi = new javax.swing.JTextField();
        anggaran = new javax.swing.JTextField();
        jumlah_karyawan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nama_karyawan = new javax.swing.JComboBox<>();
        btn_simpan = new javax.swing.JButton();
        btn_hps = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tanggalselesai = new com.github.lgooddatepicker.components.DatePicker();
        tanggalmulai = new com.github.lgooddatepicker.components.DatePicker();
        srp = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        sgudang = new javax.swing.JButton();
        skaryawan = new javax.swing.JButton();
        qcheck = new javax.swing.JButton();
        bdashboard = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        brp = new javax.swing.JButton();
        tbrang = new javax.swing.JButton();
        tkaryawan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nama_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_prodActionPerformed(evt);
            }
        });
        getContentPane().add(nama_prod, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 110, -1));
        getContentPane().add(penanggung_jawab, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 110, -1));
        getContentPane().add(terget_produksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 110, -1));
        getContentPane().add(anggaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 110, -1));
        getContentPane().add(jumlah_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 110, -1));

        jLabel1.setText("pilih namakaryawan");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, -1));

        jLabel2.setText("jumlah karyawan");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, -1, -1));

        jLabel3.setText("Penanggung jawab");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        jLabel4.setText("tanggal mulai");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, -1));

        jLabel5.setText("tanggal selesai");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        jLabel6.setText("target produksi");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        jLabel7.setText("anggaran");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, -1));

        nama_karyawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(nama_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, -1, -1));

        btn_simpan.setText("simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, -1, -1));

        btn_hps.setText("kosongkan form");
        getContentPane().add(btn_hps, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, -1, -1));

        jLabel8.setText("Nama Produksi");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));
        getContentPane().add(tanggalselesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, -1, -1));
        getContentPane().add(tanggalmulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        srp.setText("Seluruh Riwayat Produksi");
        srp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                srpMouseClicked(evt);
            }
        });
        getContentPane().add(srp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel9.setText("Master Data");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        sgudang.setText("Stok Gudang");
        sgudang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sgudangMouseClicked(evt);
            }
        });
        getContentPane().add(sgudang, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        skaryawan.setText("Seluruh Karyawan");
        skaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                skaryawanMouseClicked(evt);
            }
        });
        getContentPane().add(skaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        qcheck.setText("Quality Check");
        qcheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qcheckMouseClicked(evt);
            }
        });
        getContentPane().add(qcheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        bdashboard.setText("Dashboard");
        bdashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bdashboardMouseClicked(evt);
            }
        });
        bdashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdashboardActionPerformed(evt);
            }
        });
        getContentPane().add(bdashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel10.setText("Edit / Update Data");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        brp.setText("Buat Rencana Produksi");
        brp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                brpMouseClicked(evt);
            }
        });
        getContentPane().add(brp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        tbrang.setText("Tambah Barang");
        getContentPane().add(tbrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        tkaryawan.setText("Tambah Karyawan");
        tkaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tkaryawanMouseClicked(evt);
            }
        });
        getContentPane().add(tkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nama_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_prodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_prodActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
String nama = nama_prod.getText();
String penanggung = penanggung_jawab.getText();
String mulai =tanggalmulai.getDateStringOrEmptyString();
String selesai =tanggalselesai.getDateStringOrEmptyString();
String jlmhkaryawan = jumlah_karyawan.getText();
String nama_kar = nama_karyawan.getSelectedItem().toString();



        try {
         try {
        
        Statement statement = koneksi.koneksi.GetConnection().createStatement();
        statement.executeUpdate("INSERT INTO produksi VALUES ('" + generateNewID() + "','" + nama + "','" + penanggung + "','" + mulai + "','" + selesai + "','" + jlmhkaryawan + "','" + nama_kar + "')");
        statement.close();
        JOptionPane.showMessageDialog(rootPane, "Data berhasil ditambahkan");

        

    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, "Gagal menambahkan data: " + e.getMessage());
    }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btn_simpanActionPerformed

    private void srpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_srpMouseClicked
        // TODO add your handling code here:
        SeluruhRiwayatProduksi.SeluruhRiwayatProduksi a = new SeluruhRiwayatProduksi.SeluruhRiwayatProduksi();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_srpMouseClicked

    private void sgudangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sgudangMouseClicked
        // TODO add your handling code here:
        StokGudang.StokGudang a = new StokGudang.StokGudang();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_sgudangMouseClicked

    private void skaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_skaryawanMouseClicked
        // TODO add your handling code here:
        DataSeluruhKaryawan.DataSeluruhKaryawan a = new DataSeluruhKaryawan.DataSeluruhKaryawan();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_skaryawanMouseClicked

    private void qcheckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qcheckMouseClicked
        // TODO add your handling code here:
        QualityCheck.QualityCheck a = new QualityCheck.QualityCheck();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_qcheckMouseClicked

    private void bdashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bdashboardMouseClicked
        // TODO add your handling code here:
        dashboard.dashboard a = new dashboard.dashboard();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_bdashboardMouseClicked

    private void bdashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdashboardActionPerformed
        // TODO add your handling code here:
        dashboard.dashboard a = new dashboard.dashboard();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_bdashboardActionPerformed

    private void brpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brpMouseClicked
     
    }//GEN-LAST:event_brpMouseClicked

    private void tkaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tkaryawanMouseClicked
        // TODO add your handling code here:
        TambahKaryawan.TambahKaryawan a = new TambahKaryawan.TambahKaryawan();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_tkaryawanMouseClicked

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
            java.util.logging.Logger.getLogger(TambahRencanaProduksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahRencanaProduksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahRencanaProduksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahRencanaProduksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahRencanaProduksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anggaran;
    private javax.swing.JButton bdashboard;
    private javax.swing.JButton brp;
    private javax.swing.JButton btn_hps;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jumlah_karyawan;
    private javax.swing.JComboBox<String> nama_karyawan;
    private javax.swing.JTextField nama_prod;
    private javax.swing.JTextField penanggung_jawab;
    private javax.swing.JButton qcheck;
    private javax.swing.JButton sgudang;
    private javax.swing.JButton skaryawan;
    private javax.swing.JButton srp;
    private com.github.lgooddatepicker.components.DatePicker tanggalmulai;
    private com.github.lgooddatepicker.components.DatePicker tanggalselesai;
    private javax.swing.JButton tbrang;
    private javax.swing.JTextField terget_produksi;
    private javax.swing.JButton tkaryawan;
    // End of variables declaration//GEN-END:variables
}
