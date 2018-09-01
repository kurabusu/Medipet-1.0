/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlador.ControlAtencion;
import controlador.ControlCliente;
import controlador.ControlMascota;
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
import modelo.Atencion;
import modelo.Cliente;
import modelo.Mascota;
import modelo.Usuario;

/**
 *
 * @author Rav
 */
@WebServlet(name = "servletAtenciones", urlPatterns = {"/servletAtenciones"})
public class servletAtenciones extends HttpServlet {
    
    
    ControlMascota ctrlMas = new ControlMascota();
    ControlCliente ctrlCli = new ControlCliente();
    ControlAtencion ctrlAte = new ControlAtencion();
    ControlUsuario ctrlUsu = new ControlUsuario();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String btn_agregar = request.getParameter("btn_agregar");
            String btn_actua = request.getParameter("btn_actualizar");
            String btn_buscar = request.getParameter("btn_buscar");
            
            
            RequestDispatcher dispatcher;
            
            if(btn_agregar!=null){
                HttpSession sesion = request.getSession(true);
                String rut=" ";
                sesion.setAttribute("s_medicos", listarMedico());
                sesion.setAttribute("s_usuarios", ListaUsuario());
                sesion.setAttribute("s_clientes", ListarCliente());
                
                dispatcher = request.getServletContext().getRequestDispatcher("/agregarAtencion.jsp");
                dispatcher.forward(request, response);
            }else if(btn_actua!= null){
                HttpSession sesion = request.getSession(true);
                
                sesion.setAttribute("s_atencion", AtencionLista());
                
                dispatcher = request.getServletContext().getRequestDispatcher("/modificarAtencion.jsp");
                dispatcher.forward(request, response);
            }else if(btn_buscar!= null){
                HttpSession sesion = request.getSession(true);
                String rut=" ";
                sesion.setAttribute("s_clientes", ListarCliente());
                sesion.setAttribute("s_atencion", BuscarAtencion(rut));
                
                dispatcher = request.getServletContext().getRequestDispatcher("/buscarAtencion.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
    public ArrayList<Atencion> BuscarAtencion(String rutCliente){
        
        ArrayList<Atencion> lista = new ArrayList<>();
        lista = ctrlAte.BuscarAtencion(rutCliente);
        
        return lista;
    }
    
    public ArrayList<Usuario> listarUsuarios(int indice){
        
        
        ArrayList<Usuario> lista = new ArrayList<>();
        
        try {
            
            lista = ctrlUsu.listarUsuarios(indice);
            return lista;
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return new ArrayList<>();        }
    }
    
    public ArrayList<Atencion> AtencionLista(){
        ArrayList<Atencion> lista = new ArrayList<>();
        
        try {
            lista = ctrlAte.AtencionLista();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
            
        }
    }   
    
    public ArrayList<Usuario> ListaUsuario(){
        
        ArrayList<Usuario> lista = new ArrayList<>();
        
        try {
            
            lista = ctrlUsu.ListaUsuario();
            return lista;
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return new ArrayList<>();
            
        }
        
    }
    
    public ArrayList<Mascota> ListarMascotas(String rutCliente){
        ArrayList<Mascota> lista = new ArrayList<>();
        
        try {
            lista = ctrlMas.ListarMascotas(rutCliente);
            return lista;
        } catch (Exception e) {
            
            e.printStackTrace();
            return new ArrayList<>();
        }
        
    }
    
     public ArrayList<Usuario> listarMedico(){
         ArrayList<Usuario> lista = new ArrayList<>();
         
         try {
             lista = ctrlUsu.listarMedico();
             return lista;
         } catch (Exception e) {
             
             e.printStackTrace();
             return new ArrayList<>();
         }
    }
     
    public ArrayList<Cliente> ListarCliente(){
        return ctrlCli.ListarCliente();
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
