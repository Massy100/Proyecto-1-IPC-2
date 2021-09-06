/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import CompraVenta.CompraVenta;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Massielle Coti
 */
public class ReporteVentas extends Reporte {
    public ReporteVentas() {
    }

    public String getReporteVentas(HttpServletRequest request) {
        ArrayList<CompraVenta> ventas = (ArrayList<CompraVenta>) request.getSession().getAttribute("ventasReporte");

        String encabezado = (String) request.getSession().getAttribute("encabezadoVentas");
        String columnasVenta = "Codigo de venta;Precio;Id mueble; \n";

        String reporte = "";
        reporte += encabezado + "\n";

        for (int i = 0; i < ventas.size(); i++) {
            reporte += columnasVenta;
            CompraVenta ventaTemp = ventas.get(i);
            String filaVenta = ventaTemp.getId_compra_venta() + ";" + ventaTemp.getPrecio() + ";" + ventaTemp.getId_mueble();
            reporte += filaVenta + "\n";
                
            
        }
        return reporte;
    }
}
