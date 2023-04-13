<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Listagem de Aparências</title>
  <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
</head>
<body class="bg-gradient-light">
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container-fluid container-body-entitys">

  <c:if test="${not empty mensagemInclusao}">
    <c:if test="${not empty listaAparencia}">
      <div class="alert alert-success msg-tela-model fade-list" role="alert">
        <p class="m-0">${mensagemInclusao}</p>
      </div>
    </c:if>
  </c:if>

  <c:if test="${empty listaAparencia}">
    <section class="nothing-to-list">
      <h3 class="text-in-field text-center">Listagem de Aparências</h3>
      <div class="alert alert-info msg-tela-model" role="alert">
        <strong>Atenção! </strong>Não existem Aparências cadastradas!
      </div>
      <button class="btn btn-secondary btn-adicionar-item" onclick="adicionar()">Adicionar +</button>
    </section>
  </c:if>

  <c:if test="${not empty listaAparencia}">
    <h3 class="text-in-field">Listagem de Aparências</h3>
    <section class="text-in-field d-flex flex-wrap gap-1 justify-content-between align-items-center align-content-center">
      <h5>Quantidade de aparências cadastrados: ${listaAparencia.size()}</h5>
      <button class="btn btn-secondary btn-adicionar-item" onclick="adicionar()">Adicionar +</button>
    </section>
    <div class="flat-table-background">
      <section class="table-entity-lists-wrapper" id="table-wrapper">
        <table class="table table-hover">
          <thead>
          <tr>
            <th>ID</th>
            <th>Altura</th>
            <th>Peso</th>
            <th>Biotipo</th>
            <th>Cor da pele</th>
            <th>Cor dos Olhos</th>
            <th>Cor do cabelo</th>
            <th>Tipo de cabelo</th>
            <th>Ponto de Destaque</th>
            <th>Inspiração</th>
            <th>Descrição</th>
            <th></th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="aparencia" items="${listaAparencia}">
            <tr>
              <td class="td-id">
                <p class="id-cell">${aparencia.id}</p>
              </td>
              <td>
                <p>${aparencia.altura}</p>
              </td>
              <td>
                <p>${aparencia.peso}</p>
              </td>
              <td>
                <p>${aparencia.biotipo}</p>
              </td>
              <td>
                <p>${aparencia.corPele}</p>
              </td>
              <td>
                <p>${aparencia.corOlhos}</p>
              </td>
              <td>
                <p>${aparencia.corCabelo}</p>
              </td>
              <td>
                <p>${aparencia.tipoCabelo}</p>
              </td>
              <td>
                <p>${aparencia.pontoDeDestaque}</p>
              </td>
              <td>
                <p>${aparencia.inspiracao}</p>
              </td>
              <td class="long-cell-need-details">
                <p>${aparencia.descricao}</p>
              </td>
              <td><a href="/aparencia/${aparencia.id}/excluir" class="excluir-item-link fas fa-trash-can"></a></td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </section>
    </div>
  </c:if>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp"/>

<script src="/js/lists-script.js"></script>
<script>
  function adicionar() {
    window.location.href = "/aparencia/cadastro";
  }
</script>
</body>
</html>