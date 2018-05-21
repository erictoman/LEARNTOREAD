import com.sun.faces.facelets.util.FastWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom.Namespace;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.SAXException;

public class Operaciones {
    
    
    public int login (String Correo, String pass , String path)
    {
        int res=0;
        SAXBuilder builder = new SAXBuilder();
	File xmlFile = new File(path);
	try {
            Document document = (Document) builder.build(xmlFile);	
            Element rootNode = document.getRootElement();
            Element usuarios = rootNode.getChild("Usuarios");
            List list =usuarios.getChildren("Usuario");
            for (int i = 0; i < list.size(); i++) {
                Element usuario = (Element) list.get(i);
                if(usuario.getChildText("Correo").equals(Correo) && usuario.getChildText("Contra").equals(pass)){
                    res=1; 
                }
            }
	  } catch (IOException | JDOMException io) {
		System.out.println(io.getMessage());
	  }
          return res;
    }
    public int registro (String nom, String pass , String tipo , String path, String correo) throws ParserConfigurationException, SAXException, IOException, JDOMException
    {
        int res=0;
        Document doc = new Document();
        try {
            File fXmlFile = new File(path);
            SAXBuilder builder = new SAXBuilder();
            doc=builder.build(fXmlFile);
        }catch(JDOMException | IOException e ){
              System.out.println("" + e.getMessage());
        }
        Element Usuario = new Element ("Usuario");
        Element Correo = new Element ("Correo");
        Element Nombre = new Element ("Nombre");
        Element Contra = new Element ("Contra");
        Element Rol = new Element ("Rol");
        Nombre.setText(nom);
        Contra.setText(pass);
        Correo.setText(correo);
        Rol.setText(tipo);
        Usuario.addContent(Nombre);
        Usuario.addContent(Contra);
        Usuario.addContent(Rol);
        Usuario.addContent(Correo);
        doc.getRootElement().getChild("Usuarios").addContent(Usuario);
        XMLOutputter fmt = new XMLOutputter();
        try (FileWriter writer = new FileWriter(path)) {
            fmt.output(doc, writer);
            res=1;
            writer.flush();
        }
        System.out.println(path);
            return res;
    }
    public int cambios (String nom, String pass, String path,String Correo, String CorreoO) throws JDOMException, IOException
    {
      File xml = new File(path);
       SAXBuilder builder = new SAXBuilder();
       
       Document doc = (Document) builder.build(xml);
       Element rootnode = doc.getRootElement();
       Element usuarios = rootnode.getChild("Usuarios");
       List lista = usuarios.getChildren("Usuario");
       XMLOutputter xmlout= new XMLOutputter();
       for(int i =0;i<lista.size();i++){
           Element node = (Element) lista.get(i);
           if(node.getChildText("Correo").equals(CorreoO)){
               System.out.println(Correo);
               node.getChild("Nombre").setText(nom);
               node.getChild("Contra").setText(pass);
               node.getChild("Correo").setText(Correo);
               xmlout.output(doc,new FileWriter(path));
               xmlout.output(doc,System.out);
                return 1;
           }   
       }
       return 0;
    }
    
    public int checaReg(String Correo,String path) throws JDOMException, IOException
    {
       File xml = new File(path);
       SAXBuilder builder = new SAXBuilder();
       
       Document doc = (Document) builder.build(xml);
       Element rootnode = doc.getRootElement();
       Element usuarios = rootnode.getChild("Usuarios");
       List lista = usuarios.getChildren("Usuario");
           for(int i =0;i<lista.size();i++){
                Element node = (Element) lista.get(i);
                System.out.println(node.getChildText("Correo"));
                if(node.getChildText("Correo").equals(Correo)){
                    return 1;
                }
            }
       return 0;
    }
    public String obtenNombre(String Correo,String path) throws JDOMException, IOException
    {
       File xml = new File(path);
       SAXBuilder builder = new SAXBuilder();
       
       Document doc = (Document) builder.build(xml);
       Element rootnode = doc.getRootElement();
       Element usuarios = rootnode.getChild("Usuarios");
       List lista = usuarios.getChildren("Usuario");
           for(int i =0;i<lista.size();i++){
                Element node = (Element) lista.get(i);
                if(node.getChildText("Correo").equals(Correo)){
                    return node.getChildText("Nombre");
                }
            }
        return "";
    }
    public String obtenTipo (String Correo , String path)throws JDOMException, IOException
    {
       File xml = new File(path);
       SAXBuilder builder = new SAXBuilder();
       
       Document doc = (Document) builder.build(xml);
       Element rootnode = doc.getRootElement();
       Element usuarios = rootnode.getChild("Usuarios");
       List lista = usuarios.getChildren("Usuario");
           for(int i =0;i<lista.size();i++){
                Element node = (Element) lista.get(i);
                if(node.getChildText("Correo").equals(Correo)){
                    return node.getChildText("Rol");
                }
            }
        return "";
    }
    
    public int Ban(String Correo , String path)throws JDOMException, IOException
    {
       File xml = new File(path);
       SAXBuilder builder = new SAXBuilder();
       
       Document doc = (Document) builder.build(xml);
       Element rootnode = doc.getRootElement();
       Element usuarios = rootnode.getChild("Usuarios");
       List lista = usuarios.getChildren("Usuario");
       XMLOutputter xmlout= new XMLOutputter();
       for(int i =0;i<lista.size();i++){
           Element node = (Element) lista.get(i);
           if(node.getChildText("Correo").equals(Correo)){
               node.detach();
               xmlout.output(doc,new FileWriter(path));
               xmlout.output(doc,System.out);
                return 1;
           }   
       }
       return 0;
    }
}