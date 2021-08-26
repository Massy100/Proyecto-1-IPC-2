/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores.Querys;

import static Manejadores.Querys.QueryEnsamblador.MODIFICAR_ENSAMBLADOR;
import Modelos.Ensamblador;
import Modelos.Mueble;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Massielle Coti
 */
public class QueryMueble {
    Connection conexion;
    public static final String SELECT_MUEBLE = "SELECT * FROM MUEBLE_ENSAMBLADO";
    public static final String INSERT_MUEBLE = "INSERT INTO Mueble_ensamblado(id_mueble, precio_final, cantidad, fecha_ensamblado) VALUES (?,?,?,?)";
    public static final String ELIMINAR_MUEBLE = "DELETE FROM MUEBLE_ENSAMBLADO WHERE id_mueble=?";
    public static final String MODIFICAR_MUEBLE = "UPDATE Mueble_ensamblado SET precio_final=?, cantidad=?, fecha_ensamblado=? WHERE id_mueble=?";
   
     LocalDateConvertidor convertidor=new LocalDateConvertidor();
    
    public void InsertarMueble(Mueble mueble) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_MUEBLE);
            ps.setInt(1, mueble.getId_mueble());
            ps.setDouble(2, mueble.getPrecio_final());
            ps.setInt(3, mueble.getCantidad());
            ps.setDate(4, convertidor.convertToDatabaseColumn(mueble.getFecha_ensamblado()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryMueble.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo insertar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo insertar");
    }
    
    public void setConexion(Connection conexion){
        this.conexion=conexion;
    }
    
    public void EliminarMueble(int id){
        try {
            PreparedStatement ps = conexion.prepareStatement(ELIMINAR_MUEBLE);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryMueble.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo eliminar");
    }

    public void ModificarEnsamblador(Mueble mueble) {
        try {
            PreparedStatement ps = conexion.prepareStatement(MODIFICAR_ENSAMBLADOR);
            ps.setDouble(1, mueble.getPrecio_final());
            ps.setInt(2, mueble.getCantidad());
            ps.setDate(3, convertidor.convertToDatabaseColumn(mueble.getFecha_ensamblado()));
            ps.setInt(4, mueble.getId_mueble());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryMueble.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo modificar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo modificar");
    }
}
