<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.edu.infnet.gerenciadorpersonagens.model.domain.Personalidade" %>
<html>
<head>
    <title>Cadastro de Personagens</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
</head>
<body class="body-register-screen">
<c:import url="/WEB-INF/jsp/menu.jsp"/>
<div class="container-fluid container-register-body">
    <div class="container-fluid container-registers">
        <h2>Cadastro de Personagem</h2>
        <form action="/personagem/incluir" method="post">
            <div class="form-group mb-3">
                <label for="nome">Nome:</label>
                <input type="text" class="form-control" id="nome" name="nome" required>
            </div>
            <div class="form-group mb-3">
                <label for="idade">Idade:</label>
                <input type="number" class="form-control" id="idade" name="idade" required>
            </div>
            <div class="form-group mb-3">
                <label for="isHuman">É humano?</label>
                <select class="form-control" id="isHuman" name="isHuman">
                    <option value="true">Sim</option>
                    <option value="false" selected>Não</option>
                </select>
            </div>
            <div class="form-group mb-3">
                <label for="especie">Espécie:</label>
                <input type="text" class="form-control" id="especie" name="especie" required>
            </div>
            <div class="form-group mb-3">
                <label for="genero">Gênero:</label>
                <input type="text" class="form-control" id="genero" name="genero" required>
            </div>
            <div id="radio-caracteristicas-personagem">
                <p class="label-box-caracteristicas-personagem">Personalidades:</p>
                <section class="personalidades-wrapper">
                    <c:forEach var="personalidade" items="${listaPersonalidades}">
                        <div class="form-check ml-2 form-caracteristicas-personagens">
                            <input class="form-check-input checkbox-radiotype-personalidade" type="checkbox" name="caracteristicas" id="${personalidade.id}" value="${personalidade.id}">
                            <label class="form-check-label" for="${personalidade.id}">
                                    ${personalidade.formatTelaCadastroPersonagem()}
                            </label>
                        </div>
                    </c:forEach>
                </section>
            </div>
            <div class="radio-caracteristicas-personagem">
                <p class="label-box-caracteristicas-personagem">Habilidades:</p>
                <c:forEach var="habilidade" items="${listaHabilidades}">
                    <div class="form-check ms-1 form-caracteristicas-personagens">
                        <input class="form-check-input" type="checkbox" name="caracteristicas" id="${habilidade.id}" value="${habilidade.id}">
                        <label class="form-check-label" for="${habilidade.id}">
                                ${habilidade.formatTelaCadastroPersonagem()}
                        </label>
                    </div>
                </c:forEach>
            </div>
            <div class="radio-caracteristicas-personagem">
                <p class="label-box-caracteristicas-personagem">Aparência:</p>
                <c:forEach var="aparencia" items="${listaAparencias}">
                    <div class="form-check ms-1 form-caracteristicas-personagens">
                        <input class="form-check-input checkbox-radiotype-aparencia" type="checkbox" name="caracteristicas" id="${aparencia.id}" value="${aparencia.id}">
                        <label class="form-check-label" for="${aparencia.id}">
                                ${aparencia.formatTelaCadastroPersonagem()}
                        </label>
                    </div>
                </c:forEach>
            </div>
            <div class="form-group mb-2">
                <label for="historia">História:</label>
                <textarea class="form-control" id="historia" name="historia" rows="3" required></textarea>
            </div>
            <button type="submit" class="btn btn-secondary">Enviar</button>
        </form>
    </div>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp"/>

<script type="text/javascript" src="/js/script-register-personagem.js"></script>

</body>
</html>
