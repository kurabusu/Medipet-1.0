<%-- 
    Document   : modificarUsuario
    Created on : 30-10-2017, 18:12:05
    Author     : MZZO
--%>

<%@page import="modelo.Usuario"%>
<%@page import="modelo.Perfil"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%HttpSession sesion = request.getSession();
    ArrayList<Perfil> perfiles =  (ArrayList<Perfil>) sesion.getAttribute("s_perfiles");
    ArrayList<Usuario> usuarios = (ArrayList<Usuario>) sesion.getAttribute("s_usuarios");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Usuarios</title>
    </head>
    <body>
        <center><h1>Modificación de Usuarios</h1></center>
        <form name="frm_modificar" method="POST" action="./servletModificar">
            <table>
                <tr>
                    <td>
                        Seleccione el rut del Usuario a Modificar:
                        <select name="cmb_rut">
                            <option value="0">Seleccione</option>
                            <%for(Usuario temp : usuarios){%>
                            <option value="<%=temp.getRut()%>">
                            <%=temp.getNombre()%>
                            </option>
                            <%}%>    
                        </select>                  
                    </td>
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
                        <input type="submit" name="btn_modi" value="Modificar"/>
                    </td>
                </tr>
                
            </table>
        </form>
        
    </body>
</html>
