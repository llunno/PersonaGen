<%@ page import="org.webjars.WebJarAssetLocator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Listagem de Habilidades</title>
    <c:import url="../globalHtmlLinks.jsp"/>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">

    <h3>Listagem de Habilidades</h3>

    <c:if test="${not empty mensagemInclusao}">
        <c:if test="${not empty listaHabilidades}">
            <div class="alert alert-success" role="alert">
                <strong>Sucesso! </strong> ${mensagemInclusao}
            </div>
        </c:if>
    </c:if>

    <c:if test="${empty listaHabilidades}">
        <div class="alert alert-info" role="alert">
            <strong>Atenção! </strong>Não existem habilidades cadastradas!
        </div>
    </c:if>

    <c:if test="${not empty listaHabilidades}">
        <h5>Quantidade de habilidades cadastradas: ${listaHabilidades.size()}</h5>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Tipo</th>
                <th>Maestria</th>
                <th>Ponto de Destaque</th>
                <th>Inspiração</th>
                <th>Descrição</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="habilidade" items="${listaHabilidades}">
                <tr>
                    <td>${habilidade.id}</td>
                    <td>${habilidade.nome}</td>
                    <td>${habilidade.tipo}</td>
                    <td>${habilidade.maestria}</td>
                    <td>${habilidade.pontoDeDestaque}</td>
                    <td>${habilidade.inspiracao}</td>
                    <td>${habilidade.descricao}</td>
                    <td><a href="/habilidade/${habilidade.id}/excluir">Excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <button class="btn btn-secondary" onclick="adicionar()">Adicionar +</button>
</div>

<script>
    function adicionar() {
        window.location.href = "/habilidade/cadastro";
    }
</script>
</body>
</html>
