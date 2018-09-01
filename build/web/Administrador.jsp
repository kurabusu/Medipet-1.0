<%-- 
    Document   : Administrador
    Created on : 30-10-2017, 10:36:13
    Author     : MZZO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
    </head>
    <body>
        <center><h1>Bienvenido Administrador</h1></center>
        <form name="frm_admin" method="POST" action="./servletAdmin">
            <table align="center">
                <tr>
                    <td><input type="submit" name="btn_agregar" value="Ingresar"/></td>
                    <td><input type="submit" name="btn_eliminar" value="Eliminar"/></td>
                    <td><input type="submit" name="btn_modificar" value="Modificar"/></td>
                    <td><input type="submit" name="btn_listar" value="Listar"/></td>
                    <td><input type="submit" name="btn_perfiles" value="Agregar Perfiles"/></td>
                    <td><input type="submit" name="btn_clientes" value="Clientes"/></td>
                    <td><input type="submit" name="btn_mascotas" value="Mascotas"/></td>
                    <td><input type="submit" name="btn_atenciones" value="Atenciones"/></td>

                </tr>
            </table>
        </form>
        
    </body>
</html>
