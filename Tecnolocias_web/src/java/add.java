

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;


public class add extends HttpServlet {

   
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
          response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(sesion.getAttribute("CorreoU")!= null && ((String)sesion.getAttribute("Tipo")).equalsIgnoreCase("Administrador"))
        {

            if(request.getParameter("altas")!=null)
            {
                String nom = request.getParameter("nom");
                String pass = request.getParameter("pass");
                String tipo = request.getParameter("tipo");
                String correo = request.getParameter("correo");
                Operaciones ope = new Operaciones ();
                String path = request.getRealPath("archivo_xml");
                path=path + "/base.xml";
                int registro=0;
                try {
                    if(ope.checaReg(correo,path)==0){
                        registro=ope.registro(nom, pass, tipo, path,correo);
                        if(registro==1){
                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<body bgcolor='#A2E375'>");
                            out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.0.3/sweetalert2.all.js\"></script>");
                            out.println("<script>");
                            out.println(" swal({\n" +
                                    "  title: 'Correcto',\n" +
                                    "  text: \"Bienvenido !\",\n" +
                                    "  type: 'success',\n" +
                                    "  showCancelButton: false,\n" +
                                    "  confirmButtonColor: '#d33',\n" +
                                    "  cancelButtonColor: '#d33',\n" +
                                    "  confirmButtonText: 'OK'\n" +
                                    "}).then(function (result) {\n" +
                                    "  if (result.value) {\n" +
                                    "   window.location.href=\"ind.html\";"+
                                    "  }else{ window.location.href=\"index.html\";}\n" +
                                    "})");
                            out.println("</script>");
                            out.println("</body>");
                            out.println("</html>");
                        }else{
                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<body bgcolor='#A2E375'>");
                            out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.0.3/sweetalert2.all.js\"></script>");
                            out.println("<script>");
                            out.println(" swal({\n" +
                                    "  title: 'Error',\n" +
                                    "  text: \"Usuario o contraseña incorrecta !\",\n" +
                                    "  type: 'error',\n" +
                                    "  showCancelButton: false,\n" +
                                    "  confirmButtonColor: '#d33',\n" +
                                    "  cancelButtonColor: '#d33',\n" +
                                    "  confirmButtonText: 'OK'\n" +
                                    "}).then(function (result) {\n" +
                                    "  if (result.value) {\n" +
                                    "   window.location.href=\"Login\";"+
                                    "  }else{ window.location.href=\"Login\";}\n" +
                                    "})");
                            out.println("</script>");
                            out.println("</body>");
                            out.println("</html>");
                        }
                    }else{
                        out.print("<H1>USUARIO CREADO PREVIAMENTE</H1>");
                    }
                } catch (JDOMException ex) {
                    Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SAXException ex) {
                    Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                    out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>LEARNTOREAD</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <script src=\"JS/Validaciones.js\"></script>\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/bulma.css\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <h1 class=\"title is-3 has-text-centered\">Agregar Usuario</h1>\n" +
"        <section class=\"section\">\n" +
"            <form action=\"registro\" method=\"get\" onsubmit=\"return validaP(this);\" >\n" +
"                <label class=\"label\" for=\"correo\">Correo:</label><input class=\"input\" type=\"text\" name=\"correo\" required /><br/>\n" +
"                <label class=\"label\" for=\"nom\">Nombre:</label><input class=\"input\" type=\"text\" name=\"nom\"  required /><br/>\n" +
"                <label class=\"label\" for=\"password\">Contraseña:</label><input class=\"input\" type=\"password\" name=\"pass\"  required /><br/>\n" +
"                <label class=\"label\" for=\"password1\">Repetir Contraseña:</label><input class=\"input\" type=\"password\" name=\"pass1\"  required /><br/>\n" +
"                <label class=\"label\" for=\"tipo\">Tipo de usuario:</label>\n" +
"                <select name=\"tipo\" class=\"select is-size-6\">\n" +
"                    <option value=\"Profesor\">Profesor</option>\n" +
"                    <option value=\"Alumno\" selected>Alumno</option>\n" +
"                </select>\n" +
"                <br>\n" +
"                <input type=\"submit\" class=\"button is-info is is-pulled-right\" name='altaS' value='Registar'/>\n" +
"            </form>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
            }
        }else{
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
