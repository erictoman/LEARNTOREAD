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

/**
 *
 * @author Marcus
 */
public class Historia extends HttpServlet {


 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.print("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Servlet Historia</title>\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/bulma.css\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <section class=\"section\">\n" +
"            <h1 class=\"title is-3 has-text-centered\">Crea una nueva Historia </h1>\n" +
"            <form action='HistoriaN' method='get'> \n" +
"                <label class=\"label\">Nombre de la Historia</label>\n" +
"                <input class=\"input\" type='text' name='NombreH' required/>\n" +
"                <br>\n" +
"                <br> \n" +
"                <input class=\"button is-info\" type='submit'>\n" +
"            </form>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
    }
}