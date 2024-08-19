<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:include page="layout/header.jsp" />

<h3>${title}</h3>
<c:if test="${username.isPresent()}">
    <div class="alert alert-info" >Hola ${username.get()}, Bienvenido!</div>
    <a class="btn btn-primary my-2" href="${pageContext.request.contextPath}/productos/form">crear [+]</a>
</c:if>
<form action="${pageContext.request.contextPath}/productos/buscar" method="post">
    <div class="row mb-4">
        <div class="col-sm-4">
            <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Buscar" name="nombre">
        </div>
        <div class="col-sm-2">
            <input class="btn btn-outline-success" type="submit" value="Buscar">
        </div>
    </div>
</form>
<table class="table table-hover table-striped" >
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
            <td><a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/carro/agregar?id=${p.id}">Agregar</a></td>
            <td><a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/productos/form?id=${p.id}">Editar</a></td>
            <td><a class="btn btn-sm btn-danger" onclick="return confirm('Estas seguro de eliminar?')"
            href="${pageContext.request.contextPath}/productos/eliminar?id=${p.id}">Eliminar</a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<p>${applicationScope.mensaje}</p>
<p>${requestScope.mensaje}</p>
<p>${mensaje}</p>
<p><a class="btn btn-sm btn-secondary" href="${pageContext.request.contextPath}/index.jsp">volver</a></p>
<jsp:include page="layout/footer.jsp" />