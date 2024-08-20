<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/layout/header.jsp" />
<h3>${title}</h3>
<c:if test="${username.present}">
    <a class="btn btn-primary my-2" href="${pageContext.request.contextPath}/categorias/form">crear [+]</a>
</c:if>
<form action="${pageContext.request.contextPath}/categorias/buscar" method="post">
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
            <c:if test="${username.present}">
            <th>editar</th>
            <th>eliminar</th>
            </c:if>
    </tr>
    <c:forEach items="${categorias}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.nombre}</td>
            <c:if test="${username.present}">
                <td><a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/categorias/form?id=${u.id}">editar</a></td>
                <td><a class="btn btn-sm btn-danger" onclick="return confirm('esta seguro que desea eliminar?');"
                       href="${pageContext.request.contextPath}/categorias/eliminar?id=${u.id}">eliminar</a></td>
                </c:if>
        </tr>
    </c:forEach>
</table>
<jsp:include page="/layout/footer.jsp" />