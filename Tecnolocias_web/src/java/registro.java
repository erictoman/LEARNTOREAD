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
import javax.xml.parsers.ParserConfigurationException;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;


public class registro extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String nom = request.getParameter("nom");
        String pass = request.getParameter("pass");
        String tipo = request.getParameter("tipo");
        Operaciones ope = new Operaciones ();
        String path = request.getRealPath("archivo_xml");
                path=path + "/base.xml";
        int registro=0;
        try {
            registro=ope.registro(nom, pass, tipo, path);
        } catch (ParserConfigurationException | SAXException | JDOMException ex) {
            Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(registro==1){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body bgcolor='#A2E375'>");
            out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.0.3/sweetalert2.all.js\"></script>");
            out.println("<script>");
            out.println(" swal({\n" +
            "  title: 'Correcto',\n" +
            "  text: \"Bienvenido !\",\n" +
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
    }
}
