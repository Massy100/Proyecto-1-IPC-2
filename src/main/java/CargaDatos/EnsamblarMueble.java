/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CargaDatos;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Massielle Coti
 */
public class EnsamblarMueble implements Serializable{
  private String nombre;
  private String usuario;
  private LocalDate fecha;

    public EnsamblarMueble(String nombre, String usuario, LocalDate fecha) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
  
  
}
