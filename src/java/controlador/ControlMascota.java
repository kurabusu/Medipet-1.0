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
import modelo.Mascota;
import modelo.TipoMascota;

/**
 *
 * @author Rav
 */
public class ControlMascota {
    
    public void InsertarMascota(Mascota mas){
        
         try 
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
        
            String insert = "INSERT INTO mascota VALUES(null,'"+mas.getRutCliente()+"' ,"
                                                          +mas.getTipoMascota()+", '"
                                                          +mas.getNombre()+"',STR_TO_DATE ('"
                                                          +mas.getFechaNacimiento()+"','%Y-%m-%d'));";
            
            System.out.println(insert);
            stms.executeUpdate(insert);
            stms.close();
            conexion.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            System.out.println(e.getMessage());
        }    
    }
    
    public void ModificarMascota(Mascota mas){
        try 
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
        
            String insert = "UPDATE mascota SET mascota_rut_cliente='"+mas.getRutCliente()+
                                            "', mascota_tipo= "+mas.getTipoMascota()+
                                            ", mascota_nombre= '"+mas.getNombre()+
                                            "', mascota_fechaNacimiento= STR_TO_DATE ('"+mas.getFechaNacimiento()+"','%Y-%m-%d')"
                                            +"WHERE mascota_cod ="+mas.getId()+";";
            
            System.out.println(insert);
            stms.executeUpdate(insert);
            stms.close();
            conexion.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            System.out.println(e.getMessage());
        }    
        
    }
    
    public ArrayList<Mascota> MascotasListar(){
        ArrayList<Mascota> lista = new ArrayList<>();
        
        try{
           
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
           
            Statement stms = conexion.createStatement();
            
            String consulta= "SELECT mascota.mascota_tipo, mascota.mascota_nombre, tipo_mascota.descrip_tipo_mascota, mascota.mascota_fechaNacimiento FROM mascota "
                    + "JOIN tipo_mascota ON tipo_mascota.cod_tipo_mascota = mascota.mascota_tipo;";
            
            ResultSet rs = stms.executeQuery(consulta);
            while(rs.next()){
                Mascota mas = new Mascota();
                
                mas.setTipoMascota(rs.getInt("mascota.mascota_tipo"));
                mas.setNombre(rs.getString("mascota.mascota_nombre"));
                mas.setDescrip(rs.getString("tipo_mascota.descrip_tipo_mascota"));
                mas.setFechaNacimiento(rs.getString("mascota.mascota_fechaNacimiento"));
                
                lista.add(mas);
            }
            return lista;
        }catch(Exception e){
                e.printStackTrace();
                return new ArrayList<>();
        }
        
    }
    
    public ArrayList<Mascota> ListarMascotas(String rutCliente){
        ArrayList<Mascota> lista = new ArrayList<>();
        String es="";
        try{
           
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
           
            Statement stms = conexion.createStatement();
            
            String consulta= "SELECT mascota.mascota_cod, mascota.mascota_rut_cliente, mascota.mascota_tipo, mascota.mascota_nombre, tipo_mascota.descrip_tipo_mascota, mascota.mascota_fechaNacimiento FROM mascota "
                    + "JOIN tipo_mascota ON tipo_mascota.cod_tipo_mascota = mascota.mascota_tipo WHERE mascota_rut_cliente = '"+rutCliente+"';";
            
            ResultSet rs = stms.executeQuery(consulta);
            while(rs.next()){
                es = rs.getString("mascota.mascota_rut_cliente");
                if(rutCliente.equals(es)){
                Mascota mas = new Mascota();
                
                mas.setId(rs.getInt("mascota.mascota_cod"));
                mas.setRutCliente(rutCliente);
                mas.setTipoMascota(rs.getInt("mascota.mascota_tipo"));
                mas.setNombre(rs.getString("mascota.mascota_nombre"));
                mas.setDescrip(rs.getString("tipo_mascota.descrip_tipo_mascota"));
                mas.setFechaNacimiento(rs.getString("mascota.mascota_fechaNacimiento"));
                
                lista.add(mas);}
            }
            return lista;
        }catch(Exception e){
                e.printStackTrace();
                return new ArrayList<>();
        }
        
    }
    
    public ArrayList<Mascota> BuscarMascotas(String rutCliente){
        
        ArrayList<Mascota> lista = new ArrayList<Mascota>();
        String busca = "";
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");

            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT mascota_cod, mascota_tipo, mascota_nombre, mascota_fechaNacimiento FROM mascota WHERE mascota_rut_cliente = '"+rutCliente+"';"; 
            
            ResultSet rs = stms.executeQuery(consulta);
            
            while(rs.next()){
                busca = rs.getString("mascota_rut_cliente");
                if(rutCliente.equals(busca)){
                Mascota mas = new Mascota();
                
                mas.setRutCliente(rutCliente);
                mas.setId(rs.getInt("mascota_cod"));
                mas.setTipoMascota(rs.getInt("mascota_tipo"));
                mas.setNombre(rs.getString("mascota_nombre"));
                mas.setFechaNacimiento(rs.getString("mascota_fechaNacimineto"));
                
                lista.add(mas);
                }
            }
            return lista;
        }catch(Exception e){
                
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public void EliminarMascotas(Mascota mas){
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
            
            String delete = "DELETE FROM mascota WHERE mascota_rut_cliente ='"+mas.getRutCliente()+"';";
            
            stms.executeUpdate(delete);
   
        } catch (Exception e) {

            e.printStackTrace();   
        }
    }
    
    public void InsertarTipo(TipoMascota tipo){
        try {
            
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
            
            String insert = "INSERT INTO tipo_mascota VALUES(null, '"+tipo.getDescripcion()+"');";
            
            stms.executeUpdate(insert);
   
        } catch (Exception e) {
 
            e.printStackTrace();    
        }
    }
    
    public boolean ValidaTipo(String descripcion){
        boolean existe = false;
        String descrip = "";
        try {
            
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT descrip_tipo_mascota FROM tipo_mascota;";
            
            ResultSet rs = stms.executeQuery(consulta);
            
            while(rs.next()){
                descrip = rs.getString("descrip_tipo_mascota");
                
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
    
    public void EliminarTipo(TipoMascota tipo){
        try {
            
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
            
            String insert = "DELETE FROM tipo_mascota WHERE descrip_tipo_mascota ='"+tipo.getDescripcion()+"';";
            
            stms.executeUpdate(insert);
   
        } catch (Exception e) {

            e.printStackTrace();   
        }
    }
    
    public ArrayList<TipoMascota> ListarTipos(int cod){
        ArrayList<TipoMascota> lista = new ArrayList<>();
        
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT descrip_tipo_mascota FROM tipo_mascota WHERE cod_tipo_mascota="+cod+";";           
            
            ResultSet rset = stms.executeQuery(consulta);
            
            while(rset.next()){
                
                TipoMascota perfil = new TipoMascota();
                
                perfil.setDescripcion(rset.getString("descrip_tipo_mascota"));
               
                lista.add(perfil);}
            
            return lista;
            
        }catch (Exception e) {
                
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public ArrayList<TipoMascota> TiposListar(){
        
        ArrayList<TipoMascota> lista = new ArrayList<>();
        
        try
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT cod_tipo_mascota, descrip_tipo_mascota FROM tipo_mascota;";           
            
            ResultSet rset = stms.executeQuery(consulta);
            
            while(rset.next()){
                
                TipoMascota perfil = new TipoMascota();
                
                perfil.setId(rset.getInt("cod_tipo_mascota"));
                perfil.setDescripcion(rset.getString("descrip_tipo_mascota"));
               
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
}
