/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Factura.Factura;
import Factura.QueryFactura;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Massielle Coti
 */
public class FacturaServlet extends HttpServlet {

   private final String LISTAR_FACTURA = "PaginaWeb/Factura/FacturaListar.jsp";
    private final String INGRESAR_FACTURA = "PaginaWeb/Factura/FacturaIngresar.jsp";
    private final String MODIFICAR_FACTURA = "PaginaWeb/Factura/FacturaEditar.jsp";

    QueryFactura qf = new QueryFactura();

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String destino = "";
            String comando = request.getParameter("comando");

        if (comando.equals("listar")) {
            destino=LISTAR_FACTURA;
        }else if(comando.equalsIgnoreCase("eliminar")){
            destino=LISTAR_FACTURA;
            String codigo= request.getParameter("codigo");
            qf.EliminarFactura(Integer.parseInt(codigo));
        }else if(comando.equalsIgnoreCase("ingresar")){
            destino = INGRESAR_FACTURA;
        } else if (comando.equalsIgnoreCase("nuevo")) {
            destino = LISTAR_FACTURA;
            String di = request.getParameter("id");
            String cantidad = request.getParameter("cantidad");
            String fecha_transaccion = request.getParameter("fecha_transacion");
            String id_compra_venta = request.getParameter("id_compra_venta");
            int id = Integer.parseInt(di);
            int c = Integer.parseInt(cantidad);
            LocalDate f= LocalDate.parse(fecha_transaccion);
            int icv = Integer.parseInt(id_compra_venta);
            Factura factura = new Factura(id, c, f, icv);
            qf.InsertarFactura(factura);
        } else if (comando.equalsIgnoreCase("editar")) {
            destino = MODIFICAR_FACTURA;
            request.getSession().setAttribute("codigo_factura", request.getParameter("codigo"));
        } else if (comando.equalsIgnoreCase("modificar")) {
            destino = LISTAR_FACTURA;
            request.getSession().getAttribute("codigo_factura");
            String v;
            v = (String) request.getSession().getAttribute("codigo_factura");
            int codigo = Integer.parseInt(v);
             String cantidad = request.getParameter("cantidad");
            String fecha_transaccion = request.getParameter("fecha_transacion");
            String id_compra_venta = request.getParameter("id_compra_venta");
            int c = Integer.parseInt(cantidad);
            LocalDate f= LocalDate.parse(fecha_transaccion);
            int icv = Integer.parseInt(id_compra_venta);
            Factura factura=new Factura(codigo, c, f, icv);
            qf.ModificarFactura(factura);
        }
        RequestDispatcher requestDispatcher=request.getRequestDispatcher(destino);
        requestDispatcher.forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
