/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbadr;

import GestionBenevole.Benevole;
import GestionBenevole.ConsulterBenevole;
import GestionLoggin.ConsulterUser;
import GestionLoggin.Employer;
import GestionMalade.Malade;
import GestionMalade.RechercherMalade;
import gestionArticle.AjouterArticle;
import GestionDonnation.Beneficie;
import GestionDonnation.ConsulterHistoriqueDonnation;
import GestionMalade.ConsulterMalade;
import GestionRDV.RDV;
import gestionArticle.ConsulterArticle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FAWZI
 */
public class HomeAdministrateur extends javax.swing.JFrame {

    ResultSet rs = null;
    Connection con = null;
    Statement st = null;
char id;
    public HomeAdministrateur() {
        initComponents();
        bConsulterArticle.setEnabled(false);
        bConsulterHistoriqueDonnation1.setEnabled(false);
        bAjouterArticle.setEnabled(false);
        bAjouterDonnation1.setEnabled(false);
    }
     public HomeAdministrateur(char id) {
        initComponents();
        this.id=id;
        bConsulterArticle.setEnabled(false);
        bConsulterHistoriqueDonnation1.setEnabled(false);
        bAjouterArticle.setEnabled(false);
        bAjouterDonnation1.setEnabled(false);
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
        jLabel2 = new javax.swing.JLabel();
        bAjouterMalade = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        bConsulterMalade = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        bAjouterArticle = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bConsulterArticle = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        bAjouterRDV = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        bConsulterRDV = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        bAjouterMalade1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        bConsulterMalade1 = new javax.swing.JButton();
        bParametre = new javax.swing.JButton();
        bDeconnecter = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        bAjouterDonnation1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        bConsulterHistoriqueDonnation1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion des Malades"));
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.setLayout(null);

        jLabel2.setText("Ajouter");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(60, 40, 100, 16);

        bAjouterMalade.setBorder(null);
        bAjouterMalade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAjouterMaladeActionPerformed(evt);
            }
        });
        jPanel2.add(bAjouterMalade);
        bAjouterMalade.setBounds(20, 30, 160, 40);

        jLabel3.setText("Consulter");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(60, 90, 90, 16);

        bConsulterMalade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsulterMaladeActionPerformed(evt);
            }
        });
        jPanel2.add(bConsulterMalade);
        bConsulterMalade.setBounds(20, 80, 160, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 120, 190, 150);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion des Articles"));
        jPanel3.setLayout(null);

        jLabel4.setText("Ajouter");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(70, 50, 41, 16);

        bAjouterArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAjouterArticleActionPerformed(evt);
            }
        });
        jPanel3.add(bAjouterArticle);
        bAjouterArticle.setBounds(16, 34, 160, 40);

        jLabel5.setText("Consulter");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(70, 90, 60, 16);

        bConsulterArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsulterArticleActionPerformed(evt);
            }
        });
        jPanel3.add(bConsulterArticle);
        bConsulterArticle.setBounds(16, 83, 160, 39);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(280, 120, 190, 150);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion des RDV"));
        jPanel4.setLayout(null);

        jLabel10.setText("Ajouter");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(60, 40, 41, 16);

        bAjouterRDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAjouterRDVActionPerformed(evt);
            }
        });
        jPanel4.add(bAjouterRDV);
        bAjouterRDV.setBounds(18, 27, 160, 44);

        jLabel11.setText("Consulter");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(60, 90, 55, 16);

        bConsulterRDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsulterRDVActionPerformed(evt);
            }
        });
        jPanel4.add(bConsulterRDV);
        bConsulterRDV.setBounds(16, 82, 160, 40);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(520, 300, 190, 150);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion des Benevole"));
        jPanel6.setLayout(null);

        jLabel6.setText("Ajouter");
        jPanel6.add(jLabel6);
        jLabel6.setBounds(70, 50, 41, 16);

        bAjouterMalade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAjouterMalade1ActionPerformed(evt);
            }
        });
        jPanel6.add(bAjouterMalade1);
        bAjouterMalade1.setBounds(16, 36, 160, 40);

        jLabel7.setText("Consulter");
        jPanel6.add(jLabel7);
        jLabel7.setBounds(60, 100, 70, 16);

        bConsulterMalade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsulterMalade1ActionPerformed(evt);
            }
        });
        jPanel6.add(bConsulterMalade1);
        bConsulterMalade1.setBounds(16, 86, 160, 40);

        jPanel1.add(jPanel6);
        jPanel6.setBounds(520, 120, 190, 150);

        bParametre.setText("Parametre");
        bParametre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bParametreActionPerformed(evt);
            }
        });
        jPanel1.add(bParametre);
        bParametre.setBounds(450, 30, 110, 32);

        bDeconnecter.setText("Deconnecter");
        bDeconnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeconnecterActionPerformed(evt);
            }
        });
        jPanel1.add(bDeconnecter);
        bDeconnecter.setBounds(570, 30, 130, 32);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion des donnations"));
        jPanel7.setLayout(null);

        jLabel8.setText("Ajouter");
        jPanel7.add(jLabel8);
        jLabel8.setBounds(60, 40, 41, 16);

        bAjouterDonnation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAjouterDonnation1ActionPerformed(evt);
            }
        });
        jPanel7.add(bAjouterDonnation1);
        bAjouterDonnation1.setBounds(18, 27, 160, 44);

        jLabel9.setText("Consulter");
        jPanel7.add(jLabel9);
        jLabel9.setBounds(70, 90, 70, 16);

        bConsulterHistoriqueDonnation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsulterHistoriqueDonnation1ActionPerformed(evt);
            }
        });
        jPanel7.add(bConsulterHistoriqueDonnation1);
        bConsulterHistoriqueDonnation1.setBounds(16, 82, 160, 40);
        jPanel7.add(jLabel1);
        jLabel1.setBounds(-290, -300, 740, 560);

        jPanel1.add(jPanel7);
        jPanel7.setBounds(280, 300, 190, 150);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(748, 597));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bAjouterRDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAjouterRDVActionPerformed

        this.setVisible(false);
        RDV s = new RDV(id);
        s.setVisible(true);

    }//GEN-LAST:event_bAjouterRDVActionPerformed

    private void bAjouterArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAjouterArticleActionPerformed
        this.setVisible(false);
        AjouterArticle s = new AjouterArticle(id);
        s.setVisible(true);
    }//GEN-LAST:event_bAjouterArticleActionPerformed

    private void bConsulterArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsulterArticleActionPerformed
         this.setVisible(false);
        ConsulterArticle s = new ConsulterArticle(id);
        DefaultTableModel md = new DefaultTableModel();
        md.setColumnIdentifiers(new String[]{"Nom article", "Quantite", "Type"});
        try {
            con = Connect.connect();
            st = con.createStatement();
            rs = st.executeQuery("select Nom_a,Quantite_a,Type_art from article ");
            while (rs.next()) {
                md.addRow(new Object[]{rs.getObject("Nom_a"), rs.getObject("Quantite_a"), rs.getObject("Type_art")});
            }
            s.tArticleHistorique.setModel(md);

            s.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_bConsulterArticleActionPerformed

    private void bAjouterMalade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAjouterMalade1ActionPerformed
        this.setVisible(false);
        Benevole s = new Benevole(id);
        s.setVisible(true);
        
    }//GEN-LAST:event_bAjouterMalade1ActionPerformed

    private void bConsulterMalade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsulterMalade1ActionPerformed
        this.setVisible(false);
        ConsulterBenevole s = new ConsulterBenevole(id);
        s.setVisible(true);
    }//GEN-LAST:event_bConsulterMalade1ActionPerformed

    private void bConsulterRDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsulterRDVActionPerformed
        this.setVisible(false);
        ConsulterHistoriqueDonnation s = new ConsulterHistoriqueDonnation(id);
        s.setVisible(true);
    }//GEN-LAST:event_bConsulterRDVActionPerformed

    private void bConsulterMaladeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsulterMaladeActionPerformed
        this.setVisible(false);
        ConsulterMalade h = new ConsulterMalade(id);
        h.setVisible(true);
    }//GEN-LAST:event_bConsulterMaladeActionPerformed

    private void bAjouterMaladeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAjouterMaladeActionPerformed
        this.setVisible(false);
        Malade h = new Malade(id);
        h.setVisible(true);
        
    }//GEN-LAST:event_bAjouterMaladeActionPerformed

    private void bDeconnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeconnecterActionPerformed
        this.setVisible(false);
        Login h = new Login();
        h.setVisible(true);
    }//GEN-LAST:event_bDeconnecterActionPerformed

    private void bParametreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bParametreActionPerformed
        this.setVisible(false);
        Parametre h = new Parametre();
        h.setVisible(true);
    }//GEN-LAST:event_bParametreActionPerformed

    private void bAjouterDonnation1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAjouterDonnation1ActionPerformed
        
        this.setVisible(false);
        Beneficie s = new Beneficie(id);
        s.setVisible(true);
    }//GEN-LAST:event_bAjouterDonnation1ActionPerformed

    private void bConsulterHistoriqueDonnation1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsulterHistoriqueDonnation1ActionPerformed
        this.setVisible(false);
        ConsulterHistoriqueDonnation s = new ConsulterHistoriqueDonnation(id);
        s.setVisible(true);
    }//GEN-LAST:event_bConsulterHistoriqueDonnation1ActionPerformed

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
            java.util.logging.Logger.getLogger(HomeAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeAdministrateur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAjouterArticle;
    private javax.swing.JButton bAjouterDonnation1;
    private javax.swing.JButton bAjouterMalade;
    private javax.swing.JButton bAjouterMalade1;
    private javax.swing.JButton bAjouterRDV;
    private javax.swing.JButton bConsulterArticle;
    private javax.swing.JButton bConsulterHistoriqueDonnation1;
    private javax.swing.JButton bConsulterMalade;
    private javax.swing.JButton bConsulterMalade1;
    private javax.swing.JButton bConsulterRDV;
    private javax.swing.JButton bDeconnecter;
    private javax.swing.JButton bParametre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}
