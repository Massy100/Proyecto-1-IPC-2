package Manejadores;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author Massielle Coti
 */
public class Modelador {
   Connection connection = null;
    
    public Modelador(Connection connection){
        this.connection = connection;
    }
    
    public Modelador(){
        
    }
    // eliminar, modificar, crear y consultas (querys)
    // clase por tabla, (manejador cliente y sus querys)
    // modelos por aparte
    public void obtenerDatos(JTable tabla, String query, String[] modelPreset){
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            
            int columnas = rsMd.getColumnCount();
            
            setModel(modelPreset, modelo);
            setSorter(modelo, tabla);
            
            while (rs.next()) {                
                
                Object[] filas = new Object[columnas];
                
                for (int i = 0; i < columnas; i++) {
                    filas[i] = rs.getObject(i+1);
                }
                
                modelo.addRow(filas);
            }
            
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        tabla.updateUI();
    }
    
    public void setModel(String[] modelPreset, DefaultTableModel modelo){
        for (int i = 0; i < modelPreset.length; i++) {
            modelo.addColumn(modelPreset[i]);
        }
    }
    
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    
    public void setSorter(DefaultTableModel modelo, JTable tabla){
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<>(modelo);
        tabla.setRowSorter(elQueOrdena);
    } 
    
}
