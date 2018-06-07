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
import org.jdom.JDOMException;

/**
 *
 * @author Marcus
 */
public class Inscripcion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Inscripcion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Inscripcion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     String grupo =request.getParameter("grupo");
     String correo= request.getParameter("nom");
     String nom="";
     Operaciones ope=  new Operaciones();
         String path = request.getRealPath("archivo_xml");
            path=path + "/base.xml";
        try {
            nom=ope.obtenNombre(correo, path);
        } catch (JDOMException ex) {
            Logger.getLogger(Inscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
            ope.Inscribir(correo, grupo, path , nom);
    }


}
