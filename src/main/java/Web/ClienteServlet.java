/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Cliente.Cliente;
import Cliente.QueryCliente;
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
public class ClienteServlet extends HttpServlet {

    
    private final String LISTAR_CLIENTE = "PaginaWeb/Cliente/ClienteListar.jsp";
    private final String INGRESAR_CLIENTE= "PaginaWeb/Cliente/EnsambladorIngresar.jsp";
    private final String MODIFICAR_CLIENTE = "PaginaWeb/Cliente/EnsambladorEditar.jsp";

    QueryCliente qe = new QueryCliente();

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String destino = "";
            String comando = request.getParameter("comando");

        if (comando.equals("listar")) {
            destino=LISTAR_CLIENTE;
        }else if(comando.equalsIgnoreCase("eliminar")){
            destino=LISTAR_CLIENTE;
            String codigo= request.getParameter("codigo");
            qe.EliminarCliente(Integer.parseInt(codigo));
        }else if(comando.equalsIgnoreCase("ingresar")){
            destino = INGRESAR_CLIENTE;
        } else if (comando.equalsIgnoreCase("nuevo")) {
            destino = LISTAR_CLIENTE;
            String di = request.getParameter("id");
            String direccion = request.getParameter("direccion");
            String nit = request.getParameter("nit");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String departamento = request.getParameter("departamento");
            String municipio = request.getParameter("municipio");
            String id_compra_venta = request.getParameter("id_compra_venta");
             int idcv = Integer.parseInt(id_compra_venta);
            int id = Integer.parseInt(di);
            Cliente ensamblador = new Cliente(id, direccion, nit, nombre, apellido, departamento, municipio, idcv);
            qe.InsertarCliente(ensamblador);
        } else if (comando.equalsIgnoreCase("editar")) {
            destino = MODIFICAR_CLIENTE;
            request.getSession().setAttribute("codigo_ensamblador", request.getParameter("codigo"));
        } else if (comando.equalsIgnoreCase("modificar")) {
            destino = LISTAR_CLIENTE;
            request.getSession().getAttribute("codigo_ensamblador");
            String v;
            v = (String) request.getSession().getAttribute("codigo_ensamblador");
            int codigo = Integer.parseInt(v);
            String direccion = request.getParameter("direccion");
            String nit = request.getParameter("nit");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
             String departamento = request.getParameter("departamento");
            String municipio = request.getParameter("municipio");
            String id_compra_venta = request.getParameter("id_compra_venta");
            int idcv = Integer.parseInt(id_compra_venta);
            Cliente ensamblador=new Cliente(codigo, direccion, nit, nombre, apellido, departamento, municipio, idcv);
            qe.ModificarCliente(ensamblador);
        }
        RequestDispatcher requestDispatcher=request.getRequestDispatcher(destino);
        requestDispatcher.forward(request, response);
    }

  
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
