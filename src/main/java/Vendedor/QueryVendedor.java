/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendedor;

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
public class QueryVendedor {
    Connection conexion;
    public static final String SELECT_VENDEDOR = "SELECT * FROM Vendedor";
    public static final String INSERT_VENDEDOR = "INSERT INTO Vendedor(id_vendedor, nombre, apellido, id_compra_venta) VALUES (?,?,?,?)";
    public static final String ELIMINAR_VENDEDOR = "DELETE FROM Vendedor WHERE id_vendedor=?";
    public static final String MODIFICAR_VENDEDOR = "UPDATE Vendedor SET nombre=?, apellido=? WHERE id_vendedor=? AND id_compra_venta=?";
        public static final String SELECT_VENDEDOR_ALONE = "SELECT * FROM Vendedor WHERE id_vendedor=?";
   
         //CONSTRUCTOR
    public QueryVendedor() {
      this.conexion=Conectar.getConnection();
    }
    
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
        }
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
        }
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
        }
    }
     public ArrayList<Vendedor> ListarVendedor() {
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_VENDEDOR);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id_vendedor");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                 int idcv = result.getInt("id_compra_venta");
                
                vendedores.add(new Vendedor(id, nombre, apellido, idcv));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryVendedor.class.getName()).log(Level.SEVERE,null,ex);
        }
        return vendedores;
    }
    
    public Vendedor SeleccionarUnoVendedor(int codigo){
        Vendedor vendedor=new Vendedor();
        
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SELECT_VENDEDOR_ALONE);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {         
                int id = resultSet.getInt("id_vendedor");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                 int idcv = resultSet.getInt("id_compra_venta");
                
               vendedor = new Vendedor(id, nombre, apellido, idcv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendedor;
    }
}
