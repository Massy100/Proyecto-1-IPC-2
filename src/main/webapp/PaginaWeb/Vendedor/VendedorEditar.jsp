<%-- 
    Document   : EnsambladorEditar
    Created on : Aug 30, 2021, 4:29:59 PM
    Author     : Massielle Coti
--%>

<%@page import="Vendedor.Vendedor"%>
<%@page import="Vendedor.QueryVendedor"%>
<%@page import="Usuario.Usuario"%>
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
        <h1>Editar Vendedor</h1>
        <%
            QueryVendedor qv = new QueryVendedor();
            String v;
            v = (String) request.getSession().getAttribute("codigo_vendedor");
           int codigo = Integer.parseInt(v);
            Vendedor vendedor = qv.SeleccionarUnoVendedor(codigo);
        %>
        <form action="VendedorServlet">
           <label>Nombre</label><br>
           <input type="text" name="nombre" value="<%=vendedor.getNombre()  %>"><br>
           <label>Apellido</label><br>
           <input type="text" name="apellido" value="<%=vendedor.getApellido()   %>"><br>
           <label>Id Compra Venta</label><br>
           <input type="text" name="id_compra_venta" value="<%=vendedor.getId_compra_venta()  %>"><br>
           <input type="submit" name="comando" value="modificar">
        </form>
    </body>
</html>
