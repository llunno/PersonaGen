<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="form-group mb-3">
    <label for="cep">CEP</label>
    <input type="text" class="form-control" name="cep" id="cep" placeholder="Insira o CEP" required onchange="consultarCEP()">
</div>
<div class="form-group mb-3">
    <label for="logradouro">Logradouro</label>
    <input type="text" class="form-control" name="logradouro" id="logradouro" required>
</div>
<div class="form-group mb-3">
    <label for="numero">Número</label>
    <input type="text" class="form-control" name="numero" id="numero" required>
</div>
<div class="form-group mb-3">
    <label for="bairro">Bairro</label>
    <input type="text" class="form-control" name="bairro" id="bairro" placeholder="Insira o bairro" required>
</div>
<div class="form-group mb-3">
    <label for="cidade">Cidade</label>
    <input type="text" class="form-control" name="localidade" id="cidade" readonly required>
</div>
<div class="form-group mb-3">
    <label for="estado">Estado</label>
    <input type="text" class="form-control" name="uf" id="estado" readonly required>
</div>
<div class="form-group mb-3">
    <label for="complemento">Complemento</label>
    <input type="text" class="form-control" name="complemento" id="complemento" placeholder="Insira o complemento">
</div>
