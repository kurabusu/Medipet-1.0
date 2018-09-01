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
import modelo.Cliente;

/**
 *
 * @author Rav
 */
public class ControlCliente {
    
    public boolean ValidaCliente(String rut){
        boolean existe = false;
        String cliente="";
        try
            
            {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
           
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT cliente_rut FROM cliente;";
            
            ResultSet rs = stms.executeQuery(consulta);
            
            while(rs.next()){
                

                cliente = rs.getString("cliente_rut");
                if(rut.equals(cliente)){
                    existe = true;
                }
                
            }
            return existe;
            }catch(Exception e){
                e.printStackTrace();
                return existe;
            }
    }
    
    public void InsertarCliente(Cliente cli){
        
        try 
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
        
        
            String insert = "INSERT INTO cliente VALUES('"+cli.getRut()+"' ,'"
                                                          +cli.getNombre()+"', '"
                                                          +cli.getDirección()+"', "
                                        + "STR_TO_DATE ('"+cli.getFechaNacimiento()+"','%Y-%m-%d') ,'"
                                                          +cli.getEmail()+"', '"
                                                          +cli.getSexo()+"', null);";
            
            System.out.println(insert);
            stms.executeUpdate(insert);
            stms.close();
            conexion.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Cliente> ClienteLista(String rut){
        String cosa ="";
        ArrayList<Cliente> lista = new ArrayList<>();
        
        try
            
            {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
           
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT cliente_rut, cliente_nombre, cliente_direccion, cliente_fechaNacimiento, cliente_email, "
                            + "cliente_genero, cliente_cod FROM cliente WHERE cliente_rut='"+rut+"';";
            
            ResultSet rs = stms.executeQuery(consulta);
            
            while(rs.next()){
                cosa = rs.getString("cliente_rut");
                if(rut.equals(cosa)){
                Cliente cli = new Cliente();
                
                cli.setRut(rs.getString("cliente_rut"));
                cli.setNombre(rs.getString("cliente_nombre"));
                cli.setDirección(rs.getString("cliente_direccion"));
                cli.setFechaNacimiento(rs.getString("cliente_fechaNacimiento"));
                cli.setEmail(rs.getString("cliente_email"));
                cli.setSexo(rs.getString("cliente_genero").charAt(0));
                cli.setId(rs.getInt("cliente_cod"));
                
                lista.add(cli);
                }
            }
            
            return lista;
            }catch(Exception e){
                
                e.printStackTrace();
                return new ArrayList<>();       
            }   
    }
    
    public ArrayList<Cliente> ListarCliente(){
        
        ArrayList<Cliente> lista = new ArrayList<>();
        
        try
            
            {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
           
            Statement stms = conexion.createStatement();
            
            String consulta = "SELECT cliente_rut, cliente_nombre, cliente_direccion, cliente_fechaNacimiento, cliente_email, "
                            + "cliente_genero, cliente_cod FROM cliente;";
            
            ResultSet rs = stms.executeQuery(consulta);
            
            while(rs.next()){
                
                Cliente cli = new Cliente();
                
                cli.setRut(rs.getString("cliente_rut"));
                cli.setNombre(rs.getString("cliente_nombre"));
                cli.setDirección(rs.getString("cliente_direccion"));
                cli.setFechaNacimiento(rs.getString("cliente_fechaNacimiento"));
                cli.setEmail(rs.getString("cliente_email"));
                cli.setSexo(rs.getString("cliente_genero").charAt(0));
                cli.setId(rs.getInt("cliente_cod"));
                
                lista.add(cli);
            }
            
            return lista;
            }catch(Exception e){
                
                e.printStackTrace();
                return new ArrayList<>();       
            }   
    }

    public void ModificarCliente(Cliente cli){
        
        try 
        {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
        
        
            String insert = "UPDATE cliente set cliente_nombre= '"+cli.getNombre()+"', "
                                             + "cliente_direccion ='"+cli.getDirección()+"', "
                                             + "cliente_fechaNacimiento ='"+cli.getFechaNacimiento()+"', "
                                             + "cliente_email ='"+cli.getEmail()+"', "
                                             + "cliente_genero ='"+cli.getSexo()
                                             +"' WHERE cliente_rut = '"+cli.getRut()+"';"; 
                                                          
            
            System.out.println(insert);
            stms.executeUpdate(insert);
            stms.close();
            conexion.close();
            
        } catch (Exception e) {
            
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
    public void EliminarCliente(Cliente cli){
        
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("medipet");
            
            Statement stms = conexion.createStatement();
            
            String delete = "DELETE FROM cliente WHERE cliente_rut ='"+cli.getRut()+"';";
            
            stms.executeUpdate(delete);
            stms.close();
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
    
    
    
    
}
    
    

