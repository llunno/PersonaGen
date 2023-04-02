<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cadastro de Aparências</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
</head>
<body class="body-register-screen">
<c:import url="/WEB-INF/jsp/menu.jsp"/>
<div class="container-fluid container-register-body">
    <div class="container-fluid container-registers">
        <h2>Cadastro de Aparências</h2>
        <form action="/aparencia/incluir" method="post">
            <div class="mb-3">
                <label for="altura" class="form-label">Altura</label>
                <input name="altura" type="number" class="form-control" value="1.82" id="altura" required>
            </div>
            <div class="mb-3">
                <label for="peso" class="form-label">Peso</label>
                <input name="peso" type="number" class="form-control" value="85" id="peso" required>
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
                <input name="corPele" type="text" class="form-control" value="Branca" id="cor-pele" required>
            </div>
            <div class="mb-3">
                <label for="corOlhos" class="form-label">Cor dos Olhos</label>
                <input name="corOlhos" type="text" class="form-control" value="Pretos" id="corOlhos" required>
            </div>
            <div class="mb-3">
                <label for="corCabelo" class="form-label">Cor do Cabelo</label>
                <input name="corCabelo" type="text" class="form-control" value="Castanho" id="corCabelo" placeholder="Insira 'sem cabelo' para personagens carecas" required>
            </div>
            <div class="mb-3">
                <label for="tipoCabelo" class="form-label">Tipo do Cabelo</label>
                <input name="tipoCabelo" type="text" class="form-control" value="Ondulado com aspecto brilhoso" id="tipoCabelo" required>
            </div>
            <div class="mb-3">
                <label for="ponto-destaque" class="form-label">Ponto de Destaque</label>
                <input name="pontoDeDestaque" type="text" class="form-control" value="Cabelos" id="ponto-destaque" required>
            </div>
            <div class="mb-3">
                <label for="inspiracao" class="form-label">Inspiração</label>
                <input name="inspiracao" type="text" class="form-control" id="inspiracao" value="Aragorn" required>
            </div>
            <div class="mb-3">
                <label for="descricao" class="form-label">Descrição</label>
                <textarea name="descricao" class="form-control" id="descricao" rows="3" placeholder="Insira aqui uma descrição desta aparência" required>Uma aparência muito distinta e marcante, Seus cabelos castanhos eram tão brilhantes que pareciam ter sido banhados pelo sol,e sua textura ondulada dava-lhe um ar descontraído e elegante. Seus olhos eram de um tom de preto escuro e profundo.</textarea>
            </div>
            <button type="submit" class="btn btn-secondary">Enviar</button>
        </form>
    </div>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp"/>

</body>
</html>