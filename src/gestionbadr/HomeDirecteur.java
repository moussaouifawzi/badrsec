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
public class HomeDirecteur extends javax.swing.JFrame {

    ResultSet rs = null;
    Connection con = null;
    Statement st = null;
    char id;

    public HomeDirecteur() {
        initComponents();
        bConsulterArticle.setEnabled(false);
        bConsulterHistoriqueDonnation.setEnabled(false);
        bAjouterArticle.setEnabled(false);
        bAjouterDonnation.setEnabled(false);
    }
     public HomeDirecteur(char id) {
         this.id=id;
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bAjouterArticle = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        bConsulterArticle = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        bAjouterDonnation = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bConsulterHistoriqueDonnation = new javax.swing.JButton();
        bDeconnecter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");

        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion des Articles"));
        jPanel3.setLayout(null);

        jLabel2.setText("Ajouter");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(60, 50, 41, 16);

        bAjouterArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAjouterArticleActionPerformed(evt);
            }
        });
        jPanel3.add(bAjouterArticle);
        bAjouterArticle.setBounds(16, 34, 160, 40);

        jLabel3.setText("Consulter");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(60, 90, 70, 16);

        bConsulterArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsulterArticleActionPerformed(evt);
            }
        });
        jPanel3.add(bConsulterArticle);
        bConsulterArticle.setBounds(16, 83, 160, 39);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(120, 200, 190, 150);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestion des donnations"));
        jPanel4.setLayout(null);

        jLabel4.setText("Ajouter");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(60, 40, 41, 16);

        bAjouterDonnation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAjouterDonnationActionPerformed(evt);
            }
        });
        jPanel4.add(bAjouterDonnation);
        bAjouterDonnation.setBounds(18, 27, 160, 44);

        jLabel5.setText("Consulter");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(60, 100, 55, 16);

        bConsulterHistoriqueDonnation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsulterHistoriqueDonnationActionPerformed(evt);
            }
        });
        jPanel4.add(bConsulterHistoriqueDonnation);
        bConsulterHistoriqueDonnation.setBounds(16, 82, 160, 40);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(410, 200, 190, 150);

        bDeconnecter.setText("Deconnecter");
        bDeconnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeconnecterActionPerformed(evt);
            }
        });
        jPanel1.add(bDeconnecter);
        bDeconnecter.setBounds(500, 30, 130, 32);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 740, 560);

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

    private void bAjouterDonnationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAjouterDonnationActionPerformed

        this.setVisible(false);
        Beneficie s = new Beneficie(id);
        s.setVisible(true);

    }//GEN-LAST:event_bAjouterDonnationActionPerformed

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

    private void bConsulterHistoriqueDonnationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsulterHistoriqueDonnationActionPerformed
        this.setVisible(false);
        ConsulterHistoriqueDonnation s = new ConsulterHistoriqueDonnation(id);
        s.setVisible(true);
    }//GEN-LAST:event_bConsulterHistoriqueDonnationActionPerformed

    private void bDeconnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeconnecterActionPerformed
        this.setVisible(false);
        Login h = new Login();
        h.setVisible(true);
    }//GEN-LAST:event_bDeconnecterActionPerformed

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
            java.util.logging.Logger.getLogger(HomeDirecteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeDirecteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeDirecteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeDirecteur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeDirecteur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAjouterArticle;
    private javax.swing.JButton bAjouterDonnation;
    private javax.swing.JButton bConsulterArticle;
    private javax.swing.JButton bConsulterHistoriqueDonnation;
    private javax.swing.JButton bDeconnecter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
