<%-- 
    Document   : admiAteciones
    Created on : 02-11-2017, 2:47:50
    Author     : Rav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestor Atenciones</title>
    </head>
    <body>
        <center><h1>Bienvenido al Gestor de Atenciones</h1></center>
        <form name="frm_atencion" method="POST" action="./servletAtenciones">
            <table align="center">
                <tr>
                    <td><input type="submit" name="btn_agregar" value="Ingresar"/></td>
                    <td><input type="submit" name="btn_actualizar" value="Actualizar"/></td>
                    <td><input type="submit" name="btn_buscar" value="Buscar"/></td>    
                </tr>
            </table>
        </form>
    </body>
</html>
