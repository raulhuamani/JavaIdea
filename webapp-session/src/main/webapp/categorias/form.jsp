<%@page contentType="text/html" pageEncoding="UTF-8" import="java.time.format.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/layout/header.jsp" />

<h3>${title}</h3>

<form action="${pageContext.request.contextPath}/categorias/form" method="post">
    <div class="row mb-2">
        <label for="nombre" class="col-form-label col-sm-2">Categoria</label>
        <div class="col-sm-4">
            <input type="text" name="nombre" id="nombre" value="${categoria.nombre}" class="form-control">
        </div>
        <c:if test="${errores != null && errores.containsKey('nombre')}">
            <div style="color:red;">${errores.nombre}</div>
        </c:if>
    </div>

    <div class="my-2">
        <input class="btn btn-primary" type="submit" value="${categoria.id != null && categoria.id > 0 ? "Editar" : "Crear"}">
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/categorias">Cancelar</a>
        </div>
    <input type="hidden" name="id" value="${categoria.id!=null && categoria.id>0? categoria.id: 0}">
</form>
<jsp:include page="/layout/footer.jsp" />