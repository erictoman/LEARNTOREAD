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

/**
 *
 * @author ertim
 */
public class index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
            HttpSession sesion = request.getSession();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            if(sesion.getAttribute("Correo")!=null){
                if(sesion.getAttribute("Tipo").equals("Administrador")){
                    out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>TODO supply a title</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/bulma.css\">\n" +
"    </head>\n" +
"    <body>\n"
                            + "<section class='section'>" +
"        <div class=\"control has-text-centered\">\n" +
"            <H1 class=\"title is-3 has-text-centered\">Bienvenido "+sesion.getAttribute("Tipo")+" "+sesion.getAttribute("Nombre")+"</H1>\n" +
"            <form action='Usuarios' method='get'>\n" +
"                <input class=\"button is-info\" type='submit' value='Control'/><br> \n" +
"            </form>\n" +
"            <a class=\"button\" href='Grupo'> Crear grupo</a>\n" +
"            <br>\n" +
"            <a class=\"button is-info\" href='Inscribir'>Inscribir alumnos</a><br>\n" +
        "            <a class=\"button is-info\" href='Alumnos'>Ver grupos</a><br>\n" +
"            <form action='logout' method='get'>\n" +
"                <input class=\"button\" type='submit' value='Salir'><br>\n" +
"            </form>\n" +
"        </div>\n"
                            + "</section>" +
"    </body>\n" +
"</html>");   
                }
                else
                {
                    if(sesion.getAttribute("Tipo").equals("Profesor"))
                    {
                    out.print("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>LEARNTOREAD</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/bulma.css\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <section class=\"section\">\n" +
"            <div class=\"control has-text-centered\">\n" +
"                <H1 class=\"title has-text-centered is-3\">Bienvenido "+sesion.getAttribute("Tipo")+" "+sesion.getAttribute("Nombre")+"</H1>\n" +
"                <a href=\"Cambios\" class=\"button is-info\">Cambiar informacion de cuenta</a>\n" +
"                <br/>\n" +
"                <a href='Diagramas' class=\"button\">Lecturas </a>\n" +
"                <form action='Subir' method='post'> \n" +
"                    <input class=\"button is-info\" type='submit' name='forma' value='SubirImagen' />\n" +
"                </form>\n" +
"                <form action='logout' method='get'>\n" +
"                    <input class=\"button\" type='submit' value='Salir'>\n" +
"                </form>           \n" +
"            </div>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
                    }else{//Sesion alumno
                         out.print("<H1>Bienvenido "+sesion.getAttribute("Tipo")+" "+sesion.getAttribute("Nombre")+ "</H1>"
                        + "<a href=\"Cambios\">Cambiar informacion de cuenta</a>");
                out.println("<br/><br/><form action='logout' method='get'>"
                        + "<input type='submit' value='Salir'>"
                        + "</form> ");
                    }
                }
            }else{
                out.println(""
                        + "<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>LEARNTOREAD</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/bulma.css\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <h1 class=\"title is-2 has-text-centered\">Inicia sesion para tener acceso al sitio </h1>\n" +
"        <section class=\"section\">\n" +
"            <form class=\"\" action=\"Login\" method=\"get\">\n" +
"                <div class=\"control\">\n" +
"                    <label for=\"user\" class=\"label\">Correo:</label><input class=\"input\" type=\"text\" name=\"user\"/><br/>\n" +
"                    <label for=\"pass\" class=\"label\">Contraseña:</label><input class=\"input\" type=\"password\" name=\"pass\"/><br/>\n" +
"                    <br>\n" +
"                    <div class=\"field is-grouped is-pulled-right has-text-centered\">\n" +
"                        <div class=\"control\">\n" +
"                            <input type=\"submit\" class=\"button is-link\"/>\n" +
"                        </div>\n" +
"                        <div class=\"control\">\n" +
"                            <a class=\"button is-text\" href=\"Registrarse\">Registro</a>\n" +
"                        </div>\n" +
"                    </div>        \n" +
"                </div>\n" +
"            </form>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
            }
        }
    }
