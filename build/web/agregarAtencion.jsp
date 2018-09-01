<%-- 
    Document   : agregarAtencion
    Created on : 05-11-2017, 18:56:02
    Author     : Rav
--%>

<%@page import="modelo.Mascota"%>
<%@page import="controlador.ControlMascota"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ControlMascota mas = new ControlMascota();
    HttpSession sesion = request.getSession();
    ArrayList<Cliente> listaCli = (ArrayList<Cliente>) sesion.getAttribute("s_clientes");
    ArrayList<Usuario> listaMed = (ArrayList<Usuario>) sesion.getAttribute("s_medicos");
    ArrayList<Usuario> listaUsu = (ArrayList<Usuario>) sesion.getAttribute("s_usuarios");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Nueva Atención</title>
    </head>
    <body>
        <h2>Ingresar Atención</h2>
        <form name="frm_creaAtencion" method="POST" action="./servletCreaAtencion">
            <table>
                <tr>
                    <td>Seleccione un Cliente:
                    <select name="cmbo_cliente">
                        <option value="Seleccione">Seleccione</option>
                            <%for(Cliente temp : listaCli){%>
                                <option value ="<%=temp.getRut()%>">
                                    <%=temp.getRut()%>
                                </option>
                            <%}%>     
                       </select>
                    </td>
                </tr>
                <tr>
                    <%
                        for(Cliente cli : listaCli){
                            sesion.setAttribute("s_mascotas", mas.ListarMascotas(cli.getRut()));
                    }
                    ArrayList<Mascota> listaMas = (ArrayList<Mascota>) sesion.getAttribute("s_mascotas");
                    %>
                    <td>Seleccione una Mascota:
                    <select name="cmbo_mascota">
                        <option value="0">Seleccione</option>
                            <%for(Mascota temp : listaMas){%>
                            <option value ="<%=temp.getId()%>">
                                    <%=temp.getNombre()%>
                                </option>
                            <%}%>     
                       </select>
                    </td>
                </tr>
                <tr>
                    <td>Seleccione un Médico:
                    <select name="cmbo_medico">
                        <option value="Seleccione">Seleccione</option>
                            <%for(Usuario temp : listaMed){%>
                                <option value ="<%=temp.getRut()%>">
                                    <%=temp.getRut()%>
                                </option>
                            <%}%>     
                       </select>
                    </td>
                </tr>
                <tr>
                    <td>Usuario que Registra la Atención:
                    <select name="cmbo_usuario">
                        <option value="Seleccione">Seleccione</option>
                            <%for(Usuario usu : listaUsu){%>
                                <option value ="<%=usu.getRut()%>">
                                    <%=usu.getRut()%>
                                </option>
                            <%}%>     
                       </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Síntomas que Presenta:</td>
                    <td>    <textarea rows="4" cols="30" name="txt_descrip" required></textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="btn_guardar" value="Guardar"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
