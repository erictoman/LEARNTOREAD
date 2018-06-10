/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Cambios extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
            HttpSession sesion = request.getSession(false);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            String correo=(String) sesion.getAttribute("Correo");
            String nombre=(String) sesion.getAttribute("Nombre");
            Operaciones ops = new Operaciones();
            if(correo!=null){
                  sesion.setAttribute("correoCambiar", correo);
                out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>TODO supply a title</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <script src=\"JS/Validaciones.js\"></script>\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/bulma.css\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <section class=\"section\">\n" +
"        <form action=\"CambiarInfo\" method=\"get\" onsubmit=\"return validaP(this);\" >\n" +
"            <H1 class=\"title is-3 has-text-centered\">Cambios en el perfil</H1>\n" +
"            <label class=\"label\" for=\"correo\">Correo:</label><input class=\"input\" type=\"text\" name=\"correo\" value='"+correo+"'/><br/>\n" +
"            <label class=\"label\" for=\"nom\">Nombre:</label><input class=\"input\" type=\"text\" name=\"nom\" value='"+nombre+"'/><br/>\n" +
"            <label class=\"label\" for=\"password\">Contraseña:</label><input class=\"input\" type=\"password\" name=\"pass\"/><br/>\n" +
"            <label class=\"label\" for=\"password1\">Repetir Contraseña:</label><input class=\"input\" type=\"password\" name=\"pass1\"/><br/>\n" +
"            <br>\n" +
"            <input class=\"button is-info is-pulled-right\" type=\"submit\"/>\n" +
"        </form>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
            }else{
                out.println("<H1>¡FUERA DE AQUI!</H1>");
            }
        }
}
