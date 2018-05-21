/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author ertim
 */
public class Ban extends HttpServlet {
    
 
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            String correo = request.getParameter("correo");
            int res=0;
            String path = request.getRealPath("/archivo_xml");
            path=path + "/base.xml";
            Operaciones op = new Operaciones();
            if(op.Ban(correo,path)==1){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<body bgcolor='#A2E375'>");
                out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.0.3/sweetalert2.all.js\"></script>");
                out.println("<script>");
                out.println(" swal({\n" +
                        "  title: 'Correcto',\n" +
                        "  text: \"¡ Cambios aplicados !\",\n" +
                        "  type: 'success',\n" +
                        "  showCancelButton: false,\n" +
                        "  confirmButtonColor: '#d33',\n" +
                        "  cancelButtonColor: '#d33',\n" +
                        "  confirmButtonText: 'OK'\n" +
                        "}).then(function (result) {\n" +
                        "  if (result.value) {\n" +
                        "   window.location.href=\"Usuarios\";"+
                        "  }else{ window.location.href=\"index.html\";}\n" +
                        "})");
                out.println("</script>");
                out.println("</body>");
                out.println("</html>");
            }else{
                out.println("<H1>¡Hay un error en la peticion!</H1>");
            }
        } catch (JDOMException ex) {
            Logger.getLogger(Ban.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
