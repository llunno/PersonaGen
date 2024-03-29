<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cadastro de Criador</title>
    <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="/scss/sb-admin-2.css" rel="stylesheet">
</head>

<body class="bg-gradient-dark body-custom-style-register-user">
    <div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Crie uma Conta!</h1>
                            </div>
                            <form class="user" action="/criador/incluir" method="post">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input name="nomeCompleto" type="text" class="form-control form-control-user" id="NomeCompleto"
                                            placeholder="Nome Completo" required value="Carlos da Silva Coelho">
                                    </div>
                                    <div class="col-sm-6">
                                        <input name="nickname" type="text" class="form-control form-control-user" id="nickname"
                                            placeholder="Nickname" required value="carl_silva">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input name="email" type="email" class="form-control form-control-user" id="email"
                                        placeholder="Email" required value="carlos.silva@gmail.com">
                                </div>
                                <div class="form-group">
                                    <input name="idade" type="number" class="form-control form-control-user" id="idade"
                                           placeholder="Idade" required value="32">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="cep" id="cep" placeholder="Insira o CEP" required onchange="consultarCEP()">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="logradouro" id="logradouro" placeholder="logradouro" required>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="numero" id="numero" placeholder="número" required>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="bairro" id="bairro" placeholder="bairro" required>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="localidade" id="cidade" placeholder="cidade" readonly required>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="uf" id="estado" placeholder="estado" readonly required>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="complemento" id="complemento" placeholder="complemento">
                                </div>
                                <div class="form-group">
                                    <textarea name="interesses" type="text" class="form-control form-control-user" id="interesses"
                                              placeholder="Insira aqui seus interesses criativos! Separe cada interesse por vírgula." required
                                    >Paisagismo, Artes Futurísticas, Jogos Eletrônicos, RPG, Livros de Fantasia</textarea>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input name="senha" type="password" class="form-control form-control-user"
                                            id="senhaInput" placeholder="Senha" required>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            id="senhaRepeat" placeholder="Repita a senha" onkeyup="checkPassword()" required>
                                    </div>
                                </div>
                                <button type="submit" href="login.html" class="btn btn-primary btn-user btn-block" id="btnSubmit">
                                    Registrar
                                </button>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="/">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="/login">Já tem uma conta? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="/js/user-register-validation.js"></script>

    <!-- Bootstrap core JavaScript-->
    <script src="/vendor/jquery/jquery.min.js"></script>
    <script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="/js/sb-admin-2.min.js"></script>
</body>
</html>