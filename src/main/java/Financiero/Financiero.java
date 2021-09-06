/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Financiero;

/**
 *
 * @author Massielle Coti
 */
public class Financiero {
    private int id_financiero;
    private String nombre;
    private String apellido;

    public Financiero(int id_financiero, String nombre, String apellido) {
        this.id_financiero = id_financiero;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId_financiero() {
        return id_financiero;
    }

    public void setId_financiero(int id_financiero) {
        this.id_financiero = id_financiero;
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


    
}
