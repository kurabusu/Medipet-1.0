<%-- 
    Document   : modificarAtencion
    Created on : 05-11-2017, 18:55:32
    Author     : Rav
--%>

<%@page import="modelo.Atencion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    
    ArrayList<Atencion> listaAte = (ArrayList<Atencion>) sesion.getAttribute("s_atencion");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Atencion</title>
    </head>
    <body>
        <h2>Actualizar Información sobre la Atención</h2>
        <form name="frm_actulizaAtencion" method="POST" action="./servletActualizaAtencion">
            <table>
                <tr>
                    <td>Seleccione la Atención a Actualizar:</td>
                       <td> <select name="cmbo_atencion">
                        <option value="0">Seleccione</option>
                            <%for(Atencion temp : listaAte){%>
                            <option value ="<%=temp.getId()%>">
                                <%=temp.getId()%>
                                </option>
                            <%}%>     
                       </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        Diagnóstico del Médico:
                        <textarea rows="4" cols="20" name="txt_diagnostico" required></textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        Tratamiento a Realizar:
                    <textarea rows="4" cols="20" name="txt_tratamiento" required></textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        Valor de la Consulta:</td>
                     <td><input type="text" name="txt_valor"  required/>
                    </td>
                </tr>
                <tr>
                    <td>
                       <input type="submit" name="btn_guardar" value="Actualizar"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
