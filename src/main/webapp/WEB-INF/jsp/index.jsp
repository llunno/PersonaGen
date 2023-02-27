<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        Gerenciador de Personagens
    </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
    <nav class="navbar bg-dark navbar-expand-lg" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">PersonaGen</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link" href="#">Usuário</a>
                    <a class="nav-link" href="#">Personagem</a>
                    <a class="nav-link" href="#">Criador</a>
                    <a class="nav-link" href="#">Personalidade</a>
                    <a class="nav-link" href="#">Aparência</a>
                    <a class="nav-link" href="#">Habilidades</a>
                </div>
            </div>
        </div>
    </nav>
    <div class="container mx-2 my-2">
        <h1>Gerenciador de Personagens</h1>
        <p>Clique <a href="/usuario/lista">aqui</a> para ir para o cadastro de usuários</p>
    </div>
</body>
</html>