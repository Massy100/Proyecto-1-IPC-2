/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Pieza.Pieza;
import Pieza.QueryPieza;
import TipoPieza.TipoPieza;
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
public class PiezaServlet extends HttpServlet {

     private final String LISTAR_PIEZA = "PaginaWeb/Pieza/PiezaListar.jsp";
    private final String INGRESAR_PIEZA = "PaginaWeb/Pieza/PiezaIngresar.jsp";
    private final String MODIFICAR_PIEZA= "PaginaWeb/Pieza/PiezaEditar.jsp";

    QueryPieza qp = new QueryPieza();
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String destino = "";
            String comando = request.getParameter("comando");

        if (comando.equals("listar")) {
            destino=LISTAR_PIEZA;
        }else if(comando.equalsIgnoreCase("eliminar")){
            destino=LISTAR_PIEZA;
            String codigo= request.getParameter("codigo");
            qp.EliminarPieza(Integer.parseInt(codigo));
        }else if(comando.equalsIgnoreCase("ingresar")){
            destino = INGRESAR_PIEZA;
        } else if (comando.equalsIgnoreCase("nuevo")) {
            destino = LISTAR_PIEZA;
            String di = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String precio=request.getParameter("precio");
           String fecha=request.getParameter("fecha_ingreso");
           String cantidad=request.getParameter("cantidad_ingreso");
           String id_tipo_pieza =request.getParameter("id_tipo_pieza");
           String id_mueble=request.getParameter("id_mueble");
            int id = Integer.parseInt(di);
            double p=Double.parseDouble(precio);
             LocalDate f= LocalDate.parse(fecha);
            int c = Integer.parseInt(cantidad);
            int itp = Integer.parseInt(id_tipo_pieza);
            int idm = Integer.parseInt(id_mueble);
            Pieza pieza=new Pieza(id, nombre,p,f,c,itp,idm);
          qp.InsertarPieza(pieza);
        } else if (comando.equalsIgnoreCase("editar")) {
            destino = MODIFICAR_PIEZA;
            request.getSession().setAttribute("codigo_tipo_pieza", request.getParameter("codigo"));
        } else if (comando.equalsIgnoreCase("modificar")) {
            destino = LISTAR_PIEZA;
            request.getSession().getAttribute("codigo_pieza");
            String v;
            v = (String) request.getSession().getAttribute("codigo_pieza");
            int id = Integer.parseInt(v);
            String nombre = request.getParameter("nombre");
            String precio=request.getParameter("precio");
           String fecha=request.getParameter("fecha_ingreso");
           String cantidad=request.getParameter("cantidad_ingreso");
           String id_tipo_pieza =request.getParameter("id_tipo_pieza");
           String id_mueble=request.getParameter("id_mueble");
            double p=Double.parseDouble(precio);
            LocalDate f=LocalDate.parse(fecha);
            int c = Integer.parseInt(cantidad);
            int itp = Integer.parseInt(id_tipo_pieza);
            int idm = Integer.parseInt(id_mueble);
            Pieza pieza=new Pieza(id, nombre,p,f,c,itp,idm);
          qp.ModificarPieza(pieza);
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
