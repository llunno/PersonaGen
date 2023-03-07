<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Listagem de Aparências</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">

    <h3>Listagem de Habilidades</h3>

    <c:if test="${not empty mensagemInclusao}">
        <c:if test="${not empty listaAparencia}">
            <div class="alert alert-success" role="alert">
                <strong>Sucesso! </strong> ${mensagemInclusao}
            </div>
        </c:if>
    </c:if>

    <c:if test="${empty listaAparencia}">
        <div class="alert alert-info" role="alert">
            <strong>Atenção! </strong>Não existem aparências cadastradas!
        </div>
    </c:if>

    <c:if test="${not empty listaAparencia}">
        <h5>Quantidade de aparências cadastradas: ${listaAparencia.size()}</h5>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Altura</th>
                <th>Peso</th>
                <th>Biotipo</th>
                <th>Cor da pele</th>
                <th>Cor dos Olhos</th>
                <th>Cor do cabelo</th>
                <th>Tipo de cabelo</th>
                <th>Ponto de Destaque</th>
                <th>Inspiração</th>
                <th>Descrição</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="aparencia" items="${listaAparencia}">
                <tr>
                    <td>${aparencia.id}</td>
                    <td>${aparencia.altura}</td>
                    <td>${aparencia.peso}</td>
                    <td>${aparencia.biotipo}</td>
                    <td>${aparencia.corPele}</td>
                    <td>${aparencia.corOlhos}</td>
                    <td>${aparencia.corCabelo}</td>
                    <td>${aparencia.tipoCabelo}</td>
                    <td>${aparencia.pontoDeDestaque}</td>
                    <td>${aparencia.inspiracao}</td>
                    <td>${aparencia.descricao}</td>
                    <td><a href="/aparencia/${aparencia.id}/excluir">Excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <button class="btn btn-secondary" onclick="adicionar()">Adicionar +</button>
</div>

<script>
    function adicionar() {
        window.location.href = "/aparencia/cadastro";
    }
</script>
</body>
</html>