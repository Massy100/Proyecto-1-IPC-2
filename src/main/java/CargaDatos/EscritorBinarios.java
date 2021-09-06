/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CargaDatos;

import Cliente.Cliente;
import MuebleEnsamblado.Mueble;
import Pieza.Pieza;
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
    public static final File  FILE_CLIENTE= new File("C:\\Users\\Massielle Coti\\Desktop\\Proyecto1\\Objetos\\Cliente");
    public static final File  FILE_MUEBLE= new File("C:\\Users\\Massielle Coti\\Desktop\\Proyecto1\\Objetos\\Mueble");
    public static final File  FILE_PIEZA= new File("C:\\Users\\Massielle Coti\\Desktop\\Proyecto1\\Objetos\\Pieza");
    public static final File  FILE_USUARIO= new File("C:\\Users\\Massielle Coti\\Desktop\\Proyecto1\\Objetos\\Usuario");
    public static final File  FILE_ENSAMBLE_PIEZA= new File("C:\\Users\\Massielle Coti\\Desktop\\Proyecto1\\Objetos\\EnsamblePiezas");
     public static final File  FILE_ENSAMBLAR_MUEBLE= new File("C:\\Users\\Massielle Coti\\Desktop\\Proyecto1\\Objetos\\EnsamblarMueble");
    
    public void GuardarCliente(ArrayList<Cliente> clientes) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
       
        /*for (clase variabledeclarada: variablearraylist)*/
        for (Cliente cliente : clientes) {
            
            fileOutput = new FileOutputStream(FILE_CLIENTE+"/"+cliente.getNitt());
           
          
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(cliente);
            salida.close();
        }
    }
    
    public void GuardarMueble(ArrayList<Mueble> muebles) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
       
        
        for (Mueble mueble : muebles) {
            
            fileOutput = new FileOutputStream(FILE_MUEBLE+"/"+mueble.getNombre());
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(mueble);
            salida.close();
        }
    }
    
    public void GuardarPieza(ArrayList<Pieza> piezas) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
       
        
        for (Pieza pieza : piezas) {
            
            fileOutput = new FileOutputStream(FILE_PIEZA+"/"+pieza.getNombre());
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(pieza);
            salida.close();
        }
    }
     public void GuardarUsuario(ArrayList<Usuario> usuarios) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
       
        
        for (Usuario usuario : usuarios) {
            
            fileOutput = new FileOutputStream(FILE_USUARIO+"/"+usuario.getNombre());
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(usuario);
            salida.close();
        }
    }
     
     public void GuardarEnsamblePieza(ArrayList<EnsamblePiezas> eps) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
       
        
        for (EnsamblePiezas ep : eps) {
            
            fileOutput = new FileOutputStream(FILE_ENSAMBLE_PIEZA+"/"+ep.getNombre());
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(ep);
            salida.close();
        }
    }
     public void GuardarEnsamblarMueble(ArrayList<EnsamblarMueble> ems) throws IOException,FileNotFoundException{
        FileOutputStream fileOutput; 
        ObjectOutputStream salida;
       
        
        for (EnsamblarMueble em : ems) {
            
            fileOutput = new FileOutputStream(FILE_ENSAMBLAR_MUEBLE+"/"+em.getNombre());
            salida = new ObjectOutputStream(fileOutput);
            salida.writeObject(em);
            salida.close();
        }
    }
     
}
