/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Archivos.EscritorBinarios;
import Archivos.LectorBinarios;
import Archivos.LectorTexto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Massielle Coti
 */
public class CargarDatos extends javax.swing.JFrame {

    
    private LectorTexto lectorTexto;
    private EscritorBinarios escritorBinarios;
    private LectorBinarios lectorBinarios;
    public CargarDatos() {
        initComponents();
        this.lectorTexto = new LectorTexto();
        this.escritorBinarios = new EscritorBinarios();
        this.lectorBinarios = new LectorBinarios();
    }
    
    public static String errores="";
    
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        historialDeCargaText = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        cargarInfoButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TAreaErrores = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollBar1 = new javax.swing.JScrollBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        historialDeCargaText.setColumns(20);
        historialDeCargaText.setRows(5);
        jScrollPane1.setViewportView(historialDeCargaText);

        jLabel1.setText("Datos Cargados:");

        cargarInfoButton.setText("CargarInformacion");
        cargarInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarInfoButtonActionPerformed(evt);
            }
        });

        TAreaErrores.setColumns(20);
        TAreaErrores.setRows(5);
        jScrollPane5.setViewportView(TAreaErrores);

        jLabel14.setText("Errores de Carga: ");

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(262, 262, 262)
                                .addComponent(cargarInfoButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)))
                        .addGap(0, 745, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cargarInfoButton)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cargar Informacion", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 976, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(464, 464, 464))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    }                                                  
    */
        
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        Form administrador = new Form();
        administrador.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cargarInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarInfoButtonActionPerformed
        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //aqui selecciono y guardo el FILE que va a utilizar el FileReader
            File fichero = fileChosser.getSelectedFile();
            try {
                this.lectorTexto.LeerFichero(fichero, this.historialDeCargaText, this.TAreaErrores);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al leer el archivo");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CargarDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        errores=TAreaErrores.getText();
    }//GEN-LAST:event_cargarInfoButtonActionPerformed

        


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TAreaErrores;
    private javax.swing.JButton cargarInfoButton;
    private javax.swing.JTextArea historialDeCargaText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

private void limpiarCamposDeCreacion() {

    }
}
