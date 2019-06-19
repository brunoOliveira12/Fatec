<%-- 
    Document   : cadastrarUsuario
    Created on : 20/06/2018, 13:16:54
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
    Document   : login
    Created on : 20/06/2018, 13:04:51
    Author     : Fernando
--%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <title>CadastrarUsuario</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet">
    </head>
    <body>
        <!-- Fixed navbar -->
        <%@ include file="menu.jsp" %>
        <div class="jumbotron">
            <div class="container">
                <h2>Cadastro de Usuário</h2>                                               
            </div>
        </div>
        <div class="contact-section">
            <div class="container">                   
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <form class="form-horizontal" name="cadastrarusuario" action="CadastrarUsuario" method="POST">                           
                            <div class="form-group">
                                <label for="nomeUsuario">Nome</label>
                                <input type="text" class="form-control" id="nomeUsuario" name="nomeUsuario" placeholder="nomeUsuario" required>
                            </div>
                            <div class="form-group">
                                <label for="emailuUsuario">Email</label>
                                <input type="email" class="form-control" id="emailUsuario" name="emailUsuario" placeholder="digite o email" required>
                            </div>                                
                            <div class="form-group">
                                <label for="imagemUsuario">Imagem</label>
                                <select class="form-control" id="imagemUsuario" name="imagemUsuario">                                    
                                    <option value="500.png">Padrao</option>
                                    <option value="usuario1.png">Usuario1</option>                                    
                                    <option value="usuario2.png">Usuario2</option>
                                </select>
                            </div>
                            <hr>
                            <p>Ações</p>                   
                            <button type="submit" class="btn btn-primary" name="cadastrar" id="cadastrar">Cadastrar</button>                            
                        </form>                        
                    </div>
                </div>
            </div>
        </div>    
        <!-- FOOTER -->
        <footer class="footer">
            <div class="container">
                <p class="text-muted pull-left">&copy; Bruno Oliveira</p>
                <p class="text-muted pull-right"><a href="#">Voltar ao Topo</a></p>
            </div>
        </footer>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery.min.js"><\/script>')</script>
        <script src="js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>
