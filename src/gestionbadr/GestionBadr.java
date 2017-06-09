/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbadr;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author FAWZI
 */
public class GestionBadr {

    static Logger log = Logger.getLogger(Login.class.getName());
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creer un fichier de configuration avec la base de donnée
        boolean b = true;
        if(b=true){
            final Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("config.properties");

			// set the properties value
			prop.setProperty("db.database", "jdbc:mysql://localhost/mydb");
			prop.setProperty("db.user", "root");
			prop.setProperty("db.password", "");

			// save properties to project root folder
			prop.store(output, null);

		} catch (final IOException io) {
			log.error(io);
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (final IOException e) {
					log.error(e);
				}
			}

		}
                Connect.connect();
                Login s = new Login();
                s.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "le Fichier config.properties est introuvable");
            log.fatal("le Fichier config.properties est introuvable");
        }
                

    }
    
}
