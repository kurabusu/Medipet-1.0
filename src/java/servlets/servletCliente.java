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
@WebServlet(name = "servletCliente", urlPatterns = {"/servletCliente"})
public class servletCliente extends HttpServlet {

    ControlCliente ctrl = new ControlCliente();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String btn_agregar = request.getParameter("btn_agregar");
            String btn_elim = request.getParameter("btn_eliminar");
            String btn_modi = request.getParameter("btn_modificar");
            String btn_listar = request.getParameter("btn_listar");
            
            RequestDispatcher dispatcher;
            
            if (btn_agregar != null) {
                
                dispatcher = request.getServletContext().getRequestDispatcher("/crearCliente.jsp");
                dispatcher.forward(request, response);
                
            }else if(btn_elim != null){
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("s_clientes", ListarCliente());
                
                dispatcher = request.getServletContext().getRequestDispatcher("/eliminarCliente.jsp");
                dispatcher.forward(request, response);
                
            }else if(btn_modi != null){
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("s_clientes", ListarCliente());
                
                dispatcher = request.getServletContext().getRequestDispatcher("/modificarCliente.jsp");
                dispatcher.forward(request, response);
                
            }else if(btn_listar != null){
                String rutCliente="";
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("s_clientes", ListarCliente());
                sesion.setAttribute("s_mascota", ListarMascotas(rutCliente));
                sesion.setAttribute("s_cliente", ClienteLista(rutCliente));
                
                dispatcher = request.getServletContext().getRequestDispatcher("/listarCliente.jsp");
                dispatcher.forward(request, response);    
            }
        }
    }
    
    public ArrayList<Cliente> ListarCliente(){
        
        return ctrl.ListarCliente();
        
    }
    
    public ArrayList<Mascota> ListarMascotas(String rutCliente){
        ControlMascota ctrlMas = new ControlMascota();
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
