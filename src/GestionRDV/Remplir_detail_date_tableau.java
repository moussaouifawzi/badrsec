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

    static Logger log = Logger.getLogger(Remplir_detail_date_tableau.class.getName());
    String vDateDebut;
    String vDateFin;
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
        log.debug("Dimanche = " + dDimanche + " / Samedi = " + dSamedi);
        vDateFin = dSamedi;
        vDateDebut = dDimanche;
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
        log.debug("Dimanche = " + vDateDebut + " / Samedi = " + vDateFin);

        // diviser la date de debut  
        String AnneeDebut = vDateDebut.substring(0, 4);
//        log.debug(AnneeDebut);
        String MoisDebut = vDateDebut.substring(5, 7);
//        log.debug(MoisDebut);
        String Jours_Debut = vDateDebut.substring(8, 10);
//        log.debug(Jours_Debut);

        // diviser la date de Fin  
        String AnneeFin = vDateFin.substring(0, 4);
//        log.debug(AnneeFin);
        String MoisFin = vDateFin.substring(5, 7);
//        log.debug(MoisFin);
        String JoursFin = vDateFin.substring(8, 10);
//        log.debug(JoursFin);

        if (AnneeDebut.equals(AnneeFin) && MoisDebut.equals(MoisFin)) {
            // si l'anner et le mois ne change pas
            
            DecimalFormat myFormatter = new DecimalFormat("00");
            
            log.trace("l'anner et le mois ne change ps");
            log.debug("jour = " + Jours_Debut);
            String nn = AnneeDebut + "-" + MoisDebut + "-" + Jours_Debut;
            arJour.add(nn);
            int k = Integer.parseInt(Jours_Debut);
            log.debug("Avant Boucle k = " + k);
            for (int i = 1; i < 7; i++) {
                k++;
                String day = myFormatter.format(k);
                
                
                String n = AnneeDebut + "-" + MoisDebut + "-" + day;
                arJour.add(n);
                log.debug("jour k = " + day);
                log.debug("i = " + i);
            }
            
            log.trace("Afficher le tableau");
            for (int i = 0; i < arJour.size(); i++) {
                log.debug(arJour.get(i));
            }
            
        } else if (AnneeDebut.equals(AnneeFin)) {
            // si l'annee ne change pas
            
            log.trace("le mois et le jours change ");

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

            log.debug("max day of month = " + MoisDebut + " is " + maxDay);
            h = maxDay - k;
            log.debug(" les jours restants h =" + h);
            
            String nn = AnneeDebut + "-" + MoisDebut + "-" + Jours_Debut;
            arJour.add(nn); // Ajouter le 1er jour 

            for (int i = 0; i < h; i++) {
                // calculer les jours du debut du mois
                k++;
                String day = myFormatter.format(k);
                log.debug("jour k = " + k);
                String n = AnneeDebut + "-" + MoisDebut + "-" + day;
                arJour.add(n);

            }

            for (int i = 1; i <= Integer.parseInt(JoursFin); i++) {
                // calculer les jours du debut du mois
                u = u + 1;
                String day = myFormatter.format(u);
                log.debug("u = " + day);
                String n = AnneeDebut + "-" + MoisFin + "-" + day;
                arJour.add(n);
            }
            
            log.trace("Afficher le tableau");
            for (int i = 0; i < arJour.size(); i++) {
                log.debug(arJour.get(i));
            }
        }
        
        if (log.isTraceEnabled()) {
            log.trace("Fin date()");
        }
    }
   
}
