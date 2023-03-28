<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Utils" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Personagens</title>
    <c:import url="../globalHtmlLinks.jsp"/>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">

  <h3>Listagem de Personagens</h3>

  <c:if test="${not empty mensagemInclusao}">
    <c:if test="${not empty listaPersonagem}">
      <div class="alert alert-success" role="alert">
        <strong>Sucesso! </strong> ${mensagemInclusao}
      </div>
    </c:if>
  </c:if>

  <c:if test="${empty listaPersonagem}">
    <div class="alert alert-info" role="alert">
      <strong>Atenção! </strong>Não existem pedidos cadastrados!
    </div>
  </c:if>

  <c:if test="${not empty listaPersonagem}">
    <h5>Quantidade de pedidos cadastrados: ${listaPersonagem.size()}</h5>

    <table class="table table-striped">
      <thead>
      <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Idade</th>
        <th>Espécie</th>
        <th>Gênero</th>
        <th>Características</th>
        <th>História</th>
        <th>Criador</th>
        <th>Data de criação</th>
        <th></th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="personagem" items="${listaPersonagem}">
        <c:set var="caracteristicasConcat" value="${Utils.concatenarExibicaoLista(personagem.caracteristicas)}"/>
        <tr>
          <td>${personagem.id}</td>
          <td>${personagem.nome}</td>
          <td>${personagem.idade}</td>
          <td>${personagem.especie}</td>
          <td>${personagem.genero}</td>
          <td>${caracteristicasConcat}</td>
          <td>${personagem.historia}</td>
          <td>${personagem.criador.nomeCompleto}</td>
          <td>${personagem.formatarData()}</td>
          <td><a href="/personagem/${personagem.id}/excluir" class="excluir-item-link">Excluir</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:if>
  <button class="btn btn-secondary" onclick="adicionar()">Adicionar +</button>
</div>

<script>
  function adicionar() {
    window.location.href = "/personagem/cadastro";
  }
</script>
</body>
</html>
