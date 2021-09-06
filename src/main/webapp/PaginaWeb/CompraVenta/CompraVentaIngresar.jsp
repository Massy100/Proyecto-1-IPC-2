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
        <title>Compra Venta Ingresar</title>
    </head>
    <body>
        <h1>Ingresar Compra Venta</h1>
        <form action="CompraVentaServlet">
            <label>Id</label><br>
           <input type="text" name="id"><br>
           <label>Precio</label><br>
           <input type="text" name="precio"><br>
           <label>Id Mueble</label><br>
           <input type="text" name="id_mueble"><br>
           <input type="submit" name="comando" value="nuevo">
        </form>
    </body>
</html>
