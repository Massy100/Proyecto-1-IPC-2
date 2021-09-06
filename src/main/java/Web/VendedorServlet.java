/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Vendedor.QueryVendedor;
import Vendedor.Vendedor;
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
public class VendedorServlet extends HttpServlet {
private final String LISTAR_VENDEDOR = "PaginaWeb/Vendedor/VendedorListar.jsp";
    private final String INGRESAR_VENDEDOR = "PaginaWeb/Vendedor/VendedorIngresar.jsp";
    private final String MODIFICAR_VENDEDOR = "PaginaWeb/Vendedor/VendedorEditar.jsp";

    QueryVendedor qe = new QueryVendedor();
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         String destino = "";
            String comando = request.getParameter("comando");

        if (comando.equals("listar")) {
            destino=LISTAR_VENDEDOR;
        }else if(comando.equalsIgnoreCase("eliminar")){
            destino=LISTAR_VENDEDOR;
            String codigo= request.getParameter("codigo");
            qe.EliminarVendedor(Integer.parseInt(codigo));
        }else if(comando.equalsIgnoreCase("ingresar")){
            destino = INGRESAR_VENDEDOR;
        } else if (comando.equalsIgnoreCase("nuevo")) {
            destino = LISTAR_VENDEDOR;
            String di = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String id_compra_venta = request.getParameter("id_compra_venta");
            int id = Integer.parseInt(di);
             int idcv = Integer.parseInt(id_compra_venta);
            Vendedor vendedor = new Vendedor(id, nombre, apellido, idcv);
            qe.InsertarVendedor(vendedor);
        } else if (comando.equalsIgnoreCase("editar")) {
            destino = MODIFICAR_VENDEDOR;
            request.getSession().setAttribute("codigo_vendedor", request.getParameter("codigo"));
        } else if (comando.equalsIgnoreCase("modificar")) {
            destino = LISTAR_VENDEDOR;
            request.getSession().getAttribute("codigo_vendedor");
            String v;
            v = (String) request.getSession().getAttribute("codigo_vendedor");
            int codigo = Integer.parseInt(v);
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String id_compra_venta= request.getParameter("id_compra_venta");
               int idcv = Integer.parseInt(id_compra_venta);
            Vendedor vendedor=new Vendedor(codigo, nombre, apellido, idcv);
            qe.ModificarVendedor(vendedor);
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
