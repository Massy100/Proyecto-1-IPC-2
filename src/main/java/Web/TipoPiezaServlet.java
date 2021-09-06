/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Ensamblador.Ensamblador;
import TipoPieza.QueryTipoPieza;
import TipoPieza.TipoPieza;
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
public class TipoPiezaServlet extends HttpServlet {

   private final String LISTAR_TIPO_PIEZA = "PaginaWeb/TipoPieza/TipoPiezaListar.jsp";
    private final String INGRESAR_TIPO_PIEZA = "PaginaWeb/TipoPieza/TipoPiezaIngresar.jsp";
    private final String MODIFICAR_TIPO_PIEZA= "PaginaWeb/TipoPieza/TipoPiezaEditar.jsp";

    QueryTipoPieza qtp = new QueryTipoPieza();
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
            destino=LISTAR_TIPO_PIEZA;
        }else if(comando.equalsIgnoreCase("eliminar")){
            destino=LISTAR_TIPO_PIEZA;
            String codigo= request.getParameter("codigo");
            qtp.EliminarTipoPieza(Integer.parseInt(codigo));
        }else if(comando.equalsIgnoreCase("ingresar")){
            destino = INGRESAR_TIPO_PIEZA;
        } else if (comando.equalsIgnoreCase("nuevo")) {
            destino = LISTAR_TIPO_PIEZA;
            String di = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            int id = Integer.parseInt(di);
            TipoPieza tp=new TipoPieza(id, nombre);
           qtp.InsertarTipoPieza(tp);
        } else if (comando.equalsIgnoreCase("editar")) {
            destino = MODIFICAR_TIPO_PIEZA;
            request.getSession().setAttribute("codigo_tipo_pieza", request.getParameter("codigo"));
        } else if (comando.equalsIgnoreCase("modificar")) {
            destino = LISTAR_TIPO_PIEZA;
            request.getSession().getAttribute("codigo_tipo_pieza");
            String v;
            v = (String) request.getSession().getAttribute("codigo_tipo_pieza");
            int codigo = Integer.parseInt(v);
            String nombre = request.getParameter("nombre");
            TipoPieza tp=new TipoPieza(codigo, nombre);
            qtp.ModificarTipoPieza(tp);
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
