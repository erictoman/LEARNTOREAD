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
public class VerHistoriaCreador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession S = request.getSession();
        PrintWriter out = response.getWriter();
        String Correo = (String)S.getAttribute("CorreoU");
        if(Correo!=null){
        response.setContentType("text/html;charset=UTF-8");
        String nombreH = request.getParameter("NombreH");
        out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/fabric.js/2.2.4/fabric.min.js\"></script>\n" +
"        <script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.2.6/angular.min.js\"></script>\n" +
"        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
"        <script src=\"http://code.responsivevoice.org/responsivevoice.js\"></script>\n" +
"        <script src=\"JS/Fun3.js\"></script>\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/bulma.css\">\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/stilo.css\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <div class=\"Container\">\n" +
"            <section class=\"section\">\n" +
"                <H1 class=\"title is-3 has-text-centered\" id='TITULO'>Lectura Nombre</H1>\n" +
"                <div class=\"Content\">\n" +
"                    <div class=\"Wrapper\">\n" +
"                            <div class=\"image-detail has-text-centered\">\n" +
"                                <canvas  id=\"canvas\" width=\"500\" height=\"500\" style=\"border: 1px solid #222\"></canvas>\n" +
"                                <br><audio autoplay src=\"\" class=\"A\"></audio>\n" +
"                                <input class=\"button\" id=\"R\" type=\"button\" value=\"Regresar\">\n" +
"                                <input class=\"button\" id=\"A\" type=\"button\" value=\"Avanzar\">\n" +
"                                <input type=\"text\" id=\"DATA\" value=\""+nombreH+"\" hidden>\n"
                + "<H1 id='Pagina'></H1>" +
"                                <br>\n" +
"                                <br>\n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                </div>\n" +
"            </section>\n" +
"        </div>\n" +
"    </body>\n" +
"</html>");
    }else{
            out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<body bgcolor='#A2E375'>");
                        out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.0.3/sweetalert2.all.js\"></script>");
                        out.println("<script>");
                        out.println(" swal({\n" +
                                "  title: 'Error',\n" +
                                "  text: \"¡Inicia Sesion!\",\n" +
                                "  type: 'error',\n" +
                                "  showCancelButton: false,\n" +
                                "  confirmButtonColor: '#d33',\n" +
                                "  cancelButtonColor: '#d33',\n" +
                                "  confirmButtonText: 'OK'\n" +
                                "}).then(function (result) {\n" +
                                "  if (result.value) {\n" +
                                "   window.location.href=\"index.html\";"+
                                "  }else{ window.location.href=\"index.html\";}\n" +
                                "})");
                        out.println("</script>");
                        out.println("</body>");
                        out.println("</html>");
    }
}
}
