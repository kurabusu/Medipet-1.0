<%-- 
    Document   : listarUsuario
    Created on : 30-10-2017, 18:12:17
    Author     : MZZO
--%>

<%@page import="controlador.ControlUsuario"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Perfil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    
    ArrayList<Perfil> lista = (ArrayList<Perfil>) sesion.getAttribute("s_perfiles");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Usuarios</title>
    </head>
    <body>
    <center><h1>Listado de Usuarios</h1></center>
    <form name="frm_listar" method="POST" action="./servletListar">
        <table>
            <tr>
                    <td>Seleccione un Perfil:
                    <select name="cmbo_perfil">
                            <option value="0" >Seleccione</option>
                            <%for(Perfil temp : lista){%>
                                <option value ="<%=temp.getId()%>">      
                                <%=temp.getDescripcion()%>
                               </option>
                            <%}%>
                            
                       </select>
                   
                        <input type="submit" name="btn_listar" value="Listar"/>
                    </td>
                </tr>
                <tr>
                    <td>
                <%  ArrayList<Usuario> list = (ArrayList<Usuario>) sesion.getAttribute("s_usuarios");
                    if(list!= null){
                        for(Usuario temp : list){
                            out.print("<br />");
                            out.print("Rut:      "+temp.getRut()+"<br />");
                            out.print("Nombre:   "+temp.getNombre()+"<br />");
                            out.print("Fecha de Nacimiento:   "+temp.getFechaNacimiento()+"<br />");
                            out.print("Email:   "+temp.getEmail()+"<br />");
                            out.print("-----------------------------------------------------------<br />");
                    
                        }
                    }
                    %>
               </td>
               </tr>
                    
        </table>
    </form>
    
    </body>
</html>
