/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendedor;

/**
 *
 * @author Massielle Coti
 */
public class Vendedor {
    private int id_vendedor;
    private String nombre;
    private String apellido;
    private int id_compra_venta;

    public Vendedor(int id_vendedor, String nombre, String apellido, int id_compra_venta) {
        this.id_vendedor = id_vendedor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_compra_venta = id_compra_venta;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
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

    public Vendedor() {
    }
    
}
