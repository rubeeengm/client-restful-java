package clientrestfull;

import itver.edu.NewJerseyClient;
import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import java.io.*;
import java.util.Vector;

public class Modelo {
    private NewJerseyClient client;
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
   
   // public static void main(String[] args) {
     //   Modelo c = new Modelo();
//        
//        c.buscarAlumno("1");
        //String xml = client.findAll_XML(String.class);
        //c.registrar();
        //System.out.println(xml);
        //c.recuperarAlumnos();
//        client.edit_XML("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +
//            "   <alumnos> \n" +
//            "   <apellidoMaterno>"+"Málaga"+"</apellidoMaterno> \n" +
//            "       <apellidoPaterno>"+"Ponce"+"</apellidoPaterno> \n" +
//            "       <carrera>"+"Ing. Sistemas"+"</carrera> \n" +
//            "       <idAlumnos>"+"1"+"</idAlumnos> \n" +
//            "       <nombre>"+"Ruben"+"</nombre> \n" +
//            "       <semestre>"+"10"+"</semestre> \n" +
//            "   </alumnos> ", "1");
//        client.remove("3");
   //}
    
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
    
//    public void actualizar(){
//        System.out.println("Ingresa tu nombre: ");
//        String nombre = teclado.nextLine();
//        System.out.println("Ingresa tu apellido paterno: ");
//        String apellidoPaterno = teclado.nextLine();
//        System.out.println("Ingresa tu apellido materno: ");
//        String apellidoMaterno = teclado.nextLine();
//        System.out.println("Ingresa tu carrera: ");
//        String carrera = teclado.nextLine();
//        System.out.println("Ingresa tu semestre");
//        String semestre = String.valueOf(teclado.nextInt());
//        int idAlumnos = Integer.parseInt(client.countREST())+1;
//        
//        String data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +
//            "   <alumnos> \n" +
//            "       <apellidoMaterno>"+apellidoMaterno+"</apellidoMaterno> \n" +
//            "       <apellidoPaterno>"+apellidoPaterno+"</apellidoPaterno> \n" +
//            "       <carrera>"+carrera+"</carrera> \n" +
//            "       <idAlumnos>"+idAlumnos+"</idAlumnos> \n" +
//            "       <nombre>"+nombre+"</nombre> \n" +
//            "       <semestre>"+semestre+"</semestre> \n" +
//            "   </alumnos> ";
//        
//        client.edit_XML(data,String.valueOf(idAlumnos));
//        
//        client.close();
//    }
    
//    public void buscarAlumno(String id){
//        String xml = client.find_XML(String.class, id);
//        
//        try {
//            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//            DocumentBuilder db = dbf.newDocumentBuilder();
//            InputSource is = new InputSource();
//            is.setCharacterStream(new StringReader(xml));
//
//            Document doc = db.parse(is);
//            NodeList nodes = doc.getElementsByTagName("alumnos");
//
//            Element element = (Element) nodes.item(0);
//
//            NodeList idAlumnos = element.getElementsByTagName("idAlumnos");
//            Element line = (Element) idAlumnos.item(0);
//            System.out.println("idAlumno: " + getCharacterDataFromElement(line));
//
//            NodeList nombre = element.getElementsByTagName("nombre");
//            line = (Element) nombre.item(0);
//            System.out.println("Nombre: " + getCharacterDataFromElement(line));
//
//            NodeList apellidoPaterno = element.getElementsByTagName("apellidoPaterno");
//            line = (Element) apellidoPaterno.item(0);
//            System.out.println("Apellido Paterno: " + getCharacterDataFromElement(line));
//
//            NodeList apellidoMaterno = element.getElementsByTagName("apellidoMaterno");
//            line = (Element) apellidoMaterno.item(0);
//            System.out.println("Apellido Materno: " + getCharacterDataFromElement(line));
//
//            NodeList carrera = element.getElementsByTagName("carrera");
//            line = (Element) carrera.item(0);
//            System.out.println("Carrera: " + getCharacterDataFromElement(line));
//
//            NodeList semestre = element.getElementsByTagName("semestre");
//            line = (Element) semestre.item(0);
//            System.out.println("Semestre: " + getCharacterDataFromElement(line));
//            
//            client.close();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
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
