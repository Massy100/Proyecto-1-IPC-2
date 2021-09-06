<%-- 
    Document   : PiezaListar
    Created on : Sep 3, 2021, 4:02:54 PM
    Author     : Massielle Coti
--%>

<%@page import="java.util.ArrayList"%>
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
       <div class="d-flex justify-content-center">
            <div class="card">
                <div class="card-body">
                    <table border="1", class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id Pieza</th>
                                <th>Nombre</th>
                                <th>Precio</th>
                                <th>Cantidad Ingreso</th>
                                <th>Id tipo pieza</th>
                                <th>Id mueble</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <%
                            QueryPieza e = new QueryPieza();
                            ArrayList<Pieza> piezas = e.ListarPieza();
                            for (int i = 0; i < piezas.size(); i++) {
                                Pieza temporal = piezas.get(i);
                        %>
                        <tbody>

                            <tr>
                                <td><%=temporal.getId_pieza() %></td>
                                <td><%=temporal.getNombre()%></td>
                                <td><%=temporal.getPrecio() %></td>
                                <td><%=temporal.getCantidad_ingreso() %></td>
                                <td><%=temporal.getId_tipo_pieza() %></td>
                                <td><%=temporal.getId_mueble() %></td>
                                <td><a href="PiezaServlet?comando=editar&codigo=<%=temporal.getId_pieza() %>" class="btn btn-info">editar</a></td>
                                <td><a href="PiezaServlet?comando=eliminar&codigo=<%=temporal.getId_pieza() %>">eliminar</a></td>
                            </tr>
                        </tbody>
                        <%}%>
                    </table>
                </div>
            </div>
        </div>
        <a href="PiezaServlet?comando=ingresar" class="btn btn-primary">insertar</a>
    </body>
</html>
