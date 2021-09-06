<%-- 
    Document   : Menu
    Created on : Sep 6, 2021, 11:19:43 AM
    Author     : Massielle Coti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>fabrica</title>
    </head>
    <body>
        <h1>Menu</h1>
         
        
        <a href="../../TipoPiezaServlet?comando=listar">Tipo Pieza</a><br>
        <a href="../../MuebleServlet?comando=listar">Mueble</a><br>
        <a href="../../PiezaServlet?comando=listar">Pieza</a><br>
        <a href="../../TipoMuebleServlet?comando=listar">Tipo Mueble</a><br>

          <form action="../../CargaDatosServlet?comando=listar" method="POST" enctype="multipart/form-data">
              <input type="file" name="file"/>
              <input type="submit" value="hacer carga"/>
    </body>
</html>
