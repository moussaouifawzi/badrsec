/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionRDV;

import java.text.DecimalFormat;
import java.util.Calendar;

/**
 *
 * @author FAWZI
 */
public class Date_Manquante {

    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Date_Manquante.class.getName());

    public Date_Manquante() {

    }

    public String Date_Debut(String dateDebut) {
//        Calcule la date de la derniere date a afficher dans le tableau

        if (log.isTraceEnabled()) {
            log.trace("Debut Date_Debut");
        }

        // diviser la date de debut  
        String AnneeDebut = dateDebut.substring(0, 4);
//        log.debug(AnneeDebut);
        String MoisDebut = dateDebut.substring(5, 7);
//        log.debug(MoisDebut);
        String Jours_Debut = dateDebut.substring(8, 10);
//        log.debug(Jours_Debut);

        // diviser la date de Fin  
        String AnneeFin = AnneeDebut;
        int c = Integer.parseInt(AnneeFin) + 1;
        AnneeFin = Integer.toString(c);
//        log.debug(AnneeFin);
        String MoisFin = "01";
//        log.debug(MoisFin);
        String JoursFin = "0";
//        log.debug(JoursFin);

        int k = Integer.parseInt(Jours_Debut);
        int m = Integer.parseInt(MoisDebut);
        int h = 0; // le reste du mois 
        int u = 0; // les jours du debut du mois 

        m = m - 1; // les mois du Calendar commece par 0 et non pa par 1

        DecimalFormat myFormatter = new DecimalFormat("00");
        String month = myFormatter.format(m + 1);

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.MONTH, m);
        cal.set(Calendar.YEAR, Integer.parseInt(AnneeDebut));
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        h = maxDay - k;

//        String nn = AnneeDebut + "-" + MoisDebut + "-" + Jours_Debut;
//            arJour.add(nn); // Ajouter le 1er jour 
        for (int i = 0; i < h; i++) {
            // calculer les jours du debut du mois
            k++;
            String day = myFormatter.format(k);
//            String n = AnneeDebut + "-" + MoisDebut + "-" + day;
        }

        int p = 6 - h; // le nombre de jour restant dans le nouveau mois

        for (int i = 1; i < p; i++) {
            // calculer les jours du debut du mois
            u = u + 1;
            String day = myFormatter.format(u);
            String n = AnneeDebut + "-" + MoisFin + "-" + day;
        }
        String dayy = myFormatter.format(p);

        String date_Fini = AnneeFin + "-" + MoisFin + "-" + dayy;

        if (log.isTraceEnabled()) {
            log.trace("Fin Date_Debut");
        }

        return date_Fini;
    }

    public String Date_Premier_Dimanche(String dateSamedi) {
//        Calcule la date de la derniere date a afficher dans le tableau des semaine 

        if (log.isTraceEnabled()) {
            log.trace("Debut Date_Premier_Dimanche");
        }

        // diviser la date du Samedi
        String AnneeSamedi = dateSamedi.substring(0, 4);
//        log.debug(AnneeDebut);
        String MoisSamedi = dateSamedi.substring(5, 7);
//        log.debug(MoisDebut);
        String Jours_Samedi = dateSamedi.substring(8, 10);
//        log.debug(Jours_Debut);

//        Jour Samedi
// transformation de String a Int
        int jourSamedi = Integer.parseInt(Jours_Samedi);
        int moisSamedi = Integer.parseInt(MoisSamedi);
        int anneeSamedi = Integer.parseInt(AnneeSamedi);

        int premierJourDecembre = 0; // le reste du mois 
        int u = 0; // les jours du debut du mois 

        //   m = m - 1; // les mois du Calendar commece par 0 et non pa par 1
        int mois_Decembre = 11;
        int anneeDecembre = anneeSamedi - 1;

        DecimalFormat myFormatter2 = new DecimalFormat("00");
        String month_Decembre = myFormatter2.format(mois_Decembre + 1);

//        Calculer le max day en Decembre
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, mois_Decembre);
        cal.set(Calendar.YEAR, anneeDecembre);
        int maxDayDecember = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        int reste_semaine = 6 - jourSamedi;  // c'est le reste dans la semaine

        premierJourDecembre = maxDayDecember - reste_semaine;

        DecimalFormat myFormatter3 = new DecimalFormat("00");
        String premier_Jour_Decembre = myFormatter3.format(premierJourDecembre);
        String dateDecembre = anneeDecembre + "-" + month_Decembre + "-" + premier_Jour_Decembre;

        if (log.isTraceEnabled()) {
            log.trace("Fin Date_Premier_Dimanche");
        }

        return dateDecembre;
    }

}
