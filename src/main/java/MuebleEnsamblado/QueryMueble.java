/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MuebleEnsamblado;


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
public class QueryMueble {

    Connection conexion;
    public static final String SELECT_MUEBLE = "SELECT * FROM Mueble_ensamblado";
    public static final String INSERT_MUEBLE = "INSERT INTO Mueble_ensamblado(id_mueble, nombre, precio_final, cantidad, fecha_ensamblado) VALUES (?,?,?,?,?)";
    public static final String ELIMINAR_MUEBLE = "DELETE FROM MUEBLE_ENSAMBLADO WHERE id_mueble=?";
    public static final String MODIFICAR_MUEBLE = "UPDATE Mueble_ensamblado SET nombre=?, precio_final=?, cantidad=?, fecha_ensamblado=? WHERE id_mueble=?";
    public static final String SELECT_MUEBLE_ALONE = "SELECT * FROM Mueble_ensamblado WHERE id_mueble=?";

    //LocalDateConvertidor convertidor = new LocalDateConvertidor();

    //CONSTRUCTOR
    

    public void InsertarMueble(Mueble mueble) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_MUEBLE);
            ps.setInt(1, mueble.getId_mueble());
            ps.setString(2, mueble.getNombre());
            ps.setDouble(3, mueble.getPrecio_final());
            ps.setInt(4, mueble.getCantidad());
            ps.setDate(5, (java.sql.Date.valueOf(mueble.getFecha_ensamblado())));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryMueble.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setConexion(Connection conexion){
        this.conexion=conexion;
    }
    
    public void EliminarMueble(int id){
        try {
            PreparedStatement ps = conexion.prepareStatement(ELIMINAR_MUEBLE);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryMueble.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ModificarMueble(Mueble mueble) {
        try {
            PreparedStatement ps = conexion.prepareStatement(MODIFICAR_MUEBLE);
            ps.setString(1, mueble.getNombre());
            ps.setDouble(2, mueble.getPrecio_final());
            ps.setInt(3, mueble.getCantidad());
            ps.setDate(4, (java.sql.Date.valueOf(mueble.getFecha_ensamblado())));
            ps.setInt(5, mueble.getId_mueble());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryMueble.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo modificar");
        }
    }
    
   public ArrayList<Mueble> ListarMueble() {
        ArrayList<Mueble> muebles = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_MUEBLE);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String nombre = result.getString(2);
                double precio=result.getDouble(3);
                int cantidad = result.getInt(4);
                LocalDate fecha = null;
                if(result.getString(5)!=null){
                    fecha=LocalDate.parse(result.getString(5));
                }else{
                    fecha=LocalDate.now();
                }
                
                muebles.add(new Mueble(id, nombre, precio, cantidad,  fecha));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryMueble.class.getName()).log(Level.SEVERE,null,ex);
        }
        return muebles;
    }
    
    public Mueble SeleccionarUnoMueble(int codigo){
        Mueble mueble=new Mueble();
        
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SELECT_MUEBLE_ALONE);
            preparedStatement.setInt(1, codigo);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {         
                int id = result.getInt(1);
                String nombre = result.getString(2);
                double precio=result.getDouble(3);
                int cantidad = result.getInt(4);
                LocalDate fecha=LocalDate.parse(result.getString(5));
                
               mueble = new Mueble(id, nombre, precio, cantidad, fecha);
            }
        } catch (SQLException ex) {
        }
        return mueble;
    }
    public QueryMueble() {
        this.conexion = Conectar.getConnection();
    }

    
}
