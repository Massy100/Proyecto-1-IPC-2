/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import MuebleEnsamblado.Mueble;
import MuebleEnsamblado.QueryMueble;
import java.io.IOException;
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
public class MuebleServlet extends HttpServlet {
    private final String LISTAR_MUEBLE = "PaginaWeb/MuebleEnsamblado/MuebleEnsambladoListar.jsp";
    private final String INGRESAR_MUEBLE = "PaginaWeb/MuebleEnsamblado/MuebleEnsambladoIngresar.jsp";
    private final String MODIFICAR_MUEBLE = "PaginaWeb/MuebleEnsamblado/MuebleEnsambladoEditar.jsp";

    QueryMueble qm = new QueryMueble();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       String destino = "";
            String comando = request.getParameter("comando");

        if (comando.equals("listar")) {
            destino=LISTAR_MUEBLE;
        }else if(comando.equalsIgnoreCase("eliminar")){
            destino=LISTAR_MUEBLE;
            String codigo= request.getParameter("codigo");
            qm.EliminarMueble(Integer.parseInt(codigo));
        }else if(comando.equalsIgnoreCase("ingresar")){
            destino = INGRESAR_MUEBLE;
        } else if (comando.equalsIgnoreCase("nuevo")) {
            
            destino = LISTAR_MUEBLE;
            String di = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String precio = request.getParameter("precio");
            String cantidad = request.getParameter("cantidad");
            String fecha =request.getParameter("fecha_ensamblado");
            int id = Integer.parseInt(di);
            double p = Double.parseDouble(precio);
            int c = Integer.parseInt(cantidad); 
             LocalDate f= LocalDate.parse(fecha);
           Mueble mueble = new Mueble(id, nombre, p,c, f);
            qm.InsertarMueble(mueble);
        } else if (comando.equalsIgnoreCase("editar")) {
            destino = MODIFICAR_MUEBLE;
            request.getSession().setAttribute("codigo_mueble", request.getParameter("codigo"));
        } else if (comando.equalsIgnoreCase("modificar")) {
            destino = LISTAR_MUEBLE;
            request.getSession().getAttribute("codigo_mueble");
            String v;
            v = (String) request.getSession().getAttribute("codigo_mueble");
            int codigo = Integer.parseInt(v);
            String nombre = request.getParameter("nombre");
            String precio = request.getParameter("precio");
              String cantidad = request.getParameter("cantidad");
            String fecha = request.getParameter("fecha_ensamblado");
            double p = Double.parseDouble(precio);
            int c = Integer.parseInt(cantidad);
               LocalDate f= LocalDate.parse(fecha);
           Mueble mueble = new Mueble(codigo, nombre, p,c, f);
            qm.ModificarMueble(mueble);
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
