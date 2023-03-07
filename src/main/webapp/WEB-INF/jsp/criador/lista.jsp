<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Listagem de Criadores</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">

    <h3>Listagem de criadores</h3>

    <c:if test="${not empty mensagemInclusao}">
        <c:if test="${not empty listaCriadores}">
            <div class="alert alert-success" role="alert">
                <strong>Sucesso! </strong> ${mensagemInclusao}
            </div>
        </c:if>
    </c:if>

    <c:if test="${empty listaCriadores}">
        <div class="alert alert-info" role="alert">
            <strong>Atenção! </strong>Não existem Criadores cadastrados!
        </div>
    </c:if>

    <c:if test="${not empty listaCriadores}">
        <h5>Quantidade de criadores cadastrados: ${listaCriadores.size()}</h5>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Nickname</th>
                <th>Email</th>
                <th>Idade</th>
                <th>Interesses</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="criador" items="${listaCriadores}">
                <tr>
                    <td>${criador.id}</td>
                    <td>${criador.nomeCompleto}</td>
                    <td>${criador.nickname}</td>
                    <td>${criador.email}</td>
                    <td>${criador.idade}</td>
                    <td>${criador.interesses}</td>
                    <td><a href="/criador/${criador.id}/excluir">Excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <button class="btn btn-secondary" onclick="adicionar()">Adicionar +</button>
</div>

<script>
    function adicionar() {
        window.location.href = "/criador/cadastro";
    }
</script>
</body>
</html>
