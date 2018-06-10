/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marcus
 */
public class CambiosD extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String path1 = request.getRealPath("/archivo_xml");
        path1=path1 + "/base.xml";
        String nombre = request.getParameter("correo");
        Operaciones o = new Operaciones();
        String num = request.getParameter("numS");
       response.setContentType("text/html;charset=UTF-8");
       
       PrintWriter out = response.getWriter();
        try {
            System.out.println(num);
out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/fabric.js/2.2.4/fabric.min.js\"></script>\n" +
"        <script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.2.6/angular.min.js\"></script>\n" +
"        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
"        <script src=\"http://code.responsivevoice.org/responsivevoice.js\"></script>\n" +
"        <script src=\"JS/Fun2.js\"></script>\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/bulma.css\">\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/stilo.css\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <div id='centeredDiv'>\n" +
"            <H1 class=\"title is-3 has-text-centered\">Modifica la pagina</H1>\n" +
"        </div>		\n" +
"        <div class=\"Container\">\n" +
"            <section class=\"section\">\n" +
"                <div class=\"Content\">\n" +
"                    <div class=\"Wrapper\">\n" +
"                        <div class=\"RightContent\">\n" +
"                            <div class=\"image-detail\">\n" +
"                                <canvas  id=\"canvas\" width=\"500\" height=\"500\" style=\"border: 1px solid #222\"></canvas>\n" +
"                                <br>\n" +
"                                <button class=\"button\" id=\"botontexto\">Añadir texto</button>\n" +
"                                <button class=\"button\" id=\"botoneliminar\">Eliminar elemento</button>\n" +
"                                <audio autoplay src=\"\" class=\"A\"></audio>\n" +
"                                <br><br>\n" +
"                                <button class=\"button is-info\" id=\"botonguardar\">Guardar</button><br>\n" +
"                                <br>\n" +
"							<input type='hidden' name='nom' id='cVV' value='"+o.obtenerS((String) sesion.getAttribute("CorreoU"),request.getParameter("correo"),path1 , request.getParameter("numS"))+"' />\n" +
"                                <input class=\"input\" type='text' name='numero' id='numero' placeholder='Numero de pagina' value='"+num+"' readonly />  \n" +
"                                <br>\n" +
"                                <input class=\"input\" type='text' name='NombreH' id='NombreH' value='"+nombre+"' readonly/>  \n" +
"                            </div>\n" +
"                        </div>\n" +
"                        <div class=\"LeftContent is-pulled-right\" id=\"over\" >\n" );
                    String path=request.getRealPath("/Fotos");
                    File dir = new File(path); //La clase file tiene 3 constructores  File (String path).  Crea una nueva instancia de tipo file  convirtiendo la cadena de nombre de ruta dada en una ruta de acceso abstracta.
                    String[] ficheros = dir.list();
                    int p= ficheros.length;
                    int index=0;
                    for(int i =0; i<p ; i++)
                    {
                        index=ficheros[i].indexOf((String)sesion.getAttribute("CorreoU"));
                        if(index!=-1)
                        {
                          out.println("<img src='Fotos/"+ficheros[i]+"' width='100' height='100'/><br>");
                        }
                    }
out.print("                        </div>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </section>\n" +
"        </div>\n" +
"    </body>\n" +
"</html>");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
