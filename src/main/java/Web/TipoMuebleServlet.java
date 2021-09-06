/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Ensamblador.Ensamblador;
import TipoMueble.QueryTipoMueble;
import TipoMueble.TipoMueble;
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
public class TipoMuebleServlet extends HttpServlet {

    private final String LISTAR_TIPO_MUEBLE = "PaginaWeb/TipoMueble/TipoMuebleListar.jsp";
    private final String INGRESAR_TIPO_MUEBLE = "PaginaWeb/TipoMueble/TipoMuebleIngresar.jsp";
    private final String MODIFICAR_TIPO_MUEBLE = "PaginaWeb/TipoMueble/TipoMuebleEditar.jsp";

    QueryTipoMueble qtm = new QueryTipoMueble();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String destino = "";
            String comando = request.getParameter("comando");

        if (comando.equals("listar")) {
            destino=LISTAR_TIPO_MUEBLE;
        }else if(comando.equalsIgnoreCase("eliminar")){
            destino=LISTAR_TIPO_MUEBLE;
            String codigo= request.getParameter("codigo");
            qtm.EliminarTipoMueble(Integer.parseInt(codigo));
        }else if(comando.equalsIgnoreCase("ingresar")){
            destino = INGRESAR_TIPO_MUEBLE;
        } else if (comando.equalsIgnoreCase("nuevo")) {
            destino = LISTAR_TIPO_MUEBLE;
            String di = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            int id = Integer.parseInt(di);
            TipoMueble tm = new TipoMueble(id, nombre);
            qtm.InsertarTipoMueble(tm);
        } else if (comando.equalsIgnoreCase("editar")) {
            destino = MODIFICAR_TIPO_MUEBLE;
            request.getSession().setAttribute("codigo_tipo_mueble", request.getParameter("codigo"));
        } else if (comando.equalsIgnoreCase("modificar")) {
            destino = LISTAR_TIPO_MUEBLE;
            request.getSession().getAttribute("codigo_tipo_mueble");
            String v;
            v = (String) request.getSession().getAttribute("codigo_tipo_mueble");
            int codigo = Integer.parseInt(v);
            String nombre = request.getParameter("nombre");
            TipoMueble tm=new TipoMueble(codigo, nombre);
            qtm.ModificarTipoMueble(tm);
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
