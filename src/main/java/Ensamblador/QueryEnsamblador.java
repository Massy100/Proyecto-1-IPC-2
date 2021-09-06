package Ensamblador;


import Conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.runtime.Debug.id;
import static org.omg.CORBA.StructMemberHelper.id;

/**
 *
 * @author Massielle Coti
 */
public class QueryEnsamblador {
    Connection conexion;
    
    public static final String SELECT_ENSAMBLADOR = "SELECT * FROM Ensamblador";
    public static final String SELECT_ENSAMBLADOR_ALONE = "SELECT * FROM Ensamblador WHERE id_ensamblador=?";
    public static final String INSERT_ENSAMBLADOR = "INSERT INTO Ensamblador (id_ensamblador, nombre, apellido) VALUES (?,?,?)";
    public static final String ELIMINAR_ENSAMBLADOR = "DELETE FROM Ensamblador WHERE id_ensamblador=?";
    public static final String MODIFICAR_ENSAMBLADOR = "UPDATE Ensamblador SET nombre=?, apellido=? WHERE id_ensamblador=?";

    //CONSTRUCTOR
    public QueryEnsamblador() {
      this.conexion=Conectar.getConnection();
    }
    
    public void InsertarEnsamblador(Ensamblador ensamblador) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_ENSAMBLADOR);
            ps.setInt(1, ensamblador.getIdEnsamblador());
            ps.setString(2, ensamblador.getNombre());
            ps.setString(3, ensamblador.getApellido());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryEnsamblador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setConexion(Connection conexion){
        this.conexion=conexion;
    }
    
    public void EliminarEnsamblador(int id){
        try {
            PreparedStatement ps = conexion.prepareStatement(ELIMINAR_ENSAMBLADOR);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryEnsamblador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ModificarEnsamblador(Ensamblador ensamblador) {
        try {
            PreparedStatement ps = conexion.prepareStatement(MODIFICAR_ENSAMBLADOR);
            ps.setString(1, ensamblador.getNombre());
            ps.setString(2, ensamblador.getApellido());
            ps.setInt(3, ensamblador.getIdEnsamblador());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryEnsamblador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Ensamblador> ListarEnsamblador() {
        ArrayList<Ensamblador> ensambladores = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_ENSAMBLADOR);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("id_ensamblador");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                
                ensambladores.add(new Ensamblador(id, nombre, apellido));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryEnsamblador.class.getName()).log(Level.SEVERE,null,ex);
        }
        return ensambladores;
    }
    
    public Ensamblador SeleccionarUno(int codigo){
        Ensamblador ensamblador=new Ensamblador();
        
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SELECT_ENSAMBLADOR_ALONE);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {         
                int id = resultSet.getInt("id_ensamblador");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                
               ensamblador = new Ensamblador(id, nombre, apellido);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryEnsamblador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ensamblador;
    }

}
