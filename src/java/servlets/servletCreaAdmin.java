/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlador.ControlUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 *
 * @author Rav
 */
@WebServlet(name = "servletCreaAdmin", urlPatterns = {"/servletCreaAdmin"})
public class servletCreaAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            //HttpSession sesion = request.getSession(true);

            
            String txt_rut = request.getParameter("txt_rut");
            String txt_nombre = request.getParameter("txt_nombre");
            String txt_fNaci = request.getParameter("txt_fNacimiento");
            String txt_email = request.getParameter("txt_email");
            String txt_pass = request.getParameter("txt_pass");
            int cmb_perfil = Integer.parseInt(request.getParameter("cmbo_perfil"));
            
            if(cmb_perfil != 1){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Error</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Debe Crear un Administrador</h1>");
                out.println("<a href= './index.jsp'>Volver Atrás</a><br />");
                out.println("</body>");
                out.println("</html>");
            }else{
                InsertarUsuario(txt_rut, txt_nombre, txt_fNaci, txt_email, txt_pass, cmb_perfil);
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Exito</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Administrador Guardado Correctamente</h1>");
                out.println("<a href= './index.jsp'>Volver Atrás</a><br />");
                out.println("</body>");
                out.println("</html>");
            }
            
            
        }
    }
    
    
    
    public void InsertarUsuario(String rut, String nombre, String fNaci, String email, String pass, int perfil){
        
        ControlUsuario ctrl = new ControlUsuario();
        Usuario usu = new Usuario();
        
        
        try {
            usu.setRut(rut);
            usu.setNombre(nombre);
            usu.setFechaNacimiento(fNaci);
            usu.setEmail(email);
            usu.setPassword(pass);
            usu.setPerfil(perfil);
            
            ctrl.InsertarUsuario(usu);
        } catch (Exception e) {
            
            e.printStackTrace();
            System.out.println("Error al almacenar");
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
