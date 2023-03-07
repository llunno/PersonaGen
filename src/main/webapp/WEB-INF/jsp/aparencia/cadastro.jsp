<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cadastro de Aparência</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>
<div class="container my-5 mx-5">
    <form action="/aparencia/incluir" method="post">
        <div class="mb-3">
            <label for="altura" class="form-label">Altura</label>
            <input name="altura" type="number" class="form-control" id="altura" required>
        </div>
        <div class="mb-3">
            <label for="peso" class="form-label">Peso</label>
            <input name="peso" type="number" class="form-control" id="peso" required>
        </div>
        <h5 class="my-2">Selecione o biotipo:</h5>
        <div id="radiogroup-biotipo">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="biotipo" value="Endomorfo" id="Endomorfo">
                <label class="form-check-label" for="Endomorfo">
                    Endomorfo
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="biotipo" id="Mesomorfo" value="Mesomorfo">
                <label class="form-check-label" for="Mesomorfo">
                    Mesomorfo
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="biotipo" id="Ectomorfo" value="Ectomorfo">
                <label class="form-check-label" for="Ectomorfo">
                    Ectomorfo
                </label>
            </div>
        </div>
        <div class="mb-3">
            <label for="cor-pele" class="form-label">Cor da Pele</label>
            <input name="corPele" type="text" class="form-control" id="cor-pele" required>
        </div>
        <div class="mb-3">
            <label for="corOlhos" class="form-label">Cor dos Olhos</label>
            <input name="corOlhos" type="text" class="form-control" id="corOlhos" required>
        </div>
        <div class="mb-3">
            <label for="corCabelo" class="form-label">Cor do Cabelo</label>
            <input name="corCabelo" type="text" class="form-control" id="corCabelo" placeholder="Insira 'sem cabelo' para personagens carecas" required>
        </div>
        <div class="mb-3">
            <label for="tipoCabelo" class="form-label">Tipo do Cabelo</label>
            <input name="tipoCabelo" type="text" class="form-control" id="tipoCabelo" required>
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
            <textarea name="descricao" class="form-control" id="descricao" rows="3" placeholder="Insira aqui uma descrição desta aparência" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Enviar</button>
    </form>
</div>
</body>
</html>