/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores.Querys;

import static Manejadores.Querys.QueryEnsamblador.ELIMINAR_ENSAMBLADOR;
import static Manejadores.Querys.QueryEnsamblador.INSERT_ENSAMBLADOR;
import static Manejadores.Querys.QueryEnsamblador.MODIFICAR_ENSAMBLADOR;
import Modelos.CompraVenta;
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
public class QueryCompraVenta {
    Connection conexion;
    public static final String SELECT_COMPRA_VENTA="SELECT * FROM COMPRA_VENTA";
    public static final String INSERT_COMPRA_VENTA= "INSERT INTO Compra/Venta (id_compra_venta, precio, id_mueble) VALUES (?,?,?)";
    public static final String ELIMINAR_COMPRA_VENTA = "DELETE FROM Compra/Venta WHERE id_compra_venta=?";
    public static final String MODIFICAR_COMPRA_VENTA = "UPDATE Compra/Venta SET precio=? WHERE id_compra_venta=? AND id_mueble=?";
    
    public void InsertarCompraVenta(CompraVenta cv) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_COMPRA_VENTA);
            ps.setInt(1, cv.getId_compra_venta());
            ps.setDouble(2, cv.getPrecio());
            ps.setInt(3, cv.getId_mueble());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryCompraVenta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo insertar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo insertar");
    }
    
    public void setConexion(Connection conexion){
        this.conexion=conexion;
    }
    
    public void EliminarCompraVenta(int id){
        try {
            PreparedStatement ps = conexion.prepareStatement(ELIMINAR_COMPRA_VENTA);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryCompraVenta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo eliminar");
    }

    public void ModificarCompraVenta(CompraVenta cv) {
        try {
            PreparedStatement ps = conexion.prepareStatement(MODIFICAR_COMPRA_VENTA);
            ps.setDouble(1, cv.getPrecio());
            ps.setInt(2, cv.getId_compra_venta());
            ps.setInt(3, cv.getId_mueble());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryCompraVenta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo modificar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo modificar");
    }
}
