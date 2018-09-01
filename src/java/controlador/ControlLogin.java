/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author CETECOM
 */
public class ControlLogin {
    
    public boolean ValidaLogin(String user, String pass){
       String us = "";
       String pssw = "";
       int cod = 0;
        boolean existe = false;
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT usuario_email, usuario_clave, usuario_tipo_perfil FROM usuario;";
            
            ResultSet rs = stms.executeQuery(consulta);
            
            while(rs.next()){
                us = rs.getString("usuario_email");
                pssw = rs.getString("usuario_clave");
                cod = rs.getInt("usuario_tipo_perfil");
                if(user.equals(us)){
                    if(pass.equals(pssw)){
                        existe = true;
                        break;
                    }
                }
            }
            
            System.out.println(existe);
            return existe;
            
        } catch (Exception e) {
              
            System.out.println(e.getMessage());
            return existe;
        }    
    }
    
  
    
    public ArrayList<Usuario> ListarDatos(){
        
        ArrayList<Usuario> lista = new ArrayList<>();
        
        try {
            
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
           
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT usuario_email, usuario_clave, usuario_tipo_perfil FROM usuario;";           
            
            ResultSet rset = stms.executeQuery(consulta);
            
            while(rset.next()){
                
                Usuario usuario = new Usuario();
                
                usuario.setEmail(rset.getString("usuario_email"));
                usuario.setPassword(rset.getString("usuario_clave"));
                usuario.setPerfil(rset.getInt("usuario_tipo_perfil"));
                
              
                
                lista.add(usuario);
            }
            return lista;
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    

    
}
