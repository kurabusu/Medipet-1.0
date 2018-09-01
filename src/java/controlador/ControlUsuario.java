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
import modelo.Usuario;

/**
 *
 * @author CETECOM
 */
public class ControlUsuario {
    
    public void InsertarUsuario(Usuario usu){
        
        try 
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
        
        
            String insert = "INSERT INTO usuario VALUES('"+usu.getRut()+"' ,'"
                                                          +usu.getNombre()+"',STR_TO_DATE ('"
                                                          +usu.getFechaNacimiento()+"','%Y-%m-%d') ,'"
                                                          +usu.getEmail()+"', '"
                                                          +usu.getPassword()+"' ,"
                                                          +usu.getPerfil()+", null);";
            
            System.out.println(insert);
            stms.executeUpdate(insert);
            stms.close();
            conexion.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
    public boolean ValidaUsuario(String rut){
        boolean existe = false;
        String cliente = "";
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
           
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT usuario_rut FROM usuario;";
            
            ResultSet rs = stms.executeQuery(consulta);
            while(rs.next()){
               cliente = rs.getString("usuario_rut");
               if(rut.equals(cliente)){
                   existe = true;
               }
                
            }
            return existe;
        } catch (Exception e) {
            
            e.printStackTrace();
            return existe;
        }
    }
    
    
    public ArrayList<Usuario> listarMedico(){
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
           
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT usuario.usuario_rut, usuario.usuario_tipo_perfil, perfil.perfil_descripcion "
                               + "FROM perfil perfil JOIN usuario usuario ON usuario.usuario_tipo_perfil = perfil.perfil_codigo WHERE perfil.perfil_descripcion = 'Medico';";
            
            ResultSet rs = stms.executeQuery(consulta);
            while(rs.next()){
                Usuario usu = new Usuario();
                
                usu.setRut(rs.getString("usuario.usuario_rut"));
                usu.setPerfil(rs.getInt("usuario.usuario_tipo_perfil"));
                usu.setDescrip(rs.getString("perfil.perfil_descripcion"));
                
                lista.add(usu);
            }
            return lista;
        } catch (Exception e) {
            
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public ArrayList<Usuario> listarUsuarios(int indice){
            
        ArrayList<Usuario> lista = new ArrayList<>();
            
            try
            
            {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
           
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT usuario_rut, usuario_nombre, usuario_fechaNacimiento, usuario_email "
                               + "FROM usuario WHERE usuario_tipo_perfil ="+indice+";";
            
            ResultSet rs = stms.executeQuery(consulta);
            
            while(rs.next()){
                
                Usuario usu = new Usuario();
                
                usu.setRut(rs.getString("usuario_rut"));
                usu.setNombre(rs.getString("usuario_nombre"));
                usu.setFechaNacimiento(rs.getString("usuario_fechaNacimiento"));
                usu.setEmail(rs.getString("usuario_email"));
                
                lista.add(usu);
            }
            
            return lista;
            }catch(Exception e){
                
                e.printStackTrace();
                return new ArrayList<>();       
            }   
    }
    
    public ArrayList<Usuario> ListaUsuario(){
        
        ArrayList<Usuario> lista = new ArrayList<>();
            
            try
            
            {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
           
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT usuario_rut, usuario_nombre, usuario_fechaNacimiento, usuario_email, usuario_clave, "
                            + "usuario_tipo_perfil, usuario_id FROM usuario;";
            
            ResultSet rs = stms.executeQuery(consulta);
            
            while(rs.next()){
                
                Usuario usu = new Usuario();
                
                usu.setRut(rs.getString("usuario_rut"));
                usu.setNombre(rs.getString("usuario_nombre"));
                usu.setFechaNacimiento(rs.getString("usuario_fechaNacimiento"));
                usu.setEmail(rs.getString("usuario_email"));
                usu.setPassword(rs.getString("usuario_clave"));
                usu.setPerfil(rs.getInt("usuario_tipo_perfil"));
                usu.setId(rs.getInt("usuario_id"));
                
                lista.add(usu);
            }
            
            return lista;
            }catch(Exception e){
                
                e.printStackTrace();
                return new ArrayList<>();       
            }   
    }

    public void ModificarUsuario(Usuario usu){
        
        try 
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
        
        
            String insert = "UPDATE usuario set usuario_nombre= '"+usu.getNombre()+"', "
                                             + "usuario_fechaNacimiento ='"+usu.getFechaNacimiento()+"', "
                                             + "usuario_email ='"+usu.getEmail()+"', "
                                             + "usuario_clave ='"+usu.getPassword()+"', "
                                             + "usuario_tipo_perfil ="+usu.getPerfil()
                                             +" WHERE usuario_rut = '"+usu.getRut()+"';"; 
                                                          
            
            System.out.println(insert);
            stms.executeUpdate(insert);
            stms.close();
            conexion.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
        
    public void EliminarUsuario(Usuario usu){
        
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
            
            String delete = "DELETE FROM usuario WHERE usuario_rut ='"+usu.getRut()+"';";
            
            stms.executeUpdate(delete);
            stms.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }   
            
            
}      
        
    
    
    

