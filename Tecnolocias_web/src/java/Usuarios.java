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
        PrintWriter out = response.getWriter();
      if(sesion.getAttribute("CorreoU")!= null && ((String)sesion.getAttribute("Tipo")).equalsIgnoreCase("Administrador"))
        {
                String path = request.getRealPath("/archivo_xml");
                path=path + "/base.xml";
                String correo =(String)sesion.getAttribute("CorreoU");
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
                if (!node.getChildText("Correo").equals(correo))
                {
                out.println("<tr><td>"+node.getChildText("Correo")+"</td><td>"+node.getChildText("Rol")+" </td> <td><a href='CambiosS?correo="+node.getChildText("Correo")+"'>Cambiar</a></td> <td> <a href='Ban?correo="+node.getChildText("Correo")+"'>Eliminar</a></td> </tr>");
                } }
            out.println("</table>");
            out.println("<h3><a href='add'> Agregar Usuarios </a> </h3><br/>");
            out.println("<br/><br/><form action='logout' method='get'>"
                        + "<input type='submit' value='Salir'>"
                        + "</form> ");
            
            out.println("</body>");
            out.println("</html>");
        }
      else
      {
                out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<body bgcolor='#A2E375'>");
                        out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.0.3/sweetalert2.all.js\"></script>");
                        out.println("<script>");
                        out.println(" swal({\n" +
                                "  title: 'Error',\n" +
                                "  text: \"Inicia Sesion  !\",\n" +
                                "  type: 'error',\n" +
                                "  showCancelButton: false,\n" +
                                "  confirmButtonColor: '#d33',\n" +
                                "  cancelButtonColor: '#d33',\n" +
                                "  confirmButtonText: 'OK'\n" +
                                "}).then(function (result) {\n" +
                                "  if (result.value) {\n" +
                                "   window.location.href=\"index.html\";"+
                                "  }else{ window.location.href=\"index.html\";}\n" +
                                "})");
                        out.println("</script>");
                        out.println("</body>");
                        out.println("</html>");
      }
        
    }

 
   
}
