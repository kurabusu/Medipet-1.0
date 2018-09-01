/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlador.ControlCliente;
import controlador.ControlMascota;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.Mascota;

/**
 *
 * @author Rav
 */
@WebServlet(name = "servletEliminarCliente", urlPatterns = {"/servletEliminarCliente"})
public class servletEliminarCliente extends HttpServlet {

   ControlCliente ctrl = new ControlCliente();
    ControlMascota ctrlMas = new ControlMascota();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String cmb_eliminar = request.getParameter("cmbo_eliminar");
            ListarCliente();
            
            for(int x =0;x< ListarCliente().size(); x++){
                if(ListarCliente().get(x).getRut().equals(cmb_eliminar)){
                    EliminarCliente(cmb_eliminar);
                    EliminarMascota(cmb_eliminar);
                        
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Eliminado</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h3>Cliente Eliminado junto a sus Mascotas</h3><br />");
                    out.println("<a href= './admiClientes.jsp'>Volver</a><br />");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
            
        }
    }
    
    public void EliminarCliente(String rut){
        Cliente cli = new Cliente();
        cli.setRut(rut);
        
        ctrl.EliminarCliente(cli);
     
    }
    
    public ArrayList<Cliente> ListarCliente(){
        
        return ctrl.ListarCliente();
    }
    
    public void EliminarMascota(String rut){
        Mascota mas = new Mascota();
        mas.setRutCliente(rut);
        
        ctrlMas.EliminarMascotas(mas);
        
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
