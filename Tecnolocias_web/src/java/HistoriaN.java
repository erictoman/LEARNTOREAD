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
 * @author Marcus
 */
public class HistoriaN extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreH = request.getParameter("NombreH");
        HttpSession sesion = request.getSession();
        String Correo = (String) sesion.getAttribute("CorreoU");
          Operaciones ope= new Operaciones();
         String path = request.getRealPath("archivo_xml");
            path=path + "/base.xml";
            ope.CreateH(Correo, nombreH, path);
            response.sendRedirect("Diagramas");
    }


}
