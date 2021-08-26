/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores.Querys;

import static Manejadores.Querys.QueryEnsamblador.MODIFICAR_ENSAMBLADOR;
import Modelos.Mueble;
import Modelos.Vendedor;
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
public class QueryVendedor {
    Connection conexion;
    public static final String SELECT_VENDEDOR = "SELECT * FROM MUEBLE_VENDEDOR";
    public static final String INSERT_VENDEDOR = "INSERT INTO Vendedor(id_vendedor, nombre, apellido, id_compra_venta) VALUES (?,?,?,?)";
    public static final String ELIMINAR_VENDEDOR = "DELETE FROM Vendedor WHERE id_vendedor=?";
    public static final String MODIFICAR_VENDEDOR = "UPDATE Vendedor SET nombre=?, apellido=? WHERE id_vendedor=?, id_compra_venta=?";
   
    public void InsertarVendedor(Vendedor vendedor) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_VENDEDOR);
            ps.setInt(1, vendedor.getId_vendedor());
            ps.setString(2, vendedor.getNombre());
            ps.setString(3, vendedor.getApellido());
            ps.setInt(4, vendedor.getId_compra_venta());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryVendedor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo insertar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo insertar");
    }
    
    public void setConexion(Connection conexion){
        this.conexion=conexion;
    }
    
    public void EliminarVendedor(int id){
        try {
            PreparedStatement ps = conexion.prepareStatement(ELIMINAR_VENDEDOR);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryVendedor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo eliminar");
    }

    public void ModificarVendedor(Vendedor vendedor) {
        try {
            PreparedStatement ps = conexion.prepareStatement(MODIFICAR_VENDEDOR);
            ps.setString(1, vendedor.getNombre());
            ps.setString(2, vendedor.getApellido());
            ps.setInt(3, vendedor.getId_vendedor());
            ps.setInt(4, vendedor.getId_compra_venta());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryVendedor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo modificar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo modificar");
    }
}
