<%-- 
    Document   : EnsambladorListar
    Created on : Aug 26, 2021, 10:24:42 PM
    Author     : Massielle Coti
--%>

<%@page import="CompraVenta.CompraVenta"%>
<%@page import="CompraVenta.QueryCompraVenta"%>
<%@page import="Ensamblador.QueryEnsamblador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Ensamblador.Ensamblador"%>
<%@page import="Ensamblador.ModeloEnsamblador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra Venta Listar</title>
    </head>
    <body>
        <div class="d-flex justify-content-center">
            <div class="card">
                <div class="card-body">
                    <table border="1", class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id Compra Venta</th>
                                <th>Precio</th>
                                <th>Id Mueble</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <%
                            QueryCompraVenta e = new QueryCompraVenta();
                            ArrayList<CompraVenta> cvs = e.ListarCompraVenta();
                            for (int i = 0; i < cvs.size(); i++) {
                                CompraVenta temporal = cvs.get(i);
                        %>
                        <tbody>

                            <tr>
                                <td><%=temporal.getId_compra_venta() %></td>
                                <td><%=temporal.getPrecio() %></td>
                                <td><%=temporal.getId_mueble() %></td>
                                <td><a href="CompraVentaServlet?comando=editar&codigo=<%=temporal.getId_compra_venta() %>" class="btn btn-info">editar</a></td>
                                <td><a href="CompraVentaServlet?comando=eliminar&codigo=<%=temporal.getId_compra_venta() %>">eliminar</a></td>
                            </tr>
                        </tbody>
                        <%}%>
                    </table>
                </div>
            </div>
        </div>
        <a href="CompraVentaServlet?comando=ingresar" class="btn btn-primary">insertar</a>
    </body>
</html>
