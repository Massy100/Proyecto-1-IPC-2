/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CargaDatos;

import Cliente.Cliente;
import Conexion.Conectar;
import MuebleEnsamblado.Mueble;
import MuebleEnsamblado.QueryMueble;
import static MuebleEnsamblado.QueryMueble.INSERT_MUEBLE;
import Pieza.Pieza;
import Pieza.QueryPieza;
import static Pieza.QueryPieza.INSERT_PIEZA;
import Usuario.QueryUsuario;
import static Usuario.QueryUsuario.INSERT_USUARIO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;


/**
 *
 * @author Massielle Coti
 */
public class LectorTexto {
    Connection conexion;
     public static final String INSERT_PIEZA= "INSERT INTO pieza (nombre, precio) VALUES (?,?)";
      public static final String INSERT_MUEBLE = "INSERT INTO Mueble_ensamblado(nombre, precio_final) VALUES (?,?)";
      public static final String INSERT_ENSAMBLE_PIEZA= "INSERT INTO Pieza (nombre, tipo, cantidad_ingreso) VALUES (?,?,?)";
      public static final String INSERT_ENSAMBLAR_MUEBLE = "INSERT INTO Mueble_ensamblado(nombre,usuario, fecha_ensamblado) VALUES (?,?,?)";
      public static final String SELECT_USUARIO = "SELECT * FROM Usuario";
    private EscritorBinarios escritorBinarios = new EscritorBinarios();
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Mueble> muebles = new ArrayList<>();
    ArrayList<Pieza> piezas = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<EnsamblePiezas> eps = new ArrayList<>();
    ArrayList<EnsamblarMueble> ems = new ArrayList<>();

    public void LeerFichero(InputStream contenidoArchivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        PreparedStatement ps=null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(contenidoArchivo,StandardCharsets.UTF_8));
        String linea;
        conexion=Conectar.getConnection();
        while ((linea = reader.readLine()) != null) {
            //con la linea leida, separamos los campos
            String[] campos = separarCampos(linea);

            //pasamos el texto a objeto
            if (linea.contains("USUARIO")) {
                Usuario usuario = Constructor.ConstruirUsuario(campos);
                if (usuario != null) {
                    usuarios.add(usuario);
                    //this.escritorBinarios.GuardarUsuario(usuarios);
                    try {
                        ps = conexion.prepareStatement(INSERT_USUARIO);
                        ps.setString(1, usuario.getNombre().replaceAll("\"", ""));
                        ps.setString(2, usuario.getPassword().replaceAll("\"", ""));
                        ps.setInt(3, usuario.getTipo());
                        ps.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(QueryUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } else if (linea.contains("CLIENTE")) {
                Cliente cliente = Constructor.ConstruirCliente(campos);
                if (cliente != null) {
                    clientes.add(cliente);
                    //this.escritorBinarios.GuardarCliente(clientes);
                    try {
                        ps = conexion.prepareStatement("INSERT INTO cliente(direccion,nit,nombre,departamento,municipio) VALUES(?,?,?,?,?)");
                        ps.setString(1, cliente.getDireccion().replaceAll("\"", ""));
                        ps.setString(2, cliente.getNitt().replaceAll("\"", ""));
                        ps.setString(3, cliente.getNombre().replaceAll("\"", ""));
                        ps.setString(4, cliente.getDepartamento().replaceAll("\"", ""));
                         ps.setString(5, cliente.getMunicipio().replaceAll("\"", ""));
                       
                        
                        ps.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(QueryPieza.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            } else if (linea.contains("ENSAMBLE_PIEZAS")) {
              Pieza ep = Constructor.ConstruirEnsamblePiezas(campos);
                if (ep != null) {
                  
                        piezas.add(ep);
                        //this.escritorBinarios.GuardarEnsamblePieza(eps);
                       try{ ps = conexion.prepareStatement(INSERT_ENSAMBLE_PIEZA);
                       
                        ps.setString(1, ep.getNombre().replaceAll("\"", ""));
                        ps.setString(2, ep.getTipo().replaceAll("\"", ""));
                        ps.setInt(3, ep.getCantidad_ingreso());
                   
                        ps.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(LectorTexto.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }

            
            } else if (linea.startsWith("PIEZA")) {
                Pieza pieza = Constructor.ConstruirPieza(campos);
                if (pieza != null) {
                    piezas.add(pieza);
                    //this.escritorBinarios.GuardarPieza(piezas);
                    try {
                        ps = conexion.prepareStatement(INSERT_PIEZA);
                        ps.setString(1, pieza.getNombre().replaceAll("\"", ""));
                        ps.setDouble(2, pieza.getPrecio());
                        ps.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(QueryPieza.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } else if (linea.contains("ENSAMBLAR_MUEBLE")) {
                Mueble em = Constructor.ConstruirEnsamblarMueble(campos);
                if (em != null) {
                    muebles.add(em);
                    //this.escritorBinarios.GuardarEnsamblarMueble(ems);
                    try {
            ps = conexion.prepareStatement(INSERT_ENSAMBLAR_MUEBLE);
            
            ps.setString(1, em.getNombre().replaceAll("\"", ""));
            ps.setString(2, em.getUsuario());
            ps.setDate(3, (java.sql.Date.valueOf(em.getFecha_ensamblado())));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryMueble.class.getName()).log(Level.SEVERE, null, ex);
        }
                }
            } else if (linea.contains("MUEBLE")) {
                Mueble mueble = Constructor.ConstruirMueble(campos);
                if (mueble != null) {
                    muebles.add(mueble);
                    //this.escritorBinarios.GuardarCliente(clientes);
                    try {
                        ps = conexion.prepareStatement(INSERT_MUEBLE);
                        ps.setString(1, mueble.getNombre().replace("\"", ""));
                        ps.setDouble(2, mueble.getPrecio_final());
                        ps.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(QueryMueble.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }
        reader.close();

    }
    
/*
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

  */

    private String[] separarCampos(String linea) {
        if (linea.startsWith("USUARIO(")) {
            String v = "USUARIO(";
            String lineaDeCampos = linea.substring(v.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            return campos;
        } else if (linea.startsWith("PIEZA(")) {
            String v = "PIEZA(";
            String lineaDeCampos = linea.substring(v.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            return campos;
        } else if (linea.startsWith("MUEBLE(")) {
            String v = "MUEBLE(";
            String lineaDeCampos = linea.substring(v.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            return campos;
        } else if (linea.startsWith("ENSAMBLE_PIEZAS(")) {
            String v = "ENSAMBLE_PIEZAS(";
            String lineaDeCampos = linea.substring(v.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            return campos;
        } else if (linea.startsWith("ENSAMBLAR_MUEBLE(")) {
            String v = "ENSAMBLAR_MUEBLE(";
            String lineaDeCampos = linea.substring(v.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            return campos;
        } else if (linea.startsWith("CLIENTE(")) {
            String v = "CLIENTE(";
            String lineaDeCampos = linea.substring(v.length(), linea.length() - 1);
            String[] campos = lineaDeCampos.split(",");
            return campos;
        }

        return null;

    }
}
