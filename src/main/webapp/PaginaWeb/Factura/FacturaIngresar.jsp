<%-- 
    Document   : EnsambladorIngresar
    Created on : Aug 26, 2021, 10:24:11 PM
    Author     : Massielle Coti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factura Ingresar</title>
    </head>
    <body>
        <h1>Factura Mueble</h1>
        <form action="FacturaServlet">
            <label>Id</label><br>
           <input type="text" name="id"><br>
           <label>Cantidad</label><br>
           <input type="text" name="cantidad"><br>
           <label>Fecha Transaccion</label><br>
           <input type="text" name="fecha_transaccion"><br>
           <label>Id Compra Venta</label><br>
           <input type="text" name="id_compra_venta"><br>
           
           <input type="submit" name="comando" value="nuevo">
        </form>
    </body>
</html>
