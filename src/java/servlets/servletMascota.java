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
import modelo.TipoMascota;

/**
 *
 * @author Rav
 */
@WebServlet(name = "servletMascota", urlPatterns = {"/servletMascota"})
public class servletMascota extends HttpServlet {

    ControlMascota ctrl = new ControlMascota();
    ControlCliente ctrlC = new ControlCliente();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String btn_agregar = request.getParameter("btn_agregar");
            String btn_modificar = request.getParameter("btn_modificar");
            String btn_buscar = request.getParameter("btn_buscar");
            String btn_tipo = request.getParameter("btn_tipoMasco");
            String btn_borrar = request.getParameter("btn_borraTipoMasco");
            
            RequestDispatcher dispatcher;
            
            
            if(btn_agregar != null){
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("s_tipos", TiposListar());
                sesion.setAttribute("s_clientes", ListarCliente());
                
                dispatcher = request.getServletContext().getRequestDispatcher("/crearMascota.jsp");
                dispatcher.forward(request, response);
                
            }else if(btn_modificar!= null){
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("s_mascotas", MascotasListar());
                sesion.setAttribute("s_tipos", TiposListar());
                sesion.setAttribute("s_clientes", ListarCliente());
                
                dispatcher = request.getServletContext().getRequestDispatcher("/modificarMascota.jsp");
                dispatcher.forward(request, response);
            }else if(btn_buscar!= null){
                HttpSession sesion = request.getSession(true);
                String rutCliente ="";
                sesion.setAttribute("s_clientes", ListarCliente());
                sesion.setAttribute("s_mascotas", ListarMascotas(rutCliente));
                
                dispatcher = request.getServletContext().getRequestDispatcher("/listarMascota.jsp");
                dispatcher.forward(request, response);
                
            }else if(btn_tipo!= null){
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("s_tipos", TiposListar());
                
                dispatcher = request.getServletContext().getRequestDispatcher("/agregarTipoMascota.jsp");
                dispatcher.forward(request, response);
            }else if(btn_borrar!= null){
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("s_tipos", TiposListar());
                
                dispatcher = request.getServletContext().getRequestDispatcher("/eliminarTipos.jsp");
                dispatcher.forward(request, response);
            }
            
        }
    }
    
    public ArrayList<Mascota> ListarMascotas(String rutCliente){
        ArrayList<Mascota> lista = new ArrayList<>();
        
        try {
            lista = ctrl.ListarMascotas(rutCliente);
            
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public ArrayList<Mascota> MascotasListar(){
        ArrayList<Mascota> lista = new ArrayList<>();
        
        try {
            lista = ctrl.MascotasListar();
            
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    
    public ArrayList<TipoMascota> TiposListar(){
        ArrayList<TipoMascota> lista = new ArrayList<>();
        
        try {
            lista = ctrl.TiposListar();
            
            return lista;
        } catch (Exception e) {
            
            e.printStackTrace();
            return new ArrayList<>();
        }
        
    }
    
    public ArrayList<Cliente> ListarCliente(){
        ArrayList<Cliente> lista = new ArrayList<>();
        
        try {
            lista = ctrlC.ListarCliente();
            
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
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
