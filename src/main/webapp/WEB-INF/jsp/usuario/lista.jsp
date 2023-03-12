
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Listagem de usuários</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
</head>
<body>

<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container-fluid container-body">

    <h3>Listagem de usuários do sistema</h3>

    <c:if test="${not empty mensagemInclusao}">
        <c:if test="${not empty listaUsuarios}">
            <div class="alert alert-success" role="alert">
                <strong>Sucesso! </strong> ${mensagemInclusao}
            </div>
        </c:if>
    </c:if>

    <c:if test="${empty listaUsuarios}">
        <div class="alert alert-info" role="alert">
            <strong>Atenção! </strong>Não existem usuários cadastrados!
        </div>
    </c:if>

    <c:if test="${not empty listaUsuarios}">
        <h5>Quantidade de usuários cadastrados: ${listaUsuarios.size()}</h5>

    <section class="overflow-auto mx-2" id="table-wrapper">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Nickname</th>
                    <th>Email</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="usuario" items="${listaUsuarios}">
                <tr>
                    <td class="td-id">
                        <p class="id-cell">${usuario.id}</p>
                    </td>
                    <td>
                        <p>${usuario.nomeCompleto}</p>
                    </td>
                    <td>
                        <p>${usuario.nickname}</p>
                    </td>
                    <td>
                        <p>${usuario.email}</p>
                    </td>
                    <td><a href="/usuario/${usuario.id}/excluir" class="excluir-item-link">Excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
        <button class="btn btn-secondary btn-adicionar-item" onclick="adicionar()">Adicionar +</button>
    </c:if>
</div>

<script>
    function adicionar() {
        window.location.href = "/usuario/cadastro";
    }
</script>
</body>
</html>
