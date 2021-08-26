/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores.Querys;

import Modelos.MuebleDevuelto;
import Modelos.Pieza;
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
public class QueryPieza {
     Connection conexion;
    public static final String SELECT_PIEZA="SELECT * FROM PIEZA";
    public static final String INSERT_PIEZA= "INSERT INTO Pieza (id_pieza, precio, fecha_ingreso, cantidad_ingreso, id_mueble) VALUES (?,?,?,?,?)";
    public static final String ELIMINAR_PIEZA = "DELETE FROM Pieza WHERE id_pieza=?";
    public static final String MODIFICAR_PIEZA = "UPDATE Pieza SET precio=?, fecha_ingreso=?, cantidad_ingreso=? WHERE ? id_pieza=? AND id_mueble=?";
    
    LocalDateConvertidor convertidor=new LocalDateConvertidor();
    
    public void InsertarPieza(Pieza pieza) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_PIEZA);
            ps.setInt(1, pieza.getId_pieza());
            ps.setDouble(2, pieza.getPrecio());
            ps.setDate(4, convertidor.convertToDatabaseColumn(pieza.getFecha_ingreso()));
            ps.setInt(4, pieza.getCantidad_ingreso());
            ps.setInt(5, pieza.getId_mueble());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryMuebleDevuelto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo insertar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo insertar");
    }
    
    public void setConexion(Connection conexion){
        this.conexion=conexion;
    }
    
    public void EliminarPieza(int id){
        try {
            PreparedStatement ps = conexion.prepareStatement(ELIMINAR_PIEZA);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryPieza.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo eliminar");
    }

    public void ModificarPieza(Pieza pieza) {
        try {
            PreparedStatement ps = conexion.prepareStatement(MODIFICAR_PIEZA);
            ps.setDouble(1, pieza.getPrecio());
            ps.setDate(4, convertidor.convertToDatabaseColumn(pieza.getFecha_ingreso()));
            ps.setInt(3, pieza.getCantidad_ingreso());
            ps.setInt(4, pieza.getId_pieza());
            ps.setInt(5, pieza.getId_mueble());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryPieza.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo modificar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo modificar");
    }
}
