/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionArticle;

import gestionbadr.Connect;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author FAWZI
 */
public class RechercherArticle extends javax.swing.JFrame {
static Logger log = Logger.getLogger(RechercherArticle.class.getName());
    ResultSet rst = null;
    Connection con = null;
    Statement st = null;
    PreparedStatement pst = null;
    char id; // id de l'administrateur pour qu'il revoi au bon HOME

    public RechercherArticle() {
        initComponents();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Cancel();
            }
        });
    }
    
    public RechercherArticle(char id) {
        initComponents();
        this.id=id;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Cancel();
            }
        });
    }
    
    private void Cancel (){
        this.dispose();
        this.setVisible(false);
        AjouterArticle s = new AjouterArticle();
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
        tArticleHistorique = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cType = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        txtNomArticle = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bRechercherArticle = new javax.swing.JButton();
        bCancel2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rechercher Artcile");

        tArticleHistorique.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nom Article", "Quantite", "Type"
            }
        ));
        tArticleHistorique.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tArticleHistoriqueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tArticleHistorique);

        cType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pret", "Consomable" }));
        cType.setSelectedIndex(-1);

        jLabel11.setText("Type :");

        jLabel8.setText("Nom :");

        bRechercherArticle.setText("Rechercher");
        bRechercherArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRechercherArticleActionPerformed(evt);
            }
        });

        bCancel2.setText("Cancel");
        bCancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancel2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cType, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bRechercherArticle)
                    .addComponent(bCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNomArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(bRechercherArticle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancel2)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(481, 574));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bRechercherArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechercherArticleActionPerformed
        con = Connect.connect();
        

        if (txtNomArticle.getText().equals("") && cType.getSelectedIndex() == -1
                || cType.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Enter Une des combinaison suivante:"
                    + "\n     - Type seulement."
                    + "\n     - Nom Article et Type.");

        } else if ((cType.getSelectedItem() == "pret" || cType.getSelectedItem() == "consomable") 
                || !(txtNomArticle.getText().equals(""))) {
            try {

                String sql = "SELECT * FROM article WHERE Type_art = '" 
                        + cType.getSelectedItem() + "' AND Nom_a='"+ txtNomArticle.getText()+"'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tArticleHistorique.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            }
        }
        else if ((cType.getSelectedItem() == "pret" || cType.getSelectedItem() == "consomable") 
                || txtNomArticle.getText().equals("")) {
            try {

                String sql = "SELECT * FROM article WHERE Type_art = '" 
                        + cType.getSelectedItem() + "'";
                pst = con.prepareStatement(sql);
                rst = pst.executeQuery(sql);
                tArticleHistorique.setModel(DbUtils.resultSetToTableModel(rst));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            }
        } 

    }//GEN-LAST:event_bRechercherArticleActionPerformed

    private void bCancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancel2ActionPerformed

        Cancel();
    }//GEN-LAST:event_bCancel2ActionPerformed

    private void tArticleHistoriqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tArticleHistoriqueMouseClicked
        con = Connect.connect();
        int row = tArticleHistorique.getSelectedRow();
        System.out.println("1");
        String n;
        
        n = tArticleHistorique.getModel().getValueAt(row, 0).toString();
         System.out.println("11");
        try {
            String sql1 = "SELECT * FROM article WHERE id_a = '" + n + "'";
             System.out.println("3");
            pst = con.prepareStatement(sql1);
             System.out.println("4");
            rst = pst.executeQuery(sql1);
             System.out.println("5"+rst.toString());
             
            if (rst.next()) {
                 System.out.println("6");
                this.setVisible(false);
                AjouterArticle s1 = new AjouterArticle();
                s1.setVisible(true);
                
                String AjouterArticle = rst.getString("Nom_a");
                s1.txtNom.setText(AjouterArticle);
                String Quantite_a = rst.getString("Quantite_a");
                s1.txtQuantite.setText(Quantite_a);
                String type_art = rst.getString("type_art");
                s1.cType.setSelectedItem(type_art);
                s1.id_aa = rst.getInt("id_a");
                
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            log.error(e);
        }
       
    }//GEN-LAST:event_tArticleHistoriqueMouseClicked

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
            java.util.logging.Logger.getLogger(RechercherArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RechercherArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RechercherArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RechercherArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RechercherArticle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel2;
    private javax.swing.JButton bRechercherArticle;
    private javax.swing.JComboBox cType;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JTable tArticleHistorique;
    private javax.swing.JTextField txtNomArticle;
    // End of variables declaration//GEN-END:variables
}
