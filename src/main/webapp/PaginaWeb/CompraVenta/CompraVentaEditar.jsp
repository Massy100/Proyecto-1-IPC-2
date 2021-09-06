<%-- 
    Document   : EnsambladorEditar
    Created on : Aug 30, 2021, 4:29:59 PM
    Author     : Massielle Coti
--%>

<%@page import="CompraVenta.CompraVenta"%>
<%@page import="CompraVenta.QueryCompraVenta"%>
<%@page import="Ensamblador.Ensamblador"%>
<%@page import="Ensamblador.QueryEnsamblador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Compra Venta</h1>
        <%
            QueryCompraVenta qcv = new QueryCompraVenta();
            String v;
            v = (String) request.getSession().getAttribute("codigo_compra_venta");
            int codigo = Integer.parseInt(v);
            CompraVenta cv = qcv.SeleccionarUnoCompraVenta(codigo);
        %>
        <form action="EnsambladorServlet">
           <label>Precio</label><br>
           <input type="text" name="precio" value="<%=cv.getPrecio() %>"><br>
           <label>Id Mueble</label><br>
           <input type="text" name="id_mueble" value="<%=cv.getId_mueble() %>"><br>
           <input type="submit" name="comando" value="modificar">
        </form>
    </body>
</html>
