/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Rav
 */
public class Atencion {
    private String fechaAtención,rutCliente;
    private int idMascota;
    private String rutMedico,
	rutUsuario,
	descripSíntoma,
	diagMedico,
	descripTratamiento, nombreMasco;
    private int valorConsulta, id;

    public Atencion() {
        this.fechaAtención="";
        this.rutCliente="";
        this.idMascota=0;
        this.rutMedico="";
        this.rutUsuario="";
        this.descripSíntoma="";
        this.diagMedico="";
        this.descripTratamiento="";
        this.nombreMasco ="";
        this.valorConsulta=0;
        this.id=0;   
    }

    public String getNombreMasco() {
        return nombreMasco;
    }

    public void setNombreMasco(String nombreMasco) {
        this.nombreMasco = nombreMasco;
    }

    public String getFechaAtención() {
        return fechaAtención;
    }

    public void setFechaAtención(String fechaAtención) {
        this.fechaAtención = fechaAtención;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getRutMedico() {
        return rutMedico;
    }

    public void setRutMedico(String rutMedico) {
        this.rutMedico = rutMedico;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public String getDescripSíntoma() {
        return descripSíntoma;
    }

    public void setDescripSíntoma(String descripSíntoma) {
        this.descripSíntoma = descripSíntoma;
    }

    public String getDiagMedico() {
        return diagMedico;
    }

    public void setDiagMedico(String diagMedico) {
        this.diagMedico = diagMedico;
    }

    public String getDescripTratamiento() {
        return descripTratamiento;
    }

    public void setDescripTratamiento(String descripTratamiento) {
        this.descripTratamiento = descripTratamiento;
    }

    public int getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(int valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    

}
