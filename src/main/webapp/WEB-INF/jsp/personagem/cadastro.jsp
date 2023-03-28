<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Cadastro de Personagens</title>
  <c:import url="/WEB-INF/jsp/globalHtmlLinks.jsp"/>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>
<div class="container my-5 mx-5">
  <h1>Cadastro de Seres</h1>
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
    <div class="form-group mb-3">
      <label for="historia">História:</label>
      <textarea class="form-control" id="historia" name="historia" rows="3" required></textarea>
    </div>
    <button type="submit" class="btn btn-primary">Enviar</button>
  </form>
</div>

<script type="text/javascript">
  const isHumanElement = document.querySelector('#isHuman');
  const especieElement = document.querySelector('#especie');

  isHumanElement.addEventListener('change', function () {
    if (isHumanElement.value === 'true') {
      especieElement.value = 'Humano';
      especieElement.readOnly = true;
    } else {
      especieElement.value = '';
      especieElement.readOnly = false;
    }
  });
</script>

</body>
</html>
