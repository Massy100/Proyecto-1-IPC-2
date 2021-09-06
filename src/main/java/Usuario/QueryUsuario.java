/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Conexion.Conectar;
import Financiero.*;
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
public class QueryUsuario {
    Connection conexion;
    public static final String SELECT_USUARIO = "SELECT * FROM Usuario";
    public static final String INSERT_USUARIO= "INSERT INTO Usuario (nombre, pass, tipo) VALUES (?,?,?)";
    public static final String ELIMINAR_USUARIO= "DELETE FROM Usuario WHERE nombre=?";
    public static final String MODIFICAR_USUARIO = "UPDATE Usuario SET pass=?, tipo=? WHERE nombre=?";
    public static final String SELECT_USUARIO_ALONE = "SELECT * FROM Usuario WHERE nombre=?";
    public void InsertarUsuario(Usuario usuario) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_USUARIO);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getPassword());
            ps.setInt(3, usuario.getTipo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setConexion(Connection conexion){
        this.conexion=conexion;
    }
    
    public void EliminarUsuario(String nombre){
        try {
            PreparedStatement ps = conexion.prepareStatement(ELIMINAR_USUARIO);
            ps.setString(1, nombre);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ModificarUsuario(Usuario usuario) {
        try {
            PreparedStatement ps = conexion.prepareStatement(MODIFICAR_USUARIO);
            ps.setString(1, usuario.getPassword());
            ps.setInt(2, usuario.getTipo());
            ps.setString(3, usuario.getNombre());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QueryUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public ArrayList<Usuario> ListarUsuario() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_USUARIO);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                String nombre = result.getString(1);
                String password = result.getString(2);
                int tipo = result.getInt(3);
                
                usuarios.add(new Usuario(nombre, password, tipo));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryUsuario.class.getName()).log(Level.SEVERE,null,ex);
        }
        return usuarios;
    }
    
    public Usuario SeleccionarUnoUsuario(String u){
        Usuario usuario=new Usuario();
        
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SELECT_USUARIO_ALONE);
            preparedStatement.setString(1, u);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {         
                String nombre = result.getString(1);
                String password = result.getString(2);
                int tipo = result.getInt(3);
                
               usuario = new Usuario(nombre, password, tipo);
            }
        } catch (SQLException ex) {
        }
        return usuario;
    }
    public QueryUsuario() {
        this.conexion = Conectar.getConnection();
    }
    
}
