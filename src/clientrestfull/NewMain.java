/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientrestfull;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author lasergun
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Modelo m = new Modelo();
        JFrame f = new JFrame();
        m.recuperarAlumnos();
        Vista v = new Vista();
        v.setData(m.getData());
        v.cargarTabla();
        //n.setVisible(true);
        f.add(v);
        f.setSize(700, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
