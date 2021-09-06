/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ensamblador;

/**
 *
 * @author Massielle Coti
 */
public class Ensamblador {
    private int idEnsamblador;
    private String nombre;
    private String apellido;

    public Ensamblador(int idEnsamblador, String nombre, String apellido) {
        this.idEnsamblador = idEnsamblador;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getIdEnsamblador() {
        return idEnsamblador;
    }

    public void setIdEnsamblador(int idEnsamblador) {
        this.idEnsamblador = idEnsamblador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Ensamblador() {
    }

    public Ensamblador(int idEnsamblador) {
        this.idEnsamblador = idEnsamblador;
    }

 
    
}
