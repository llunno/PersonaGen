<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Usuário</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
    <h2 class="m-2">Cadastre-se para obter acesso ao sistema:</h2>
    <div class="container my-5 mx-5">
        <form action="/usuario/incluir" method="post">
            <div class="mb-3">
                <label for="nomeInput" class="form-label">Nome Completo</label>
                <input name="nomeCompleto" type="text" class="form-control" id="nomeInput" required>
            </div>
            <div class="mb-3">
                <label for="nickname" class="form-label">Nickname</label>
                <input name="nickname" type="text" class="form-control" id="nickname" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input name="email" type="text" class="form-control" id="email" required>
            </div>
            <div class="mb-3">
                <label for="senha" class="form-label">Senha</label>
                <input name="senha" type="password" class="form-control" id="senha" required>
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </div>
</body>
</html>
