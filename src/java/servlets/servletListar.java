/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlador.ControlUsuario;
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
import modelo.Usuario;

/**
 *
 * @author MZZO
 */
@WebServlet(name = "servletListar", urlPatterns = {"/servletListar"})
public class servletListar extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            int cmb_perfil = Integer.parseInt(request.getParameter("cmbo_perfil"));
            
            
         
             listarUsuarios(cmb_perfil);
             
             HttpSession sesion = request.getSession(true);
             sesion.setAttribute("s_usuarios", listarUsuarios(cmb_perfil));
             RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/listarUsuario.jsp");
             dispatcher.forward(request, response);
    
        }
    }
    
    public ArrayList<Usuario> listarUsuarios(int indice){
        
        ControlUsuario ctrl = new ControlUsuario();
        ArrayList<Usuario> lista = new ArrayList<>();
        
        try {
            
            lista = ctrl.listarUsuarios(indice);
            return lista;
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return new ArrayList<>();        }
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
