/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import itver.edu.NewJerseyClient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Alumno;
import modelo.Modelo;
import vista.Formulario;
import vista.Vista;

/**
 *
 * @author lasergun
 */
public class NewMain implements ActionListener{
    public Modelo m;
    public JFrame f;
    public Vista v;
    public Formulario form;
    
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String carrera ;
    private String semestre;
    private int selectedRow = -1;

    public NewMain() {
        m = new Modelo();
        f = new JFrame();
        v = new Vista();
        form = new Formulario();
        eventoTabla();
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
        main.form.getBtnRegistrar().addActionListener(main);
        main.v.getBtnEliminar().addActionListener(main);
        main.v.setData(main.m.getData());
        main.v.cargarTabla();
        //n.setVisible(true);
        main.f.add(main.v);
        main.f.setSize(700, 400);
        main.f.setVisible(true);
        main.f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void eventoTabla(){
        v.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                selectedRow = v.getTable().getSelectedRow();
                //System.out.println(selectedRow);  
            }
        });
    }
        

    @Override
    public void actionPerformed(ActionEvent e) {
        if (v.getBtnCrear() == e.getSource()) {
            form.getTxfNombre().setText("");
            form.getTxfApellidoPaterno().setText("");
            form.getTxfApellidoMaterno().setText("");
            form.getTxfCarrera().setText("");
            form.getTxfSemestre().setText("");
            form.setVisible(true);
        }
        
        if (form.getBtnRegistrar() == e.getSource()) {
            if(camposLlenos()){
                m.crear(new Alumno(this.nombre, this.apellidoPaterno, this.apellidoMaterno, this.carrera, this.semestre));
                m.recuperarAlumnos();
                v.setData(m.getData());
                //v.getModelo().setRowCount(0);
                v.cargarTabla();
                form.setVisible(false);
            } else
                JOptionPane.showMessageDialog(null,"Rellena todos los campos!");
        }
        
        if(v.getBtnEliminar() == e.getSource()){
            if (selectedRow > -1){
                m.eliminar(String.valueOf(selectedRow));
                m.recuperarAlumnos();
                v.setData(m.getData());
                v.cargarTabla();
            }
            else
                JOptionPane.showMessageDialog(null,"Debes selecciona un registro");
        }
    }
    
    public boolean camposLlenos() {
        this.nombre = form.getTxfNombre().getText();
        this.apellidoPaterno = form.getTxfApellidoPaterno().getText();
        this.apellidoMaterno = form.getTxfApellidoMaterno().getText();
        this.carrera = form.getTxfCarrera().getText();
        this.semestre = form.getTxfSemestre().getText();

        if(nombre.equals("") || apellidoPaterno.equals("") || apellidoMaterno.equals("") || carrera.equals("") 
            || semestre.equals(""))
            return false;
        
        return true;
    }
    
}
