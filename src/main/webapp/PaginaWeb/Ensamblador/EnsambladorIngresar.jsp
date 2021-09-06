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
        <title>Ensamblador Ingresar</title>
    </head>
    <body>
        <h1>Ingresar Ensamblador</h1>
        <form action="EnsambladorServlet">
            <label>Id</label><br>
           <input type="text" name="id"><br>
           <label>Nombre</label><br>
           <input type="text" name="nombre"><br>
           <label>Apellido</label><br>
           <input type="text" name="apellido"><br>
           <input type="submit" name="comando" value="nuevo">
        </form>
    </body>
</html>
