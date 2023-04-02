<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Utils" %>
<html>
<head>
    <title>Cadastro de Personagens</title>
    <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/scss/styles-details-screen.css">
</head>
<body class="body-register-screen">
<c:set var="toggleButton" value=""/>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container-fluid container-register-body link deco ali">
    <div class="container-fluid container-registers">
        <section id="header-data-personagem" class="caracteristica-details">
            <h1>${personagem.nome}</h1>
            <hr>
            <div class="content-personagem-wrapper">
                <div class="div-from-section">
                    <h2 class="mb-4 justify-content-start">ID:</h2>
                    <p>${personagem.id}</p>
                </div>
                <div class="div-from-section">
                    <h2>Idade:</h2>
                    <p>${personagem.idade}</p>
                </div>
                <div class="div-from-section">
                    <h2>Gênero:</h2>
                    <p>${personagem.genero}</p>
                </div>
                <div class="div-from-section">
                    <h2>É humano?</h2>
                    <p>${personagem.formatIsHuman()}</p>
                </div>
                <div class="column-div-need div-from-section">
                    <h2>História:</h2>
                    <p>${personagem.historia}</p>
                </div>
            </div>
            <hr>
        </section>
        <section id="personalidade-details" class="caracteristica-details">
            <h2 class="titulo-capitulo">Personalidade</h2>
            <div class="content-personagem-wrapper">
                <div class="div-from-section">
                    <h3 class="mb-4 justify-content-start">ID:</h3>
                    <p>${personalidade.id}</p>
                </div>
                <div class="div-from-section">
                    <h3>Palavra-Definição:</h3>
                    <p>${personalidade.palavraDefinicao}</p>
                </div>
                <div class="div-from-section">
                    <h3>Ponto de Destaque:</h3>
                    <p>${personalidade.pontoDeDestaque}</p>
                </div>
                <div class="div-from-section">
                    <h3>Inspiração:</h3>
                    <p>${personalidade.inspiracao}</p>
                </div>
                <div class="div-from-section">
                    <h3>Expressão:</h3>
                    <p>${personalidade.tipoExpressao}</p>
                </div>
                <div class="div-from-section">
                    <h3>Temparamento:</h3>
                    <p>${personalidade.temperamento}</p>
                </div>
                <div class="div-from-section">
                    <h3>Religião:</h3>
                    <p>${personalidade.religiao}</p>
                </div>
                <div class="column-div-need div-from-section mt-4">
                    <h3>Qualidades:</h3>
                    <p>${Utils.concatenarExibicaoLista(personalidade.qualidades)}</p>
                </div>
                <div class="column-div-need div-from-section">
                    <h3>Defeitos:</h3>
                    <p>${Utils.concatenarExibicaoLista(personalidade.defeitos)}</p>
                </div>
                <div class="column-div-need div-from-section">
                    <h3>Interesses:</h3>
                    <p>${Utils.concatenarExibicaoLista(personalidade.interesses)}</p>
                </div>
                <div class="column-div-need div-from-section">
                    <h3>Desinteresses:</h3>
                    <p>${Utils.concatenarExibicaoLista(personalidade.desinteresses)}</p>
                </div>
                <div class="column-div-need div-from-section">
                    <h3>Descrição:</h3>
                    <p>${personalidade.descricao}</p>
                </div>
            </div>
            <hr>
        </section>
        <section id="aparencia-details" class="caracteristica-details">
            <h2 class="titulo-capitulo">Aparência</h2>
            <div class="content-personagem-wrapper">
                <div class="div-from-section">
                    <h3 class="mb-4 justify-content-start">ID:</h3>
                    <p>${aparencia.id}</p>
                </div>
                <div class="div-from-section">
                    <h3>Ponto de Destaque:</h3>
                    <p>${aparencia.pontoDeDestaque}</p>
                </div>
                <div class="div-from-section">
                    <h3>Inspiração:</h3>
                    <p>${aparencia.inspiracao}</p>
                </div>
                <div class="div-from-section">
                    <h3>Biotipo:</h3>
                    <p>${aparencia.biotipo}</p>
                </div>
                <div class="div-from-section">
                    <h3>Altura:</h3>
                    <p>${aparencia.altura}</p>
                </div>
                <div class="div-from-section">
                    <h3>Peso:</h3>
                    <p>${aparencia.peso}</p>
                </div>
                <div class="div-from-section">
                    <h3>Cor da pele:</h3>
                    <p>${aparencia.corPele}</p>
                </div>
                <div class="div-from-section">
                    <h3>Cor dos olhos:</h3>
                    <p>${aparencia.corOlhos}</p>
                </div>
                <div class="div-from-section">
                    <h3>Cor do Cabelo:</h3>
                    <p>${aparencia.corCabelo}</p>
                </div>
                <div class="div-from-section">
                    <h3>Tipo de Cabelo:</h3>
                    <p>${aparencia.tipoCabelo}</p>
                </div>
                <div class="column-div-need div-from-section">
                    <h3>Descrição:</h3>
                    <p>${aparencia.descricao}</p>
                </div>
            </div>
            <hr>
        </section>
        <section id="habilidade-details-all" class="caracteristica-detail">
            <c:set var="counter" value="1" scope="page"/>
            <h2 class="titulo-capitulo">Habilidades</h2>
            <section id="habilidades-wrapper">
                <c:forEach var="habilidade" items="${listaHabilidades}">
                    <section id="habilidade-details-individual">
                        <h3 class="titulo-capitulo mb-3">Habilidade ${counter}</h3>
                        <div class="content-personagem-wrapper habilidades-content-wrapper">
                            <div class="div-from-section">
                                <h4 class="mb-4 justify-content-start">ID:</h4>
                                <p>${habilidade.id}</p>
                            </div>
                            <div class="div-from-section">
                                <h4>Nome:</h4>
                                <p>${habilidade.nome}</p>
                            </div>
                            <div class="div-from-section">
                                <h4>Tipo:</h4>
                                <p>${habilidade.tipo}</p>
                            </div>
                            <div class="div-from-section">
                                <h4>Inspiração:</h4>
                                <p>${habilidade.inspiracao}</p>
                            </div>
                            <div class="div-from-section">
                                <h4>Maestria:</h4>
                                <p>${habilidade.maestria}</p>
                            </div>
                            <div class="column-div-need div-from-section">
                                <h4>Descrição:</h4>
                                <p>${habilidade.descricao}</p>
                            </div>
                        </div>
                        <hr>
                    </section>
                    <c:set var="counter" value="${counter + 1}" scope="page"/>
                </c:forEach>
            </section>
            <hr>
        </section>
    </div>
</div>
<c:import url="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>