/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Massielle Coti
 */
public class QueryCliente {

    Connection conexion;
    public static final String SELECT_CLIENTE = "SELECT * FROM CLIENTE";
    public static final String INSERT_CLIENTE = "INSERT INTO Cliente (id_cliente, direccion, nit, nombre, apellido, id_compra_venta) VALUES (?,?,?,?,?,?)";
    public static final String ELIMINAR_CLIENTE = "DELETE FROM Compra/Venta WHERE id_compra_venta=?";
    public static final String MODIFICAR_CLIENTE = "UPDATE Cliente SET direccion=?, nit=?, nombre=?, apellido=? WHERE id_cliente=? AND id_compra_venta=?";
    public static final String SELECCIONAR_CLIENTE_ID = "SELECT FROM Cliente WHERE id_cliente=?";
    public static final String SELECCIONAR_CLIENTE_NIT = "SELECT FROM Cliente WHERE nit=?";
     public static final String SELECT_CLIENTE_ALONE = "SELECT * FROM Ensamblador WHERE id_ensamblador=?";

     //CONSTRUCTOR
    public QueryCliente() {
      this.conexion=Conectar.getConnection();
    }
    
    public void InsertarCliente(Cliente cliente) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_CLIENTE);
            ps.setInt(1, cliente.getId_cliente());
            ps.setString(2, cliente.getDireccion());
            ps.setString(3, cliente.getNit());
            ps.setString(4, cliente.getNombre());
            ps.setString(5, cliente.getApellido());
            ps.setInt(6, cliente.getId_compra_venta());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        }
    }

    public void ModificarCliente(Cliente cliente) {
        try {
            PreparedStatement ps = conexion.prepareStatement(MODIFICAR_CLIENTE);
            ps.setString(1, cliente.getDireccion());
            ps.setString(2, cliente.getNit());
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getApellido());
            ps.setInt(5, cliente.getId_cliente());
            ps.setInt(6, cliente.getId_compra_venta());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Cliente> ListarCliente() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_CLIENTE);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id_cliente");
                String direccion = result.getString("direccion");
                String nit = result.getString("nit");
                String nombre = result.getString("direccion");
                String apellido = result.getString("nit");
                int id_compra_venta = result.getInt("id_compra_venta");
                clientes.add(new Cliente(id, direccion, nit, nombre, apellido, id_compra_venta));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryCliente.class.getName()).log(Level.SEVERE,null,ex);
        }
        return clientes;
    }
    
    public Cliente SeleccionarUnoCliente(int codigo){
        Cliente cliente=new Cliente();
        
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SELECT_CLIENTE_ALONE);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {         
                int id = resultSet.getInt("id_cliente");
                String direccion = resultSet.getString("direccion");
                String nit = resultSet.getString("nit");
                String nombre = resultSet.getString("direccion");
                String apellido = resultSet.getString("nit");
                int id_compra_venta = resultSet.getInt("id_compra_venta");
               cliente = new Cliente(id, direccion, nit, nombre, apellido, id_compra_venta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
}
