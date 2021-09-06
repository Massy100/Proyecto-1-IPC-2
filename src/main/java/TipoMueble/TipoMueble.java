/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TipoMueble;

import TipoPieza.*;

/**
 *
 * @author Massielle Coti
 */
public class TipoMueble {
    private int id_tipo_mueble;
    private String nombre;

    public TipoMueble(int id_tipo_mueble, String nombre) {
        this.id_tipo_mueble = id_tipo_mueble;
        this.nombre = nombre;
    }

    public int getId_tipo_mueble() {
        return id_tipo_mueble;
    }

    public void setId_tipo_mueble(int id_tipo_mueble) {
        this.id_tipo_mueble = id_tipo_mueble;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoMueble(int id_tipo_mueble) {
        this.id_tipo_mueble = id_tipo_mueble;
    }

    public TipoMueble() {
    }

    
}
