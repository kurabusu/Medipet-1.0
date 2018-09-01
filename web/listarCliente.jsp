<%-- 
    Document   : listarCliente
    Created on : 04-11-2017, 21:29:04
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
        <title>Listado Clientes</title>
    </head>
    <body>
        <h3>Aquí se Listan todos los Clientes y sus Mascotas</h3>
        <form name="frm_listarCliente" method="POST" action="./servletListarCliente">
            <table>
             <tr>
                    <td>
                        Elija un Cliente Para ver Sus Mascotas: 
                        <select name="cmbo_cliente">
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
                <%  ArrayList<Mascota> list = (ArrayList<Mascota>) sesion.getAttribute("s_mascota");
                    
                        for(Cliente temp : lista){
                            out.print("<br />");
                            out.print("Rut:      "+temp.getRut()+"<br />");
                            out.print("Nombre:   "+temp.getNombre()+"<br />");
                            out.print("Dirección:   "+temp.getDirección()+"<br />");
                            out.print("Fecha de Nacimiento:   "+temp.getFechaNacimiento()+"<br />");
                            out.print("Email:   "+temp.getEmail()+"<br />");
                            out.print("Sexo:   "+temp.getSexo()+"<br />");
                            out.print("-----------------------------------------------------------<br />");
                            
                                for(Mascota x : list){
                                    out.print("Listando Mascotas<br />");
                                    out.print("-----------------------------------------------------------<br />");
                                    out.print("Nombre:    "+x.getNombre()+"<br/>");
                                    out.print("Tipo de Mascota:    "+x.getDescrip()+"<br/>");
                                    out.print("Fecha de Nacimiento:    "+x.getFechaNacimiento()+"<br/>");
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
