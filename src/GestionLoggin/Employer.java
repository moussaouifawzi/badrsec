/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionLoggin;

import gestionbadr.Connect;
import gestionbadr.HomeSecretaire;
import gestionbadr.Parametre;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FAWZI
 */
public class Employer extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    PreparedStatement pst2 = null;
    ResultSet rs2 = null;
    Statement st = null;
    String idEmployer = "";
    String nomEmployer = "";
    boolean v = false;
    String c;

    protected void reset() {
        txtUserName.setText("");
        jPassword.setText("");
        jConfirmePassword.setText("");
        cSpecialisation.setSelectedIndex(-1);
        txtNom.setText("");
        txtPrenom.setText("");
    }

    public Employer() {
        initComponents();
        bModifier.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        cSpecialisation = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jConfirmePassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        txtPrenom = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        bSave = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        bNew = new javax.swing.JButton();
        bModifier = new javax.swing.JButton();
        bRechercher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajouter utilisateur");
        getContentPane().setLayout(null);

        jPanel3.setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setText("User Name");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 73, 110, 16);

        jLabel2.setText("Password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 111, 58, 16);

        jLabel3.setText("Specialization");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 184, 79, 16);
        jPanel1.add(txtUserName);
        txtUserName.setBounds(136, 70, 168, 24);

        cSpecialisation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrateur", "Secretaire", "Directeur" }));
        cSpecialisation.setSelectedIndex(-1);
        cSpecialisation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cSpecialisationActionPerformed(evt);
            }
        });
        jPanel1.add(cSpecialisation);
        cSpecialisation.setBounds(142, 184, 168, 26);

        jLabel4.setText("Confirme Password");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 149, 113, 16);
        jPanel1.add(jPassword);
        jPassword.setBounds(136, 108, 168, 22);
        jPanel1.add(jConfirmePassword);
        jConfirmePassword.setBounds(136, 146, 168, 22);

        jLabel5.setText("Nom :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 10, 50, 16);

        jLabel6.setText("Prenom:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 42, 48, 16);
        jPanel1.add(txtNom);
        txtNom.setBounds(140, 10, 168, 24);
        jPanel1.add(txtPrenom);
        txtPrenom.setBounds(136, 39, 168, 24);

        jPanel3.add(jPanel1);
        jPanel1.setBounds(27, 25, 340, 300);

        jPanel2.setLayout(null);

        bSave.setText("Save");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });
        jPanel2.add(bSave);
        bSave.setBounds(10, 11, 169, 32);

        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });
        jPanel2.add(bCancel);
        bCancel.setBounds(10, 130, 169, 32);

        bNew.setText("Reset");
        bNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewActionPerformed(evt);
            }
        });
        jPanel2.add(bNew);
        bNew.setBounds(10, 98, 169, 32);

        bModifier.setText("Modifier");
        bModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModifierActionPerformed(evt);
            }
        });
        jPanel2.add(bModifier);
        bModifier.setBounds(10, 40, 169, 32);

        bRechercher.setText("Rechercher");
        bRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRechercherActionPerformed(evt);
            }
        });
        jPanel2.add(bRechercher);
        bRechercher.setBounds(10, 70, 169, 32);

        jPanel3.add(jPanel2);
        jPanel2.setBounds(380, 100, 189, 169);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 600, 370);

        setSize(new java.awt.Dimension(613, 404));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cSpecialisationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cSpecialisationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cSpecialisationActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        String password = String.valueOf(jPassword.getPassword());
        String confirm = String.valueOf(jConfirmePassword.getPassword());

        if (txtNom.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "enter le Nom");

        } else if (txtPrenom.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "enter le Prenom");

        } else if (txtUserName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "enter user name");

        } else if (password.equals("")) {
            JOptionPane.showMessageDialog(null, "enter password");

        } else if (confirm.equals("")) {
            JOptionPane.showMessageDialog(null, "Confirmer votre mot de password");

        } else if (!password.equals(confirm)) {
            JOptionPane.showMessageDialog(null, "Confirm not equals password");

        } else if (password.length() < 5) {
            JOptionPane.showMessageDialog(null, "password should be atleast 5 char");
        } else if (cSpecialisation.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "enter Specialization");

        } else {

            if (cSpecialisation.getSelectedItem().equals("Directeur")) {
                c = "D";
                con = Connect.connect();
                String sql = "SELECT COUNT(*)  count FROM directeur WHERE employerId LIKE '" + c + "%'";

                con = Connect.connect();

                try {
                    pst = con.prepareStatement(sql);
                    ResultSet rec2 = pst.executeQuery(sql);
                    rec2.next();
                    int nb = rec2.getInt("count");
                    String fou = Integer.toString(nb + 1);

                    //              Inserer Dans Table   "Employer"
                    String sql2 = "insert into Employer (employerId,username, password, nom_e, prenom_e) values('"
                            + c + fou + "','" + txtUserName.getText() + "','" + password + "','"
                            + txtNom.getText() + "','" + txtPrenom.getText() + "')";
                    pst = con.prepareStatement(sql2);
                    pst.execute();
                    String sql3 = "insert into directeur (employerId) values('"
                            + c + fou + "')";
                    pst = con.prepareStatement(sql3);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Successfully registred");
                    reset();

                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            } else if (cSpecialisation.getSelectedItem().equals("Administrateur")) {
                c = "A";
                con = Connect.connect();
                String sql = "SELECT COUNT(*)  count FROM administrateur WHERE employerId LIKE '" + c + "%'";

                con = Connect.connect();

                try {
                    pst = con.prepareStatement(sql);
                    ResultSet rec2 = pst.executeQuery(sql);
                    rec2.next();
                    int nb = rec2.getInt("count");
                    String fou = Integer.toString(nb + 1);

                    //              Inserer Dans Table   "Employer"
                    String sql2 = "insert into Employer (employerId,username, password, nom_e, prenom_e) values('"
                            + c + fou + "','" + txtUserName.getText() + "','" + password + "','"
                            + txtNom.getText() + "','" + txtPrenom.getText() + "')";
                    pst = con.prepareStatement(sql2);
                    pst.execute();
                    String sql3 = "insert into administrateur (employerId) values('"
                            + c + fou + "')";
                    pst = con.prepareStatement(sql3);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Successfully registred");
                    
                    reset();

                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else if (cSpecialisation.getSelectedItem().equals("Secretaire")) {
                c = "S";
                con = Connect.connect();
                String sql = "SELECT COUNT(*)  count FROM secretaire WHERE employerId LIKE '" + c + "%'";

                con = Connect.connect();

                try {
                    pst = con.prepareStatement(sql);
                    ResultSet rec2 = pst.executeQuery(sql);
                    rec2.next();
                    int nb = rec2.getInt("count");
                    String fou = Integer.toString(nb + 1);

                    //              Inserer Dans Table   "Employer"
                    String sql2 = "insert into Employer (employerId,username, password, nom_e, prenom_e) values('"
                            + c + fou + "','" + txtUserName.getText() + "','" + password + "','"
                            + txtNom.getText() + "','" + txtPrenom.getText() + "')";
                    pst = con.prepareStatement(sql2);
                    pst.execute();
                    String sql3 = "insert into secretaire (employerId) values('"
                            + c + fou + "')";
                    pst = con.prepareStatement(sql3);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Successfully registred");
                    
                    reset();

                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void insererEmployer() {
        String password = String.valueOf(jPassword.getPassword());
//                Calculer ID Employer
        con = Connect.connect();
        String sql = "SELECT COUNT(*)  count FROM directeur WHERE employerId LIKE '" + c + "%'";

        con = Connect.connect();

        try {
            pst = con.prepareStatement(sql);
//                                        System.out.println("hghghgh");
            ResultSet rec2 = pst.executeQuery(sql);
//                                       System.out.println("hfhghgh");
            rec2.next();
            int nb = rec2.getInt("count");
            String fou = Integer.toString(nb + 1);

            //              Inserer Dans Table   "Employer"
            String sql2 = "insert into Employer (employerId,username, password, nom_e, prenom_e) values('"
                    + c + fou + "','" + txtUserName.getText() + "','" + password + "','"
                    + txtNom.getText() + "','" + txtPrenom.getText() + "')";
            pst = con.prepareStatement(sql2);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Successfully registred");
            v = true;
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        this.dispose();
        this.setVisible(false);
                Parametre s = new Parametre();
                s.setVisible(true);
    }//GEN-LAST:event_bCancelActionPerformed


    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_bNewActionPerformed

    private void bModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModifierActionPerformed
int val = JOptionPane.showConfirmDialog(null, "Voulez vous modifier ?");
        if (val == 0) {
        try {
                con = Connect.connect();
                String sql = "update employer set Nom_e='" + txtNom.getText()
                        + "',Prenom_e='" + txtPrenom.getText()
                        + "',username='" + txtUserName.getText() 
                        + "' WHERE employerId='" + idEmployer + "'";

                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Update Successfully");
                
                reset();
                bModifier.setEnabled(false);
                bSave.setEnabled(true);
                cSpecialisation.setEnabled(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }}
    }//GEN-LAST:event_bModifierActionPerformed

    private void bRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechercherActionPerformed
        this.setVisible(false);
        RechercherUser s = new RechercherUser();
        DefaultTableModel md = new DefaultTableModel();
        md.setColumnIdentifiers(new String[]{"numero", "nom", "prenom"});
        try {
            con = Connect.connect();
            st = con.createStatement();
            rs = st.executeQuery("select * from employer ");
            while (rs.next()) {
                md.addRow(new Object[]{rs.getObject("employerId"), rs.getObject("Prenom_e"), rs.getObject("Nom_e")});
            }
            s.tUser.setModel(md);

            s.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_bRechercherActionPerformed

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
            java.util.logging.Logger.getLogger(Employer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    protected javax.swing.JButton bModifier;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bRechercher;
    protected javax.swing.JButton bSave;
    protected javax.swing.JComboBox cSpecialisation;
    private javax.swing.JPasswordField jConfirmePassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPassword;
    protected javax.swing.JTextField txtNom;
    protected javax.swing.JTextField txtPrenom;
    protected javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
