<%-- 
    Document   : EnsambladorListar
    Created on : Aug 26, 2021, 10:24:42 PM
    Author     : Massielle Coti
--%>

<%@page import="TipoPieza.TipoPieza"%>
<%@page import="TipoPieza.QueryTipoPieza"%>
<%@page import="Ensamblador.QueryEnsamblador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Ensamblador.Ensamblador"%>
<%@page import="Ensamblador.ModeloEnsamblador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipo Pieza Listar</title>
    </head>
    <body>
        <div class="d-flex justify-content-center">
            <div class="card">
                <div class="card-body">
                    <table border="1", class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id Tipo Pieza</th>
                                <th>Nombre</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <%
                            QueryTipoPieza e = new QueryTipoPieza();
                            ArrayList<TipoPieza> tps = e.ListarTipoPieza();
                            for (int i = 0; i < tps.size(); i++) {
                                TipoPieza temporal = tps.get(i);
                        %>
                        <tbody>

                            <tr>
                                <td><%=temporal.getId_tipo_pieza() %></td>
                                <td><%=temporal.getNombre()%></td>
                                <td><a href="TipoPiezaServlet?comando=editar&codigo=<%=temporal.getId_tipo_pieza() %>" class="btn btn-info">editar</a></td>
                                <td><a href="TipoPiezaServlet?comando=eliminar&codigo=<%=temporal.getId_tipo_pieza()%>">eliminar</a></td>
                            </tr>
                        </tbody>
                        <%}%>
                    </table>
                </div>
            </div>
        </div>
        <a href="TipoPiezaServlet?comando=ingresar" class="btn btn-primary">insertar</a>
    </body>
</html>
