<%-- 
    Document   : listarMascota
    Created on : 05-11-2017, 17:31:06
    Author     : Rav
--%>

<%@page import="modelo.Mascota"%>
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
        <title>Listado de Mascotas</title>
    </head>
    <body>
        <h3>Aquí se Muestran las Mascotas Registradas por Cliente</h3>
        <form name="frm_listaMascota" method="POST" action="./servletListarMascota">
            <table>
                <tr>
                    <td>
                        Elija un Cliente Para ver Sus Mascotas: 
                        <select name="cmbo_clientes">
                            <option value="Seleccione">Seleccione</option>
                            <%for(Cliente temp : lista){%>
                                <option value ="<%=temp.getRut()%>">      
                                <%=temp.getRut()%>
                               </option>
                            <%}%>
                        </select>  
                        <input type="submit" name="btn_buscar" value="Buscar"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <%
                            ArrayList<Mascota> listaM = (ArrayList<Mascota>) sesion.getAttribute("s_mascotas");
                            if(listaM!= null){
                                for(Mascota temp : listaM){
                                    out.print("<br />");
                                    out.print("Rut Cliente:    "+temp.getRutCliente()+"<br />");
                                    out.print("Nombre:   "+temp.getNombre()+"<br />");
                                    out.print("Tipo:   "+temp.getDescrip()+"<br />");
                                    out.print("Fecha de Nacimiento:   "+temp.getFechaNacimiento()+"<br />");
                                    out.print("-----------------------------------------------------------<br />");
                                
                                }
                            }out.println("<a href= './admiMascotas.jsp'>Volver Atrás</a><br />");
                        %>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
