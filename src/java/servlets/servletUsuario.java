/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CETECOM
 */
@WebServlet(name = "servletUsuario", urlPatterns = {"/servletUsuario"})
public class servletUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            RequestDispatcher dispatcher;
            String btn_cliente = request.getParameter("btn_clientes");
            String btn_mascotas = request.getParameter("btn_mascotas");
            String btn_atenciones = request.getParameter("btn_atenciones");
            
            if(btn_cliente!=null){
                
                dispatcher = request.getServletContext().getRequestDispatcher("/admiClientes.jsp");
                dispatcher.forward(request, response);
                
            }else if(btn_mascotas!= null){
                
                dispatcher = request.getServletContext().getRequestDispatcher("/admiMascotas.jsp");
                dispatcher.forward(request, response);
                
            }else if(btn_atenciones!=null){
                
                dispatcher = request.getServletContext().getRequestDispatcher("/admiAtenciones.jsp");
                dispatcher.forward(request, response);
            }
            
            
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
