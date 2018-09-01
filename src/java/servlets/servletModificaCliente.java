/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlador.ControlCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;

/**
 *
 * @author Rav
 */
@WebServlet(name = "servletModificaCliente", urlPatterns = {"/servletModificaCliente"})
public class servletModificaCliente extends HttpServlet {

   ControlCliente ctrl = new ControlCliente();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            String cmb_modificar = request.getParameter("cmbo_modificar");
            String txt_nombre = request.getParameter("txt_nombre");
            String txt_dir = request.getParameter("txt_direc");
            String txt_fNaci = request.getParameter("txt_fNacimiento");
            String txt_email = request.getParameter("txt_email");
            char cmb_sexo = request.getParameter("cmbo_sexo").charAt(0);
            
            ModificarCliente(cmb_modificar, txt_nombre, txt_dir, txt_fNaci, txt_email, cmb_sexo);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Exito</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cliente Modificado correctamente</h1><br />");
            out.println("<a href= './admiClientes.jsp'>Volver Atras</a><br />");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public void ModificarCliente(String rut, String nombre, String direccion, String fechaNaci, String email, char sexo){
        Cliente cli = new Cliente();
        
        try {
            cli.setRut(rut);
            cli.setNombre(nombre);
            cli.setDirección(direccion);
            cli.setFechaNacimiento(fechaNaci);
            cli.setEmail(email);
            cli.setSexo(sexo);
            
            ctrl.ModificarCliente(cli);
            
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
