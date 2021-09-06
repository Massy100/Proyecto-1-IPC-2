/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CargaDatos;

import Cliente.Cliente;
import MuebleEnsamblado.Mueble;
import Pieza.Pieza;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 *
 * @author Massielle Coti
 */
public class Constructor {

    public static final String FILE_CLIENTES = "CLIENTE";
    public static final String FILE_MUEBLES = "MUEBLES";
    public static final String FILE_PIEZAS = "PIEZA";
    public static final String FILE_USUARIOS = "USUARIO";
    public static final String FILE_ENSAMBLE_PIEZAS = "ENSAMBLE_PIEZA";
    public static final String FILE_ENSAMBLAR_MUEBLE = "ENSAMBLAR_MUEBLE";

    public static Cliente ConstruirCliente(String[] campos) {
        Cliente cliente;
        return cliente = new Cliente(campos[0], campos[1], campos[2], campos[3], campos[4]);
    }
    
    public static Mueble ConstruirMueble(String[] campos) {
        Mueble mueble;
        return mueble = new Mueble(campos[0], Double.parseDouble(campos[1]));
    }

    public static Pieza ConstruirPieza(String[] campos) {
        Pieza pieza;
        return pieza = new Pieza(campos[0], Double.parseDouble(campos[1]));
    }

    public static Usuario ConstruirUsuario(String[] campos){
        Usuario usuario;
        return usuario=new Usuario(campos[0], campos[1], Integer.parseInt(campos[2]));
    }
    
    public static Pieza ConstruirEnsamblePiezas(String[] campos){
        Pieza pieza;
        return pieza=new Pieza(campos[0], campos[1], Integer.parseInt(campos[2]));
    }
    
    public static Mueble ConstruirEnsamblarMueble(String[] campos){
        Mueble em;
        return em=new Mueble(campos[0], campos[1], darFormatoFecha(campos[2].replaceAll("\"", "")));
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
