<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Utils" %>
<html>
<head>
    <title>Listagem de Criadores</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
</head>
<body class="bg-gradient-light">
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container-fluid container-body-entitys">

    <c:if test="${not empty mensagemInclusao}">
        <c:if test="${not empty listaCriadores}">
            <div class="alert alert-success msg-tela-model fade-list" role="alert">
                <p class="m-0">${mensagemInclusao}</p>
            </div>
        </c:if>
    </c:if>

    <c:if test="${empty listaCriadores}">
        <section class="nothing-to-list">
            <h3 class="text-in-field text-center">Listagem de Criadores</h3>
            <div class="alert alert-info msg-tela-model" role="alert">
                <strong>Atenção! </strong>Não existem Criadores cadastrados!
            </div>
            <button class="btn btn-secondary btn-adicionar-item" onclick="adicionar()">Adicionar +</button>
        </section>
    </c:if>

    <c:if test="${not empty listaCriadores}">
        <h3 class="text-in-field">Listagem de Criadores</h3>
        <section class="text-in-field d-flex flex-wrap gap-1 justify-content-between align-items-center align-content-center">
            <h5>Quantidade de criadores cadastrados: ${listaCriadores.size()}</h5>
            <button class="btn btn-secondary btn-adicionar-item" onclick="adicionar()">Adicionar +</button>
        </section>
        <div class="flat-table-background">
            <section class="table-entity-lists-wrapper" id="table-wrapper">
                <table class="table table-hover">
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
                        <c:set var="interessesConcat" value="${Utils.concatenarExibicaoLista(criador.interesses)}"/>
                        <tr class>
                            <td class="td-id">
                                <p class="id-cell">${criador.id}</p>
                            </td>
                            <td>
                                <p>${criador.nomeCompleto}</p>
                            </td>
                            <td>
                                <p>${criador.nickname}</p>
                            </td>
                            <td>
                                <p>${criador.email}</p>
                            </td>
                            <td>
                                <p>${criador.idade}</p>
                            </td>
                            <td class="long-cel-need">
                                <p>${interessesConcat}</p>
                            </td>
                            <td><a href="/criador/${criador.id}/excluir" class="excluir-item-link">Excluir</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </section>
        </div>
    </c:if>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp"/>

<script src="/js/lists-script.js"></script>
<script>
    function adicionar() {
        window.location.href = "/criador/cadastro";
    }
</script>
</body>
</html>
