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
        <title>Mueble Ingresar</title>
    </head>
    <body>
        <h1>Ingresar Mueble</h1>
        <form action="MuebleServlet">
            <label>Id</label><br>
           <input type="text" name="id"><br>
           <label>Nombre</label><br>
           <input type="text" name="nombre"><br>
           <label>Precio final</label><br>
           <input type="text" name="precio_final"><br>
           <label>Cantidad</label><br>
           <input type="text" name="cantidad"><br>
           <label>Fecha Ensamblado</label><br>
           <input type="text" name="fecha_ensamblado"><br>
           
           <input type="submit" name="comando" value="nuevo">
        </form>
    </body>
</html>
