
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "br.edu.infnet.gerenciadorpersonagens.model.domain.Administrador, br.edu.infnet.gerenciadorpersonagens.model.domain.Usuario"%>

<nav class="navbar navbar-dark bg-dark navbar-expand-lg jus mb-4 sticky-top" data-bs-theme="dark">
  <div class="container-fluid d-flex justify-content-between">
    <div class="d-flex justify-content-between">
        <a class="navbar-brand text-bg-dark" href="${pageContext.request.contextPath}/">PersonaGen</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <c:if test="${not empty usuario}">
                <a class="nav-link" href="${pageContext.request.contextPath}/personagem/lista">Personagem</a>
                <%
                    if (session.getAttribute("usuario") instanceof Administrador){%>
                        <a class="nav-link" href="${pageContext.request.contextPath}/administrador/lista">Administrador</a>
                        <a class="nav-link" href="${pageContext.request.contextPath}/criador/lista">Criador</a>
                <%}%>
                <a class="nav-link" href="${pageContext.request.contextPath}/personalidade/lista">Personalidade</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/aparencia/lista">Aparência</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/habilidade/lista">Habilidades</a>
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
              <i class="fa fa-sign-out"></i> Sair, ${usuario.email}
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