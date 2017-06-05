/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionBenevole;

import org.apache.log4j.Logger;

/**
 *
 * @author FAWZI
 */
public class Log4j {
    static Logger log = Logger.getLogger(Log4j.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
log.debug("msg de debogage");
log.info("msg d'information");
log.warn("msg d'avertissement");
log.error("msg d'erreur");
log.fatal("msg d'erreur fatale");  
 
 
    }
}
