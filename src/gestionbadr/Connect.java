package gestionbadr;



import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author FAWZI
 */
public class Connect {
    
    public static Connection connect(){
        try{
//          System.out.println("slaut");
        Class.forName("com.mysql.jdbc.Driver");
//          System.out.println("allé");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
//        System.out.println("hhhh");
//              JOptionPane.showMessageDialog(null, "connec");

        return con;
    }catch(ClassNotFoundException | SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
    }
}
}