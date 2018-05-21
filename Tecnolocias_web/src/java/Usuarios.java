/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author Marcus
 */
public class Usuarios extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
     response.setContentType("text/html;charset=UTF-8");
      HttpSession sesion = request.getSession();
                String path = request.getRealPath("/archivo_xml");
                path=path + "/base.xml";
     File xml = new File(path);
       SAXBuilder builder = new SAXBuilder();
      Document doc = null; 
        try {
            doc = (Document) builder.build(xml);
        } catch (JDOMException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
       Element rootnode = doc.getRootElement();
       Element usuarios = rootnode.getChild("Usuarios");
       List lista = usuarios.getChildren("Usuario");
          /* for(int i =0;i<lista.size();i++){
                Element node = (Element) lista.get(i);
                if(node.getChildText("Correo").equals(Correo)){
                    return node.getChildText("Rol");
                }
            }*/
        PrintWriter out = response.getWriter();
          Element node;
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Usuarios</h1>");
            out.println("<table border='1'>");
            out.println("<tr><td>Usuario</td> <td>Tipo</td></tr>");
            for(int i=0; i<lista.size(); i++)
            {
                node=(Element) lista.get(i);
                out.println("<tr><td>"+node.getChildText("Correo")+"</td><td>"+node.getChildText("Rol")+" </td> <td><a href='CambiosS?correo="+node.getChildText("Correo")+"'>Cambiar</a></td> <td> <a href='Ban?correo="+node.getChildText("Correo")+"'>Eliminar</a></td> </tr>");
            }
            out.println("</table>");
            out.println("<h3><a href='add'> Agregar Usuarios </a> </h3>");
            out.println("</body>");
            out.println("</html>");
        
    }

 
   
}
