

package servlets;

import controlador.ControlPerfil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Perfil;

/**
 *
 * @author MZZO
 */
@WebServlet(name = "servletPerfil", urlPatterns = {"/servletPerfil"})
public class servletPerfil extends HttpServlet {

    
    ControlPerfil ctrl = new ControlPerfil();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String descripcion = request.getParameter("txt_descripcion");
            RequestDispatcher dispatcher;
            
            if(ctrl.ValidaPerfil(descripcion)){
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Error</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<br>La Descripción ingresada Ya existe</br>");
                out.println("<a href='./agregarPerfil.jsp'>Volver atrás</a>");
                out.println("</body>");
                out.println("</html>");
                
            }else{
                
                AgregarPerfil(descripcion);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Guardado</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<br>Nuevo Perfil creado Correctamente</br>");
                out.println("<a href='./agregarPerfil.jsp'>Volver atrás</a>");
                out.println("<a href='./Administrador.jsp'>Volver a Menú Administrador</a>");
                out.println("</body>");
                out.println("</html>");
            }    
        }
    }
    
    public void AgregarPerfil(String descripcion){
        
        Perfil perfil = new Perfil();
            
            try {
                
                perfil.setDescripcion(descripcion);
                
                ctrl.AgregarPerfil(perfil);
                
            } catch (Exception e) {
                
                e.printStackTrace();
            }
        
        
        
        
    }
    
    public boolean ValidarPerfil(String descripcion){
        
  
        boolean validar = ctrl.ValidaPerfil(descripcion);
        
        return validar;
        
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
