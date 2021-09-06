<%-- 
    Document   : PiezaIngresar
    Created on : Sep 3, 2021, 4:02:38 PM
    Author     : Massielle Coti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Ingresar Pieza</h1>
        <form action="PiezaServlet">
            <label>Id</label><br>
           <input type="text" name="id"><br>
           <label>Nombre</label><br>
           <input type="text" name="nombre"><br>
           <label>Precio</label><br>
           <input type="text" name="precio"><br>
           <label>Cantidad ingreso</label><br>
           <input type="text" name="cantidad_ingreso"><br>
           <label>Id tipo pieza</label><br>
           <input type="text" name="id_tipo_pieza"><br>
           <label>Id mueble</label><br>
           <input type="text" name="id_mueble"><br>
           
           <input type="submit" name="comando" value="nuevo">
        </form>
    </body>
</html>
