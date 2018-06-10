import Cuento.Cuento;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
            fmt.setFormat(Format.getPrettyFormat());
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
               xmlout.setFormat(Format.getPrettyFormat());
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
     public int checaReg2(String Correo,String path , String Nombre) throws JDOMException, IOException
    {
       File xml = new File(path);
       SAXBuilder builder = new SAXBuilder();
       
       Document doc = (Document) builder.build(xml);
       Element rootnode = doc.getRootElement();
       Element Historia = rootnode.getChild("Historias");
       List lista = Historia.getChildren("Historia");
           for(int i =0;i<lista.size();i++){
                Element node = (Element) lista.get(i);
                System.out.println(node.getChildText("Correo"));
                if(node.getChildText("NombreH").equals(Nombre) && node.getAttributeValue("Creador").equals(Correo)){
                    return 1;
                }
            }
           return 0;
    }
    public int Serial(String Correo , String Nombre , String Serial , String path , String num) throws IOException{
        int res=0;
        Document doc = new Document();
        try {
            File fXmlFile = new File(path);
            SAXBuilder builder = new SAXBuilder();
            doc=builder.build(fXmlFile);
        }catch(JDOMException | IOException e ){
            System.out.println("" + e.getMessage());
        }
        Element serie = new Element ("Serial");
        serie.setText(Serial);
        serie.setAttribute("numS", num);
        List lista=doc.getRootElement().getChild("Historias").getChildren("Historia");
        Element nodo;
        Element nodo2;
        XMLOutputter xmlout= new XMLOutputter();
        for(int i =0;i<lista.size();i++){
            nodo = (Element) lista.get(i);
            if(nodo.getAttributeValue("NombreH").equals(Nombre) && nodo.getAttributeValue("Creador").equals(Correo)){
                List lista2=nodo.getChildren("Serial");
                for (int z=0; z<lista2.size();z++){
                    nodo2=(Element) lista2.get(z);
                    if(nodo2.getAttributeValue("numS").equals(num)){
                        return 0;
                    }
                }
                nodo.addContent(serie);
                xmlout.setFormat(Format.getPrettyFormat());
                xmlout.output(doc,new FileWriter(path));
                xmlout.output(doc,System.out);
                return 1;
            }   
        }
        return res;
    }
    
    public String obtenerS(String correo, String nom , String path , String numS) throws JDOMException, IOException{
       String ser="";
       File xml = new File(path);
       SAXBuilder builder = new SAXBuilder();
       Document doc = (Document) builder.build(xml);
       Element rootnode = doc.getRootElement();
       Element Historia = rootnode.getChild("Historias");
       List lista = Historia.getChildren("Historia");
           for(int i =0;i<lista.size();i++){
                Element node = (Element) lista.get(i);
               // System.out.println(node.getChildText("Correo"));
                if(node.getAttributeValue("NombreH").equals(nom) && node.getAttributeValue("Creador").equals(correo)){
                    List Lista2 = node.getChildren("Serial");
                    Element nodo2;
                    for(int j=0 ; j<lista.size(); j++)
                    {
                        nodo2=(Element)Lista2.get(j);
                        if(nodo2.getAttributeValue("numS").equals(numS))
                        {
                            return nodo2.getText();
                        }
                    }
                }
            }
        return ser;
    }
    
    public String EliminarPagina(String correo, String nom , String path , String numS) throws JDOMException, IOException{
       File xml = new File(path);
       SAXBuilder builder = new SAXBuilder();
       Document doc = (Document) builder.build(xml);
       Element rootnode = doc.getRootElement();
       Element Historia = rootnode.getChild("Historias");
       List lista = Historia.getChildren("Historia");
        System.out.println(correo);
        System.out.println(nom);
        System.out.println(numS);
         XMLOutputter xmlout= new XMLOutputter();
           for(int i =0;i<lista.size();i++){
                Element node = (Element) lista.get(i);
                if(node.getAttributeValue("NombreH").equals(nom) && node.getAttributeValue("Creador").equals(correo)){
                    List Lista2 = node.getChildren("Serial");
                    Element nodo2;
                    for(int j=0 ; j<lista.size(); j++)
                    {
                        nodo2=(Element)Lista2.get(j);
                        if(nodo2.getAttributeValue("numS").equals(numS))
                        {
                            nodo2.detach();
                            xmlout.output(doc,new FileWriter(path));
                            xmlout.output(doc,System.out);
                            return "Pagina "+numS+" eliminada";
                        }
                    }
                }
            }
        return "";
    }
    
    public String ObtenerHistoria(String Correo , String Nombre, String path) throws IOException{
        Document doc = new Document();
        try {
            File fXmlFile = new File(path);
            SAXBuilder builder = new SAXBuilder();
            doc=builder.build(fXmlFile);
        }catch(JDOMException | IOException e ){
            System.out.println("" + e.getMessage());
        }
        List lista=doc.getRootElement().getChild("Historias").getChildren("Historia");
        Element nodo;
        Element nodo2;
        Cuento C = new Cuento(Nombre);
        Gson gson = new GsonBuilder().create();
        System.out.println(Nombre);
        System.out.println(Correo);
        for(int i =0;i<lista.size();i++){
            nodo = (Element) lista.get(i);
            if(nodo.getAttributeValue("NombreH").equals(Nombre) && nodo.getAttributeValue("Creador").equals(Correo)){
                System.out.println("Hasta Aqui");
                List listaPaginas=nodo.getChildren();
                for(int o =0;o<listaPaginas.size();o++){
                    nodo2=(Element)listaPaginas.get(o);
                    C.AgregarPagina(nodo2.getAttributeValue("numS"),nodo2.getText());
                }
            }
        }
        String Cuento = gson.toJson(C);
        return Cuento;
    }
    
    
    public int editarS (String correo , String nom , String path ,String serial, String numS) throws IOException, JDOMException
    {
        File xml = new File(path);
        SAXBuilder builder = new SAXBuilder();
        Element nodo; 
        Document doc = (Document) builder.build(xml);
        Element rootnode = doc.getRootElement();
        Element Historias = rootnode.getChild("Historias");
        List lista = Historias.getChildren("Historia");
        XMLOutputter xmlout= new XMLOutputter();
        for(int i =0;i<lista.size();i++){
            Element node = (Element) lista.get(i);
            if(node.getAttributeValue("NombreH").equals(nom) && node.getAttributeValue("Creador").equals(correo)){
                List lista2 =node.getChildren("Serial");
                for(int j=0 ; j<lista2.size() ; j++)
                {
                    nodo=(Element) lista2.get(j);
                    if (nodo.getAttributeValue("numS").equals(numS))
                    {
                        nodo.setText(serial);    
                        xmlout.setFormat(Format.getPrettyFormat());
                        xmlout.output(doc,new FileWriter(path));
                        xmlout.output(doc,System.out);
                        return 1;
                  }
               }
           }   
       }
       return 0;
    }
    
    public void Cgrupo (String nom, String num , String path) throws IOException
    {
        Document doc = new Document();
        try {
            File fXmlFile = new File(path);
            SAXBuilder builder = new SAXBuilder();
            doc=builder.build(fXmlFile);
        }catch(JDOMException | IOException e ){
              System.out.println("" + e.getMessage());
        }
        Element Grupo = new Element ("Grupo");
        Grupo.setAttribute("num", num);
        Grupo.setAttribute("profesor", nom);
        doc.getRootElement().getChild("Grupos").addContent(Grupo);
        XMLOutputter fmt = new XMLOutputter();
        try (FileWriter writer = new FileWriter(path)) {
            fmt.setFormat(Format.getPrettyFormat());
            fmt.output(doc, writer);
          
            writer.flush();
        }
    }
    public int Inscribir (String correo, String grupo , String path , String nom ) throws IOException
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
        Element NombreA = new Element ("NombreA");
        NombreA.setText(nom);
        NombreA.setAttribute("correo", correo);
        List lista=doc.getRootElement().getChild("Grupos").getChildren("Grupo");
        Element nodo;
        Element nodo2;
        XMLOutputter xmlout= new XMLOutputter();
        for(int i =0;i<lista.size();i++){
            nodo = (Element) lista.get(i);
            if(nodo.getAttributeValue("num").equals(grupo)){
                    List lista2=nodo.getChildren("NombreA");
                    for (int z=0; z<lista2.size() ; z++)
                    {
                        nodo2=(Element) lista2.get(z);
                        if(nodo2.getAttributeValue("correo").equals(correo))
                        {
                            return 0;
                        }
                    }
                nodo.addContent(NombreA);
                xmlout.setFormat(Format.getPrettyFormat());
                xmlout.output(doc,new FileWriter(path));
                xmlout.output(doc,System.out);
                return 1;
            }   
       }
       return res;
    }
    public void CreateH(String correo , String nombre , String path) throws IOException
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
        Element Historia = new Element ("Historia");
        Historia.setAttribute("Creador", correo);
        Historia.setAttribute("NombreH", nombre);
       
        doc.getRootElement().getChild("Historias").addContent(Historia);
        XMLOutputter fmt = new XMLOutputter();
        try (FileWriter writer = new FileWriter(path)) {
            fmt.setFormat(Format.getPrettyFormat());
            fmt.output(doc, writer);
            res=1;
            writer.flush();
        }
    }
     public int BanGrupo(String profesor , String num , String path)throws JDOMException, IOException
    {
       File xml = new File(path);
       SAXBuilder builder = new SAXBuilder();
       
       Document doc = (Document) builder.build(xml);
       Element rootnode = doc.getRootElement();
       Element usuarios = rootnode.getChild("Grupos");
       List lista = usuarios.getChildren("Grupo");
       XMLOutputter xmlout= new XMLOutputter();
       for(int i =0;i<lista.size();i++){
           Element node = (Element) lista.get(i);
           if(node.getAttributeValue("profesor").equals(profesor) && node.getAttributeValue("num").equals(num)){
               node.detach();
               xmlout.output(doc,new FileWriter(path));
               xmlout.output(doc,System.out);
               return 1;
           }   
       }
       return 0;
    }
     public void BanAlumno (String profesor , String num , String path , String correo) throws IOException, JDOMException
     {
          File xml = new File(path);
       SAXBuilder builder = new SAXBuilder();
       
       Document doc = (Document) builder.build(xml);
       Element rootnode = doc.getRootElement();
       Element usuarios = rootnode.getChild("Grupos");
       List lista = usuarios.getChildren("Grupo");
       List lista2;
       Element nodo;
       XMLOutputter xmlout= new XMLOutputter();
       for(int i =0;i<lista.size();i++){
           Element node = (Element) lista.get(i);
           if(node.getAttributeValue("profesor").equals(profesor) && node.getAttributeValue("num").equals(num)){
               lista2 = node.getChildren("NombreA");
               for(int j=0; j<lista2.size() ; j++)
               {
                   nodo=(Element) lista2.get(j);
                   if(nodo.getAttributeValue("correo").equals(correo))
                   {
               nodo.detach();
               xmlout.output(doc,new FileWriter(path));
               xmlout.output(doc,System.out);
                   }
               }
              
           }   
       }
         
     }
}