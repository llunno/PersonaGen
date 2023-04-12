<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Listagem de Administradores</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
</head>
<body class="bg-gradient-light">
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container-fluid container-body-entitys">

    <c:if test="${not empty mensagemInclusao}">
        <c:if test="${not empty listaAdministrador}">
            <div class="alert alert-success msg-tela-model fade-list" role="alert">
                <p class="m-0">${mensagemInclusao}</p>
            </div>
        </c:if>
    </c:if>

    <c:if test="${empty listaAdministrador}">
    <section class="nothing-to-list">
        <h3 class="text-in-field text-center">Listagem de administradores</h3>
        <div class="alert alert-info msg-tela-model" role="alert">
            <strong>Atenção! </strong>Não existem administradores cadastrados!
        </div>
        <button class="btn btn-secondary btn-adicionar-item" onclick="adicionar()">Adicionar +</button>
    </section>
    </c:if>

    <c:if test="${not empty listaAdministrador}">
        <h3 class="text-in-field">Listagem de administradores</h3>
        <section class="text-in-field d-flex flex-wrap gap-1 justify-content-between align-items-center align-content-center">
            <h5>Quantidade de usuários cadastrados: ${listaAdministrador.size()}</h5>
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
                        <th>Cargo</th>
                        <th>Nível de acesso</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="administrador" items="${listaAdministrador}">
                        <tr>
                            <td class="td-id">
                                <p class="id-cell">${administrador.id}</p>
                            </td>
                            <td>
                                <p>${administrador.nomeCompleto}</p>
                            </td>
                            <td>
                                <p>${administrador.nickname}</p>
                            </td>
                            <td>
                                <p>${administrador.email}</p>
                            </td>
                            <td>
                                <p>${administrador.cargo}</p>
                            </td>
                            <td>
                                <p>${administrador.nivelAcesso}</p>
                            </td>
                            <td><a href="/administrador/${administrador.id}/excluir" class="excluir-item-link">Excluir</a></td>
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
        window.location.href = "/administrador/cadastro";
    }
</script>
</body>
</html>
