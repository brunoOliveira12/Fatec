<?php
 if(!isset($_SESSION)){
    session_start();
  }
?>
<?php

function __autoload($class) {
    require_once '../Model/' . $class . '.php';
}

$id_produto = $_GET['id_produto'];
$port = new Produto();
$resultado = $port->find($id_produto);
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
        <title>Edição</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet">
    </head>
    <body>        
    <?php
        include_once('menu.php');
    ?>
        <div class="jumbotron">
            <div class="container">
                <h2>Edição de Produto</h2>                                               
            </div>
        </div>            
        <div class="contact-section">
            <div class="container">                    
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <form class="form-horizontal" action="../Controller/ProdutoController.php" method="POST" enctype="multipart/form-data">
                        <div class="form-group">
                                <label for="id_produto">Id Produto</label>
                                <input name="id_produto" id="id_produto" value="<?php echo $resultado->id_produto; ?>" type="text" required readonly="true">                                
                        </div>
                            <div class="form-group">
                                <label for="nome_produto">Nome do produto</label>
                                <input name="nome_produto" value="<?php echo $resultado->nome_produto; ?>" type="text" required>                                
                            </div>
                            <div class="form-group">
                                <label for="valor_produto">Valor</label>
                                <input name="valor_produto" value="<?php echo $resultado->valor_produto; ?>" type="number" required>                                
                            </div>
                            <div class="form-group">
                                <label for="nome_vendedor">Vendedor</label>
                                <input name="nome_vendedor" value="<?php echo $resultado->nome_vendedor; ?>" type="text" required>                                
                            </div>
                            <div class = "col-sm-6 col-md-8">
                            <div class="form-group">
                                <label for="caminho_arquivo">Anexo</label>
                                <input type="file" name="file_upload" accept="image/png, image/jpeg, document/pdf">                                
                            </div>
                            </div>                            
                            <div class = "col-sm-6 col-md-4">
                            <div class = "thumbnail">
                                <img src ="<?=$resultado->caminho_arquivo?>">
                            </div>
                            </div>                            
                            </div>
                            </div>
                            <?php               
                            if ($_SESSION['autenticado'] == 'false') {
                                echo '<button class="btn btn-primary" disabled>Alterar</button>';
                            } else {
                                echo  '<div class = "col-sm-6 col-md-2">';                              
                                echo '</div>';
                                echo '<button type="submit" class="btn btn-primary" name="alterar" id="alterar">Alterar</button>';
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
