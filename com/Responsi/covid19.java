/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Responsi;


import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class covid19 extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    private Connection conn;
    private void kosongkan_form(){
        namaDaerah.setEditable(true);
        namaDaerah.setText(null);
        odpData.setText(null);
        pdpData.setText(null);
        positifData.setText(null);
    }
    
    private void tampilkan_data(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("NAMA DAERAH");
        model.addColumn("JUMLAH ODP");
        model.addColumn("JUMLAH PDP");
        model.addColumn("JUMLAH POSITIF");
        model.addColumn("STATUS");
        
        
        
        
        try{
            int no = 1;
            String sql = "SELECT namadaerah.nama_daerah,namadaerah.odp,namadaerah.pdp,namadaerah.positif,status_orang.status from namadaerah  join status_orang where namadaerah.id = status_orang.id_daerah";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5) });
            }
            tableCovid19.setModel(model);
            
        }catch (SQLException e){
            System.out.println("ERROR " + e.getMessage());
        }
    }

    /**
     * Creates new form Mahasiswa
     */
    public covid19() {
        initComponents();
        tampilkan_data();
        kosongkan_form();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        namaDaerah = new javax.swing.JTextField();
        odpData = new javax.swing.JTextField();
        pdpData = new javax.swing.JTextField();
        positifData = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCovid19 = new javax.swing.JTable();
        btTambah = new javax.swing.JButton();
        btSimpan = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btHapus = new javax.swing.JButton();
        btBatal = new javax.swing.JButton();
        btKeluar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Data Mahasiswa");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("NAMA DAERAH");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel3.setText("JUMLAH ODP");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        jLabel5.setText("JUMLAH PDP");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 80, 30));

        jLabel6.setText("JUMLAH POSITIF");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));
        getContentPane().add(namaDaerah, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 110, 30));
        getContentPane().add(odpData, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 50, 30));
        getContentPane().add(pdpData, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 50, 30));
        getContentPane().add(positifData, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 50, 30));

        tableCovid19.setBackground(null);
        tableCovid19.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableCovid19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCovid19MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableCovid19);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 110, 820, 180));

        btTambah.setText("Tambah Data");
        btTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTambahActionPerformed(evt);
            }
        });
        getContentPane().add(btTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        btSimpan.setText("Simpan");
        btSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, -1, -1));

        btEdit.setText("Edit");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });
        getContentPane().add(btEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, -1));

        btHapus.setText("Hapus");
        btHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, -1, -1));

        btBatal.setText("Batal");
        btBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatalActionPerformed(evt);
            }
        });
        getContentPane().add(btBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, -1, -1));

        btKeluar.setBackground(new java.awt.Color(255, 0, 0));
        btKeluar.setForeground(new java.awt.Color(255, 255, 255));
        btKeluar.setText("Keluar");
        btKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKeluarActionPerformed(evt);
            }
        });
        getContentPane().add(btKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, -1, -1));

        jLabel8.setFont(new java.awt.Font("Century", 0, 24)); // NOI18N
        jLabel8.setText("COVID 19");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel9.setText("nb : data NAMA DAERAH tidak boleh dan tidak dapat diedit");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, -1, 10));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btKeluarActionPerformed

    private void btTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTambahActionPerformed
        // TODO add your handling code here:
        kosongkan_form();
        //txtNIM.setFocusable(true);
    }//GEN-LAST:event_btTambahActionPerformed

    private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
        // TODO add your handling code here:
        String sql = "INSERT INTO namadaerah "+"(nama_daerah,odp,pdp,positif)"+"VALUES (?,?,?,?)";
        try{
         String nama_daerah=namaDaerah.getText();
        Integer odp = Integer.valueOf(odpData.getText());
        Integer pdp = Integer.valueOf(pdpData.getText());
        Integer positif = Integer.valueOf(positifData.getText());
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan...");
            tampilkan_data();
            kosongkan_form();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btSimpanActionPerformed

    private void tableCovid19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCovid19MouseClicked
        // TODO add your handling code here:
        int kolom = tableCovid19.rowAtPoint(evt.getPoint());
        String nama_daerah = tableCovid19.getValueAt(kolom, 1).toString();
        namaDaerah.setText(nama_daerah);
        
        String odp = tableCovid19.getValueAt(kolom, 2).toString();
        odpData.setText(odp);
        
        String pdp = tableCovid19.getValueAt(kolom, 3).toString();
        pdpData.setText(pdp);
        
        String positif = tableCovid19.getValueAt(kolom, 4).toString();
        positifData.setText(positif);
        
        String Status = tableCovid19.getValueAt(kolom, 5).toString();
            if(positif=="0")
            Status="Zona Hijau";
            else
            Status="Zona Merah";
    }//GEN-LAST:event_tableCovid19MouseClicked

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "UPDATE namadaerah SET nama_daerah='"+ namaDaerah.getText()+"',odp='"+ odpData.getText()+"',pdp='"+ pdpData.getText()+"',positif='"+ positifData.getText()+"'WHERE nama_Daerah = '"+namaDaerah.getText()+ "'";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil diedit...");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data();
        kosongkan_form();
        
    }//GEN-LAST:event_btEditActionPerformed

    private void btHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "DELETE  from namadaerah,status_orang join status_orang on namadaerah.id = status_orang.id_daerah where nama_daerah='"+ namaDaerah.getText()+"'";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus...");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data();
        kosongkan_form();
    }//GEN-LAST:event_btHapusActionPerformed

    private void btBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBatalActionPerformed
        // TODO add your handling code here:
        kosongkan_form();
    }//GEN-LAST:event_btBatalActionPerformed

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
            java.util.logging.Logger.getLogger(covid19.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(covid19.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(covid19.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(covid19.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new covid19().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBatal;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btHapus;
    private javax.swing.JButton btKeluar;
    private javax.swing.JButton btSimpan;
    private javax.swing.JButton btTambah;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField namaDaerah;
    private javax.swing.JTextField odpData;
    private javax.swing.JTextField pdpData;
    private javax.swing.JTextField positifData;
    private javax.swing.JTable tableCovid19;
    // End of variables declaration//GEN-END:variables
}
