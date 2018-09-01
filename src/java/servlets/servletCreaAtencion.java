/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlador.ControlAtencion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Atencion;

/**
 *
 * @author Rav
 */
@WebServlet(name = "servletCreaAtencion", urlPatterns = {"/servletCreaAtencion"})
public class servletCreaAtencion extends HttpServlet {

    ControlAtencion ctrlAte = new ControlAtencion();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String cmb_cliente = request.getParameter("cmbo_cliente");
            int cmb_mascota = Integer.parseInt(request.getParameter("cmbo_mascota"));
            String cmb_medico = request.getParameter("cmbo_medico");
            String cmb_usuario = request.getParameter("cmbo_usuario");
            String txt_descrip = request.getParameter("txt_descrip");
            
            
            InsertarAtencion(cmb_cliente, cmb_mascota, cmb_medico, cmb_usuario, txt_descrip);
            
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Realizado</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h3>Atención Guardada con Exito</h3><br />");
                    out.println("<a href= './admiAtenciones.jsp'>Volver Atrás</a><br />");
                    out.println("</body>");
                    out.println("</html>");
        }
    }
    
    public void InsertarAtencion(String cliente, int mascota, String medico, String usuario, String descrip){
        
        Atencion ate = new Atencion();
        
        try {
            ate.setRutCliente(cliente);
            ate.setIdMascota(mascota);
            ate.setRutMedico(medico);
            ate.setRutUsuario(usuario);
            ate.setDescripSíntoma(descrip);
            
            ctrlAte.InsertarAtencion(ate);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
