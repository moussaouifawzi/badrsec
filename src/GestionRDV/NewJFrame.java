/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionRDV;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.omg.CORBA.SystemException;


/**
 *
 * @author FAWZI
 */
 

public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
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

        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Verifier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(jButton1)
                .addGap(95, 95, 95))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        //                                                  il fo ajoute jcalendar ici
        JOptionPane.showMessageDialog(null, "test "+get_nombre_Vendredi_FIN_MOIS(11,06,2016));
        

    }//GEN-LAST:event_jButton1ActionPerformed
    
    public Boolean is_week_end(Date date)
    {
        if(date.toString().contains("Fri"))
        {
            return true;
        }
        return false;
    }   
    //deuxieme cas, l'utilisateur choisi le mois et l'année
    //il est névessaire d'enlever les week-end les compter les rendez-vous déja pris
    
    public int get_nombre_Vendredi_par_mois(int mois,int annee)
    {
        Calendar mois_annee = Calendar.getInstance();
        mois_annee.set(annee, mois -1 ,1);
        
        int nombre_jours_du_mois = mois_annee.getActualMaximum(Calendar.DAY_OF_MONTH);
        int nombre_week_end = 0;
        
        for(int i = 1;i<=nombre_jours_du_mois;i++)
        {
            mois_annee.set(annee, mois -1,i);
            int dayOfWeek = mois_annee.get(Calendar.DAY_OF_WEEK);
            if(dayOfWeek == Calendar.FRIDAY)
            {
                System.out.print(nombre_week_end);
                nombre_week_end++;
            }
        }
        //int nombre_vendredi = mois_annee.getMaximum(Calendar.DAY_OF_WEEK_IN_MONTH);
        return nombre_week_end;
    }
    
        public int get_nombre_Vendredi_FIN_MOIS(int jour,int mois,int annee)
        {
            Calendar mois_annee = Calendar.getInstance();
            mois_annee.set(annee, mois -1 ,jour);

            int nombre_jours_du_mois = mois_annee.getActualMaximum(Calendar.DAY_OF_MONTH);
            int nombre_week_end = 0;

            for(int i = jour;i<=nombre_jours_du_mois;i++)
            {
                mois_annee.set(annee, mois -1,i);
                int dayOfWeek = mois_annee.get(Calendar.DAY_OF_WEEK);
                if(dayOfWeek == Calendar.FRIDAY)
                {
                    System.out.print(nombre_week_end);
                    nombre_week_end++;
                }
            }
            //int nombre_vendredi = mois_annee.getMaximum(Calendar.DAY_OF_WEEK_IN_MONTH);
            return nombre_week_end;
        }
        
        public int get_semaine_de_annee(int jour,int mois,int annee)
        {
            Calendar calendrier = Calendar.getInstance();
            calendrier.set(annee, mois -1,jour);            
            calendrier.setFirstDayOfWeek(Calendar.SUNDAY);
            
            int semaine_courante = calendrier.get(Calendar.WEEK_OF_YEAR);
            return semaine_courante;
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
                
    
Calendar now = Calendar.getInstance();

//int jour = now.get(Calendar.DAY_OF_WEEK);
/*Date jour = JDateChooser.getDateEditor().getUiComponent().getText();
                
if(Calendar.FRIDAY == jour)
   JOptionPane.showMessageDialog(null, "c'est un week end !!");*/


  
    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    // End of variables declaration//GEN-END:variables
}
