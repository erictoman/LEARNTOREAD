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
public class Alumnos extends HttpServlet {

 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        try
        {
        Element rootnode = doc.getRootElement();
        Element Historias = rootnode.getChild("Grupos");
        List lista = Historias.getChildren("Grupo");
          /* for(int i =0;i<lista.size();i++){
                Element node = (Element) lista.get(i);
                if(node.getChildText("Correo").equals(Correo)){
                    return node.getChildText("Rol");
                }
            }*/
            Element node;
            Element node2;
            List lista2=null;
          out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/bulma.css\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <section class=\"section\">\n" +
"            <div class=\"has-text-centered\">\n" +
"            <h1 class=\"title is-3 has-text-centered\">Grupos</h1>\n" +
"            <table class=\"table is-bordered\">\n" +
"                <tfoot>\n");
                for(int i=0; i<lista.size(); i++){
                node=(Element) lista.get(i);
              
                    lista2=node.getChildren("NombreA");
                    out.println("<tr><th>Grupo:  "+node.getAttributeValue("num")+"</th> <th>Profesor: "+node.getAttributeValue("profesor")+"</th>"
                            + " <th> <a href='BanGrup?num="+node.getAttributeValue("num")+"&profesor="+node.getAttributeValue("profesor")+"'>Eliminar</a> </th><tr>");
                            
                    try{
                        for (int j=0 ; j<lista2.size(); j++){
                            node2 = (Element) lista2.get(j);
                            out.println("<tr><td>"+(j+1) +" Alumno: "+node2.getText()+"</td> <td>Correo: "+node2.getAttributeValue("correo")+"</td> "
                                    + " <th> <a href='BanAlum?num="+node.getAttributeValue("num")+"&profesor="+node.getAttributeValue("profesor")+"&correo="+node2.getAttributeValue("correo")+" '>Eliminar</a> </th><tr>");
                            }
                        }
                    catch(Exception e){
                     out.print("<tr><th> No tiene historias </th></tr>");
                    }
                
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        }else{
                out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<body bgcolor='#A2E375'>");
                        out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.0.3/sweetalert2.all.js\"></script>");
                        out.println("<script>");
                        out.println(" swal({\n" +
                                "  title: 'Error',\n" +
                                "  text: \"¡Inicia Sesion!\",\n" +
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