/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TambahBarang;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Faujixx
 */
public class TambahBarang extends javax.swing.JFrame {

    public TambahBarang() {
        initComponents();

    }
     public static String generateNewID() {
      String newID = "PD0000";

        try (Connection connection = koneksi.koneksi.GetConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(id_barang) FROM barang");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                String lastID = resultSet.getString("MAX(id_barang)");
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
    void reset() {
        txtnamabarang.setText("");
        txtkategori.setSelectedIndex(0);
        txtjumlah.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        qcheck = new javax.swing.JButton();
        bdashboard = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        brp = new javax.swing.JButton();
        tbrang = new javax.swing.JButton();
        tkaryawan = new javax.swing.JButton();
        srp = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        sgudang = new javax.swing.JButton();
        skaryawan = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnamabarang = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtkategori = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtjumlah = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        kform = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        qcheck.setText("Quality Check");
        qcheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qcheckMouseClicked(evt);
            }
        });

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

        jLabel1.setText("Edit / Update Data");

        brp.setText("Buat Rencana Produksi");
        brp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                brpMouseClicked(evt);
            }
        });

        tbrang.setText("Tambah Barang");

        tkaryawan.setText("Tambah Karyawan");
        tkaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tkaryawanMouseClicked(evt);
            }
        });

        srp.setText("Seluruh Riwayat Produksi");
        srp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                srpMouseClicked(evt);
            }
        });

        jLabel2.setText("Master Data");

        sgudang.setText("Stok Gudang");
        sgudang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sgudangMouseClicked(evt);
            }
        });

        skaryawan.setText("Seluruh Karyawan");
        skaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                skaryawanMouseClicked(evt);
            }
        });

        jLabel3.setText("TAMBAH BARANG");

        jLabel4.setText("Nama Barang");

        jLabel5.setText("Kategori");

        txtkategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkategoriActionPerformed(evt);
            }
        });

        jLabel6.setText("Jumlah");

        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        kform.setText("Kosongkan Form");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(skaryawan)
                    .addComponent(sgudang)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bdashboard)
                            .addComponent(jLabel1)
                            .addComponent(brp)
                            .addComponent(tbrang)
                            .addComponent(tkaryawan)
                            .addComponent(jLabel2)
                            .addComponent(srp)
                            .addComponent(qcheck))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bsimpan)
                                .addGap(60, 60, 60)
                                .addComponent(kform, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(txtnamabarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtkategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtjumlah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(263, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bdashboard)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brp)
                    .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbrang)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tkaryawan)
                    .addComponent(txtkategori, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(srp)
                    .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sgudang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(skaryawan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qcheck)
                    .addComponent(bsimpan)
                    .addComponent(kform))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bdashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdashboardActionPerformed
        // TODO add your handling code here:
        dashboard.dashboard a = new dashboard.dashboard();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_bdashboardActionPerformed

    private void txtkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkategoriActionPerformed

    private void bdashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bdashboardMouseClicked
        // TODO add your handling code here:
        dashboard.dashboard a = new dashboard.dashboard();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_bdashboardMouseClicked

    private void brpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brpMouseClicked
        // TODO add your handling code here:
        TambahRencanaProduksi.TambahRencanaProduksi a = new TambahRencanaProduksi.TambahRencanaProduksi();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_brpMouseClicked

    private void tkaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tkaryawanMouseClicked
        // TODO add your handling code here:
        TambahKaryawan.TambahKaryawan a = new TambahKaryawan.TambahKaryawan();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_tkaryawanMouseClicked

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

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        String namabarang = txtnamabarang.getText();
        int kategori = txtkategori.getSelectedIndex();
        String jumlah = txtjumlah.getText();

        try{
            Statement statement = koneksi.koneksi.GetConnection().createStatement();
            String query = "UPDATE barang SET " 
                + "nama = '" +namabarang+ "',"
                + "id_kategori = '" +kategori+ "',"
                + "jumlah = '" +jumlah+ "',"
                + "id_kategori = '" +kategori+ "',"
                + "WHERE nama = '" +namabarang+ "'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Perubahan berhasil disimpan");
            reset();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "gagal menambah data"+e);
        }
    }//GEN-LAST:event_bsimpanActionPerformed

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
            java.util.logging.Logger.getLogger(TambahBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bdashboard;
    private javax.swing.JButton brp;
    private javax.swing.JButton bsimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton kform;
    private javax.swing.JButton qcheck;
    private javax.swing.JButton sgudang;
    private javax.swing.JButton skaryawan;
    private javax.swing.JButton srp;
    private javax.swing.JButton tbrang;
    private javax.swing.JButton tkaryawan;
    private javax.swing.JButton txtjumlah;
    private javax.swing.JComboBox<String> txtkategori;
    private javax.swing.JButton txtnamabarang;
    // End of variables declaration//GEN-END:variables


}