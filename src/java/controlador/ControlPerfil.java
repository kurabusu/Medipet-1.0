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
import modelo.Perfil;

/**
 *
 * @author MZZO
 */
public class ControlPerfil {
    
    public boolean ValidaPerfil(String descripcion){
        boolean existe = false;
        String descrip = "";
        try {
            
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT perfil_descripcion FROM perfil;";
            
            ResultSet rs = stms.executeQuery(consulta);
            
            while(rs.next()){
                descrip = rs.getString("perfil_descripcion");
                
                if(descripcion.equalsIgnoreCase(descrip)){
                    existe = true;
                }
            }
            
            
            return existe;
            
        } catch (Exception e) {
            
            
            e.printStackTrace();
            return existe;
        }    
    }
    
    public ArrayList<Perfil> PerfilListar(){
        
        ArrayList<Perfil> lista = new ArrayList<>();
        
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
           
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT perfil_codigo, perfil_descripcion FROM perfil;";           
            
            ResultSet rset = stms.executeQuery(consulta);
            
            while(rset.next()){
                
                Perfil perfil = new Perfil();
                
                perfil.setId(rset.getInt("perfil_codigo"));
                perfil.setDescripcion(rset.getString("perfil_descripcion"));
               
                
                lista.add(perfil);
            }
            return lista;
        }
        catch(Exception ex)
        {
            
            ex.printStackTrace();
            return new ArrayList<>();
        }
        
    }
    
    public void AgregarPerfil(Perfil perfil){
        
        try {
            
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
            
            String insert = "INSERT INTO perfil VALUES(null, '"+perfil.getDescripcion()+"');";
            
            stms.executeUpdate(insert);
            System.out.println("Perfil Agregado");
            
            
        } catch (Exception e) {
            
            
            e.printStackTrace();
            
        }
        
    }
    
    
}
