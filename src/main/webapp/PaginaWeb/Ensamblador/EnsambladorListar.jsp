<%-- 
    Document   : EnsambladorListar
    Created on : Aug 26, 2021, 10:24:42 PM
    Author     : Massielle Coti
--%>

<%@page import="Ensamblador.QueryEnsamblador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Ensamblador.Ensamblador"%>
<%@page import="Ensamblador.ModeloEnsamblador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ensamblador Listar</title>
    </head>
    <body>
        <div class="d-flex justify-content-center">
            <div class="card">
                <div class="card-body">
                    <table border="1", class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id_Ensamblador</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <%
                            QueryEnsamblador e = new QueryEnsamblador();
                            ArrayList<Ensamblador> ensambladores = e.ListarEnsamblador();
                            for (int i = 0; i < ensambladores.size(); i++) {
                                Ensamblador temporal = ensambladores.get(i);
                        %>
                        <tbody>

                            <tr>
                                <td><%=temporal.getIdEnsamblador()%></td>
                                <td><%=temporal.getNombre()%></td>
                                <td><%=temporal.getApellido()%></td>
                                <td><a href="EnsambladorServlet?comando=editar&codigo=<%=temporal.getIdEnsamblador()%>" class="btn btn-info">editar</a></td>
                                <td><a href="EnsambladorServlet?comando=eliminar&codigo=<%=temporal.getIdEnsamblador()%>">eliminar</a></td>
                            </tr>
                        </tbody>
                        <%}%>
                    </table>
                </div>
            </div>
        </div>
        <a href="EnsambladorServlet?comando=ingresar" class="btn btn-primary">insertar</a>
    </body>
</html>
