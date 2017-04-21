/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionConvontion;

import GestionPartenaire.*;
import GestionLoggin.*;
import GestionMalade.Malade;
import gestionbadr.Connect;
import gestionbadr.HomeSecretaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author FAWZI
 */
public class RechercherConvontion extends javax.swing.JFrame {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String s;
    PreparedStatement pst = null;
    String row;
    ResultSet rst = null;

    public RechercherConvontion() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        bRechercher = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cEtatConvontion = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cUnite = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tConvontion = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rechercher Convontion");

        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        bRechercher.setText("Rechercher");
        bRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRechercherActionPerformed(evt);
            }
        });

        jLabel7.setText("Etat de la Convontion");

        cEtatConvontion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Areter", "Marche", " " }));
        cEtatConvontion.setSelectedIndex(-1);

        jLabel4.setText("Unite");

        cUnite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mois", "Semaine", "Jours" }));
        cUnite.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(309, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cUnite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(bRechercher)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cEtatConvontion, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bRechercher)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cEtatConvontion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cUnite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(0, 38, Short.MAX_VALUE))
        );

        tConvontion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nom", "Prenom", "User Name"
            }
        ));
        tConvontion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tConvontionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tConvontion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bCancel))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bCancel)
                .addGap(200, 200, 200))
        );

        setSize(new java.awt.Dimension(922, 373));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechercherActionPerformed
        if (cEtatConvontion.getSelectedIndex() == -1 && cUnite.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Enter Une des combinaison suivante:"
                    + "\n     - L'unite."
                    + "\n     - Etat de la convontion."
            + "\n     - L'unite + Etat de la convontion.");

        } else if ( cEtatConvontion.getSelectedIndex() == -1) {
            try {
                con = Connect.connect();
                String sql = "SELECT * FROM convontion WHERE unite = '"+ cUnite.getSelectedItem().toString() +"'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tConvontion.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else if (cUnite.getSelectedIndex() == -1 ) {
            try {
                con = Connect.connect();
                String sql = "SELECT * FROM convontion WHERE  etat_c='"+ cEtatConvontion.getSelectedItem()+"'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tConvontion.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else if (!(cEtatConvontion.getSelectedIndex() == -1) && !(cUnite.getSelectedIndex() == -1)) {
            try {
                con = Connect.connect();
                String sql = "SELECT * FROM convontion WHERE  etat_c='"+ cEtatConvontion.getSelectedItem()
                        +"' AND unite = '"+cUnite.getSelectedItem() +"'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tConvontion.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
         
    }//GEN-LAST:event_bRechercherActionPerformed

    private void tConvontionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tConvontionMouseClicked
        
        con = Connect.connect();
        int row = tConvontion.getSelectedRow();    
        String n;     
        n = tConvontion.getModel().getValueAt(row, 0).toString();
         
        try {
            String sql = "SELECT * FROM convontion WHERE id_conv = '" + n + "'";            
            pst = con.prepareStatement(sql);         
            rs = pst.executeQuery(sql);
         
            if (rs.next()) {               
                this.setVisible(false);
                Convontion s1 = new Convontion();
                s1.setVisible(true);
                
                int nbr_RDv = rs.getInt("nbr_RDv");
                s1.txtNombre.setText(Integer.toString(nbr_RDv));            
                String unite = rs.getString("unite");
                s1.cUnite.setSelectedItem(unite);
                String 	type_radiologie = rs.getString("type_radiologie");
                s1.txtType.setVisible(true);
                s1.txtType.setEditable(false);
                s1.txtType.setText(type_radiologie);             
                String nom_convontion = rs.getString("nom_convontion");
                s1.txtNomConvontion.setText(nom_convontion);
                String injection = rs.getString("injection");
                s1.cInjection.setSelectedItem(injection);
                String etat_c = rs.getString("etat_c");
                s1.cEtatConvontion.setSelectedItem(etat_c);
                s1.id_p = rs.getInt("partenaire_id_p");
                s1.id_conv = rs.getInt("id_conv");
                s1.Rechercher_nom_Partenaire();
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       
       
    }//GEN-LAST:event_tConvontionMouseClicked

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        this.dispose();
        this.setVisible(false);
                Convontion s1 = new Convontion();
                s1.setVisible(true);
    }//GEN-LAST:event_bCancelActionPerformed

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
            java.util.logging.Logger.getLogger(RechercherConvontion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RechercherConvontion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RechercherConvontion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RechercherConvontion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RechercherConvontion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bRechercher;
    private javax.swing.JComboBox cEtatConvontion;
    private javax.swing.JComboBox cUnite;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JTable tConvontion;
    // End of variables declaration//GEN-END:variables
}
