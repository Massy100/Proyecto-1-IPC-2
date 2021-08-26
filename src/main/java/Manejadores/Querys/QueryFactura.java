/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores.Querys;

import Modelos.CompraVenta;
import Modelos.Factura;
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
public class QueryFactura {
    Connection conexion;
    public static final String SELECT_FACTURA="SELECT * FROM FACTURA";
    public static final String INSERT_FACTURA= "INSERT INTO Factura (id_factura, cantidad, fecha_transaccion, id_compra_venta) VALUES (?,?,?,?)";
    public static final String ELIMINAR_FACTURA = "DELETE FROM Factura WHERE id_factura=?";
    public static final String MODIFICAR_FACTURA = "UPDATE Factura SET catidad=?, fecha_transaccion=? WHERE id_factura=? AND id_compra_venta=?";
    
    LocalDateConvertidor convertidor=new LocalDateConvertidor();
    
    public void InsertarFactura(Factura factura) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_FACTURA);
            ps.setInt(1, factura.getId_factura());
            ps.setInt(2, factura.getCantidad());
            ps.setDate(3, convertidor.convertToDatabaseColumn(factura.getFecha_transaccion()));
            ps.setInt(4, factura.getId_compra_venta());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryFactura.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo insertar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo insertar");
    }
    
    public void setConexion(Connection conexion){
        this.conexion=conexion;
    }
    
    public void EliminarFactura(int id){
        try {
            PreparedStatement ps = conexion.prepareStatement(ELIMINAR_FACTURA);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryFactura.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo eliminar");
    }

    public void ModificarFactura(Factura factura) {
        try {
            PreparedStatement ps = conexion.prepareStatement(MODIFICAR_FACTURA);
            ps.setInt(1, factura.getCantidad());
            ps.setDate(2, convertidor.convertToDatabaseColumn(factura.getFecha_transaccion()));
            ps.setInt(3, factura.getId_factura());
            ps.setInt(4, factura.getId_compra_venta());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryFactura.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo modificar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo modificar");
    }
    
}
