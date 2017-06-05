/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionConvontion;

import GestionPartenaire.RechercherPartenaire;
import GestionRDV.RDV;
import gestionbadr.Connect;
import gestionbadr.Parametre;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author FAWZI
 */
public class Convontion extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rst = null;
    String nom_p;
    String type_p;
    protected int id_p;
    Boolean b = false;
    protected int id_conv;
    protected String nom_pr;

    public Convontion() {
        initComponents();
        Remplir_Combo_Partenaire();
        cPartenaire.setSelectedIndex(-1);
        txtType.setVisible(false);
        bModifierPartenaire.setEnabled(false);
        addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){
                            Cancel();
			}
		});
    }
    
    private void Cancel(){
        this.dispose();
        this.setVisible(false);
        if (b == true) {
            RDV s = new RDV();
            s.setVisible(true);

        } else {
            Parametre s = new Parametre();
            s.setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNomConvontion = new javax.swing.JTextField();
        cPartenaire = new javax.swing.JComboBox();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cUnite = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        chIRM = new javax.swing.JCheckBox();
        chScaner = new javax.swing.JCheckBox();
        chMamographie = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        cInjection = new javax.swing.JComboBox();
        cEtatConvontion = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtType = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        bSavePartenaire = new javax.swing.JButton();
        bCancelPartenaire = new javax.swing.JButton();
        bModifierPartenaire = new javax.swing.JButton();
        bRechercherBenevole = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajouter Convontion");

        jLabel1.setText("Nom Convontion :");

        jLabel2.setText("Partenaire");

        jLabel5.setText("Nombre :");

        txtNomConvontion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomConvontionActionPerformed(evt);
            }
        });

        cPartenaire.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cPartenairePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cPartenaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cPartenaireActionPerformed(evt);
            }
        });

        jLabel4.setText("Unite");

        cUnite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mois", "Semaine", "Jours" }));
        cUnite.setSelectedIndex(-1);

        jLabel3.setText("Type");

        chIRM.setText("IRM");

        chScaner.setText("Scaner");

        chMamographie.setText("Mamographie");

        jLabel6.setText("Injection:");

        cInjection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gratuit", "Payant", "demi tarif" }));
        cInjection.setSelectedIndex(-1);

        cEtatConvontion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Areter", "Marche", " " }));
        cEtatConvontion.setSelectedIndex(-1);

        jLabel7.setText("Etat de la Convontion");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addComponent(jLabel1))
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomConvontion, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cUnite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chIRM)
                    .addComponent(chScaner)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cEtatConvontion, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cInjection, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chMamographie, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cPartenaire, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomConvontion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cPartenaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cUnite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(chIRM))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chScaner)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chMamographie)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cInjection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cEtatConvontion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        bSavePartenaire.setText("Save");
        bSavePartenaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSavePartenaireActionPerformed(evt);
            }
        });

        bCancelPartenaire.setText("Cancel");
        bCancelPartenaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelPartenaireActionPerformed(evt);
            }
        });

        bModifierPartenaire.setText("Modifier");
        bModifierPartenaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModifierPartenaireActionPerformed(evt);
            }
        });

        bRechercherBenevole.setText("Rechercher");
        bRechercherBenevole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRechercherBenevoleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bSavePartenaire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bCancelPartenaire, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(bModifierPartenaire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bRechercherBenevole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(bSavePartenaire)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bModifierPartenaire)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bRechercherBenevole)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bCancelPartenaire)
                .addGap(98, 98, 98))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(602, 497));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomConvontionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomConvontionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomConvontionActionPerformed

    
    public Boolean getB() {
        return b;
    }

    public void setB(Boolean b) {
        this.b = b;
    }

    protected void reset() {
        txtNomConvontion.setText("");
        txtNombre.setText("");
        txtType.setText("");
        
        cEtatConvontion.setSelectedIndex(-1);
        cInjection.setSelectedIndex(-1);
        cPartenaire.setSelectedIndex(-1);
        cUnite.setSelectedIndex(-1);
        
        chIRM.setSelected(false);
        chMamographie.setSelected(false);
        chScaner.setSelected(false);
           
    }

    private void bSavePartenaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSavePartenaireActionPerformed
        String r = "";
        if (chIRM.isSelected() && chMamographie.isSelected() && chScaner.isSelected()) {
            r = chIRM.getText() + "/" + chMamographie.getText() + "/" + chScaner.getText();
        } else if (chIRM.isSelected() && chScaner.isSelected()) {
            r = chIRM.getText() + "/" + chScaner.getText();
        } else if (chMamographie.isSelected() && chScaner.isSelected()) {
            r = chMamographie.getText() + "/" + chScaner.getText();
        } else if (chIRM.isSelected() && chMamographie.isSelected()) {
            r = chIRM.getText() + "/" + chMamographie.getText();
        } else if (chIRM.isSelected()) {
            r = chIRM.getText();
        } else if (chMamographie.isSelected()) {
            r = chMamographie.getText();
        } else if (chScaner.isSelected()) {
            r = chScaner.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Il faut choisire le Type");
        }
        Rechercher_id_Partenaire();
        con = Connect.connect();
        try {

            String sql2 = "insert into  convontion (nbr_RDv, Unite, Nom_convontion, type_radiologie,"
                    + " injection, Etat_c, partenaire_id_p ) values('"
                    + Integer.parseInt(txtNombre.getText()) + "','" + cUnite.getSelectedItem() + "','" + txtNomConvontion.getText()
                    + "','" + r + "','" + cInjection.getSelectedItem() + "','" + cEtatConvontion.getSelectedItem()
                    + "','" + id_p + "')";
            pst = con.prepareStatement(sql2);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Successfully registred");
            reset();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_bSavePartenaireActionPerformed

    private void bCancelPartenaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelPartenaireActionPerformed
        Cancel();
    }//GEN-LAST:event_bCancelPartenaireActionPerformed

    private void bModifierPartenaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModifierPartenaireActionPerformed
       
        int val = JOptionPane.showConfirmDialog(null, "Voulez vous modifier ?");
        String r = "";
        
        if (chIRM.isSelected() && chMamographie.isSelected() && chScaner.isSelected()) {
            r = chIRM.getText() + "/" + chMamographie.getText() + "/" + chScaner.getText();
        } else if (chIRM.isSelected() && chScaner.isSelected()) {
            r = chIRM.getText() + "/" + chScaner.getText();
        } else if (chMamographie.isSelected() && chScaner.isSelected()) {
            r = chMamographie.getText() + "/" + chScaner.getText();
        } else if (chIRM.isSelected() && chMamographie.isSelected()) {
            r = chIRM.getText() + "/" + chMamographie.getText();
        } else if (chIRM.isSelected()) {
            r = chIRM.getText();
        } else if (chMamographie.isSelected()) {
            r = chMamographie.getText();
        } else if (chScaner.isSelected()) {
            r = chScaner.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Il faut choisire le Type");
        }
        if (val == 0) {
            Rechercher_id_Partenaire();
            try {
                con = Connect.connect();
                String sql = "update convontion set unite='" + cUnite.getSelectedItem()
                        + "',nbr_RDv='" + txtNombre.getText()
                        + "',partenaire_id_p='" + id_p
                        + "',nom_convontion='" + txtNomConvontion.getText()
                        + "',type_radiologie='" + r
                        + "',injection='" + cInjection.getSelectedItem()
                        + "',etat_c='" + cEtatConvontion.getSelectedItem()
                        + "' WHERE id_conv='" + id_conv + "'";

                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Update Successfully");
                reset();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_bModifierPartenaireActionPerformed

    private void bRechercherBenevoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechercherBenevoleActionPerformed
        this.dispose();
        this.setVisible(false);
        RechercherConvontion s = new RechercherConvontion();
        s.setVisible(true);
    }//GEN-LAST:event_bRechercherBenevoleActionPerformed

    private void cPartenairePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cPartenairePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        Rechercher_id_Partenaire();
        if (!type_p.equals("Radiologue")) {
            chIRM.setEnabled(false);
            chMamographie.setEnabled(false);
            chScaner.setEnabled(false);
            cInjection.setEnabled(false);
        } else {
            chIRM.setEnabled(true);
            chMamographie.setEnabled(true);
            chScaner.setEnabled(true);
            cInjection.setEnabled(true);
        }
    }//GEN-LAST:event_cPartenairePopupMenuWillBecomeInvisible

    private void cPartenaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cPartenaireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cPartenaireActionPerformed

    @SuppressWarnings("unchecked")
    private void Remplir_Combo_Partenaire() {
        con = Connect.connect();
        String requete = "select * from partenaire";
        try {
            pst = con.prepareStatement(requete);
            rst = pst.executeQuery();
            while (rst.next()) {
                nom_p = rst.getString("nom_p");
                cPartenaire.addItem(nom_p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void Rechercher_id_Partenaire() {
//        Rechercher par raport au choix du combobox
        String sql = "select id_p, type_p from  partenaire where nom_p ='" + cPartenaire.getSelectedItem() + "'";
        con = Connect.connect();

        try {
            pst = con.prepareStatement(sql);
            ResultSet rec2 = pst.executeQuery(sql);
            rec2.next();
            id_p = Integer.parseInt(rec2.getString("id_p"));
            type_p = rec2.getString("type_p");
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        System.out.println(id_p + " /// " + type_p);
    }

    protected void Rechercher_nom_Partenaire() {
//        Rechercher le nom du partenair depuis une rechercher 
        String sql = "select id_p,nom_p from  partenaire where id_p ='" + id_p + "'";
        con = Connect.connect();

        try {
            pst = con.prepareStatement(sql);
            ResultSet rec2 = pst.executeQuery(sql);
            rec2.next();
            id_p = Integer.parseInt(rec2.getString("id_p"));
            nom_pr = rec2.getString("nom_p");
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

//        System.out.println( id_p +" /// " + nom_pr);
        cPartenaire.setSelectedItem(nom_pr);
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
            java.util.logging.Logger.getLogger(Convontion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Convontion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Convontion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Convontion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Convontion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelPartenaire;
    protected javax.swing.JButton bModifierPartenaire;
    private javax.swing.JButton bRechercherBenevole;
    protected javax.swing.JButton bSavePartenaire;
    protected javax.swing.JComboBox cEtatConvontion;
    protected javax.swing.JComboBox cInjection;
    protected javax.swing.JComboBox cPartenaire;
    protected javax.swing.JComboBox cUnite;
    protected javax.swing.JCheckBox chIRM;
    protected javax.swing.JCheckBox chMamographie;
    protected javax.swing.JCheckBox chScaner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    protected javax.swing.JTextField txtNomConvontion;
    protected javax.swing.JTextField txtNombre;
    protected javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}
