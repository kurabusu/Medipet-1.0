<%-- 
    Document   : agregarPerfil
    Created on : 18-10-2017, 12:43:20
    Author     : MZZO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Perfiles</title>
    </head>
    <body>
        <form name="frm_perfil" method="POST" action="./servletPerfil">
            <table>
                <tr>
                    <td>Descripción:</td>
                    <td><input type="text" name="txt_descripcion" required/></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="btn_agregarPerfil" value="Agregar"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
