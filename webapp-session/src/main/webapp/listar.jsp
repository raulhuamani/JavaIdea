<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listado de productos</title>
</head>
<body>
<h1>Listado de productos</h1>
<c:if test="${username.isPresent()}">
    <div>Hola ${username.get()}, Bienvenido!</div>
    <p><a href="${pageContext.request.contextPath}/productos/form">crear [+]</a></p>
</c:if>
<form action="${pageContext.request.contextPath}/productos/buscar" method="post">
    <input type="text" name="nombre">
    <input type="submit" value="Buscar">
</form>
<table>
    <tr>
        <th>Id</th>
        <th>Nombre</th>
        <th>tipo</th>
        <c:if test="${username.present}">
        <th>Precio</th>
        <th>agregar</th>
        <th>editar</th>
        <th>eliminar</th>
        </c:if>
    </tr>
    <c:forEach items="${productos}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.nombre}</td>
            <td>${p.categoria.nombre}</td>
            <c:if test="${username.present}">
            <td>${p.precio}</td>
            <td><a href="${pageContext.request.contextPath}/carro/agregar?id=${p.id}">Agregar</a></td>
            <td><a href="${pageContext.request.contextPath}/productos/form?id=${p.id}">Editar</a></td>
            <td><a onclick="return confirm('Estas seguro de eliminar?')"
            href="${pageContext.request.contextPath}/productos/eliminar?id=${p.id}">Eliminar</a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<p>${applicationScope.mensaje}</p>
<p>${requestScope.mensaje}</p>
<p>${mensaje}</p>
<p><a href="${pageContext.request.contextPath}/index.html">volver</a></p>
</body>
</html>