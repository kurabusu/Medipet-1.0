<%-- 
    Document   : modificarMascota
    Created on : 05-11-2017, 16:57:34
    Author     : Rav
--%>

<%@page import="modelo.Mascota"%>
<%@page import="modelo.TipoMascota"%>
<%@page import="modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    ArrayList<Cliente> lista = (ArrayList<Cliente>) sesion.getAttribute("s_clientes");
    ArrayList<TipoMascota> listaT = (ArrayList<TipoMascota>) sesion.getAttribute("s_tipos");
    ArrayList<Mascota> listaM = (ArrayList<Mascota>) sesion.getAttribute("s_mascotas");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifcador de Mascotas</title>
    </head>
    <body>
        <h3>Aquí puede cambiar Información sobre las Mascotas</h3>
        <form name="frm_modificarMascota" method="POST" action="./servletModificarMascota">
            <table>
                <tr>
                    <td>
                        Elija la Mascota a Modificar:
                        <select name="cmbo_mascota">
                            <option value="0">Seleccione</option>
                            <%for(Mascota temp : listaM){%>
                            <option value ="<%=temp.getId()%>">
                                <%=temp.getNombre()%>
                                
                               </option>
                            <%}%>
                        </select>   
                    </td>
                </tr>
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
                    <td>Nombre:</td>
                    <td>
                        <input type="text" name="txt_nombre" required />
                    </td>
                </tr>
                <tr>
                    <td>Fecha de Nacimiento:</td>
                    <td>
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
