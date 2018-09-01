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
import modelo.Atencion;

/**
 *
 * @author Rav
 */
public class ControlAtencion {
    
    public void InsertarAtencion(Atencion ate){
        
        try {
           
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
            
            String insert = "INSERT INTO atencion_medica VALUES(curdate(),'"+ate.getRutCliente()+"', "
                                                                            +ate.getIdMascota()+", '"
                                                                            +ate.getRutMedico()+"', '"
                                                                            +ate.getRutUsuario()+"', '"
                                                                            +ate.getDescripSíntoma()+"', null, null, null, null);";
            
            stms.executeUpdate(insert);
            stms.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
        
        }
    }
    
    public void ActualizarAtencion(Atencion ate){
        
        try {
           
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
            
            String update = "UPDATE atencion_medica SET atencion_diagnostico ='"+ate.getDiagMedico()+"', "+
                                                           "atencion_procedi= '"+ate.getDescripTratamiento()+"', "+
                                                              "atencion_total ="+ate.getValorConsulta()+
                                                         " WHERE atencion_cod ="+ate.getId()+";";
            
            stms.executeUpdate(update);
            stms.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
        
        }
    }
    
    public boolean BuscarMedico(String rutMedico){
        boolean existe = false;
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");

            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT atencion_rut_medico FROM atencion_medica WHERE atencion_rut_medico ='"+rutMedico+"';";
            
            ResultSet rs= stms.executeQuery(consulta);
            while(rs.next()){
                Atencion ate = new Atencion();
                ate.setRutMedico(rs.getString("atencion_rut_medico"));
                if(ate.getRutMedico().equals(rutMedico)){
                    existe = true;
                }    
            }
            return existe;
            
        }catch(Exception e){
            
            e.printStackTrace();
            return existe;
        }
    }
    
    public ArrayList<Atencion> AtencionLista(){
        ArrayList<Atencion> lista = new ArrayList<Atencion>();
        
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");

            Statement stms = conexion.createStatement();
            
            String consulta= "SELECT atencion_cod, atencion_fechaAtencion, atencion_tipo_mascota,"
                    + " atencion_rut_medico, atencion_descrip, atencion_diagnostico, "
                    +"atencion_procedi, atencion_total"
                    + " FROM atencion_medica;";
            
            ResultSet rs = stms.executeQuery(consulta);
            
            while(rs.next()){
                Atencion aten = new Atencion();
                
                aten.setId(rs.getInt("atencion_cod"));
                aten.setFechaAtención(rs.getString("atencion_fechaAtencion"));
                aten.setIdMascota(rs.getInt("atencion_tipo_mascota"));
                aten.setRutMedico(rs.getString("atencion_rut_medico"));
                aten.setDescripSíntoma(rs.getString("atencion_descrip"));
                aten.setDiagMedico(rs.getString("atencion_diagnostico"));
                aten.setDescripTratamiento(rs.getString("atencion_procedi"));
                aten.setValorConsulta(rs.getInt("atencion_total"));
                
                
                lista.add(aten);
                
            }
            
            return lista;
        }catch(Exception e){
            
            e.printStackTrace();
            return new ArrayList<>();
        }
        
    }
    
    public ArrayList<Atencion> ListarAtencion(int cod){
        ArrayList<Atencion> lista = new ArrayList<Atencion>();
        
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");

            Statement stms = conexion.createStatement();
            
            String consulta= "SELECT ate.atencion_tipo_mascota, mas.mascota_nombre"
                    + " ate.atencion_descrip "
                    + "FROM atencion_medica ate JOIN mascota mas ON mas.mascota_cod = ate.atencion_tipo_mascota"
                    + "WHERE ate.atencion_cod = "+cod+";";
            
            ResultSet rs = stms.executeQuery(consulta);
            
            while(rs.next()){
                Atencion aten = new Atencion();
                
                
                
                aten.setIdMascota(rs.getInt("ate.atencion_tipo_mascota"));
                aten.setNombreMasco(rs.getString("mas.mascota_nombre"));
                aten.setDescripSíntoma(rs.getString("ate.atencion_descrip"));
                aten.setId(rs.getInt("ate.atencion_cod"));
                
                lista.add(aten);
                
            }
            
            return lista;
        }catch(Exception e){
            
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public ArrayList<Atencion> BuscarAtencion(String rutCliente){
        ArrayList<Atencion> lista = new ArrayList<Atencion>();
        String cosa = "";
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");

            Statement stms = conexion.createStatement();
            
            String consulta= "SELECT atencion_medica.atencion_fechaAtencion, mascota.mascota_nombre,"
                    + " atencion_medica.atencion_rut_medico, atencion_medica.atencion_descrip, atencion_medica.atencion_diagnostico, "
                    +"atencion_medica.atencion_procedi, atencion_medica.atencion_total"
                    + " FROM atencion_medica JOIN mascota ON atencion_medica.atencion_tipo_mascota = mascota.mascota_cod "
                    + "WHERE atencion_rut_cliente = '"+rutCliente+"';";
            
            ResultSet rs = stms.executeQuery(consulta);
            
            while(rs.next()){
                
                    Atencion aten = new Atencion();

                    aten.setFechaAtención(rs.getString("atencion_medica.atencion_fechaAtencion"));
                    aten.setNombreMasco(rs.getString("mascota.mascota_nombre"));
                    aten.setRutMedico(rs.getString("atencion_medica.atencion_rut_medico"));
                    aten.setDescripSíntoma(rs.getString("atencion_medica.atencion_descrip"));
                    aten.setDiagMedico(rs.getString("atencion_medica.atencion_diagnostico"));
                    aten.setDescripTratamiento(rs.getString("atencion_medica.atencion_procedi"));
                    aten.setValorConsulta(rs.getInt("atencion_medica.atencion_total"));
                    
                
                lista.add(aten);
                
            }
            
            return lista;
        }catch(Exception e){
            
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
}
