/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Modelos.Cliente;
import Modelos.CompraVenta;
import Modelos.Ensamblador;
import Modelos.Factura;
import Modelos.Financiero;
import Modelos.Mueble;
import Modelos.MuebleDevuelto;
import Modelos.Pieza;
import Modelos.TipoMueble;
import Modelos.TipoPieza;
import Modelos.Vendedor;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 *
 * @author Massielle Coti
 */
public class Constructor {

    public static final String FILE_CLIENTES = "CLIENTE";
    public static final String FILE_COMPRAS_VENTAS = "COMPRA_VENTA";
    public static final String FILE_ENSAMBLADORES = "ENSAMBLADOR";
    public static final String FILE_FACTURAS = "FACTURA";
    public static final String FILE_FINANCIEROS = "FINANCIERO";
    public static final String FILE_MUEBLES = "MUEBLES";
    public static final String FILE_MUEBLES_DEVUELTOS = "MUEBLES_DEVUELTOS";
    public static final String FILE_PIEZAS = "PIEZA";
    public static final String FILE_TIPOS_MUEBLES = "TIPO_MUEBLE";
    public static final String FILE_TIPOS_PIEZAS = "TIPO_PIEZA";
    public static final String FILE_VENDEDORES = "VENDEDOR";

    public static Cliente ConstruirCliente(String[] campos) {
        Cliente cliente;
        return cliente = new Cliente(Integer.parseInt(campos[0]), campos[1], Integer.parseInt(campos[2]), campos[3], campos[4], Integer.parseInt(campos[5]));
    }

    public static CompraVenta ConstruirCompraVenta(String[] campos) {
        CompraVenta cv;
        return cv = new CompraVenta(Integer.parseInt(campos[0]), Double.parseDouble(campos[1]), Integer.parseInt(campos[2]));
    }

    public static Ensamblador ConstruirEnsamblador(String[] campos) {
        Ensamblador ensamblador;
        return ensamblador = new Ensamblador(Integer.parseInt(campos[0]), campos[1], campos[2]);
    }

    public static Factura ConstruirFactura(String[] campos) {
        Factura factura;
        return factura = new Factura(Integer.parseInt(campos[0]), Integer.parseInt(campos[1]), darFormatoFecha(campos[2]), Integer.parseInt(campos[3]));
    }

    public static Financiero ConstruirFinanciero(String[] campos) {
        Financiero financiero;
        return financiero = new Financiero(Integer.parseInt(campos[0]), campos[1], campos[2]);
    }

    public static Mueble ConstruirMueble(String[] campos) {
        Mueble mueble;
        return mueble = new Mueble(Integer.parseInt(campos[0]), campos[1], Double.parseDouble(campos[2]), Integer.parseInt(campos[3]), darFormatoFecha(campos[4]));
    }

    public static MuebleDevuelto ConstruirMuebleDevuelto(String[] campos) {
        MuebleDevuelto md;
        return md = new MuebleDevuelto(Integer.parseInt(campos[0]), campos[1], Integer.parseInt(campos[2]));
    }

    public static Pieza ConstruirPieza(String[] campos) {
        Pieza pieza;
        return pieza = new Pieza(Integer.parseInt(campos[0]), campos[1], Double.parseDouble(campos[2]), darFormatoFecha(campos[4]), Integer.parseInt(campos[3]), Integer.parseInt(campos[3]));
    }

    public static TipoMueble ConstruirTipoMueble(String[] campos) {
        TipoMueble tm;
        return tm = new TipoMueble(Integer.parseInt(campos[0]), campos[1]);
    }
    
    public static TipoPieza ConstruirTipoPieza(String[] campos) {
        TipoPieza tp;
        return tp = new TipoPieza(Integer.parseInt(campos[0]), campos[1]);
    }
    
    public static Vendedor ConstruirVendedor(String[] campos) {
        Vendedor vendedor;
        return vendedor = new Vendedor(Integer.parseInt(campos[0]), campos[1], campos[2], Integer.parseInt(campos[3]));
    }

    public static LocalTime darFormatoHora(String horaCadena) {
        String[] horaDividida = horaCadena.split(":");
        int hora = Integer.valueOf(horaDividida[0]);
        int minuto = Integer.valueOf(horaDividida[1]);
        return LocalTime.of(hora, minuto);
    }

    public static LocalDate darFormatoFecha(String fechaCadena) {
        String[] fechaDividida = fechaCadena.split("/");
        int dia = Integer.valueOf(fechaDividida[2]);
        int mes = Integer.valueOf(fechaDividida[1]);
        int anio = Integer.valueOf(fechaDividida[0]);
        return LocalDate.of(dia, mes, anio);
    }
}
