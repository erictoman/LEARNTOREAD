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
import javax.servlet.http.Part;

/**
 *
 * @author Marcus
 */
public class MisImagenes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   response.setContentType("text/html;charset=UTF-8");
   HttpSession sesion = request.getSession();
       PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MisImagenes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Arrastra las imagenes de tu galeria a tu Lectura </h1>");
                  
        
      
        
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
              out.println("<img src='Fotos/"+ficheros[i]+"' with='100' height='100'/> <br/> <br/>");
          }
      }
            out.println("</body>");
            out.println("</html>");
    }


}
