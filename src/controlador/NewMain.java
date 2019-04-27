package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Alumno;
import modelo.Modelo;
import vista.Formulario;
import vista.Vista;

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
    
    private boolean registro;
    private String id;

    public NewMain() {
        m = new Modelo();
        f = new JFrame();
        v = new Vista();
        form = new Formulario();
        eventoTabla();
    }
    
    public static void main(String[] args) {
        NewMain main = new NewMain();
        
        main.form.getBtnRegistrar().addActionListener(main);
        main.v.getBtnCrear().addActionListener(main);
        main.v.getBtnEliminar().addActionListener(main);
        main.v.getBtnActualizar().addActionListener(main);
        main.m.recuperarAlumnos();
        main.v.setData(main.m.getData());
        main.v.cargarTabla();
        
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
            form.setTitle("Crear nuevo registro");
            form.getBtnRegistrar().setText("Registrar");
            form.setVisible(true);
            registro = true;
        }
        
        if (form.getBtnRegistrar() == e.getSource()) {
            if(camposLlenos()){
                if(registro)
                    m.crear(new Alumno(this.nombre, this.apellidoPaterno, this.apellidoMaterno, this.carrera, this.semestre));
                else{
                    Vector objeto = (Vector) this.v.getModelo().getDataVector().get(selectedRow);
                    id = String.valueOf(objeto.get(0));
                    m.editar(new Alumno(this.id, this.nombre, this.apellidoPaterno, this.apellidoMaterno, this.carrera, this.semestre));
                }
                
                m.recuperarAlumnos();
                v.setData(m.getData());
                v.cargarTabla();
                form.setVisible(false);
            } else
                JOptionPane.showMessageDialog(null,"Rellena todos los campos!");
        }
        
        if (v.getBtnActualizar()== e.getSource()) {
            if (selectedRow > -1){
                Vector objeto = (Vector) this.v.getModelo().getDataVector().get(selectedRow);
                
                form.getTxfNombre().setText(String.valueOf(objeto.get(1)));
                form.getTxfApellidoPaterno().setText(String.valueOf(objeto.get(2)));
                form.getTxfApellidoMaterno().setText(String.valueOf(objeto.get(3)));
                form.getTxfCarrera().setText(String.valueOf(objeto.get(4)));
                form.getTxfSemestre().setText(String.valueOf(objeto.get(5)));
                form.setTitle("Actualizar registro");
                form.getBtnRegistrar().setText("Actualizar");
                form.setVisible(true);
                registro = false;
            } else
                JOptionPane.showMessageDialog(null,"Debes seleccionar un registro");
        }
        
        if(v.getBtnEliminar() == e.getSource()){
            if (selectedRow > -1){
                Vector objeto = (Vector) this.v.getModelo().getDataVector().get(selectedRow);
                id = String.valueOf(objeto.get(0));
                m.eliminar(id);
                m.recuperarAlumnos();
                v.setData(m.getData());
                v.cargarTabla();
            } else
                JOptionPane.showMessageDialog(null,"Debes seleccionar un registro");
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