/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientrestfull;

import itver.edu.NewJerseyClient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author lasergun
 */
public class NewMain implements ActionListener{
    public Modelo m;
    public JFrame f;
    public Vista v;

    public NewMain() {
        m = new Modelo();
        f = new JFrame();
        v = new Vista();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NewMain main = new NewMain();
        
        //m.eliminar("11");
        //m.client = new NewJerseyClient();
        
////        m.client.edit_XML("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +
////            "   <alumnos> \n" +
////            "   <apellidoMaterno>"+"Málaga"+"</apellidoMaterno> \n" +
////            "       <apellidoPaterno>"+"Ponce"+"</apellidoPaterno> \n" +
////            "       <carrera>"+"Ing. Sistemas"+"</carrera> \n" +
////            "       <idAlumnos>"+"13"+"</idAlumnos> \n" +
////            "       <nombre>"+"Ruben"+"</nombre> \n" +
////            "       <semestre>"+"10"+"</semestre> \n" +
////            "   </alumnos> ", "13");
        main.m.recuperarAlumnos();
        
        main.v.getBtnCrear().addActionListener(main);
        main.v.setData(main.m.getData());
        main.v.cargarTabla();
        //n.setVisible(true);
        main.f.add(main.v);
        main.f.setSize(700, 400);
        main.f.setVisible(true);
        main.f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (v.getBtnCrear() == e.getSource()) {
            new Formulario().setVisible(true);
        }
    }
    
}
