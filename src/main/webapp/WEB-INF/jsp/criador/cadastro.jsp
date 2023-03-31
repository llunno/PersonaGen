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
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="/scss/sb-admin-2.css" rel="stylesheet">
</head>

<body class="bg-gradient-dark" class="body-custom-style">
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
                                            placeholder="Nome Completo" required>
                                    </div>
                                    <div class="col-sm-6">
                                        <input name="nickname" type="text" class="form-control form-control-user" id="nickname"
                                            placeholder="Nickname" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input name="email" type="email" class="form-control form-control-user" id="email"
                                        placeholder="Email" required>
                                </div>
                                <div class="form-group">
                                    <input name="idade" type="number" class="form-control form-control-user" id="idade"
                                           placeholder="Idade" required>
                                </div>
                                <div class="form-group">
                                    <textarea name="interesses" name="idade" type="text" class="form-control form-control-user" id="interesses"
                                           placeholder="Insira aqui seus interesses criativos! Separe cada interesse por vírgula." required></textarea>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input name="senha" type="password" class="form-control form-control-user"
                                            id="exampleInputPassword" placeholder="Senha" required>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="senha" class="form-control form-control-user"
                                            id="exampleRepeatPassword" placeholder="Repita a senha" required>
                                    </div>
                                </div>
                                <button type="submit" href="login.html" class="btn btn-primary btn-user btn-block">
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

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>
</body>
</html>