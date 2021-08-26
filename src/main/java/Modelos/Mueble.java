/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Massielle Coti
 */
public class Mueble {
    private int id_mueble;
    private String nombre;
    private Double precio_final;
    private int cantidad;
    private LocalDate fecha_ensamblado;

    public Mueble(int id_mueble, String nombre, Double precio_final, int cantidad, LocalDate fecha_ensamblado) {
        this.id_mueble = id_mueble;
        this.nombre = nombre;
        this.precio_final = precio_final;
        this.cantidad = cantidad;
        this.fecha_ensamblado = fecha_ensamblado;
    }

    public int getId_mueble() {
        return id_mueble;
    }

    public void setId_mueble(int id_mueble) {
        this.id_mueble = id_mueble;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio_final() {
        return precio_final;
    }

    public void setPrecio_final(Double precio_final) {
        this.precio_final = precio_final;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha_ensamblado() {
        return fecha_ensamblado;
    }

    public void setFecha_ensamblado(LocalDate fecha_ensamblado) {
        this.fecha_ensamblado = fecha_ensamblado;
    }

   
    
}
