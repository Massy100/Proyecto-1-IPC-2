<%-- 
    Document   : EnsambladorEditar
    Created on : Aug 30, 2021, 4:29:59 PM
    Author     : Massielle Coti
--%>

<%@page import="Factura.Factura"%>
<%@page import="Factura.QueryFactura"%>
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
        <h1>Editar Factura</h1>
        <%
            QueryFactura qf = new QueryFactura();
            String v;

            v = (String) request.getSession().getAttribute("codigo_factura");
            int codigo = Integer.parseInt(v);
            Factura factura = qf.SeleccionarUnoFactura(codigo);
        %>

        <form action="FacturaServlet">
           <label>Cantidad</label><br>
           <input type="text" name="cantidad" value="<%=factura.getCantidad() %>"><br>
           <label>Fecha Transaccion</label><br>
           <input type="text" name="fecha_transaccion" value="<%=factura.getFecha_transaccion() %>"><br>
            <label>Id Compra Venta</label><br>
           <input type="text" name="id_compra_venta" value="<%=factura.getId_compra_venta() %>"><br>
           <input type="submit" name="comando" value="modificar">
        </form>
        
    </body>
</html>
