package Main;

import GUI.Form;
import Manejadores.Conectar;

/**
 *
 * @author Massielle Coti
 */
public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conectar conexion = new Conectar();
        conexion.conectarDB();
        Form v = new Form();
        v.setVisible(true);
        v.setConnection(conexion.getConnection());
    }
}
    

