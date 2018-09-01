/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlador.ControlMascota;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Mascota;

/**
 *
 * @author Rav
 */
@WebServlet(name = "servletCreaMascota", urlPatterns = {"/servletCreaMascota"})
public class servletCreaMascota extends HttpServlet {
    
    ControlMascota ctrl = new ControlMascota();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String cmb_cliente = request.getParameter("cmbo_clientes");
            int cmb_tipo = Integer.parseInt(request.getParameter("cmbo_tipos"));
            String txt_nombre = request.getParameter("txt_nombre");
            String txt_fNacimiento = request.getParameter("txt_fNacimiento");
            
            InsertarMascota(cmb_cliente, cmb_tipo, txt_nombre, txt_fNacimiento);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Realizado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Mascota Guardada con Exito</h3><br />");
            out.println("<a href= './admiMascotas.jsp'>Volver Atrás</a><br />");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public void InsertarMascota(String rutCliente, int tipoMascota, String nombre, String fNaci){
        
        Mascota cachupin = new Mascota();
        
        try {
            cachupin.setRutCliente(rutCliente);
            cachupin.setTipoMascota(tipoMascota);
            cachupin.setNombre(nombre);
            cachupin.setFechaNacimiento(fNaci);
            
            ctrl.InsertarMascota(cachupin);
            
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
