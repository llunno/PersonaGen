<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Listagem de personagens</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">

  <h3>Listagem de Personagens</h3>

  <c:if test="${not empty mensagemInclusao}">
    <c:if test="${not empty listaCriadores}">
      <div class="alert alert-success" role="alert">
        <strong>Sucesso! </strong> ${mensagemInclusao}
      </div>
    </c:if>
  </c:if>

  <c:if test="${empty listaCriadores}">
    <div class="alert alert-info" role="alert">
      <strong>Atenção! </strong>Não existem usuários cadastrados!
    </div>
  </c:if>

  <c:if test="${not empty listaCriadores}">
    <h5>Quantidade de usuários cadastrados: ${listaCriadores.size()}</h5>

    <table class="table table-striped">
      <thead>
      <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Nickname</th>
        <th>Email</th>
        <th>Idade</th>
        <th>Interesses</th>
        <th></th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="criador" items="${listaCriadores}">
        <tr>
          <td>${criador.id}</td>
          <td>${criador.nomeCompleto}</td>
          <td>${criador.nickname}</td>
          <td>${criador.email}</td>
          <td>${criador.idade}</td>
          <td>${criador.interesses}</td>
          <td><a href="/criador/${criador.id}/excluir">Excluir</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:if>
  <button class="btn btn-secondary" onclick="adicionar()">Adicionar +</button>
</div>

<script>
  function adicionar() {
    window.location.href = "/criador/cadastro";
  }
</script>
</body>
</html>
