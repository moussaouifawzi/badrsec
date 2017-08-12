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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FAWZI
 */
public class Convontion_Semaine {

    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(RechercherMaladeRDV.class.getName());

    ArrayList date = new ArrayList(); // tableau de ma date
    ArrayList nomJour = new ArrayList(); // tableau des nom du jour
    ArrayList aSamedi = new ArrayList(); // tableau de Samedi
    ArrayList aDimanche = new ArrayList(); // tableau de Dimanche
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
        log.debug("le mois recu = " + mois_recu);

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

    public void afficher_la_date_dun_mois_ameliorer(int mois) throws ParseException {
//        Afficher les Date + le Nom du Jours d'un mois et d'une annee dans tRDVChoix
        if (log.isTraceEnabled()) {
            log.trace("Debut afficher_la_date_dun_mois_ameliorer");
        }

        if (log.isDebugEnabled()) {
            log.trace("mois dans  afficher_la_date_dun_mois_ameliorer= " + mois);
        }

        int m = mois;
        boolean b = false;

        DecimalFormat myFormatter = new DecimalFormat("00");
        String month = myFormatter.format(m + 1);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, m);

        cal.set(Calendar.YEAR, n.jYearChooser1.getYear());

        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 1; i < maxDay + 1; i++) {

            String day = myFormatter.format(i);
            String z = Integer.toString(n.jYearChooser1.getYear());
            //            Ajouter le Nom du jour
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String n = z + "-" + month + "-" + day;
            date.add(n);

            Date dateValidation = formatter.parse(n);
            nomJour.add(new SimpleDateFormat("EEEE").format(dateValidation));
        }
        
        log.trace("la taille du tableau date dans afficher_la_date_dun_mois_ameliorer  = "+ date.size());
        log.trace("le detaille du tableau date dans afficher_la_date_dun_mois_ameliorer ");
        for(int i = 0; i < date.size() ; i++){
        log.debug(date.get(i));
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

        if (log.isTraceEnabled()) {
            log.trace("le tableau complet de toute l'année ");
        }
        if (log.isDebugEnabled()) {
            log.debug("la taille du tableau = " + date.size());
        }

        int limit = date.size();
        for (int i = 0; i < limit; i++) {
            // Parcourt tout le tableau "Date" et calculer le nombre de samedi et dimanche dans l'année
            
            if (log.isDebugEnabled()) {
            log.debug("le Tableau Date");
            log.debug("la date = " +date.get(i));
             }

            if (nomJour.get(i).equals("dimanche")) {
                cmp_dimanche++;
                aDimanche.add(date.get(i));
            } else if (nomJour.get(i).equals("samedi")) {
                cmp_samedi++;
                aSamedi.add(date.get(i));
            }
        }

        // AJouter null pour avoir le méme nombre dans le tableau
        if (cmp_samedi < cmp_dimanche) {
            aSamedi.add(null);
        } else if (cmp_dimanche < cmp_samedi) {
            aDimanche.add(null);
        }

        log.debug("le nombre de samedi = " + aSamedi.size() + " le nombre de dimanche = " + aDimanche.size());
        

        if (log.isTraceEnabled()) {
            log.trace("Fin Calculer_sam_dim_annee");
        }
    }

   

}
