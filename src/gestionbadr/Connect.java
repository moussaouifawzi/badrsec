package gestionbadr;



import GestionBenevole.Benevole;
import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author FAWZI
 */

public class Connect {
    
    
    static Logger log = Logger.getLogger(Connect.class.getName());
    
    // Lire le fichier de configuration
    public static Connection connect(){
         Properties prop = new Properties();
/* Ici le fichier contenant les données de configuration est nommé 'db.myproperties' */
FileInputStream in;
        try {
            in = new FileInputStream("config.properties");
            prop.load(in);
            in.close();
        } catch (FileNotFoundException ex) {
          //  java.util.logging.Logger.getLogger(ConnectMain.class.getName()).log(Level.SEVERE, null, ex);
          log.error(ex);
        } catch (IOException ex) {
            log.error(ex);
        }


// Extraction des propriétés
String url = prop.getProperty("db.database");
String user = prop.getProperty("db.user");
String password = prop.getProperty("db.password");
   
        
        
//        try{
////          System.out.println("slaut");
//        Class.forName("com.mysql.jdbc.Driver");
////          System.out.println("allé");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
////        System.out.println("hhhh");
////              JOptionPane.showMessageDialog(null, "connec");
//
//        return con;
//    }catch(ClassNotFoundException | SQLException | HeadlessException e){
//            JOptionPane.showMessageDialog(null, e.getMessage());
//            log.fatal("Alerte JDBC", e);
//            return null;
//   }

try{
          
        Class.forName("com.mysql.jdbc.Driver");
         
        Connection con = DriverManager.getConnection(url, user, password);
       
           //  JOptionPane.showMessageDialog(null, "connec");
                     return con;

    }catch(ClassNotFoundException | SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            log.fatal("Alerte", e);
                    return null;

    }

}
    
}