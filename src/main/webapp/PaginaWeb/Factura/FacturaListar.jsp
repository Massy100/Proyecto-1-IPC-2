<%-- 
    Document   : EnsambladorListar
    Created on : Aug 26, 2021, 10:24:42 PM
    Author     : Massielle Coti
--%>

<%@page import="Factura.Factura"%>
<%@page import="Factura.QueryFactura"%>
<%@page import="java.sql.*"%>
<%@page import="Conexion.Conectar"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factura Listar</title>
    </head>
    <body>
        <div class="d-flex justify-content-center">
            <div class="card">
                <div class="card-body">
                    <table border="1", class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id Factura</th>
                                <th>Cantidad</th>
                                <th>Fecha Transaccion</th>
                                <th>Id Compra Venta</th>
                            </tr>
                        </thead>
                        
                        <%
                            QueryFactura e = new QueryFactura();
                            ArrayList<Factura> facturas = e.ListarFactura();
                            for (int i = 0; i < facturas.size(); i++) {
                                Factura temporal = facturas.get(i);
                        %>
                        
                        <tbody>
                            
                            <tr>
                                
                                <td><%=temporal.getId_factura() %></td>
                                <td><%=temporal.getCantidad() %></td>
                                <td><%=temporal.getFecha_transaccion() %></td>
                                <td><%=temporal.getId_compra_venta() %></td>
                                <td><a href="FacturaServlet?comando=editar&codigo=<%=temporal.getId_factura() %>" class="btn btn-info">editar</a></td>
                                <td><a href="FacturaServlet?comando=eliminar&codigo=<%=temporal.getId_factura() %>">eliminar</a></td>
                                <!--
                                -->
                            </tr>
                            
                        </tbody>
                        <%}%>
                    </table>
                </div>
            </div>
        </div>
        <a href="FacturaServlet?comando=ingresar" class="btn btn-primary">insertar</a>
    </body>
</html>
