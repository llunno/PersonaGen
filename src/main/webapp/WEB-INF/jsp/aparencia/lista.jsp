<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Listagem de Aparências</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container-fluid container-body">

    <h3>Listagem de Aparências</h3>

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

    <section class="overflow-auto mx-2" id="table-wrapper">
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
                    <td class="td-id">
                        <p class="id-cell">${aparencia.id}</p>
                    </td>
                    <td>
                        <p>${aparencia.altura}</p>
                    </td>
                    <td>
                        <p>${aparencia.peso}</p>
                    </td>
                    <td>
                        <p>${aparencia.biotipo}</p>
                    </td>
                    <td>
                        <p>${aparencia.corPele}</p>
                    </td>
                    <td>
                        <p>${aparencia.corOlhos}</p>
                    </td>
                    <td>
                        <p>${aparencia.corCabelo}</p>
                    </td>
                    <td>
                        <p>${aparencia.tipoCabelo}</p>
                    </td>
                    <td>
                        <p>${aparencia.pontoDeDestaque}</p>
                    </td>
                    <td>
                        <p>${aparencia.inspiracao}</p>
                    </td>
                    <td>
                        <p>${aparencia.descricao}</p>
                    </td>
                    <td><a href="/aparencia/${aparencia.id}/excluir" class="excluir-item-link">Excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
    </c:if>
    <button class="btn btn-secondary btn-adicionar-item" onclick="adicionar()">Adicionar +</button>
</div>

<script>
    function adicionar() {
        window.location.href = "/aparencia/cadastro";
    }
</script>
</body>
</html>