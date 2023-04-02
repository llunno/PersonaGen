<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cadastro de Personalidade</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
</head>
<body class="body-register-screen">
<c:import url="/WEB-INF/jsp/menu.jsp"/>
<div class="container-fluid container-register-body">
    <div class="container-fluid container-registers">
        <h2>Cadastro de Personalidade</h2>
        <form action="/personalidade/incluir" method="post">
            <div class="mb-3">
                <label for="palavraDefinicao" class="form-label">Palavra Definição</label>
                <input name="palavraDefinicao" type="text" class="form-control" id="palavraDefinicao"
                       placeholder="Insira aqui uma palavra que defina esta personalidade" value="Disciplina" required>
            </div>
            <p>Selecione o tipo de expressão:</p>
            <div id="radio-tipoexpressao-personalidade">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tipoExpressao" id="Extrovertido" value="Extrovertido">
                    <label class="form-check-label" for="Extrovertido">
                        Extrovertido
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="tipoExpressao" id="Introvertido" value="Introvertido">
                    <label class="form-check-label" for="Introvertido">
                        Introvertido
                    </label>
                </div>
            </div>
            <div class="mb-3">
                <label for="religiao" class="form-label">Religião</label>
                <input name="religiao" type="text" class="form-control" id="religiao"
                       placeholder="Caso não tenha religião, informe 'ateu' ou 'sem religião'" value="Cristão" required>
            </div>
            <div class="mb-3">
                <label for="temperamento" class="form-label">Temperamento</label>
                <input name="temperamento" type="text" class="form-control" id="temperamento" value="Calmo" required>
            </div>
            <div class="mb-3">
                <label for="qualidades" class="form-label">Qualidades</label>
                <textarea name="qualidades" type="text" class="form-control" id="qualidades" rows="3" required>Simpático, Educado, Feliz, Prestativo, Acolhedor</textarea>
            </div>
            <div class="mb-3">
                <label for="defeitos" class="form-label">Defeitos</label>
                <textarea name="defeitos" type="text" class="form-control" id="defeitos" rows="3" required>Impaciente, Impulsivo, Inseguro, Inflexível, Inconstante</textarea>
            </div>
            <div class="mb-3">
                <label for="interesses" class="form-label">Interesses</label>
                <textarea name="interesses" type="text" class="form-control" id="interesses" rows="3" required>Jogos Eletrônicos, Rock, Filmes, Séries, Livros, Viagens</textarea>
            </div>
            <div class="mb-3">
                <label for="desinteresses" class="form-label">Desinteresses</label>
                <textarea name="desinteresses" type="text" class="form-control" id="desinteresses" rows="3" required>Política, Futebol, Famosos, Fofocas</textarea>
            </div>
            <div class="mb-3">
                <label for="ponto-destaque" class="form-label">Ponto de Destaque</label>
                <input name="pontoDeDestaque" type="text" class="form-control" id="ponto-destaque" value="Capacidade de organização e definição de prioridades" required>
            </div>
            <div class="mb-3">
                <label for="inspiracao" class="form-label">Inspiração</label>
                <input name="inspiracao" type="text" class="form-control" id="inspiracao" value="Jesus Cristo" required>
            </div>
            <div class="mb-3">
                <label for="descricao" class="form-label">Descrição</label>
                <textarea name="descricao" class="form-control" id="descricao" rows="3" placeholder="Insira aqui uma descrição desta aparência" required>uma pessoa calma e equilibrada que sempre está em controle de suas emoções,agindo de forma racional e ponderada diante das mais diversas situações.</textarea>
            </div>
            <button type="submit" class="btn btn-secondary">Registrar</button>
        </form>
    </div>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp"/>

</body>
</html>
