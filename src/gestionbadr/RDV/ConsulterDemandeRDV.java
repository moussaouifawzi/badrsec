/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbadr.RDV;

import gestionbadr.Connect;
import gestionbadr.HomeAdministrateur;
import gestionbadr.HomeDirecteur;
import gestionbadr.HomeSecretaire;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author FAWZI
 */
public class ConsulterDemandeRDV extends javax.swing.JFrame {
static Logger log = Logger.getLogger(ConsulterDemandeRDV.class.getName());
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String s;
    PreparedStatement pst = null;
    String row;
    ResultSet rst = null;
    char id;

    public ConsulterDemandeRDV() {
        initComponents();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Cancel();
            }
        });

    }
    
    public ConsulterDemandeRDV(char id) {
        initComponents();
        this.id = id;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Cancel();
            }
        });

    }
    
    private void Cancel(){
        this.dispose();
        this.setVisible(false);

        if (id == 'A') {
            this.setVisible(false);
            HomeAdministrateur h = new HomeAdministrateur(id);
            h.setVisible(true);
        } else if (id == 'S') {
            this.setVisible(false);

            HomeSecretaire h = new HomeSecretaire(id);
            h.setVisible(true);
        } else if (id == 'D') {
            this.setVisible(false);
            HomeDirecteur h = new HomeDirecteur(id);
            h.setVisible(true);
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

        bCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        bRechercher = new javax.swing.JButton();
        cEtatRDV = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cAlphabet = new javax.swing.JComboBox();
        txtInt = new javax.swing.JTextField();
        txtId_p3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDemandeRDV = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulter Demande RDV");
        setResizable(false);

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

        cEtatRDV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Valider", "En Attente" }));
        cEtatRDV.setSelectedIndex(-1);

        jLabel7.setText("Etat du RDV:");

        jLabel10.setText("ID :");

        cAlphabet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "Z" }));
        cAlphabet.setSelectedIndex(-1);
        cAlphabet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cAlphabetActionPerformed(evt);
            }
        });

        txtInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIntActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cAlphabet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtInt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId_p3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(cEtatRDV, 0, 180, Short.MAX_VALUE)))))
                .addGap(171, 171, 171)
                .addComponent(bRechercher)
                .addGap(8, 8, 8))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtId_p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cAlphabet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(cEtatRDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bRechercher))
                .addContainerGap())
        );

        tDemandeRDV.setModel(new javax.swing.table.DefaultTableModel(
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
        tDemandeRDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tDemandeRDVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tDemandeRDV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bCancel)
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(696, 383));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechercherActionPerformed

        if (cEtatRDV.getSelectedIndex() == -1 && cAlphabet.getSelectedIndex() == -1
                && txtId_p3.getText().equals("") && txtInt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Une des combinaison suivante:"
                    + "\n     - L'Id Malade."
                    + "\n     - Etat de la demande."
                    + "\n     - L'Id Malade + Etat de la demande.");

        } else if (cEtatRDV.getSelectedIndex() == -1) {
            DecimalFormat myFormatter = new DecimalFormat("0000");
            String output = myFormatter.format(Integer.parseInt(txtInt.getText()));
            String output2 = myFormatter.format(Integer.parseInt(txtId_p3.getText()));
            String id_m = cAlphabet.getSelectedItem() + output + output2;
            try {
                con = Connect.connect();
                String sql = "SELECT datedepot, malade.id_m, nom_m, prenom_m, etat_demande FROM demande_de_rdv INNER JOIN malade ON demande_de_rdv.id_m = malade.id_m WHERE id_m = '" + id_m + "'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tDemandeRDV.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            }
        } else if (cAlphabet.getSelectedIndex() == -1
                && txtId_p3.getText().equals("") && txtInt.getText().equals("")) {
            try {
                con = Connect.connect();
                String sql = "SELECT datedepot, malade.id_m, nom_m, prenom_m, etat_demande FROM demande_de_rdv INNER JOIN malade ON demande_de_rdv.id_m = malade.id_m WHERE Etat_Demande='" + cEtatRDV.getSelectedItem() + "'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tDemandeRDV.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            }
        } else if (!(cEtatRDV.getSelectedIndex() == -1) && !(cAlphabet.getSelectedIndex() == -1)
                && !(txtId_p3.getText().equals("")) && !(txtInt.getText().equals(""))) {
            DecimalFormat myFormatter = new DecimalFormat("0000");
            String output = myFormatter.format(Integer.parseInt(txtInt.getText()));
            String output2 = myFormatter.format(Integer.parseInt(txtId_p3.getText()));
            String id_m = cAlphabet.getSelectedItem() + output + output2;
            try {
                con = Connect.connect();
                String sql = "SELECT datedepot, malade.id_m, nom_m, prenom_m, etat_demande FROM demande_de_rdv INNER JOIN malade ON demande_de_rdv.id_m = malade.id_m WHERE  Etat_Demande='" + cEtatRDV.getSelectedItem()
                        + "' AND id_m = '" + id_m + "'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tDemandeRDV.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            }
        }

    }//GEN-LAST:event_bRechercherActionPerformed

    private void tDemandeRDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tDemandeRDVMouseClicked
//
//        con = Connect.connect();
//        int row = tDemandeRDV.getSelectedRow();
//        String n;
//        n = tDemandeRDV.getModel().getValueAt(row, 2).toString();
//
//        try {
//            String sql = "SELECT datedepot, malade.id_m, nom_m, prenom_m, etat_demande FROM demande_de_rdv INNER JOIN malade ON demande_de_rdv.id_m = malade.id_m WHERE id_date_depot = '" + n + "'";
//            pst = con.prepareStatement(sql);
//            rs = pst.executeQuery(sql);
//
//            if (rs.next()) {
//                this.setVisible(false);
//                RDV s1 = new RDV();
//                s1.setVisible(true);
//
//                String id_m = rs.getString("id_m");
//                String p1 = id_m.substring(0, 1);
//                s1.cAlphabet.setSelectedItem(p1);
//                s1.cAlphabet.setEditable(false);
//                String p2 = id_m.substring(1, 5);
//                s1.txtInt.setText(p2);
//                String p3 = id_m.substring(5, 9);
//                s1.txtId_p3.setText(p3);
//                s1.cAlphabet.setEnabled(false);
//                s1.txtId_p3.setEditable(false);
//                s1.txtInt.setEditable(false);
//                
//                Date DateDepot = rs.getDate("DateDepot");
//                s1.jDateDepot.setDate(DateDepot);
//                
//                String Etat_Demande = rs.getString("Etat_Demande");
//                s1.cEtatDemandeRDV.setSelectedItem(Etat_Demande);
//                
//                s1.id_date_depot = rs.getInt("id_date_depot");
//                s1.bAjouterDemandeRDV.setEnabled(false);
//
//            }
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//            log.error(e);
//        }


    }//GEN-LAST:event_tDemandeRDVMouseClicked

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        Cancel();
    }//GEN-LAST:event_bCancelActionPerformed

    private void cAlphabetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cAlphabetActionPerformed

    }//GEN-LAST:event_cAlphabetActionPerformed

    private void txtIntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIntActionPerformed

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
            java.util.logging.Logger.getLogger(ConsulterDemandeRDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsulterDemandeRDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsulterDemandeRDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsulterDemandeRDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ConsulterDemandeRDV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bRechercher;
    private javax.swing.JComboBox cAlphabet;
    private javax.swing.JComboBox cEtatRDV;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JTable tDemandeRDV;
    private javax.swing.JTextField txtId_p3;
    private javax.swing.JTextField txtInt;
    // End of variables declaration//GEN-END:variables
}
