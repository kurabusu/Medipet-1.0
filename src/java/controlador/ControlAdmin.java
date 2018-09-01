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

/**
 *
 * @author CETECOM
 */
public class ControlAdmin {
    
    public boolean validaAdmin(){
        boolean Existe = false;
        int cod = 0;
        try {
            
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT usuario_tipo_perfil FROM usuario;";
            
            ResultSet rs = stms.executeQuery(consulta);
            
            while(rs.next()){
                cod = rs.getInt("usuario_tipo_perfil");
                if(cod == 1){
                    Existe= true;
                }
            }
            
            rs.close();
            stms.close();
            return Existe;
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return Existe;
        }
        
    }
    
    
    
}
