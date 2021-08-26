package Manejadores;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Massielle Coti
 */
public class Conectar {
     static Connection Conexion = null;
    public Conectar(){
        
    }
    public int conectarDB() {
        try{

            if (Conexion != null) {
                JOptionPane.showMessageDialog(null, "La conexión previa con la base de datos sigue vigente");
            }

            String url = "jdbc:mysql://localhost:3306/Proyecto1";
            String user = "root";
            String password = "12345";

            Conexion = DriverManager.getConnection(url, user, password);
        }catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Conexion Fallida");
            return 2;
        }
        return 0;
    }
    
    public int desconectar(){
        Conexion = null;
        if (Conexion!=null) {
            JOptionPane.showMessageDialog(null, "Error al desconectar de base de datos, sigue conectado");
            return 1;
        }
        return 0;
    }
    
    public static Connection getConnection(){
        return Conexion;
    }
}
