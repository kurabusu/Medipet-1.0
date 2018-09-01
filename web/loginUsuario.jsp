<%-- 
    Document   : loginUsuario
    Created on : 18-10-2017, 10:56:02
    Author     : MZZO
--%>

<%@page import="controlador.ControlLogin"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    ArrayList<Usuario> lista = (ArrayList<Usuario>) sesion.getAttribute("s_user");
    
                    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión</title>
    </head>
    <body>
        <center><h1>Login Usuario</h1></center>
        <form name="frm_login" method="POST" action="./servletLogin">
            <table align="center">
                
                <tr>
                    <td>Usuario:</td>
                    <td><input type="text" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" name="txt_usuario" required/></td>
                </tr>
                  <tr>
                    <td>Contraseña:</td>
                    <td><input type="password" name="txt_pass" required/></td>
                </tr>
           

                
                  <tr>
                    <td><input type="submit" name="btn_ingresar" value="Ingresar"/></td>
                </tr>
            </table>
        </form>
        
        
    </body>
</html>
