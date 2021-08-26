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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Massielle Coti
 */
public class EscritorBinarios {
    //donde se guardn los archivos binarios
    public static final File  FILE_CLIENTE= new File("C:\\Users\\Massielle Coti\\Desktop\\Proyecto1\\Cliente");
    public static final File  FILE_COMPRA_VENTA= new File("C:\\Users\\Massielle Coti\\Desktop\\Proyecto1\\CompraVenta");
    public static final File  FILE_ENSAMBLADOR= new File("C:\\Users\\Massielle Coti\\Desktop\\Proyecto1\\Ensamblador");
    public static final File  FILE_FACTURA= new File("C:\\Users\\Massielle Coti\\Desktop\\Proyecto1\\Factura");
    public static final File  FILE_FINANCIERO= new File("C:\\Users\\Massielle Coti\\Desktop\\Proyecto1\\Financiero");
    public static final File  FILE_MUEBLE= new File("C:\\Users\\Massielle Coti\\Desktop\\Proyecto1\\Mueble");
    public static final File  FILE_MUEBLE_DEVUELTO= new File("C:\\Users\\Massielle Coti\\Desktop\\Proyecto1\\MuebleDevuelto");
    public static final File  FILE_PIEZA= new File("C:\\Users\\Massielle Coti\\Desktop\\Proyecto1\\Pieza");
    public static final File  FILE_TIPO_MUEBLE= new File("C:\\Users\\Massielle Coti\\Desktop\\Proyecto1\\TipoMueble");
    public static final File  FILE_TIPO_PIEZA= new File("C:\\Users\\Massielle Coti\\Desktop\\Proyecto1\\TipoPieza");
    public static final File  FILE_VENDEDOR= new File("C:\\Users\\Massielle Coti\\Desktop\\Proyecto1\\Vendedor");
    
    public void GuardarCliente(ArrayList<Cliente> clientes) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
       
        /*for (clase variabledeclarada: variablearraylist)*/
        for (Cliente cliente : clientes) {
            
            fileOutput = new FileOutputStream(FILE_CLIENTE+"/"+cliente.getId_cliente());
           
          
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(cliente);
            salida.close();
        }
    }
       
    public void GuardarCompraVenta(ArrayList<CompraVenta> cvs) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
       
        /*for (clase variabledeclarada: variablearraylist)*/
        for (CompraVenta cv : cvs) {
            
            fileOutput = new FileOutputStream(FILE_COMPRA_VENTA+"/"+cv.getId_compra_venta());
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(cv);
            salida.close();
        }
    }
    
    public void GuardarEnsamblador(ArrayList<Ensamblador> ensambladores) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
       
        
        for (Ensamblador ensamblador : ensambladores) {
            
            fileOutput = new FileOutputStream(FILE_ENSAMBLADOR+"/"+ensamblador.getIdEnsamblador());
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(ensamblador);
            salida.close();
        }
    }
    
    public void GuardarFactura(ArrayList<Factura> facturas) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
       
        
        for (Factura factura : facturas) {
            
            fileOutput = new FileOutputStream(FILE_FACTURA+"/"+factura.getId_factura());
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(factura);
            salida.close();
        }
    }
    
    public void GuardarFinanciero(ArrayList<Financiero> financieros) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
       
        
        for (Financiero financiero : financieros) {
            
            fileOutput = new FileOutputStream(FILE_FINANCIERO+"/"+financiero.getId_financiero());
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(financiero);
            salida.close();
        }
    }
    
    public void GuardarMueble(ArrayList<Mueble> muebles) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
       
        
        for (Mueble mueble : muebles) {
            
            fileOutput = new FileOutputStream(FILE_MUEBLE+"/"+mueble.getId_mueble());
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(mueble);
            salida.close();
        }
    }
    
    public void GuardarMuebleDevuelto(ArrayList<MuebleDevuelto> mds) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
       
        
        for (MuebleDevuelto md : mds) {
            
            fileOutput = new FileOutputStream(FILE_MUEBLE_DEVUELTO+"/"+md.getId_mueble_devuelto());
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(md);
            salida.close();
        }
    }
    
    public void GuardarPieza(ArrayList<Pieza> piezas) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
       
        
        for (Pieza pieza : piezas) {
            
            fileOutput = new FileOutputStream(FILE_PIEZA+"/"+pieza.getId_pieza());
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(pieza);
            salida.close();
        }
    }
    
     public void GuardarTipoMueble(ArrayList<TipoMueble> tms) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
       
        
        for (TipoMueble tm : tms) {
            
            fileOutput = new FileOutputStream(FILE_TIPO_MUEBLE+"/"+tm.getId_tipo_mueble());
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(tm);
            salida.close();
        }
    }
     
     public void GuardarTipoPieza(ArrayList<TipoPieza> tps) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
       
        
        for (TipoPieza tp : tps) {
            
            fileOutput = new FileOutputStream(FILE_TIPO_PIEZA+"/"+tp.getId_tipo_pieza());
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(tp);
            salida.close();
        }
    }
     
     public void GuardarVendedor(ArrayList<Vendedor> vendedores) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
       
        
        for (Vendedor vendedor : vendedores) {
            
            fileOutput = new FileOutputStream(FILE_VENDEDOR+"/"+vendedor.getId_vendedor());
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(vendedor);
            salida.close();
        }
    }
}
