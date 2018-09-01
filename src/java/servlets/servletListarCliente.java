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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import modelo.Mascota;

/**
 *
 * @author Rav
 */
@WebServlet(name = "servletListarCliente", urlPatterns = {"/servletListarCliente"})
public class servletListarCliente extends HttpServlet {

   ControlCliente ctrl = new ControlCliente();
   ControlMascota ctrlMas = new ControlMascota();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String cmb_cliente = request.getParameter("cmbo_cliente");
            
            ListarCliente();
            ListarMascotas(cmb_cliente);
            ClienteLista(cmb_cliente);
            
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("s_clientes", ListarCliente());
            sesion.setAttribute("s_mascota", ListarMascotas(cmb_cliente));
            sesion.setAttribute("s_cliente", ClienteLista(cmb_cliente));
            
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/listarCliente.jsp");
            dispatcher.forward(request, response);
            
       
        }
    }
    
    public ArrayList<Cliente> ListarCliente(){
        return ctrl.ListarCliente();
    }
    
    public ArrayList<Mascota> ListarMascotas(String rutCliente){
        ArrayList<Mascota> lista = new ArrayList<>();
        
        try {
            lista = ctrlMas.ListarMascotas(rutCliente);
            return lista;
        } catch (Exception e) {
            
            e.printStackTrace();
            return new ArrayList<>();
        }
        
    }
    
    public ArrayList<Cliente> ClienteLista(String rut){
        return ctrl.ClienteLista(rut);
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
