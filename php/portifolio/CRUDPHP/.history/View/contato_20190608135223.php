<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <title>Cadastro</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet">
    </head>
    <body>
    <?php
        include_once('menu.php');
    ?>
        <div class="jumbotron">
            <div class="container">
                <h2>Contato</h2>                                               
            </div>
        </div>            
        <div class="contact-section">
            <div class="container">                    
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <form class="form-horizontal" action="../Controller/PessoaController.php" method="POST">
                            <div class="form-group">
                                <label for="nome">Nome</label>
                                <input name="nome" type="text" required>                                
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input name="email" type="email" required>
                            </div>
                            <div class="form-group">
                                <label for="mensagem">Mensagem</label>
                                <input name="mensagem" type="text" required>
                            </div> 
                            <?php
                            session_start();

                            if ($_SESSION['autenticado'] == 'false') {
                                echo '<button class="btn btn-primary" disabled>Cadastrar</button>';
                            } else {
                                echo '<button type = "submit" class = "btn btn-primary" name = "cadastrar" id = "cadastrar">Cadastrar</button>';
                            }
                            ?>
                        </form>                
                    </div>
                </div>
            </div>              
        </div>	
        <!-- Fim contatos -->
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

