/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores.Querys;

import Modelos.TipoMueble;
import Modelos.TipoPieza;
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
public class QueryTipoMueble {
        Connection conexion;
    public static final String SELECT_TIPO_MUEBLE = "SELECT * FROM TIPO_MUEBLE";
    public static final String INSERT_TIPO_MUEBLE = "INSERT INTO Tipo_mueble (id_tipo_mueble, nombre) VALUES (?,?)";
    public static final String ELIMINAR_TIPO_MUEBLE = "DELETE FROM Tipo_mueble WHERE id_tipo_mueble=?";
    public static final String MODIFICAR_TIPO_MUEBLE = "UPDATE Tipo_mueble SET nombre=? WHERE id_tipo_mueble=?";
    public void InsertarTipoPieza(TipoMueble tm) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_TIPO_MUEBLE);
            ps.setInt(1, tm.getId_tipo_mueble());
            ps.setString(2, tm.getNombre());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryTipoMueble.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo insertar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo insertar");
    }
    
    public void setConexion(Connection conexion){
        this.conexion=conexion;
    }
    
    public void EliminarTipoMueble(int id){
        try {
            PreparedStatement ps = conexion.prepareStatement(ELIMINAR_TIPO_MUEBLE);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryTipoMueble.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo eliminar");
    }

    public void ModificarTipoMueble(TipoMueble tm) {
        try {
            PreparedStatement ps = conexion.prepareStatement(MODIFICAR_TIPO_MUEBLE);
            ps.setString(1, tm.getNombre());
            ps.setInt(2, tm.getId_tipo_mueble());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryTipoMueble.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo modificar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo modificar");
    }
}
