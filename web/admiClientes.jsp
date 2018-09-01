<%-- 
    Document   : admiClientes
    Created on : 02-11-2017, 2:44:32
    Author     : Rav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestor Clientes</title>
    </head>
    <body>
        <center><h1>Binevenido al Gestor de Clientes</h1></center>
        <form name="frm_cliente" method="POST" action="./servletCliente">
            <table align="center">
                <tr>
                    <td><input type="submit" name="btn_agregar" value="Agregar"/></td>
                    <td><input type="submit" name="btn_eliminar" value="Eliminar"/></td>
                    <td><input type="submit" name="btn_modificar" value="Modificar"/></td>
                    <td><input type="submit" name="btn_listar" value="Listar"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
