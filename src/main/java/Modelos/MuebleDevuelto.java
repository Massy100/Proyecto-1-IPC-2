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
public class MuebleDevuelto {
    private int id_mueble_devuelto;
    private String motivo;
    private int id_compra_venta;

    public MuebleDevuelto(int id_mueble_devuelto, String motivo, int id_compra_venta) {
        this.id_mueble_devuelto = id_mueble_devuelto;
        this.motivo = motivo;
        this.id_compra_venta = id_compra_venta;
    }

    public int getId_mueble_devuelto() {
        return id_mueble_devuelto;
    }

    public void setId_mueble_devuelto(int id_mueble_devuelto) {
        this.id_mueble_devuelto = id_mueble_devuelto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getId_compra_venta() {
        return id_compra_venta;
    }

    public void setId_compra_venta(int id_compra_venta) {
        this.id_compra_venta = id_compra_venta;
    }



}
