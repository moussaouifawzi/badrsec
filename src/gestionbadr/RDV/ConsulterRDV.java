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
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author FAWZI
 */
public class ConsulterRDV extends javax.swing.JFrame {

    static Logger log = Logger.getLogger(ConsulterRDV.class.getName());
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String s;
    PreparedStatement pst = null;
    String row;
    ResultSet rst = null;
    char id;

    public ConsulterRDV() {
        initComponents();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Cancel();
            }
        });

    }

    public ConsulterRDV(char id) {
        initComponents();
        this.id = id;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Cancel();
            }
        });

    }

    private void Cancel() {
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
        jLabel10 = new javax.swing.JLabel();
        cAlphabet = new javax.swing.JComboBox();
        txtInt = new javax.swing.JTextField();
        txtId_p3 = new javax.swing.JTextField();
        cEtatValidation = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tRDV = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulter RDV");
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

        cEtatValidation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Annuler", "Reporter", "Pris", "En Attente" }));
        cEtatValidation.setSelectedIndex(-1);

        jLabel13.setText("Etat du RDV:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(654, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cAlphabet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtInt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId_p3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cEtatValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(jLabel13)
                        .addComponent(cEtatValidation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bRechercher))
                .addContainerGap())
        );

        tRDV.setModel(new javax.swing.table.DefaultTableModel(
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
        tRDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tRDVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tRDV);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bCancel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCancel)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1216, 575));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechercherActionPerformed

        if (cEtatValidation.getSelectedIndex() == -1 && cAlphabet.getSelectedIndex() == -1
                && txtId_p3.getText().equals("") && txtInt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Une des combinaison suivante:"
                    + "\n     - L'Id Malade."
                    + "\n     - Etat de la demande."
                    + "\n     - L'Id Malade + Etat de la demande.");

        } else if (cEtatValidation.getSelectedIndex() == -1) {
            DecimalFormat myFormatter = new DecimalFormat("0000");
            String output = myFormatter.format(Integer.parseInt(txtInt.getText()));
            String output2 = myFormatter.format(Integer.parseInt(txtId_p3.getText()));
            String id_m = cAlphabet.getSelectedItem() + output + output2;
            try {
                con = Connect.connect();
                String sql = "SELECT id_RDV, malade.id_m, nom_m, prenom_m, date_rdv, etat_rdv, remarque, date_recuperation, examen, nom_convontion, nom_p, datedepot, etat_demande "
                        + "FROM rdv "
                        + "INNER JOIN malade ON rdv.id_m = malade.id_m "
                        + "INNER JOIN convontion ON rdv.convontion_id_conv = convontion.id_conv "
                        + "INNER JOIN partenaire ON convontion.partenaire_id_p = partenaire.id_p "
                        + "INNER JOIN demande_de_rdv ON rdv.id_date_depot = demande_de_rdv.id_date_depot "
                        + "WHERE rdv.id_m = '" + id_m + "'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tRDV.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            }
        } else if (cAlphabet.getSelectedIndex() == -1
                && txtId_p3.getText().equals("") && txtInt.getText().equals("")) {
            try {
                con = Connect.connect();
                String sql = "SELECT id_RDV, malade.id_m, nom_m, prenom_m, date_rdv, etat_rdv, remarque, date_recuperation, examen, nom_convontion, nom_p, datedepot, etat_demande "
                        + "FROM rdv "
                        + "INNER JOIN malade ON rdv.id_m = malade.id_m "
                        + "INNER JOIN convontion ON rdv.convontion_id_conv = convontion.id_conv "
                        + "INNER JOIN partenaire ON convontion.partenaire_id_p = partenaire.id_p "
                        + "INNER JOIN demande_de_rdv ON rdv.id_date_depot = demande_de_rdv.id_date_depot "
                        + "WHERE Etat_RDV='" + cEtatValidation.getSelectedItem() + "'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tRDV.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            }
        } else if (!(cEtatValidation.getSelectedIndex() == -1) && !(cAlphabet.getSelectedIndex() == -1)
                && !(txtId_p3.getText().equals("")) && !(txtInt.getText().equals(""))) {
            DecimalFormat myFormatter = new DecimalFormat("0000");
            String output = myFormatter.format(Integer.parseInt(txtInt.getText()));
            String output2 = myFormatter.format(Integer.parseInt(txtId_p3.getText()));
            String id_m = cAlphabet.getSelectedItem() + output + output2;
            try {
                con = Connect.connect();
                String sql = "SELECT id_RDV, malade.id_m, nom_m, prenom_m, date_rdv, etat_rdv, remarque, date_recuperation, examen, nom_convontion, nom_p, datedepot, etat_demande "
                        + "FROM rdv "
                        + "INNER JOIN malade ON rdv.id_m = malade.id_m "
                        + "INNER JOIN convontion ON rdv.convontion_id_conv = convontion.id_conv "
                        + "INNER JOIN partenaire ON convontion.partenaire_id_p = partenaire.id_p "
                        + "INNER JOIN demande_de_rdv ON rdv.id_date_depot = demande_de_rdv.id_date_depot "
                        + "WHERE  Etat_RDV='" + cEtatValidation.getSelectedItem()
                        + "' AND rdv.id_m = '" + id_m + "'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tRDV.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            }
        }

    }//GEN-LAST:event_bRechercherActionPerformed

    private void tRDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tRDVMouseClicked
        log.trace("Debut");
        con = Connect.connect();
        int row = tRDV.getSelectedRow();
        String n;
        n = tRDV.getModel().getValueAt(row, 0).toString();
        log.error(n);

        try {
            String sql = "SELECT id_RDV, malade.id_m, nom_m, prenom_m, date_rdv, etat_rdv, remarque, date_recuperation, examen, nom_convontion, nom_p, datedepot, etat_demande "
                    + "FROM rdv "
                    + "INNER JOIN malade ON rdv.id_m = malade.id_m "
                    + "INNER JOIN convontion ON rdv.convontion_id_conv = convontion.id_conv "
                    + "INNER JOIN partenaire ON convontion.partenaire_id_p = partenaire.id_p "
                    + "INNER JOIN demande_de_rdv ON rdv.id_date_depot = demande_de_rdv.id_date_depot "
                    + "WHERE id_RDV = '" + n + "'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(sql);

            if (rs.next()) {

                AfficherRDV s1 = new AfficherRDV();
                s1.setVisible(true);

                String id_m = rs.getString("id_m");
                log.debug("id_m = " + id_m);
                s1.txtid.setText(id_m);
                String nom_m = rs.getString("nom_m");
                s1.txtNom.setText(nom_m);
                String prenom_m = rs.getString("prenom_m");
                s1.txtPrenom.setText(prenom_m);
                String etat_rdv = rs.getString("etat_rdv");
                s1.txtEtatRDV.setText(etat_rdv);
                String examen = rs.getString("examen");
                s1.aExamen.setText(examen);
                String remarque = rs.getString("remarque");
                s1.aRemarque.setText(remarque);
                
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date date_rdv = rs.getDate("date_rdv");
                String date_rdv_formater = df.format(date_rdv);
                s1.txtDateRDV.setText(date_rdv_formater);
                
                DateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
                Date datedepot = rs.getDate("datedepot");
                String datedepot_formater = dff.format(datedepot);
                s1.txtDateDepot.setText(datedepot_formater);
                
//                s1.txtid.setText(Integer.toString(id_m));
//                
//                Date date_rdv = rs.getDate("date_rdv");
//                s1.txtDateRDV.setText(date_rdv);
//                Date date_recuperation = rs.getDate("date_recuperation");
//                s1.jDateRecuperation.setDate(date_recuperation);
//                
//                String Etat_RDV = rs.getString("Etat_RDV");
//                s1.cEtatValidation.setSelectedItem(Etat_RDV);
//                String Remarque = rs.getString("Remarque");
//                s1.textRemarque.setText(Remarque);
//                
//                s1.id_date_depot = rs.getInt("id_date_depot");
//                s1.id_conv = rs.getInt("convontion_id_conv");
//                s1.id_date_depot = rs.getInt("id_date_depot");
//                s1.partenaire_id_p = rs.getInt("convontion_partenaire_id_p");
//                 s1.id_m = rs.getString("id_m");
//                 
//                
//                s1.bAjouterValidation.setEnabled(false);
//                s1.jTabbedPane1.setEnabledAt(1, true);
//        s1.jTabbedPane1.setEnabledAt(2, true);
//        s1.jTabbedPane1.setEnabledAt(3, true);
//        s1.jTabbedPane1.setSelectedIndex(3);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            log.error(e);
        }
        log.trace("Fin");
    }//GEN-LAST:event_tRDVMouseClicked

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
            java.util.logging.Logger.getLogger(ConsulterRDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsulterRDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsulterRDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsulterRDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ConsulterRDV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bRechercher;
    private javax.swing.JComboBox cAlphabet;
    private javax.swing.JComboBox cEtatValidation;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JTable tRDV;
    private javax.swing.JTextField txtId_p3;
    private javax.swing.JTextField txtInt;
    // End of variables declaration//GEN-END:variables
}
