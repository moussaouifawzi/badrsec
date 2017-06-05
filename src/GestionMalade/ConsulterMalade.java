/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionMalade;

import gestionbadr.Connect;

import gestionbadr.HomeAdministrateur;
import gestionbadr.HomeDirecteur;
import gestionbadr.HomeSecretaire;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class ConsulterMalade extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rst = null;
char id;
    public ConsulterMalade() {
        initComponents();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Cancel();
            }
        });
    }
    
    private void Cancel(){
        
        this.dispose();
        this.setVisible(false);
       if ( id == 'A' ){
                        this.setVisible(false);
                       
                        HomeAdministrateur h = new HomeAdministrateur(id);
                        h.setVisible(true);
                    } else if ( id == 'S' ){
                        this.setVisible(false);
                      
                        HomeSecretaire h = new HomeSecretaire(id);
                        h.setVisible(true);
                    } else if ( id == 'D' ){
                        this.setVisible(false);
                        
                        HomeDirecteur h = new HomeDirecteur(id);
                        h.setVisible(true);
                    }
    }
    
     public ConsulterMalade(char id) {
        initComponents();
        this.id=id;
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
        jLabel10 = new javax.swing.JLabel();
        cAlphabet = new javax.swing.JComboBox();
        txtInt = new javax.swing.JTextField();
        txtId_p3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cEtatSocial = new javax.swing.JComboBox();
        bCancel2 = new javax.swing.JButton();
        bRechercherMalade = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cWillaya = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulter Malade");

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
        jScrollPane1.setBounds(20, 210, 808, 137);

        jLabel10.setText("ID :");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(70, 80, 27, 16);

        cAlphabet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "Z" }));
        cAlphabet.setSelectedIndex(-1);
        cAlphabet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cAlphabetActionPerformed(evt);
            }
        });
        jPanel1.add(cAlphabet);
        cAlphabet.setBounds(95, 70, 60, 26);

        txtInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIntActionPerformed(evt);
            }
        });
        jPanel1.add(txtInt);
        txtInt.setBounds(160, 70, 75, 24);
        jPanel1.add(txtId_p3);
        txtId_p3.setBounds(240, 70, 70, 24);

        jLabel11.setText("Etat Sociale :");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(380, 110, 73, 16);

        cEtatSocial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Asurer", "Non Asurer" }));
        cEtatSocial.setSelectedIndex(-1);
        jPanel1.add(cEtatSocial);
        cEtatSocial.setBounds(460, 110, 152, 26);

        bCancel2.setText("Cancel");
        bCancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancel2ActionPerformed(evt);
            }
        });
        jPanel1.add(bCancel2);
        bCancel2.setBounds(680, 120, 87, 32);

        bRechercherMalade.setText("Rechercher");
        bRechercherMalade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRechercherMaladeActionPerformed(evt);
            }
        });
        jPanel1.add(bRechercherMalade);
        bRechercherMalade.setBounds(680, 80, 97, 32);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 840, 360);

        cWillaya.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Adrar", "Chlef", "Laghouat", "Oum El Bouaghi", "Batna", "Béjaïa", "Biskra", "Béchar", "Blida", "Bouira", "Tamanrasset", "Tébessa", "Tlemcen", "Tiaret", "Tizi Ouzou", "Alger", "Djelfa", "Jijel", "Sétif", "Saïda", "Skikda", "Sidi Bel Abbès", "Annaba", "Guelma", "Constantine", "Médéa", "Mostaganem", "M'Sila", "Mascara", "Ouargla", "Oran", "El Bayadh", "Illizi", "Bordj Bou Arreridj", "Boumerdès", "El Tarf", "Tindouf", "Tissemsilt", "El Oued", "Khenchela", "Souk Ahras", "Tipaza", "Mila", "Aïn Defla", "Naàma", "Aïn Témouchent", "Ghardaïa", "Relizane", " " }));
        cWillaya.setSelectedIndex(-1);
        jPanel1.add(cWillaya);
        cWillaya.setBounds(180, 130, 160, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Willaya :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(90, 140, 70, 17);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(855, 394));
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
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
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
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
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
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
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
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
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
                String sql = "SELECT id_m, prenom_m, nom_m, adr_m, ville_m, willaya_m, Etat_social, Medecin_m, date_n_m, num_tel_m , tel_famille_m, sexe_m, type_cancer FROM `malade`INNER JOIN maladies ON maladies_id_maladi1 = id_maladi where id_m='" + id_m + "'";
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
                String sql = "SELECT id_m, prenom_m, nom_m, adr_m, ville_m, willaya_m, Etat_social, Medecin_m, date_n_m, num_tel_m , tel_famille_m, sexe_m, type_cancer FROM `malade`INNER JOIN maladies ON maladies_id_maladi1 = id_maladi where Etat_social ='" + cEtatSocial.getSelectedItem()
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
                String sql = "SELECT id_m, prenom_m, nom_m, adr_m, ville_m, willaya_m, Etat_social, Medecin_m, date_n_m, num_tel_m , tel_famille_m, sexe_m, type_cancer FROM `malade`INNER JOIN maladies ON maladies_id_maladi1 = id_maladi where Etat_social ='" + cEtatSocial.getSelectedItem()
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
       
    }//GEN-LAST:event_tMaladeMouseClicked

    private void bCancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancel2ActionPerformed
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
            java.util.logging.Logger.getLogger(ConsulterMalade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsulterMalade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsulterMalade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsulterMalade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsulterMalade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel2;
    private javax.swing.JButton bRechercherMalade;
    protected javax.swing.JComboBox cAlphabet;
    protected javax.swing.JComboBox cEtatSocial;
    protected javax.swing.JComboBox cWillaya;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JTable tMalade;
    protected javax.swing.JTextField txtId_p3;
    protected javax.swing.JTextField txtInt;
    // End of variables declaration//GEN-END:variables
}
