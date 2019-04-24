package clientrestfull;

import itver.edu.NewJerseyClient;
import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import java.io.*;
import java.util.Vector;

public class Modelo {
    public NewJerseyClient client;
    private Vector data;

    public Modelo() {
        this.client = new NewJerseyClient();
        this.data = new Vector();
    }

    public Vector getData() {
        return data;
    }

    public void setData(Vector data) {
        this.data = data;
    }
   
    public void crear(Alumno alumno){
        this.client = new NewJerseyClient();
        
        String data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +
            "   <alumnos> \n" +
            "       <apellidoMaterno>"+alumno.getApellidoMaterno()+"</apellidoMaterno> \n" +
            "       <apellidoPaterno>"+alumno.getApellidoPaterno()+"</apellidoPaterno> \n" +
            "       <carrera>"+alumno.getCarrera()+"</carrera> \n" +
            "       <idAlumnos>"+""+"</idAlumnos> \n" +
            "       <nombre>"+alumno.getNombre()+"</nombre> \n" +
            "       <semestre>"+alumno.getSemestre()+"</semestre> \n" +
            "   </alumnos> ";
        
        client.create_XML(data);
        
        client.close();
    }
    
    public void editar(Alumno alumno){
        this.client = new NewJerseyClient();
        
        String data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +
            "   <alumnos> \n" +
            "       <apellidoMaterno>"+alumno.getApellidoMaterno()+"</apellidoMaterno> \n" +
            "       <apellidoPaterno>"+alumno.getApellidoPaterno()+"</apellidoPaterno> \n" +
            "       <carrera>"+alumno.getCarrera()+"</carrera> \n" +
            "       <idAlumnos>"+alumno.getIdAlumno()+"</idAlumnos> \n" +
            "       <nombre>"+alumno.getNombre()+"</nombre> \n" +
            "       <semestre>"+alumno.getSemestre()+"</semestre> \n" +
            "   </alumnos> ";
        
        client.edit_XML(data, alumno.getIdAlumno());
        
        client.close();
    }
    
    public void recuperarAlumnos(){
        this.client = new NewJerseyClient();
        String data = client.findAll_XML(String.class);
        
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(data));

            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("alumnos");
            
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);

                NodeList nodo = element.getElementsByTagName("idAlumnos");
                Element line = (Element) nodo.item(0);
                //System.out.println("idAlumno: " + getCharacterDataFromElement(line));
                String idAlumnos = getCharacterDataFromElement(line);

                nodo = element.getElementsByTagName("nombre");
                line = (Element) nodo.item(0);
                //System.out.println("Nombre: " + getCharacterDataFromElement(line));
                String nombre = getCharacterDataFromElement(line);

                nodo = element.getElementsByTagName("apellidoPaterno");
                line = (Element) nodo.item(0);
                //System.out.println("Apellido Paterno: " + getCharacterDataFromElement(line));
                String apellidoPaterno = getCharacterDataFromElement(line);

                nodo = element.getElementsByTagName("apellidoMaterno");
                line = (Element) nodo.item(0);
                //System.out.println("Apellido Materno: " + getCharacterDataFromElement(line));
                String apellidoMaterno = getCharacterDataFromElement(line);

                nodo = element.getElementsByTagName("carrera");
                line = (Element) nodo.item(0);
                //System.out.println("Carrera: " + getCharacterDataFromElement(line));
                String carrera = getCharacterDataFromElement(line);

                nodo = element.getElementsByTagName("semestre");
                line = (Element) nodo.item(0);
                //System.out.println("Semestre: " + getCharacterDataFromElement(line));
                String semestre = getCharacterDataFromElement(line);
                //System.out.println("---------------------");
                
                this.data.add(new Object[]{idAlumnos, nombre, apellidoPaterno, apellidoMaterno, carrera, semestre});
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        client.close();
    }
    
    public void eliminar(String id) {
        client.remove(id);
    }
    
    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        
        if (child instanceof CharacterData) {
           CharacterData cd = (CharacterData) child;
           
           return cd.getData();
        }
        
        return "?";
    }
}
