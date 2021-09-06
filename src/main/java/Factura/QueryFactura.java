/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factura;

import Conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Massielle Coti
 */
public class QueryFactura {
    Connection conexion;
    public static final String SELECT_FACTURA="SELECT * FROM Factura";
    public static final String INSERT_FACTURA= "INSERT INTO Factura (id_factura, cantidad, fecha_transaccion, id_compra_venta) VALUES (?,?,?,?)";
    public static final String ELIMINAR_FACTURA = "DELETE FROM Factura WHERE id_factura=?";
    public static final String MODIFICAR_FACTURA = "UPDATE Factura SET catidad=?, fecha_transaccion=? WHERE id_factura=? AND id_compra_venta=?";
     public static final String SELECT_FACTURA_ALONE = "SELECT * FROM Factura WHERE id_factura=?";
   
     
     public QueryFactura() {
        this.conexion = Conectar.getConnection();
    }
    
    public void InsertarFactura(Factura factura) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_FACTURA);
            ps.setInt(1, factura.getId_factura());
            ps.setInt(2, factura.getCantidad());
            ps.setDate(3, (java.sql.Date.valueOf(factura.getFecha_transaccion())));
            ps.setInt(4, factura.getId_compra_venta());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        }
    }

    public void ModificarFactura(Factura factura) {
        try {
            PreparedStatement ps = conexion.prepareStatement(MODIFICAR_FACTURA);
            ps.setInt(1, factura.getCantidad());
           ps.setDate(2, (java.sql.Date.valueOf(factura.getFecha_transaccion())));
            ps.setInt(3, factura.getId_factura());
            ps.setInt(4, factura.getId_compra_venta());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public ArrayList<Factura> ListarFactura() {
        ArrayList<Factura> facturas = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_FACTURA);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                int cantidad = result.getInt(2);
                LocalDate fecha=LocalDate.parse(result.getString(3));
                int id_compra_venta = result.getInt(4);
               
                facturas.add(new Factura(id, cantidad, fecha, id_compra_venta));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryFactura.class.getName()).log(Level.SEVERE,null,ex);
        }
        return facturas;
    }
    
    public Factura SeleccionarUnoFactura(int codigo){
        Factura factura=new Factura();
        
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SELECT_FACTURA_ALONE);
            preparedStatement.setInt(1, codigo);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {         
                int id = result.getInt(1);
                int cantidad = result.getInt(2);
                 LocalDate fecha=LocalDate.parse(result.getString(3));
                 int id_compra_venta = result.getInt(4);
                
               factura = new Factura(id, cantidad, fecha, id_compra_venta);
            }
        } catch (SQLException ex) {
        }
        return factura;
    }
    
}
