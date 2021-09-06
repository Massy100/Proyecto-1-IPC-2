/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Usuario.QueryUsuario;
import Usuario.Usuario;
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
public class UsuarioServlet extends HttpServlet {


      private final String LISTAR_USUARIO = "PaginaWeb/Usuario/UsuarioListar.jsp";
    private final String INGRESAR_USUARIO = "PaginaWeb/Usuario/UsuarioIngresar.jsp";
    private final String MODIFICAR_USUARIO = "PaginaWeb/Usuario/UsuarioEditar.jsp";

    QueryUsuario qe = new QueryUsuario();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
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
       String destino = "";
            String comando = request.getParameter("comando");

        if (comando.equals("listar")) {
            destino=LISTAR_USUARIO;
        }else if(comando.equalsIgnoreCase("eliminar")){
            destino=LISTAR_USUARIO;
            String codigo= request.getParameter("codigo");
            qe.EliminarUsuario(codigo);
        }else if(comando.equalsIgnoreCase("ingresar")){
            destino = INGRESAR_USUARIO;
        } else if (comando.equalsIgnoreCase("nuevo")) {
            destino = LISTAR_USUARIO;
            String nombre = request.getParameter("nombre");
            String password = request.getParameter("password");
            String tipo = request.getParameter("tipo");
            int t = Integer.parseInt(tipo);
            Usuario usuario = new Usuario(nombre, password, t);
            qe.InsertarUsuario(usuario);
        } else if (comando.equalsIgnoreCase("editar")) {
            destino = MODIFICAR_USUARIO;
            request.getSession().setAttribute("codigo_usuario", request.getParameter("codigo"));
        } else if (comando.equalsIgnoreCase("modificar")) {
            destino = LISTAR_USUARIO;
            request.getSession().getAttribute("codigo_usuario");
            String v;
            v = (String) request.getSession().getAttribute("codigo_usuario");
            int tipo = Integer.parseInt(v);
            String nombre = request.getParameter("nombre");
            String password = request.getParameter("password");
            Usuario usuario=new Usuario(nombre, password, tipo);
           qe.ModificarUsuario(usuario);
        }
        RequestDispatcher requestDispatcher=request.getRequestDispatcher(destino);
        requestDispatcher.forward(request, response);
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
