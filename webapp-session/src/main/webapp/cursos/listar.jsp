<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:include page="/layout/headerCurso.jsp" />

<h1>${titulo}</h1>
<p><a class="btn btn-primary my-2" href="${pageContext.request.contextPath}/cursos/form">crear [+]</a></p>
<form action="${pageContext.request.contextPath}/cursos/buscar" method="post">
    <div class="row mb-4">
        <div class="col-sm-4">
            <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Buscar" name="nombre">
        </div>
        <div class="col-sm-2">
            <input class="btn btn-outline-success" type="submit" value="Buscar">
        </div>
    </div>
</form>
<table class="table table-hover table-striped">
    <tr>
        <th>id</th>
        <th>nombre</th>
        <th>instructor</th>
        <th>duracion</th>
        <th>editar</th>
        <th>eliminar</th>
    </tr>
    <c:forEach items="${cursos}" var="c">
    <tr>
        <td>${c.id}</td>
        <td>${c.nombre}</td>
        <td>${c.instructor}</td>
        <td>${c.duracion}</td>
        <td><a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/cursos/form?id=${c.id}">editar</a></td>
        <td><a class="btn btn-sm btn-danger" onclick="return confirm('esta seguro que desea eliminar?');"
               href="${pageContext.request.contextPath}/cursos/eliminar?id=${c.id}">eliminar</a></td>
    </tr>
    </c:forEach>
</table>
<p><a class="btn btn-sm btn-secondary" href="${pageContext.request.contextPath}/index.jsp">volver</a></p>
<jsp:include page="/layout/footer.jsp" />