/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;


public class CambiosS extends HttpServlet {

 
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
   String correo = request.getParameter("correo");
   String Nombre="" ;
   String Pass="";
    HttpSession sesion = request.getSession();
    int res=0;
                String path = request.getRealPath("/archivo_xml");
                path=path + "/base.xml";
   SAXBuilder builder = new SAXBuilder();
	File xmlFile = new File(path);
	try {
            Document document = (Document) builder.build(xmlFile);	
            Element rootNode = document.getRootElement();
            Element usuarios = rootNode.getChild("Usuarios");
            List list =usuarios.getChildren("Usuario");
            for (int i = 0; i < list.size(); i++) {
                Element usuario = (Element) list.get(i);
                if(usuario.getChildText("Correo").equals(correo)){
                    Nombre=usuario.getChildText("Nombre");
                    Pass= usuario.getChildText("Contra");
                    res=1;
                }
            }
	  } catch (IOException | JDOMException io) {
		System.out.println(io.getMessage());
	  }
        
        if(res==1){
            sesion.setAttribute("correoCambiar", correo);
        out.println("<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "    <head>\n" +
                        "        <title>TODO supply a title</title>\n" +
                        "        <meta charset=\"UTF-8\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "        <script src=\"JS/Validaciones.js\"></script>\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <form action=\"CambiarInfoS\" method=\"get\" >\n" +
                        "            <label for=\"correo\">Correo:</label><input type=\"text\" name=\"correo\" value='"+correo+"'/><br/>\n" +
                        "            <label for=\"nom\">Nombre:</label><input type=\"text\" name=\"nom\" value='"+Nombre+"'/><br/>\n" +
                        "            <label for=\"password\">Contraseña:</label><input type=\"hidden\" name=\"pass\" value='"+Pass+"'/><br/>\n" +
                       
                        "            <br>\n" +
                        "            <input type=\"submit\"/>\n" +
                        "        </form>\n" +
                        "    </body>\n" +
                        "</html>\n" +
                        "");
            }else{
                out.println("<H1>¡FUERA DE AQUI!</H1>");
            }
        
    }

   

}
