/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionRDV;

import static GestionRDV.NewJFrame1.log;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FAWZI
 */
public class Convontion_Semaine {

    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Convontion_Semaine.class.getName());

    ArrayList date = new ArrayList(); // tableau de ma date
    ArrayList nomJour = new ArrayList(); // tableau des nom du jour
    ArrayList aSamedi = new ArrayList(); // tableau de Samedi
    ArrayList aDimanche = new ArrayList(); // tableau de Dimanche
    List lSamedi = new LinkedList();
    List lDimanche = new LinkedList();

    RDV n = new RDV();
    int mois_recu = 0;

    public Convontion_Semaine() {
        if (log.isTraceEnabled()) {
            log.trace("Debut Convontion_Semaine()");
        }
        if (log.isTraceEnabled()) {
            log.trace("Fin Convontion_Semaine()");
        }
    }

    public Convontion_Semaine(int recu) {
        if (log.isTraceEnabled()) {
            log.trace("Debut Convontion_Semaine(int recu)");
        }
        mois_recu = recu;
        if (log.isDebugEnabled()){
            log.debug("le mois_recu = " + mois_recu);
        }

        if (log.isTraceEnabled()) {
            log.trace("Fin Convontion_Semaine(int recu)");
        }
    }

    public void Afficher_details_semaine(ArrayList q) throws ParseException {
//              Ajouter et Afficher l'ordre de la semaine au tableauc
        if (log.isTraceEnabled()) {
            log.trace("Debut Afficher_details_semaine");
        }

        DefaultTableModel md = new DefaultTableModel();
        md.setColumnIdentifiers(new String[]{"Nom", "Jours"});

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for (int l = 0; l < q.size(); l++) {
//            afficher la liste des semaines (debut et fin)

            String n = (String) q.get(l);

            Date dateValidation = formatter.parse(n);
            md.addRow(new Object[]{new SimpleDateFormat("EEEE").format(dateValidation), q.get(l)});  // Ajouter les variables à la ligne du tableau
        }

        n.tRDVchoix1.setModel(md);

        if (log.isTraceEnabled()) {
            log.trace("Fin Afficher_details_semaine");
        }
    }

    public void afficher_la_date_dun_mois_ameliorer(int mois , int anneeJYearChooser) throws ParseException {
//        Afficher les Date + le Nom du Jours d'un mois et d'une annee dans tRDVChoix
        if (log.isTraceEnabled()) {
            log.trace("Debut afficher_la_date_dun_mois_ameliorer");
        }

        int m = mois;
        boolean b = false;

        DecimalFormat myFormatter = new DecimalFormat("00");
        String month = myFormatter.format(m + 1);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, m);

        cal.set(Calendar.YEAR, anneeJYearChooser);

        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 1; i < maxDay + 1; i++) {

            String day = myFormatter.format(i);
            String z = Integer.toString(anneeJYearChooser);
            //            Ajouter le Nom du jour
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String n = z + "-" + month + "-" + day;
            date.add(n);

            Date dateValidation = formatter.parse(n);
            nomJour.add(new SimpleDateFormat("EEEE").format(dateValidation));
        }

        if (log.isTraceEnabled()) {
            log.trace("Fin afficher_la_date_dun_mois_ameliorer");
        }
    }

    public void Calculer_sam_dim_annee() {
        // Calculer le nombre de samedi et dimanche dans toute l'anner a partire du tableau "Date"
        // Verifier si le tableau de samedi > au tableau de dimanche et ajouter null pour équilibrer

        if (log.isTraceEnabled()) {
            log.trace("Debut Calculer_sam_dim_annee");
        }

        int cmp_dimanche = 0;
        int cmp_samedi = 0;

        int limit = date.size();
        for (int i = 0; i < limit; i++) {
            // Parcourt tout le tableau "Date" et calculer le nombre de samedi et dimanche dans l'année

            if (nomJour.get(i).equals("dimanche")) {
                cmp_dimanche++;
                aDimanche.add(date.get(i));
            } else if (nomJour.get(i).equals("samedi")) {
                cmp_samedi++;
                aSamedi.add(date.get(i));
            }
        }

        // AJouter le dernier Samedi pour avoir le méme nombre dans le tableau      
        if (cmp_samedi < cmp_dimanche) {
            log.trace("Si cmp_samedi < cmp_dimanche");

            String date_fini_recu = Rechercher_Derniere_Date();
            aSamedi.add(date_fini_recu); // ajouter le dernier Samedi à la Tableau du samedi

        } else if (cmp_dimanche <= cmp_samedi) {
            log.trace("Sinon cmp_dimanche < cmp_samedi");

//            Transformer les Tableau en LinkedListe
            for (int e = 0; e < aDimanche.size(); e++) {
                lDimanche.add(aDimanche.get(e));
            }
            for (int e = 0; e < aSamedi.size(); e++) {
                lSamedi.add(aSamedi.get(e));
            }
            
            String date_fini_recu = Rechercher_Derniere_Date();

//            Ajouter des élément au List
//            Ajouter un element au debut de lDimanche
            String date_Debut_Decembre = Rechercher_Premiere_Date();
            lDimanche.add(0, date_Debut_Decembre);

//            Ajouter un élément a la fin de lSamedi
            lSamedi.add(lSamedi.size(), date_fini_recu); // ajouter le dernier Samedi à la liste du samedi

//            Vider les valeur de tableau 
            aDimanche.removeAll(date);
            aSamedi.removeAll(date);

//            Ajouter tout les elements du tableau a la Liste
            for (int e = 0; e < lDimanche.size(); e++) {
                aDimanche.add(lDimanche.get(e));
            }

            for (int e = 0; e < lSamedi.size(); e++) {
                aSamedi.add(lSamedi.get(e));
            }
            
        //    vider_linkedlist();
        }
        
       // vider_arraylist();

        if (log.isTraceEnabled()) {
            log.trace("Fin Calculer_sam_dim_annee");
        }
    }

    public String Rechercher_Derniere_Date() {
        // Calculer la darniere date du Samedi (de la nouvelle annee)

        int maxDate = aDimanche.size() - 1; // la max dans le tableau du Dimanche (-1 car le tableau commence de 0)
        String vDernierDate = (String) aDimanche.get(maxDate); // Transformation maxdate en String

        Date_Manquante d = new Date_Manquante();
        String date_fini_recu = d.Date_Debut(vDernierDate);
        return date_fini_recu;
    }

    public String Rechercher_Premiere_Date() {
        // Calculer la Premiere date du Dimanche dans le tableau tRDVchoix

        String vDateSamedi = (String) aSamedi.get(0); // la date du 1er samedi du tableau

        Date_Manquante d = new Date_Manquante();
        String date_Dimanche_recu = d.Date_Premier_Dimanche(vDateSamedi);
        return date_Dimanche_recu;
    }
    
    public void vider_linkedlist(){
        lDimanche.clear();
            lSamedi.clear();
    }
    
    public void vider_arraylist(){
        log.debug("vider les tableau");
        aDimanche.clear();
        aSamedi.clear();
        date.clear();
        nomJour.clear();
    }

}
