
package modelo;

import java.util.Date;


public class Agenda {
private int id; 
private String nom_paciente;
private String nom_medico;
private String rut_med;
private Date fecha;
private String hora;
private String secretario_rut;
private String paciente_rut;

    public Agenda(int id, String nom_paciente, String nom_medico, String rut_med, Date fecha, String hora, String secretario_rut, String paciente_rut) {
        this.id = id;
        this.nom_paciente = nom_paciente;
        this.nom_medico = nom_medico;
        this.rut_med = rut_med;
        this.fecha = fecha;
        this.hora = hora;
        this.secretario_rut = secretario_rut;
        this.paciente_rut = paciente_rut;
    }


    public Agenda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSecretario_rut() {
        return secretario_rut;
    }

    public void setSecretario_rut(String secretario_rut) {
        this.secretario_rut = secretario_rut;
    }

    public String getPaciente_rut() {
        return paciente_rut;
    }

    public void setPaciente_rut(String paciente_rut) {
        this.paciente_rut = paciente_rut;
    }
    
}
