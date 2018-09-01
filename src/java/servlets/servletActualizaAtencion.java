/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlador.ControlAtencion;
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
import modelo.Atencion;

/**
 *
 * @author Rav
 */
@WebServlet(name = "servletActualizaAtencion", urlPatterns = {"/servletActualizaAtencion"})
public class servletActualizaAtencion extends HttpServlet {

    ControlAtencion ctrlAte = new ControlAtencion();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String btn_guardar = request.getParameter("btn_guardar");
            int cmb_atencion = Integer.parseInt(request.getParameter("cmbo_atencion"));
            String txt_diag = request.getParameter("txt_diagnostico");
            String txt_trata = request.getParameter("txt_tratamiento");
            int valor = Integer.parseInt(request.getParameter("txt_valor"));
            
                   ActualizarAtencion(cmb_atencion, txt_diag, txt_trata, valor);
                   
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Realizado</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h3>información Actualizada</h3><br />");
                    out.println("<a href= './admiAtenciones.jsp'>Volver Atrás</a><br />");
                    out.println("</body>");
                    out.println("</html>");
                
            
        }
    }
    
    public ArrayList<Atencion> ListarAtencion(int cod){
        ArrayList<Atencion> lista = new ArrayList<>();
        
        lista = ctrlAte.ListarAtencion(cod);
        return lista;
    }
    
    public void ActualizarAtencion(int cod, String diagno, String trata, int total){
        Atencion ate = new Atencion();
        
        ate.setId(cod);
        ate.setDiagMedico(diagno);
        ate.setDescripTratamiento(trata);
        ate.setValorConsulta(total);
        
        ctrlAte.ActualizarAtencion(ate);
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
