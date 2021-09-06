<%-- 
    Document   : EnsambladorListar
    Created on : Aug 26, 2021, 10:24:42 PM
    Author     : Massielle Coti
--%>

<%@page import="Cliente.Cliente"%>
<%@page import="Cliente.QueryCliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente Listar</title>
    </head>
    <body>
        <div class="d-flex justify-content-center">
            <div class="card">
                <div class="card-body">
                    <table border="1", class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id_Ensamblador</th>
                                <th>Direccion</th>
                                <th>Nit</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                 <th>Departamento</th>
                                 <th>Municipio</th>
                                <th>Id Compra Venta</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <%
                            QueryCliente e = new QueryCliente();
                            ArrayList<Cliente> clientes = e.ListarCliente();
                            for (int i = 0; i < clientes.size(); i++) {
                                Cliente temporal = clientes.get(i);
                        %>
                        <tbody>

                            <tr>
                                <td><%=temporal.getId_cliente() %></td>
                                <td><%=temporal.getDireccion()  %></td>
                                <td><%=temporal.getNit() %></td>
                                <td><%=temporal.getNombre()%></td>
                                <td><%=temporal.getApellido()%></td>
                                <td><%=temporal.getDepartamento() %></td>
                                <td><%=temporal.getMunicipio()%></td>
                                <td><a href="ClienteServlet?comando=editar&codigo=<%=temporal.getId_cliente() %>" class="btn btn-info">editar</a></td>
                                <td><a href="ClienteServlet?comando=eliminar&codigo=<%=temporal.getId_cliente() %>">eliminar</a></td>
                            </tr>
                        </tbody>
                        <%}%>
                    </table>
                </div>
            </div>
        </div>
        <a href="ClienteServlet?comando=ingresar" class="btn btn-primary">insertar</a>
    </body>
</html>
