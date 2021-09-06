<%-- 
    Document   : EnsambladorEditar
    Created on : Aug 30, 2021, 4:29:59 PM
    Author     : Massielle Coti
--%>

<%@page import="Ensamblador.Ensamblador"%>
<%@page import="Ensamblador.QueryEnsamblador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Ensamblador</h1>
        <%
            QueryEnsamblador qe = new QueryEnsamblador();
            String v;
            v = (String) request.getSession().getAttribute("codigo_ensamblador");
            int codigo = Integer.parseInt(v);
            Ensamblador ensamblador = qe.SeleccionarUno(codigo);
        %>
        <form action="EnsambladorServlet">
           <label>Nombre</label><br>
           <input type="text" name="nombre" value="<%=ensamblador.getNombre() %>"><br>
           <label>Apellido</label><br>
           <input type="text" name="apellido" value="<%=ensamblador.getApellido()%>"><br>
           <input type="submit" name="comando" value="modificar">
        </form>
    </body>
</html>
