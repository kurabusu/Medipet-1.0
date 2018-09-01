

<%@page import="modelo.TipoMascota"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    
    ArrayList<TipoMascota> lista = (ArrayList<TipoMascota>) sesion.getAttribute("s_tipos");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borra Tipos</title>
    </head>
    <body>
        <h3>Aquí Puede Eliminar Tipos Mascotas</h3>
        <form name="frm_borraTipoMascota" method="POST" action="./servletBorraTipo">
            <table>
                <tr>
                    <td>
                        Elija un Tipo de Mascota a Eliminar:<select name="cmbo_tipoMascota">
                            <option value="0" >Seleccione</option>
                            <%for(TipoMascota temp : lista){%>
                                <option value ="<%=temp.getDescripcion()%>">      
                                <%=temp.getDescripcion()%>
                               </option>
                            <%}%>
                            
                       </select>
                    </td>
                    <td>
                        <input type="submit" name="btn_eliminar" value="Eliminar"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
