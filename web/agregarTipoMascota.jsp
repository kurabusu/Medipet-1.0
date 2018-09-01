<%-- 
    Document   : agregarTipoMascota
    Created on : 04-11-2017, 23:27:30
    Author     : Rav
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.TipoMascota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    
    ArrayList<TipoMascota> lista = (ArrayList<TipoMascota>) sesion.getAttribute("s_tipos");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar o Eliminar Tipos de Mascotas</title>
    </head>
    <body>
        <h3>Aquí Puede Crear Tipos Mascotas</h3>
        <form name="frm_tipoMascota" method="POST" action="./servletTipoMascota">
            <table>
                <tr>
                    <td>Descripción:
                    <input type="text" name="txt_descripcion" required/>
                    
                        <input type="submit" name="btn_agregarPerfil" value="Agregar"/>
                    </td>
                </tr>
               
            </table>
        </form>
    </body>
</html>
