<%-- 
    Document   : crearMascota
    Created on : 30-10-2017, 18:14:44
    Author     : MZZO
--%>

<%@page import="modelo.TipoMascota"%>
<%@page import="modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    ArrayList<Cliente> lista = (ArrayList<Cliente>) sesion.getAttribute("s_clientes");
    ArrayList<TipoMascota> listaT = (ArrayList<TipoMascota>) sesion.getAttribute("s_tipos");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Mascota</title>
    </head>
    <body>
        <center><h1>Creación de Mascotas Nuevas</h1></center>
        <form name="frm_creaMascota" method="POST" action="./servletCreaMascota">
            <table>
                <tr>
                    <td>
                         Rut A Quien Pertenece: 
                        <select name="cmbo_clientes">
                            <option value="0">Seleccione</option>
                            <%for(Cliente temp : lista){%>
                                <option value ="<%=temp.getRut()%>">      
                                <%=temp.getRut()%>
                               </option>
                            <%}%>
                        </select>   
                    </td>
                </tr>
                <tr>
                    <td>
                        Tipo de Mascota:
                        <select name="cmbo_tipos">
                            <option value="0">Seleccione</option>
                            <%for(TipoMascota temp : listaT){%>
                            <option value ="<%=temp.getId()%>">      
                                <%=temp.getDescripcion()%>
                               </option>
                            <%}%>
                        </select>   
                    </td>
                </tr>
                <tr>
                    <td>Nombre:
                        <input type="text" name="txt_nombre" required />
                    </td>
                </tr>
                <tr>
                    <td>Fecha de Nacimiento:
                        <input type="date" name="txt_fNacimiento" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="btn_agregar" Value="Guardar" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
