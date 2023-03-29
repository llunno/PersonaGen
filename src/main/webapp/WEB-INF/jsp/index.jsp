<%@ page import="br.edu.infnet.gerenciadorpersonagens.model.domain.Administrador" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/font-awesome/css/all.min.css" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/scss/sb-admin-2.css" rel="stylesheet">
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gray-900 sidebar sidebar-dark accordion sticky-top h-100 " id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">Persona<sup>Gen</sup></div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <a class="nav-link" href="/">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Ferramentas
        </div>

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-plus"></i>
                <span>Cadastrar novo</span>
            </a>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Cadastrar:</h6>
                    <% if (session.getAttribute("usuario") instanceof Administrador) { %>
                    <a class="collapse-item" href="administrador/cadastro">Administrador</a>
                    <a class="collapse-item" href="criador/cadastro">Criador</a>
                    <%}%>
                    <a class="collapse-item" href="personalidade/cadastro">Personalidade</a>
                    <a class="collapse-item" href="aparencia/cadastro">Aparência</a>
                    <a class="collapse-item" href="habilidade/cadastro">Habilidade</a>
                    <a class="collapse-item" href="personagem/cadastro">Personagem</a>
                </div>
            </div>
        </li>

        <!-- Nav Item - Utilities Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
               aria-expanded="true" aria-controls="collapseUtilities">
                <i class="fas fa-fw fa-search"></i>
                <span>Consultar</span>
            </a>
            <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Consultar:</h6>
                    <% if (session.getAttribute("usuario") instanceof Administrador) { %>
                    <a class="collapse-item" href="administrador/lista">Administradores</a>
                    <a class="collapse-item" href="criador/lista">Criadores</a>
                    <%}%>
                    <a class="collapse-item" href="personalidade/lista">Personalidade</a>
                    <a class="collapse-item" href="aparencia/lista">Aparência</a>
                    <a class="collapse-item" href="habilidade/lista">Habilidade</a>
                    <a class="collapse-item" href="personagem/lista">Personagem</a>
                </div>
            </div>
        </li>

        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-dark bg-gray-900 topbar mb-4 shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                    <div class="input-group">
                        <input type="text" class="form-control bg-light border-0 small" placeholder="Procurar..." aria-label="Search" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-secondary" type="button">
                                <i class="fas fa-search fa-sm"></i>
                            </button>
                        </div>
                    </div>
                </form>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <div class="topbar-divider d-none d-sm-block"></div>

                    <c:if test="${not empty usuario}">
                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-400 small">${usuario.nomeCompleto}</span>
                                <img class="img-profile rounded-circle"
                                     src="img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                 aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Perfil
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Configurações
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Log de Atividades
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>
                    </c:if>
                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">Relatórios</h1>
                    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                            class="fas fa-download fa-sm text-white-50"></i>Gerar Relatório</a>
                </div>

                <!-- Content Row -->
                <div class="row">
                    <div id="dashboard-info-cards" class="col-lg-6">
                        <div class="card-info-item">
                            <div class="card border-left-primary shadow py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                Personagens Cadastrados</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${listaPersonagens.size()}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-person fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-info-item">
                            <div class="card border-left-success shadow py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                Habilidades cadastradas</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${listaHabilidades.size()}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-lightbulb fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-info-item">
                            <div class="card border-left-danger shadow py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-danger text-uppercase mb-1">
                                                Aparências cadastradas</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${listaAparencias.size()}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-face-smile fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-info-item">
                            <div class="card border-left-info shadow py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">
                                                Personalidades cadastradas</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${listaPersonalidades.size()}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-brain fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <% if (session.getAttribute("usuario") instanceof Administrador) {%>
                        <div class="card-info-item">
                            <div class="card border-left-warning shadow py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">Criadores cadastrados
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">${listaCriadores.size()}</div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-user fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card-info-item">
                            <div class="card border-left-brown shadow py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-brown text-uppercase mb-1">
                                                Administradores Cadastrados</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${listaAdministradores.size()}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-user-shield fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <% } %>
                    </div>

                    <!-- Pie Chart -->
                    <div class="col-lg-6 mb-4">
                        <div class="card shadow pb-4">
                            <!-- Card Body -->
                            <div class="card-body">
                                <div class="chart-pie pt-4 pb-2">
                                    <canvas id="myPieChart"></canvas>
                                </div>
                                <div class="mt-4 text-center small">
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-primary"></i> Personagens
                                        </span>
                                    <span class="mr-2">
                                            <i class="fas fa-circle text-success"></i> Habilidades
                                        </span>
                                    <span class="mr-2">
                                            <i class="fas fa-circle text-info"></i> Personalidades
                                        </span>
                                    <span class="mr-2">
                                            <i class="fas fa-circle text-danger"></i> Aparências
                                        </span>
                                    <%if (session.getAttribute("usuario") instanceof Administrador) {%>
                                    <span class="mr-2">
                                                <i class="fas fa-circle" style="color: #fdba3a"></i> Criadores
                                            </span>
                                    <span class="mr-2">
                                                <i class="fas fa-circle" style="color: #5b4545"></i> Administradores
                                            </span>
                                    <% } %>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Content Row -->
                <div class="row">
                    <div class="card-log-container col-lg-12">
                        <div class="card shadow mb-4">
                            <!-- Card Header - Accordion -->
                            <a href="#collapseCardLog" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardLog">
                                <h6 class="m-0 font-weight-bold text-primary">Registro de ações do sistema</h6>
                            </a>
                            <!-- Card Content - Collapse -->
                            <div class="collapse show" id="collapseCardLog">
                                <div class="card-body" id="body-card-log">
                                    This is a collapsable card example using Bootstrap's built in collapse
                                    functionality. Click on the card header to see the card body
                                    collapse and expand! This is a collapsable card example using Bootstrap's built in collapse
                                    functionality. Click on the card header to see the card body
                                    collapse and expand! This is a collapsable card example using Bootstrap's built in collapse
                                    functionality. Click on the card header to see the card body
                                    collapse and expand! This is a collapsable card example using Bootstrap's built in collapse
                                    functionality. Click on the card header to see the card body
                                    collapse and expand! This is a collapsable card example using Bootstrap's built in collapse
                                    functionality. Click on the card header to see the card body
                                    collapse and expand!
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; PersonaGen</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Irá sair? :(</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Confirme se você desejar sair da sessão atual</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <button class="btn btn-primary" onclick="signOut()">Sair</button>
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

<!-- Page level plugins -->
<script src="vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/chart-pie-demo.js"></script>

<script>
    function signOut() {
        window.location.href = "/logout";
    }
</script>

</body>
</html>