<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.edu.infnet.gerenciadorpersonagens.model.domain.Personalidade" %>
<html>
<head>
    <title>Cadastro de Personagens</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
</head>
<body class="body-register-screen">
<c:set var="toggleButton" value=""/>
<c:import url="/WEB-INF/jsp/menu.jsp"/>
<%--<c:set var="listaPersonalidades" value="${requestScope['listaPersonalidades']}" />--%>
<div class="container-fluid container-register-body">
    <div class="container-fluid container-registers">
        <h2>Cadastro de Personagem</h2>
        <form action="/personagem/incluir" method="post">
            <section class="d-flex justify-content-between align-items-center gap-2">
                <div class="form-group mb-3 flex-grow-1">
                    <label for="nome">Nome:</label>
                    <input type="text" class="form-control" id="nome" name="nome"  value="Marthos" required>
                </div>
                <div class="form-group mb-3">
                    <label for="idade">Idade:</label>
                    <input type="number" class="form-control" id="idade" name="idade" value="45" required>
                </div>
            </section>
            <div class="form-group mb-3">
                <label for="isHuman">É humano?</label>
                <select class="form-control" id="isHuman" name="isHuman">
                    <option value="true">Sim</option>
                    <option value="false" selected>Não</option>
                </select>
            </div>
            <section class="d-flex justify-content-between align-items-center gap-2">
                <div class="form-group mb-3 flex-grow-1">
                    <label for="especie">Espécie:</label>
                    <input type="text" class="form-control" id="especie" name="especie" value="Elfo" required>
                </div>
                <div class="form-group mb-3 flex-grow-1">
                    <label for="genero">Gênero:</label>
                    <input type="text" class="form-control" id="genero" name="genero" value="Masculino" required>
                </div>
            </section>
            <c:if test="${not empty listaPersonalidades}">
                <div class="radio-caracteristicas-personagem">
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
            </c:if>
            <c:if test="${empty listaPersonalidades}">
                <c:set var="toggleButton" value="disabled"/>
                <div class="alert alert-warning">
                    <p>Não existem Personalidades cadastradas! Adicione pelo menos uma para continuar.</p>
                    <a class="link-secondary" href="${pageContext.request.contextPath}/personalidade/cadastro">Ir para o cadastro de personalidades</a>
                </div>
            </c:if>
            <c:if test="${not empty listaHabilidades}">
                <div class="radio-caracteristicas-personagem">
                    <p class="label-box-caracteristicas-personagem">Habilidades:</p>
                    <section class="personalidades-wrapper">
                    <c:forEach var="habilidade" items="${listaHabilidades}">
                        <div class="form-check ms-1 form-caracteristicas-personagens">
                            <input class="form-check-input checkbox-radiotype-habilidade" type="checkbox" name="caracteristicas" id="${habilidade.id}" value="${habilidade.id}">
                            <label class="form-check-label" for="${habilidade.id}">
                                    ${habilidade.formatTelaCadastroPersonagem()}
                            </label>
                        </div>
                    </c:forEach>
                    </section>
                </div>
            </c:if>
            <c:if test="${empty listaHabilidades}">
                <c:set var="toggleButton" value="disabled"/>
                <div class="alert alert-warning">
                    <p>Não existem Habilidades cadastradas! Adicione pelo menos uma para continuar.</p>
                    <a class="link-secondary" href="${pageContext.request.contextPath}/habilidade/cadastro">Ir para o cadastro de habilidades</a>
                </div>
            </c:if>
            <c:if test="${not empty listaAparencias}">
                <div class="radio-caracteristicas-personagem">
                    <p class="label-box-caracteristicas-personagem">Aparência:</p>
                    <section class="personalidades-wrapper">
                    <c:forEach var="aparencia" items="${listaAparencias}">
                        <div class="form-check ms-1  form-caracteristicas-personagens">
                            <input class="form-check-input checkbox-radiotype-aparencia" type="checkbox" name="caracteristicas" id="${aparencia.id}" value="${aparencia.id}">
                            <label class="form-check-label" for="${aparencia.id}">
                                    ${aparencia.formatTelaCadastroPersonagem()}
                            </label>
                        </div>
                    </c:forEach>
                    </section>
                </div>
            </c:if>
            <c:if test="${empty listaAparencias}">
                <c:set var="toggleButton" value="disabled"/>
                <div class="alert alert-warning">
                    <p>Não existem Aparências cadastradas! Adicione pelo menos uma para continuar.</p>
                    <a class="link-secondary" href="${pageContext.request.contextPath}/aparencia/cadastro">Ir para o cadastro de aparências</a>
                </div>
            </c:if>
            <div class="form-group mb-2">
                <label for="historia">História:</label>
                <textarea class="form-control mb-2" id="historia" name="historia" rows="5" required>Marthos era um elfo da floresta que passou sua vida inteira protegendo as terras em que nasceu. Desde jovem, ele foi treinado pelos melhores guerreiros da tribo, desenvolvendo habilidades incríveis com o arco e a espada.</textarea>
            </div>
            <button ${toggleButton} type="submit" class="btn btn-secondary" id="btn-submit-personagem">Enviar</button>
        </form>
    </div>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp"/>

<script type="text/javascript" src="/js/script-register-personagem.js"></script>

</body>
</html>
