<%-- 
    Document   : EnsambladorListar
    Created on : Aug 26, 2021, 10:24:42 PM
    Author     : Massielle Coti
--%>

<%@page import="Vendedor.Vendedor"%>
<%@page import="Vendedor.QueryVendedor"%>
<%@page import="Ensamblador.QueryEnsamblador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Ensamblador.Ensamblador"%>
<%@page import="Ensamblador.ModeloEnsamblador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendedor Listar</title>
    </head>
    <body>
        <div class="d-flex justify-content-center">
            <div class="card">
                <div class="card-body">
                    <table border="1", class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id Vendedor</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Id Compra Venta</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <%
                            QueryVendedor e = new QueryVendedor();
                            ArrayList<Vendedor> vendedores = e.ListarVendedor();
                            for (int i = 0; i < vendedores.size(); i++) {
                                Vendedor temporal = vendedores.get(i);
                        %>
                        <tbody>

                            <tr>
                                
                                <td><%=temporal.getId_vendedor() %></td>
                                <td><%=temporal.getNombre()%></td>
                                <td><%=temporal.getApellido()%></td>
                                 <td><%=temporal.getId_compra_venta() %></td>
                                <td><a href="VendedorServlet?comando=editar&codigo=<%=temporal.getId_vendedor()%>" class="btn btn-info">editar</a></td>
                                <td><a href="VendedorServlet?comando=eliminar&codigo=<%=temporal.getId_vendedor()%>">eliminar</a></td>
                            </tr>
                        </tbody>
                        <%}%>
                    </table>
                </div>
            </div>
        </div>
        <a href="VendedorServlet?comando=ingresar" class="btn btn-primary">insertar</a>
    </body>
</html>
