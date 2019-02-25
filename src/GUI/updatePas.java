/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BackgroundWork.*;
import Objek.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dimas Adiyaksa
 */
public class updatePas extends javax.swing.JFrame {

    /**
     * Creates new form updatePas
     */
    koneksi kon = new koneksi(); 
     TambahPasien t = new TambahPasien();
     Pasien p = new Pasien();
    
     public updatePas() {
        initComponents();
        setLocationRelativeTo(null);
    }
    public updatePas(Pasien p) {
        initComponents();
        inisiasi(p);
        setLocationRelativeTo(null);
        this.toFront();
    }

    public void inisiasi(Pasien p){
        this.p = p;
        kdupdt.setText(p.getId());
        nmupdt.setText(p.getNama());
        ageupdt.setText(Integer.toString(p.getUmur()));
        alamatupdt.setText(p.getAlamat());
        t.ruangBox(ruangUpBox);
        t.PenyakitPasien(penyakitUpBox);
        ruangUpBox.setSelectedItem(p.getKodeRuang());
        penyakitUpBox.setSelectedItem(p.getKodePenyakit());
        p.print();
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = null;
        
        System.out.println(p.getOut());
        try {
           dt = d.parse(p.getOut());
        } catch (ParseException ex) {
            Logger.getLogger(updatePas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        //d = p.getOut();
    
        dateOut.setDate(dt);
        //dateOut.setDate();
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
        alamatupdt = new javax.swing.JTextArea();
        penyakitUpBox = new javax.swing.JComboBox<>();
        ruangUpBox = new javax.swing.JComboBox<>();
        alamatUpdt = new javax.swing.JLabel();
        kdUpdtf = new javax.swing.JLabel();
        penyakitUpdt = new javax.swing.JLabel();
        nmupdt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ageupdt = new javax.swing.JTextField();
        updtBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        kdupdt = new javax.swing.JLabel();
        dateOut = new org.jdesktop.swingx.JXDatePicker();
        tglKeluar = new javax.swing.JLabel();
        btl = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        alamatupdt.setColumns(20);
        alamatupdt.setRows(5);
        jScrollPane1.setViewportView(alamatupdt);

        penyakitUpBox.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        penyakitUpBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ruangUpBox.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ruangUpBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        alamatUpdt.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        alamatUpdt.setText("Alamat :");

        kdUpdtf.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        kdUpdtf.setText("Kode    : ");

        penyakitUpdt.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        penyakitUpdt.setText("Penyakit : ");

        nmupdt.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        nmupdt.setText(" ");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setText("Ruang    :");

        ageupdt.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        ageupdt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ageupdt.setText(" ");

        updtBtn.setText("Update");
        updtBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updtBtnMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Nama   :");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("Umur     :");

        kdupdt.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        tglKeluar.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        tglKeluar.setText("Tgl Keluar :");

        btl.setText("Batal");
        btl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kdUpdtf)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(alamatUpdt)
                            .addComponent(penyakitUpdt)
                            .addComponent(jLabel6))
                        .addComponent(tglKeluar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kdupdt)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nmupdt)
                        .addComponent(ageupdt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                        .addComponent(ruangUpBox, 0, 240, Short.MAX_VALUE)
                        .addComponent(penyakitUpBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(dateOut, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updtBtn)
                .addGap(27, 27, 27)
                .addComponent(btl)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kdUpdtf)
                    .addComponent(kdupdt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nmupdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageupdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alamatUpdt))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(penyakitUpBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(penyakitUpdt))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ruangUpBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tglKeluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updtBtn)
                    .addComponent(btl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updtBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updtBtnMouseClicked
        
         ResultSet kdruang = null;
         ResultSet kdsakit = null;
         String ruang = null;
         ResultSet rs = null;
         String pnyakit = null;
         String dt = null;
         String s = null;
        try {
            // TODO add your handling code here:
            kdsakit = kon.koneksikan("SELECT `kode penyakit` "
                    + "FROM `info penyakit` WHERE `nama penyakit`='"+penyakitUpBox.getSelectedItem()+"'");
            kdsakit.next();
            pnyakit = kdsakit.getString("Kode penyakit");
        } catch (SQLException ex) {
            Logger.getLogger(updatePas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "C");
        }
        try {
            // TODO add your handling code here:
            kdruang = kon.koneksikan("SELECT `kode ruang` "
                    + "FROM ruangan WHERE `nama ruang`='"+ruangUpBox.getSelectedItem()+"'");
            kdruang.next();
            ruang = kdruang.getString("Kode ruang");
        } catch (SQLException ex) {
            Logger.getLogger(updatePas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "B");
            
        }
        // rs.next();
        
        
        try{
            rs = kon.koneksikan("SELECT * FROM penempatan "
                    + "WHERE `kode pasien` = '"+kdupdt.getText()+"'");
            rs.next();
            System.out.println(kdupdt.getText());
            s = rs.getString("Kode penempatan");
            System.out.println(s);
            kon.insert("UPDATE `pasien` SET `Nama`='"+
                nmupdt.getText()+"',`umur`="+Integer.parseInt(ageupdt.getText())+
                ",`alamat`='"+alamatupdt.getText()+"', `kode penyakit`='"+pnyakit+"',`kode ruang`='"+ruang+"'"
                        + " WHERE `kode pasien` = '"+kdupdt.getText()+"'");    
        
        kon.insert("UPDATE `penempatan` SET `kode ruang` = '"+ruang+"' WHERE `kode penempatan` = '"+s
                +"'");
        
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        dt = f.format(dateOut.getDate());
            System.out.println(dt);
       
            kon.insert("UPDATE `penempatan` SET `Tanggal Keluar` = '"+dt+"' WHERE `kode penempatan` = '"+rs.getString("kode penempatan")
                +"'");

        }catch(Exception e){
            System.out.println(s);
            JOptionPane.showMessageDialog(null,e);
            
             
        }
        
        p.setNama(nmupdt.getText());
        p.setAlamat(alamatupdt.getText());
        p.setKodePenyakit(penyakitUpBox.getSelectedItem().toString());
        p.setKodeRuang(ruangUpBox.getSelectedItem().toString());
        p.setUmur(Integer.parseInt(ageupdt.getText()));
        p.setOut(dt);
        JOptionPane.showMessageDialog(null, "Update Berhasil!");
        this.dispose();
        
        //System.out.println(pnyakit);
    }//GEN-LAST:event_updtBtnMouseClicked

    private void btlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btlActionPerformed

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
            java.util.logging.Logger.getLogger(updatePas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updatePas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updatePas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updatePas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updatePas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageupdt;
    private javax.swing.JLabel alamatUpdt;
    private javax.swing.JTextArea alamatupdt;
    private javax.swing.JButton btl;
    private org.jdesktop.swingx.JXDatePicker dateOut;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kdUpdtf;
    private javax.swing.JLabel kdupdt;
    private javax.swing.JTextField nmupdt;
    private javax.swing.JComboBox<String> penyakitUpBox;
    private javax.swing.JLabel penyakitUpdt;
    private javax.swing.JComboBox<String> ruangUpBox;
    private javax.swing.JLabel tglKeluar;
    private javax.swing.JButton updtBtn;
    // End of variables declaration//GEN-END:variables
}