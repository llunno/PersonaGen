<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Utils" %>
<html>
<head>
    <title>Listagem de Personagens</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
</head>
<body class="bg-gradient-light">
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container-fluid container-body-entitys">

    <c:if test="${not empty mensagemInclusao}">
        <c:if test="${not empty listaPersonagem}">
            <div class="alert alert-success msg-tela-model text-in-field" role="alert">
                <p class="m-0">${mensagemInclusao}</p>
            </div>
        </c:if>
    </c:if>

    <c:if test="${empty listaPersonagem}">
        <section class="nothing-to-list">
            <h3 class="text-in-field text-center">Listagem de personagens</h3>
            <div class="alert alert-info msg-tela-model" role="alert">
                <strong>Atenção! </strong>Não existem personagens cadastrados!
            </div>
            <button class="btn btn-secondary btn-adicionar-item" onclick="adicionar()">Adicionar +</button>
        </section>
    </c:if>

    <c:if test="${not empty listaPersonagem}">
        <h3 class="text-in-field">Listagem de personagens</h3>
        <section class="text-in-field d-flex flex-wrap gap-1 justify-content-between align-items-center align-content-center">
            <h5>Quantidade de personagens cadastrados: ${listaPersonagem.size()}</h5>
            <button class="btn btn-secondary btn-adicionar-item" onclick="adicionar()">Adicionar +</button>
        </section>
        <div class="flat-table-background">
            <section class="table-entity-lists-wrapper" id="table-wrapper">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Idade</th>
                        <th>Espécie</th>
                        <th>Gênero</th>
                        <th>Características</th>
                        <th>História</th>
                        <th>Criador</th>
                        <th>Data de criação</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="personagem" items="${listaPersonagem}">
                        <c:set var="caracteristicasConcat" value="${Utils.concatenarExibicaoLista(personagem.caracteristicas)}"/>
                        <tr>
                            <td>${personagem.id}</td>
                            <td>${personagem.nome}</td>
                            <td>${personagem.idade}</td>
                            <td>${personagem.especie}</td>
                            <td>${personagem.genero}</td>
                            <td>${caracteristicasConcat}</td>
                            <td>${personagem.historia}</td>
                            <td>${personagem.criador.nomeCompleto}</td>
                            <td>${personagem.formatarData()}</td>
                            <td><a href="/personagem/${personagem.id}/excluir" class="excluir-item-link">Excluir</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </section>
        </div>
    </c:if>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp"/>

<script>
    function adicionar() {
        window.location.href = "/personagem/cadastro";
    }
</script>
</body>
</html>
