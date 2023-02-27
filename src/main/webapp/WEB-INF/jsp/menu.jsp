
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar bg-dark navbar-expand-lg" data-bs-theme="dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">PersonaGen</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link" href="/usuario/lista">Usuário</a>
        <a class="nav-link" href="#">Personagem</a>
        <a class="nav-link" href="#">Criador</a>
        <a class="nav-link" href="#">Personalidade</a>
        <a class="nav-link" href="#">Aparência</a>
        <a class="nav-link" href="#">Habilidades</a>
      </div>
      <div class="d-flex justify-content-end gap-2">
        <a href="/usuario" class="link-light">Sign Up</a>
        <a href="/login" class="link-light">Login</a>
      </div>
    </div>
  </div>
</nav>
