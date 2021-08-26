/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores.Querys;

import Modelos.Cliente;
import Modelos.CompraVenta;
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
public class QueryCliente {

    Connection conexion;
    public static final String SELECT_CLENTE = "SELECT * FROM CLIENTE";
    public static final String INSERT_CLIENTE = "INSERT INTO Cliente (id_cliente, direccion, nit, nombre, apellido, id_compra_venta) VALUES (?,?,?,?,?,?)";
    public static final String ELIMINAR_CLIENTE = "DELETE FROM Compra/Venta WHERE id_compra_venta=?";
    public static final String MODIFICAR_CLIENTE = "UPDATE Cliente SET direccion=?, nit=?, nombre=?, apellido=? WHERE id_cliente=? AND id_compra_venta=?";
    public static final String SELECCIONAR_CLIENTE_ID = "SELECT FROM Cliente WHERE id_cliente=?";
    public static final String SELECCIONAR_CLIENTE_NIT = "SELECT FROM Cliente WHERE nit=?";

    public void InsertarCliente(Cliente cliente) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_CLIENTE);
            ps.setInt(1, cliente.getId_cliente());
            ps.setString(2, cliente.getDireccion());
            ps.setInt(3, cliente.getNit());
            ps.setString(4, cliente.getNombre());
            ps.setString(5, cliente.getApellido());
            ps.setInt(6, cliente.getId_compra_venta());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo insertar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo insertar");
    }
    
    public void setConexion(Connection conexion){
        this.conexion=conexion;
    }
    
    public void EliminarCliente(int id){
        try {
            PreparedStatement ps = conexion.prepareStatement(ELIMINAR_CLIENTE);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo eliminar");
    }

    public void ModificarCliente(Cliente cliente) {
        try {
            PreparedStatement ps = conexion.prepareStatement(MODIFICAR_CLIENTE);
            ps.setString(1, cliente.getDireccion());
            ps.setInt(2, cliente.getNit());
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getApellido());
            ps.setInt(5, cliente.getId_cliente());
            ps.setInt(6, cliente.getId_compra_venta());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo modificar");
        }
        JOptionPane.showMessageDialog(null, "Si se pudo modificar");
    }
}
