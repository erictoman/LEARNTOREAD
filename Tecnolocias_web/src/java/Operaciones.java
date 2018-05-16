import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom.output.XMLOutputter;
import org.xml.sax.SAXException;

public class Operaciones {
    
    
    public int login (String nom, String pass , String path)
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
                System.out.println("aqui");
                System.out.println("" + usuario.getChildText("Nombre"));
                if(usuario.getChildText("Nombre").equals(nom) && usuario.getChildText("Contra").equals(pass)){
                    res=1; 
                }
            }
	  } catch (IOException | JDOMException io) {
		System.out.println(io.getMessage());
	  }
          return res;
    }
    public int registro (String nom, String pass , String tipo , String path) throws ParserConfigurationException, SAXException, IOException, JDOMException
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
        Element Nombre = new Element ("Nombre");
        Element Contra = new Element ("Contra");
        Element Rol = new Element ("Rol");
        Nombre.setText(nom);
        Contra.setText(pass);
        Rol.setText(tipo);
        Usuario.addContent(Nombre);
        Usuario.addContent(Contra);
        Usuario.addContent(Rol);
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
}