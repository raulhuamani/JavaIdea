<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:include page="layout/headerCurso.jsp" />

<h1>${titulo}</h1>

<form action="${pageContext.request.contextPath}/cursos/form" method="post">
    <div class="row mb-2">
        <label for="nombre" class="col-form-label col-sm-2">Nombre</label>
        <div class="col-sm-4">
            <input type="text" name="nombre" id="nombre" value="${curso.nombre}" class="form-control">
        </div>
        <c:if test="${errores != null && errores.containsKey('nombre')}">
            <div style="color:red;">${errores.nombre}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <label for="instructor" class="col-form-label col-sm-2">Instructor</label>
        <div class="col-sm-4">
            <input type="text" name="instructor" id="instructor" value="${curso.instructor}" class="form-control">
        </div>
        <c:if test="${errores != null && errores.containsKey('instructor')}">
            <div style="color:red;">${errores.instructor}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <label for="duracion" class="col-form-label col-sm-2">Duracion</label>
        <div class="col-sm-4">
            <input type="text" name="duracion" id="duracion" value="${curso.duracion != null && curso.duracion > 0 ? curso.duracion : ""}" class="form-control">
        </div>
        <c:if test="${errores != null && errores.containsKey('duracion')}">
        <div style="color:red;">${errores.duracion}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <label for="descripcion" class="col-form-label col-sm-2">Descripción</label>
        <div class="col-sm-4">
            <textarea class="form-control" name="descripcion" id="descripcion">${curso.descripcion}</textarea>
        </div>
        <c:if test="${errores != null && errores.containsKey('descripcion')}">
            <div style="color:red;">${errores.descripcion}</div>
        </c:if>
    </div>

    <div class="my-2">
    <input class="btn btn-primary" type="submit" value="${curso.id != null && curso.id > 0 ? "Editar" : "Crear"}">
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/cursos">Cancelar</a>
    </div>
    <input class="btn btn-primary" type="hidden" name="id" value="${curso.id}">
</form>
<jsp:include page="layout/footer.jsp" />