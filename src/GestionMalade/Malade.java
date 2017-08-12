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
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.apache.log4j.Logger;

/**
 *
 * @author FAWZI
 */
public class Malade extends javax.swing.JFrame {
    static Logger log = Logger.getLogger(Malade.class.getName());
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rst = null;
    String Type_cancer;
    int id_maladi;
    char id; // id de l'administrateur pour qu'il revoi au bon HOME

    public Malade() {
        initComponents();
        Remplir_Combo_Maladie();
        cMaladie.setSelectedIndex(-1);
        
        bModifier.setEnabled(false);
        txtInt.setEditable(false);
        txtId_p3.setEditable(false);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Cancel();
            }
        });
    }

    private void Cancel() {
        log.trace("Debut Cancel");
        
        log.debug(" id "+id);
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
        
        log.trace("Fin Cancel");
    }

    public Malade(char id) {
        initComponents();
        Remplir_Combo_Maladie();
        cMaladie.setSelectedIndex(-1);
        this.id = id;
        bModifier.setEnabled(false);
        txtInt.setEditable(false);
        txtId_p3.setEditable(false);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Cancel();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtInt = new javax.swing.JTextField();
        txtId_p3 = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        txtPrenom = new javax.swing.JTextField();
        txtAdress = new javax.swing.JTextField();
        txtVille = new javax.swing.JTextField();
        txtNumTelMalade = new javax.swing.JTextField();
        txtNumTelFamille = new javax.swing.JTextField();
        cEtatSocial = new javax.swing.JComboBox();
        txtMedecin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cWillaya = new javax.swing.JComboBox();
        jDateNaiMalade = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        bModifier = new javax.swing.JButton();
        bAjouter = new javax.swing.JButton();
        bRechercher = new javax.swing.JButton();
        bCancel2 = new javax.swing.JButton();
        bReset = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        cMaladie = new javax.swing.JComboBox();
        bPlusMaladie = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        cSexe = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        bNewID = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajouter Malade");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Information du malade"));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ID :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(90, 50, 30, 15);

        txtInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIntActionPerformed(evt);
            }
        });
        jPanel1.add(txtInt);
        txtInt.setBounds(190, 40, 70, 30);

        txtId_p3.setToolTipText("");
        txtId_p3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtId_p3MouseClicked(evt);
            }
        });
        txtId_p3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtId_p3ActionPerformed(evt);
            }
        });
        jPanel1.add(txtId_p3);
        txtId_p3.setBounds(290, 40, 80, 30);

        txtNom.setBorder(null);
        jPanel1.add(txtNom);
        txtNom.setBounds(50, 100, 160, 30);

        txtPrenom.setBorder(null);
        jPanel1.add(txtPrenom);
        txtPrenom.setBounds(260, 100, 160, 30);

        txtAdress.setBorder(null);
        jPanel1.add(txtAdress);
        txtAdress.setBounds(50, 250, 370, 30);

        txtVille.setBorder(null);
        jPanel1.add(txtVille);
        txtVille.setBounds(50, 320, 160, 30);

        txtNumTelMalade.setBorder(null);
        jPanel1.add(txtNumTelMalade);
        txtNumTelMalade.setBounds(50, 400, 160, 30);

        txtNumTelFamille.setBorder(null);
        jPanel1.add(txtNumTelFamille);
        txtNumTelFamille.setBounds(260, 400, 160, 30);

        cEtatSocial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Asurer", "Non Asurer" }));
        cEtatSocial.setSelectedIndex(-1);
        jPanel1.add(cEtatSocial);
        cEtatSocial.setBounds(50, 470, 160, 30);

        txtMedecin.setBorder(null);
        jPanel1.add(txtMedecin);
        txtMedecin.setBounds(260, 470, 160, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Prenom :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(270, 70, 80, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Adress :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 220, 110, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Date de Naissance :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 150, 160, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Ville :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 290, 80, 15);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Willaya :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(260, 290, 70, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("N° Tel (Malade) :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(50, 370, 120, 17);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("N° Tel (Famille) :");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(260, 370, 110, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Etat Sociale :");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(60, 440, 100, 17);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Medecin Traitant :");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(280, 440, 120, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nom :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 70, 70, 15);

        cWillaya.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Adrar", "Chlef", "Laghouat", "Oum El Bouaghi", "Batna", "Béjaïa", "Biskra", "Béchar", "Blida", "Bouira", "Tamanrasset", "Tébessa", "Tlemcen", "Tiaret", "Tizi Ouzou", "Alger", "Djelfa", "Jijel", "Sétif", "Saïda", "Skikda", "Sidi Bel Abbès", "Annaba", "Guelma", "Constantine", "Médéa", "Mostaganem", "M'Sila", "Mascara", "Ouargla", "Oran", "El Bayadh", "Illizi", "Bordj Bou Arreridj", "Boumerdès", "El Tarf", "Tindouf", "Tissemsilt", "El Oued", "Khenchela", "Souk Ahras", "Tipaza", "Mila", "Aïn Defla", "Naàma", "Aïn Témouchent", "Ghardaïa", "Relizane", " " }));
        cWillaya.setSelectedIndex(-1);
        jPanel1.add(cWillaya);
        cWillaya.setBounds(260, 320, 160, 30);

        jDateNaiMalade.setDateFormatString("yyyy-MM-dd");
        jDateNaiMalade.setMaxSelectableDate(new java.util.Date(253370764886000L));
        jPanel1.add(jDateNaiMalade);
        jDateNaiMalade.setBounds(50, 180, 160, 30);
        jPanel1.add(jLabel12);
        jLabel12.setBounds(250, 90, 220, 50);
        jPanel1.add(jLabel13);
        jLabel13.setBounds(40, 90, 210, 50);
        jPanel1.add(jLabel14);
        jLabel14.setBounds(40, 170, 190, 50);
        jPanel1.add(jLabel15);
        jLabel15.setBounds(40, 460, 230, 50);
        jPanel1.add(jLabel16);
        jLabel16.setBounds(40, 240, 420, 50);
        jPanel1.add(jLabel17);
        jLabel17.setBounds(250, 460, 250, 50);
        jPanel1.add(jLabel18);
        jLabel18.setBounds(40, 390, 240, 50);
        jPanel1.add(jLabel19);
        jLabel19.setBounds(250, 390, 190, 50);
        jPanel1.add(jLabel20);
        jLabel20.setBounds(40, 310, 220, 50);
        jPanel1.add(jLabel21);
        jLabel21.setBounds(250, 310, 240, 50);

        bModifier.setText("Modifier");
        bModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModifierActionPerformed(evt);
            }
        });
        jPanel1.add(bModifier);
        bModifier.setBounds(490, 250, 110, 30);

        bAjouter.setText("Ajouter");
        bAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAjouterActionPerformed(evt);
            }
        });
        jPanel1.add(bAjouter);
        bAjouter.setBounds(490, 150, 110, 30);

        bRechercher.setText("Rechercher");
        bRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRechercherActionPerformed(evt);
            }
        });
        jPanel1.add(bRechercher);
        bRechercher.setBounds(490, 200, 110, 30);

        bCancel2.setText("Cancel");
        bCancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancel2ActionPerformed(evt);
            }
        });
        jPanel1.add(bCancel2);
        bCancel2.setBounds(490, 300, 110, 30);

        bReset.setText("Reset");
        bReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResetActionPerformed(evt);
            }
        });
        jPanel1.add(bReset);
        bReset.setBounds(490, 350, 110, 30);

        jLabel23.setText("Maladie :");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(270, 150, 50, 16);

        jPanel1.add(cMaladie);
        cMaladie.setBounds(260, 180, 150, 26);

        bPlusMaladie.setText("+");
        bPlusMaladie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPlusMaladieActionPerformed(evt);
            }
        });
        jPanel1.add(bPlusMaladie);
        bPlusMaladie.setBounds(420, 180, 40, 32);

        jLabel24.setText("Sexe");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(500, 440, 29, 16);

        cSexe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Homme", "Femme" }));
        cSexe.setSelectedIndex(-1);
        jPanel1.add(cSexe);
        cSexe.setBounds(490, 470, 110, 26);

        jLabel25.setText("/");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(270, 36, 30, 30);

        bNewID.setText("New ID");
        bNewID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewIDActionPerformed(evt);
            }
        });
        jPanel1.add(bNewID);
        bNewID.setBounds(490, 100, 110, 32);
        jPanel1.add(jLabel22);
        jLabel22.setBounds(-10, -10, 640, 570);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 641, 516);

        setSize(new java.awt.Dimension(645, 570));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAjouterActionPerformed
 log.trace("Debut");
        boolean v = true;
//        Condition
        if (txtAdress.getText().equals("")) {
            txtAdress.setBackground(Color.red);
            v = false;
//            JOptionPane.showMessageDialog(null, "Enter Adress");
        }
//        if (cAlphabet.getSelectedIndex() == -1) {
//            cAlphabet.setBackground(Color.red);
//            v = false;
////            JOptionPane.showMessageDialog(null, "Enter Alphabet");
//        }
        if (txtId_p3.getText().equals("")) {
            txtId_p3.setBackground(Color.red);
            v = false;
//            JOptionPane.showMessageDialog(null, "Enter id p3");
        }
        if (txtInt.getText().equals("")) {
            txtInt.setBackground(Color.red);
            v = false;
//            JOptionPane.showMessageDialog(null, "Enter Le numero du docier");
        }
        
        if (txtNom.getText().equals("")) {
            txtNom.setBackground(Color.red);
            v = false;
//            JOptionPane.showMessageDialog(null, "Enter Nom");
        }
        
        if (txtNumTelMalade.getText().equals("")) {
            txtNumTelMalade.setBackground(Color.red);
            v = false;
//            JOptionPane.showMessageDialog(null, "Enter Num Tel du Malade");
        }
        if (txtPrenom.getText().equals("")) {
            txtPrenom.setBackground(Color.red);
            v = false;
//            JOptionPane.showMessageDialog(null, "Enter Prenom");
        }
        if (txtVille.getText().equals("")) {
            txtVille.setBackground(Color.red);
            v = false;
//            JOptionPane.showMessageDialog(null, "Enter Ville");
        }
        if (((JTextField) jDateNaiMalade.getDateEditor().getUiComponent()).getText().equals("")) {
            jDateNaiMalade.setBackground(Color.red);
            v = false;
//            JOptionPane.showMessageDialog(null, "Enter Ville");
        }
//        if (cAlphabet.getSelectedIndex() == -1) {
//            cAlphabet.setBackground(Color.red);
//            v = false;
////            JOptionPane.showMessageDialog(null, "Enter Alphabet");
//        }
       
        if (cWillaya.getSelectedIndex() == -1) {
            cWillaya.setBackground(Color.red);
            v = false;
//            JOptionPane.showMessageDialog(null, "Enter Willaya");
        }
        if (cMaladie.getSelectedIndex() == -1) {
            cMaladie.setBackground(Color.red);
            v = false;
//            JOptionPane.showMessageDialog(null, "Enter Willaya");
        }
        if (cSexe.getSelectedIndex() == -1) {
            cSexe.setBackground(Color.red);
            v = false;
//            JOptionPane.showMessageDialog(null, "Enter Willaya");
        }

        if (v == false) {
            JOptionPane.showMessageDialog(null, "un champ est vide");
        } else {
            try {
               
                Rechercher_id_Maladie();
                DecimalFormat myFormatter = new DecimalFormat("0000");
                String output = myFormatter.format(Integer.parseInt(txtInt.getText()));
                String output2 = myFormatter.format(Integer.parseInt(txtId_p3.getText()));
                String c = "/";
                //2eme requete pour ajouter les donné à la table
                String sql2 = "insert into malade (id_m, prenom_m, nom_m, adr_m,  ville_m,willaya_m , num_tel_m"
                        + ", tel_famille_m, Etat_social, Medecin_m, maladies_id_maladi1, date_n_m,sexe_m) values ('"
                        + output  + c + txtId_p3.getText()  + "','" + txtPrenom.getText() 
                        + "','" + txtNom.getText() + "','" + txtAdress.getText() + "','" + txtVille.getText()
                        + "','" + cWillaya.getSelectedItem() + "','" + txtNumTelMalade.getText()
                        + "','" + txtNumTelFamille.getText() + "','" + cEtatSocial.getSelectedItem() + "','"
                        + txtMedecin.getText() + "','" + id_maladi + "','"
                        + ((JTextField) jDateNaiMalade.getDateEditor().getUiComponent()).getText()
                        + "','" + cSexe.getSelectedItem() + "')";

                pst = con.prepareStatement(sql2);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Ok");
                reset();

            } catch (NumberFormatException | SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            }
        }
         log.trace("Fin");
    }//GEN-LAST:event_bAjouterActionPerformed

    private void bRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechercherActionPerformed
         log.trace("Debut");
        this.dispose();
        this.setVisible(false);
        System.out.println("  kwwwwwwwd" + id);

        RechercherMalade s = new RechercherMalade(id);
        s.setVisible(true);
        System.out.println("rechercher malade function");
    }//GEN-LAST:event_bRechercherActionPerformed

    private void bCancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancel2ActionPerformed
        System.out.println(" idiidii    <<<<< " + id);
        Cancel();
//        RetoureCancel();
 log.trace("Fin");
    }//GEN-LAST:event_bCancel2ActionPerformed

    private void bResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResetActionPerformed
        reset();
    }//GEN-LAST:event_bResetActionPerformed

    private void bModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModifierActionPerformed
        //        Condition
         log.trace("Debut");
        int val = JOptionPane.showConfirmDialog(null, "Voulez vous modifier ?");
        if (txtAdress.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Adress");
        } else if (txtId_p3.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter id p3");
        } else if (txtInt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Le numero du docier");
        } else if (txtNom.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Nom");
        } else if (txtNumTelMalade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Num Tel du Malade");
        } else if (txtPrenom.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Prenom");
        } else if (txtVille.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Ville");
        } else if (((JTextField) jDateNaiMalade.getDateEditor().getUiComponent()).getText().equals("")) {
            JOptionPane.showMessageDialog(null, "enter la date de naissance");
        } else if (cWillaya.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Enter Willaya");
        } else {
            if (val == 0) {
                try {
                    Rechercher_id_Maladie();
                    con = Connect.connect();
                    DecimalFormat myFormatter = new DecimalFormat("0000");
                    String output = myFormatter.format(Integer.parseInt(txtInt.getText()));
                    
                    String c = "/";
                    System.out.println("prenom_m='" + txtPrenom.getText()
                            + "',nom_m='" + txtNom.getText() + "',adr_m='" + txtAdress.getText()
                            + "',ville_m='" + txtVille.getText() + "',num_tel_m='" + txtNumTelMalade.getText()
                            + "',tel_famille_m='" + txtNumTelFamille.getText() + "',Etat_social='" + cEtatSocial.getSelectedItem()
                            + "',Medecin_m='" + txtMedecin.getText() + "',maladies_id_maladi1='" + id_maladi
                            + "',date_n_m='" + ((JTextField) jDateNaiMalade.getDateEditor().getUiComponent()).getText()
                            + "',sexe_m='" + cSexe.getSelectedItem()
                            + "'id_m='" + output + c + txtId_p3.getText() + "'");
                    
                    
                    String sql = "update malade set prenom_m='" + txtPrenom.getText()
                            + "',nom_m='" + txtNom.getText() + "',adr_m='" + txtAdress.getText()
                            + "',ville_m='" + txtVille.getText() + "',num_tel_m='" + txtNumTelMalade.getText()
                            + "',tel_famille_m='" + txtNumTelFamille.getText() + "',Etat_social='" + cEtatSocial.getSelectedItem()
                            + "',Medecin_m='" + txtMedecin.getText() + "',maladies_id_maladi1='" + id_maladi
                            + "',date_n_m='" + ((JTextField) jDateNaiMalade.getDateEditor().getUiComponent()).getText()
                            + "',sexe_m='" + cSexe.getSelectedItem()
                            + "' WHERE id_m='" + output + c + txtId_p3.getText() + "'";

                    System.out.println("prenom_m='" + txtPrenom.getText()
                            + "',nom_m='" + txtNom.getText() + "',adr_m='" + txtAdress.getText()
                            + "',ville_m='" + txtVille.getText() + "',num_tel_m='" + txtNumTelMalade.getText()
                            + "',tel_famille_m='" + txtNumTelFamille.getText() + "',Etat_social='" + cEtatSocial.getSelectedItem()
                            + "',Medecin_m='" + txtMedecin.getText() + "',maladies_id_maladi1='" + id_maladi
                            + "',date_n_m='" + ((JTextField) jDateNaiMalade.getDateEditor().getUiComponent()).getText()
                            + "',sexe_m='" + cSexe.getSelectedItem()
                            + "'id_m='" + output + c + txtId_p3.getText() + "'");
                    pst = con.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Update Successfully");
                    reset();

                    // rétablire l'interface pour un ajout éventuelle
                    
                    txtId_p3.setEditable(true);
                    txtInt.setEditable(false);
                    bAjouter.setEnabled(true);
                    bModifier.setEnabled(false);
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    log.error(e);
                }
            }
        }
         log.trace("Fin");
    }//GEN-LAST:event_bModifierActionPerformed

    private void txtIntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIntActionPerformed

    private void txtId_p3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId_p3ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtId_p3ActionPerformed

    private void txtId_p3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtId_p3MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_txtId_p3MouseClicked

    private void RetoureCancel() {

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
    private void bPlusMaladieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPlusMaladieActionPerformed
 log.trace("Debut");
        this.setVisible(false);
        Maladies s = new Maladies();
        s.id = id;
        s.setVisible(true);
 log.trace("Fin");
    }//GEN-LAST:event_bPlusMaladieActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
    }//GEN-LAST:event_formWindowOpened

    private void bNewIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewIDActionPerformed
        Verification_de_date();
        VerifierNbrMalade();
    }//GEN-LAST:event_bNewIDActionPerformed

    private  void VerifierNbrMalade() {
        // Verifie le nbr de malade dans la base de donnée et Ajoute 1
        
        log.trace("Debut");
        con = Connect.connect();
                String sql = "SELECT COUNT(*) count FROM malade ";
                
                try {
                    pst = con.prepareStatement(sql);
                    
                    ResultSet rec2 = pst.executeQuery(sql);
                    
                    rec2.next();
                    int nb = rec2.getInt("count");
                    String k = Integer.toString(nb + 1);
                    txtInt.setText(k);
                    log.debug("le Nbr de malde = '" + k + "'");
                    txtInt.setText(k);

                   
                } catch (SQLException e) {
                    System.err.println(e);
                    log.error(e);
                }
        log.trace("Fin");
    }
    
    private void Verification_de_date(){
        // Verifie si la date
        DateFormat dateFormat = new SimpleDateFormat("yy");
        Date date = new Date();
        log.debug("la date (Date) = " + dateFormat.format(date)); 
        
        String reportDate = dateFormat.format(date);
        log.debug("la date (String) = " + reportDate); 
        
        txtId_p3.setText(reportDate);

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
            java.util.logging.Logger.getLogger(Malade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Malade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Malade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Malade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Malade().setVisible(true);
            }
        });
    }

    protected void reset() {
        
        txtId_p3.setText("");
        txtInt.setText("");
        txtNom.setText("");
        txtPrenom.setText("");
        jDateNaiMalade.setCalendar(null);
        cMaladie.setSelectedIndex(-1);
        txtAdress.setText("");
        txtVille.setText("");
        cWillaya.setSelectedIndex(-1);
        txtNumTelFamille.setText("");
        txtNumTelMalade.setText("");
        cEtatSocial.setSelectedIndex(-1);
        txtMedecin.setText("");
        cSexe.setSelectedIndex(-1);
        
        bModifier.setEnabled(false);
        bNewID.setEnabled(true);
        bAjouter.setEnabled(true);
    }

    private void Rechercher_id_Maladie() {
         log.trace("Debut");
        String sql = "select 	id_maladi from   maladies where Type_cancer ='" + cMaladie.getSelectedItem() + "'";
        con = Connect.connect();

        try {
            pst = con.prepareStatement(sql);
            ResultSet rec2 = pst.executeQuery(sql);
            rec2.next();
            id_maladi = Integer.parseInt(rec2.getString("id_maladi"));

        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            log.error("Rechercher_id_Maladie : ", e);
        }
 log.trace("Fin");
    }

    @SuppressWarnings("unchecked")
    private void Remplir_Combo_Maladie() {
         log.trace("Debut");
        con = Connect.connect();
        String requete = "select * from maladies";
        try {
            pst = con.prepareStatement(requete);
            rst = pst.executeQuery();
            while (rst.next()) {
                Type_cancer = rst.getString("Type_cancer");
                cMaladie.addItem(Type_cancer);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            log.error("Remplir_Combo_Maladie : ", e);
        }
         log.trace("Fin");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton bAjouter;
    private javax.swing.JButton bCancel2;
    protected javax.swing.JButton bModifier;
    protected javax.swing.JButton bNewID;
    private javax.swing.JButton bPlusMaladie;
    private javax.swing.JButton bRechercher;
    private javax.swing.JButton bReset;
    protected javax.swing.JComboBox cEtatSocial;
    protected javax.swing.JComboBox cMaladie;
    protected javax.swing.JComboBox cSexe;
    protected javax.swing.JComboBox cWillaya;
    protected com.toedter.calendar.JDateChooser jDateNaiMalade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    protected javax.swing.JTextField txtAdress;
    protected javax.swing.JTextField txtId_p3;
    protected javax.swing.JTextField txtInt;
    protected javax.swing.JTextField txtMedecin;
    protected javax.swing.JTextField txtNom;
    protected javax.swing.JTextField txtNumTelFamille;
    protected javax.swing.JTextField txtNumTelMalade;
    protected javax.swing.JTextField txtPrenom;
    protected javax.swing.JTextField txtVille;
    // End of variables declaration//GEN-END:variables
}
