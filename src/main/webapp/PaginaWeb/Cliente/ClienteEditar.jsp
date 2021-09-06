<%-- 
    Document   : EnsambladorEditar
    Created on : Aug 30, 2021, 4:29:59 PM
    Author     : Massielle Coti
--%>

<%@page import="Cliente.Cliente"%>
<%@page import="Cliente.QueryCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Cliente</h1>
        <%
            QueryCliente qc = new QueryCliente();
            String v;
            v = (String) request.getSession().getAttribute("codigo_cliente");
            int codigo = Integer.parseInt(v);
            Cliente cliente = qc.SeleccionarUnoCliente(codigo);
        %>
        <form action="ClienteServlet">
           <label>Direccion</label><br>
           <input type="text" name="direccion" value="<%=cliente.getDireccion() %>"><br>
           <label>Nit</label><br>
           <input type="text" name="nit" value="<%=cliente.getNit() %>"><br>
           <label>Nombre</label><br>
           <input type="text" name="nombre" value="<%=cliente.getNombre() %>"><br>
           <label>Apellido</label><br>
           <input type="text" name="apellido" value="<%=cliente.getApellido() %>"><br>
           <label>Id Compra Venta</label><br>
           <input type="text" name="id_compra_venta" value="<%=cliente.getId_compra_venta() %>"><br>
           <input type="submit" name="comando" value="modificar">
        </form>
    </body>
</html>
