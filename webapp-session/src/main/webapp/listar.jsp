<%@page contentType="UTF-8" import="java.util.*, org.rhuamani.apiservlet.webapp.headers.models.*"%>
<%
List<Producto> productos = (List<Producto>) request.getAttribute("productos");
Optional<String> username = (Optional<String>) request.getAttribute("username");
String mensajeRequest = (String) request.getAttribute("mensaje");
String mensajeApp = (String) getServletContext().getAttribute("mensaje");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listado de productos</title>
</head>
<body>
<h1>Listado de productos</h1>
<% if(username.isPresent()) {%>
<div>Hola <%=username.get()%>, Bienvenido!</div>
<p><a href="<%=request.getContextPath()%>/productos/form">crear [+]</a></p>
<% } %>
<form action="<%=request.getContextPath()%>/productos/buscar" method="post">
            <input type="text" name="nombre">
            <input type="submit" value="Buscar">
</form>
<table>
    <tr>
        <th>Id</th>
        <th>Nombre</th>
        <th>tipo</th>
        <% if(username.isPresent()) {%>
        <th>Precio</th>
        <th>agregar</th>
        <th>editar</th>
        <th>eliminar</th>
        <% } %>
    </tr>
    <% for (Producto p: productos) {%>
        <tr>
            <td><%=p.getId()%></td>
            <td><%=p.getNombre()%></td>
            <td><%=p.getCategoria().getNombre()%></td>
            <% if (username.isPresent()) {%>
            <td><%=p.getPrecio()%></td>
            <td><a href="<%=request.getContextPath()%>/carro/agregar?id=<%=p.getId()%>">Agregar</a></td>
            <td><a href="<%=request.getContextPath()%>/productos/form?id=<%=p.getId()%>">Editar</a></td>
            <td><a onclick="return confirm('Estas seguro de eliminar?')"
            href="<%=request.getContextPath()%>/productos/eliminar?id=<%=p.getId()%>">Eliminar</a></td>
            <% } %>
        </tr>
    <% } %>
</table>
<p><%=mensajeApp%></p>
<p><%=mensajeRequest%></p>
<p><a href="<%=request.getContextPath()%>/index.html">volver</a></p>
</body>
</html>