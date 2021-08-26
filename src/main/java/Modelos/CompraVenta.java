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
public class CompraVenta {
    private int id_compra_venta;
    private Double precio;
    private int id_mueble;

    public CompraVenta(int id_compra_venta, Double precio, int id_mueble) {
        this.id_compra_venta = id_compra_venta;
        this.precio = precio;
        this.id_mueble = id_mueble;
    }

    public int getId_compra_venta() {
        return id_compra_venta;
    }

    public void setId_compra_venta(int id_compra_venta) {
        this.id_compra_venta = id_compra_venta;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getId_mueble() {
        return id_mueble;
    }

    public void setId_mueble(int id_mueble) {
        this.id_mueble = id_mueble;
    }


    
}
