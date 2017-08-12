/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbadr.RDV;

import GestionRDV.ConsulterConvontionRDV;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import GestionRDV.RDV;
import gestionbadr.Connect;
import gestionbadr.HomeAdministrateur;
import gestionbadr.HomeDirecteur;
import gestionbadr.HomeSecretaire;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.APRIL;
import static java.util.Calendar.AUGUST;
import static java.util.Calendar.DECEMBER;
import static java.util.Calendar.FEBRUARY;
import static java.util.Calendar.JANUARY;
import static java.util.Calendar.JULY;
import static java.util.Calendar.JUNE;
import static java.util.Calendar.MARCH;
import static java.util.Calendar.MAY;
import static java.util.Calendar.NOVEMBER;
import static java.util.Calendar.OCTOBER;
import static java.util.Calendar.SEPTEMBER;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.apache.log4j.Logger;

/**
 *
 * @author FAWZI
 */
public class Quantite extends javax.swing.JFrame {
static Logger log = Logger.getLogger(Quantite.class.getName());

     Connection con = null;
    PreparedStatement pst = null;
    ResultSet rst = null;
    Statement st = null;
    ResultSet rs = null;
    String nom_convontion;
    String nbr_RDv;
    String unite_c;
    protected int id_conv;
    int id_pp;
    int id_p;
    String nom_p;
    char id; 
    
    protected String id_m;
    //protected int id_demande_RDV;
    boolean t = false; // etat de la date si prise = true  "Verifier_date_rdv()"
    Integer[] tableau_resultat_rdv_mois_par_annee = new Integer[12]; // tableau des rdv restant par mois de l'année
    Integer[] tableau_Vendredi_mois_par_annee = new Integer[12]; // Tableau du nombres de Vendredi par mois de l'année
    Integer[] tableau_max_Day_mois_par_annee = new Integer[12]; // Tableau de Maximum de jour par mois de l'année
    
    public Quantite() {
        
        log.trace("Debut Quantite()");
        initComponents();
        
        jTabbedPane1.setEnabledAt(1, false);
        Remplir_Combo_Type_Convontion();
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Cancel();
            }
        });
        
        log.trace("Fin Quantite()");
    }
    
    private void Cancel(){
        log.trace("Debut Cancel");
         this.dispose();
        this.setVisible(false);

        log.debug("Cancel : id " + id);
        
        if (id == 'A') {
            this.setVisible(false);
            HomeAdministrateur h = new HomeAdministrateur(id);
            h.setVisible(true);
            log.trace("le caracter = a");
        } else if (id == 'S') {
            this.setVisible(false);

            HomeSecretaire h = new HomeSecretaire(id);
            h.setVisible(true);
            log.trace("le caracter = s");
        } else if (id == 'D') {
            this.setVisible(false);
            HomeDirecteur h = new HomeDirecteur(id);
            h.setVisible(true);
            log.trace("le caracter = d");
        }
        log.trace("Fin Cancel");
    }
    
    public Quantite(char id) {
        
        log.trace("Debut Quantite(char id)");
        
        initComponents();
        
        jTabbedPane1.setEnabledAt(1, false);
        Remplir_Combo_Type_Convontion();
        
        log.debug("Quantite(char id) : id Admin = " + id);
        this.id = id;
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Cancel();
            }
        });
        
        log.trace("Fin Quantite(char id)");
    }

    @SuppressWarnings("unchecked")
    private void Remplir_Combo_Type_Convontion() {
         log.trace("Debut");
        con = Connect.connect();
        String requete = "select nom_convontion from convontion";
        try {
            pst = con.prepareStatement(requete);
            rst = pst.executeQuery();
            while (rst.next()) {
                nom_convontion = rst.getString("nom_convontion");
//                id_conv = rst.getString("id_conv");
                cConvontion.addItem(nom_convontion);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            log.error(e);
        } finally {
            /*This block should be added to your code
             * You need to release the resources like connections
             */
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    log.error(ex);
                }
            }
        }
         log.trace("Fin");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pChoisirRDV = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jYearChooser2 = new com.toedter.calendar.JYearChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tConvontion = new javax.swing.JTable(){
            public boolean isCellEditable (int d, int c){
                return false;
            }

        }
        ;
        jLabel15 = new javax.swing.JLabel();
        cConvontion = new javax.swing.JComboBox();
        bRechercherCotaParAns = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        pChoisirDate = new javax.swing.JPanel();
        tDateParConvontion = new javax.swing.JScrollPane();
        tRDVchoix1 = new javax.swing.JTable(){
            public boolean isCellEditable (int d, int c){
                // Rendre les cellule non Editable
                return false;
            }
            public Component prepareRenderer(TableCellRenderer r, int rw,int col)
            {
                //        // Colorier les ligne du tableau
                Component c = super.prepareRenderer(r, rw, col);
                c.setBackground(Color.WHITE);
                c.setForeground(Color.BLACK);
                String nomJour = tRDVchoix1.getModel().getValueAt(rw, 0).toString();

                if (nomJour.equals("vendredi")) { // Si Jour = Vendredi alors ERREUR
                    c.setBackground(Color.RED);
                    c.setForeground(Color.WHITE);
                }

                String date_tester = tRDVchoix1.getModel().getValueAt(rw, 1).toString();
                boolean k = Verifier_date_rdv_colorier(date_tester);
                //        con = Connect.connect();
                //        String sql = "select Etat_RDV,date_rdv from rdv where date_rdv ='" + date_tester + "'";
                //        try {
                    //            pst = con.prepareStatement(sql);
                    //            ResultSet rst1 = pst.executeQuery(sql);

                    //            while (rst1.next()) {
                        //                // Compare la valeur selectioner avec la valeur rechercher dans la BDD
                        //                String Etat_rdv_pris = rst1.getString("Etat_RDV");
                        //                Date date_rdv_pris = rst1.getDate("date_rdv");
                        //                DateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
                        //                String dateFormatee = fd.format(date_rdv_pris);
                        //                System.out.println(Etat_rdv_pris + " | date bd: "+ dateFormatee + " | date tableau: "+ date_tester);
                        if (k == true) {
                            //                    //                     si la date est prise afficher ERREUR
                            t = true;
                            System.out.println("Rouge");
                            c.setBackground(Color.RED);
                            c.setForeground(Color.WHITE);
                            //                    //                    JOptionPane.showMessageDialog(null, "c'est une date prise");
                        }
                        //else if ((((Etat_rdv_pris.equals("Pris") || Etat_rdv_pris.equals("En Attente")))
                            //                    && (Etat_rdv_pris.equals("Annuler") || Etat_rdv_pris.equals("Reporter")))
                        //                && dateFormatee.equals(date_tester)) {
                        //                //                     si la date est prise afficher ERREUR
                        //                t = true;
                        //                c.setBackground(Color.RED);
                        //                c.setForeground(Color.WHITE);
                        //            }
                    //        }
                //        else {
                    //            t = false;
                    //            //        }
                //    } catch (SQLException | NumberFormatException e) {
                //        JOptionPane.showMessageDialog(null, e.getMessage());
                //    }finally{
                //        /*This block should be added to your code
                //        * You need to release the resources like connections
                //        */
                //        if(con!=null)
                //        try {
                    //            con.close();
                    //        } catch (SQLException ex) {
                    //            Logger.getLogger(RDV.class.getName()).log(Level.SEVERE, null, ex);
                    //        }
                //    }
            return c;
        }
    };
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jYearChooser1 = new com.toedter.calendar.JYearChooser();
    jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
    bRechercherCotaParMois = new javax.swing.JButton();
    jLabel16 = new javax.swing.JLabel();
    txtNomConvontion = new javax.swing.JTextField();
    bCancel = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setResizable(false);

    jLabel17.setText("Annee");

    tConvontion.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null}
        },
        new String [] {
            "Mois", "Annee", "Quantite"
        }
    ));
    tConvontion.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tConvontionMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tConvontion);

    jLabel15.setText("Convontion");

    cConvontion.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
        public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
        }
        public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            cConvontionPopupMenuWillBecomeInvisible(evt);
        }
        public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
        }
    });
    cConvontion.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cConvontionActionPerformed(evt);
        }
    });

    bRechercherCotaParAns.setText("Rechercher");
    bRechercherCotaParAns.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            bRechercherCotaParAnsActionPerformed(evt);
        }
    });

    jButton3.setText("Consulter Convontion");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pChoisirRDVLayout = new javax.swing.GroupLayout(pChoisirRDV);
    pChoisirRDV.setLayout(pChoisirRDVLayout);
    pChoisirRDVLayout.setHorizontalGroup(
        pChoisirRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pChoisirRDVLayout.createSequentialGroup()
            .addGroup(pChoisirRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pChoisirRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pChoisirRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pChoisirRDVLayout.createSequentialGroup()
                            .addGap(58, 58, 58)
                            .addComponent(jLabel15))
                        .addGroup(pChoisirRDVLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(pChoisirRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cConvontion, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pChoisirRDVLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jButton3)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pChoisirRDVLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel17)
                        .addGap(29, 29, 29)
                        .addComponent(jYearChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pChoisirRDVLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(bRechercherCotaParAns)))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pChoisirRDVLayout.setVerticalGroup(
        pChoisirRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pChoisirRDVLayout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(pChoisirRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pChoisirRDVLayout.createSequentialGroup()
                    .addGroup(pChoisirRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pChoisirRDVLayout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cConvontion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jYearChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel17))
                    .addGap(29, 29, 29)
                    .addComponent(bRechercherCotaParAns)
                    .addGap(18, 18, 18)
                    .addComponent(jButton3))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(180, Short.MAX_VALUE))
    );

    jTabbedPane1.addTab("Choisir une Convontion", pChoisirRDV);

    tRDVchoix1.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null},
            {null, null},
            {null, null},
            {null, null}
        },
        new String [] {
            "Jour", "Date"
        }
    ));
    tRDVchoix1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tRDVchoix1MouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            tRDVchoix1MouseEntered(evt);
        }
    });
    tDateParConvontion.setViewportView(tRDVchoix1);

    jLabel8.setText("Mois");

    jLabel9.setText("Annee");

    jMonthChooser1.setMonth(5);

    bRechercherCotaParMois.setText("Rechercher");
    bRechercherCotaParMois.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            bRechercherCotaParMoisActionPerformed(evt);
        }
    });

    jLabel16.setText("Nom de la convontion:");

    javax.swing.GroupLayout pChoisirDateLayout = new javax.swing.GroupLayout(pChoisirDate);
    pChoisirDate.setLayout(pChoisirDateLayout);
    pChoisirDateLayout.setHorizontalGroup(
        pChoisirDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pChoisirDateLayout.createSequentialGroup()
            .addGroup(pChoisirDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pChoisirDateLayout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jLabel8))
                .addGroup(pChoisirDateLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jLabel16))
                .addGroup(pChoisirDateLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pChoisirDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pChoisirDateLayout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(bRechercherCotaParMois))
                .addGroup(pChoisirDateLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtNomConvontion, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(tDateParConvontion, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
            .addGap(28, 28, 28))
    );
    pChoisirDateLayout.setVerticalGroup(
        pChoisirDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pChoisirDateLayout.createSequentialGroup()
            .addGap(22, 22, 22)
            .addComponent(jLabel16)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtNomConvontion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 356, Short.MAX_VALUE)
            .addGroup(pChoisirDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pChoisirDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jYearChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jMonthChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bRechercherCotaParMois)
            .addGap(48, 48, 48))
        .addGroup(pChoisirDateLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(tDateParConvontion, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jTabbedPane1.addTab("Choisir une Date", pChoisirDate);

    bCancel.setText("Cancel");
    bCancel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            bCancelActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jTabbedPane1)))
            .addGap(36, 36, 36))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jTabbedPane1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bCancel)
            .addContainerGap())
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bRechercherCotaParMoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechercherCotaParMoisActionPerformed
         log.trace("Debut");
        try {
            afficher_la_date_dun_mois();

        } catch (ParseException ex) {
            log.error("Erreure ", ex);
        }
         log.trace("Fin");
    }//GEN-LAST:event_bRechercherCotaParMoisActionPerformed

    public void afficher_la_date_dun_mois() throws ParseException {
//        Afficher les Date + le Nom du Jours d'un mois et d'une annee dans tRDVChoix

        DecimalFormat myFormatter = new DecimalFormat("00");
        String output = myFormatter.format(jMonthChooser1.getMonth() + 1);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, jMonthChooser1.getMonth());
        DefaultTableModel md = new DefaultTableModel();
        md.setColumnIdentifiers(new String[]{"Jours", "date"});
        cal.set(Calendar.YEAR, jYearChooser1.getYear());
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i < maxDay + 1; i++) {
            String output2 = myFormatter.format(i);
            //            Ajouter le Nom du jour
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String n = jYearChooser1.getYear() + "-" + output + "-" + output2;
            Date dateValidation = formatter.parse(n);
            md.addRow(new Object[]{new SimpleDateFormat("EEEE").format(dateValidation), jYearChooser1.getYear() + "-" + output + "-" + output2});
        }
        tRDVchoix1.setModel(md);
    }
    
    private void tRDVchoix1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tRDVchoix1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tRDVchoix1MouseEntered

    public boolean Verifier_date_rdv() {
//      Cette methode Verifie si la date de RDv a été Pris ou existe Sur TOute l'année 
//        et affiche un message d'erreur si l'utilisateur choisit une date prise

        Rechercher_Unite_Convontion();
        int row = tRDVchoix1.getSelectedRow();
        ArrayList date = new ArrayList(); // tableau de ma date
        ArrayList etat = new ArrayList(); // tableau des etat des date
        boolean h = false; // etat des date

        String date_tester = tRDVchoix1.getModel().getValueAt(row, 1).toString();
        con = Connect.connect();
        String sql = "select Etat_RDV,date_rdv from rdv where convontion_id_conv='" + id_conv + "'";
        try {
            pst = con.prepareStatement(sql);
            ResultSet rst1 = pst.executeQuery(sql);
            while (rst1.next()) {
                // Remplire ArrayList "Etat" et "Date"
                String Etat_rdv_pris = rst1.getString("Etat_RDV");
                Date date_rdv_pris = rst1.getDate("date_rdv");
                DateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
                String dateFormatee = fd.format(date_rdv_pris);
                etat.add(Etat_rdv_pris);
                date.add(dateFormatee);
            }
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            log.error(e);
        } finally {
            /*This block should be added to your code
             * You need to release the resources like connections
             */
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    log.error(ex);
                }
            }
        }

        for (int i = 0; i < etat.size(); i++) {
            // Parcourt tout le tableau
            if (date.get(i).equals(date_tester)) {
                // verifie si la date existe dans la tableau
                if (etat.get(i).equals("Pris") || etat.get(i).equals("En Attente")) {
                    // verifie l'etat si pris ou en attent puis h = true 
                    h = true;
                }
            }
        }
        return h;
    }

    @SuppressWarnings("unchecked")
    private boolean Verifier_date_rdv_colorier(String date_rdv_tableau) {
//      Cette methode Verifie si la date de RDv a été Pris ou existe Sur TOute l'année
//        puis elle colorie le tableau

        Rechercher_Unite_Convontion();
        ArrayList date = new ArrayList(); // tableau des date
        ArrayList etat = new ArrayList(); // tableau des etat des date
        boolean h = false; // l'etat du RDV

        con = Connect.connect();
        String sql = "select Etat_RDV,date_rdv from rdv where convontion_id_conv='" + id_conv + "'";
        try {
            pst = con.prepareStatement(sql);
            ResultSet rst1 = pst.executeQuery(sql);
            while (rst1.next()) {
                // Remplire ArrayList "Etat" et "Date" depuis la table RDV
                String Etat_rdv_pris = rst1.getString("Etat_RDV");
                Date date_rdv_pris = rst1.getDate("date_rdv");
                DateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
                String dateFormatee = fd.format(date_rdv_pris);
                etat.add(Etat_rdv_pris);
                date.add(dateFormatee);
            }
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            log.error(e);
        } finally {
            /*This block should be added to your code
             * You need to release the resources like connections
             */
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    log.error(ex);
                }
            }
        }

        for (int i = 0; i < etat.size(); i++) {
            // Parcourt tout le tableau
            if (date.get(i).equals(date_rdv_tableau)) {
                // verifie si la date existe dans la tableau
                if (etat.get(i).equals("Pris") || etat.get(i).equals("En Attente")) {
                    // verifie l'etat si c'est pirs ou en attente h = true
                    h = true;
                }
            }
        }
        return h;
    }
    
    private void tRDVchoix1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tRDVchoix1MouseClicked
        //        Envoie de la Date du TABLEAU "Choisir une Date" à "Validation RDV"
         log.trace("Debut");
        boolean v;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        int row = tRDVchoix1.getSelectedRow();
        String n = tRDVchoix1.getModel().getValueAt(row, 1).toString();
        String nomJour = tRDVchoix1.getModel().getValueAt(row, 0).toString();

        if (nomJour.equals("vendredi")) { // Si Jour = Vendredi alors ERREUR
            JOptionPane.showMessageDialog(null, "c'est un week end");
        } else {
            
            Boolean k = Verifier_date_rdv();
            //            System.out.println("Table else t =" + t);

            //            if (t == false) { // Si la Date a était prise alos
                if (k == false) { // Si la Date a était prise alos
                    //                System.out.println("Table else if t =" + t);
                    try {
                        Date dateValidation = formatter.parse(n);   // foramter la date
//                        jDateValidation.setDate(dateValidation);
                        v = true;
                    } catch (ParseException e) {
                        log.error(e);
                        v = false;
                    } finally {
                        /*This block should be added to your code
                        * You need to release the resources like connections
                        */
                        if (con != null) {
                            try {
                                con.close();
                            } catch (SQLException ex) {
                                log.error(ex);
                            }
                        }
                    }

//                    if (v == true) {
//                        // Débloquer les autres anglets et affecter la date prise
//                        //                    System.out.println("Table if v =" + v);
//                        jTabbedPane1.setEnabledAt(3, true);
//                        jTabbedPane1.setSelectedIndex(3);
//
//                        jDateValidation.setEnabled(false);
//                        bAjouterValidation.setEnabled(true);
//                        bModifierValidation.setEnabled(false);
//                    } else {
//                        //                    System.out.println("Table Erreur");
//                        JOptionPane.showMessageDialog(null, "Erreur");
//                    }
                } else {
                    JOptionPane.showMessageDialog(null, "c'est une date prise");
                }
            }
         log.trace("Fin");
    }//GEN-LAST:event_tRDVchoix1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        ConsulterConvontionRDV s = new ConsulterConvontionRDV();
        s.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bRechercherCotaParAnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechercherCotaParAnsActionPerformed
         log.trace("Debut");
        if (cConvontion.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "La Convontion est vide");
        } else {
            
            Rechercher_Unite_Convontion();
            afficher_le_Mois_dune_anne();
        }
         log.trace("Fin");
    }//GEN-LAST:event_bRechercherCotaParAnsActionPerformed

    public void Rechercher_Unite_Convontion() {
         log.trace("Debut");
        String sql = "select partenaire_id_p,id_conv, nbr_RDv , unite from  convontion where nom_convontion ='"
                + cConvontion.getSelectedItem() + "'";
        con = Connect.connect();
        try {
            pst = con.prepareStatement(sql);
            ResultSet rec2 = pst.executeQuery(sql);
            rec2.next();
            id_p = Integer.parseInt(rec2.getString("partenaire_id_p"));
            id_conv = Integer.parseInt(rec2.getString("id_conv"));
            nbr_RDv = rec2.getString("nbr_RDv");
            unite_c = rec2.getString("unite");
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            log.error(e);
        } finally {
            /*This block should be added to your code
             * You need to release the resources like connections
             */
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    log.error(ex);
                }
            }
        }
         log.trace("Fin");
    }
    
    public void afficher_le_Mois_dune_anne() {
//      Cette methode Affiche tout les mois d'une annee dans tConvontion
         log.trace("Debut");
        int quantite_par_unite; // la quantite des RDV restant par Unite
        String Unite[] = {"Mois", "Semaine", "Jours"}; // Tableau des Nom d'unite
        DecimalFormat myFormatter = new DecimalFormat("00");
        int MoisAnnee[] = {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};
        DefaultTableModel md = new DefaultTableModel();
        md.setColumnIdentifiers(new String[]{"Mois", "Annee", "Quantite"});

        if (unite_c.equals(Unite[0])) { // Calcule de la Quantite des RDV restant dans l'unite MOIS
            Calculer_les_RDv_Pris();
            quantite_par_unite = Integer.parseInt(nbr_RDv);
            for (int i = 0; i < MoisAnnee.length; i++) {
                String Mois = myFormatter.format(i + 1); // le Mois (formater et +1 pour afficher le mois exacte)
                int quantite_restante_rdv = quantite_par_unite - tableau_resultat_rdv_mois_par_annee[i];
                md.addRow(new Object[]{Mois, jYearChooser2.getYear(), quantite_restante_rdv});
            }
            tConvontion.setModel(md);
        } else if (unite_c.equals(Unite[1])) { // Calcule de la Quantite des RDV restant dans l'unite Semaine

        } else if (unite_c.equals(Unite[2])) { // Calcule de la Quantite des RDV restant dans l'unite Jours
            Calculer_les_RDv_Pris();
            Nbr_Vedredie_de_toute_lannee();
            quantite_par_unite = Integer.parseInt(nbr_RDv);
            for (int i = 0; i < MoisAnnee.length; i++) {    // calculer le nombre de rdv par mois sans les weekend
                String Mois = myFormatter.format(i + 1);
//                int quantite_restante_rdv = quantite_par_unite * tableau_max_Day_mois_par_annee[i] - tableau_Vendredi_mois_par_annee[i];
                int quantite_restante_rdv = tableau_max_Day_mois_par_annee[i] - tableau_Vendredi_mois_par_annee[i] - tableau_resultat_rdv_mois_par_annee[i];
                md.addRow(new Object[]{Mois, jYearChooser2.getYear(), quantite_restante_rdv});
            }
            tConvontion.setModel(md);
        }
//        }
         log.trace("Fin");
//        Remplir la table tConvontion
    }
    
    private void Nbr_Vedredie_de_toute_lannee() {
        // cette methode Calcule les vendredi de toute l'année par mois
 log.trace("Debut");
        Calendar cal = Calendar.getInstance();
        int tableauMois[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        for (int i = 0; i < tableauMois.length; i++) {
            int Vendredi_par_mois = get_nombre_Vendredi_par_mois(tableauMois[i], jYearChooser1.getYear());
            tableau_Vendredi_mois_par_annee[i] = Vendredi_par_mois;
            cal.set(Calendar.MONTH, tableauMois[i]);
            cal.set(Calendar.YEAR, jYearChooser2.getYear());
            int maxDayPerMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            tableau_max_Day_mois_par_annee[i] = maxDayPerMonth;
        }
         log.trace("Fin");
    }
    
    public int get_nombre_Vendredi_par_mois(int mois, int annee) {
        // Cette Methode calcule de nombre de WeekEnd par mois de l'année 
 log.trace("Debut");
        Calendar mois_annee = Calendar.getInstance();
        mois_annee.set(annee, mois, 1);
        int nombre_jours_du_mois = mois_annee.getActualMaximum(Calendar.DAY_OF_MONTH);
        int nombre_week_end = 0;
        for (int i = 1; i <= nombre_jours_du_mois; i++) {
            mois_annee.set(annee, mois, i);
            int dayOfWeek = mois_annee.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.FRIDAY) {
                nombre_week_end++;
            }
        }
         log.trace("Fin");
        return nombre_week_end;
        
    }
    
     private void Calculer_les_RDv_Pris() {
//      Cette methode Calcule les RDv Pris ou En ATTENTE Sur TOute l'année
 log.trace("Debut");
        Rechercher_Unite_Convontion();
        DecimalFormat myFormatter = new DecimalFormat("00");
        String sql = "select Etat_RDV,date_rdv from rdv where convontion_id_conv='" + id_conv + "'";
        int yearChooser2 = jYearChooser2.getYear();
        for (int m = 0; m <= 11; m++) { // calculer les rdv restant sur tout les mois le l'annee
            int i = 0;
            con = Connect.connect();
            try {
                pst = con.prepareStatement(sql);
                ResultSet rst1 = pst.executeQuery(sql);

                while (rst1.next()) {
                    String Etat_rdv_pris = rst1.getString("Etat_RDV");
                    Date date_rdv_pris = rst1.getDate("date_rdv");
                    DateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
                    String dateFormatee = fd.format(date_rdv_pris);
                    String Mois = dateFormatee.substring(5, 7);
                    String Annee = dateFormatee.substring(0, 4);
                    String Month = myFormatter.format(m + 1);
                    String yearChooser2Formater = myFormatter.format(yearChooser2);
                    if ((Etat_rdv_pris.equals("Pris") || Etat_rdv_pris.equals("En Attente")) && Mois.equals(Month)
                            && Annee.equals(yearChooser2Formater)) { // Si l'etat du RDV = Pris ou En Attente alors +1
                        i++;
                    }
                }
                tableau_resultat_rdv_mois_par_annee[m] = i;
            } catch (SQLException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            } finally {
                /*This block should be added to your code
                 * You need to release the resources like connections
                 */
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        log.error(ex);
                    }
                }
            }
        }
         log.trace("Fin");
    }
    
    private void cConvontionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cConvontionActionPerformed
         log.trace("Debut");
        String a = (String) cConvontion.getSelectedItem();
        txtNomConvontion.setText(a);
        txtNomConvontion.setEditable(false);
         log.trace("Fin");
    }//GEN-LAST:event_cConvontionActionPerformed

    private void cConvontionPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cConvontionPopupMenuWillBecomeInvisible
       Rechercher_Unite_Convontion();
    }//GEN-LAST:event_cConvontionPopupMenuWillBecomeInvisible

    
    
    
    private void tConvontionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tConvontionMouseClicked
         log.trace("Debut");
        boolean b = false;
        int row = tConvontion.getSelectedRow();
        String Mois = tConvontion.getModel().getValueAt(row, 0).toString();
        String Annee = tConvontion.getModel().getValueAt(row, 1).toString();
        String quantite_rdv = tConvontion.getModel().getValueAt(row, 2).toString();
        jYearChooser1.setYear(Integer.parseInt(Annee));
        int Month = Integer.parseInt(Mois) - 1;
        jMonthChooser1.setMonth(Month);
        

        if (Integer.parseInt(quantite_rdv) == 0) {  // Si quantite de RDV = 0 alors ERREUR
            JOptionPane.showMessageDialog(null, "Erreur: La Quantite est = 0. ");
        } 
        else {
            
            try {
                afficher_la_date_dun_mois();
            } catch (ParseException ex) {
                log.error(ex);
            }
            b = true;
            /*This block should be added to your code
            * You need to release the resources like connections
            */
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    log.error(ex);
                }
            }
        }

        if (b == true) { // Debloquer les autres anglets
            log.trace("Debut Debloquer les autres anglets");
            jTabbedPane1.setEnabledAt(1, true);
            jTabbedPane1.setSelectedIndex(1);
            log.trace("Fin Debloquer les autres anglets");
        }
         log.trace("Fin");
        //        else {
            //            JOptionPane.showMessageDialog(null, "Erreur");
            //        }
    }//GEN-LAST:event_tConvontionMouseClicked

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        Cancel();
    }//GEN-LAST:event_bCancelActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(Quantite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quantite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quantite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quantite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quantite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bRechercherCotaParAns;
    private javax.swing.JButton bRechercherCotaParMois;
    private javax.swing.JComboBox cConvontion;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private com.toedter.calendar.JYearChooser jYearChooser2;
    private javax.swing.JPanel pChoisirDate;
    private javax.swing.JPanel pChoisirRDV;
    private javax.swing.JTable tConvontion;
    private javax.swing.JScrollPane tDateParConvontion;
    private javax.swing.JTable tRDVchoix1;
    private javax.swing.JTextField txtNomConvontion;
    // End of variables declaration//GEN-END:variables
}
