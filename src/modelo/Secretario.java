/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alumno
 */
public class Secretario {
    static String rut;
    private String nombre;
    private String clave;

    public Secretario() {
    }

    public Secretario(String rut, String nombre, String clave) {
        Secretario.rut = rut;
        this.nombre = nombre;
        this.clave = clave;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        Secretario.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
      
}
