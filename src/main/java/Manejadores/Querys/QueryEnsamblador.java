package Manejadores.Querys;

import Modelos.Ensamblador;
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
public class QueryEnsamblador {
    Connection conexion;
    public static final String SELECT_ENSAMBLADOR = "SELECT * FROM ENSAMBLADOR";
    public static final String INSERT_ENSAMBLADOR = "INSERT INTO Ensamblador (id_ensamblador, nombre, apellido) VALUES (?,?,?)";
    public static final String ELIMINAR_ENSAMBLADOR = "DELETE FROM Ensamblador WHERE id_ensamblador=?";
    public static final String MODIFICAR_ENSAMBLADOR = "UPDATE Ensamblador SET nombre=?, apellido=? WHERE id_ensamblador=?";
    public void InsertarEnsamblador(Ensamblador ensamblador) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_ENSAMBLADOR);
            ps.setInt(1, ensamblador.getIdEnsamblador());
            ps.setString(2, ensamblador.getNombre());
            ps.setString(3, ensamblador.getApellido());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryEnsamblador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo insertar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo insertar");
    }
    
    public void setConexion(Connection conexion){
        this.conexion=conexion;
    }
    
    public void EliminarEnsamblador(int id){
        try {
            PreparedStatement ps = conexion.prepareStatement(ELIMINAR_ENSAMBLADOR);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryEnsamblador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo eliminar");
    }

    public void ModificarEnsamblador(Ensamblador ensamblador) {
        try {
            PreparedStatement ps = conexion.prepareStatement(MODIFICAR_ENSAMBLADOR);
            ps.setString(1, ensamblador.getNombre());
            ps.setString(2, ensamblador.getApellido());
            ps.setInt(3, ensamblador.getIdEnsamblador());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryEnsamblador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo modificar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo modificar");
    }

}
