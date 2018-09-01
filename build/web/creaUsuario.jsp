<%-- 
    Document   : creaUsuario
    Created on : 02-11-2017, 0:44:45
    Author     : Rav
--%>

<%@page import="modelo.Perfil"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    ArrayList<Perfil> perfiles =  (ArrayList<Perfil>) sesion.getAttribute("s_perfiles");

%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Nuevo Usuario</title>
    </head>
    <body>
        <h2>Creación de Usuarios</h2>
        <form name="frm_creaUsuario" method="POST" action="./servletCreaUsuario">
            <table>
                <tr>
                    <td>Rut:</td>
                    <td><input type="text" name="txt_rut" required /></td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="txt_nombre" required/></td>
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
                    <td>Contraseña:</td>
                    <td><input type="password" title="Debe tener un máximo de 20 caracteres" name="txt_pass" required /></td>
                </tr>
                <tr>
                    <td>Perfil:</td>
                    <td><select name="cmbo_perfil">
                            <option value="0" >Seleccione</option>
                            <%for(Perfil temp : perfiles){%>
                                <option value ="<%=temp.getId()%>">      
                                <%=temp.getDescripcion()%>
                               </option>
                            <%}%>
                            
                       </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="btn_agregar" value="Agregar"/>
                    </td>
                </tr>
                
            </table>
        </form>
    </body>
</html>
