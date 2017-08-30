/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionRDV;

import gestionbadr.Connect;
import gestionbadr.HomeAdministrateur;
import gestionbadr.HomeDirecteur;
import gestionbadr.HomeSecretaire;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.*;

import java.util.Date;
import java.util.logging.Level;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.apache.log4j.Logger;

/**
 *
 * @author FAWZI
 */
public class RDV extends javax.swing.JFrame {

    static Logger log = Logger.getLogger(RDV.class.getName());

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rst = null;
    Statement st = null;
    Convontion_Semaine n;
    ResultSet rs = null;
    String nom_convontion;
    String nbr_RDv;
    String unite_c;
    protected int id_conv;
    int id_pp;
    int id_p;
    String nom_p;
    boolean bTypeSemaine = false; // les methode utiliser en cas de TRUE sont que pour "SEMAINE" e
    // et evite une erreur lore du changement de la convontion sans choir une date

    protected String id_m;
    //protected int id_demande_RDV;
    boolean t = false; // etat de la date si prise = true  "Verifier_date_rdv()"

    public int getId_demande_rdv() {
        return id_demande_rdv;
    }

    public void setId_demande_rdv(int id_demande_rdv) {
        this.id_demande_rdv = id_demande_rdv;
    }
    protected int id_demande_rdv;
    protected int id_rdv; // l'ID de la date du RDV de la table rdv
    protected int id_date_depot; // l'ID de la date depot de la table demande_de_rdv
    protected int partenaire_id_p;
    protected String date_depot;
    int Quantite_RDV_Pris;
    Integer[] tableau_resultat_rdv_mois_par_annee = new Integer[12]; // tableau des rdv restant par mois de l'année
    Integer[] tableau_Vendredi_mois_par_annee = new Integer[12]; // Tableau du nombres de Vendredi par mois de l'année
    Integer[] tableau_max_Day_mois_par_annee = new Integer[12]; // Tableau de Maximum de jour par mois de l'année
    Integer[] tableau_resultat_rdv_par_semaine = new Integer[53]; // Tableau de Maximum de jour par semaine par annee
    char id;
    String vNumSemaine = null;

//    public String getvNumSemaine() {
//        return vNumSemaine;
//    }
    public RDV() {
        initComponents();
        Remplir_Combo_Type_Convontion();
        cConvontion.setSelectedIndex(-1);
        txtNom.setEditable(false);
        txtPrenom.setEditable(false);
        txtAdress.setEditable(false);
        txtAdress.setEditable(false);
        txtNumTel.setEditable(false);

        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setEnabledAt(2, false);
        jTabbedPane1.setEnabledAt(3, false);
        bModifierValidation.setEnabled(false);
        bModifierDemandeRDV.setEnabled(false);
        jDateRecuperation.setEnabled(false);

        bDdateRecuperation.setEnabled(false);

        jMonthChooser1.setEnabled(false);
        jYearChooser1.setEnabled(false);
        bRechercherCotaParMois.setEnabled(false);
//        System.out.println(id_date_depot + "/" + id_m + "/" + id_conv + "/" + partenaire_id_p + "/" + id_rdv);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Cancel();
            }
        });
    }

    private void Cancel() {
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
    }

    public RDV(char id) {
        log.trace("Constructeure Surcharger de RDV ");
        initComponents();
        Remplir_Combo_Type_Convontion();
        cConvontion.setSelectedIndex(-1);
        txtNom.setEditable(false);
        txtPrenom.setEditable(false);
        txtAdress.setEditable(false);
        txtAdress.setEditable(false);
        txtNumTel.setEditable(false);

        bDdateRecuperation.setEnabled(false);

        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setEnabledAt(2, false);
        jTabbedPane1.setEnabledAt(3, false);
        bModifierValidation.setEnabled(false);
        bModifierDemandeRDV.setEnabled(false);
        jDateRecuperation.setEnabled(false);

        jMonthChooser1.setEnabled(false);
        jYearChooser1.setEnabled(false);
        bRechercherCotaParMois.setEnabled(false);
//        System.out.println(id_date_depot + "/" + id_m + "/" + id_conv + "/" + partenaire_id_p + "/" + id_rdv);
        log.debug("id Admin = " + id);
        this.id = id;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Cancel();
            }
        });
        log.trace("FIN Constructeure Surcharger de RDV ");
    }

    public int getId_rdv() {
        return id_rdv;
    }

    public void setId_rdv(int id_rdv) {
        this.id_rdv = id_rdv;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bCancel = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pDemandeRDV = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cEtatDemandeRDV = new javax.swing.JComboBox();
        bAjouterDemandeRDV = new javax.swing.JButton();
        jDateDepot = new com.toedter.calendar.JDateChooser();
        bModifierDemandeRDV = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        pRemarque1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        textExamenDe = new javax.swing.JTextArea();
        bIRM = new javax.swing.JButton();
        bSyntegraphie = new javax.swing.JButton();
        pExamen1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textRemarqueDe = new javax.swing.JTextArea();
        bDdateDepot = new javax.swing.JButton();
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
                // Colorier les ligne du tableau
                if (log.isTraceEnabled()){
                    log.trace("Debut Colorier les ligne du tableau");
                }

                Component c = super.prepareRenderer(r, rw, col);
                c.setBackground(Color.WHITE);
                c.setForeground(Color.BLACK);
                String nomJour = tRDVchoix1.getModel().getValueAt(rw, 0).toString();

                if (nomJour.equals("vendredi")) { // Si Jour = Vendredi alors ERREUR
                    c.setBackground(Color.RED);
                    c.setForeground(Color.WHITE);
                }

                boolean verificateur_unite = Verification_par_unite_convontion();

                Rechercher_Unite_Convontion();

                String date_tester = tRDVchoix1.getModel().getValueAt(rw, 1).toString();
                if ( verificateur_unite == true) {
                    if (log.isDebugEnabled()){
                        log.debug("Si  verificateur_unite == true");
                    }
                    boolean k = Verifier_date_rdv_colorier(date_tester);

                    if (k == true) {
                        //                    //                     si la date est prise afficher ERREUR
                        t = true;
                        //  System.out.println("Rouge");
                        c.setBackground(Color.RED);
                        c.setForeground(Color.WHITE);
                    }
                }

                if (log.isTraceEnabled()){
                    log.trace("Fin Colorier les ligne du tableau");
                }
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
        pValidationRDV = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cEtatValidation = new javax.swing.JComboBox();
        bAjouterValidation = new javax.swing.JButton();
        bModifierValidation = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jDateValidation = new com.toedter.calendar.JDateChooser();
        jDateRecuperation = new com.toedter.calendar.JDateChooser();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        pExamen = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textExamen = new javax.swing.JTextArea();
        pRemarque = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textRemarque = new javax.swing.JTextArea();
        bAppeler = new javax.swing.JButton();
        bPasDeReponse = new javax.swing.JButton();
        bARepondu = new javax.swing.JButton();
        bDdateRecuperation = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        bRechercherMalade = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNumTel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAdress = new javax.swing.JTextField();
        txtInt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        txtId_p3 = new javax.swing.JTextField();
        txtPrenom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bRechercherMaladeRDV = new javax.swing.JButton();
        bRechercherDemandeRDV = new javax.swing.JButton();
        bRechercherRDV = new javax.swing.JButton();
        bResetID = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        bannuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajouter RDV");
        setResizable(false);

        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        jLabel5.setText("Date Depot:");

        jLabel7.setText("Etat du RDV:");

        cEtatDemandeRDV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Valider", "En Attente" }));
        cEtatDemandeRDV.setSelectedIndex(-1);

        bAjouterDemandeRDV.setText("Ajouter");
        bAjouterDemandeRDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAjouterDemandeRDVActionPerformed(evt);
            }
        });

        jDateDepot.setDateFormatString("yyyy-MM-dd");
        jDateDepot.setMaxSelectableDate(new java.util.Date(253370764886000L));

        bModifierDemandeRDV.setText("Modifier");
        bModifierDemandeRDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModifierDemandeRDVActionPerformed(evt);
            }
        });

        textExamenDe.setColumns(20);
        textExamenDe.setRows(5);
        jScrollPane5.setViewportView(textExamenDe);

        bIRM.setText("IRM");
        bIRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIRMActionPerformed(evt);
            }
        });

        bSyntegraphie.setText("Syntegraphie");
        bSyntegraphie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSyntegraphieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pRemarque1Layout = new javax.swing.GroupLayout(pRemarque1);
        pRemarque1.setLayout(pRemarque1Layout);
        pRemarque1Layout.setHorizontalGroup(
            pRemarque1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRemarque1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pRemarque1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bIRM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bSyntegraphie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addContainerGap())
        );
        pRemarque1Layout.setVerticalGroup(
            pRemarque1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRemarque1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pRemarque1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pRemarque1Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pRemarque1Layout.createSequentialGroup()
                        .addComponent(bIRM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSyntegraphie)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane3.addTab("Examen", pRemarque1);

        textRemarqueDe.setColumns(20);
        textRemarqueDe.setRows(5);
        jScrollPane4.setViewportView(textRemarqueDe);

        javax.swing.GroupLayout pExamen1Layout = new javax.swing.GroupLayout(pExamen1);
        pExamen1.setLayout(pExamen1Layout);
        pExamen1Layout.setHorizontalGroup(
            pExamen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pExamen1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pExamen1Layout.setVerticalGroup(
            pExamen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pExamen1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Remarque", pExamen1);

        bDdateDepot.setText("D");
        bDdateDepot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDdateDepotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pDemandeRDVLayout = new javax.swing.GroupLayout(pDemandeRDV);
        pDemandeRDV.setLayout(pDemandeRDVLayout);
        pDemandeRDVLayout.setHorizontalGroup(
            pDemandeRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDemandeRDVLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pDemandeRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDemandeRDVLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateDepot, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bDdateDepot)
                        .addGap(17, 17, 17))
                    .addGroup(pDemandeRDVLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pDemandeRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pDemandeRDVLayout.createSequentialGroup()
                                .addComponent(cEtatDemandeRDV, 0, 172, Short.MAX_VALUE)
                                .addGap(57, 57, 57))
                            .addGroup(pDemandeRDVLayout.createSequentialGroup()
                                .addComponent(bModifierDemandeRDV)
                                .addGap(18, 18, 18)
                                .addComponent(bAjouterDemandeRDV)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        pDemandeRDVLayout.setVerticalGroup(
            pDemandeRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDemandeRDVLayout.createSequentialGroup()
                .addGroup(pDemandeRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDemandeRDVLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pDemandeRDVLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(pDemandeRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bDdateDepot)
                            .addGroup(pDemandeRDVLayout.createSequentialGroup()
                                .addGroup(pDemandeRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jDateDepot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pDemandeRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(cEtatDemandeRDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pDemandeRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bAjouterDemandeRDV)
                                    .addComponent(bModifierDemandeRDV))))))
                .addContainerGap(299, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Demande de RDV", pDemandeRDV);

        jLabel17.setText("Annee");

        tConvontion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
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
        tConvontion.setRowHeight(22);
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
                .addContainerGap(186, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Choisir une Convontion", pChoisirRDV);

        tRDVchoix1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
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
        tRDVchoix1.setRowHeight(22);
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
                        .addGap(29, 29, 29)
                        .addComponent(jLabel16))
                    .addGroup(pChoisirDateLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNomConvontion, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pChoisirDateLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pChoisirDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pChoisirDateLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel8))
                            .addGroup(pChoisirDateLayout.createSequentialGroup()
                                .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pChoisirDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pChoisirDateLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(bRechercherCotaParMois)))))
                .addGap(18, 18, 18)
                .addComponent(tDateParConvontion, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );
        pChoisirDateLayout.setVerticalGroup(
            pChoisirDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pChoisirDateLayout.createSequentialGroup()
                .addGroup(pChoisirDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pChoisirDateLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomConvontion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(pChoisirDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pChoisirDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jYearChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMonthChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bRechercherCotaParMois))
                    .addGroup(pChoisirDateLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tDateParConvontion, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Choisir une Date", pChoisirDate);

        jLabel11.setText("Date Valider du RDV:");

        jLabel12.setText("Date de Récupération:");

        jLabel13.setText("Etat du RDV:");

        cEtatValidation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Annuler", "Reporter", "Pris", "En Attente" }));
        cEtatValidation.setSelectedIndex(-1);
        cEtatValidation.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cEtatValidationPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cEtatValidation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cEtatValidationActionPerformed(evt);
            }
        });

        bAjouterValidation.setText("Ajouter");
        bAjouterValidation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAjouterValidationActionPerformed(evt);
            }
        });

        bModifierValidation.setText("Modifier");
        bModifierValidation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModifierValidationActionPerformed(evt);
            }
        });

        jDateValidation.setDateFormatString("yyyy-MM-dd");
        jDateValidation.setMaxSelectableDate(new java.util.Date(253370764886000L));

        jDateRecuperation.setDateFormatString("yyyy-MM-dd");
        jDateRecuperation.setMaxSelectableDate(new java.util.Date(253370764886000L));

        textExamen.setColumns(20);
        textExamen.setRows(5);
        jScrollPane3.setViewportView(textExamen);

        javax.swing.GroupLayout pExamenLayout = new javax.swing.GroupLayout(pExamen);
        pExamen.setLayout(pExamenLayout);
        pExamenLayout.setHorizontalGroup(
            pExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pExamenLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pExamenLayout.setVerticalGroup(
            pExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pExamenLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Examen", pExamen);

        textRemarque.setColumns(20);
        textRemarque.setRows(5);
        jScrollPane2.setViewportView(textRemarque);

        bAppeler.setText("Appeler");
        bAppeler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAppelerActionPerformed(evt);
            }
        });

        bPasDeReponse.setText("Pas de reponse");
        bPasDeReponse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPasDeReponseActionPerformed(evt);
            }
        });

        bARepondu.setText("A Repondu");
        bARepondu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAReponduActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pRemarqueLayout = new javax.swing.GroupLayout(pRemarque);
        pRemarque.setLayout(pRemarqueLayout);
        pRemarqueLayout.setHorizontalGroup(
            pRemarqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRemarqueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pRemarqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pRemarqueLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bPasDeReponse))
                    .addComponent(bAppeler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bARepondu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pRemarqueLayout.setVerticalGroup(
            pRemarqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRemarqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pRemarqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pRemarqueLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(pRemarqueLayout.createSequentialGroup()
                        .addComponent(bAppeler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bPasDeReponse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bARepondu)
                        .addGap(0, 107, Short.MAX_VALUE))))
        );

        jTabbedPane2.addTab("Remarque", pRemarque);

        bDdateRecuperation.setText("D");
        bDdateRecuperation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDdateRecuperationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pValidationRDVLayout = new javax.swing.GroupLayout(pValidationRDV);
        pValidationRDV.setLayout(pValidationRDVLayout);
        pValidationRDVLayout.setHorizontalGroup(
            pValidationRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pValidationRDVLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pValidationRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pValidationRDVLayout.createSequentialGroup()
                        .addGroup(pValidationRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pValidationRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pValidationRDVLayout.createSequentialGroup()
                                .addComponent(jDateRecuperation, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bDdateRecuperation))
                            .addComponent(cEtatValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pValidationRDVLayout.createSequentialGroup()
                        .addComponent(bModifierValidation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bAjouterValidation))
                    .addGroup(pValidationRDVLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pValidationRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pValidationRDVLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addContainerGap(207, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pValidationRDVLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        pValidationRDVLayout.setVerticalGroup(
            pValidationRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pValidationRDVLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pValidationRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pValidationRDVLayout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(184, 184, 184))
                    .addGroup(pValidationRDVLayout.createSequentialGroup()
                        .addGroup(pValidationRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jDateValidation, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pValidationRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cEtatValidation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(pValidationRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pValidationRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel12)
                                .addComponent(jDateRecuperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bDdateRecuperation))
                        .addGap(18, 18, 18)
                        .addGroup(pValidationRDVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bAjouterValidation)
                            .addComponent(bModifierValidation))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Validation du DRV", pValidationRDV);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Information Malade"));

        bRechercherMalade.setText("Rechercher");
        bRechercherMalade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRechercherMaladeActionPerformed(evt);
            }
        });

        jLabel3.setText("Numero de Tel :");

        jLabel4.setText("Adress");

        txtInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIntActionPerformed(evt);
            }
        });

        jLabel10.setText("ID :");

        jLabel1.setText("Nom :");

        jLabel2.setText("Prenom :");

        bRechercherMaladeRDV.setText("Rechercher Malade");
        bRechercherMaladeRDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRechercherMaladeRDVActionPerformed(evt);
            }
        });

        bRechercherDemandeRDV.setText("Demande RDV");
        bRechercherDemandeRDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRechercherDemandeRDVActionPerformed(evt);
            }
        });

        bRechercherRDV.setText("RDV");
        bRechercherRDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRechercherRDVActionPerformed(evt);
            }
        });

        bResetID.setText("R");
        bResetID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResetIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bRechercherRDV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bRechercherDemandeRDV))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNom)
                                    .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(txtInt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId_p3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(bResetID)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(36, 36, 36)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAdress)
                                    .addComponent(txtNumTel, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(bRechercherMaladeRDV, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bRechercherMalade)))))
                .addGap(32, 32, 32))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtId_p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bResetID)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNumTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bRechercherMalade)
                            .addComponent(bRechercherMaladeRDV))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bRechercherDemandeRDV)
                    .addComponent(bRechercherRDV))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        bannuler.setText("Anuler");
        bannuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bannulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bannuler)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancel)
                    .addComponent(bannuler))
                .addGap(14, 14, 14))
        );

        setSize(new java.awt.Dimension(800, 912));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void txtIntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIntActionPerformed

    private void bRechercherMaladeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechercherMaladeActionPerformed

        if (txtId_p3.getText().equals("") && txtInt.getText().equals("")
                || txtId_p3.getText().equals("") || txtInt.getText().equals("")
                || txtId_p3.getText().equals("") && txtInt.getText().equals("")
                || txtInt.getText().equals("")) {
//            si aucun malade n'est choisit
            JOptionPane.showMessageDialog(null, "Il faut choisir un Malade");
        } else {
            String c = "/";
            DecimalFormat myFormatter = new DecimalFormat("0000");
            String output = myFormatter.format(Integer.parseInt(txtInt.getText()));
            id_m = output + c + txtId_p3.getText();

            String sql = "Select id_m, prenom_m, nom_m, adr_m, num_tel_m from malade where id_m='" + id_m + "'";
            con = Connect.connect();
            try {
                //1er requete pour identifier une erreur de redendence
                pst = con.prepareStatement(sql);
                ResultSet rec2 = pst.executeQuery(sql);
                //            next() passe au autre tuple de la table
                rec2.next();
                String id_m1 = rec2.getString("id_m");
                String prenom = rec2.getString("prenom_m");
                String nom = rec2.getString("nom_m");
                String adr_m = rec2.getString("adr_m");
                String num_tel_m = rec2.getString("num_tel_m");

                //            Envoie des Donnée au textField
                txtNom.setText(adr_m);
                txtPrenom.setText(prenom);
                txtNumTel.setText(nom);
                txtAdress.setText(num_tel_m);

            } catch (Exception e) {
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
    }//GEN-LAST:event_bRechercherMaladeActionPerformed

    public void Rechercher_Malade(String id_malade) {
        System.out.println(id_malade);
        String sql = "Select id_m, prenom_m, nom_m, adr_m, num_tel_m from malade where id_m='" + id_malade + "'";
        con = Connect.connect();
        try {
            //1er requete pour identifier une erreur de redendence
            System.out.println("1");
            pst = con.prepareStatement(sql);
            System.out.println("2");
            ResultSet rec2 = pst.executeQuery(sql);
            //            next() passe au autre tuple de la table
            System.out.println("3");
            rec2.next();
            String id_m1 = rec2.getString("id_m");
            String prenom = rec2.getString("prenom_m");
            String nom = rec2.getString("nom_m");
            String adr_m = rec2.getString("adr_m");
            String num_tel_m = rec2.getString("num_tel_m");

            //            Envoie des Donnée au textField
            txtNom.setText(adr_m);
            txtPrenom.setText(prenom);
            txtNumTel.setText(nom);
            txtAdress.setText(num_tel_m);

        } catch (SQLException e) {
            log.error(e);
            JOptionPane.showMessageDialog(null, e.getMessage());
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
    private void bAjouterDemandeRDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAjouterDemandeRDVActionPerformed
        date_depot = ((JTextField) jDateDepot.getDateEditor().getUiComponent()).getText();
        if (txtId_p3.getText().equals("") && txtInt.getText().equals("")
                || txtId_p3.getText().equals("") || txtInt.getText().equals("")
                || txtId_p3.getText().equals("") && txtInt.getText().equals("")
                || txtInt.getText().equals("")) {
//            si aucun malade n'est choisit
            JOptionPane.showMessageDialog(null, "Il faut choisir un Malade");
        } else if (cEtatDemandeRDV.getSelectedIndex() == -1) {
//            si l'Etat du RDV est vide
            JOptionPane.showMessageDialog(null, "Etat du RDV est vide");
        } else if (date_depot.isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "La date est vide");
        } else {
//            Ajouter la demande de RDV

            String c = "/";
            String vEtatDemandeRDV = cEtatDemandeRDV.getSelectedItem().toString();
            DecimalFormat myFormatter = new DecimalFormat("0000");
            String output = myFormatter.format(Integer.parseInt(txtInt.getText()));
            id_m = output + c + txtId_p3.getText();
            boolean b;

            con = Connect.connect();
            try {
                //2eme requete pour ajouter les donné à la table
                String sql2 = "insert into demande_de_rdv (id_m, DateDepot, Etat_Demande, RemarqueDe, ExamenDe) values ('"
                        + id_m + "','" + date_depot
                        + "','" + cEtatDemandeRDV.getSelectedItem() + "','" + textRemarqueDe.getText() + "','" + textExamenDe.getText() + "')";

                pst = con.prepareStatement(sql2);
                pst.execute();

                b = true;

            } catch (NumberFormatException | SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
                b = false;
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

            if (b == true && cEtatDemandeRDV.getSelectedItem().equals("Valider")) {
//                Ouvrir l'onglet 2
                jTabbedPane1.setEnabledAt(1, true);
                jTabbedPane1.setSelectedIndex(1);
                bAjouterDemandeRDV.setEnabled(false);
                bModifierDemandeRDV.setEnabled(false);
                cEtatDemandeRDV.setEnabled(false);
                jDateDepot.setEnabled(false);
                Configurer_Partie_Malade();
                textExamenDe.setEditable(false);
                textRemarqueDe.setEditable(false);
                bSyntegraphie.setEnabled(false);
                bIRM.setEnabled(false);
                bDdateDepot.setEnabled(false);

                bResetID.setEnabled(false);
                bRechercherRDV.setEnabled(false);
                bRechercherMaladeRDV.setEnabled(false);
                bannuler.setEnabled(false);

            } else if (b == true && cEtatDemandeRDV.getSelectedItem().equals("En Attente")) {
                Reset_Demande_RDV();
                textExamenDe.setText("");
                textRemarqueDe.setText("");
            }
        }
    }//GEN-LAST:event_bAjouterDemandeRDVActionPerformed

    private void Reset_Demande_RDV() {
//        Vider les champs de la demande de rdv

        txtAdress.setText("");
        txtId_p3.setText("");
        txtInt.setText("");
        txtNom.setText("");
        txtPrenom.setText("");
        txtNumTel.setText("");

        jDateDepot.setDate(null);
        cEtatDemandeRDV.setSelectedIndex(-1);
        bAjouterDemandeRDV.setEnabled(true);
        bModifierDemandeRDV.setEnabled(false);

        bResetID.setEnabled(true);
        bRechercherRDV.setEnabled(true);
        bRechercherRDV.setEnabled(true);
        bRechercherMaladeRDV.setEnabled(true);
        bRechercherMalade.setEnabled(true);
        bannuler.setEnabled(true);

    }

    private void Reset_RDV_Pris() {
        //        Vider les champs des RDV pris
        Reset_Demande_RDV();

        cEtatDemandeRDV.setEnabled(true);
        jDateDepot.setEnabled(true);
        bResetID.setEnabled(true);
        bRechercherRDV.setEnabled(true);
        bRechercherMaladeRDV.setEnabled(true);

        bRechercherMalade.setEnabled(true);
        bRechercherMaladeRDV.setEnabled(true);
        bRechercherDemandeRDV.setEnabled(true);
        bRechercherRDV.setEnabled(true);
        bResetID.setEnabled(true);

        jDateValidation.setDate(null);
        jDateRecuperation.setDate(null);
        cEtatValidation.setSelectedIndex(-1);
        textRemarque.setText("");

        cConvontion.setSelectedIndex(-1);
        txtNomConvontion.setText("");
        Vider_Tableau_Convontion();

        jTabbedPane1.setSelectedIndex(0);
        jTabbedPane1.setEnabledAt(0, true);
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setEnabledAt(2, false);
        jTabbedPane1.setEnabledAt(3, false);

        txtId_p3.setEditable(true);
        txtInt.setEditable(true);

        textExamen.setText("");
        textRemarque.setText("");

        textExamenDe.setEditable(true);
        textRemarqueDe.setEditable(true);
        textExamenDe.setText("");
        textRemarqueDe.setText("");
        bSyntegraphie.setEnabled(true);
        bIRM.setEnabled(true);
        bDdateDepot.setEnabled(true);

    }

    private void Vider_Tableau_Convontion() {
//        Vider le Tableau de la Convontion
        DefaultTableModel model = (DefaultTableModel) tConvontion.getModel();
        while (model.getRowCount() > 0) {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.removeRow(i);
            }
        }
    }

    private void bModifierDemandeRDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModifierDemandeRDVActionPerformed
        date_depot = ((JTextField) jDateDepot.getDateEditor().getUiComponent()).getText();
        System.out.println("id demonde = " + id_demande_rdv);

        String c = "/";
        DecimalFormat myFormatter = new DecimalFormat("0000");
        String output = myFormatter.format(Integer.parseInt(txtInt.getText()));

        id_m = output + c + txtId_p3.getText();
        log.debug("id malade dans bModifier = " + id_m);

        if (cEtatDemandeRDV.getSelectedItem().equals("En Attente")) {
            JOptionPane.showMessageDialog(null, "Changer l'etat");
        } else {
            try {
                con = Connect.connect();
                String sql = "update demande_de_rdv set Etat_Demande='" + cEtatDemandeRDV.getSelectedItem()
                        + "' , RemarqueDe ='" + textRemarqueDe.getText() + "', ExamenDe = '" + textExamenDe.getText()
                        + "' WHERE id_date_depot = '" + id_demande_rdv + "' And id_m ='" + id_m + "'";

                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Update Successfully");

            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                log.error(e);
            }

            jTabbedPane1.setEnabledAt(1, true);
            jTabbedPane1.setSelectedIndex(1);
            bAjouterDemandeRDV.setEnabled(false);
            bModifierDemandeRDV.setEnabled(false);
            cEtatDemandeRDV.setEnabled(false);
            jDateDepot.setEnabled(false);
            Configurer_Partie_Malade();

            bResetID.setEnabled(false);
            bRechercherRDV.setEnabled(false);
            bRechercherMaladeRDV.setEnabled(false);
            bannuler.setEnabled(false);
        }
    }//GEN-LAST:event_bModifierDemandeRDVActionPerformed

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

    public void afficher_le_Mois_dune_anne() {
//      Cette methode Affiche tout les mois d'une annee dans tConvontion

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

//        Remplir la table tConvontion
    }

    public void Rechercher_Unite_Convontion() {
        // Recherche les information lier à la convontion à partir du Nom de la convontion Selectionnner

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
    }

    private void Rechercher_id_Demande_RDV() {
        String sql = "select id_date_depot from  demande_de_rdv where DateDepot='"
                + date_depot + "' AND id_m='" + id_m + "'";
        con = Connect.connect();

        try {
            pst = con.prepareStatement(sql);
            ResultSet rec2 = pst.executeQuery(sql);
            rec2.next();
            id_date_depot = Integer.parseInt(rec2.getString("id_date_depot"));

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

    private void Calculer_les_RDv_Pris() {
//      Cette methode Calcule les RDv Pris ou En ATTENTE Sur TOute l'année
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
    }

    private void Calculer_les_RDv_Pris_Semaine() {
        if (log.isTraceEnabled()) {
            log.trace("Debut Calculer_les_RDv_Pris_Semaine");
        }
//      Cette methode Calcule les RDv Pris ou En ATTENTE Sur TOute l'année de toute les semaine 

        int z = 0;
        for (z = 0; z < tableau_resultat_rdv_par_semaine.length; z++) {
//            initializer les valeurs du tableau afin que les valeur par default soient 0 et non "null"
            tableau_resultat_rdv_par_semaine[z] = 0;
        }

        int i = 0;
        Rechercher_Unite_Convontion();
        DecimalFormat myFormatter = new DecimalFormat("00");
        String sql = "select Etat_RDV,date_rdv, Num_semaine  from rdv where convontion_id_conv='" + id_conv + "'";
        int yearChooser2 = jYearChooser2.getYear();
//        for (int m = 1; m < 54; m++) { // calculer les rdv restant sur tout les mois le l'annee
        if (log.isDebugEnabled()) {
            log.debug("Debut Calculer_les_RDv_Pris_Semaine");
        }

        con = Connect.connect();

        DecimalFormat myFormatter3 = new DecimalFormat("00");
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
//                    String Month = myFormatter.format(m + 1);
                String yearChooser2Formater = myFormatter.format(yearChooser2);

                String Num_semaine = rst1.getString("Num_semaine");
                System.out.println("");
                log.debug("DataBase : Num_semaine = " + Num_semaine);

                boolean bsortire_Boucle = false;

                if (!(Num_semaine == "0")) {
                    log.debug("Condition : !(Num_semaine == null)");
//                    Si numero de la semaine est different de Null

                    int iNumSemaine = Integer.parseInt(Num_semaine);
                    int cmp = 0; // Compteur d'existance de la date 

                    for (i = 0; i < 53; i++) {
//                        verifier par rapport a toute les semaine d'une annee
                        log.debug("Boucle : i = " + i);

                        if (iNumSemaine == i) {
                            log.debug("Condition i = le num de la semaine");
//                            Si numero de la semaine = i

                            if ((Etat_rdv_pris.equals("Pris") || Etat_rdv_pris.equals("En Attente"))
                                    && Annee.equals(yearChooser2Formater)) {
//                      Si l'etat du RDV = Pris ou En Attente et l'annee est la méme que dans le jYearChooser alors +1
                                log.debug("Condition Pris/ En Attent & méme anné");

                                if (tableau_resultat_rdv_par_semaine[i] == 0) {
//                                    la date n'existe pas
                                    log.debug("la date n'existe pas");
                                    cmp++;
                                    log.debug("Cmp = " + cmp);
                                    tableau_resultat_rdv_par_semaine[i] = cmp;
                                } else {
//                                    la date existe 
                                    log.debug("la date existe ");
                                    int val_Tab_Sem = tableau_resultat_rdv_par_semaine[i]; // si la valeur existe la metre dans valTabSem
                                    cmp = val_Tab_Sem + 1;
                                    log.debug("Cmp = " + cmp);
                                    tableau_resultat_rdv_par_semaine[i] = cmp;
                                }

                                bsortire_Boucle = true;
                            }
                        }

                        if (bsortire_Boucle == true) {
//                            Sortire de la boucle si on trouve l'élément
                            break;
                        }
                    }
                }
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
//        }

        System.out.println("");
        log.debug("la taille : tableau_resultat_rdv_par_semaine = " + tableau_resultat_rdv_par_semaine.length);
        System.out.println("");
        log.debug("Afficher tableau_resultat_rdv_par_semaine");
        for (i = 0; i < tableau_resultat_rdv_par_semaine.length; i++) {
            log.debug("i : " + i + " = " + tableau_resultat_rdv_par_semaine[i]);
        }

        if (log.isTraceEnabled()) {
            log.trace("Fin Calculer_les_RDv_Pris_Semaine");
        }
    }

    private void Verifier_daterdv() {
//      Cette methode Verifie si la date de RDv a été Pris ou existe Sur TOute l'année

        int row = tRDVchoix1.getSelectedRow();
        DecimalFormat myFormatter = new DecimalFormat("00");
        String date_tester = tRDVchoix1.getModel().getValueAt(row, 1).toString();
        con = Connect.connect();
        String sql = "select Etat_RDV,date_rdv from rdv where date_rdv ='" + date_tester + "'";

        try {
            pst = con.prepareStatement(sql);
            ResultSet rst1 = pst.executeQuery(sql);
            if (rst1.next()) { // Compare la valeur selectioner avec la valeur rechercher dans la BDD
                String Etat_rdv_pris = rst1.getString("Etat_RDV");
                Date date_rdv_pris = rst1.getDate("date_rdv");
                DateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
                String dateFormatee = fd.format(date_rdv_pris);
                if ((Etat_rdv_pris.equals("Pris") || Etat_rdv_pris.equals("En Attente"))
                        && dateFormatee.equals(date_tester)) {
//                     si la date est prise afficher ERREUR
                    t = true;
                    JOptionPane.showMessageDialog(null, "c'est une date prise");
                }
            } else {
                t = false;
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
    }

    @SuppressWarnings("unchecked")
    public boolean Verifier_date_rdv() {
//      Cette methode Verifie si la date de RDv a été Pris ou existe Sur TOute l'année 
//        et affiche un message d'erreur si l'utilisateur choisit une date prise

        Rechercher_Unite_Convontion();
        boolean verificateur_unite = Verification_par_unite_convontion();

        int row = tRDVchoix1.getSelectedRow();
        ArrayList date = new ArrayList(); // tableau de ma date
        ArrayList etat = new ArrayList(); // tableau des etat des date
        boolean h = false; // etat des date

        if (verificateur_unite == true) {
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
        }
        return h;
    }

    @SuppressWarnings("unchecked")
    private boolean Verifier_date_rdv_colorier(String date_rdv_tableau) {
//      Cette methode Verifie si la date de RDv a été Pris ou existe Sur TOute l'année
//        puis elle colorie le tableau

        if (log.isTraceEnabled()) {
            log.trace("Debut Verifier_date_rdv_colorier");
        }

        boolean h = false; // l'etat du RDV

        Rechercher_Unite_Convontion();

        ArrayList date = new ArrayList(); // tableau des date
        ArrayList etat = new ArrayList(); // tableau des etat des date

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

        if (log.isTraceEnabled()) {
            log.trace("Fin Verifier_date_rdv_colorier");
        }
        return h;
    }

    private boolean Verification_par_unite_convontion() {
        // Verifie si l'unite = Mois et desactive la verification de la date prise par click ou par couleur

        Rechercher_Unite_Convontion();

        boolean verificateur_unite = false;

        if (unite_c.equals("Mois")) {
            verificateur_unite = false;
            if (log.isDebugEnabled()) {
                log.debug("Mois : verificateur_unite = false;");
            }
        } else if (unite_c.equals("Semaine")) {
            verificateur_unite = true;
            if (log.isDebugEnabled()) {
                log.debug("Semaine : verificateur_unite = false;");
            }
        } else if (unite_c.equals("Jours")) {
            verificateur_unite = true;
            if (log.isDebugEnabled()) {
                log.debug("Jours : verificateur_unite = false;");
            }
        }

        return verificateur_unite;
    }

    private void bAjouterValidationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAjouterValidationActionPerformed
        log.trace("Debut bAjouterValidationActiodnPerformed");

        log.debug("vSemaine = " + vNumSemaine);
//        if(!(unite_c.equals("semaine"))){
//            vNumSemaine = null;
//        }

        boolean b = false;
        if (((JTextField) jDateValidation.getDateEditor().getUiComponent()).getText().equals("")) {
            // Si les champs sont vides afficher un message d'erreur
            JOptionPane.showMessageDialog(null, "Rempliser la Date Valide du RDV et son l'etat");

        } else {
            if (unite_c.equals("Semaine")) {
                if (cEtatValidation.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "l'etat du RDV n'a pas était choisit");
                } else if (!(((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText().equals(""))
                        && !(textRemarque.getText().equals("")) && !(textExamen.getText().equals(""))) {
                    // Inserer la date de rdv pris si les 4 champs sont remplit
                    log.debug("bAjouterValidationActionPerformed Condition SEM 01");
                    try {
                        Rechercher_id_Demande_RDV(); // id_m et id_date_depot
                        Rechercher_Unite_Convontion(); // id_p et id_c

                        con = Connect.connect();
                        String sql2 = "insert into rdv (date_rdv, id_date_depot, id_m, Etat_RDV, convontion_id_conv,"
                                + " convontion_partenaire_id_p, Remarque, date_recuperation, examen , Num_semaine) values ('"
                                + ((JTextField) jDateValidation.getDateEditor().getUiComponent()).getText()
                                + "','" + id_date_depot + "','" + id_m + "','" + cEtatValidation.getSelectedItem() + "','"
                                + id_conv + "','" + id_p + "','" + textRemarque.getText() + "','"
                                + ((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText()
                                + "','" + textExamen.getText() + "','" + vNumSemaine + "')";
                        pst = con.prepareStatement(sql2);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Ok");
                        b = true;

                    } catch (SQLException | HeadlessException e) {
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

                } else if (((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText().equals("")
                        && !(textRemarque.getText().equals("")) && !(textExamen.getText().equals(""))) {
                    // Inserer la date de rdv pris si la date de recuperation est vide et la Remarque est Remplit

                    log.debug("bAjouterValidationActionPerformed Condition SEM 02");
                    try {
                        Rechercher_id_Demande_RDV(); // id_m et id_date_depot
                        Rechercher_Unite_Convontion(); // id_p et id_c

                        con = Connect.connect();
                        String sql2 = "insert into rdv (date_rdv, id_date_depot, id_m, Etat_RDV,"
                                + " convontion_id_conv, convontion_partenaire_id_p, "
                                + "Remarque, examen , Num_semaine) values ('"
                                + ((JTextField) jDateValidation.getDateEditor().getUiComponent()).getText()
                                + "','" + id_date_depot + "','" + id_m + "','" + cEtatValidation.getSelectedItem() + "','"
                                + id_conv + "','" + id_p + "','" + textRemarque.getText()
                                + "','" + textExamen.getText() + "','" + vNumSemaine + "')";
                        pst = con.prepareStatement(sql2);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Ok");
                        b = true;
                    } catch (SQLException | HeadlessException e) {
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
                } else if (!(((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText().equals(""))
                        && !(textRemarque.getText().equals("")) && textExamen.getText().equals("")) {
                    // Inserer la date de rdv pris si la date de recuperation est Remplit 
//            et la Remarque est remplie et l'examen est vide
                    log.debug("bAjouterValidationActionPerformed Condition SEM 03");
                    try {
                        Rechercher_id_Demande_RDV(); // id_m et id_date_depot
                        Rechercher_Unite_Convontion(); // id_p et id_c

                        con = Connect.connect();
                        String sql2 = "insert into rdv (date_rdv, id_date_depot, id_m, Etat_RDV, "
                                + "convontion_id_conv, convontion_partenaire_id_p, "
                                + "date_recuperation, Remarque , Num_semaine) values ('"
                                + ((JTextField) jDateValidation.getDateEditor().getUiComponent()).getText()
                                + "','" + id_date_depot + "','" + id_m + "','"
                                + cEtatValidation.getSelectedItem() + "','"
                                + id_conv + "','" + id_p + "','"
                                + ((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText()
                                + "','" + textRemarque.getText() + "','" + vNumSemaine + "')";
                        pst = con.prepareStatement(sql2);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Ok");
                        b = true;
                    } catch (SQLException | HeadlessException e) {
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
                } else if (((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText().equals("")
                        && !(textRemarque.getText().equals("")) && textExamen.getText().equals("")) {
                    // Inserer la date de rdv pris si la date de recuperation est vide et la Remarque est Remplit
                    log.debug("bAjouterValidationActionPerformed Condition SEM 04");
                    try {
                        Rechercher_id_Demande_RDV(); // id_m et id_date_depot
                        Rechercher_Unite_Convontion(); // id_p et id_c

                        con = Connect.connect();
                        String sql2 = "insert into rdv (date_rdv, id_date_depot, id_m, Etat_RDV,"
                                + " convontion_id_conv, convontion_partenaire_id_p, "
                                + "Remarque , Num_semaine) values ('"
                                + ((JTextField) jDateValidation.getDateEditor().getUiComponent()).getText()
                                + "','" + id_date_depot + "','" + id_m + "','" + cEtatValidation.getSelectedItem() + "','"
                                + id_conv + "','" + id_p + "','" + textRemarque.getText() + "','" + vNumSemaine + "')";
                        pst = con.prepareStatement(sql2);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Ok");
                        b = true;
                    } catch (SQLException | HeadlessException e) {
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
                } else if (((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText().equals("")
                        && textRemarque.getText().equals("") && textExamen.getText().equals("")) {
                    // Inserer la date de rdv pris si la date de recuperation est Remplit 
//            et la Remarque et l'examen sont vide
                    log.debug("bAjouterValidationActionPerformed Condition SEM 05");
                    try {
                        Rechercher_id_Demande_RDV(); // id_m et id_date_depot
                        Rechercher_Unite_Convontion(); // id_p et id_c
                        log.trace("les valeure avant l'ajout ");
                        log.debug("id date depot = " + id_date_depot
                                + " / id malade = +" + id_m
                                + "/ id convontion =" + id_conv
                                + " / Etat de validation = " + cEtatValidation.getSelectedItem()
                                + " / id partenaire = " + id_p
                                + " / date de validation = " + ((JTextField) jDateValidation.getDateEditor().getUiComponent()).getText());

                        con = Connect.connect();
                        String sql2 = "insert into rdv (date_rdv, id_date_depot, id_m, Etat_RDV, "
                                + "convontion_id_conv, convontion_partenaire_id_p , Num_semaine) values ('"
                                + ((JTextField) jDateValidation.getDateEditor().getUiComponent()).getText()
                                + "','" + id_date_depot + "','" + id_m + "','"
                                + cEtatValidation.getSelectedItem() + "','"
                                + id_conv + "','" + id_p + "','" + vNumSemaine + "')";
                        pst = con.prepareStatement(sql2);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Ok");
                        b = true;
                    } catch (SQLException | HeadlessException e) {
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
                } else if (textRemarque.getText().equals("") && textExamen.getText().equals("")) {
                    // Inserer la date de rdv pris si la date de recuperation est Remplit 
//            et la Remarque et l'examen sont vide
                    log.debug("bAjouterValidationActionPerformed Condition SEM 06");
                    try {
                        Rechercher_id_Demande_RDV(); // id_m et id_date_depot
                        Rechercher_Unite_Convontion(); // id_p et id_c

                        con = Connect.connect();
                        String sql2 = "insert into rdv (date_rdv, id_date_depot, id_m, Etat_RDV, "
                                + "convontion_id_conv, convontion_partenaire_id_p, "
                                + "date_recuperation , Num_semaine) values ('"
                                + ((JTextField) jDateValidation.getDateEditor().getUiComponent()).getText()
                                + "','" + id_date_depot + "','" + id_m + "','"
                                + cEtatValidation.getSelectedItem() + "','"
                                + id_conv + "','" + id_p + "','"
                                + ((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText()
                                + "','" + vNumSemaine + "')";
                        pst = con.prepareStatement(sql2);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Ok");
                        b = true;
                    } catch (SQLException | HeadlessException e) {
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
                } else if (!(((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText().equals(""))
                        && textRemarque.getText().equals("") && !(textExamen.getText().equals(""))) {
                    // Inserer la date de rdv pris si les 4 champs sont remplit
                    log.debug("bAjouterValidationActionPerformed Condition SEM 07");
                    try {
                        Rechercher_id_Demande_RDV(); // id_m et id_date_depot
                        Rechercher_Unite_Convontion(); // id_p et id_c

                        con = Connect.connect();
                        String sql2 = "insert into rdv (date_rdv, id_date_depot, id_m, Etat_RDV, convontion_id_conv,"
                                + " convontion_partenaire_id_p,  date_recuperation, examen , Num_semaine) values ('"
                                + ((JTextField) jDateValidation.getDateEditor().getUiComponent()).getText()
                                + "','" + id_date_depot + "','" + id_m + "','" + cEtatValidation.getSelectedItem() + "','"
                                + id_conv + "','" + id_p + "','" + ((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText()
                                + "','" + textExamen.getText() + "','" + vNumSemaine + "')";
                        pst = con.prepareStatement(sql2);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Ok");
                        b = true;

                    } catch (SQLException | HeadlessException e) {
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

                if (b == true) {
                    Reset_RDV_Pris();
                    bannuler.setEnabled(true);
                }

                log.trace("Fin bAjouterValidationActionPerformed");

            } else {
                if (cEtatValidation.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "l'etat du RDV n'a pas était choisit");
                } else if (!(((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText().equals(""))
                        && !(textRemarque.getText().equals("")) && !(textExamen.getText().equals(""))) {
                    // Inserer la date de rdv pris si les 4 champs sont remplit
                    log.debug("bAjouterValidationActionPerformed Condition 01");
                    try {
                        Rechercher_id_Demande_RDV(); // id_m et id_date_depot
                        Rechercher_Unite_Convontion(); // id_p et id_c

                        con = Connect.connect();
                        String sql2 = "insert into rdv (date_rdv, id_date_depot, id_m, Etat_RDV, convontion_id_conv,"
                                + " convontion_partenaire_id_p, Remarque, date_recuperation, examen) values ('"
                                + ((JTextField) jDateValidation.getDateEditor().getUiComponent()).getText()
                                + "','" + id_date_depot + "','" + id_m + "','" + cEtatValidation.getSelectedItem() + "','"
                                + id_conv + "','" + id_p + "','" + textRemarque.getText() + "','"
                                + ((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText()
                                + "','" + textExamen.getText() + "')";
                        pst = con.prepareStatement(sql2);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Ok");
                        b = true;

                    } catch (SQLException | HeadlessException e) {
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

                } else if (((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText().equals("")
                        && !(textRemarque.getText().equals("")) && !(textExamen.getText().equals(""))) {
                    // Inserer la date de rdv pris si la date de recuperation est vide et la Remarque est Remplit

                    log.debug("bAjouterValidationActionPerformed Condition 02");
                    try {
                        Rechercher_id_Demande_RDV(); // id_m et id_date_depot
                        Rechercher_Unite_Convontion(); // id_p et id_c

                        con = Connect.connect();
                        String sql2 = "insert into rdv (date_rdv, id_date_depot, id_m, Etat_RDV,"
                                + " convontion_id_conv, convontion_partenaire_id_p, "
                                + "Remarque, examen) values ('"
                                + ((JTextField) jDateValidation.getDateEditor().getUiComponent()).getText()
                                + "','" + id_date_depot + "','" + id_m + "','" + cEtatValidation.getSelectedItem() + "','"
                                + id_conv + "','" + id_p + "','" + textRemarque.getText()
                                + "','" + textExamen.getText() + "')";
                        pst = con.prepareStatement(sql2);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Ok");
                        b = true;
                    } catch (SQLException | HeadlessException e) {
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
                } else if (!(((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText().equals(""))
                        && !(textRemarque.getText().equals("")) && textExamen.getText().equals("")) {
                    // Inserer la date de rdv pris si la date de recuperation est Remplit 
//            et la Remarque est remplie et l'examen est vide
                    log.debug("bAjouterValidationActionPerformed Condition 03");
                    try {
                        Rechercher_id_Demande_RDV(); // id_m et id_date_depot
                        Rechercher_Unite_Convontion(); // id_p et id_c

                        con = Connect.connect();
                        String sql2 = "insert into rdv (date_rdv, id_date_depot, id_m, Etat_RDV, "
                                + "convontion_id_conv, convontion_partenaire_id_p, "
                                + "date_recuperation, Remarque) values ('"
                                + ((JTextField) jDateValidation.getDateEditor().getUiComponent()).getText()
                                + "','" + id_date_depot + "','" + id_m + "','"
                                + cEtatValidation.getSelectedItem() + "','"
                                + id_conv + "','" + id_p + "','"
                                + ((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText()
                                + "','" + textRemarque.getText() + "')";
                        pst = con.prepareStatement(sql2);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Ok");
                        b = true;
                    } catch (SQLException | HeadlessException e) {
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
                } else if (((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText().equals("")
                        && !(textRemarque.getText().equals("")) && textExamen.getText().equals("")) {
                    // Inserer la date de rdv pris si la date de recuperation est vide et la Remarque est Remplit
                    log.debug("bAjouterValidationActionPerformed Condition 04");
                    try {
                        Rechercher_id_Demande_RDV(); // id_m et id_date_depot
                        Rechercher_Unite_Convontion(); // id_p et id_c

                        con = Connect.connect();
                        String sql2 = "insert into rdv (date_rdv, id_date_depot, id_m, Etat_RDV,"
                                + " convontion_id_conv, convontion_partenaire_id_p, "
                                + "Remarque) values ('"
                                + ((JTextField) jDateValidation.getDateEditor().getUiComponent()).getText()
                                + "','" + id_date_depot + "','" + id_m + "','" + cEtatValidation.getSelectedItem() + "','"
                                + id_conv + "','" + id_p + "','" + textRemarque.getText() + "')";
                        pst = con.prepareStatement(sql2);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Ok");
                        b = true;
                    } catch (SQLException | HeadlessException e) {
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
                } else if (((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText().equals("")
                        && textRemarque.getText().equals("") && textExamen.getText().equals("")) {
                    // Inserer la date de rdv pris si la date de recuperation est Remplit 
//            et la Remarque et l'examen sont vide
                    log.debug("bAjouterValidationActionPerformed Condition 05");
                    try {
                        Rechercher_id_Demande_RDV(); // id_m et id_date_depot
                        Rechercher_Unite_Convontion(); // id_p et id_c
                        log.trace("les valeure avant l'ajout ");
                        log.debug("id date depot = " + id_date_depot
                                + " / id malade = +" + id_m
                                + "/ id convontion =" + id_conv
                                + " / Etat de validation = " + cEtatValidation.getSelectedItem()
                                + " / id partenaire = " + id_p
                                + " / date de validation = " + ((JTextField) jDateValidation.getDateEditor().getUiComponent()).getText());

                        con = Connect.connect();
                        String sql2 = "insert into rdv (date_rdv, id_date_depot, id_m, Etat_RDV, "
                                + "convontion_id_conv, convontion_partenaire_id_p) values ('"
                                + ((JTextField) jDateValidation.getDateEditor().getUiComponent()).getText()
                                + "','" + id_date_depot + "','" + id_m + "','"
                                + cEtatValidation.getSelectedItem() + "','"
                                + id_conv + "','" + id_p + "')";
                        pst = con.prepareStatement(sql2);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Ok");
                        b = true;
                    } catch (SQLException | HeadlessException e) {
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
                } else if (textRemarque.getText().equals("") && textExamen.getText().equals("")) {
                    // Inserer la date de rdv pris si la date de recuperation est Remplit 
//            et la Remarque et l'examen sont vide
                    log.debug("bAjouterValidationActionPerformed Condition 06");
                    try {
                        Rechercher_id_Demande_RDV(); // id_m et id_date_depot
                        Rechercher_Unite_Convontion(); // id_p et id_c

                        con = Connect.connect();
                        String sql2 = "insert into rdv (date_rdv, id_date_depot, id_m, Etat_RDV, "
                                + "convontion_id_conv, convontion_partenaire_id_p, "
                                + "date_recuperation) values ('"
                                + ((JTextField) jDateValidation.getDateEditor().getUiComponent()).getText()
                                + "','" + id_date_depot + "','" + id_m + "','"
                                + cEtatValidation.getSelectedItem() + "','"
                                + id_conv + "','" + id_p + "','"
                                + ((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText()
                                + "')";
                        pst = con.prepareStatement(sql2);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Ok");
                        b = true;
                    } catch (SQLException | HeadlessException e) {
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
                } else if (!(((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText().equals(""))
                        && textRemarque.getText().equals("") && !(textExamen.getText().equals(""))) {
                    // Inserer la date de rdv pris si les 4 champs sont remplit
                    log.debug("bAjouterValidationActionPerformed Condition 07");
                    try {
                        Rechercher_id_Demande_RDV(); // id_m et id_date_depot
                        Rechercher_Unite_Convontion(); // id_p et id_c

                        con = Connect.connect();
                        String sql2 = "insert into rdv (date_rdv, id_date_depot, id_m, Etat_RDV, convontion_id_conv,"
                                + " convontion_partenaire_id_p,  date_recuperation, examen) values ('"
                                + ((JTextField) jDateValidation.getDateEditor().getUiComponent()).getText()
                                + "','" + id_date_depot + "','" + id_m + "','" + cEtatValidation.getSelectedItem() + "','"
                                + id_conv + "','" + id_p + "','" + ((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText()
                                + "','" + textExamen.getText() + "')";
                        pst = con.prepareStatement(sql2);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Ok");
                        b = true;

                    } catch (SQLException | HeadlessException e) {
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

                if (b == true) {
                    Reset_RDV_Pris();
                    bannuler.setEnabled(true);
                }

                log.trace("Fin bAjouterValidationActionPerformed");
            }
        }
    }//GEN-LAST:event_bAjouterValidationActionPerformed

    private void bRechercherCotaParMoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechercherCotaParMoisActionPerformed
        try {
            afficher_la_date_dun_mois();

        } catch (ParseException ex) {
            log.error("Erreure ", ex);
        }


    }//GEN-LAST:event_bRechercherCotaParMoisActionPerformed

    private void cConvontionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cConvontionActionPerformed
        String a = (String) cConvontion.getSelectedItem();
        txtNomConvontion.setText(a);
        txtNomConvontion.setEditable(false);
    }//GEN-LAST:event_cConvontionActionPerformed

    private void cConvontionPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cConvontionPopupMenuWillBecomeInvisible
        Rechercher_Unite_Convontion();
    }//GEN-LAST:event_cConvontionPopupMenuWillBecomeInvisible

    private void tRDVchoix1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tRDVchoix1MouseClicked
//        Envoie de la Date du TABLEAU "Choisir une Date" à "Validation RDV"

        boolean v;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        int row = tRDVchoix1.getSelectedRow();
        String n = tRDVchoix1.getModel().getValueAt(row, 1).toString();
        String nomJour = tRDVchoix1.getModel().getValueAt(row, 0).toString();

        // diviser la date de debut  
        String AnneeSelected = n.substring(0, 4);
        int iAnneeSelected = Integer.parseInt(AnneeSelected);

        String MoisSelected = n.substring(5, 7);
        int iMoisSelected = Integer.parseInt(MoisSelected);

        String JoursSelected = n.substring(8, 10);
        int iJoursSelected = Integer.parseInt(JoursSelected);

        String MoisActuel = Verification_de_Mois_actuel();
        int iMoisActuel = Integer.parseInt(MoisActuel);

        String AnneeActuel = Verification_de_annee_actuel();
        int iAnneeActuel = Integer.parseInt(AnneeActuel);

        String JoursActuel = Verification_de_Jours_actuel();
        int iJourActuel = Integer.parseInt(JoursActuel);

        boolean etat_Jous = false;

        if (iAnneeSelected == iAnneeActuel) {
            log.debug("iAnnee == iAnneeActuel");
            if (iMoisSelected == iMoisActuel) {
                log.debug("iMois == iMoisActuel");
                if (iJoursSelected == iJourActuel || iJoursSelected > iJourActuel) {
                    etat_Jous = true;
                }
            } else if (iMoisSelected > iMoisActuel) {
                log.debug("iMois > iMoisActuel");
                etat_Jous = true;
            } else {
                JOptionPane.showMessageDialog(null, "Verifier le mois");
            }
        } else if (iAnneeSelected > iAnneeActuel) {
            log.debug("il n'est pas nesséssaire de verifier l'etat du mois ");
            etat_Jous = true;
        } else {
            JOptionPane.showMessageDialog(null, "Verifier l'annee");
        }

        if (etat_Jous == true) {

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
                        jDateValidation.setDate(dateValidation);
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

                    if (v == true) {
                        // Débloquer les autres anglets et affecter la date prise
//                    System.out.println("Table if v =" + v);
                        jTabbedPane1.setEnabledAt(3, true);
                        jTabbedPane1.setSelectedIndex(3);

                        jDateValidation.setEnabled(false);
                        bAjouterValidation.setEnabled(true);
                        bModifierValidation.setEnabled(false);
                    } else {
//                    System.out.println("Table Erreur");
                        JOptionPane.showMessageDialog(null, "Erreur");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "c'est une date prise");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "La date Choisit est inferieure a la date actuel");
        }

    }//GEN-LAST:event_tRDVchoix1MouseClicked
    private void bRechercherCotaParAnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechercherCotaParAnsActionPerformed

        String anneActuel = Verification_de_annee_actuel();
        int ianneActuel = Integer.parseInt(anneActuel);
        int anneeJyearChooser = jYearChooser2.getYear();

        if (anneeJyearChooser == ianneActuel || anneeJyearChooser > ianneActuel) {
            log.debug("l'anne est = ou > a lannee actuel ");
            bRechercherCota();
        } else {
            JOptionPane.showMessageDialog(null, "Corriger l'annee de la convontion");
        }


    }//GEN-LAST:event_bRechercherCotaParAnsActionPerformed

    private String Verification_de_annee_actuel() {
        // Verifie si la date
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        log.debug("la date (Date) = " + dateFormat.format(date));

        String reportDate = dateFormat.format(date);
        log.debug("la date (String) = " + reportDate);
        return reportDate;

    }

    private String Verification_de_Mois_actuel() {
        // Verifie si la date
        DateFormat dateFormat = new SimpleDateFormat("MM");
        Date date = new Date();
        log.debug("la date (Date) = " + dateFormat.format(date));

        String reportDate = dateFormat.format(date);
        log.debug("la date (String) = " + reportDate);
        return reportDate;

    }

    private String Verification_de_Jours_actuel() {
        // Verifie si la date
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date = new Date();
        log.debug("la date (Date) = " + dateFormat.format(date));

        String reportDate = dateFormat.format(date);
        log.debug("la date (String) = " + reportDate);
        return reportDate;

    }

    private String Verification_de_Date_actuel() {
        // Verifie si la date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        log.debug("la date (Date) = " + dateFormat.format(date));

        String reportDate = dateFormat.format(date);
        log.debug("la date (String) = " + reportDate);
        return reportDate;

    }

    public void bRechercherCota() {
        if (log.isTraceEnabled()) {
            log.trace("Debut bRechercherCotaParAnsActionPerformed");
        }

        n = new Convontion_Semaine();
        if (cConvontion.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "La Convontion est vide");
        } else {

            Rechercher_Unite_Convontion();
            if (log.isDebugEnabled()) {
                log.debug("bRechercherCotaParAnsActionPerformed :unite_c = " + unite_c);
            }

            if ("Semaine".equals(unite_c)) {
                if (log.isDebugEnabled()) {
                    log.debug("Si semaine = " + unite_c);
                }

                int k = 0;
                int anneeJyearChooser = jYearChooser2.getYear();
                try {

                    for (k = 0; k < 12; k++) {
                        n.afficher_la_date_dun_mois_ameliorer(k, anneeJyearChooser);
                    }
                    n.Calculer_sam_dim_annee();
                    Afficher_la_liste_des_semaines();
                    bTypeSemaine = true;
                } catch (ParseException ex) {
                    java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (log.isDebugEnabled()) {
                    log.debug("Else ");
                }
                afficher_le_Mois_dune_anne();
            }
        }

        if (log.isTraceEnabled()) {
            log.trace("Fin bRechercherCotaParAnsActionPerformed");
        }
    }

    ////////////////////////////////////////
    public void Afficher_la_liste_des_semaines() {
//              Ajouter et Afficher l'ordre de la semaine au tableau

        if (log.isTraceEnabled()) {
            log.trace("Debut Afficher_la_liste_des_semaines");
        }

        int m = 0;
        int a = 0;

        Calculer_les_RDv_Pris_Semaine();

        DefaultTableModel md = new DefaultTableModel();
        md.setColumnIdentifiers(new String[]{"Numéro Semaine", "Dimanche", "Samedi", "Quantite"});

        int quantite_par_unite = Integer.parseInt(nbr_RDv);
        log.debug("quantite_par_unite = " + nbr_RDv);
        log.debug("Taille Dimanche = " + n.aDimanche.size());
        log.debug("Taille Samedi = " + n.aSamedi.size());

        int i = 0;
        log.debug("Afficher tableau_resultat_rdv_par_semaine");
        log.debug("Taille de tableau_resultat_rdv_par_semaine =" + tableau_resultat_rdv_par_semaine.length);

        for (i = 0; i < tableau_resultat_rdv_par_semaine.length; i++) {
            log.debug("i : " + i + " = " + tableau_resultat_rdv_par_semaine[i] + " Dimanche = " + n.aDimanche.get(i));
        }

        for (int l = 0; l < n.aDimanche.size(); l++) {
//            afficher la liste des semaines (debut et fin)
            a = a + 1;
            int nbrRdv_unite = Integer.parseInt(nbr_RDv);
            int quantite_restante_rdv = 0;

            log.debug(" tableau_resultat_rdv_par_semaine[l = " + l + " ]  " + tableau_resultat_rdv_par_semaine[l]);
            int vTableau_resultat_rdv_par_semaine = tableau_resultat_rdv_par_semaine[l];

            if (vTableau_resultat_rdv_par_semaine == 0) {
//                Si la quantite prise est = 0

                log.debug("la valeur du tableau  = 0");
                quantite_restante_rdv = 0;
            } else {
//                Si la quantite prise est != 0

                log.debug("la valeur du tableau  != 0");
                quantite_restante_rdv = tableau_resultat_rdv_par_semaine[l];
            }

            log.debug("nbrRdv_unite = " + nbrRdv_unite);
            quantite_restante_rdv = nbrRdv_unite - quantite_restante_rdv;
            int u = 0;
            u = u + 1;
            md.addRow(new Object[]{a, n.aDimanche.get(l), n.aSamedi.get(l), quantite_restante_rdv});  // Ajouter les variables à la ligne du tableau
            System.out.println("");
//            String squantite_restante_rdv = Integer.toString(quantite_restante_rdv);
        }

        tConvontion.setModel(md);

        if (log.isTraceEnabled()) {
            log.trace("Fin Afficher_la_liste_des_semaines");
        }
    }
    ///////////////////////////////////////

    private void tConvontionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tConvontionMouseClicked
        boolean bDebloqueAnglet = false; // boolean pour les anglet

        Rechercher_Unite_Convontion();
        boolean f = false;
        if ("Semaine".equals(unite_c)) {
            f = true;
        } else {
            f = false;
        }

        log.debug("bTypeSemaine = " + bTypeSemaine);
        if (f == true) {
//            pour "Semaine"

            log.trace("Debut tRDVchoix1MouseClicked");

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            int row = tConvontion.getSelectedRow();
            String vDimanche = tConvontion.getModel().getValueAt(row, 1).toString();
            String vSamedi = tConvontion.getModel().getValueAt(row, 2).toString();
            vNumSemaine = tConvontion.getModel().getValueAt(row, 0).toString();
            String quantite_semaine = tConvontion.getModel().getValueAt(row, 3).toString();

            boolean b53 = false;

            // diviser la date de debut  
            String AnneeDimanche = vDimanche.substring(0, 4);
//        log.debug(AnneeDimanche);
// diviser la date de debut  
            String AnneeSamedi = vSamedi.substring(0, 4);
//        log.debug(AnneeSamedi);

            if (vNumSemaine.equals("53") && !(AnneeDimanche.equals(AnneeSamedi))) {
                JOptionPane.showMessageDialog(null, "Selectioner cette date dans le calendrier de la nouvelle annee");
            } else {
                if (quantite_semaine.equals("0")) { // Si Num sem = Vendredi alors ERREUR
                    JOptionPane.showMessageDialog(null, "La Quantite = 0");
                } else {

//            les tableau et les array list commence par 0 
                    int zz = Integer.parseInt(vNumSemaine);
                    zz = zz - 1;
                    vNumSemaine = Integer.toString(zz);

                    Remplir_detail_date_tableau n = new Remplir_detail_date_tableau(vSamedi, vDimanche);

                    ArrayList z;
                    z = n.getArJour();  // récuperer les valeurs de la liste 
                    try {
                        Afficher_details_semaine(z);
                        bDebloqueAnglet = true;
                    } catch (ParseException ex) {
                        Logger.getLogger(NewJFrame1.class.getName()).log(null, ex);
                    }
                    f = false;
                }
            }

            log.trace("Fin tRDVchoix1MouseClicked");

        } else {
            //            pour "Jours" et "Mois"
            log.trace("Debut tRDVchoix1MouseClicked else");
            int row = tConvontion.getSelectedRow();
            String Mois = tConvontion.getModel().getValueAt(row, 0).toString();
            String Annee = tConvontion.getModel().getValueAt(row, 1).toString();
            String quantite_rdv = tConvontion.getModel().getValueAt(row, 2).toString();
            jYearChooser1.setYear(Integer.parseInt(Annee));
            int Month = Integer.parseInt(Mois) - 1;
            jMonthChooser1.setMonth(Month);

            int iMois = Integer.parseInt(Mois);
            String MoisActuel = Verification_de_Mois_actuel();
            int iMoisActuel = Integer.parseInt(MoisActuel);

            int iAnnee = Integer.parseInt(Annee);
            String AnneeActuel = Verification_de_annee_actuel();
            int iAnneeActuel = Integer.parseInt(AnneeActuel);

            boolean etat_Mois = false;

            if (iAnnee == iAnneeActuel) {
                log.debug("iAnnee == iAnneeActuel");
                if (iMois == iMoisActuel || iMois > iMoisActuel) {
                    log.debug("iMois == iMoisActuel  || iMois > iMoisActuel");
                    etat_Mois = true;
                }
            } else if (iAnnee > iAnneeActuel) {
                log.debug("il n'est pas nesséssaire de verifier l'etat du mois ");
                etat_Mois = true;
            }

            if (etat_Mois == true) {
                if (Integer.parseInt(quantite_rdv) == 0) {  // Si quantite de RDV = 0 alors ERREUR
                    JOptionPane.showMessageDialog(null, "Erreur: La Quantite est = 0. ");
                } else {
                    try {
                        afficher_la_date_dun_mois();
                        bDebloqueAnglet = true;
                    } catch (ParseException ex) {
                        log.error(ex);
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
            } else {
                JOptionPane.showMessageDialog(null, "Le mois selectionner est inferieure au mois actuelle ");
            }
        }
        if (bDebloqueAnglet == true) { // Debloquer les autres anglets
            jTabbedPane1.setEnabledAt(2, true);
            jTabbedPane1.setSelectedIndex(2);
        }
//        else {
//            JOptionPane.showMessageDialog(null, "Erreur");
//        }
    }//GEN-LAST:event_tConvontionMouseClicked

    public void Afficher_details_semaine(ArrayList q) throws ParseException {
//              Ajouter et Afficher l'ordre de la semaine au tableau pour "Semaine"

        DefaultTableModel md = new DefaultTableModel();
        md.setColumnIdentifiers(new String[]{"Nom", "Jours"});

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for (int l = 0; l < q.size(); l++) {
//            afficher la liste des semaines (debut et fin)

            String n = (String) q.get(l);

            Date dateValidation = formatter.parse(n);
            md.addRow(new Object[]{new SimpleDateFormat("EEEE").format(dateValidation), q.get(l)});  // Ajouter les variables à la ligne du tableau
        }

        tRDVchoix1.setModel(md);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        ConsulterConvontionRDV s = new ConsulterConvontionRDV();
        s.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        Cancel();
    }//GEN-LAST:event_bCancelActionPerformed

    private void bModifierValidationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModifierValidationActionPerformed
        log.trace("Debut");
        log.debug("cEtatValidation = " + cEtatValidation.getSelectedIndex());
        boolean b = false;
        if (cEtatValidation.getSelectedIndex() == -1) {
            log.trace("cEtatValidation.getSelectedIndex() == -1");
            JOptionPane.showMessageDialog(null, "l'etat du RDV n'a pas était choisit");
        } else {
            if ((cEtatValidation.getSelectedIndex() == 2)
                    && (((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText().equals(""))) {
                log.trace("etat Pris et date recupe Vide");
                JOptionPane.showMessageDialog(null, "la Date du RDV doit étre remplit");
                log.debug("cEtatValidation = " + cEtatValidation.getSelectedIndex());
                log.debug("jDateRecuperation = " + ((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText());
            } else {
                if ((cEtatValidation.getSelectedIndex() == 2)
                        && (!((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText().equals(""))) {
                    log.trace("cEtatValidation Pris // jDateRecuperation Non Vide");
                    int val = JOptionPane.showConfirmDialog(null, "Voulez vous modifier ?");
                    if (val == 0) {
                        try {
                            log.debug("Id_RDV = " + id_rdv);
                            log.debug("date_recuperation = " + ((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText());
                            con = Connect.connect();
                            String sql = "update rdv set examen='" + textExamen.getText()
                                    + "',Etat_RDV='" + cEtatValidation.getSelectedItem()
                                    + "',Remarque='" + textRemarque.getText()
                                    + "',date_recuperation = '" + ((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText()
                                    + "' WHERE id_RDV='" + id_rdv + "'";

                            pst = con.prepareStatement(sql);
                            pst.execute();
                            JOptionPane.showMessageDialog(null, "Update Successfully");
                            b = true;
//                             reset();

                        } catch (HeadlessException | SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                            log.error(e);
                        }
                        log.trace("Fin cEtatValidation Pris // jDateRecuperation Non Vide");
                    }
                } else {
                    log.trace("Je C PA");
                    int val1 = JOptionPane.showConfirmDialog(null, "Voulez vous modifier ?");
                    if (val1 == 0) {
                        log.debug("jDateRecuperation = " + ((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText());
                        jDateRecuperation.setDate(null);
                        log.debug("jDateRecuperation = " + ((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText());
                        try {
                            log.debug("Id_RDV = " + id_rdv);
                            log.debug("date_recuperation = " + ((JTextField) jDateRecuperation.getDateEditor().getUiComponent()).getText());
                            con = Connect.connect();
                            String sql = "update rdv set examen='" + textExamen.getText()
                                    + "',Etat_RDV='" + cEtatValidation.getSelectedItem()
                                    + "',Remarque='" + textRemarque.getText()
                                    + "' WHERE id_RDV='" + id_rdv + "'";

                            pst = con.prepareStatement(sql);
                            pst.execute();
                            JOptionPane.showMessageDialog(null, "Update Successfully");
                            b = true;
                            // reset();

                        } catch (HeadlessException | SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                            log.error(e);
                        }
                    }

                    log.trace("FIN");
                }
            }
        }
        if (b == true) {
            Reset_RDV_Pris();
            bannuler.setEnabled(true);
        }
    }//GEN-LAST:event_bModifierValidationActionPerformed

    private void Configurer_Partie_Malade() {
        // Cette methode cofigure la partie Malade apres avoir Ajouter une demande de RDV

        bRechercherMalade.setEnabled(false);
        bRechercherMaladeRDV.setEnabled(false);
        bRechercherRDV.setEnabled(false);
        bRechercherDemandeRDV.setEnabled(false);
        bResetID.setEnabled(false);

        txtId_p3.setEditable(false);
        txtInt.setEditable(false);
    }

    private void bRechercherMaladeRDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechercherMaladeRDVActionPerformed
        log.trace("DEBUT bRechercherMaladeRDVActionPerformed ");
        this.dispose();
        RechercherMaladeRDV s = new RechercherMaladeRDV();
        log.debug("id Admin = " + id);
        s.id = id;
        s.setVisible(true);
        log.trace("FIN bRechercherMaladeRDVActionPerformed ");

    }//GEN-LAST:event_bRechercherMaladeRDVActionPerformed

    private void bRechercherDemandeRDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechercherDemandeRDVActionPerformed
        this.dispose();
        RechercherDemandeRDV s = new RechercherDemandeRDV();
        s.id = this.id;
        s.setVisible(true);
    }//GEN-LAST:event_bRechercherDemandeRDVActionPerformed

    private void bRechercherRDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRechercherRDVActionPerformed
        log.trace("DEBUT bRechercherRDVActionPerformed ");

        this.dispose();
        RechercherRDV s = new RechercherRDV();
        log.debug("id ADMIN = " + id);
        s.id = id;
        s.setVisible(true);
        log.trace("FIN bRechercherRDVActionPerformed ");
    }//GEN-LAST:event_bRechercherRDVActionPerformed

    private void cEtatValidationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cEtatValidationActionPerformed

    }//GEN-LAST:event_cEtatValidationActionPerformed

    private void cEtatValidationPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cEtatValidationPopupMenuWillBecomeInvisible
//        Crée un menu invisible pour verifier l'etat de la validation 

        if (!(cEtatValidation.getSelectedIndex() == -1)) {
            // Regler le BUG de : si on click ailleur sans choisir dans le combobox l'app plante

            String l; // l'etat du comobobox cEtatValidation
            l = (String) cEtatValidation.getSelectedItem();

            if (l.equals("Pris")) {
                jDateRecuperation.setEnabled(true);
                bDdateRecuperation.setEnabled(true);
            } else if (l.equals("Annuler") || l.equals("Reporter") || l.equals("En Attente")) {
                jDateRecuperation.setDate(null);
                jDateRecuperation.setEnabled(false);
            }
        }
    }//GEN-LAST:event_cEtatValidationPopupMenuWillBecomeInvisible

    private void bResetIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResetIDActionPerformed
        txtNom.setText("");
        txtPrenom.setText("");
        txtAdress.setText("");
        txtAdress.setText("");
        txtNumTel.setText("");
        txtId_p3.setText("");
        txtInt.setText("");

        bResetID.setEnabled(true);
    }//GEN-LAST:event_bResetIDActionPerformed

    private void bPasDeReponseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPasDeReponseActionPerformed
        if (textRemarque.getText().equals("")) {
            textRemarque.setText("<Pas De Reponse> : ");
        } else {
            textRemarque.setText(textRemarque.getText() + "<Pas De Reponse> : ");
        }
    }//GEN-LAST:event_bPasDeReponseActionPerformed

    private void bAppelerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAppelerActionPerformed
        if (textRemarque.getText().equals("")) {
            textRemarque.setText("<Appeler> : ");
        } else {
            textRemarque.setText(textRemarque.getText() + "<Appeler> : ");
        }
    }//GEN-LAST:event_bAppelerActionPerformed

    private void bAReponduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAReponduActionPerformed
        if (textRemarque.getText().equals("")) {
            textRemarque.setText("<A Repondu> : ");
        } else {
            textRemarque.setText(textRemarque.getText() + "<A Repondu> : ");
        }
    }//GEN-LAST:event_bAReponduActionPerformed

    private void tRDVchoix1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tRDVchoix1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tRDVchoix1MouseEntered

    private void bannulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bannulerActionPerformed
        //        reset tout les champs
        Reset_RDV_Pris();
    }//GEN-LAST:event_bannulerActionPerformed

    private void bIRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIRMActionPerformed
        if (textExamenDe.getText().equals("")) {
            textExamenDe.setText("IRM");
        } else {
            textExamenDe.setText(textExamenDe.getText() + "IRM");
        }
    }//GEN-LAST:event_bIRMActionPerformed

    private void bSyntegraphieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSyntegraphieActionPerformed
        if (textExamenDe.getText().equals("")) {
            textExamenDe.setText("Syntegraphie");
        } else {
            textExamenDe.setText(textExamenDe.getText() + "Syntegraphie");
        }
    }//GEN-LAST:event_bSyntegraphieActionPerformed

    private void bDdateDepotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDdateDepotActionPerformed
        try {
            String date = Verification_de_Date_actuel();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date dateValidation = formatter.parse(date);
            jDateDepot.setDate(dateValidation);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(RDV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bDdateDepotActionPerformed

    private void bDdateRecuperationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDdateRecuperationActionPerformed
        try {
            String date = Verification_de_Date_actuel();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date dateValidation = formatter.parse(date);
            jDateRecuperation.setDate(dateValidation);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(RDV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bDdateRecuperationActionPerformed

    private void Remplir_Tableau_Convontion() {
//            Remplir le Tableau tConvontion des Convontion par Raport au Cota des mois d'une annee

        con = Connect.connect();
        try {
            //1er requete pour identifier une erreur de redendence 
            String sql = "Select * from convontion ";
            pst = con.prepareStatement(sql);
            rst = pst.executeQuery(sql);

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
    }

    private void Nbr_Vedredie_de_toute_lannee() {
        // cette methode Calcule les vendredi de toute l'année par mois

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
    }

    public int get_nombre_Vendredi_par_mois(int mois, int annee) {
        // Cette Methode calcule de nombre de WeekEnd par mois de l'année 

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
        return nombre_week_end;
    }

    @SuppressWarnings("unchecked")
    public void Remplir_Combo_Type_Convontion() {
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
            java.util.logging.Logger.getLogger(RDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RDV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bARepondu;
    protected javax.swing.JButton bAjouterDemandeRDV;
    protected javax.swing.JButton bAjouterValidation;
    private javax.swing.JButton bAppeler;
    private javax.swing.JButton bCancel;
    protected javax.swing.JButton bDdateDepot;
    protected javax.swing.JButton bDdateRecuperation;
    private javax.swing.JButton bIRM;
    protected javax.swing.JButton bModifierDemandeRDV;
    protected javax.swing.JButton bModifierValidation;
    private javax.swing.JButton bPasDeReponse;
    private javax.swing.JButton bRechercherCotaParAns;
    private javax.swing.JButton bRechercherCotaParMois;
    protected javax.swing.JButton bRechercherDemandeRDV;
    protected javax.swing.JButton bRechercherMalade;
    protected javax.swing.JButton bRechercherMaladeRDV;
    protected javax.swing.JButton bRechercherRDV;
    protected javax.swing.JButton bResetID;
    private javax.swing.JButton bSyntegraphie;
    private javax.swing.JButton bannuler;
    private javax.swing.JComboBox cConvontion;
    protected javax.swing.JComboBox cEtatDemandeRDV;
    protected javax.swing.JComboBox cEtatValidation;
    private javax.swing.JButton jButton3;
    protected com.toedter.calendar.JDateChooser jDateDepot;
    protected com.toedter.calendar.JDateChooser jDateRecuperation;
    protected com.toedter.calendar.JDateChooser jDateValidation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    protected javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    protected com.toedter.calendar.JYearChooser jYearChooser1;
    protected com.toedter.calendar.JYearChooser jYearChooser2;
    private javax.swing.JPanel pChoisirDate;
    private javax.swing.JPanel pChoisirRDV;
    private javax.swing.JPanel pDemandeRDV;
    private javax.swing.JPanel pExamen;
    private javax.swing.JPanel pExamen1;
    private javax.swing.JPanel pRemarque;
    private javax.swing.JPanel pRemarque1;
    private javax.swing.JPanel pValidationRDV;
    protected javax.swing.JTable tConvontion;
    private javax.swing.JScrollPane tDateParConvontion;
    protected javax.swing.JTable tRDVchoix1;
    protected javax.swing.JTextArea textExamen;
    protected javax.swing.JTextArea textExamenDe;
    protected javax.swing.JTextArea textRemarque;
    protected javax.swing.JTextArea textRemarqueDe;
    protected javax.swing.JTextField txtAdress;
    protected javax.swing.JTextField txtId_p3;
    protected javax.swing.JTextField txtInt;
    protected javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtNomConvontion;
    protected javax.swing.JTextField txtNumTel;
    protected javax.swing.JTextField txtPrenom;
    // End of variables declaration//GEN-END:variables
}
