
<%@page import="com.emergentes.modelo.registro_de_datos_DAO"%>
<%@page import="com.emergentes.modelo.registro_de_datos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            registro_de_datos_DAO lista = (registro_de_datos_DAO) session.getAttribute("gestor");
        %>
        
        <h1>Listado</h1>
        <p><a href="../Principal?op=nuevo">Nuevo</a></p>
        <%
            if(lista.getRegistros().size()>0){
        %>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Peso</th>
                <th>Talla</th>
                <th>Vacuna</th>
                <th></th>
                <th></th>
            </tr>
            <%
                for(Registro item : lista.getRegistros()){
            %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getNombre()%></td>
                <td><%= item.getPeso()%></td>
                <td><%= item.getTalla()%></td>
                <td><%= item.getVacuna()%></td>
                <td><a href="../Principal?op=editar&id=<%= item.getId() %>">Editar</a></td>
                <td><a href="../Principal?op=eliminar&id=<%= item.getId() %>">Eliminar</a></td>
            </tr>
            <%
            }
            %>
        </table>
            <%
                }
                else{
                    out.println("<p>No existe registro");
                }
            %>
            <h3>ALAND EMERSON GUTIERREZ CALLISAYA</h3>
    </body>
</html>
