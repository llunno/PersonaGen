<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cadastro de habilidades</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>
<div class="container my-5 mx-5">
    <form action="/habilidade/incluir" method="post">
        <div class="mb-3">
            <label for="nomeInput" class="form-label">Nome Completo</label>
            <input name="nome" type="text" class="form-control" id="nomeInput" required>
        </div>
        <h5 class="my-2">Selecione o tipo de habilidade:</h5>
        <div id="radiogroup-tipo-habilidade">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="tipo" value="Física" id="Física">
                <label class="form-check-label" for="Física">
                    Física
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="tipo" id="Intelectual" value="Intelectual">
                <label class="form-check-label" for="Intelectual">
                    Intelectual
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="tipo" id="Musical" value="Musical">
                <label class="form-check-label" for="Musical">
                    Musical
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="tipo" id="Emocional" value="Emocional">
                <label class="form-check-label" for="Emocional">
                    Emocional
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="tipo" id="Intuitiva" value="Intuitiva">
                <label class="form-check-label" for="Intuitiva">
                    Intuitiva
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="tipo" id="Outros" value="Outros">
                <label class="form-check-label" for="Outros">
                    Outros
                </label>
            </div>
        </div>
        <h5 class="my-2">Selecione o grau de maestria:</h5>
        <div id="radiogroup-maestria-habilidade">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="maestria" id="Pouco Dominio" value="Pouco Domínio">
                <label class="form-check-label" for="Pouco Dominio">
                    Pouco Domínio
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="maestria" id="Domínio Razoavel" value="Domínio Razoável">
                <label class="form-check-label" for="Domínio Razoavel">
                    Domínio razoável
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="maestria" id="Muito Domínio" value="Muito Domínio">
                <label class="form-check-label" for="Muito Domínio">
                    Domínio Completo
                </label>
            </div>
        </div>
        <div class="mb-3">
            <label for="ponto-destaque" class="form-label">Ponto de Destaque</label>
            <input name="pontoDeDestaque" type="text" class="form-control" id="ponto-destaque" required>
        </div>
        <div class="mb-3">
            <label for="inspiracao" class="form-label">Inspiração</label>
            <input name="inspiracao" type="text" class="form-control" id="inspiracao" required>
        </div>
        <div class="mb-3">
            <label for="descricao" class="form-label">Descrição</label>
            <textarea name="descricao" class="form-control" id="descricao" rows="3" placeholder="Insira aqui uma descrição desta habilidade" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Enviar</button>
    </form>
</div>
</body>
</html>
