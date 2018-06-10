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

public class Inscribir extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
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
        Element Grupos = rootnode.getChild("Grupos");
        List lista2 = Grupos.getChildren("Grupo");
     
          /* for(int i =0;i<lista.size();i++){
                Element node = (Element) lista.get(i);
                if(node.getChildText("Correo").equals(Correo)){
                    return node.getChildText("Rol");
                }
            }*/
      
        Element node;
        Element node2;
        if(sesion.getAttribute("CorreoU")!= null && ((String)sesion.getAttribute("Tipo")).equalsIgnoreCase("Administrador")){
            out.print("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
"        <script>  $(document).ready(function(){\n" +
"                    $(\"#botonguardar\").click(function() {\n" +
"                        \n" +
"                        $.ajax({\n" +
"                            url: \"Inscripcion\",\n" +
"                            type: \"get\", //send it through get method\n" +
"                            data: {\n" +
"                                grupo:$('select[name=grupo]').val(), \n" +
"                                nom:$('select[name=text]').val()\n" +
"                            },\n" +
"                            success: function(response) {\n" +
"                                alert(\"¡GUARDADO!\");\n" +
"                                                        window.parent.location='index.html'\n" +
"                            },\n" +
"                            error: function(xhr) {\n" +
"                                alert(\"Error!\"); window.parent.location='index.html'\n" +
"                            }\n" +
"                        });\n" +
"                    });\n" +
"                });			\n" +
"        </script>\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/bulma.css\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <section class=\"section\">\n" +
"            <h1 class=\"title is-3 has-text-centered\">Crea un grupo adminsitrador</h1>\n"
                    + "<div class='has-text-centered'>" +
"            <p>Solo es necesario escribir el nombre del profesor y listo en la parte de registar alumnos podras inscrbirlos</p>\n" +
"            <label class=\"label\">Selecciona al Alumno </label> \n" +
"            <select class=\"select\"  name='text'> \n");
        for(int z=0; z<lista.size() ; z++){
            node=(Element) lista.get(z);
            if (node.getChildText("Rol").equals("Alumno"))
            {
                out.println("<option value='"+node.getChildText("Correo")+"'>"+node.getChildText("Correo")+"</option>");
            }
        }  
        out.print("            </select><br>\n" +
"            <label class=\"label\">Selecciona el grupo</label>\n" +
"            <select class=\"select\"  name='grupo'> \n");
            for(int z=0; z<lista2.size() ; z++)
            {
                node2=(Element) lista2.get(z);
                out.println("<option value='"+node2.getAttributeValue("num")+"'>"+node2.getAttributeValue("num")+"</option>");
            }
out.print("            </select><br>\n" +
"            <button class=\"button is-info is-pulled-right\" id=\"botonguardar\">Guardar</button><br>\n"
        + "</div>"
        + "" +
"        </section>\n" +
"    </body>\n" +
"</html>");
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




    

  


