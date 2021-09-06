/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Conexion.Conectar;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Massielle Coti
 */
public class LoginServlet extends HttpServlet {
  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario=request.getParameter("usuario");
        String password = request.getParameter("password");
        try{
            Connection conexion=null;
            try{
                conexion=Conectar.getConnection();
            }catch(Exception e){
            }
            Statement conne=conexion.createStatement();
            ResultSet set=conne.executeQuery("select * from Usuario where nombre='"+usuario+"'");
            String v[]= new String[3];
            
            if(set.next()){       
                v[0]=set.getString(1);
                v[1]=set.getString(2);
                v[2]=set.getString(3);
                if(Integer.parseInt(v[2])==1&&v[1].equals(password)){
                    response.sendRedirect("PaginaWeb/Menu/Menu.jsp?comando=listar&usuario="+usuario);
                }else if(Integer.parseInt(v[2])==2&&v[1].equals(password)){
                    response.sendRedirect("PaginaWeb/Menu/Menu2.jsp?comando=listar&usuario="+usuario);
                }else if(Integer.parseInt(v[2])==3&&v[1].equals(password)){
                    response.sendRedirect("PaginaWeb/Menu/Menu3.jsp?comando=listar&usuario="+usuario);
                }else{
                }
            }else{
            }
        }catch(Exception e){
            
        }
    }
   
}
