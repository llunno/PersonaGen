
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Listagem de usuários</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/usuario" method="get">
        <h3>Listagem de usuários do sistema</h3>

        <c:if test="${not empty mensagemInclusao}">
            <c:if test="${not empty listaUsuarios}">
                <div class="alert alert-success" role="alert">
                    <strong>Sucesso! </strong> ${mensagemInclusao}
                </div>
            </c:if>
        </c:if>

        <button class="btn btn-primary" type="submit">Novo</button>
    </form>

    <c:if test="${empty listaUsuarios}">
        <div class="alert alert-info" role="alert">
            <strong>Atenção! </strong>Não existem usuários cadastrados!
        </div>
    </c:if>

    <c:if test="${not empty listaUsuarios}">
        <h5>Quantidade de usuários cadastrados: ${listaUsuarios.size()}</h5>

        <table class="table table-striped">
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
                    <td>${usuario.id}</td>
                    <td>${usuario.nomeCompleto}</td>
                    <td>${usuario.nickname}</td>
                    <td>${usuario.email}</td>
                    <td><a href="/usuario/${usuario.id}/excluir">Excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>
