/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionBenevole;

import gestionbadr.Connect;
import gestionbadr.HomeAdministrateur;
import gestionbadr.HomeDirecteur;
import gestionbadr.HomeSecretaire;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.apache.log4j.Logger;

/**
 *
 * @author FAWZI
 */
public class Benevole extends javax.swing.JFrame {

    static Logger log = Logger.getLogger(Benevole.class.getName());
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rst = null;
    Statement st = null;
    ResultSet rs = null;
    protected int id_b;
    char id; // id de l'administrateur pour qu'il revoi au bon HOME

    public Benevole() {
        initComponents();
        bModifier.setEnabled(false);
        log.info("Interface Benevole");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                RetoureCancel();
            }
        });
    }

    public Benevole(char id) {
       
        log.trace("Constructeure Surcharger de Benevole ");
         initComponents();
        bModifier.setEnabled(false);
        this.id = id;
        log.debug("Id Admin= " + id);
    }

    private void RetoureCancel() {
//        log.trace("Constructeure Surcharger de Benevole ");
//        log.debug("Id Admin= " + id);

        this.dispose();
        this.setVisible(false);
        System.out.println(id);
        if (id == 'A') {
            this.setVisible(false);

            HomeAdministrateur h = new HomeAdministrateur(id);
            h.setVisible(true);
            System.out.println("1");
        } else if (id == 'S') {
            this.setVisible(false);

            HomeSecretaire h = new HomeSecretaire(id);
            h.setVisible(true);
            System.out.println("2");
        } else if (id == 'D') {
            this.setVisible(false);

            HomeDirecteur h = new HomeDirecteur(id);
            h.setVisible(true);
            System.out.println("3");
        }
        System.out.println("4");
    }

    protected void reset() {
        txtEmail.setText("");
        txtFonction.setText("");
        txtNumTelB.setText("");
        txtNomb.setText("");
        txtPrenom.setText("");
        cSexeB.setSelectedIndex(-1);
        cWillayaBenevole.setSelectedIndex(-1);
        jDateNaissance.setCalendar(null);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtNumTelB = new javax.swing.JTextField();
        txtNomb = new javax.swing.JTextField();
        txtFonction = new javax.swing.JTextField();
        txtPrenom = new javax.swing.JTextField();
        jDateNaissance = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        cSexeB = new javax.swing.JComboBox();
        cWillayaBenevole = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        bSave = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        bModifier = new javax.swing.JButton();
        bRechercher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajouter Benevole");
        setResizable(false);

        jLabel1.setText("Nom :");

        jLabel2.setText("Prenom :");

        jLabel3.setText("Date de Naissance :");

        jLabel4.setText("Num de tel :");

        jLabel5.setText("Email :");

        jLabel6.setText("Fonction :");

        txtNumTelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumTelBActionPerformed(evt);
            }
        });

        txtNomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombActionPerformed(evt);
            }
        });

        txtFonction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFonctionActionPerformed(evt);
            }
        });

        txtPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrenomActionPerformed(evt);
            }
        });

        jDateNaissance.setDateFormatString("yyyy-MM-dd");
        jDateNaissance.setMaxSelectableDate(new java.util.Date(253370764886000L));

        jLabel7.setText("Sexe :  ");

        cSexeB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Homme", "Femme" }));
        cSexeB.setSelectedIndex(-1);

        cWillayaBenevole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Adrar", "Chlef", "Laghouat", "Oum El Bouaghi", "Batna", "Béjaïa", "Biskra", "Béchar", "Blida", "Bouira", "Tamanrasset", "Tébessa", "Tlemcen", "Tiaret", "Tizi Ouzou", "Alger", "Djelfa", "Jijel", "Sétif", "Saïda", "Skikda", "Sidi Bel Abbès", "Annaba", "Guelma", "Constantine", "Médéa", "Mostaganem", "M'Sila", "Mascara", "Ouargla", "Oran", "El Bayadh", "Illizi", "Bordj Bou Arreridj", "Boumerdès", "El Tarf", "Tindouf", "Tissemsilt", "El Oued", "Khenchela", "Souk Ahras", "Tipaza", "Mila", "Aïn Defla", "Naàma", "Aïn Témouchent", "Ghardaïa", "Relizane", " " }));
        cWillayaBenevole.setSelectedIndex(-1);

        jLabel8.setText("Willaya :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7))
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addGap(149, 149, 149)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNumTelB, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFonction, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(15, 15, 15))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDateNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cSexeB, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap()))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cWillayaBenevole, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPrenom)
                                .addComponent(txtNomb, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jDateNaissance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNumTelB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFonction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(cSexeB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cWillayaBenevole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        bSave.setText("Save");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        bModifier.setText("Modifier");
        bModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModifierActionPerformed(evt);
            }
        });

        bRechercher.setText("Rechercher");
        bRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRechercherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bModifier, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                    .addComponent(bRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(bSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bModifier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(bRechercher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCancel)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(721, 533));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumTelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumTelBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumTelBActionPerformed

    private void txtNombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombActionPerformed

    private void txtFonctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFonctionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFonctionActionPerformed

    private void txtPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrenomActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed

        if (txtNomb.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "enter le Nom");

        } else if (txtPrenom.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "enter le Prenom");

        } else if (txtNumTelB.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "enter le numero de telephone");

        } else if (cSexeB.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Enter le Sexe");
        } else if (cWillayaBenevole.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Enter le Willaya");
        } else if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "enter l'email");

        } else if (txtFonction.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "enter la fonction");

        } else if (((JTextField) jDateNaissance.getDateEditor().getUiComponent()).getText().equals("")) {
            JOptionPane.showMessageDialog(null, "enter la date de naissance");

        } else {

            con = Connect.connect();
            try {

                String sql2 = "insert into benevole (Nom_b, prenom_b, num_tel_b, email_b, fonction, date_n_b"
                        + ", sexe_b, willaya_b ) values('"
                        + txtNomb.getText() + "','" + txtPrenom.getText() + "','" + txtNumTelB.getText() + "','"
                        + txtEmail.getText() + "','" + txtFonction.getText() + "','"
                        + ((JTextField) jDateNaissance.getDateEditor().getUiComponent()).getText()
                        + "','" + cSexeB.getSelectedItem() + "','" + cWillayaBenevole.getSelectedItem()
                        + "')";
                pst = con.prepareStatement(sql2);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Successfully registred");
                //   log.info("Successfully registred");
                reset();

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error("Erreur bSaveActionPerformed : ", e);
            }

        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        RetoureCancel();
    }//GEN-LAST:event_bCancelActionPerformed

    private void bModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModifierActionPerformed
        //        Condition
        int val = JOptionPane.showConfirmDialog(null, "Voulez vous modifier ?");

        if (txtNomb.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "enter le Nom");

        } else if (txtPrenom.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "enter le Prenom");

        } else if (txtNumTelB.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "enter le numero de telephone");

        } else if (cSexeB.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Enter le Sexe");
        } else if (cWillayaBenevole.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Enter le willaya");
        } else if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "enter l'email");

        } else if (txtFonction.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "enter la fonction");

        } else {
            if (val == 0) {
                try {
                    con = Connect.connect();
                    String sql = "update benevole set Nom_b='" + txtNomb.getText()
                            + "',prenom_b='" + txtPrenom.getText()
                            + "',num_tel_b='" + txtNumTelB.getText() + "',email_b='" + txtEmail.getText()
                            + "',fonction='" + txtFonction.getText() + "', sexe_b ='" + cSexeB.getSelectedItem()
                            + "', willaya_b	='" + cWillayaBenevole.getSelectedItem()
                            + "' WHERE id_b='" + id_b + "'";

                    pst = con.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Update Successfully");

                    reset();
                    bModifier.setEnabled(false);
                    bSave.setEnabled(true);

                } catch (HeadlessException | SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    log.error("Erreur bModifierActionPerformed : ", e);
                }
            }
        }

    }//GEN-LAST:event_bModifierActionPerformed

    private void bRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechercherActionPerformed
        log.trace("Open bRechercherActionPerformed ");

        this.setVisible(false);
        RechercherBenevole s = new RechercherBenevole();
        s.id = id;
        log.debug("Id Envoyer a Rechercher" + id);
        s.setVisible(true);
        log.trace("Close bRechercherActionPerformed");
//        DefaultTableModel md = new DefaultTableModel();
//        md.setColumnIdentifiers(new String[]{"numero", "nom", "prenom"});
//        try {
//            con = Connect.connect();
//            st = con.createStatement();
//            rs = st.executeQuery("select * from employer ");
//            while (rs.next()) {
//                md.addRow(new Object[]{rs.getObject("employerId"), rs.getObject("Prenom_e"), rs.getObject("Nom_e")});
//            }
//            s.tBenevole.setModel(md);
//
//            s.setVisible(true);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
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
            java.util.logging.Logger.getLogger(Benevole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Benevole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Benevole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Benevole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Benevole().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    protected javax.swing.JButton bModifier;
    private javax.swing.JButton bRechercher;
    protected javax.swing.JButton bSave;
    protected javax.swing.JComboBox cSexeB;
    protected javax.swing.JComboBox cWillayaBenevole;
    protected com.toedter.calendar.JDateChooser jDateNaissance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    protected javax.swing.JTextField txtEmail;
    protected javax.swing.JTextField txtFonction;
    protected javax.swing.JTextField txtNomb;
    protected javax.swing.JTextField txtNumTelB;
    protected javax.swing.JTextField txtPrenom;
    // End of variables declaration//GEN-END:variables
}
