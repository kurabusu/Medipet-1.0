<%-- 
    Document   : admiMascotas
    Created on : 02-11-2017, 2:47:34
    Author     : Rav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestor Mascotas</title>
    </head>
    <body>
        <center><h1>Bienvenido al Gestor de Mascotas</h1></center>
        <form name="frm_mascotas" method="POST" action="./servletMascota">
            <table align="center">
                <tr>
                    <td><input type="submit" name="btn_agregar" value="Ingresar"/></td>
                    <td><input type="submit" name="btn_modificar" value="Modificar"/></td>
                    <td><input type="submit" name="btn_buscar" value="Buscar"/></td>
                    <td><input type="submit" name="btn_tipoMasco" value="Tipos de Mascotas"/></td>
                    <td><input type="submit" name="btn_borraTipoMasco" value=" Borrar Tipos de Mascotas"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
