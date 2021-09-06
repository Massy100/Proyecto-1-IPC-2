/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.Serializable;

/**
 *
 * @author Massielle Coti
 */
public class Cliente implements Serializable{
    private int id_cliente;
    private String direccion;
    private String nit;
    private String nombre;
    private String apellido;
    private int id_compra_venta;
    private String municipio;
    private String departamento;
    private String nitt;

    public Cliente(int id_cliente, String direccion, String nit, String nombre, String apellido, int id_compra_venta) {
        this.id_cliente = id_cliente;
        this.direccion = direccion;
        this.nit = nit;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_compra_venta = id_compra_venta;
    }

    public Cliente(int id, String direccion, String nit, String nombre, String apellido, String departamento, String municipio, int idcv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
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

    public Cliente(String nombre, String nitt, String direccion, String departamento, String municipio) {
        this.direccion = direccion;
        this.nitt = nitt;
        this.nombre = nombre;
        this.municipio = municipio;
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNitt() {
        return nitt;
    }

    public void setNitt(String nitt) {
        this.nitt = nitt;
    }

    public Cliente() {
    }

    public Cliente(int id_cliente, String direccion, String nombre, String apellido, int id_compra_venta, String municipio, String departamento, String nitt) {
        this.id_cliente = id_cliente;
        this.direccion = direccion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_compra_venta = id_compra_venta;
        this.municipio = municipio;
        this.departamento = departamento;
        this.nitt = nitt;
    }

    
    
    
}
