/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ertim
 */
public class Registrarse extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession sesion = request.getSession(false);
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            String correo=(String) sesion.getAttribute("Correo");
            String nombre=(String) sesion.getAttribute("Nombre");
            Operaciones ops = new Operaciones();
            if(correo==null){
                out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>TODO supply a title</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/bulma.css\">\n" +
"        <script src=\"JS/Validaciones.js\"></script>\n" +
"    </head>\n" +
"    <body>\n"
+ "<section class='section'>" +
"        <div class=\"\">\n" +
"            <form action=\"registro\" method=\"get\" onsubmit=\"return validaP(this);\" >\n" +
"            <H1 class=\"title is-3 has-text-centered\">Registro</H1><br>            \n" +
"                <label for=\"correo\" class=\"label\">Correo:</label><input class=\"input\" type=\"text\" name=\"correo\"/><br/>\n" +
"                <label for=\"nom\" class=\"label\">Nombre:</label><input class=\"input\" type=\"text\" name=\"nom\"/><br/>\n" +
"                <label for=\"password\" class=\"label\">Contraseña:</label><input class=\"input\" type=\"password\" name=\"pass\"/><br/>\n" +
"                <label for=\"password1\" class=\"label\">Repetir Contraseña:</label><input class=\"input\" type=\"password\" name=\"pass1\"/><br/>\n" +
"                <label for=\"tipo\" class=\"label\">Tipo de usuario:</label>\n" +
"                <select class=\"select is-medium is-pulled-left\" name=\"tipo\">\n" +
"                    <option value=\"1\">Creador</option>\n" +
"                    <option value=\"2\" selected>Usuario</option>\n" +
"                </select>\n" +
"                <br>\n" +
"                <input class=\"button is-link is-pulled-right\" type=\"submit\"/>\n" +
"            </form>\n" +
"        </div>\n"
+ "</section>" +
"    </body>\n" +
"</html>");
            }else{
                out.println("<H1>¡FUERA DE AQUI!</H1>");
            }
    }
    
            
}
