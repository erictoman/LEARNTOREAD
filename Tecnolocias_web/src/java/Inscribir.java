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
public class Inscribir extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Inscribir</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Inscribir at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         HttpSession sesion = request.getSession();
            /* TODO output your page here. You may use following sample code. */
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
                    
                    "<script>  $(document).ready(function(){\n" +
"			$(\"#botonguardar\").click(function() {\n" +
"				\n" +
"				$.ajax({\n" +
"					url: \"Inscripcion\",\n" +
"					type: \"get\", //send it through get method\n" +
"					data: {\n" +
"						grupo:$('select[name=grupo]').val(), \n" +
"						nom:$('select[name=text]').val()\n" +
"					},\n" +
"					success: function(response) {\n" +
"						alert(\"¡GUARDADO!\");\n" +
"                                                window.parent.location='Diagramas'\n" +
"					},\n" +
"					error: function(xhr) {\n" +
"						alert(\"Error!\"); "
        + "window.parent.location='Diagramas'\n" +
"					}\n" +
"				});\n" +
"			});\n" +
"			\n" +
"			\n" +
"			\n" +
"	  	});" +
"			</script>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Crea un grupo adminsitrador</h1> <br/>");
            out.println("Solo es necesario escribir el nombre del profesor y listo en la parte de registar alumnos podras inscrbirlos <br/>" );
            out.println("<label>Selecciona al Alumno </label> <select  name='text'> ");
            for(int z=0; z<lista.size() ; z++)
            {
                node=(Element) lista.get(z);
               if (node.getChildText("Rol").equals("Alumno"))
                {
              
            out.println("<option value='"+node.getChildText("Correo")+"'>"+node.getChildText("Correo")+"</option>");
                }
            }
            out.println("</select>");
             out.println("<label>Selecciona el grupo </label> <select  name='grupo'> ");
            for(int z=0; z<lista2.size() ; z++)
            {
                node2=(Element) lista2.get(z);
                        
            out.println("<option value='"+node2.getAttributeValue("num")+"'>"+node2.getAttributeValue("num")+"</option>");
             
            }
            out.println("</select>");
            out.println(" <button id=\"botonguardar\">Guardar</button><br> </body>");
            out.println("</html>");
        }
    }




    

  


