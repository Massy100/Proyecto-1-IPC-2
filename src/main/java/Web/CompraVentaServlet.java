/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import CompraVenta.CompraVenta;
import CompraVenta.QueryCompraVenta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Massielle Coti
 */
public class CompraVentaServlet extends HttpServlet {
       private final String LISTAR_COMPRA_VENTA = "PaginaWeb/CompraVenta/CompraVentaListar.jsp";
    private final String INGRESAR_COMPRA_VENTA= "PaginaWeb/CompraVenta/CompraVentaIngresar.jsp";
    private final String MODIFICAR_COMPRA_VENTA = "PaginaWeb/CompraVenta/CompraVentaEditar.jsp";

    QueryCompraVenta qcv = new QueryCompraVenta();

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String destino = "";
            String comando = request.getParameter("comando");

        if (comando.equals("listar")) {
            destino=LISTAR_COMPRA_VENTA;
        }else if(comando.equalsIgnoreCase("eliminar")){
            destino=LISTAR_COMPRA_VENTA;
            String codigo= request.getParameter("codigo");
            qcv.EliminarCompraVenta(Integer.parseInt(codigo));
        }else if(comando.equalsIgnoreCase("ingresar")){
            destino = INGRESAR_COMPRA_VENTA;
        } else if (comando.equalsIgnoreCase("nuevo")) {
            destino = LISTAR_COMPRA_VENTA;
            String di = request.getParameter("id");
            String precio = request.getParameter("precio");
            String id_mueble = request.getParameter("id_mueble");
            int id = Integer.parseInt(di);
            double p = Double.parseDouble(precio);
            int im = Integer.parseInt(id_mueble);
            CompraVenta cv = new CompraVenta(id, p, im);
            qcv.InsertarCompraVenta(cv);
        } else if (comando.equalsIgnoreCase("editar")) {
            destino = MODIFICAR_COMPRA_VENTA;
            request.getSession().setAttribute("codigo_compra_venta", request.getParameter("codigo"));
        } else if (comando.equalsIgnoreCase("modificar")) {
            destino = LISTAR_COMPRA_VENTA;
            request.getSession().getAttribute("codigo_compra_venta");
            String v;
            v = (String) request.getSession().getAttribute("codigo_compra_venta");
            int codigo = Integer.parseInt(v);
             String precio = request.getParameter("precio");
            String id_mueble = request.getParameter("id_mueble");
             double p = Double.parseDouble(precio);
            int c = Integer.parseInt(id_mueble);
            CompraVenta cv=new CompraVenta(codigo, p, c);
            qcv.ModificarCompraVenta(cv);
        }
        
        RequestDispatcher requestDispatcher=request.getRequestDispatcher(destino);
        requestDispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
