<?php
function __autoload($class){
    require_once '../Model/' . $class . '.php';
}

$port = new Produto();

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
        <title>Listar Produto</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet">
    </head>
    <body>
    <?php
        include_once('menu.php');
    ?>
        <!-- Fixed navbar -->        
        <!-- Apresentação e portquisa -->	
        <div class="jumbotron">
            <div class="container">
                <h1>Listar Produto</h1>
                <p>Mensagem de Boas Vindas sobre os Produtos</p>               
                <form role = "form" class="form-inline" name="listarProduto" action="ListarProduto" method="POST">                     
                    <hr>
                </form>                
            </div>
        </div><!-- Fim apresentação e portquisa -->	      
        <div class = "row">
            <?php foreach ($port->findAll()as $key => $value) { ?>
                <!-- div para um produto -->
                <div class = "col-sm-6 col-md-3">
                <?php 
                    if($value->caminho_arquivo != ""){                        
                        echo "<div class='thumbnail'>";                                        
                        echo "<embed src=\"{$value->caminho_arquivo}\">'";                    
                        echo '</div>';
                    }
                ?>             
                    <div class = "caption">
                        <p> Nome produto: <?php echo $value->nome_produto; ?></p>
                        <p> Nome vendedor: <?php echo $value->nome_vendedor; ?></p>
                        <p> Valor: <?php echo $value->valor_produto; ?></p>                                                                        
                        <?php echo "<a href='edicaoProduto.php?id_produto=" . $value->id_produto . "'>Editar</a>"; ?>
                        <?php echo "<a href='exclusaoProduto.php?id_produto=" . $value->id_produto . "'>Deletar</a>"; ?>                        
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

