package Conexion;


import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {
    static Connection con;
    public Conectar(){
        try {
            if (con != null) {
                System.out.println("conexion previa aun vigente");
                return;
            }
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Proyecto1","root","12345");     
            System.out.println("conexion exitosa");
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
    }
    public static Connection getConnection(){
        return con;
    }
    
}
