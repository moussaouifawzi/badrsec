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

/**
 *
 * @author FAWZI
 */
public class GestionBadr {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creer un fichier de configuration avec la base de donnée
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
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}

		}
            
                Connect.connect();
                Login s = new Login();
                s.setVisible(true);

    }
    
}
