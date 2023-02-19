<%--
  Created by IntelliJ IDEA.
  User: Lucas
  Date: 13/02/2023
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listagem de usuários</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/usuario" method="get">
        <h3>Listagem de usuários do sistema</h3>
        <button class="btn btn-primary" type="submit">Novo</button>
    </form>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>Nome</th>
                <th>Nickname</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Carlos</td>
                <td>Carlin06</td>
                <td>carlin06@gmail.com</td>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>
