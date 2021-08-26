/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;

/**
 *
 * @author Massielle Coti
 */
public class Cliente implements Serializable{
    private int id_cliente;
    private String direccion;
    private int nit;
    private String nombre;
    private String apellido;
    private int id_compra_venta;

    public Cliente(int id_cliente, String direccion, int nit, String nombre, String apellido, int id_compra_venta) {
        this.id_cliente = id_cliente;
        this.direccion = direccion;
        this.nit = nit;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_compra_venta = id_compra_venta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
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

    public int getId_compra_venta() {
        return id_compra_venta;
    }

    public void setId_compra_venta(int id_compra_venta) {
        this.id_compra_venta = id_compra_venta;
    }

    
    
}
