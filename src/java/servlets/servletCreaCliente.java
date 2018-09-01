/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlador.ControlCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;


@WebServlet(name = "servletCreaCliente", urlPatterns = {"/servletCreaCliente"})
public class servletCreaCliente extends HttpServlet {


    ControlCliente ctrl = new ControlCliente();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String txt_rut = request.getParameter("txt_rut");
            String txt_nombre = request.getParameter("txt_nombre");
            String txt_dir = request.getParameter("txt_direc");
            String txt_fNaci = request.getParameter("txt_fNacimiento");
            String txt_email = request.getParameter("txt_email");
            char cmb_sexo = request.getParameter("cmbo_sexo").charAt(0);
            String btn_agregar = request.getParameter("btn_agregar");
            
            
            if(ValidaCliente(txt_rut)){
                
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Error</title>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h3>No se puede Registrar dos Clientes con el mismo Rut</h3><br />");
                        out.println("<a href= './crearCliente.jsp'>Volver a Intentar</a><br />");
                        out.println("</body>");
                        out.println("</html>");
                           
                
            }else{
                InsertarCliente(txt_rut, txt_nombre, txt_dir, txt_fNaci, txt_email, cmb_sexo);
                    
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Realizado</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h3>Cliente Guardado con Exito</h3><br />");
                    out.println("<a href= './admiClientes.jsp'>Volver Atrás</a><br />");
                    out.println("</body>");
                    out.println("</html>");
            }
        
        }
    }
    
     public void InsertarCliente(String rut, String nombre, String direccion, String fNaci, String email, char sexo){
        
        Cliente usu = new Cliente();

        try {
            usu.setRut(rut);
            usu.setNombre(nombre);
            usu.setDirección(direccion);
            usu.setFechaNacimiento(fNaci);
            usu.setEmail(email);
            
            usu.setSexo(sexo);
            
            ctrl.InsertarCliente(usu);
        } catch (Exception e) {
            
            e.printStackTrace();
            System.out.println("Error al almacenar");
        }    
    }
     
    public boolean ValidaCliente(String rut){
        
        return ctrl.ValidaCliente(rut);
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
