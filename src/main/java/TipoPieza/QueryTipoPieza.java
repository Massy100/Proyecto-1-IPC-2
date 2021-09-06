/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TipoPieza;

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
public class QueryTipoPieza {

    Connection conexion;
    public static final String SELECT_TIPO_PIEZA = "SELECT * FROM TIPO_PIEZA";
    public static final String INSERT_TIPO_PIEZA = "INSERT INTO Tipo_pieza (id_tipo_pieza, nombre) VALUES (?,?)";
    public static final String ELIMINAR_TIPO_PIEZA = "DELETE FROM Tipo_pieza WHERE id_tipo_pieza=?";
    public static final String MODIFICAR_TIPO_PIEZA = "UPDATE Tipo_pieza SET nombre=? WHERE id_tipo_pieza=?";
    public static final String SELECT_TIPO_PIEZA_ALONE = "SELECT * FROM Tipo_pieza WHERE id_tipo_pieza=?";

    public void InsertarTipoPieza(TipoPieza tp) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_TIPO_PIEZA);
            ps.setInt(1, tp.getId_tipo_pieza());
            ps.setString(2, tp.getNombre());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryTipoPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void EliminarTipoPieza(int id){
        try {
            PreparedStatement ps = conexion.prepareStatement(ELIMINAR_TIPO_PIEZA);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryTipoPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ModificarTipoPieza(TipoPieza tp) {
        try {
            PreparedStatement ps = conexion.prepareStatement(MODIFICAR_TIPO_PIEZA);
            ps.setString(1, tp.getNombre());
            ps.setInt(2, tp.getId_tipo_pieza());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryTipoPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<TipoPieza> ListarTipoPieza() {
        ArrayList<TipoPieza> tps = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_TIPO_PIEZA);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id_tipo_pieza");
                String nombre = result.getString("nombre");
                
                tps.add(new TipoPieza(id, nombre));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryTipoPieza.class.getName()).log(Level.SEVERE,null,ex);
        }
        return tps;
    }
    
    public TipoPieza SeleccionarUno(int codigo){
        TipoPieza tp=new TipoPieza();
        
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SELECT_TIPO_PIEZA_ALONE);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {         
                int id = resultSet.getInt("id_tipo_pieza");
                String nombre = resultSet.getString("nombre");
                
               tp = new TipoPieza(id, nombre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryTipoPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tp;
    }
    
    public QueryTipoPieza() {
      this.conexion=Conectar.getConnection();
    }
    
}
