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
 * @author Marcus
 */
public class BanAlum extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession sesion = request.getSession();
        String path = request.getRealPath("/archivo_xml");
        path=path + "/base.xml";
        String num = request.getParameter("num");
        String profesor= request.getParameter("profesor");
        String correo = request.getParameter("correo");
        Operaciones ope = new Operaciones();
        try {
            ope.BanAlumno(profesor, num, path, correo);
        } catch (JDOMException ex) {
            Logger.getLogger(BanAlum.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("index.html");
    }

}
