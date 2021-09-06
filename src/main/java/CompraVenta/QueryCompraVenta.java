/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompraVenta;

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
public class QueryCompraVenta {
    Connection conexion;
    public static final String SELECT_COMPRA_VENTA="SELECT * FROM Compra_venta";
    public static final String INSERT_COMPRA_VENTA= "INSERT INTO Compra_venta (id_compra_venta, precio, id_mueble) VALUES (?,?,?)";
    public static final String ELIMINAR_COMPRA_VENTA = "DELETE FROM Compra_venta WHERE id_compra_venta=?";
    public static final String MODIFICAR_COMPRA_VENTA = "UPDATE Compra_venta SET precio=? WHERE id_compra_venta=? AND id_mueble=?";
    public static final String SELECT_COMPRA_VENTA_ALONE = "SELECT * FROM Compra_venta WHERE id_comopra_venta=?";
    //CONSTRUCTOR
    public QueryCompraVenta() {
      this.conexion=Conectar.getConnection();
    }
    public void InsertarCompraVenta(CompraVenta cv) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_COMPRA_VENTA);
            ps.setInt(1, cv.getId_compra_venta());
            ps.setDouble(2, cv.getPrecio());
            ps.setInt(3, cv.getId_mueble());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryCompraVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        }
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
        }
    }
    public ArrayList<CompraVenta> ListarCompraVenta() {
        ArrayList<CompraVenta> cvs = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_COMPRA_VENTA);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id_compra_venta");
                double precio = result.getDouble("precio");
                int id_mueble = result.getInt("id_mueble");
                
                cvs.add(new CompraVenta(id, precio, id_mueble));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryCompraVenta.class.getName()).log(Level.SEVERE,null,ex);
        }
        return cvs;
    }
    
    public CompraVenta SeleccionarUnoCompraVenta(int codigo){
        CompraVenta cv=new CompraVenta();
        
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SELECT_COMPRA_VENTA_ALONE);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {         
                int id = resultSet.getInt("id_compra_venta");
                 double precio = resultSet.getDouble("precio");
                int id_mueble = resultSet.getInt("id_mueble");
                
                cv=new CompraVenta(id, precio, id_mueble);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryCompraVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cv;
    }
}
