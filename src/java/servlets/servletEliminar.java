/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlador.ControlAtencion;
import controlador.ControlUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Atencion;
import modelo.Usuario;

/**
 *
 * @author Rav
 */
@WebServlet(name = "servletEliminar", urlPatterns = {"/servletEliminar"})
public class servletEliminar extends HttpServlet {

   ControlUsuario ctrl = new ControlUsuario();
    ControlAtencion ctrlAten = new ControlAtencion();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            String cmb_eliminar = request.getParameter("cmbo_eliminar");
            HttpSession sesion = request.getSession(true);
            ListaUsuario();
            
            for(int x=0;x<ListaUsuario().size();x++){
                if(ListaUsuario().get(x).getRut().equals(cmb_eliminar)){
                    if(BuscarMedico(cmb_eliminar)){
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Error</title>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Usuario Posee Atenciones y no puede ser Eliminado</h1><br />");
                        out.println("<a href= './eliminarUsuario.jsp'>Volver Atrás</a>");
                        out.println("</body>");
                        out.println("</html>");
                        
                    }else{
                        EliminarUsuario(cmb_eliminar);

                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Exito</title>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Usuario Eliminado Exitosamente</h1> <br />");
                        out.println("<a href= './eliminarUsuario.jsp'>Volver Atrás</a>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }    
            }    
        }
    }
    
    public ArrayList<Usuario> ListaUsuario(){
        
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            lista = ctrl.ListaUsuario();
            return lista;
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return new ArrayList<>();
        }
        
    }
    
    public void EliminarUsuario(String rut){
        Usuario usu = new Usuario();
        usu.setRut(rut);
        
        ctrl.EliminarUsuario(usu);
        
    }
    
    public boolean BuscarMedico(String rutMedico){
       
        return ctrlAten.BuscarMedico(rutMedico);
        
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
