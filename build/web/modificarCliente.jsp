<%-- 
    Document   : modificarCliente
    Created on : 04-11-2017, 21:13:37
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
        <title>Modificar Clientes</title>
    </head>
    <body>
        <h3>Aquí Puede Modificar la Información de los Clientes</h3>
        <form name="frm_modificaCliente" method="POST" action="./servletModificaCliente">
            <table>
                <tr>
                    <td>
                        Seleccione el Rut del Cliente a Modificar: 
                        <select name="cmbo_modificar">
                            <option value="0">Seleccione</option>
                            <%for(Cliente temp : lista){%>
                                <option value ="<%=temp.getRut()%>">      
                                <%=temp.getRut()%>
                               </option>
                            <%}%>
                        </select>
                   </td>
                <tr/>   
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="txt_nombre" required/></td>
                </tr>
                <tr>
                    <td>Dirección:</td>
                    <td><input type="text" name="txt_direc" required /></td>
                </tr>
                <tr>
                    <td>Fecha de Nacimiento:</td>
                    <td><input type="date" name="txt_fNacimiento" required/></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" name="txt_email" required/></td>
                </tr>
                <tr>
                    <td>Sexo:</td>
                    <td><select name="cmbo_sexo">
                            <option value ="Masculino">Masculino</option>
                            <option value ="Femenino">Femenino</option>    
                       </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="btn_guardar" value="Guardar"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
