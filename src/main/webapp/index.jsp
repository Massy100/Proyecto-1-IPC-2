<%-- 
    Document   : index
    Created on : Aug 27, 2021, 9:23:27 PM
    Author     : Massielle Coti
--%>

<%@page import="Conexion.Conectar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%Conectar conectar=new Conectar();%>
        <h1>BIENVENIDO A MI MUEBLERIA</h1>
        
   
        <div id="datosUsuario">   
            <h1>Inicio de Sesión<h1>
            <form id="formularioUsuario" method="POST" action="LoginServlet">
              
                <input type="text" name="usuario" placeholder="Ingrese su usuario"/>
                
                <hr>
              
                <input type="password" name="password" placeholder="Ingrese su contraseña"/>
                <hr>
                <input type="submit" value="Iniciar Sesión" />
            </form>
        </div>
  
        
        
        
        
        
       
          </form>
    </body>
</html>
