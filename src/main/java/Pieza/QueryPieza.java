/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieza;

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
public class QueryPieza {
     Connection conexion;
    public static final String SELECT_PIEZA="SELECT * FROM Pieza";
    public static final String INSERT_PIEZA= "INSERT INTO Pieza (id_pieza,nombre, precio, fecha_ingreso, cantidad_ingreso, id_tipo_pieza, id_mueble) VALUES (?,?,?,?,?,?,?)";
    public static final String ELIMINAR_PIEZA = "DELETE FROM Pieza WHERE id_pieza=?";
    public static final String MODIFICAR_PIEZA = "UPDATE Pieza SET nombre=?, precio=?, fecha_ingreso=?, cantidad_ingreso=? WHERE ? id_pieza=? AND id_tipo_pieza AND id_mueble=?";
     public static final String SELECT_TIPO_PIEZA_ALONE = "SELECT * FROM Pieza WHERE id_pieza=?";
    
    
    public void InsertarPieza(Pieza pieza) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_PIEZA);
            ps.setInt(1, pieza.getId_pieza());
            ps.setString(2, pieza.getNombre());
            ps.setDouble(3, pieza.getPrecio());
            ps.setDate(4, (java.sql.Date.valueOf(pieza.getFecha_ingreso())));
            ps.setInt(5, pieza.getCantidad_ingreso());
            ps.setInt(6, pieza.getId_tipo_pieza());
            ps.setInt(7, pieza.getId_mueble());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setConexion(Connection conexion){
        this.conexion=conexion;
    }
    
    public void EliminarPieza(int id){
        try {
            PreparedStatement ps = conexion.prepareStatement(ELIMINAR_PIEZA);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ModificarPieza(Pieza pieza) {
        try {
            PreparedStatement ps = conexion.prepareStatement(MODIFICAR_PIEZA);
            ps.setString(1, pieza.getNombre());
            ps.setDouble(2, pieza.getPrecio());
            ps.setDate(3, (java.sql.Date.valueOf(pieza.getFecha_ingreso())));
            ps.setInt(4, pieza.getCantidad_ingreso());
            ps.setInt(5, pieza.getId_pieza());
            ps.setInt(6, pieza.getId_tipo_pieza());
            ps.setInt(7, pieza.getId_mueble());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public ArrayList<Pieza> ListarPieza() {
        ArrayList<Pieza> tps = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_PIEZA);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id_tipo_pieza");
                String nombre = result.getString("nombre");
                double precio = result.getDouble("precio");
                LocalDate fecha=LocalDate.parse(result.getString("fecha_ingreso"));
                int cantidad = result.getInt("cantidad_ingreso");
                int id_tipo_pieza = result.getInt("id_tipoS_pieza");
                int id_mueble = result.getInt("id_mueble");
                tps.add(new Pieza(id, nombre, precio, fecha, cantidad, id_tipo_pieza,id_mueble));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryPieza.class.getName()).log(Level.SEVERE,null,ex);
        }
        return tps;
    }
    
    public Pieza SeleccionarUnoPieza(int codigo){
        Pieza pieza=new Pieza();
        
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SELECT_TIPO_PIEZA_ALONE);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {         
                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                double precio = resultSet.getDouble(3);
                LocalDate fecha=LocalDate.parse(resultSet.getString(4));
                int cantidad = resultSet.getInt(5);
                int id_tipo_pieza = resultSet.getInt(6);
                int id_mueble = resultSet.getInt(7);
               pieza = new Pieza(id, nombre, precio, fecha, cantidad,id_tipo_pieza,id_mueble);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pieza;
    }
    
    public QueryPieza() {
      this.conexion=Conectar.getConnection();
    }
}
