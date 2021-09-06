/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieza;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Massielle Coti
 */
public class Pieza{
    private int id_pieza;
    private String nombre;
    private double precio;
    private LocalDate fecha_ingreso;
    private int cantidad_ingreso;
    private int id_tipo_pieza;
    private int id_mueble;
    private String tipo;

    public Pieza(int id_pieza, String nombre, double precio, LocalDate fecha_ingreso, int cantidad_ingreso, int id_tipo_pieza, int id_mueble) {
        this.id_pieza = id_pieza;
        this.nombre = nombre;
        this.precio = precio;
        this.fecha_ingreso = fecha_ingreso;
        this.cantidad_ingreso = cantidad_ingreso;
        this.id_tipo_pieza = id_tipo_pieza;
        this.id_mueble = id_mueble;
    }

    public int getId_pieza() {
        return id_pieza;
    }

    public void setId_pieza(int id_pieza) {
        this.id_pieza = id_pieza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getCantidad_ingreso() {
        return cantidad_ingreso;
    }

    public void setCantidad_ingreso(int cantidad_ingreso) {
        this.cantidad_ingreso = cantidad_ingreso;
    }

    public int getId_tipo_pieza() {
        return id_tipo_pieza;
    }

    public void setId_tipo_pieza(int id_tipo_pieza) {
        this.id_tipo_pieza = id_tipo_pieza;
    }

    public int getId_mueble() {
        return id_mueble;
    }

    public void setId_mueble(int id_mueble) {
        this.id_mueble = id_mueble;
    }



    public Pieza(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Pieza() {
    }

    public Pieza(int id_pieza) {
        this.id_pieza = id_pieza;
    }

    public Pieza(String nombre,  String tipo,int cantidad_ingreso) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad_ingreso = cantidad_ingreso;
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
}
