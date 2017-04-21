/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionRDV;

import GestionMalade.*;
import gestionbadr.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class RechercherMaladeRDV extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rst = null;
    int a;
    String Type_cancer;

    public RechercherMaladeRDV() {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tMalade = new javax.swing.JTable();
        txtInt = new javax.swing.JTextField();
        txtId_p3 = new javax.swing.JTextField();
        cAlphabet = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cEtatSocial = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        bCancel2 = new javax.swing.JButton();
        bRechercherMalade = new javax.swing.JButton();
        cWillaya = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rechercher Malade");
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        tMalade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Malade", "Nom", "Prenom", "Adress", "Ville", "Telephone Malade", "Telephone Famille", "Etat Social", "Medecin Traitant"
            }
        ));
        tMalade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tMaladeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tMalade);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 270, 820, 137);

        txtInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIntActionPerformed(evt);
            }
        });
        jPanel1.add(txtInt);
        txtInt.setBounds(200, 50, 100, 24);
        jPanel1.add(txtId_p3);
        txtId_p3.setBounds(330, 50, 100, 24);

        cAlphabet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "Z" }));
        cAlphabet.setSelectedIndex(-1);
        cAlphabet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cAlphabetActionPerformed(evt);
            }
        });
        jPanel1.add(cAlphabet);
        cAlphabet.setBounds(140, 50, 42, 26);

        jLabel10.setText("ID :");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(100, 60, 17, 16);

        cEtatSocial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Asurer", "Non Asurer" }));
        cEtatSocial.setSelectedIndex(-1);
        jPanel1.add(cEtatSocial);
        cEtatSocial.setBounds(170, 90, 152, 26);

        jLabel11.setText("Etat Sociale :");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(80, 90, 73, 20);

        bCancel2.setText("Cancel");
        bCancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancel2ActionPerformed(evt);
            }
        });
        jPanel1.add(bCancel2);
        bCancel2.setBounds(720, 120, 87, 32);

        bRechercherMalade.setText("Rechercher");
        bRechercherMalade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRechercherMaladeActionPerformed(evt);
            }
        });
        jPanel1.add(bRechercherMalade);
        bRechercherMalade.setBounds(720, 70, 97, 32);

        cWillaya.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Adrar", "Chlef", "Laghouat", "Oum El Bouaghi", "Batna", "Béjaïa", "Biskra", "Béchar", "Blida", "Bouira", "Tamanrasset", "Tébessa", "Tlemcen", "Tiaret", "Tizi Ouzou", "Alger", "Djelfa", "Jijel", "Sétif", "Saïda", "Skikda", "Sidi Bel Abbès", "Annaba", "Guelma", "Constantine", "Médéa", "Mostaganem", "M'Sila", "Mascara", "Ouargla", "Oran", "El Bayadh", "Illizi", "Bordj Bou Arreridj", "Boumerdès", "El Tarf", "Tindouf", "Tissemsilt", "El Oued", "Khenchela", "Souk Ahras", "Tipaza", "Mila", "Aïn Defla", "Naàma", "Aïn Témouchent", "Ghardaïa", "Relizane", " " }));
        cWillaya.setSelectedIndex(-1);
        jPanel1.add(cWillaya);
        cWillaya.setBounds(180, 130, 160, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Willaya :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(90, 140, 70, 17);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 840, 420);

        setSize(new java.awt.Dimension(855, 462));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cAlphabetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cAlphabetActionPerformed

    }//GEN-LAST:event_cAlphabetActionPerformed

    private void txtIntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIntActionPerformed

    private void bRechercherMaladeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechercherMaladeActionPerformed

        con = Connect.connect();
        if (cWillaya.getSelectedIndex() == -1 && cAlphabet.getSelectedIndex() == -1
                && cEtatSocial.getSelectedIndex() == -1 && txtId_p3.getText().equals("")
                && txtInt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Une des combinaison suivante:"
                    + "\n     - Alphabet de l'ID seulement."
                    + "\n     - ID compltet ou Willaya ou Etat Social."
                    + "\n     - Willaya + Etat Social ."
                    + "\n     - Willaya + Alphabet de l'ID ."
                    + "\n     - Etat Social + Alphabet de l'ID .");
        } else if (txtId_p3.getText().equals("") && txtInt.getText().equals("")
                && cWillaya.getSelectedIndex() == -1 && cEtatSocial.getSelectedIndex() == -1) {
            // alphabet
            try {
                //1er requete pour identifier une erreur de redendence 
                String sql = "Select * from malade where id_m LIKE '" + cAlphabet.getSelectedItem() + "%'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tMalade.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else if (cAlphabet.getSelectedIndex() == -1 && txtId_p3.getText().equals("")
                && txtInt.getText().equals("") && cEtatSocial.getSelectedIndex() == -1) {
            // willaya
            try {
                //1er requete pour identifier une erreur de redendence 
                String sql = "Select * from malade where willaya_m='" + cWillaya.getSelectedItem() + "'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tMalade.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else if (cAlphabet.getSelectedIndex() == -1 && txtId_p3.getText().equals("")
                && txtInt.getText().equals("") && cWillaya.getSelectedIndex() == -1) {
            // etat social
            try {
                //1er requete pour identifier une erreur de redendence 
                String sql = "Select * from malade where Etat_social='" + cEtatSocial.getSelectedItem() + "'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tMalade.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else if (txtId_p3.getText().equals("") && txtInt.getText().equals("")
                && cWillaya.getSelectedIndex() == -1) {
            // alpha + etat
            try {
                //1er requete pour identifier une erreur de redendence 
                String sql = "Select * from malade where Etat_social ='" + cEtatSocial.getSelectedItem()
                        + "'AND id_m LIKE'" + cAlphabet.getSelectedItem() + "%'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tMalade.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else if (txtId_p3.getText().equals("") && txtInt.getText().equals("")
                && cEtatSocial.getSelectedIndex() == -1) {
            // alpha + willaya
            try {
                //1er requete pour identifier une erreur de redendence 
                String sql = "Select * from malade where willaya_m ='" + cWillaya.getSelectedItem()
                        + "'AND id_m LIKE'" + cAlphabet.getSelectedItem() + "%'";

                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tMalade.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else if (cEtatSocial.getSelectedIndex() == -1 && cWillaya.getSelectedIndex() == -1) {
            // id malade
            DecimalFormat myFormatter = new DecimalFormat("0000");
            String output = myFormatter.format(Integer.parseInt(txtInt.getText()));
            String output2 = myFormatter.format(Integer.parseInt(txtId_p3.getText()));
            String id_m = cAlphabet.getSelectedItem() + output + output2;
            try {
                //1er requete pour identifier une erreur de redendence 
                String sql = "Select * from malade where id_m='" + id_m + "'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tMalade.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else if (cAlphabet.getSelectedIndex() == -1 && txtId_p3.getText().equals("")
                && txtInt.getText().equals("")) {
            // willaya + etat
            try {
                //1er requete pour identifier une erreur de redendence 
                String sql = "Select * from malade where Etat_social ='" + cEtatSocial.getSelectedItem()
                        + "'AND willaya_m='" + cWillaya.getSelectedItem() + "'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tMalade.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }else if (txtId_p3.getText().equals("") && txtInt.getText().equals("")) {
            // willaya + etat + Alphabet
            try {
                //1er requete pour identifier une erreur de redendence 
                String sql = "Select * from malade where Etat_social ='" + cEtatSocial.getSelectedItem()
                        + "'AND willaya_m='" + cWillaya.getSelectedItem() 
                        + "'AND id_m LIKE'" + cAlphabet.getSelectedItem() + "%'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tMalade.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }


    }//GEN-LAST:event_bRechercherMaladeActionPerformed

    private void tMaladeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMaladeMouseClicked
        int row = tMalade.getSelectedRow();
        String n;
        n = tMalade.getModel().getValueAt(row, 0).toString();
        try {
            String sql = "SELECT * FROM malade WHERE id_m = '" + n + "'";
            pst = con.prepareStatement(sql);
            rst = pst.executeQuery(sql);
            if (rst.next()) {
                this.setVisible(false);
                RDV s = new RDV();
                s.setVisible(true);
                
                String adr_m = rst.getString("adr_m");
                s.txtAdress.setText(adr_m);
                String nom_m = rst.getString("nom_m");
                s.txtNom.setText(nom_m);
                String num_tel_m = rst.getString("num_tel_m");
                s.txtNumTel.setText(num_tel_m);
                String prenom = rst.getString("prenom_m");
                s.txtPrenom.setText(prenom);
                String id_m = rst.getString("id_m");
                
                String p1 = id_m.substring(0, 1);
                s.cAlphabet.setSelectedItem(p1);
                s.cAlphabet.setEditable(false);
                String p2 = id_m.substring(1, 5);
                s.txtInt.setText(p2);
                String p3 = id_m.substring(5, 9);
                s.txtId_p3.setText(p3);
                
                s.cAlphabet.setEnabled(false);
                s.txtId_p3.setEditable(false);
                s.txtInt.setEditable(false);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tMaladeMouseClicked

    private void Rechercher_id_Maladie() {
        String sql = "select Type_cancer from   maladies where id_maladi ='" + a + "'";
        con = Connect.connect();

        try {
            pst = con.prepareStatement(sql);
            ResultSet rec2 = pst.executeQuery(sql);
            rec2.next();
            Type_cancer = rec2.getString("Type_cancer");

        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    private void bCancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancel2ActionPerformed

        this.dispose();
        RDV s = new RDV();
        s.setVisible(true);
        
    }//GEN-LAST:event_bCancel2ActionPerformed

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
            java.util.logging.Logger.getLogger(RechercherMaladeRDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RechercherMaladeRDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RechercherMaladeRDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RechercherMaladeRDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new RechercherMaladeRDV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel2;
    private javax.swing.JButton bRechercherMalade;
    private javax.swing.JComboBox cAlphabet;
    private javax.swing.JComboBox cEtatSocial;
    protected javax.swing.JComboBox cWillaya;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tMalade;
    private javax.swing.JTextField txtId_p3;
    private javax.swing.JTextField txtInt;
    // End of variables declaration//GEN-END:variables
}
