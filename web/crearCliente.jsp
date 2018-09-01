<%-- 
    Document   : crearCliente
    Created on : 30-10-2017, 18:14:32
    Author     : MZZO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Cliente</title>
    </head>
    <body>
        <h1>Ingreso de Clientes</h1>
        <form name="frm_cliente" method="POST" action="./servletCreaCliente">
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
                        <input type="submit" name="btn_agregar" value="Agregar"/>
                    </td>
                </tr>
                
            </table>
        </form>
    </body>
</html>
