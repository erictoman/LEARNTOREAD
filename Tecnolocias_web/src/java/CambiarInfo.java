/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 * @author ertim
 */
public class CambiarInfo extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String Correo = request.getParameter("correo");
        String Nombre = request.getParameter("nom");
        String Pass = request.getParameter("pass");
        HttpSession sesion = request.getSession();
        String path = request.getRealPath("/archivo_xml");
        path=path + "/base.xml";
        Operaciones opera = new Operaciones();
        int p=opera.cambios(Nombre, Pass, path, Correo);
        if(p==1)
        {
            try {
                sesion=request.getSession(true);
                sesion.setAttribute("Correo", Correo);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<body bgcolor='#A2E375'>");
                out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.0.3/sweetalert2.all.js\"></script>");
                out.println("<script>");
                out.println(" swal({\n" +
                        "  title: 'Correcto',\n" +
                        "  text: \"¡ Cambios aplicados !\",\n" +
                        "  type: 'Correcto',\n" +
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
                String nombre = opera.obtenNombre(Correo, path);
                sesion.setAttribute("Nombre", nombre);
            } catch (JDOMException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body bgcolor='#A2E375'>");
            out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.0.3/sweetalert2.all.js\"></script>");
            out.println("<script>");
            out.println(" swal({\n" +
                    "  title: 'Error',\n" +
                    "  text: \"Usuario o contraseña incorrecta !\",\n" +
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
    } catch (JDOMException ex) {
        Logger.getLogger(CambiarInfo.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
