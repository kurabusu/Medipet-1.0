<%-- 
    Document   : Usuario
    Created on : 30-10-2017, 15:20:55
    Author     : MZZO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
    </head>
    <body>
        <center><h1>Bienvenido Usuario</h1></center>
        <form name="frm_usuario" method="POST" action="./servletUsuario">
            <table>
                <tr><td><input type="submit" name="btn_clientes" value="Clientes"/></td>
                <td><input type="submit" name="btn_mascotas" value="Mascotas"/></td>
                <td><input type="submit" name="btn_atenciones" value="Atenciónes"/></td></tr>
            </table>
        </form>
    </body>
</html>
