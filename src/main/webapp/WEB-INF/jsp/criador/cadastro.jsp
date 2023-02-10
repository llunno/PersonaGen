<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Criador</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>

<!--//TODO INSERIR FORMULÁRIO PARA CADASTRO DE USUÁRIO DEPOIS-->
<body>
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
            <label for="senhaCriador" class="form-label">Senha</label>
            <input name="senhaCriador" type="password" class="form-control" id="senhaCriador" required>
        </div>
        <div class="mb-3">
            <label for="idade" class="form-label">Idade</label>
            <input name="idade" type="text" class="form-control" id="idade" required>
        </div>
        <div class="mb-3">
            <label for="interesses" class="form-label">Interesses Criativos</label>
            <textarea name="interesses" class="form-control" id="interesses" rows="3" placeholder="Insira seus interesses separados por vírgula" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Enviar</button>
    </form>
</div>
</body>
</html>
