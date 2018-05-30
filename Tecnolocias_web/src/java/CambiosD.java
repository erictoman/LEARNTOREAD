/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jdom.JDOMException;

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
                Operaciones o = new Operaciones();
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
        try {
            out.println("<html>\n" +
                    "  	<head>\n" +
                    "	  	<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/fabric.js/2.2.4/fabric.min.js\"></script>\n" +
                    "	  	<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.2.6/angular.min.js\"></script>\n" +
                    "	  	<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
                    "	  	<script src=\"http://code.responsivevoice.org/responsivevoice.js\"></script>\n" +
                    "	  	<script src=\"JS/Fun2.js\"></script>\n" +
                    "	  	<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/stilo.css\">\n" +
                    "  	</head>\n" +
                    "  	<body>\n"
                    + "<div id='centeredDiv'><H1>Crea una nueva lectura</H1></div>" +
                    "		<div class=\"Container\">\n" +
                    "	        <div class=\"Content\">\n" +
                    "	            <div class=\"Wrapper\">\n" +
                    "	                <div class=\"RightContent\">\n" +
                    "	                	<div class=\"image-detail\">\n" +
                    "		                    <canvas id=\"canvas\" width=\"600\" height=\"600\" style=\"border: 1px solid #222\"></canvas>\n" +
                    "							<br>\n" +
                    "						    <button id=\"botontexto\">Añadir texto</button>\n" +
                    "							<button id=\"botoneliminar\">Eliminar elemento</button>\n" +
                    "						    <audio autoplay src=\"\" class=\"A\"></audio>\n" +
                    "							<a href=\"MisImagenes\" target=\"_blank\"><input type='button' value='Imagenes de mi biblioteca'/></a>\n" +
                    "							<br><br>\n" +
                    "							<input type='text' readonly name='nom' id='nom' placeholder='Nombre de la pagina'value='"+request.getParameter("correo")+"' />\n" +
                    "							<button id=\"botonguardar\">Guardar</button><br>\n" +
                    "							<input type='hidden' name='nom' id='cVV' value='"+o.obtenerS((String) sesion.getAttribute("CorreoU"),request.getParameter("correo"),path1)+"' />\n" +
                            "						</div>\n" +
                            "	                </div>\n" +
                            "	                <div class=\"LeftContent\" id=\"over\">\n");
        } catch (JDOMException ex) {
            Logger.getLogger(CambiosD.class.getName()).log(Level.SEVERE, null, ex);
        }
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
out.println("	                </div>\n" +
"	            </div>\n" +
"	        </div>\n" +
"    	</div>\n" +
"	</body>\n" +
"</html>");
    }
}
