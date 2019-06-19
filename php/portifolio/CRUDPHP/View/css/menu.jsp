<%-- 
    Document   : menu
    Created on : 20/06/2018, 13:21:35
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">        
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet">
        <script src="js/ie-emulation-modes-warning.js"></script>
    </head>

    <body>  
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp">Index</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.jsp">Home</a></li>                       
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Opções <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-header">Cadastros</li>
                                <li><a href="cadastrarUsuario.jsp">Usuário</a></li>
                                <li><a href="cadastrarProduto.jsp">Produto</a></li>
                                <li><a href="cadastrarFuncionario.jsp">Funcionário</a></li>
                                <li><a href="cadastrarServico.jsp">Serviço</a></li>
                                <li role="separator" class="divider"></li>
                                <li class="dropdown-header">Listas</li>
                                <li><a href="listarUsuario.jsp">Usuário</a></li>
                                <li><a href="listarProduto.jsp">Produto</a></li>
                                <li><a href="listarFuncionario.jsp">Funcionário</a></li>
                                <li><a href="listarServico.jsp">Serviço</a></li>
                            </ul>
                        </li> <!-- fim dropdown -->
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
    </body>
</html>