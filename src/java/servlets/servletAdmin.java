/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlador.ControlAtencion;
import controlador.ControlPerfil;
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
import modelo.Perfil;
import modelo.Usuario;

/**
 *
 * @author MZZO
 */
@WebServlet(name = "servletAdmin", urlPatterns = {"/servletAdmin"})
public class servletAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ControlUsuario ctrl = new ControlUsuario();
    ControlAtencion ctrlAte = new ControlAtencion();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            String btn_agregar = request.getParameter("btn_agregar");
            String btn_eliminar = request.getParameter("btn_eliminar");
            String btn_modificar = request.getParameter("btn_modificar");
            String btn_listar = request.getParameter("btn_listar");
            String btn_perfiles = request.getParameter("btn_perfiles");
            String btn_clientes = request.getParameter("btn_clientes");
            String btn_mascotas = request.getParameter("btn_mascotas");
            String btn_atenciones = request.getParameter("btn_atenciones");
            
            RequestDispatcher dispatcher;
            
            if (btn_agregar!= null) {
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("s_perfiles", PerfilListar());
                
                dispatcher = request.getServletContext().getRequestDispatcher("/creaUsuario.jsp");
                dispatcher.forward(request, response);
                
            }else if(btn_eliminar!= null){
                
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("s_usuarios", ListaUsuario());
             
                dispatcher = request.getServletContext().getRequestDispatcher("/eliminarUsuario.jsp");
                dispatcher.forward(request, response);
                
            }else if(btn_modificar!= null){
                
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("s_perfiles", PerfilListar());
                sesion.setAttribute("s_usuarios", ListaUsuario());
                
                dispatcher = request.getServletContext().getRequestDispatcher("/modificarUsuario.jsp");
                dispatcher.forward(request, response);
                
            }else if(btn_listar!= null){
                
                HttpSession sesion = request.getSession(true);
                int indice = 0;
                sesion.setAttribute("s_perfiles", PerfilListar());
                sesion.setAttribute("s_usuarios", listarUsuarios(indice));
                dispatcher = request.getServletContext().getRequestDispatcher("/listarUsuario.jsp");
                dispatcher.forward(request, response);
                
            }else if(btn_perfiles!= null){
                
                dispatcher = request.getServletContext().getRequestDispatcher("/agregarPerfil.jsp");
                dispatcher.forward(request, response);
                
            }else if(btn_clientes!= null){
                
                dispatcher = request.getServletContext().getRequestDispatcher("/admiClientes.jsp");
                dispatcher.forward(request, response);
                
            }else if(btn_mascotas!= null){
                
                dispatcher = request.getServletContext().getRequestDispatcher("/admiMascotas.jsp");
                dispatcher.forward(request, response);
                
            }else if(btn_atenciones!= null){
                
                dispatcher = request.getServletContext().getRequestDispatcher("/admiAtenciones.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
    
    public boolean BuscarMedico(String rutMedico){
        
       return BuscarMedico(rutMedico);    
    }
    
     public ArrayList<Perfil> PerfilListar(){
        
        ControlPerfil ctrl = new ControlPerfil();
        ArrayList<Perfil> lista = new ArrayList<>();
        
        try {
            
            lista = ctrl.PerfilListar();
            return lista;
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return new ArrayList<>();        }
        
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
