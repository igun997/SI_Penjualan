/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package si_penjualan.views;

import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import si_penjualan.entity.barang;
import si_penjualan.entity.pelanggan;
import si_penjualan.implement.barangimplement;
import si_penjualan.implement.pelangganimplement;
import si_penjualan.implement.penjualanimplement;

/**
 *
 * @author systemfive
 */
public class v_pilih_user extends javax.swing.JFrame {

    DefaultTableModel tabModel;
    pelangganimplement plimpl = new pelangganimplement();

    /**
     * Creates new form v_pilih_user
     */
    public v_pilih_user() {
        initComponents();
        setTabel();
        cari();
    }
    
    private void cari()
    {
         txtCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
               cari(txtCari.getText());
            }

            public void removeUpdate(DocumentEvent e) {
                // ketika teks diubah
                cari(txtCari.getText());
            }

            public void changedUpdate(DocumentEvent e) {
                // ketika teks diubah
                cari(txtCari.getText());
            }
        });
    }
    private void cari(String query)
    {
        System.out.println("Query := "+query);
        String value = txtCari.getText();
        for (int row = 0; row <= listPelanggan.getRowCount() - 1; row++) {
            for (int col = 0; col <= listPelanggan.getColumnCount() - 1; col++) {
                if (value.equals(listPelanggan.getValueAt(row, col))) {
                    // this will automatically set the view of the scroll in the location of the value
                    listPelanggan.scrollRectToVisible(listPelanggan.getCellRect(row, 0, true));
                    // this will automatically set the focus of the searched/selected row/value
                    listPelanggan.setRowSelectionInterval(row, row);
                    for (int i = 0; i <= listPelanggan.getColumnCount() - 1; i++) {
                        //listPelanggan.getColumnModel().getColumn(i).setCellRenderer(new HighlightRenderer());
                    }
                }
            }
        }
    }
    private void getData()
    {
        
        int no = 0;
        try {
            List<pelanggan> record = plimpl.getAll();
            int x = 0;
            for (pelanggan pl : record) {
                String kode = pl.getKode();
                String nama = pl.getNama();
                String alamat = pl.getAlamat();
                Object Data[]={kode,nama,alamat};
                tabModel.addRow(Data);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(v_barang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void setTabel()
    {
        String [] JudulKolom={"Kode Barang","Nama Pelanggan","Alamat"};
        tabModel = new DefaultTableModel(null, JudulKolom){
                  boolean[] canEdit = new boolean [] {false, false, false,false,false };
                  @Override
                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                   return canEdit [columnIndex];
                  }
              };
        listPelanggan.setModel(tabModel);
        getData();
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
        listPelanggan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnPilih = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        listPelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(listPelanggan);

        jLabel1.setText("Kode Pelanggan");

        txtCari.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtCariInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        txtCari.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtCariPropertyChange(evt);
            }
        });

        btnPilih.setText("Pilih");
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btnPilih)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPilih)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtCariInputMethodTextChanged

    }//GEN-LAST:event_txtCariInputMethodTextChanged

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtCariPropertyChange
        System.out.print(txtCari.getText());
    }//GEN-LAST:event_txtCariPropertyChange

    private void btnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihActionPerformed
        DefaultTableModel model = (DefaultTableModel) listPelanggan.getModel();
        int s = listPelanggan.getSelectedRow();
        try {
            pelanggan fetch = plimpl.finById(model.getValueAt(s, 0).toString());
            v_pembelian.SAna_pel = fetch.getNama();
            v_pembelian.SAid_pel = fetch.getKode();
            v_pembelian.SAalamat = fetch.getAlamat();
            v_pembelian.cek = 1;
            System.out.print("Param " + model.getValueAt(s, 0).toString());
            System.out.print("Pass ");
            dispose();

        } catch (SQLException ex) {
            Logger.getLogger(v_pilih_barang.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnPilihActionPerformed

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
            java.util.logging.Logger.getLogger(v_pilih_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(v_pilih_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(v_pilih_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(v_pilih_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new v_pilih_user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPilih;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listPelanggan;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
