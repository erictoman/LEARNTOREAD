/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Marcus
 */
public class Subir extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
        if(!request.getParameter("forma").equalsIgnoreCase("SUBIDA")){
            if(sesion.getAttribute("CorreoU")!= null && ((String)sesion.getAttribute("Tipo")).equalsIgnoreCase("Profesor")){
                out.print(""
                        + "<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <title>LEARNTOREAD</title>\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/bulma.css\">\n" +
"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css\">\n" +
"        <script type=\"text/javascript\" src=\"JS/jquery-3.3.1.min.js\"></script>\n" +
"        <script type=\"text/javascript\" src=\"JS/Funcionalidad.js\"></script>\n" +
"    </head>\n" +
"    <body>\n" +
"        <section class=\"section\">\n" +
"                <h1 class=\"title is-3 has-text-centered\">Esta pagina tiene como proposito el subir las imagenes de las lecturas que haras </h1>\n" +
"                <br/>\n" +
"                <div class=\"has-text-centered\">\n" +
"                    <div class=\"file has-name is-boxed\">\n" +
"                        <label class=\"file-label\">\n" +
"                            <input class=\"file-input\" accept='.jpg' type=\"file\" name=\"foto\" id=\"foto\">\n" +
"                            <span class=\"file-cta\">\n" +
"                                <span class=\"file-icon\">\n" +
"                                    <i class=\"fa fa-file\"></i>\n" +
"                                </span>\n" +
"                                <span class=\"file-label\" id=\"text1\">\n" +
"                                    Elige una imagen\n" +
"                                </span>\n" +
"                            </span>\n" +
"                            <span class=\"file-name has-text-centered\" id=\"text2\">\n" +
"                                Esperando imagen\n" +
"                            </span>\n" +
"                        </label>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </div>\n" +
"        </section>\n" +
"    </body>\n" +
"</html>");
            }else{
                response.sendRedirect("index.html");
            }
        }else{
            Part filePart = request.getPart("foto"); //Devuelve una parte especifica del request. Part Esta clase representa una pieza o elemento de formulario que se recibió dentro de una multipart/form-datas en solicitud POST.
            String path=request.getRealPath("/Fotos");
            System.out.println(path);
            File dir = new File(path); //La clase file tiene 3 constructores  File (String path).  Crea una nueva instancia de tipo file  convirtiendo la cadena de nombre de ruta dada en una ruta de acceso abstracta.
            String[] ficheros = dir.list();
            int p= ficheros.length;
            p=p++;
            /*int p=0;
            p=r.nextInt(20000000)+1000;
            */
            File file = new File(path+"/" +sesion.getAttribute("CorreoU")+ p +".jpg" ); //La clase file tiene 3 constructores  File (String path).  Crea una nueva instancia de tipo file  convirtiendo la cadena de nombre de ruta dada en una ruta de acceso abstracta.
            InputStream input = filePart.getInputStream(); //Obtener el contenido de la parte en un inputStream
            Files.copy(input, file.toPath(),StandardCopyOption.REPLACE_EXISTING );
            out.print("Imagen subida con exito");
        }
    }
}

  


