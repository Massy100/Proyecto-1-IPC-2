/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores.Querys;

import Modelos.Ensamblador;
import Modelos.Financiero;
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
public class QueryFinanciero {
    Connection conexion;
    public static final String SELECT_FINANCIERO = "SELECT * FROM FINANCIERO";
    public static final String INSERT_FINANCIERO = "INSERT INTO Financiero (id_financiero, nombre, apellido) VALUES (?,?,?)";
    public static final String ELIMINAR_FINANCIERO = "DELETE FROM Financiero WHERE id_financiero=?";
    public static final String MODIFICAR_FINANCIERO = "UPDATE Financiero SET nombre=?, apellido=? WHERE id_financiero=?";
    public void InsertarEnsamblador(Financiero financiero) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_FINANCIERO);
            ps.setInt(1, financiero.getId_financiero());
            ps.setString(2, financiero.getNombre());
            ps.setString(3, financiero.getApellido());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryFinanciero.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo insertar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo insertar");
    }
    
    public void setConexion(Connection conexion){
        this.conexion=conexion;
    }
    
    public void EliminarFinanciero(int id){
        try {
            PreparedStatement ps = conexion.prepareStatement(ELIMINAR_FINANCIERO);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryFinanciero.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo eliminar");
    }

    public void ModificarEnsamblador(Financiero financiero) {
        try {
            PreparedStatement ps = conexion.prepareStatement(MODIFICAR_FINANCIERO);
            ps.setString(1, financiero.getNombre());
            ps.setString(2, financiero.getApellido());
            ps.setInt(3, financiero.getId_financiero());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryFinanciero.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo modificar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo modificar");
    }
}
