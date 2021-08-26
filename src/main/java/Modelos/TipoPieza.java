/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Massielle Coti
 */
public class TipoPieza {
    private int id_tipo_pieza;
    private String nombre;

    public TipoPieza(int id_tipo_pieza, String nombre) {
        this.id_tipo_pieza = id_tipo_pieza;
        this.nombre = nombre;
    }

    public int getId_tipo_pieza() {
        return id_tipo_pieza;
    }

    public void setId_tipo_pieza(int id_tipo_pieza) {
        this.id_tipo_pieza = id_tipo_pieza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
