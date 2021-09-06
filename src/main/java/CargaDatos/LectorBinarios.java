/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CargaDatos;


import Cliente.Cliente;
import MuebleEnsamblado.Mueble;
import Pieza.Pieza;
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
     
     public ArrayList<Pieza> LeerPieza() throws FileNotFoundException,IOException,ClassNotFoundException{
        ArrayList<Pieza> piezas = new ArrayList<>();
        String[]  archivos=EscritorBinarios.FILE_PIEZA.list();
        ObjectInputStream lector;   
        System.out.println("Archivos de piezas:" + archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorBinarios.FILE_PIEZA + "/" + archivo));
            Pieza v = (Pieza) lector.readObject();
            piezas.add(v);
            lector.close();
        }
        return piezas;
    }

  public ArrayList<Usuario> LeerUsuario() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String[] archivos = EscritorBinarios.FILE_USUARIO.list();
        ObjectInputStream lector;
        System.out.println("Archivos de usuarios:" + archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorBinarios.FILE_USUARIO + "/" + archivo));
            Usuario v = (Usuario) lector.readObject();
            usuarios.add(v);
            lector.close();
        }
        return usuarios;
    }
   
   public ArrayList<EnsamblePiezas> LeerEnsamblePiezas() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<EnsamblePiezas> eps = new ArrayList<>();
        String[] archivos = EscritorBinarios.FILE_ENSAMBLE_PIEZA.list();
        ObjectInputStream lector;
        System.out.println("Archivos de ensamble de piezas:" + archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorBinarios.FILE_ENSAMBLE_PIEZA + "/" + archivo));
            EnsamblePiezas v = (EnsamblePiezas) lector.readObject();
            eps.add(v);
            lector.close();
        }
        return eps;
    }
    
    public ArrayList<EnsamblarMueble> LeerEnsamblarMueble() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<EnsamblarMueble> ems = new ArrayList<>();
        String[] archivos = EscritorBinarios.FILE_ENSAMBLAR_MUEBLE.list();
        ObjectInputStream lector;
        System.out.println("Archivos de ensamblar mueble:" + archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            String archivo = archivos[i];
            lector = new ObjectInputStream(new FileInputStream(EscritorBinarios.FILE_ENSAMBLAR_MUEBLE + "/" + archivo));
            EnsamblarMueble v = (EnsamblarMueble) lector.readObject();
            ems.add(v);
            lector.close();
        }
        return ems;
    }
}
