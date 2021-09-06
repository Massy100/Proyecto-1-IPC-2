/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Conexion.Conectar;
import Ensamblador.Ensamblador;
import Ensamblador.QueryEnsamblador;
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
public class EnsambladorServlet extends HttpServlet {
    

    private final String LISTAR_ENSAMBLADOR = "PaginaWeb/Ensamblador/EnsambladorListar.jsp";
    private final String INGRESAR_ENSAMBLADOR = "PaginaWeb/Ensamblador/EnsambladorIngresar.jsp";
    private final String MODIFICAR_ENSAMBLADOR = "PaginaWeb/Ensamblador/EnsambladorEditar.jsp";

    QueryEnsamblador qe = new QueryEnsamblador();

 
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
            destino=LISTAR_ENSAMBLADOR;
        }else if(comando.equalsIgnoreCase("eliminar")){
            destino=LISTAR_ENSAMBLADOR;
            String codigo= request.getParameter("codigo");
            qe.EliminarEnsamblador(Integer.parseInt(codigo));
        }else if(comando.equalsIgnoreCase("ingresar")){
            destino = INGRESAR_ENSAMBLADOR;
        } else if (comando.equalsIgnoreCase("nuevo")) {
            destino = LISTAR_ENSAMBLADOR;
            String di = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            int id = Integer.parseInt(di);
            Ensamblador ensamblador = new Ensamblador(id, nombre, apellido);
            qe.InsertarEnsamblador(ensamblador);
        } else if (comando.equalsIgnoreCase("editar")) {
            destino = MODIFICAR_ENSAMBLADOR;
            request.getSession().setAttribute("codigo_ensamblador", request.getParameter("codigo"));
        } else if (comando.equalsIgnoreCase("modificar")) {
            destino = LISTAR_ENSAMBLADOR;
            request.getSession().getAttribute("codigo_ensamblador");
            String v;
            v = (String) request.getSession().getAttribute("codigo_ensamblador");
            int codigo = Integer.parseInt(v);
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            Ensamblador ensamblador=new Ensamblador(codigo, nombre, apellido);
            qe.ModificarEnsamblador(ensamblador);
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
