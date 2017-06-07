/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbadr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author FAWZI
 */
public class Login extends javax.swing.JFrame {

    static Logger log = Logger.getLogger(Login.class.getName());
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rst = null;
    public String id = "";

    /**
     * Creates new form Login
     */
    public Login() {
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

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        bOk = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Authentification");
        setResizable(false);

        jPanel1.setLayout(null);

        txtUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUserName.setBorder(null);
        txtUserName.setCaretColor(new java.awt.Color(51, 51, 255));
        jPanel1.add(txtUserName);
        txtUserName.setBounds(250, 100, 190, 40);

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassword);
        txtPassword.setBounds(250, 160, 190, 40);

        bOk.setBackground(new java.awt.Color(42, 135, 227));
        bOk.setText("Ok");
        bOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOkActionPerformed(evt);
            }
        });
        jPanel1.add(bOk);
        bOk.setBounds(220, 220, 100, 40);

        bCancel.setBackground(new java.awt.Color(42, 135, 227));
        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });
        jPanel1.add(bCancel);
        bCancel.setBounds(330, 220, 100, 40);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(460, 40, 0, 230);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(210, 150, 240, 40);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(210, 100, 230, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(700, 379));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        // TODO add your handling code here:

        System.exit(0);
    }//GEN-LAST:event_bCancelActionPerformed

    private void bOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOkActionPerformed
        //confirmation si le user name et password ne sont pas vide
        System.out.println(" kwd");
        if (txtUserName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter UserName");
        } else if (txtPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Password");
        } else {
            //connection avec la base de donnée
            con = Connect.connect();
            //envoi de la requete SQL
            String sql = "select employerId from employer where username ='" + txtUserName.getText()
                    + "'and Password='" + txtPassword.getText() + "'";
            //try et catch verifie ke l'app ne va pa sarété en cas d'erreur
            try {
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery();

                if (rst.next()) {
                    //afficher le paneau spécifike a un user
                    con = Connect.connect();
                    try {
                        pst = con.prepareStatement(sql);
                        ResultSet rec2 = pst.executeQuery(sql);
                        rec2.next();
                        id = rec2.getString("employerId");
                        log.info("User is Connecter = " + txtUserName.getText());
                    } catch (SQLException e) {
                        log.error(e);
                    }

                    char charAt = id.charAt(0);

                    if (charAt == 'A') {
                        this.setVisible(false);

                        HomeAdministrateur h = new HomeAdministrateur(charAt);
                        h.setVisible(true);
                    } else if (charAt == 'S') {
                        this.setVisible(false);

                        HomeSecretaire h = new HomeSecretaire(charAt);
                        h.setVisible(true);
                    } else if (charAt == 'D') {
                        this.setVisible(false);

                        HomeDirecteur h = new HomeDirecteur(charAt);
                        h.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "error");
                }
            } catch (SQLException ex) {
                log.error(ex);
            }
        }
    }//GEN-LAST:event_bOkActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        //confirmation si le user name et password ne sont pas vide
        if (txtUserName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter UserName");
        } else if (txtPassword.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Password");
        } else {
            //connection avec la base de donnée
            con = Connect.connect();
            //envoi de la requete SQL
            String sql = "select employerId from employer where username ='" + txtUserName.getText()
                    + "'and Password='" + txtPassword.getText() + "'";
            //try et catch verifie ke l'app ne va pa sarété en cas d'erreur
            try {
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery();

                if (rst.next()) {
                    //afficher le paneau spécifike a un user
                    con = Connect.connect();
                    try {
                        pst = con.prepareStatement(sql);
                        ResultSet rec2 = pst.executeQuery(sql);
                        rec2.next();
                        id = rec2.getString("employerId");
                    } catch (SQLException e) {
                        log.error(e);
                    }

                    char charAt = id.charAt(0);

                    if (charAt == 'A') {
                        this.setVisible(false);

                        HomeAdministrateur h = new HomeAdministrateur(charAt);
                        h.setVisible(true);
                    } else if (charAt == 'S') {
                        this.setVisible(false);

                        HomeSecretaire h = new HomeSecretaire(charAt);
                        h.setVisible(true);
                    } else if (charAt == 'D') {
                        this.setVisible(false);

                        HomeDirecteur h = new HomeDirecteur(charAt);
                        h.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "error");
                }
            } catch (SQLException ex) {
                log.error(ex);
            }
        }    }//GEN-LAST:event_txtPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
