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
        <title>Usuario Ingresar</title>
    </head>
    <body>
        <h1>Ingresar Usuario</h1>
        <form action="UsuarioServlet">
            <label>Nombre</label><br>
           <input type="text" name="nombre"><br>
           <label>Password</label><br>
           <input type="text" name="password"><br>
           <label>Tipo</label><br>
           <input type="text" name="tipo"><br>

           
           <input type="submit" name="comando" value="nuevo">
        </form>
    </body>
</html>
