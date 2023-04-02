<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "br.edu.infnet.gerenciadorpersonagens.model.domain.Administrador, br.edu.infnet.gerenciadorpersonagens.model.domain.Usuario"%>

<nav class="navbar navbar-dark bg-dark navbar-expand-lg jus mb-4 sticky-top nav-entitys-menu" data-bs-theme="dark">
    <div class="container-fluid d-flex justify-content-between">
        <div class="d-flex justify-content-between">
            <a class="navbar-brand text-bg-dark" href="${pageContext.request.contextPath}/">PersonaGen</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <c:if test="${not empty usuario}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Personagem
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/personagem/lista">Listagem</a></li>
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/personagem/cadastro">Cadastro</a></li>
                            </ul>
                        </li>
                        <!--<a class="nav-link" href="${pageContext.request.contextPath}/personagem/lista">Personagem</a>-->
                        <%
                            if (session.getAttribute("usuario") instanceof Administrador){%>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Administrador
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/administrador/lista">Listagem</a></li>
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/administrador/cadastro">Cadastro</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Criador
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/criador/lista">Listagem</a></li>
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/criador/cadastro">Cadastro</a></li>
                            </ul>
                        </li>
                        <%}%>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Personalidade
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/personalidade/lista">Listagem</a></li>
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/personalidade/cadastro">Cadastro</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Aparência
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/aparencia/lista">Listagem</a></li>
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/aparencia/cadastro">Cadastro</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Habilidade
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/habilidade/lista">Listagem</a></li>
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/habilidade/cadastro">Cadastro</a></li>
                            </ul>
                        </li>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="d-flex justify-content-between gap-2">
            <c:if test="${empty usuario}">
                <button onclick="signIn()" class="btn btn-light btn-navbar">
                    <i class="fas fa-sign-in"></i> Login
                </button>
                <button onclick="signUp()" class="btn btn-light btn-navbar">
                    <i class="fas fa-user-plus"></i> Cadastrar-se
                </button>
            </c:if>
            <c:if test="${not empty usuario}">
                <button onclick="signOut()" class="btn btn-light btn-navbar">
                    <i class="fa fa-sign-out"></i> Sair, ${usuario.nomeCompleto}
                </button>
            </c:if>
        </div>
    </div>
</nav>

<script>
    function signIn() {
        window.location.href = "/login";
    }
    function signOut() {
        location.reload();
        window.location.href = "/logout";
    }
    function signUp() {
        window.location.href  = "/usuario/cadastro";
    }
</script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/js/bootstrap.bundle.min.js"></script>