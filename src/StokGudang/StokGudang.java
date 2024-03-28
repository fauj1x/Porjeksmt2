/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package StokGudang;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Faujixx
 */
public class StokGudang extends javax.swing.JFrame {
    String sql;

    /**
     * Creates new form StokGudang
     */
    public StokGudang() {
        initComponents();
        tampilkanDataBarang();
   
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
    
    private void tampilkanDataBarang() {
    DefaultTableModel model = (DefaultTableModel) tablestokgudang.getModel();
    model.setRowCount(0); // Menghapus semua baris yang ada di tabel sebelum menambahkan yang baru
    
    try {
        Connection connection = koneksi.koneksi.GetConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM barang");
        
        while (resultSet.next()) {
            String id_barang = resultSet.getString("id_barang");
            String nama_barang = resultSet.getString("nama_barang");
            int jumlah = resultSet.getInt("jumlah");
            String kategori = resultSet.getString("kategori");
            
            model.addRow(new Object[]{id_barang, nama_barang, jumlah, kategori});
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error retrieving data: " + e.getMessage());
    }
}
    
    private void datatable(String select_from_TambahBarang) {
        DefaultTableModel tbl=new DefaultTableModel();
        tbl.addColumn("id_barang");
        tbl.addColumn("nama_barang");
        tbl.addColumn("jumlah");
        tbl.addColumn("kategori");
        tablestokgudang.setModel(tbl);
        try{
            Statement statement = koneksi.koneksi.GetConnection().createStatement();
            if (select_from_TambahBarang.equals("")) {
                sql = "SELECT barang.*, kategori.nama as kategori FROM `barang` inner join kategori on barang.id_kategori = kategori.id_kategori order by id_barang asc";
            } else {
                sql = select_from_TambahBarang;
            }
            ResultSet res = statement.executeQuery
                (sql);
            while(res.next())
            {
                tbl.addRow(new Object[]{
                    res.getString("id_barang"),
                    res.getString("nama_barang"),
                    res.getString("jumlah"),
                    res.getString("kategori"),
                });
                tablestokgudang.setModel(tbl);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane,"salah" +e);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablestokgudang = new javax.swing.JTable();
        srp = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sgudang = new javax.swing.JButton();
        skaryawan = new javax.swing.JButton();
        qcheck = new javax.swing.JButton();
        bdashboard = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        brp = new javax.swing.JButton();
        tbrang = new javax.swing.JButton();
        tkaryawan = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bcari = new javax.swing.JButton();
        pencarian = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("STOK GUDANG");

        tablestokgudang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Barang", "Nama Barang", "Stok", "Kategori"
            }
        ));
        jScrollPane1.setViewportView(tablestokgudang);

        srp.setText("Seluruh Riwayat Produksi");
        srp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                srpMouseClicked(evt);
            }
        });

        jLabel4.setText("Master Data");

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

        jLabel5.setText("Edit / Update Data");

        brp.setText("Buat Rencana Produksi");
        brp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                brpMouseClicked(evt);
            }
        });

        tbrang.setText("Tambah Barang");
        tbrang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbrangMouseClicked(evt);
            }
        });

        tkaryawan.setText("Tambah Karyawan");
        tkaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tkaryawanMouseClicked(evt);
            }
        });

        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        bcari.setText("cari");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });
        bcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bcariKeyTyped(evt);
            }
        });

        pencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pencarianActionPerformed(evt);
            }
        });
        pencarian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pencarianKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(skaryawan)
                    .addComponent(sgudang)
                    .addComponent(bdashboard)
                    .addComponent(jLabel5)
                    .addComponent(brp)
                    .addComponent(tbrang)
                    .addComponent(tkaryawan)
                    .addComponent(jLabel4)
                    .addComponent(srp)
                    .addComponent(qcheck))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bhapus)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(221, 221, 221)
                        .addComponent(bcari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pencarian))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(343, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(bcari)
                    .addComponent(pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bdashboard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(brp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tbrang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tkaryawan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(srp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sgudang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(skaryawan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(qcheck))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(bhapus)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void srpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_srpMouseClicked
        // TODO add your handling code here:
        SeluruhRiwayatProduksi.SeluruhRiwayatProduksi a = new SeluruhRiwayatProduksi.SeluruhRiwayatProduksi();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_srpMouseClicked

    private void sgudangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sgudangMouseClicked
        // TODO add your handling code here:
        
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

    private void tbrangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbrangMouseClicked
        // TODO add your handling code here:
        TambahBarang.TambahBarang a = new TambahBarang.TambahBarang();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_tbrangMouseClicked

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        // Mendapatkan indeks baris yang dipilih
    int selectedRow = tablestokgudang.getSelectedRow();
    
    // Pastikan baris telah dipilih
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang akan dihapus.");
        return;
    }
    
    // Mendapatkan id_barang dari baris yang dipilih
    String idBarang = tablestokgudang.getValueAt(selectedRow, 0).toString();
    
    // Konfirmasi penghapusan
    int option = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    
    if (option == JOptionPane.YES_OPTION) {
        try {
            // Buat koneksi ke database
            Connection connection = koneksi.koneksi.GetConnection();
            
            // Buat SQL untuk menghapus data berdasarkan id_barang
            String sql = "DELETE FROM barang WHERE id_barang = ?";
            
            // Persiapkan statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            // Set parameter id_barang
            preparedStatement.setString(1, idBarang);
            
            // Eksekusi statement
            int deletedRows = preparedStatement.executeUpdate();
            
            if (deletedRows > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
                
                // Perbarui tampilan tabel setelah penghapusan
                tampilkanDataBarang();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
        
    }//GEN-LAST:event_bhapusActionPerformed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
try{
            Statement statement = (Statement)koneksi.koneksi.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from barang where "
                    + "nama_barang ='" + pencarian.getText() + "'");
                    DefaultTableModel tbl = new DefaultTableModel();
                    tbl.addColumn("id_barang");
                    tbl.addColumn("nama_barang");
                    tbl.addColumn("jumlah");
                    tbl.addColumn("kategori");
            
            tablestokgudang.setModel(tbl);
            
            while (res.next()) {
                tbl.addRow(new Object[]{
                        res.getString("id_barang"),
                        res.getString("nama_barang"),
                        res.getString("jumlah"),
                        res.getString("kategori"),
                });
                tablestokgudang.setModel(tbl);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "");
        }       
    }//GEN-LAST:event_bcariActionPerformed

    private void pencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pencarianActionPerformed
        // TODO add your handling code here:
        String keyword = pencarian.getText();
    }//GEN-LAST:event_pencarianActionPerformed

    private void bcariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bcariKeyTyped
        
    }//GEN-LAST:event_bcariKeyTyped

    private void pencarianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pencarianKeyTyped
        
    }//GEN-LAST:event_pencarianKeyTyped

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
            java.util.logging.Logger.getLogger(StokGudang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StokGudang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StokGudang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StokGudang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StokGudang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcari;
    private javax.swing.JButton bdashboard;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton brp;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pencarian;
    private javax.swing.JButton qcheck;
    private javax.swing.JButton sgudang;
    private javax.swing.JButton skaryawan;
    private javax.swing.JButton srp;
    private javax.swing.JTable tablestokgudang;
    private javax.swing.JButton tbrang;
    private javax.swing.JButton tkaryawan;
    // End of variables declaration//GEN-END:variables
}
