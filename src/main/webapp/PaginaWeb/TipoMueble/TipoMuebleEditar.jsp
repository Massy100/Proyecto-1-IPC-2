<%-- 
    Document   : EnsambladorEditar
    Created on : Aug 30, 2021, 4:29:59 PM
    Author     : Massielle Coti
--%>

<%@page import="TipoMueble.TipoMueble"%>
<%@page import="MuebleEnsamblado.Mueble"%>
<%@page import="TipoMueble.QueryTipoMueble"%>
<%@page import="TipoPieza.TipoPieza"%>
<%@page import="TipoPieza.QueryTipoPieza"%>
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
        <h1>Editar Tipo Mueble</h1>
        <%
            QueryTipoMueble qtm = new QueryTipoMueble();
            String v;
            v = (String) request.getSession().getAttribute("codigo_tipo_mueble");
            int codigo = Integer.parseInt(v);
            TipoMueble tm = qtm.SeleccionarUno(codigo);
        %>
        <form action="TipoMuebleServlet">
           <label>Nombre</label><br>
           <input type="text" name="nombre" value="<%=tm.getNombre() %>"><br>
           <input type="submit" name="comando" value="modificar">
        </form>
    </body>
</html>
