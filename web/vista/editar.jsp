

<%@page import="com.emergentes.modelo.registro_de_datos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTRO_VACUNAS</title>
    </head>
    <body>
        <%
            registro_de_datos item=(registro_de_datos) request.getAttribute("item");
        %>
        <h1>Editar libro</h1>
        <form action="Principal?op=guardar" method="POST">
            Id:<input type="text" name="id" value="<%= item.getId() %>" size="2" pattern="[1-9]{1}[0-9]*"/>
            <input type="hidden" name="tipo" value="<%= item.getId() %>" />
            <br>
            Nombre: <input type="text" name="nombre" value="<%= item.getNombre() %>" required/>
            <br>
            Peso: <input type="text" name="peso" value="<%= item.getPeso()%>" />
            <br>
            Talla: <input type="text" name="talla" value="<%= item.getPeso()%>" />
            <br>
            Vacuna: <input type="radio" name="vacuna" value="Si" <%= (item.getVacuna()=="Si") ? "checked" : ""%> required/> Si
            <input type="radio" name="vacuna" value="No" <%= (item.getVacuna()=="No") ? "checked" : ""%> required/> No
            <br>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
