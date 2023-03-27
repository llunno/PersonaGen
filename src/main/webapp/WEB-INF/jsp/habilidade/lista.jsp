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

<div class="container-fluid container-body">

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

    <section class="overflow-auto mx-2" id="table-wrapper">
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
                <th>Criador</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="habilidade" items="${listaHabilidades}">
                <tr>
                    <td class="td-id">
                        <p class="id-cell">${habilidade.id}</p>
                    </td>
                    <td>
                        <p>${habilidade.nome}</p>
                    </td>
                    <td>
                        <p>${habilidade.tipo}</p>
                    </td>
                    <td>
                        <p>${habilidade.maestria}</p>
                    </td>
                    <td>
                        <p>${habilidade.pontoDeDestaque}</p>
                    </td>
                    <td>
                        <p>${habilidade.inspiracao}</p>
                    </td>
                    <td>
                        <p>${habilidade.descricao}</p>
                    </td>
                    <td>
                        <p>${habilidade.criador.nomeCompleto}</p>
                    </td>
                    <td><a href="/habilidade/${habilidade.id}/excluir" class="excluir-item-link">Excluir</a></td>
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
        window.location.href = "/habilidade/cadastro";
    }
</script>
</body>
</html>
