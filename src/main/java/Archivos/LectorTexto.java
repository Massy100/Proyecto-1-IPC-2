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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextArea;


/**
 *
 * @author Massielle Coti
 */
public class LectorTexto {

    private EscritorBinarios escritorBinarios = new EscritorBinarios();
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<CompraVenta> cvs = new ArrayList<>();
    ArrayList<Ensamblador> ensambladores = new ArrayList<>();
    ArrayList<Factura> facturas = new ArrayList<>();
    ArrayList<Financiero> financieros = new ArrayList<>();
    ArrayList<Mueble> muebles = new ArrayList<>();
    ArrayList<MuebleDevuelto> mds = new ArrayList<>();
    ArrayList<Pieza> piezas = new ArrayList<>();
    ArrayList<TipoMueble> tms = new ArrayList<>();
    ArrayList<TipoPieza> tps = new ArrayList<>();
    ArrayList<Vendedor> vendedores = new ArrayList<>();

    public void LeerFichero(File archivo, JTextArea text, JTextArea textErrores) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;

        while ((linea = br.readLine()) != null) {
            //con la linea leida, separamos los campos
            String[] campos = separarCampos(linea);

            //pasamos el texto a objeto
            if (linea.contains("USUARIO")) {
                Cliente cliente = Constructor.ConstruirCliente(campos);
                if (cliente != null) {
                    clientes.add(cliente);
                    this.escritorBinarios.GuardarCliente(clientes);
                    text.append("\n" + linea);
                }
            }else if (linea.contains("PIEZA")) {
                Pieza pieza = Constructor.ConstruirPieza(campos);
                if (pieza != null) {
                    piezas.add(pieza);
                    this.escritorBinarios.GuardarPieza(piezas);
                    text.append("\n" + linea);
                }
            } else if (linea.contains("MUEBLE")) {
                Mueble mueble = Constructor.ConstruirMueble(campos);
                if (mueble != null) {
                    muebles.add(mueble);
                    this.escritorBinarios.GuardarMueble(muebles);
                    text.append("\n" + linea);
                }
            } else if (linea.contains("ENSAMBLE_PIEZAS")) {
                Cliente cliente = Constructor.ConstruirCliente(campos);
                if (cliente != null) {
                    clientes.add(cliente);
                    this.escritorBinarios.GuardarCliente(clientes);
                    text.append("\n" + linea);
                }
            } else if (linea.contains("ENSAMBLADOR_MUEBLE")) {
                Cliente cliente = Constructor.ConstruirCliente(campos);
                if (cliente != null) {
                    clientes.add(cliente);
                    this.escritorBinarios.GuardarCliente(clientes);
                    text.append("\n" + linea);
                }
            }
            if (linea.contains("CLIENTE")) {
                Cliente cliente = Constructor.ConstruirCliente(campos);
                if (cliente != null) {
                    clientes.add(cliente);
                    this.escritorBinarios.GuardarCliente(clientes);
                    text.append("\n" + linea);
                }
            }
        }
        fr.close();

    }
    

    public boolean Busqueda(String fichero, File directorioFile) throws FileNotFoundException, IOException, ClassNotFoundException {
        File[] lista = directorioFile.listFiles();
        if (lista != null) {
            for (File elemento : lista) {
                if (fichero.equalsIgnoreCase(elemento.getName())) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return true;
    }
   
  

    public File BusquedaFile(String fichero, File directorio) throws FileNotFoundException, IOException, ClassNotFoundException {
        File[] archivos = directorio.listFiles();
        for (File archivo : archivos) {
            if (fichero.equalsIgnoreCase(archivo.getName())) {
                return archivo;
            }
        }
        return null;
    }

  

    private String[] separarCampos(String linea) {
        if (linea.contains("USUARIO(")) {
            String inicioAereolinea = "USUARIO(";
            String lineaDeCampos = linea.substring(inicioAereolinea.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            return campos;
        } else if (linea.contains("PIEZA(")) {
            String inicioAereopuerto = "PIEZA(";
            String lineaDeCampos = linea.substring(inicioAereopuerto.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            return campos;
        } else if (linea.contains("MUEBLE(")) {
            String inicioAvion = "MUEBLE(";
            String lineaDeCampos = linea.substring(inicioAvion.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            return campos;
        } else if (linea.contains("ENSAMBLE_PIEZAS(")) {
            String inicioDistancia = "ENSAMBLE_PIEZAS(";
            String lineaDeCampos = linea.substring(inicioDistancia.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            return campos;
        } else if (linea.contains("ENSAMBLADOR_MUEBLE(")) {
            String inicioDistancia = "ENSAMBLADOR_MUEBLE(";
            String lineaDeCampos = linea.substring(inicioDistancia.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            return campos;
        } else if (linea.contains("CLIENTE(")) {
            String inicioDistancia = "CLIENTE(";
            String lineaDeCampos = linea.substring(inicioDistancia.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            return campos;
        }

        return null;

    }
}
