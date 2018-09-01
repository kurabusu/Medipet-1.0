<%-- 
    Document   : buscarAtencion
    Created on : 05-11-2017, 18:56:32
    Author     : Rav
--%>

<%@page import="modelo.Atencion"%>
<%@page import="modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    ArrayList<Cliente> lista = (ArrayList<Cliente>) sesion.getAttribute("s_clientes");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Consultas</title>
    </head>
    <body>
        <h3>Aquí Puede ver Las Atenciones Realizadas a un Cliente</h3>
        <form name="frm_listaAtencion" method="POST" action="./servletListarAtencion">
            <table>
                <tr>
                    <td>Seleccione un Cliente:
                    <select name="cmbo_cliente">
                        <option value="Seleccione">Seleccione</option>
                            <%for(Cliente temp : lista){%>
                                <option value ="<%=temp.getRut()%>">      
                                <%=temp.getRut()%>
                               </option>
                            <%}%>    
                       </select>
                        <input type="submit" name="btn_listar" value="Listar"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <%
                            ArrayList<Atencion> listaAte = (ArrayList<Atencion>) sesion.getAttribute("s_atencion");
                            if(listaAte!= null){
                                for(Atencion ate : listaAte){
                                    out.print("Fecha de la Atención: "+ate.getFechaAtención()+"<br />");
                                    out.print("Nombre de la Mascota: "+ate.getNombreMasco()+"<br />");
                                    out.print("Rut del Médico: "+ate.getRutMedico()+"<br />");
                                    out.print("Síntomas: "+ate.getDescripSíntoma()+"<br />");
                                    out.print("Tratamiento Realizado: "+ate.getDescripTratamiento()+"<br />");
                                    out.print("Valor total de La Consulta. "+ate.getValorConsulta()+"<br />");
                                    out.print("-------------------------------------------------"+"<br />");
                                }
                            }out.println("<a href= './admiAtenciones.jsp'>Volver Atrás</a><br />");
                        %>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
