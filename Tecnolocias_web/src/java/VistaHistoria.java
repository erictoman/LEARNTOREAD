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
public class VistaHistoria extends HttpServlet {
    
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        PrintWriter out = response.getWriter();
        Operaciones op = new Operaciones();
        String Correo = (String) sesion.getAttribute("CorreoU");
        String nombre = request.getParameter("nom");
        String path = request.getRealPath("archivo_xml");
        path=path + "/base.xml";
        out.print(op.ObtenerHistoria(Correo, nombre, path));
    }
}
