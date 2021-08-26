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
public class Factura {
    private int id_factura;
    private int cantidad;
    private LocalDate fecha_transaccion;
    private int id_compra_venta;

    public Factura(int id_factura, int cantidad, LocalDate fecha_transaccion, int id_compra_venta) {
        this.id_factura = id_factura;
        this.cantidad = cantidad;
        this.fecha_transaccion = fecha_transaccion;
        this.id_compra_venta = id_compra_venta;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha_transaccion() {
        return fecha_transaccion;
    }

    public void setFecha_transaccion(LocalDate fecha_transaccion) {
        this.fecha_transaccion = fecha_transaccion;
    }

    public int getId_compra_venta() {
        return id_compra_venta;
    }

    public void setId_compra_venta(int id_compra_venta) {
        this.id_compra_venta = id_compra_venta;
    }

   
            
}
