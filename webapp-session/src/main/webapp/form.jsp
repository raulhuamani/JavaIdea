<%@page contentType="text/html" pageEncoding="UTF-8" import="java.time.format.*"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario productos</title>
</head>
<body>
    <h1>Formulario productos</h1>
    <form action="${pageContext.request.contextPath}/productos/form" method="post">
        <div>
            <label for="nombre">Nombre:</label>
            <div>
                <input type="text" id="nombre" name="nombre" value="${producto.nombre}">
            </div>
            <c:if test="${errores != null && errores.containsKey('nombre')}">
                <div style="color: red;">${errores.nombre}</div>
            </c:if>
        </div>

        <div>
            <label for="precio">Precio:</label>
            <div>
                <input type="number" id="precio" name="precio" value="${producto.precio > 0 ? producto.precio : "" }">
            </div>
            <c:if test="${errores != null && not empty errores.precio}">
                <div style="color: red;">${errores.precio}</div>
            </c:if>
        </div>

        <div>
            <label for="sku">Sku:</label>
            <div>
                <input type="text" id="sku" name="sku" value="${producto.sku}">
            </div>
            <c:if test="${errores != null && not empty errores.sku}">
                <div style="color: red;">${errores.sku}</div>
            </c:if>
        </div>

        <div>
            <label for="fecha_registro">Fecha Registro:</label>
            <div>
                <input type="date" id="fecha_registro" name="fecha_registro" value="${producto.fechaRegistro != null ? producto.fechaRegistro.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : ""}">
            </div>
            <c:if test="${errores != null && not empty errores.fecha_registro}">
                <div style="color: red;">${errores.fecha_registro}</div>
            </c:if>
        </div>

        <div>
            <label for="Categoria">Categoria:</label>
            <div>
                <select name="categoria" id="Categoria">
                    <option value="">--- seleccionar ---</option>
                    <c:forEach items="${categorias}" var="c">
                        <option value="${c.id}" ${c.id.equals(producto.categoria.id) ? "selected" : ""}>${c.nombre}</option>
                    </c:forEach>
                </select>
            </div>
            <c:if test="${errores != null && not empty errores.categoria}">
                <div style="color: red;">${errores.categoria}</div>
            </c:if>
        </div>

        <div><input type="submit" value="${producto.id != null && producto.id>0 ? "Editar" : "Crear"}"></div>
        <input type="hidden" name="id" value="${producto.id}">
    </form>
    <p><a href="${pageContext.request.contextPath}/productos">volver</a></p>
</body>
</html>