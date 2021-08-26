/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores.Querys;

import Modelos.CompraVenta;
import Modelos.MuebleDevuelto;
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
public class QueryMuebleDevuelto {
    Connection conexion;
    public static final String SELECT_MUEBLE_DEVUELTO="SELECT * FROM MUEBLE_DEVUELTO";
    public static final String INSERT_MUEBLE_DEVUELTO= "INSERT INTO Mueble_devuelto (id_mueble_devuelto, motivo. id_comprs_venta) VALUES (?,?,?)";
    public static final String ELIMINAR_MUEBLE_DEVUELTO = "DELETE FROM Mueble_devuelto WHERE id_mueble_devuelto=?";
    public static final String MODIFICAR_MUEBLE_DEVUELTO = "UPDATE Mueble_devuelto SET motivo=? WHERE ? id_mueble_devuelto=? AND id_compra_venta=?";
    
    public void InsertarMuebleDevuelto(MuebleDevuelto md) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_MUEBLE_DEVUELTO);
            ps.setInt(1, md.getId_mueble_devuelto());
            ps.setString(2, md.getMotivo());
            ps.setInt(3, md.getId_compra_venta());
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
    
    public void EliminarMuebleDevuelto(int id){
        try {
            PreparedStatement ps = conexion.prepareStatement(ELIMINAR_MUEBLE_DEVUELTO);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryMuebleDevuelto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo eliminar");
    }

    public void ModificarMuebleDevuelto(MuebleDevuelto md) {
        try {
            PreparedStatement ps = conexion.prepareStatement(MODIFICAR_MUEBLE_DEVUELTO);
            ps.setString(1, md.getMotivo());
            ps.setInt(2, md.getId_mueble_devuelto());
            ps.setInt(3, md.getId_compra_venta());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryMuebleDevuelto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo modificar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo modificar");
    }
}
