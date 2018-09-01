<%-- 
    Document   : eliminarCliente
    Created on : 04-11-2017, 11:21:22
    Author     : Rav
--%>

<%@page import="modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    ArrayList<Cliente> lista = (ArrayList<Cliente>) sesion.getAttribute("s_clientes");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Clientes</title>
    </head>
    <body>
    <center><h1>Aquí Puede Borrar Clientes</h1></center>
    <form name="frm_eliminaCliente" method="POST" action="./servletEliminarCliente">
        <table align="center">
            <tr>
                    <td>
                        Seleccione el Rut del Cliente a Eliminar: 
                        <select name="cmbo_eliminar">
                            <option value="0">Seleccione</option>
                            <%for(Cliente temp : lista){%>
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
