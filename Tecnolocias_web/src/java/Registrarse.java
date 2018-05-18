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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
"        <script src=\"JS/Validaciones.js\"></script>\n" +
"    </head>\n" +
"    <body>\n" +
"        <form action=\"registro\" method=\"get\" onsubmit=\"return validaP(this);\" >\n"
                        + "<H1>Registro</H1><br>" +
"            <label for=\"correo\">Correo:</label><input type=\"text\" name=\"correo\"/><br/>\n" +
"            <label for=\"nom\">Nombre:</label><input type=\"text\" name=\"nom\"/><br/>\n" +
"            <label for=\"password\">Contraseña:</label><input type=\"password\" name=\"pass\"/><br/>\n" +
"            <label for=\"password1\">Repetir Contraseña:</label><input type=\"password\" name=\"pass1\"/><br/>\n" +
"            <label for=\"tipo\">Tipo de usuario:</label>\n" +
"            <select name=\"tipo\">\n" +
"                <option value=\"1\">Creador</option>\n" +
"                <option value=\"2\" selected>Usuario</option>\n" +
"            </select>\n" +
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
