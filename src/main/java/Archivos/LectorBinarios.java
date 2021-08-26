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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


/**
 *
 * @author Massielle Coti
 */
public class LectorBinarios {
    
     public ArrayList<Cliente> LeerCliente() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Cliente> clientes = new ArrayList<>();
        String[]  archivos=EscritorBinarios.FILE_CLIENTE.list();
        ObjectInputStream lector;   
        System.out.println("Archivos de cliente:"+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorBinarios.FILE_CLIENTE+"/"+archivo));
            Cliente v =(Cliente)lector.readObject();
            clientes.add(v);
            lector.close();
        }
        return clientes;
    }
     
     public ArrayList<CompraVenta> LeerCompraVenta() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<CompraVenta> cvs = new ArrayList<>();
        String[]  archivos=EscritorBinarios.FILE_COMPRA_VENTA.list();
        ObjectInputStream lector;   
        System.out.println("Archivos de compra venta:"+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorBinarios.FILE_COMPRA_VENTA+"/"+archivo));
            CompraVenta v =(CompraVenta)lector.readObject();
            cvs.add(v);
            lector.close();
        }
        return cvs;
    }
     
     public ArrayList<Ensamblador> LeerEnsamblador() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Ensamblador> ensambladores = new ArrayList<>();
        String[]  archivos=EscritorBinarios.FILE_ENSAMBLADOR.list();
        ObjectInputStream lector;   
        System.out.println("Archivos de ensamblador:"+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorBinarios.FILE_ENSAMBLADOR+"/"+archivo));
            Ensamblador v =(Ensamblador)lector.readObject();
            ensambladores.add(v);
            lector.close();
        }
        return ensambladores;
    }
     
     public ArrayList<Factura> LeerFactura() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Factura> facturas = new ArrayList<>();
        String[]  archivos=EscritorBinarios.FILE_FACTURA.list();
        ObjectInputStream lector;   
        System.out.println("Archivos de FACTURA:"+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorBinarios.FILE_FACTURA+"/"+archivo));
            Factura v =(Factura)lector.readObject();
            facturas.add(v);
            lector.close();
        }
        return facturas;
    }
     
     public ArrayList<Financiero> LeerFinanciero() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Financiero> financieros = new ArrayList<>();
        String[]  archivos=EscritorBinarios.FILE_FINANCIERO.list();
        ObjectInputStream lector;   
        System.out.println("Archivos de financiero:"+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorBinarios.FILE_FINANCIERO+"/"+archivo));
            Financiero v =(Financiero)lector.readObject();
            financieros.add(v);
            lector.close();
        }
        return financieros;
    }
     
     public ArrayList<Mueble> LeerMueble() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Mueble> muebles = new ArrayList<>();
        String[]  archivos=EscritorBinarios.FILE_MUEBLE.list();
        ObjectInputStream lector;   
        System.out.println("Archivos de mueble:"+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorBinarios.FILE_MUEBLE+"/"+archivo));
            Mueble v =(Mueble)lector.readObject();
            muebles.add(v);
            lector.close();
        }
        return muebles;
    }
     
     public ArrayList<MuebleDevuelto> LeerMuebleDevuelto() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<MuebleDevuelto> mds = new ArrayList<>();
        String[]  archivos=EscritorBinarios.FILE_MUEBLE_DEVUELTO.list();
        ObjectInputStream lector;   
        System.out.println("Archivos de muebles devueltos:"+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorBinarios.FILE_MUEBLE_DEVUELTO+"/"+archivo));
            MuebleDevuelto v =(MuebleDevuelto)lector.readObject();
            mds.add(v);
            lector.close();
        }
        return mds;
    }
     
     public ArrayList<Pieza> LeerPieza() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Pieza> piezas = new ArrayList<>();
        String[]  archivos=EscritorBinarios.FILE_PIEZA.list();
        ObjectInputStream lector;   
        System.out.println("Archivos de piezas:"+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorBinarios.FILE_PIEZA+"/"+archivo));
            Pieza v =(Pieza)lector.readObject();
            piezas.add(v);
            lector.close();
        }
        return piezas;
    }
     
     public ArrayList<TipoMueble> LeerTipoMueble() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<TipoMueble> tms = new ArrayList<>();
        String[]  archivos=EscritorBinarios.FILE_TIPO_MUEBLE.list();
        ObjectInputStream lector;   
        System.out.println("Archivos de tipos de muebles:"+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorBinarios.FILE_TIPO_MUEBLE+"/"+archivo));
            TipoMueble v =(TipoMueble)lector.readObject();
            tms.add(v);
            lector.close();
        }
        return tms;
    }
     public ArrayList<TipoPieza> LeerTipoPieza() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<TipoPieza> tps = new ArrayList<>();
        String[]  archivos=EscritorBinarios.FILE_TIPO_PIEZA.list();
        ObjectInputStream lector;   
        System.out.println("Archivos de tipos de piezas:"+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorBinarios.FILE_TIPO_PIEZA+"/"+archivo));
            TipoPieza v =(TipoPieza)lector.readObject();
            tps.add(v);
            lector.close();
        }
        return tps;
     }
     
     public ArrayList<Vendedor> LeerVendedor() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        String[]  archivos=EscritorBinarios.FILE_VENDEDOR.list();
        ObjectInputStream lector;   
        System.out.println("Archivos de vendedores:"+archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorBinarios.FILE_TIPO_PIEZA+"/"+archivo));
            Vendedor v =(Vendedor)lector.readObject();
            vendedores.add(v);
            lector.close();
        }
        return vendedores;
    }
}
