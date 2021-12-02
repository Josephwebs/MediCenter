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
public class Paciente {
    private String rut; 
    private String nombre;
    private int edad;
    private String condicion;

    public Paciente(String rut, String nombre, int edad, String condicion) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.condicion = condicion;
    }

    public Paciente() {
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
    
    
}
