<%-- 
    Document   : EnsambladorEditar
    Created on : Aug 30, 2021, 4:29:59 PM
    Author     : Massielle Coti
--%>

<%@page import="Usuario.Usuario"%>
<%@page import="Usuario.QueryUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Usuario</h1>
        <%
            QueryUsuario qu = new QueryUsuario();
            String v;

            v = (String) request.getSession().getAttribute("codigo_usuario");
            Usuario usuario = qu.SeleccionarUnoUsuario(v);
        %>

        <form action="UsuarioServlet"
           <label>Password final</label><br>
           <input type="text" name="password" value="<%=usuario.getPassword() %>"><br>
            <label>Tipo</label><br>
           <input type="text" name="tipo" value="<%=usuario.getTipo() %>"><br>
           <input type="submit" name="comando" value="modificar">
        </form>
        
    </body>
</html>
