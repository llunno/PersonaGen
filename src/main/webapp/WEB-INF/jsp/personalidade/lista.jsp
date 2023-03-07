<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Listagem de Personalidades</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">

    <h3>Listagem de Personalidades</h3>

    <c:if test="${not empty mensagemInclusao}">
        <c:if test="${not empty listaPersonalidade}">
            <div class="alert alert-success" role="alert">
                <strong>Sucesso! </strong> ${mensagemInclusao}
            </div>
        </c:if>
    </c:if>

    <c:if test="${empty listaPersonalidade}">
        <div class="alert alert-info" role="alert">
            <strong>Atenção! </strong>Não existem personalidades cadastradas!
        </div>
    </c:if>

    <c:if test="${not empty listaPersonalidade}">
        <h5>Quantidade de personalidades cadastradas: ${listaPersonalidade.size()}</h5>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Palavra Definição</th>
                <th>Tipo de Expressão</th>
                <th>Religião</th>
                <th>Temperamento</th>
                <th>Qualidades</th>
                <th>Defeitos</th>
                <th>Interesses</th>
                <th>Desinteresses</th>
                <th>Ponto de Destaque</th>
                <th>Inspiração</th>
                <th>Descrição</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="personalidade" items="${listaPersonalidade}">
                <tr>
                    <td>${personalidade.id}</td>
                    <td>${personalidade.palavraDefinicao}</td>
                    <td>${personalidade.tipoExpressao}</td>
                    <td>${personalidade.religiao}</td>
                    <td>${personalidade.temperamento}</td>
                    <td>${personalidade.qualidades}</td>
                    <td>${personalidade.defeitos}</td>
                    <td>${personalidade.interesses}</td>
                    <td>${personalidade.desinteresses}</td>
                    <td>${personalidade.pontoDeDestaque}</td>
                    <td>${personalidade.inspiracao}</td>
                    <td>${personalidade.descricao}</td>
                    <td><a href="/personalidade/${personalidade.id}/excluir">Excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <button class="btn btn-secondary" onclick="adicionar()">Adicionar +</button>
</div>

<script>
    function adicionar() {
        window.location.href = "/personalidade/cadastro";
    }
</script>
</body>
</html>