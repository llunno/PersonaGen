<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Utils" %>
<html>
<head>
    <title>Listagem de Personalidades</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
</head>
<body class="bg-gradient-light">
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container-fluid container-body-entitys">

    <c:if test="${not empty mensagemInclusao}">
        <c:if test="${not empty listaPersonalidade}">
            <div class="alert alert-success msg-tela-model" role="alert">
                <p class="m-0">${mensagemInclusao}</p>
            </div>
        </c:if>
    </c:if>

    <c:if test="${empty listaPersonalidade}">
        <section class="nothing-to-list">
            <h3 class="text-in-field text-center">Listagem de Personalidades</h3>
            <div class="alert alert-info msg-tela-model" role="alert">
                <strong>Atenção! </strong>Não existem personalidades cadastradas!
            </div>
            <button class="btn btn-secondary btn-adicionar-item" onclick="adicionar()">Adicionar +</button>
        </section>
    </c:if>

    <c:if test="${not empty listaPersonalidade}">
        <h3 class="text-in-field">Listagem de Personalidades</h3>
        <section class="text-in-field d-flex flex-wrap gap-1 justify-content-between align-items-center align-content-center">
            <h5>Quantidade de personalidades cadastradas: ${listaPersonalidade.size()}</h5>
            <button class="btn btn-secondary btn-adicionar-item" onclick="adicionar()">Adicionar +</button>
        </section>
        <div class="flat-table-background">
            <section class="table-entity-lists-wrapper" id="table-wrapper">
                <table class="table table-hover">
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
                        <c:set var="qualidadesConcat" value="${Utils.concatenarExibicaoLista(personalidade.qualidades)}"/>
                        <c:set var="defeitosConcat" value="${Utils.concatenarExibicaoLista(personalidade.defeitos)}"/>
                        <c:set var="interessesConcat" value="${Utils.concatenarExibicaoLista(personalidade.interesses)}"/>
                        <c:set var="desinteressesConcat" value="${Utils.concatenarExibicaoLista(personalidade.desinteresses)}"/>
                        <tr>
                            <td class="td-id">
                                <p class="id-cell">${personalidade.id}</p>
                            </td>
                            <td>
                                <p>${personalidade.palavraDefinicao}</p>
                            </td>
                            <td>
                                <p>${personalidade.tipoExpressao}</p>
                            </td>
                            <td>
                                <p>${personalidade.religiao}</p>
                            </td>
                            <td>
                                <p>${personalidade.temperamento}</p>
                            </td>
                            <td class="long-cel-need">
                                <p>${qualidadesConcat}</p>
                            </td>
                            <td class="long-cel-need">
                                <p>${defeitosConcat}</p>
                            </td>
                            <td class="long-cel-need">
                                <p>${interessesConcat}</p>
                            </td>
                            <td class="long-cel-need">
                                <p>${desinteressesConcat}</p>
                            </td>
                            <td>
                                <p>${personalidade.pontoDeDestaque}</p>
                            </td>
                            <td>
                                <p>${personalidade.inspiracao}</p>
                            </td>
                            <td class="long-cell-need-details">
                                <p>${personalidade.descricao}</p>
                            </td>
                            <td><a href="/personalidade/${personalidade.id}/excluir" class="excluir-item-link">Excluir</a></td>
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
        window.location.href = "/personalidade/cadastro";
    }
</script>
</body>
</html>
