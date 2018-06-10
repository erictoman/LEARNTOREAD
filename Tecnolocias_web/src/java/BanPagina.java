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
public class BanPagina extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            HttpSession sesion = request.getSession();
            PrintWriter out = response.getWriter();
            Operaciones op = new Operaciones();
            String Correo = (String) sesion.getAttribute("CorreoU");
            String nombre = request.getParameter("correo");
            String numero = request.getParameter("nums");
            String path = request.getRealPath("archivo_xml");
            path=path + "/base.xml";
            String co=op.EliminarPagina(Correo, nombre, path,numero);
            if(co==""){
                out.print("ERROR");
            }else{
                response.sendRedirect("Diagramas");
            }
        } catch (JDOMException ex) {
            Logger.getLogger(BanPagina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
