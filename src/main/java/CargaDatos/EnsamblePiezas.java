/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CargaDatos;

import java.io.Serializable;

/**
 *
 * @author Massielle Coti
 */
public class EnsamblePiezas implements Serializable{
    private String nombre;
    private String pieza;
    private int cantidad;

    public EnsamblePiezas(String nombre, String pieza, int cantidad) {
        this.nombre = nombre;
        this.pieza = pieza;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPieza() {
        return pieza;
    }

    public void setPieza(String pieza) {
        this.pieza = pieza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
