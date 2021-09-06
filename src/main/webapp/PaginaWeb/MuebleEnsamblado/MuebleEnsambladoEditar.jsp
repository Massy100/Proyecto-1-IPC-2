<%-- 
    Document   : EnsambladorEditar
    Created on : Aug 30, 2021, 4:29:59 PM
    Author     : Massielle Coti
--%>

<%@page import="MuebleEnsamblado.Mueble"%>
<%@page import="MuebleEnsamblado.QueryMueble"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Mueble Ensamblado</h1>
        <%
            QueryMueble qme = new QueryMueble();
            String v;

            v = (String) request.getSession().getAttribute("codigo_mueble");
            int codigo = Integer.parseInt(v);
            Mueble mueble = qme.SeleccionarUnoMueble(codigo);
        %>

        <form action="MuebleServlet">
           <label>Nombre</label><br>
           <input type="text" name="nombre" value="<%=mueble.getNombre() %>"><br>
           <label>Precio final</label><br>
           <input type="text" name="precio_final" value="<%=mueble.getPrecio_final() %>"><br>
            <label>Cantidad</label><br>
           <input type="text" name="cantidad" value="<%=mueble.getCantidad() %>"><br>
            <label>Fecha ensamblado</label><br>
           <input type="text" name="fecha_ensamblado" value="<%=mueble.getFecha_ensamblado() %>"><br>
           <input type="submit" name="comando" value="modificar">
        </form>
        
    </body>
</html>
