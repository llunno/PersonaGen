<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib uri="jakarta.tags.cores" prefix="c" %>--%>
<html>
<head>
    <title>Autenticação</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
</head>
<body>
    <div class="container my-5 mx-5">
        <h1 class="mb-2">Autenticação</h1>
        <c:if test="${not empty mensagem}">
            <div class="alert alert-danger">
                <strong>Atenção!</strong> ${mensagem}
            </div>
        </c:if>
        <form action="/login" method="post">
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input name="email" type="text" class="form-control" id="email" required>
            </div>
            <div class="mb-3">
                <label for="senha" class="form-label">Senha</label>
                <input name="senha" type="password" class="form-control" id="senha" required>
            </div>
            <button type="submit" class="btn btn-primary">Entrar</button>
        </form>
    </div>
</body>
</html>
