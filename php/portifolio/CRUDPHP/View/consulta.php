<?php
function __autoload($class){
    require_once '../Model/' . $class . '.php';
}

$pes = new Pessoa();

?>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <title>Listar Usuário</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet">
    </head>
    <body>
    <?php
        include_once('menu.php');
    ?>
        <!-- Fixed navbar -->        
        <!-- Apresentação e Pesquisa -->	
        <div class="jumbotron">
            <div class="container">
                <h1>Listar Usuário</h1>
                <p>Mensagem de Boas Vindas sobre os usuarios</p>               
                <form role = "form" class="form-inline" name="listarusuario" action="ListarUsuario" method="POST">                     
                    <hr>
                </form>                
            </div>
        </div><!-- Fim apresentação e Pesquisa -->	      
        <div class = "row">
            <?php foreach ($pes->findAll()as $key => $value) { ?>
                <!-- div para um produto -->
                <div class = "col-sm-6 col-md-3">
                    <div class = "thumbnail">
                        <img src = "image/500.png">
                    </div>
                    <div class = "caption">
                        <h3><?php echo $value->id; ?> - <?php echo $value->nome; ?></h3>
                        <p><?php echo $value->email; ?></p>                                                
                        <?php echo "<a href='edicao.php?id=" . $value->id . "'>Editar</a>"; ?>
                        <?php echo "<a href='exclusao.php?id=" . $value->id . "'>Deletar</a>"; ?>
                    </div>
                </div> <!-- fim div de um produto -->   
            <?php } ?>
        </div>
    </body>
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

