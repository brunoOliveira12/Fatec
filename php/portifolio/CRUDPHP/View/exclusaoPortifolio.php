<?php
 if(!isset($_SESSION)){
    session_start();
  }
?>
<?php

function __autoload($class) {
    require_once '../Model/' . $class . '.php';
}

$id_portifolio = $_GET['id_portifolio'];
$port = new Portifolio();
$resultado = $port->find($id_portifolio);
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
                <h2>Edição de portifolio</h2>                                               
            </div>
        </div>            
        <div class="contact-section">
            <div class="container">                    
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <form class="form-horizontal" action="../Controller/PortifolioController.php" method="POST">
                        <div class="form-group">
                                <label for="id_portifolio">Id Portifolio</label>
                                <input name="id_portifolio" id="id_portifolio" value="<?php echo $resultado->id_portifolio; ?>" type="text" required readonly="true">                                
                        </div>
                            <div class="form-group">
                                <label for="nome_disciplina">Disciplina</label>
                                <input name="nome_disciplina" value="<?php echo $resultado->nome_disciplina; ?>" type="text" required readonly="true">                                
                            </div>
                            <div class="form-group">
                                <label for="grade_disciplina">Grade</label>
                                <input name="grade_disciplina" value="<?php echo $resultado->grade_disciplina; ?>" type="text" required readonly="true">                                
                            </div>
                            <div class="form-group">
                                <label for="nome_professor">Professor</label>
                                <input name="nome_professor" value="<?php echo $resultado->nome_professor; ?>" type="text" required readonly="true">                                
                            </div>                         
                            </div>                            
                            <div class = "col-sm-8 col-md-2">
                            <div class = "thumbnail">
                                <img src ="<?=$resultado->caminhoarquivo?>">
                            </div>
                            </div>
                            </div>
                            <?php               
                            if ($_SESSION['autenticado'] == 'false') {
                                echo '<button class="btn btn-primary" disabled>Deletar</button>';
                            } else {
                                echo '<button type="submit" class="btn btn-primary" name="deletar" id="deletar">Deletar</button>';
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
