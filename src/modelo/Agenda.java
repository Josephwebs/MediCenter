
package modelo;

import java.util.Date;


public class Agenda {
private String id; 
private String nom_paciente;
private String nom_medico;
private String rut_med;
private Date fecha;
private Date hora;

    public Agenda(String id, String nom_paciente, String nom_medico, String rut_med, Date fecha, Date hora) {
        this.id = id;
        this.nom_paciente = nom_paciente;
        this.nom_medico = nom_medico;
        this.rut_med = rut_med;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Agenda() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom_paciente() {
        return nom_paciente;
    }

    public void setNom_paciente(String nom_paciente) {
        this.nom_paciente = nom_paciente;
    }

    public String getNom_medico() {
        return nom_medico;
    }

    public void setNom_medico(String nom_medico) {
        this.nom_medico = nom_medico;
    }

    public String getRut_med() {
        return rut_med;
    }

    public void setRut_med(String rut_med) {
        this.rut_med = rut_med;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }
    
}
