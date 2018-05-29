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
import java.util.Random;
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
        if(request.getParameter("forma")!=null){
            HttpSession sesion = request.getSession();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            if(sesion.getAttribute("CorreoU")!= null && ((String)sesion.getAttribute("Tipo")).equalsIgnoreCase("Profesor")){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Subir</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Esta pagina tiene como proposito el subir las imagenes de las lecturas que haras </h1>");
                out.println("<br/><br/><form action='Subir' method='post' enctype='multipart/form-data'>"
                        + " <input type='file' name='foto' accept='.jpg' placeholder='selecciona la foto'  required/> <input type='submit' name='subir'/> </form>   ");
                out.println("</body>");
                out.println("</html>");
            }else{
                response.sendRedirect("index.html");
            }
        }else{
            HttpSession sesion = request.getSession();
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
            response.sendRedirect("index.html");
        }
    }
}


  


