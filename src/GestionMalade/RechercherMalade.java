/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionMalade;

import gestionbadr.Connect;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import org.apache.log4j.Logger;

public class RechercherMalade extends javax.swing.JFrame {
    static Logger log = Logger.getLogger(RechercherMalade.class.getName());
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rst = null;
    int a;
    char id; // id de l'administrateur pour qu'il revoi au bon HOME
    String Type_cancer;

    public RechercherMalade() {
        initComponents();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Cancel();
            }
        });
    }

    public RechercherMalade(char id) {
     
      initComponents();
        this.id=id;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Cancel();
            }
        });
        
    }
    
    
    private void Cancel( ){
        this.dispose();
        this.setVisible(false);
        Malade s = new Malade(id);
        s.setVisible(true);
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
        tMalade = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };
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
        setResizable(false);
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
        jScrollPane1.setBounds(10, 130, 1790, 350);

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
        cEtatSocial.setBounds(760, 50, 152, 26);

        jLabel11.setText("Etat Sociale :");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(670, 50, 73, 20);

        bCancel2.setText("Cancel");
        bCancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancel2ActionPerformed(evt);
            }
        });
        jPanel1.add(bCancel2);
        bCancel2.setBounds(1680, 500, 87, 32);

        bRechercherMalade.setText("Rechercher");
        bRechercherMalade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRechercherMaladeActionPerformed(evt);
            }
        });
        jPanel1.add(bRechercherMalade);
        bRechercherMalade.setBounds(1640, 50, 97, 32);

        cWillaya.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Adrar", "Chlef", "Laghouat", "Oum El Bouaghi", "Batna", "Béjaïa", "Biskra", "Béchar", "Blida", "Bouira", "Tamanrasset", "Tébessa", "Tlemcen", "Tiaret", "Tizi Ouzou", "Alger", "Djelfa", "Jijel", "Sétif", "Saïda", "Skikda", "Sidi Bel Abbès", "Annaba", "Guelma", "Constantine", "Médéa", "Mostaganem", "M'Sila", "Mascara", "Ouargla", "Oran", "El Bayadh", "Illizi", "Bordj Bou Arreridj", "Boumerdès", "El Tarf", "Tindouf", "Tissemsilt", "El Oued", "Khenchela", "Souk Ahras", "Tipaza", "Mila", "Aïn Defla", "Naàma", "Aïn Témouchent", "Ghardaïa", "Relizane", " " }));
        cWillaya.setSelectedIndex(-1);
        jPanel1.add(cWillaya);
        cWillaya.setBounds(1260, 50, 160, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Willaya :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(1170, 60, 70, 17);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1810, 550);

        setSize(new java.awt.Dimension(1828, 600));
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
                String sql = "SELECT id_m, prenom_m, nom_m, adr_m, ville_m, willaya_m, Etat_social, Medecin_m, date_n_m, num_tel_m , tel_famille_m, sexe_m, type_cancer FROM `malade`INNER JOIN maladies ON maladies_id_maladi1 = id_maladi where id_m LIKE '" + cAlphabet.getSelectedItem() + "%'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tMalade.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            }
        } else if (cAlphabet.getSelectedIndex() == -1 && txtId_p3.getText().equals("")
                && txtInt.getText().equals("") && cEtatSocial.getSelectedIndex() == -1) {
            // willaya
            try {
                //1er requete pour identifier une erreur de redendence 
                String sql = "SELECT id_m, prenom_m, nom_m, adr_m, ville_m, willaya_m, Etat_social, Medecin_m, date_n_m, num_tel_m , tel_famille_m, sexe_m, type_cancer FROM `malade`INNER JOIN maladies ON maladies_id_maladi1 = id_maladi where willaya_m='" + cWillaya.getSelectedItem() + "'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tMalade.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            }
        } else if (cAlphabet.getSelectedIndex() == -1 && txtId_p3.getText().equals("")
                && txtInt.getText().equals("") && cWillaya.getSelectedIndex() == -1) {
            // etat social
            try {
                //1er requete pour identifier une erreur de redendence 
                String sql = "SELECT id_m, prenom_m, nom_m, adr_m, ville_m, willaya_m, Etat_social, Medecin_m, date_n_m, num_tel_m , tel_famille_m, sexe_m, type_cancer FROM `malade`INNER JOIN maladies ON maladies_id_maladi1 = id_maladi where Etat_social='" + cEtatSocial.getSelectedItem() + "'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tMalade.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            }
        } else if (txtId_p3.getText().equals("") && txtInt.getText().equals("")
                && cWillaya.getSelectedIndex() == -1) {
            // alpha + etat
            try {
                //1er requete pour identifier une erreur de redendence 
                String sql = "SELECT id_m, prenom_m, nom_m, adr_m, ville_m, willaya_m, Etat_social, Medecin_m, date_n_m, num_tel_m , tel_famille_m, sexe_m, type_cancer FROM `malade`INNER JOIN maladies ON maladies_id_maladi1 = id_maladi where Etat_social ='" + cEtatSocial.getSelectedItem()
                        + "'AND id_m LIKE'" + cAlphabet.getSelectedItem() + "%'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tMalade.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            }
        } else if (txtId_p3.getText().equals("") && txtInt.getText().equals("")
                && cEtatSocial.getSelectedIndex() == -1) {
            // alpha + willaya
            try {
                //1er requete pour identifier une erreur de redendence 
                String sql = "SELECT id_m, prenom_m, nom_m, adr_m, ville_m, willaya_m, Etat_social, Medecin_m, date_n_m, num_tel_m , tel_famille_m, sexe_m, type_cancer FROM `malade`INNER JOIN maladies ON maladies_id_maladi1 = id_maladi where willaya_m ='" + cWillaya.getSelectedItem()
                        + "'AND id_m LIKE'" + cAlphabet.getSelectedItem() + "%'";

                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tMalade.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            }
        } else if (cEtatSocial.getSelectedIndex() == -1 && cWillaya.getSelectedIndex() == -1) {
            // id malade
            DecimalFormat myFormatter = new DecimalFormat("0000");
            String output = myFormatter.format(Integer.parseInt(txtInt.getText()));
            String output2 = myFormatter.format(Integer.parseInt(txtId_p3.getText()));
            String id_m = cAlphabet.getSelectedItem() + output + output2;
            try {
                //1er requete pour identifier une erreur de redendence 
                String sql = "SELECT id_m, prenom_m, nom_m, adr_m, ville_m, willaya_m, Etat_social, Medecin_m, date_n_m, num_tel_m , tel_famille_m, sexe_m, type_cancer FROM `malade`INNER JOIN maladies ON maladies_id_maladi1 = id_maladi where id_m='" + id_m + "'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tMalade.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            }
        } else if (cAlphabet.getSelectedIndex() == -1 && txtId_p3.getText().equals("")
                && txtInt.getText().equals("")) {
            // willaya + etat
            try {
                //1er requete pour identifier une erreur de redendence 
                String sql = "SELECT id_m, prenom_m, nom_m, adr_m, ville_m, willaya_m, Etat_social, Medecin_m, date_n_m, num_tel_m , tel_famille_m, sexe_m, type_cancer FROM `malade`INNER JOIN maladies ON maladies_id_maladi1 = id_maladi where Etat_social ='" + cEtatSocial.getSelectedItem()
                        + "'AND willaya_m='" + cWillaya.getSelectedItem() + "'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tMalade.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            }
        }else if (txtId_p3.getText().equals("") && txtInt.getText().equals("")) {
            // willaya + etat + Alphabet
            try {
                //1er requete pour identifier une erreur de redendence 
                String sql = "SELECT id_m, prenom_m, nom_m, adr_m, ville_m, willaya_m, Etat_social, Medecin_m, date_n_m, num_tel_m , tel_famille_m, sexe_m, type_cancer FROM `malade`INNER JOIN maladies ON maladies_id_maladi1 = id_maladi where Etat_social ='" + cEtatSocial.getSelectedItem()
                        + "'AND willaya_m='" + cWillaya.getSelectedItem() 
                        + "'AND id_m LIKE'" + cAlphabet.getSelectedItem() + "%'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tMalade.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
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
                Malade s = new Malade(id);
                s.setVisible(true);
                String adr_m = rst.getString("adr_m");
                s.txtAdress.setText(adr_m);
                String Medecin_m = rst.getString("Medecin_m");
                s.txtMedecin.setText(Medecin_m);
                String id_m = rst.getString("id_m");
                String p1 = id_m.substring(0, 1);
                s.cAlphabet.setSelectedItem(p1);
                s.cAlphabet.setEditable(false);
                String p2 = id_m.substring(1, 5);
                s.txtInt.setText(p2);
                String p3 = id_m.substring(5, 9);
                s.txtId_p3.setText(p3);
                String nom_m = rst.getString("nom_m");
                s.txtNom.setText(nom_m);
                String Etat_social = rst.getString("Etat_social");
                s.cEtatSocial.setSelectedItem(Etat_social);
                String num_tel_m = rst.getString("num_tel_m");
                s.txtNumTelMalade.setText(num_tel_m);
                String tel_famille_m = rst.getString("tel_famille_m");
                s.txtNumTelFamille.setText(tel_famille_m);
                String prenom_m = rst.getString("prenom_m");
                s.txtPrenom.setText(prenom_m);
                String ville_m = rst.getString("ville_m");
                s.txtVille.setText(ville_m);
                Date date_n_m = rst.getDate("date_n_m");
                s.jDateNaiMalade.setDate(date_n_m);
                String willaya_m = rst.getString("willaya_m");
                s.cWillaya.setSelectedItem(willaya_m);
                String sexe_m = rst.getString("sexe_m");
                s.cSexe.setSelectedItem(sexe_m);
                a = rst.getInt("maladies_id_maladi1");
                Rechercher_id_Maladie();
                s.cMaladie.setSelectedItem(Type_cancer);
                s.cAlphabet.setEnabled(false);
                s.txtId_p3.setEditable(false);
                s.txtInt.setEditable(false);
                s.bAjouter.setEnabled(false);
                s.bModifier.setEnabled(true);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            log.error(e);
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
            log.error(e);
        }

    }
    private void bCancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancel2ActionPerformed
        System.out.println(" kwd");
        Cancel();
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
            java.util.logging.Logger.getLogger(RechercherMalade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RechercherMalade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RechercherMalade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RechercherMalade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RechercherMalade().setVisible(true);
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
