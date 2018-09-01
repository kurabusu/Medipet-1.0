/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author CETECOM
 */
public class Mascota {
    
    private String rutCliente;
    private int tipoMascota;
    private String nombre;
    private String fechaNacimiento;
    private int id;
    private String descrip;

    public Mascota() {
        this.rutCliente="";
        this.tipoMascota=0;
        this.nombre="";
        this.fechaNacimiento="";
        this.id=0;
        this.descrip="";
        
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public int getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(int tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
    
}
