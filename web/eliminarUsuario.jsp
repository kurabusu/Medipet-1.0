<%-- 
    Document   : eliminarUsuario
    Created on : 30-10-2017, 18:11:54
    Author     : MZZO
--%>

<%@page import="modelo.Atencion"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    ArrayList<Usuario> lista = (ArrayList<Usuario>) sesion.getAttribute("s_usuarios");
    

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Usuarios</title>
    </head>
    <body>
        <center><h1>Eliminación de Usuarios</h1></center>
        <form name="frm_elimina" method="POST" action="./servletEliminar">
            <table align="center">
                <tr>
                    <td>
                        Seleccione el Rut del Usuario a Eliminar: 
                        <select name="cmbo_eliminar">
                            <option value="0">Seleccione</option>
                            <%for(Usuario temp : lista){%>
                                <option value ="<%=temp.getRut()%>">      
                                <%=temp.getRut()%>
                               </option>
                            <%}%>
                        </select>
                        
                        <input type="submit" name="btn_eliminar" value="Eliminar"/>
                    </td>
                </tr>
            </table>
        </form>
        
        
    </body>
</html>
