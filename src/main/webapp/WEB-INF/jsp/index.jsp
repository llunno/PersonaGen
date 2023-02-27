<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>
        Gerenciador de Personagens
    </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>
    <div class="container mx-2 my-2">
        <h1>Gerenciador de Personagens</h1>
        <p>Clique <a href="/usuario/lista">aqui</a> para ir para o cadastro de usuários</p>
    </div>
</body>
</html>