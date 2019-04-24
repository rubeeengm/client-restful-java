/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientrestfull;

import itver.edu.NewJerseyClient;
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
        //m.eliminar("11");
        m.client = new NewJerseyClient();
        
        m.client.edit_XML("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +
            "   <alumnos> \n" +
            "   <apellidoMaterno>"+"Málaga"+"</apellidoMaterno> \n" +
            "       <apellidoPaterno>"+"Ponce"+"</apellidoPaterno> \n" +
            "       <carrera>"+"Ing. Sistemas"+"</carrera> \n" +
            "       <idAlumnos>"+"13"+"</idAlumnos> \n" +
            "       <nombre>"+"Ruben"+"</nombre> \n" +
            "       <semestre>"+"10"+"</semestre> \n" +
            "   </alumnos> ", "13");
                
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
