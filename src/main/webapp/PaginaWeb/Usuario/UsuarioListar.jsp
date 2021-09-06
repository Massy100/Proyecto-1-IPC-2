<%-- 
    Document   : EnsambladorListar
    Created on : Aug 26, 2021, 10:24:42 PM
    Author     : Massielle Coti
--%>

<%@page import="Usuario.Usuario"%>
<%@page import="Usuario.QueryUsuario"%>
<%@page import="java.sql.*"%>
<%@page import="Conexion.Conectar"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mueble Ensamblado Listar</title>
    </head>
    <body>
        <div class="d-flex justify-content-center">
            <div class="card">
                <div class="card-body">
                    <table border="1", class="table table-striped">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Password</th>
                                <th>Tipo</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        
                        <%
                            QueryUsuario e = new QueryUsuario();
                            ArrayList<Usuario> usuarios = e.ListarUsuario();
                            for (int i = 0; i < usuarios.size(); i++) {
                                Usuario temporal = usuarios.get(i);
                        %>
                        
                        <tbody>
                            
                            <tr>
                                
                               
                                <td><%=temporal.getNombre()%></td>
                                <td><%=temporal.getPassword() %></td>
                                <td><%=temporal.getTipo() %></td>
                                <td><a href="UsuarioServlet?comando=editar&codigo=<%=temporal.getNombre()%>" class="btn btn-info">editar</a></td>
                                <td><a href="UsuarioServlet?comando=eliminar&codigo=<%=temporal.getNombre()%>">eliminar</a></td>
                                <!--
                                -->
                            </tr>
                            
                        </tbody>
                        <%}%>
                    </table>
                </div>
            </div>
        </div>
        <a href="UsuarioServlet?comando=ingresar" class="btn btn-primary">insertar</a>
    </body>
</html>
