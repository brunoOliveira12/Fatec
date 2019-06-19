<?php
session_start();
if ($_SESSION['autenticado'] == null) {
    $_SESSION['autenticado'] = "false";
}
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <title>Empresa</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet">
        <script src="js/ie-emulation-modes-warning.js"></script>

    </head>

    <body>  
    <?php
        include_once('menu.php');
    ?>
        <!-- Carousel
         ================================================== -->
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="first-slide" src="image/2.jpg" alt="First slide">
                    <div class="container">                      
                    </div>
                </div>
                <div class="item">
                    <img class="second-slide" src="image/2.jpg" alt="Second slide">
                    <div class="container">                     
                    </div>
                </div>
                <div class="item">
                    <img class="third-slide" src="image/3.jpg" alt="Third slide">
                    <div class="container">                      
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div><!-- /.carousel -->

        <!-- Inicio da historia da empresa -->     

        <!-- START THE FEATURETTES -->

        <!-- pular linhas <hr class="featurette-divider">-->

        <div class="row featurette">
            <div class="col-md-7">
                <h2 class="featurette-heading">Titulo 1<span class="text-muted"> O que é Lorem Ipsum?</span></h2>
                <p class="lead" align="justify">Lorem Ipsum é simplesmente uma simulação de texto da indústria 
                    tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando 
                    um impressor desconhecido pegou uma bandeja de tipos e os embaralhou 
                    para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só 
                    a cinco séculos, como também ao salto para a editoração eletrônica, 
                    permanecendo essencialmente inalterado. Se popularizou na década de 60, 
                    quando a Letraset lançou decalques contendo passagens de Lorem Ipsum, e 
                    mais recentemente quando passou a ser integrado a softwares de editoração
                    eletrônica como Aldus PageMaker.</p>
            </div>
            <div class="col-md-5">
                <img class="featurette-image img-responsive center-block" src="image/500.png" alt="Generic placeholder image">
            </div>
        </div>

        <div class="row featurette">
            <div class="col-md-7 col-md-push-5">
                <h2 class="featurette-heading">Titulo 2 <span class="text-muted">De onde ele vem?</span></h2>
                <p class="lead" align="justify">Ao contrário do que se acredita, Lorem Ipsum não é simplesmente 
                    um texto randômico. Com mais de 2000 anos, suas raízes podem ser encontradas 
                    em uma obra de literatura latina clássica datada de 45 AC. Richard McClintock, 
                    um professor de latim do Hampden-Sydney College na Virginia, pesquisou uma das 
                    mais obscuras palavras em latim, consectetur, oriunda de uma passagem de Lorem 
                    Ipsum, e, procurando por entre citações da palavra na literatura clássica, 
                    descobriu a sua indubitável origem. Lorem Ipsum vem das seções 1.10.32 e 
                    1.10.33 do "de Finibus Bonorum et Malorum".</p>
            </div>
            <div class="col-md-5 col-md-pull-7">
                <img class="featurette-image img-responsive center-block" src="image/500.png" alt="Generic placeholder image">
            </div>
        </div>

        <div class="row featurette">
            <div class="col-md-7">
                <h2 class="featurette-heading">Titulo 3 : <span class="text-muted"> Porque nós o usamos?</span></h2>
                <p class="lead" align="justify">É um fato conhecido de todos que um leitor se distrairá com o conteúdo de texto legível de 
                    uma página quando estiver examinando sua diagramação. A vantagem de usar Lorem Ipsum é que ele 
                    tem uma distribuição normal de letras, ao contrário de "Conteúdo aqui, conteúdo aqui", fazendo 
                    com que ele tenha uma aparência similar a de um texto legível.</p>
            </div>
            <div class="col-md-5">
                <img class="featurette-image img-responsive center-block" src="image/500.png" alt="Generic placeholder image">
            </div>
        </div>
        <!-- /END THE FEATURETTES -->
    </div><!-- container -->

    <!-- FOOTER -->
    <footer class="container footer">

    </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    <!-- para carousel -->
    <script src="js/vendor/holder.min.js"></script>
</body>
</html>
