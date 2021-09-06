<%-- 
    Document   : PiezaEditar
    Created on : Sep 3, 2021, 4:02:25 PM
    Author     : Massielle Coti
--%>

<%@page import="Pieza.Pieza"%>
<%@page import="Pieza.QueryPieza"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Pieza</h1>
        <%
            QueryPieza qp = new QueryPieza();
            String v;
            v = (String) request.getSession().getAttribute("codigo_pieza");
            int codigo = Integer.parseInt(v);
            Pieza pieza = qp.SeleccionarUnoPieza(codigo);
        %>
        <form action="PiezaServlet">
           <label>Nombre</label><br>
           <input type="text" name="nombre" value="<%=pieza.getNombre() %>"><br>
            <label>Precio</label><br>
           <input type="text" name="precio" value="<%=pieza.getPrecio() %>"><br>
           <label>Fecha ingreso</label><br>
           <input type="text" name="fecha_ingreso" value="<%=pieza.getFecha_ingreso() %>"><br>
            <label>Cantidad ingreso</label><br>
           <input type="text" name="cantidad_ingreso" value="<%=pieza.getCantidad_ingreso() %>"><br>
            <label>Id tipo pieza</label><br>
           <input type="text" name="id_tipo)pieza" value="<%=pieza.getId_pieza() %>"><br>
           <label>Id mueble</label><br>
           <input type="text" name="id_mueble" value="<%=pieza.getId_mueble() %>"><br>
           <input type="submit" name="comando" value="modificar">
        </form>
    </body>
</html>
