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
public class Lectura extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       out.print("<html>\n" +
"  	<head>\n" +
"	  	<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/fabric.js/2.2.4/fabric.min.js\"></script>\n" +
"	  	<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.2.6/angular.min.js\"></script>\n" +
"	  	<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
"	  	<script src=\"http://code.responsivevoice.org/responsivevoice.js\"></script>\n" +
"	  	<script src=\"JS/Fun.js\"></script>\n" +
"	  	<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/stilo.css\">\n" +
"  	</head>                                                                                               \n" +
"  	<body>\n" +
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
"							<input type='text' name='nom' id='nom' placeholder='Nombre de la pagina' />\n" +
"							<button id=\"botonguardar\">Guardar</button><br>\n" +
"							<input type='text' name='nom' id='cVV' value=\"\" />\n" +
"							<button id=\"botonrecuperar\">Recuperar</button>\n" +
"						</div>\n" +
"	                </div>\n" +
"	                <div class=\"LeftContent\" id=\"over\">\n" +
"	                	<img src=\"https://www.anipedia.net/imagenes/donde-viven-los-gatos.jpg\" height=\"150px\" width=\"250px\"/>\n" +
"				    	<br>\n" +
"				    	<img src=\"https://www.anipedia.net/imagenes/donde-viven-los-gatos.jpg\" height=\"150px\" width=\"250px\"/>\n" +
"				    	<br>\n" +
"				    	<img src=\"https://www.anipedia.net/imagenes/donde-viven-los-gatos.jpg\" height=\"150px\" width=\"250px\"/>\n" +
"				    	<br>\n" +
"				    	<img src=\"https://www.anipedia.net/imagenes/donde-viven-los-gatos.jpg\" height=\"150px\" width=\"250px\"/>\n" +
"				    	<br>\n" +
"				    	<img src=\"https://www.anipedia.net/imagenes/donde-viven-los-gatos.jpg\" height=\"150px\" width=\"250px\"/>\n" +
"				    	<br>\n" +
"				    	<img src=\"https://www.anipedia.net/imagenes/donde-viven-los-gatos.jpg\" height=\"150px\" width=\"250px\"/>\n" +
"				    	<br>\n" +
"				    	<img src=\"https://www.anipedia.net/imagenes/donde-viven-los-gatos.jpg\" height=\"150px\" width=\"250px\"/>\n" +
"				    	<br>\n" +
"				    	<img src=\"https://www.anipedia.net/imagenes/donde-viven-los-gatos.jpg\" height=\"150px\" width=\"250px\"/>\n" +
"				    	<br>\n" +
"				    	<img src=\"https://www.anipedia.net/imagenes/donde-viven-los-gatos.jpg\" height=\"150px\" width=\"250px\"/>\n" +
"				    	<br>\n" +
"				    	<img src=\"https://www.anipedia.net/imagenes/donde-viven-los-gatos.jpg\" height=\"150px\" width=\"250px\"/>\n" +
"				    	<br>\n" +
"	                </div>\n" +
"	            </div>\n" +
"	        </div>\n" +
"    	</div>\n" +
"	</body>\n" +
"</html>");
    }
}
