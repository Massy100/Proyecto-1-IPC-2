<%-- 
    Document   : EnsambladorListar
    Created on : Aug 26, 2021, 10:24:42 PM
    Author     : Massielle Coti
--%>

<%@page import="java.sql.*"%>
<%@page import="Conexion.Conectar"%>
<%@page import="MuebleEnsamblado.*"%>
<%@page import="MuebleEnsamblado.QueryMueble"%>
<%@page import="TipoPieza.TipoPieza"%>
<%@page import="TipoPieza.QueryTipoPieza"%>
<%@page import="Ensamblador.QueryEnsamblador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Ensamblador.Ensamblador"%>
<%@page import="Ensamblador.ModeloEnsamblador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mueble Ensamblado Listar</title>
    </head>
    <body>
        <div class="d-flex justify-content-center">
            <div class="card">
                <div class="card-body">
                    <table border="1", class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id Mueble Ensamblado</th>
                                <th>Nombre</th>
                                <th>Precio Final</th>
                                <th>Cantidad</th>
                                <th>Fecha Ensamblado</th>
                                <th>OPciones</th>
                            </tr>
                        </thead>
                        
                        <%
                            QueryMueble e = new QueryMueble();
                            ArrayList<Mueble> muebles = e.ListarMueble();
                            for (int i = 0; i < muebles.size(); i++) {
                                Mueble temporal = muebles.get(i);
                        %>
                        
                        <tbody>
                            
                            <tr>
                                
                                <td><%=temporal.getId_mueble() %></td>
                                <td><%=temporal.getNombre()%></td>
                                <td><%=temporal.getPrecio_final() %></td>
                                <td><%=temporal.getCantidad() %></td>
                                <td><%=temporal.getFecha_ensamblado() %></td>
                                <td><a href="MuebleServlet?comando=editar&codigo=<%=temporal.getId_mueble() %>" class="btn btn-info">editar</a></td>
                                <td><a href="MuebleServlet?comando=eliminar&codigo=<%=temporal.getId_mueble()%>">eliminar</a></td>
                                <!--
                                -->
                            </tr>
                            
                        </tbody>
                        <%}%>
                    </table>
                </div>
            </div>
        </div>
        <a href="MuebleServlet?comando=ingresar" class="btn btn-primary">insertar</a>
    </body>
</html>
