<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cadastro de Administradores</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
</head>
<body class="body-register-screen">
<c:import url="/WEB-INF/jsp/menu.jsp"/>
<div class="container-fluid container-register-body">
    <div class="container-fluid container-registers">
        <h2>Cadastro de Administradores</h2>
        <form action="/administrador/incluir" method="post">
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
            <div class="mb-3">
                <label for="cargo" class="form-label">Cargo</label>
                <input name="cargo" type="text" class="form-control" id="cargo" required>
            </div>
            <div class="mb-3">
                <label for="nivelAcesso" class="form-label">Nível de Acesso</label>
                <input name="nivelAcesso" type="text" class="form-control" id="nivelAcesso" required>
            </div>
            <c:import url="/WEB-INF/jsp/endereco/cadastro.jsp"/>
            <button type="submit" class="btn btn-secondary">Enviar</button>
        </form>
    </div>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp"/>

<script src="/js/user-register-validation.js"></script>
</body>
</html>