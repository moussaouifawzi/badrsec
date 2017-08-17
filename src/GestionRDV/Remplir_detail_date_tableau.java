/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionRDV;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.log4j.Logger;

/**
 *
 * @author FAWZI
 */
public class Remplir_detail_date_tableau {
    // Remplir le deuxieme tableau avec le detaille d'une semaine 

    static Logger log = Logger.getLogger(Remplir_detail_date_tableau.class.getName());
    String vDateDebutDimanche;
    String vDateFinSamedi;
    ArrayList arJour = new ArrayList(); // tableau de ma date

    public ArrayList getArJour() {
        if (log.isTraceEnabled()) {
            log.trace("Debut getArJour()");
        }
        if (log.isTraceEnabled()) {
            log.trace("Fin getArJour()");
        }
        return arJour;
    }
    
    

    public Remplir_detail_date_tableau(String dSamedi, String dDimanche) {
        if (log.isTraceEnabled()) {
            log.trace("Debut Remplir_detail_date_tableau(String dSamedi, String dDimanche)");
        }
        
        log.trace("New Class");
//        log.debug("Dimanche = " + dDimanche + " / Samedi = " + dSamedi);
        vDateFinSamedi = dSamedi;
        vDateDebutDimanche = dDimanche;
        date();
        
        if (log.isTraceEnabled()) {
            log.trace("Fin Remplir_detail_date_tableau(String dSamedi, String dDimanche)");
        }
    }

    public void date() {
        if (log.isTraceEnabled()) {
            log.trace("Debut date()");
        }
        
        log.trace("date");
//        log.debug("Dimanche = " + vDateDebutDimanche + " / Samedi = " + vDateFinSamedi);

        // diviser la date de debut  
        String AnneeDebutDimanche = vDateDebutDimanche.substring(0, 4);
//        log.debug(AnneeDebut);
        String MoisDebutDimanche = vDateDebutDimanche.substring(5, 7);
//        log.debug(MoisDebut);
        String Jours_DebutDimanche = vDateDebutDimanche.substring(8, 10);
//        log.debug(Jours_Debut);

        // diviser la date de Fin  
        String AnneeFinSamedi = vDateFinSamedi.substring(0, 4);
//        log.debug(AnneeFin);
        String MoisFinSamedi = vDateFinSamedi.substring(5, 7);
//        log.debug(MoisFin);
        String JoursFinSamedi = vDateFinSamedi.substring(8, 10);
//        log.debug(JoursFin);

        if (AnneeDebutDimanche.equals(AnneeFinSamedi) && MoisDebutDimanche.equals(MoisFinSamedi)) {
            // si l'anner et le mois ne change pas
            
            DecimalFormat myFormatter = new DecimalFormat("00");
            
//            log.trace("l'anner et le mois ne change ps");
//            log.debug("jour = " + Jours_DebutDimanche);
            String nn = AnneeDebutDimanche + "-" + MoisDebutDimanche + "-" + Jours_DebutDimanche;
            arJour.add(nn);
            int k = Integer.parseInt(Jours_DebutDimanche);
//            log.debug("Avant Boucle k = " + k);
            for (int i = 1; i < 7; i++) {
                k++;
                String day = myFormatter.format(k);
                
                
                String n = AnneeDebutDimanche + "-" + MoisDebutDimanche + "-" + day;
                arJour.add(n);
//                log.debug("jour k = " + day);
//                log.debug("i = " + i);
            }
            
            log.trace("Afficher le tableau");
            for (int i = 0; i < arJour.size(); i++) {
                log.debug(arJour.get(i));
            }
            
        } else if (AnneeDebutDimanche.equals(AnneeFinSamedi)) {
            // si l'annee ne change pas
            
            log.trace("le mois et le jours change ");

            int k = Integer.parseInt(Jours_DebutDimanche);
            int m = Integer.parseInt(MoisDebutDimanche);
            int h = 0; // le reste du mois 
            int u = 0; // les jours du debut du mois 

            m = m - 1; // les mois du Calendar commece par 0 et non pa par 1

            DecimalFormat myFormatter = new DecimalFormat("00");
            String month = myFormatter.format(m + 1);

            Calendar cal = Calendar.getInstance();

            cal.set(Calendar.MONTH, m);
            cal.set(Calendar.YEAR, Integer.parseInt(AnneeDebutDimanche));
            int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

//            log.debug("max day of month = " + MoisDebutDimanche + " is " + maxDay);
            h = maxDay - k;
//            log.debug(" les jours restants h =" + h);
            
            String nn = AnneeDebutDimanche + "-" + MoisDebutDimanche + "-" + Jours_DebutDimanche;
            arJour.add(nn); // Ajouter le 1er jour 

            for (int i = 0; i < h; i++) {
                // calculer les jours du debut du mois
                k++;
                String day = myFormatter.format(k);
//                log.debug("jour k = " + k);
                String n = AnneeDebutDimanche + "-" + MoisDebutDimanche + "-" + day;
                arJour.add(n);

            }

            for (int i = 1; i <= Integer.parseInt(JoursFinSamedi); i++) {
                // calculer les jours du debut du mois
                u = u + 1;
                String day = myFormatter.format(u);
//                log.debug("u = " + day);
                String n = AnneeDebutDimanche + "-" + MoisFinSamedi + "-" + day;
                arJour.add(n);
            }
            
            log.trace("Afficher le tableau");
            for (int i = 0; i < arJour.size(); i++) {
                log.debug(arJour.get(i));
            }
        } else {
            
//            Tout Change 

log.trace("Tout Change  ");

            int jourDebutDimanch = Integer.parseInt(Jours_DebutDimanche);
           // int moisDebutDimanche = Integer.parseInt(MoisDebutDimanche);
            int resteJourDecembre = 0; // le reste du mois 
            int u = 0; // les jours du debut du mois 

            int m = 11; // les mois du Calendar commece par 0 et non pa par 1

            DecimalFormat myFormatter = new DecimalFormat("00");
            String month = myFormatter.format(m + 1);

            Calendar cal = Calendar.getInstance();

            cal.set(Calendar.MONTH, m);
            cal.set(Calendar.YEAR, Integer.parseInt(AnneeDebutDimanche));
            int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

//            log.debug("max day of month = " + MoisDebutDimanche + " is " + maxDay);
            resteJourDecembre = maxDay - jourDebutDimanch;
//            log.debug(" les jours restants resteJourDecembre =" + resteJourDecembre);
            
            String nn = AnneeDebutDimanche + "-" + MoisDebutDimanche + "-" + Jours_DebutDimanche;
            arJour.add(nn); // Ajouter le 1er jour 

            for (int i = 0; i < resteJourDecembre; i++) {
                // calculer les jours du debut du mois
                jourDebutDimanch++;
                String day = myFormatter.format(jourDebutDimanch);
//                log.debug("jour k = " + jourDebutDimanch);
                String n = AnneeDebutDimanche + "-" + MoisDebutDimanche + "-" + day;
                arJour.add(n);

            }

            for (int i = 1; i <= Integer.parseInt(JoursFinSamedi); i++) {
                // calculer les jours du debut du mois
                u = u + 1;
                String day = myFormatter.format(u);
//                log.debug("u = " + day);
                String n = AnneeDebutDimanche + "-" + MoisFinSamedi + "-" + day;
                arJour.add(n);
            }
            
//            log.trace("Afficher le tableau");
//            for (int i = 0; i < arJour.size(); i++) {
//                log.debug(arJour.get(i));
//            }

                        
                
        }
        
        if (log.isTraceEnabled()) {
            log.trace("Fin date()");
        }
    }
   
}
