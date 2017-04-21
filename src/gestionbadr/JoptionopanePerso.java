/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbadr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author FAWZI
 */
public class JoptionopanePerso {

    public void SetAjouter() {
        final JOptionPane msg = new JOptionPane("Ajouter avec succès", JOptionPane.INFORMATION_MESSAGE, JOptionPane.CLOSED_OPTION);
        final JDialog dlg = msg.createDialog("Valider");
        dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dlg.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                final Timer t = new Timer(800, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dlg.setVisible(false);
                    }
                }
                );
                t.start();
            }
        });
        dlg.setVisible(true);
        System.out.println("Outside code.");

    }

   

}
