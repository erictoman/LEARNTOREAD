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
                if(sesion.getAttribute("Tipo").equals("Profesor")){
                    out.println("<!DOCTYPE html>\n" +
            "\n" +
            "<html>\n" +
            "    <head>\n" +
            "        <title>TODO supply a title</title>\n" +
            "        <meta charset=\"UTF-8\">\n" +
            "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    </head>\n" +
            "    <body>\n" + "<H1>Bienvenido "+sesion.getAttribute("Tipo") +" "+sesion.getAttribute("Nombre")+"</H1> <br/> <form action='Usuarios' method='get'><input type='submit' value='Control'/> </form> " + 
                   "<br/><br/><form action='logout' method='get'>"
                        + "<input type='submit' value='Salir'>"
                        + "</form> "+
            "    </body>\n" +
            "</html>\n" +
            "");
                    
                }
                else
                {
                out.print("<H1>Bienvenido "+sesion.getAttribute("Tipo")+" "+sesion.getAttribute("Nombre")+ "</H1>"
                        + "<a href=\"Cambios\">Cambiar informacion de cuenta</a>");
                out.println("<br/><br/><form action='logout' method='get'>"
                        + "<input type='submit' value='Salir'>"
                        + "</form> ");
                }
                
            }else{
                out.println("<!DOCTYPE html>\n" +
            "\n" +
            "<html>\n" +
            "    <head>\n" +
            "        <title>TODO supply a title</title>\n" +
            "        <meta charset=\"UTF-8\">\n" +
            "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    </head>\n" +
            "    <body>\n" +
            "        <h1>Inicia sesion para tener acceso al sitio </h1>\n" +
            "        <form action=\"Login\" method=\"get\">\n" +
            "            <label for=\"user\">Correo:</label><input  type=\"text\" name=\"user\"/><br/>\n" +
            "            <label for=\"pass\">Contraseña:</label><input type=\"password\" name=\"pass\"/><br/>\n" +
            "            <input type=\"submit\" /><br/>\n" +
            "        </form>\n" +
            "        <br>\n" +
            "        <a href=\"Registrarse\">Registro</a>\n" +
            "    </body>\n" +
            "</html>\n" +
            "");
            }
        }
    }
